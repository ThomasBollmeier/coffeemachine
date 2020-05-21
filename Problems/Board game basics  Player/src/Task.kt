data class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var nextId = 1
        fun create(name: String) = Player(nextId++, name, 100)
    }
}