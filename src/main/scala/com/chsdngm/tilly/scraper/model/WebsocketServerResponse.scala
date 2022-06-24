package com.chsdngm.tilly.scraper.model

case class WebsocketServerArgs(endpoint: String,
                               key: String)

case class WebsocketServerResponse(response: WebsocketServerArgs)
