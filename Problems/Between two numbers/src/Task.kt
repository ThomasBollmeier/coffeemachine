import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val num = scanner.nextInt()
    val low = scanner.nextInt()
    val high = scanner.nextInt()

    println(num in low..high)
}