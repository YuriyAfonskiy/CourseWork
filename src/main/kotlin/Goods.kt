import kotlin.random.Random

abstract class Goods {
    abstract val eatable: Boolean
    abstract val weight: Int
    abstract val timeToLoad: Int
    abstract val name: String

    fun generateRandomGood():Goods {
        return when (Random.nextInt(1, 9)) {
            1 -> {
                BigGoods.Fridges()
            }
            2 -> {
                BigGoods.Cookers()
            }
            3 -> {
                BigGoods.Dishwashers()
            }
            4 -> {
                MiddleGoods.Kettles()
            }
            5 -> {
                MiddleGoods.Microwaves()
            }
            6 -> {
                MiddleGoods.Pans()
            }
            7 -> {
                SmallGoods.BodySprays()
            }
            8 -> {
                SmallGoods.Knives()
            }
            else -> {
                SmallGoods.Soap()
            }
        }
    }
}