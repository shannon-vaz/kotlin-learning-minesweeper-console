fun main() {
    val balance = readLine()!!.toInt()
    val payments = readLine()!!.split(" ").map { it.toInt() }

    var tempBalance = balance
    var pendingPayments = 0
    for (i in payments.indices) {
        if (tempBalance - payments[i] >= 0) {
            tempBalance -= payments[i]
        } else {
            pendingPayments = payments.subList(i, payments.size).sum()
            break
        }
    }
    if (pendingPayments == 0) {
        println("Thank you for choosing us to manage your account! Your balance is $tempBalance.")
    } else {
        println("Error, insufficient funds for the purchase. Your balance is $tempBalance, but you need $pendingPayments.")
    }
}
