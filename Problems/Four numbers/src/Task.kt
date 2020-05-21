import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val numbers = scanner.nextLine().split(Regex("\\s+"))
    for (number in numbers) {
        println(number)
    }
}