package catsfun


import cats.data.OptionT

import cats.implicits._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.duration._
import scala.language.postfixOps

object FutureOptionFun extends App {

  val eventualResult = combine.value

  val result = Await.result(eventualResult, 1 second)
  println(s"result=$result")


  def combine: OptionT[Future, Int] = {

    for {
      a <- OptionT.fromOption[Future](lookup1)
      b <- OptionT.liftF(lookup2)
      c <- OptionT(lookup3)
      d <- lookup4
    } yield {
      a + b + c + d
    }
  }

  def lookup1: Option[Int] = Option(10)

  def lookup2: Future[Int] = {
    Future.successful(20)
  }

  def lookup3: Future[Option[Int]] = {
    Future.successful(
      Option(30)
    )
  }

  def lookup4: OptionT[Future, Int] = {
    OptionT(
      Future.successful(
        Option(40)
      )
    )
  }


}
