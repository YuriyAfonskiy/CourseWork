import kotlin.random.Random

abstract class Vehicle {
    abstract val name: String
    abstract val capacity: Int
    private var currentLoadWeight: Int = 0
    val loadedGoodsList: MutableList<Goods> = mutableListOf()


    fun fillWithGoods() {
        val x = Random.nextInt(1, 3)
        if (x == 1) {
            while (currentLoadWeight < capacity) {
                loadedGoodsList.add(GoodsGenerator().generateRandomGood())
                currentLoadWeight = countCurrentLoadWeight()
            }
            loadedGoodsList.removeLast()
            currentLoadWeight = countCurrentLoadWeight()
        } else {
            while (currentLoadWeight < capacity) {
                loadedGoodsList.add(GoodsGenerator().generateEatableGood())
                currentLoadWeight = countCurrentLoadWeight()
            }
            loadedGoodsList.removeLast()
            currentLoadWeight = countCurrentLoadWeight()
        }
    }


    private fun countCurrentLoadWeight(): Int {
        var i = loadedGoodsList.lastIndex
        var sumOfWeights = 0
        while (i >= 0) {
            sumOfWeights += loadedGoodsList[i].weight
            i--
        }
        return sumOfWeights
    }


}