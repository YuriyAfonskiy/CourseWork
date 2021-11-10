import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlin.random.Random

object ExportTruckGenerator {

    fun randomTruckGenerate(): Vehicle {
        val x = Random.nextInt(1, 3)
        return if (x == 1) {
            Lorry()
        } else {
            Gazel()
        }
    }
}

fun CoroutineScope.prepareVehicle(): ReceiveChannel<Vehicle> = produce {
    var car: Vehicle
    var i = 1
    while (i > 0) {
        car = ExportTruckGenerator.randomTruckGenerate()
        send(car)
        delay(100)
        i++
    }
}

