package numerals

import scala.collection.{mutable, SortedMap}

object NumeralConverter {

    val numberToNumeral = mutable.LinkedHashMap(
        1000 -> "M",
        500 -> "D",
        100 -> "C",
        50 -> "L",
        10 -> "X",
        5 -> "V",
        1 -> "I"
    )

    def convert(i: Int): String = {

        val exact = getExact(i)

        handle3InARow(exact)
    }

    def getExact(i: Int): String = {

        numberToNumeral.collectFirst {
            case (number, numeral) if i == number => numeral
            case (number, numeral) if i > number => numeral + getExact(i - number)
        }.getOrElse(throw new IllegalArgumentException)
    }

    def handle3InARow(numerals: String): String = {

        println(s"removing 3 in a row from numerals=$numerals")

        if (numerals.matches("V([I])\\1{3}")) {
            "IX"
        } else {
            numerals.replaceFirst("([I])\\1{3}", "IV")
        }
    }
}
