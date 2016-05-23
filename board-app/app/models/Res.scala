package models

import scalikejdbc._
import skinny.orm._
import org.joda.time._

import models._

case class Res(
  id: Long,
  threadId: Long,
  name: String,
  message: String,
  createdAt: DateTime,
  updatedAt: DateTime
)

object Res extends SkinnyCRUDMapper[Res] {
  override lazy val defaultAlias = createAlias("r")
  private[this] lazy val r = defaultAlias

  override def extract(rs: WrappedResultSet, rn: ResultName[Res]) = autoConstruct(rs, rn)

  def belongTo(thread: Thread) = where(sqls.eq(r.threadId, thread.id)).apply()

  // def create(name: String): Long = createWithNamedValues(column.name -> name)
  // def findByName(name: String): Option[User] = where(sqls.eq(u.name, name)).apply().headOption
}
