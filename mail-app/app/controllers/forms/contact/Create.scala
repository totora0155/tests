package controllers.forms.contact

import play.api.data._
import play.api.data.Forms._

object Create {
  val form = Form(
    mapping(
      "company" -> optional(text),
      "name" -> nonEmptyText,
      "kananame" -> nonEmptyText,
      "position" -> optional(text),
      "tel" -> nonEmptyText,
      "email" -> nonEmptyText,
      "content" -> nonEmptyText
    )(CreateForm.apply)(CreateForm.unapply)
  )
}

case class CreateForm(
  company: Option[String],
  name: String,
  kananame: String,
  position: Option[String],
  tel: String,
  email: String,
  content: String
) {}
