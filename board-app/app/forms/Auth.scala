package forms

import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._

case class Auth(userId: String, pass: String) {
  def save() = {}
}

object Auth {
  val form = Form(
    mapping(
      "userId" -> nonEmptyText,
      "pass" -> nonEmptyText
    )(Auth.apply)(Auth.unapply)
  )
}
