fun main() {
    val (country1, country2) = readLine()!!.split(" ")
    println(haveSameCurrency(country1, country2))
}

fun haveSameCurrency(c1: String, c2: String): Boolean {
    return CountryCurrency.isKnownCountry(c1) &&
        CountryCurrency.isKnownCountry(c2) &&
        CountryCurrency.valueOf(c1).currency == CountryCurrency.valueOf(c2).currency
}

enum class CountryCurrency(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar");

    companion object {
        private val knownCountries = values().map(CountryCurrency::name).toSet()
        fun isKnownCountry(country: String) = country in knownCountries
    }
}
