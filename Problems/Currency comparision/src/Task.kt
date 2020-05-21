import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val currencyInfo = createCurrencyInfo()

    val firstCurrency = currencyInfo.get(input.next())
    val secondCurrency = currencyInfo.get(input.next())

    val messageTrue = "true"
    val messageFalse = "false"
    when {
        firstCurrency == null -> println(messageFalse)
        secondCurrency == null -> println(messageFalse)
        else -> println(if (firstCurrency == secondCurrency) {
            messageTrue
        } else {
            messageFalse
        })
    }
}

fun createCurrencyInfo(): Map<String, Currency> {
    val countryCurrencies = mutableMapOf<String, Currency>()
    with(countryCurrencies) {
        put("Germany", Currency.EURO)
        put("Mali", Currency.CFA_FRANC)
        put("Dominica", Currency.EAST_CARIB)
        put("Canada", Currency.CND)
        put("Spain", Currency.EURO)
        put("Australia", Currency.AUD)
        put("Brazil", Currency.BRZ)
        put("Senegal", Currency.CFA_FRANC)
        put("France", Currency.EURO)
        put("Grenada", Currency.EAST_CARIB)
        put("Kiribati", Currency.AUD)
    }
    return countryCurrencies
}

enum class Currency(val description: String) {
    EURO("Euro"),
    CFA_FRANC("CFA franc"),
    EAST_CARIB("Eastern Carribean dollar"),
    CND("Canadian dollar"),
    AUD("Australian dollar"),
    BRZ("Brazilian real")
}