fun main() {
    val name = readLine()!!
    if (name == "HIDDEN")
        println(greet())
    else
        println(greet(name))
}

fun greet(name: String = "secret user"): String {
    return "Hello, $name!"
}