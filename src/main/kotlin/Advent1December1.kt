import java.io.File

/**
 * The digits spell out with letters
 * You need to replace the string with a string with a number in the middle
 * It is needed for cases: oneight. sevenine
 * If you store first letter or last(it is not for all cases, because first letter and last letter
 * in four(4) doesn't store letters in other strings
 */
private val mapWithDigitsInStringFormat = mapOf(
    "one" to "o1e",
    "two" to "t2o",
    "three" to "t3e",
    "four" to "4",
    "five" to "5e",
    "six" to "s6",
    "seven" to "s7n",
    "eight" to "e8t",
    "nine" to "n9e"
)

fun main() {
    val file = File("./src/main/kotlin/day1.txt")

    // It is used for reading from file
    val currentListStrings = file.readLines()

    println("Day 1, tasks 1. Sum =  ${part(currentListStrings, false)}")
    println("Day 1, tasks 2. Sum =  ${part(currentListStrings, true)}")
}

private fun part(currentListStrings: List<String>, isNeedReplacing: Boolean): Int {
    var sum = 0
    currentListStrings.forEach { strings ->
        var stringsWithoutDigitsInStringFormat = if (isNeedReplacing) {
            replaceDigitsInStringFormat(strings)
        } else {
            strings
        }

        stringsWithoutDigitsInStringFormat = stringsWithoutDigitsInStringFormat
            .filter { char ->
                char.isDigit()
            }

        val firstDigitInChar: Char = stringsWithoutDigitsInStringFormat.first()
        val lastDigitInChar: Char = stringsWithoutDigitsInStringFormat.last()

        val newDigit = "$firstDigitInChar$lastDigitInChar".toInt()

        sum += newDigit
    }
    return sum
}


/**
 * Replacing digits in string format in new format
 */
private fun replaceDigitsInStringFormat(listWithDigits: String): String {
    var stringsWithoutDigitsInStringFormat = listWithDigits
    for (entry in mapWithDigitsInStringFormat.entries) {
        stringsWithoutDigitsInStringFormat.replace(entry.key, entry.value)
            .also { stringsWithoutDigitsInStringFormat = it }
    }
    return stringsWithoutDigitsInStringFormat
}