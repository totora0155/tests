package models

import scalikejdbc._
import skinny.orm._
import org.joda.time.DateTime

case class Res(
  id: Long,
  threadId: Long,
  name: String,
  message: String,
  createdAt: DateTime,
  updatedAt: DateTime
)

object Res extends SkinnyCRUDMapper[models.Res] {
  override lazy val defaultAlias = createAlias("r")
  private[this] lazy val r = defaultAlias

  override def extract(rs: WrappedResultSet, rn: ResultName[models.Res]) = autoConstruct(rs, rn)

  def belongTo(thread: Thread) = where(sqls.eq(r.threadId, thread.id)).apply()
  def count(threadId: Long) = countBy(sqls.eq(r.threadId, threadId))

  def create(threadId: Long, name: String, message: String) {
    models.Res.createWithAttributes(
      'threadId -> threadId,
      'name -> name,
      'message -> message,
      'createdAt -> DateTime.now(),
      'updatedAt -> DateTime.now()
    )
  }
}
