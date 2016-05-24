package controllers

import javax.inject.{Singleton, Inject}
import play.api.Configuration
import play.api.data._
import play.api.data.Forms._
import play.api.Environment
import play.api.mvc._
import play.api.libs.json.Json
import play.api.i18n.{I18nSupport, MessagesApi, Messages, Lang}

case class ThreadOutputer(thread: models.Thread) {
  lazy val id = thread.id
  lazy val title = thread.title
  lazy val author = thread.author
  
  def getResCount() = models.Res.count(thread.id)
}

@Singleton
class Application @Inject()(valconfiguration: Configuration, val messagesApi: MessagesApi) extends Controller with I18nSupport {
  def index = Action {
    val threads: Seq[ThreadOutputer] = models.Thread.findAll().map {ThreadOutputer(_)}
    Ok(views.html.index(threads)(forms.Thread.form))
  }
}
