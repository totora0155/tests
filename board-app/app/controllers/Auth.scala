package controllers

import javax.inject._
import play.api.mvc._
import play.api.i18n.{I18nSupport, MessagesApi, Messages, Lang}

import jp.t2v.lab.play2.auth._

import controllers.auth.AuthConfigImpl

@Singleton
class Auth @Inject()(val messagesApi: MessagesApi) extends Controller with LoginLogout with AuthConfigImpl with I18nSupport {
  def login() = Action { implicit req =>
    Ok(views.html.auth(forms.Auth.form))
  }
}
