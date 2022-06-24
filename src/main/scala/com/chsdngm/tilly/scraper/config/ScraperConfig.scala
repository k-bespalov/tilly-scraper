package com.chsdngm.tilly.scraper.config

import com.typesafe.config.{Config, ConfigFactory}

object ScraperConfig extends Configuration:
  val config: Config = initialConfig

  object AuthParameters:
    def serverUri: String = config.getString("auth.serverUri")

trait Configuration:
  val initialConfigValue: Config = ConfigFactory.load()

  def initialConfig: Config = initialConfigValue
  def reloadableConfig: Config = ConfigFactory.load()
