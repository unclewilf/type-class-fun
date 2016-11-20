package typeclassfun

import io.circe.Json
import org.scalatest.{FunSuite, Matchers}

class TitanicSongFormatter$Test extends FunSuite with Matchers {

  test("transform titanic to String") {

    TitanicSongFormatter.transform[String] shouldBe "SongMetadata(1,My heart will go on,Céline Dion)"
  }

  test("transform titanic to Json") {

    TitanicSongFormatter.transform[Json].spaces2 shouldBe
      "{\n  " +
        "\"id\" : 1,\n  " +
        "\"name\" : \"My heart will go on\",\n  " +
        "\"artist\" : \"Céline Dion\"\n" +
      "}"
  }

}
