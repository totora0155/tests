package models

import scalikejdbc._
import skinny.orm._
import org.joda.time.DateTime

case class Auth(
  id: Long,
  userId: String,
  pass: String,
  createdAt: DateTime
)

object Auth extends SkinnyCRUDMapper[models.Auth] {
  override lazy val defaultAlias = createAlias("a")
  private[this] lazy val a = defaultAlias

  override def extract(rs: WrappedResultSet, rn: ResultName[models.Auth]) = autoConstruct(rs, rn)
}
