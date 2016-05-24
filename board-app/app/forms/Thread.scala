package forms

import javax.inject._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import scalikejdbc._

case class Thread(title: String, author: String) {
  def create()(implicit session: DBSession): Unit = {
    models.Thread.create(title, author)
  }
}

object Thread {
  val form = Form(
    mapping(
      "title" -> nonEmptyText,
      "author" -> nonEmptyText
    )(forms.Thread.apply)(forms.Thread.unapply)
  )
}
