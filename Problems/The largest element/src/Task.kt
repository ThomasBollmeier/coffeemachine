import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var value = scanner.nextInt()
    var maxValue = Int.MIN_VALUE

    while (value != 0) {
        if (value > maxValue) {
            maxValue = value
        }
        value = scanner.nextInt()
    }

    println(maxValue)
}