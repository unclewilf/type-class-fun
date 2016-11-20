package typeclassfun

object TitanicSongFormatter {

  import SongFormatting.SongFileTypeFormatter

  def transform[T](implicit ftf: SongFileTypeFormatter[T]): T = {

    ftf.transform(
      SongMetadata(1, "My heart will go on", "Céline Dion")
    )
  }
}
