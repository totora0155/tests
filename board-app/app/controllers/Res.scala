package controllers

import javax.inject._
import play.api.mvc._
import scalikejdbc._

import forms._

@Singleton
class Res extends Controller {
  def submit() = Action { implicit req =>
    forms.Res.form.bindFromRequest().fold(
      errors => {
        BadRequest(s"oops")
      },
      form => {
        val res = forms.Res(form.threadId, form.name, form.message)
        print(res)
        Ok(s"ccc")
        // DB.localTx { implicit session =>
        //   val res = forms.Res(form.threadId, form.name, form.message)
        //   res.build()
        //   Ok(s"created")
        // }
      }
    )
  }
}
