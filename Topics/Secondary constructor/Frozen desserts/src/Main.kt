// write the IceCreamOrder class here
class IceCreamOrder {
    val price: Int
    
    companion object {
        const val PRICE_PER_POPSICLE = 7
        const val PRICE_PER_SCOOP = 5
        const val PRICE_PER_TOPPING = 2
    }
    
    constructor(popsicles: Int) {
        this.price = popsicles * PRICE_PER_POPSICLE
    }
    
    constructor(scoops: Int, toppings: Int) {
        this.price = scoops * PRICE_PER_SCOOP + toppings * PRICE_PER_TOPPING
    }
}
