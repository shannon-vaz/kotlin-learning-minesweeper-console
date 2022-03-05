class EspressoMachine {
    val costPerServing: Float

    companion object {
        const val BEANS_CONSUMED_PER_CUP = 10
    }

    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
        costPerServing = totalCost / coffeeCapsulesCount
    }

    constructor(coffeeBeansWeight: Float, totalCost: Float) {
        val noOfServings = coffeeBeansWeight / BEANS_CONSUMED_PER_CUP
        costPerServing = totalCost / noOfServings
    }
}