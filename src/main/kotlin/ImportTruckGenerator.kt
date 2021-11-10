import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlin.random.Random

object ImportTruckGenerator {

    init {
        println("Start generating trucks")
    }

    fun randomTruckGenerate(): Vehicle {
        val x = Random.nextInt(1, 4)
        val vehicle: Vehicle = if (x == 1) {
            Truck()
        } else {
            if (x == 2) {
                Lorry()
            } else {
                Gazel()
            }
        }
        vehicle.fillWithGoods()
        return vehicle
    }

}

fun CoroutineScope.sendCars(): ReceiveChannel<Vehicle> = produce {
    var car: Vehicle
    var i = 1
    while (i > 0) {
        car = ImportTruckGenerator.randomTruckGenerate()
        send(car)
        delay(5000)
        i++
    }
}