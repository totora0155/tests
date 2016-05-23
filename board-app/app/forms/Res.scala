package forms

import javax.inject.{Singleton, Inject}
import play.api.mvc._
import play.api.data.Forms._
import play.api.data._
import scalikejdbc._

import models._

case class Res(threadId: Long, name: String, message: String) {
  def build()(implicit session: DBSession): ResCreater = new ResCreater(
    threadId: threadId,
    name: name,
    message: message
  )

  def save()(implicit session: DBSession): Long = {
    build()
  }
}

object Res {
  val form = Form(
    mapping(
      "threadId" -> longNumber,
      "name" -> nonEmptyText,
      "message" -> nonEmptyText
    )(Res.apply)(Res.unapply)
  )
}
