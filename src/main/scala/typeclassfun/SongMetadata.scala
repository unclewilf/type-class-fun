package typeclassfun

import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._

case class SongMetadata(id: Long, name: String, artist: String)

object SongFormatting {

  trait SongFileTypeFormatter[T] {
    def transform(song: SongMetadata): T
  }

  object SongFileTypeFormatter {

    implicit object StringSongFormatter extends SongFileTypeFormatter[String] {
      override def transform(song: SongMetadata): String = song.toString
    }

    implicit object JsonCirceSongFormatter extends SongFileTypeFormatter[Json] {
      override def transform(song: SongMetadata): Json = song.asJson
    }
  }
}



