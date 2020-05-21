import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var balance = scanner.nextInt()

    while (scanner.hasNextInt()) {
        val amount = scanner.nextInt()
        if (amount <= balance) {
            balance -= amount
        } else {
            println("Error, insufficient funds for the purchase. You have $balance, but you need $amount.")
            return
        }
    }

    println("Thank you for choosing us to manage your account! You have $balance money.")
}