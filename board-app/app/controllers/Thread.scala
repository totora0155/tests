package controllers

import javax.inject._
import play.api.mvc._
import scalikejdbc._
import play.api.i18n.{MessagesApi, I18nSupport, Messages, Lang}

@Singleton
class Thread @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {
  def index(threadId: Long) = Action {
    models.Thread.findById(threadId).fold(NotFound(s"not found")) { thread =>
      val resList = models.Res.belongTo(thread)
      Ok(views.html.thread(thread, resList)(forms.Res.form))
    }
  }

  def create() = Action { implicit req =>
    forms.Thread.form.bindFromRequest.fold(
      errors => {
        BadRequest(s"bad")
      },
      thread => {
        DB.localTx { implicit session =>
          thread.create()
          Redirect(routes.Application.index)
        }
      }
    )
  }

  def edit(id: Long) = Action {
    val threadOpt = models.Thread.findById(id)
    if (threadOpt.isEmpty) {
      NotFound(s"not found")
    } else {
      val thread = threadOpt.get
      val form = forms.Thread.form.fill(forms.Thread(
        thread.title,
        thread.author
      ))
      Ok(views.html.editThread(thread)(form))
    }
  }

  def update(id: Long) = Action { implicit req =>
    forms.Thread.form.bindFromRequest.fold(
      errors => {
        BadRequest(s"bad")
      },
      thread => {
        DB.localTx { implicit session =>
          thread.update(id)
          Redirect(routes.Application.index)
        }

      }
    )
  }

  def delete(id: Long) = Action { implicit req =>
    DB.localTx { implicit session =>
      models.Thread.deleteById(id)
      Redirect(routes.Application.index)
    }
  }
}
