package machine

import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    val machine = CoffeeMachine(
            money = 550,
            water = 400,
            milk = 540,
            beans = 120,
            cups = 9)

    loop@ while (true) {

        println("Write action (buy, fill, take, remaining, exit): > ")

        when (scanner.next()) {
            "buy" -> actionBuy(machine, scanner)
            "fill" -> actionFill(machine, scanner)
            "take" -> actionTake(machine)
            "remaining" -> actionRemaining(machine)
            "exit" -> break@loop
        }

    }

}

fun actionBuy(machine: CoffeeMachine, scanner: Scanner) {

    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ")

    when (val answer = scanner.next()) {
        "back" -> return
        else -> {
            val coffeeCode = answer.toIntOrNull() ?: return
            val coffee = machine.getCoffee(coffeeCode) ?: return
            val (ok, errorMessage) = machine.isAvailable(coffee)
            if (ok) {
                println("I have enough resources, making you a coffee!")
                machine.buy(coffee)
            } else {
                println(errorMessage)
            }
        }
    }

}

fun actionFill(machine: CoffeeMachine, scanner: Scanner) {

    println("Write how many ml of water do you want to add: > ")
    val water = if (scanner.hasNextInt()) scanner.nextInt() else return

    println("Write how many ml of milk do you want to add: > ")
    val milk = if (scanner.hasNextInt()) scanner.nextInt() else return

    println("Write how many grams of coffee beans do you want to add: > ")
    val beans = if (scanner.hasNextInt()) scanner.nextInt() else return

    println("Write how many disposable cups of coffee do you want to add: > ")
    val cups = if (scanner.hasNextInt()) scanner.nextInt() else return

    machine.fill(water, milk, beans, cups)
}

fun actionTake(machine: CoffeeMachine) {
    val money = machine.take()
    println("I gave you \$$money")
}

fun actionRemaining(machine: CoffeeMachine) {
    println("\n" + machine.getInfoString() + "\n")
}

class Coffee(val price: Int,
             val water: Int = 0,
             val milk: Int = 0,
             val beans: Int = 0)

class CoffeeMachine(private var money: Int,
                    private var water: Int,
                    private var milk: Int,
                    private var beans: Int,
                    private var cups: Int) {

    private val coffees : List<Coffee> = listOf(
            Coffee(price = 4, water = 250, beans = 16), // espresso
            Coffee(price = 7, water = 350, milk = 75, beans = 20), // latte
            Coffee(price = 6, water = 200, milk = 100, beans = 12) // cappuccino
    )

    fun getCoffee(coffeeCode: Int) = coffees.getOrNull(coffeeCode - 1)

    fun buy(coffee: Coffee) {
        cups -= 1
        water -= coffee.water
        milk -= coffee.milk
        beans -= coffee.beans
        money += coffee.price
    }

    fun isAvailable(coffee: Coffee) : Pair<Boolean, String> {
        if (cups < 1) return (false to "Sorry, not enough cups!")
        if (water < coffee.water) return (false to "Sorry, not enough water!")
        if (milk < coffee.milk) return (false to "Sorry, not enough milk!")
        if (beans < coffee.beans) return (false to "Sorry, not enough beans!")
        return (true to "")
    }

    fun fill(water: Int, milk: Int, beans: Int, cups: Int) {
        this.water += water
        this.milk += milk
        this.beans += beans
        this.cups += cups
    }

    fun take() : Int {
        val money = this.money
        this.money = 0
        return money
    }

    fun getInfoString() = """The coffee machine has:
        |$water of water
        |$milk of milk
        |$beans of coffee beans
        |$cups of disposable cups
        |$money of money""".trimMargin("|")

}