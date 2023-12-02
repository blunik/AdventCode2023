import java.io.File

fun main() {
    val file = File("./src/main/kotlin/day2.txt")

    // It is used for reading from file
    val currentListStrings = file.readLines()

    println("Day 2, part 1 - sum = ${part1(currentListStrings)}")
    println("Day 2, part 2 - sum = ${part2(currentListStrings)}")
}

private fun part1(currentStrings: List<String>): Int{
    var sum = 0
    currentStrings
        .map { currentString ->
            val blueCount= currentString.regexColor("blue")
            val redCount = currentString.regexColor("red")
            val greenCount = currentString.regexColor("green")
            if (blueCount <= 14 && redCount <= 12 && greenCount <= 13){
                sum += Regex("\\d+").find(currentString)
                    ?.value?.toInt() ?: 0
            }
        }
    return sum
}

private fun part2(currentStrings: List<String>): Int{
    var sum = 0
    currentStrings
        .map { currentString ->
            val blueCount= currentString.regexColor("blue")
            val redCount = currentString.regexColor("red")
            val greenCount = currentString.regexColor("green")
           sum += blueCount * redCount *greenCount
        }
    return sum
}

private fun String.regexColor(color: String): Int {
    return Regex("\\d+(?= $color)")
        .findAll(this)
        .toList()
        .maxOfOrNull {
            it.value.toInt()
        } ?: 0
}