package models

import scalikejdbc._
import skinny.orm._
import org.joda.time._

case class ThreadId(value: Long)
case class Thread(
  id: Long,
  title: String,
  author: String,
  createdAt: DateTime,
  updatedAt: DateTime
)

object Thread extends SkinnyCRUDMapperWithId[ThreadId, Thread] {
  override lazy val defaultAlias = createAlias("t")
  private[this] lazy val t = defaultAlias

  override def extract(rs: WrappedResultSet, rn: ResultName[Thread]) = autoConstruct(rs, rn)
  override def idToRawValue(id: ThreadId) = id.value
  override def rawValueToId(value: Any) = ThreadId(value.toString.toLong)

  // def create(name: String): Long = createWithNamedValues(column.name -> name)
  // def findByName(name: String): Option[User] = where(sqls.eq(u.name, name)).apply().headOption
}
