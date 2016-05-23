package models

import scalikejdbc._
import skinny.orm._
import org.joda.time._

case class ResId(value: Long)
case class Res(
  id: Long,
  threadId: Long,
  name: String,
  message: String,
  createdAt: DateTime,
  updatedAt: DateTime
)

object Res extends SkinnyCRUDMapperWithId[ResId, Res] {
  override lazy val defaultAlias = createAlias("t")
  private[this] lazy val t = defaultAlias

  override def extract(rs: WrappedResultSet, rn: ResultName[Res]) = autoConstruct(rs, rn)
  override def idToRawValue(id: ResId) = id.value
  override def rawValueToId(value: Any) = ResId(value.toString.toLong)

  // def create(name: String): Long = createWithNamedValues(column.name -> name)
  // def findByName(name: String): Option[User] = where(sqls.eq(u.name, name)).apply().headOption
}
