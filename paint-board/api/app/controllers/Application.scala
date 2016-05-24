package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class Application @Inject()() extends controller {
  def index() = Action { implicit req =>
    Ok(s"ok")
  }
}
