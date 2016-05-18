package controllers

import javax.inject.Inject
import org.apache.commons.mail.EmailAttachment
import play.api.Environment
import play.api.libs.mailer._
import play.api.mvc.{Action, Controller}

class Application @Inject()(mailer: MailerClient, environment: Environment) extends Controller {
  def index = Action {
    Ok(s"index")
  }

  def send = Action {
    Ok(s"send")
  }
}
