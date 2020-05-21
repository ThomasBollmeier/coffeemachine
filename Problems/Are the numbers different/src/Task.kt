import java.util.Scanner

fun main() {
    println(allDistinct(readNumbers()))
}

fun readNumbers() : List<Int> {
    val ret = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextInt()) {
        ret.add(scanner.nextInt())
    }
    return ret
}

fun <T>allDistinct(elements: List<T>) =
        elements.size == elements.toSet().size