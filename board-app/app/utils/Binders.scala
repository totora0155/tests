// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
// 呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪呪
//
//
// package utils
//
// import play.api.mvc.PathBindable
//
// import models._
//
// object Binders {
//   implicit def threadPathBindable = new PathBindable[Thread] {
//     // def bind(key: String, value: String): Either[String, Thread] =
//     //   for {
//     //     id <- longBinder.bind(key, value).right
//     //     thread <- Thread.findById(id).toRight("Thread not found").right
//     //   } yield thread
//     // def unbind(key: String, thread: models.Thread): String =
//     //   longBinder.unbind(key, models.ThreadId(thread.id))
//     def bind(key: String, value: models.Thread) =
//       // Thread.find(_.toString.toLowerCase == value.toLowerCase) match {
//       //   case Some(v) => Right(v)
//       //   case None => Left("Unknown thread type '" + value + "'")
//       // }
//       Right(ThreadId(1))
//     def unbind(key: String, value: Thread) = value.toString
//   }
// }
