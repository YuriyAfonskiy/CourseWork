sealed class SmallGoods : Goods() {
    override val eatable: Boolean = false

    class Soap (
        override val weight: Int = 1,
        override val timeToLoad: Int = 1,
        override val name: String = "soaps"
    ) : SmallGoods()

    class Knives (
        override val weight: Int = 3,
        override val timeToLoad: Int = 3,
        override val name: String = "knives"
        ) : SmallGoods()

    class BodySprays (
        override val weight: Int = 2,
        override val timeToLoad: Int = 2,
        override val name: String = "body sprays"
    ) : SmallGoods()
}
