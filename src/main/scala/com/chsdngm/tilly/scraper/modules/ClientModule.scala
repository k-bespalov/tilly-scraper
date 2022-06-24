package com.chsdngm.tilly.scraper.modules

import cats.effect.IO
import cats.effect.kernel.Resource
import com.chsdngm.tilly.scraper.consumer.WebSocketConsumer
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.client.Client
import org.http4s.client.websocket.WSClient
import org.http4s.jdkhttpclient.JdkWSClient

import java.net.http.HttpClient

trait ClientModule:
  lazy val httpClient: Resource[IO, Client[IO]] = BlazeClientBuilder[IO].resource
  lazy val webSocketConsumer: WebSocketConsumer[IO] = {
    val websocketClient: Resource[IO, WSClient[IO]] = JdkWSClient.simple[IO]
    WebSocketConsumer[IO](websocketClient)
  }
