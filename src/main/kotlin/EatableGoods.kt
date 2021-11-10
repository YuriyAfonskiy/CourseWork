sealed class EatableGoods : Goods() {
    override val eatable: Boolean = true

    class Bread(
        override val weight: Int = 3,
        override val timeToLoad: Int = 3,
        override val name: String = "bread pcs"
    ) : EatableGoods()

    class Olives(
        override val weight: Int = 5,
        override val timeToLoad: Int = 5,
        override val name: String = "olive cans"
    ) : EatableGoods()

    class Cookies(
        override val weight: Int = 2,
        override val timeToLoad: Int = 2,
        override val name: String = "cookie pcs"
    ) : EatableGoods()

    class Milk(
        override val weight: Int = 6,
        override val timeToLoad: Int = 6,
        override val name: String = "milk pcs"
    ) : EatableGoods()
}
