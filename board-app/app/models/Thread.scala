package models

import scalikejdbc._
import skinny.orm._
import org.joda.time._

case class Thread(
  id: Long,
  title: String,
  author: String,
  createdAt: DateTime,
  updatedAt: DateTime
)

object Thread extends SkinnyCRUDMapper[Thread] {
  override lazy val defaultAlias = createAlias("t")
  private[this] lazy val t = defaultAlias

  override def extract(rs: WrappedResultSet, rn: ResultName[Thread]) = autoConstruct(rs, rn)

  def create(title: String, author: String) = {
    models.Thread.createWithAttributes(
      'title -> title,
      'author -> author,
      'createdAt -> DateTime.now(),
      'updatedAt -> DateTime.now()
    )
  }

  def update(threadId: Long, title: String, author: String) = {
    models.Thread.updateById(threadId).withAttributes(
      'title -> title,
      'author -> author,
      'updatedAt -> DateTime.now()
    )
  }
}
