fun main() {
    val numbers = readLine()!!.split(' ').map{it.toInt()}.toMutableList()
    // do not touch the lines above
    // write your code here   
    val sum = numbers.reduce{ sum, i -> sum + i }
    numbers.add(0, sum)
    numbers.removeAt(numbers.lastIndex - 1)

    // do not touch the lines below
    println(numbers.joinToString(" "))
}