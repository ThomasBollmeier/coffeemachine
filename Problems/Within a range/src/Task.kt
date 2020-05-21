import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val low1 = scanner.nextInt()
    val high1 = scanner.nextInt()
    val low2 = scanner.nextInt()
    val high2 = scanner.nextInt()
    val num = scanner.nextInt()

    println(num in low1..high1 || num in low2..high2)
}