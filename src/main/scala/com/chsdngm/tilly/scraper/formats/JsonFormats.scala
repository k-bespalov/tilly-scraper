package com.chsdngm.tilly.scraper.formats

import cats.effect.Concurrent
import com.chsdngm.tilly.scraper.model.WebsocketServerResponse
import io.circe.generic.auto.*
import org.http4s.EntityDecoder
import org.http4s.circe.jsonOf

trait JsonFormats[F[_]: Concurrent]:
  implicit val websocketServerArgsJsonDecoder: EntityDecoder[F, WebsocketServerResponse] =jsonOf[F, WebsocketServerResponse]
