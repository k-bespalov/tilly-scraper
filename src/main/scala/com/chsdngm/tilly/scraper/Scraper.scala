package com.chsdngm.tilly.scraper

import cats.effect.{ExitCode, IO, IOApp}
import com.chsdngm.tilly.scraper.config.ScraperConfig.AuthParameters
import com.chsdngm.tilly.scraper.formats.JsonFormats
import com.chsdngm.tilly.scraper.model.WebsocketServerResponse
import com.chsdngm.tilly.scraper.modules.ClientModule
import org.http4s.{Method, Request}

import scala.util.{Failure, Success}

object Scraper extends IOApp with ClientModule with JsonFormats[IO]:
  def run(args: List[String]): IO[ExitCode] = {
    val startApp = httpClient.use { client =>
      client.expect[WebsocketServerResponse](AuthParameters.serverUri)
    }.flatMap(response => webSocketConsumer.start(response.response))

    startApp.as(ExitCode.Success)
  }
