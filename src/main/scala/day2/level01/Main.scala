package day2.level01

import cats.effect._
import fs2.StreamApp.ExitCode
import fs2._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends StreamApp[IO] {

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "localhost")
      .mountService(service, "/")
      .serve

  /**
    * Create routes for your application with hard-coded responses
    *
    * GET  /movies
    *   returns: All movies, OK 200
    * GET  /movie/1
    *   returns: Movie with id 1, OK 200
    * POST /movie/
    *   payload: { "name": "Batman Forever", "synopsis": "Superhero movie!" }
    *   returns: Created 201
    * POST /movie/1/review
    *   payload: { "author": "Bob", "comment": "Great movie for the family." }
    *   returns: Created 201
    */
  val service: HttpService[IO] = HttpService[IO] {
    case GET -> Root / "movies" => ???
  }

}
