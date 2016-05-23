package controllers

import javax.inject.{Singleton, Inject}
import play.api.Configuration
import play.api.data._
import play.api.data.Forms._
import play.api.Environment
import play.api.mvc._
import play.api.libs.json.Json

import models._

@Singleton
class Application @Inject()(configuration: Configuration) extends Controller {
  def index = Action {
    // Ok(s"index")
    Ok(views.html.index(Thread.findAll()))
  }
}
