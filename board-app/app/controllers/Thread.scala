package controllers

import javax.inject._
import play.api.mvc._
import scalikejdbc._

import models._

@Singleton
class Thread extends Controller {
  def index(threadId: Long) = Action {

    // val thread = Thread.findById(threadId)
    // if (thread.isEmpty) {
    //   return NotFound(s"not found")
    // }
    //
    // val resList = Res.belongTo(thread.get)
    // Ok(views.html.thread(thread.title, resList))

    Thread.findById(threadId).fold(NotFound(s"not found")) { thread =>
      val resList = Res.belongTo(thread)
      Ok(views.html.thread(thread.title, resList))
    }
  }
}
