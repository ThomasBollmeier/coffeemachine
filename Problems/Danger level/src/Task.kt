enum class DangerLevel(private val severity: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = severity
}