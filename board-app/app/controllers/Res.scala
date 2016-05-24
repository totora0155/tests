package controllers

import javax.inject._
import play.api.mvc._
import scalikejdbc._

@Singleton
class Res extends Controller {
  def create() = Action { implicit req =>
    forms.Res.form.bindFromRequest().fold(
      errors => {
        BadRequest(s"oops")
      },
      res => {
        DB.localTx { implicit session =>
          forms.Res(res.threadId, res.name, res.message).create()
          Redirect(routes.Thread.index(res.threadId))
        }
      }
    )
  }
}
