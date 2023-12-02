val numberStrings = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9"
)

val numbersAndDigits = listOf(
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9"
)

fun main() {

    fun calculateCoordinates(line: String): Int {
        val firstDigit = line.firstOrNull { it.isDigit() } ?: 0
        val lastDigit = line.lastOrNull { it.isDigit() } ?: 0
        return "$firstDigit$lastDigit".toInt()
    }

    fun parseStringNumber(stringNumber: String): String {
        return numberStrings[stringNumber] ?: "0"
    }

    fun parseDigitOrString(input: String): String {
        return if (input.length == 1) {
            input
        } else {
            parseStringNumber(input)
        }
    }

    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            result += calculateCoordinates(line)
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val firstResult = line.findAnyOf(numbersAndDigits)?.second
            val lastResult = line.findLastAnyOf(numbersAndDigits)?.second

            if (firstResult != null && lastResult != null) {
                val first = parseDigitOrString(firstResult)
                val last = parseDigitOrString(lastResult)
                result += "$first$last".toInt()
            }
        }
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11 + 66 + 69 + 91)

    check(part2(testInput) == 51 + 64 + 99 + 98)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
