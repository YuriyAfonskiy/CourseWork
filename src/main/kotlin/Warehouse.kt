import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach

object Warehouse {
    private val importDocks = listOf(Dock(), Dock(), Dock())
    private val exportDocks = listOf(Dock(), Dock(), Dock(), Dock(), Dock())


    val stock = mutableListOf<Goods>()
    private val importQueue = mutableListOf<Vehicle>()

    init {
        println("Creating warehouse")
        try {
            runBlocking {
                launch {
                    prepareVehicle().consumeEach {
                        launch {
                            if (stock.size == 0) {
                                delay(1000)
                            } else {
                                exportDocks.forEach { dock ->
                                    if (!dock.isEmpty) {
                                        delay(1)
                                    } else {
                                        dock.loadVehicle(it, exportDocks.indexOf(dock) + 1)
                                    }
                                }
                            }
                        }
                    }
                }


                launch {
                    sendCars().consumeEach {
                        importQueue.add(it)
                        println("Vehicle queue size = ${importQueue.size}")
                        launch {
                            while (isActive) {
                                if (importQueue.size == 0) {
                                    delay(1)
                                } else {
                                    var x = 0
                                    while (x < importDocks.size) {
                                        if (importQueue.size == 0) {
                                            delay(1)
                                        } else {
                                            if (importDocks[x].isEmpty) {
                                                val vehicleToUnload = importQueue[0]
                                                importQueue.removeAt(0)
                                                stock.addAll(importDocks[x].unloadVehicle(vehicleToUnload, x + 1))
                                                println("Current stock size = ${stock.size} units")
                                            } else {
                                                delay(1)
                                            }
                                            x++
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                delay(180000)
                currentCoroutineContext().job.cancelAndJoin()

            }
        } catch (e: CancellationException) {
            println("Cancelled after 3 minutes.")
        }


    }
}