import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val pi = 3.14

    val area = when (scanner.next()) {
        "triangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            val c = scanner.nextDouble()
            val s = 0.5 * (a + b + c)
            sqrt(s * (s - a) * (s - b) * (s - c))
        }
        "rectangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            a * b
        }
        "circle" -> {
            val r = scanner.nextDouble()
            pi * r * r
        }
        else -> return
    }

    println(area)
}