import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val numUnits = scanner.nextInt()
    println(if (numUnits < 1) {
        "no army"
    } else when (numUnits) {
        in 1..4 -> "few"
        in 5..9 -> "several"
        in 10..19 -> "pack"
        in 20..49 -> "lots"
        in 50..99 -> "horde"
        in 100..249 -> "throng"
        in 250..499 -> "swarm"
        in 500..999 -> "zounds"
        else -> "legion"
    })
}