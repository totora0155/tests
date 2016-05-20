package controllers

import javax.inject.{Singleton, Inject}
import play.api.Play.current
import org.apache.commons.mail.EmailAttachment
import play.api.data._
import play.api.data.Forms._
import play.api.Environment
import play.api.libs.mailer._
import play.api.mvc._

import controllers.forms.contact.{Create, CreateForm}
import views.txt.mail.ContactContent

@Singleton
class Contact @Inject()(mailer: MailerClient, environment: Environment) extends Controller {
  def send = Action { implicit request =>
    Create.form.bindFromRequest.fold(
      formErrors => {
        BadRequest(s"Validation Error")
      },
      form => {
        val email = Contact.buildEmail(form)
        mailer.send(email)
        Ok(s"send")
      }
    )
  }
}

object Contact {
  val subject = current.configuration.getString("play.mailer.subject").get
  val to = current.configuration.getString("play.mailer.to").get

  def buildEmail(form: CreateForm): Email = {
    Email(
      Contact.subject,
      form.email,
      Seq(Contact.to),
      bodyText = Some(ContactContent(form.company, form.name, form.kananame, form.position, form.tel, form.content).body.trim)
    )
  }
}
