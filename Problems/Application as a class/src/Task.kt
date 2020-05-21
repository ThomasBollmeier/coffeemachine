class Application(val name: String) {

    fun run(args: Array<String>) {
        println(name)
        for (arg in args) {
            println(arg)
        }
    }
}