package numerals

import numerals.NumeralConverter.convert
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{Matchers, FunSuite}

class NumeralConverterTest extends FunSuite with Matchers with TableDrivenPropertyChecks {

    val numeralConversions =
        Table(
            ("Arabic", "Numeral"),
            ( 1,       "I"),
            ( 3,       "III"),
            ( 5,       "V"),
            ( 8,       "VIII"),
            ( 9,       "IX"),
            ( 10,      "X"),
            ( 1066,    "MLXVI")
        )

//        1989	MCMLXXXIX


    forAll (numeralConversions) { (arabic: Int, numeral: String) =>
        convert(arabic) shouldBe numeral
    }

    test("I can only be repeated at most 3 times in a row") {
        convert(4) shouldBe "IV"
    }
}
