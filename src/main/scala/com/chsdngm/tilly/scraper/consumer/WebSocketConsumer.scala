package com.chsdngm.tilly.scraper.consumer

import cats.effect.kernel.Resource
import cats.effect.Concurrent
import com.chsdngm.tilly.scraper.model.WebsocketServerArgs
import org.http4s.Uri
import org.http4s.client.websocket.{WSClient, WSRequest, WSFrame}
import org.http4s.syntax.all.*

class WebSocketConsumer[F[_]](websocketClient: Resource[F, WSClient[F]])
                             (implicit F: Concurrent[F]):
  def start(args: WebsocketServerArgs): F[Unit] = {
    val request = WSRequest(Uri.unsafeFromString(s"wss://${args.endpoint}/stream?key=${args.key}"))
    val connection = websocketClient.flatMap(_.connect(request))

    connection.use { conn =>

      val receiveMessages: F[Unit] =
        conn.receiveStream
          .evalTap(frame => F.pure(println(frame.toString)))
          .compile
          .drain

      receiveMessages
    }
  }
