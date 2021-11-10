sealed class BigGoods : Goods() {
    override val eatable: Boolean = false

    class Fridges(
        override val weight: Int = 60,
        override val timeToLoad: Int = 100,
        override val name: String = "fridges"
    ) : BigGoods()

    class Dishwashers(
        override val weight: Int = 40,
        override val timeToLoad: Int = 100,
        override val name: String = "dishwashers"
    ) : BigGoods()

    class Cookers(
        override val weight: Int = 50,
        override val timeToLoad: Int = 100,
        override val name: String = "cookers"
    ) : BigGoods()
}
