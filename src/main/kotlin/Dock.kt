import kotlinx.coroutines.*
import kotlin.random.Random

class Dock {
    var isEmpty = true

    suspend fun unloadVehicle(vehicle: Vehicle, numberOfDock: Int): MutableList<Goods> {
        println("Start unloading ${vehicle.name} in import dock number $numberOfDock")
        isEmpty = false
        var i = vehicle.loadedGoodsList.lastIndex
        val unloadedStock = mutableListOf<Goods>()
        while (i >= 0) {
            delay(vehicle.loadedGoodsList[i].timeToLoad.toLong())
            unloadedStock.add(vehicle.loadedGoodsList[i])
            vehicle.loadedGoodsList.removeAt(i)
            i--
        }
        println("Unloaded ${unloadedStock.size} goods from ${vehicle.name} in import dock number $numberOfDock")
        isEmpty = true
        return unloadedStock
    }

    suspend fun loadVehicle(vehicle: Vehicle, numberOfDock: Int) {
        isEmpty = false
        println("Start loading ${vehicle.name} in export dock number $numberOfDock")
        val loadedGoods = mutableListOf<Goods>()
        var i = 0
        val firstLoaded = Warehouse.stock[Random.nextInt(0, Warehouse.stock.size)]
        loadedGoods.add(firstLoaded)
        var loadedWeight: Int = firstLoaded.weight
        delay(firstLoaded.timeToLoad.toLong())
        while (loadedWeight < vehicle.capacity) {
            if (i >= Warehouse.stock.size) {
                delay(1000)
                i = 1
            } else {
                val loadingGood = Warehouse.stock[i]
                if (loadingGood.javaClass == firstLoaded.javaClass) {
                    if (loadedWeight + loadingGood.weight > vehicle.capacity) {
                        isEmpty = true
                        break
                    } else {
                        loadedGoods.add(loadingGood)
                        Warehouse.stock.remove(loadingGood)
                        i++
                        loadedWeight += loadingGood.weight
                        delay(loadingGood.timeToLoad.toLong())
                    }
                } else {
                    i++
                }
            }
        }
        println(
            "In dock $numberOfDock ${vehicle.name} is loaded with ${loadedGoods.size} ${loadedGoods[0].name}. " +
                    "Weight of goods - $loadedWeight kg"
        )
        isEmpty = true
    }

}