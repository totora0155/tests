package controllers

import javax.inject.{Singleton, Inject}
import play.api.Configuration
import org.apache.commons.mail.EmailAttachment
import play.api.data._
import play.api.data.Forms._
import play.api.Environment
import play.api.libs.mailer._
import play.api.mvc._

import controllers.forms.contact.{Create, CreateForm}
import views.txt.mail.ContactContent

@Singleton
class Contact @Inject()(configuration: Configuration, mailer: MailerClient, environment: Environment) extends Controller {
  val mailSubject = configuration.underlying.getString("play.mailer.subject")
  val mailTo = configuration.underlying.getString("play.mailer.to")

  def buildEmail(form: CreateForm): Email = {
    Email(
      mailSubject,
      form.email,
      Seq(mailTo),
      bodyText = Some(
        ContactContent(form.company, form.name, form.kananame,
                       form.position, form.tel, form.content).body.trim
      )
    )
  }

  def send = Action { implicit request =>
    Create.form.bindFromRequest.fold(
      formErrors => {
        BadRequest(s"Validation Error")
      },
      form => {
        val email = buildEmail(form)
        mailer.send(email)
        Ok(s"send")
      }
    )
  }
}
