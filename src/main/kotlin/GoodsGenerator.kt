import kotlin.random.Random

class GoodsGenerator {
    private val listOfGoods = mutableListOf(
        SmallGoods.Soap(),
        SmallGoods.BodySprays(),
        SmallGoods.Knives(),
        MiddleGoods.Kettles(),
        MiddleGoods.Pans(),
        MiddleGoods.Microwaves(),
        BigGoods.Fridges(),
        BigGoods.Dishwashers(),
        BigGoods.Cookers()
    )
    private val listOfEatableGoods = mutableListOf(
        EatableGoods.Bread(),
        EatableGoods.Olives(),
        EatableGoods.Cookies(),
        EatableGoods.Milk()
    )

    fun generateRandomGood(): Goods {
        return listOfGoods[Random.nextInt(0, listOfGoods.size)]
    }

    fun generateEatableGood(): Goods {
        return listOfEatableGoods[Random.nextInt(0, listOfEatableGoods.size)]
    }

}