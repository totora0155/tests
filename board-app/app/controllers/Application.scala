package controllers

import javax.inject.{Singleton, Inject}
import play.api.Configuration
import play.api.data._
import play.api.data.Forms._
import play.api.Environment
import play.api.mvc._
import play.api.libs.json.Json
import play.api.i18n.{I18nSupport, MessagesApi, Messages, Lang}

@Singleton
class Application @Inject()(valconfiguration: Configuration, val messagesApi: MessagesApi) extends Controller with I18nSupport {
  def index = Action {
    Ok(views.html.index(models.Thread.findAll())(forms.Thread.form))
  }
}
