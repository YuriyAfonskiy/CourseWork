sealed class MiddleGoods : Goods() {
    override val eatable: Boolean = false

    class Microwaves(
        override val weight: Int = 10,
        override val timeToLoad: Int = 5,
        override val name: String = "microwaves"
    ) : MiddleGoods()

    class Pans(
        override val weight: Int = 2,
        override val timeToLoad: Int = 2,
        override val name: String = "pans"
    ) : MiddleGoods()

    class Kettles(
        override val weight: Int = 50,
        override val timeToLoad: Int = 10,
        override val name: String = "kettles"
    ) : MiddleGoods()

}
