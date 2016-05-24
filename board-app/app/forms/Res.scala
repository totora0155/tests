package forms

import javax.inject.{Singleton, Inject}
import play.api.mvc._
import play.api.data.Forms._
import play.api.data._
import scalikejdbc._

case class Res(threadId: Long, name: String, message: String) {
  def create()(implicit session: DBSession) = {
    models.Res.create(threadId, name, message)
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
