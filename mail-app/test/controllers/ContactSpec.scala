package controllers

import views.txt.mail.ContactContent

import play.api.test._
import collection.mutable.Stack
import org.scalatest._

class ContactSpec extends FunSpec {
  describe("お問い合わせ内容") {
    it("すべて記述") {
      val content = ContactContent(
        Some("xxx株式会社"),
        "佐藤太郎",
        "サトウタロウ",
        Some("メンバー"),
        "000-0000",
        "お問い合わせ"
      ).body.trim
      val answer = """- 会社名
                     |  xxx株式会社
                     |- 氏名
                     |  佐藤太郎
                     |- カナ氏名
                     |  サトウタロウ
                     |- 部署役職
                     |  メンバー
                     |- 電話番号
                     |  000-0000
                     |- お問い合わせ内容
                     |  お問い合わせ""".stripMargin
      assert(content === answer)
    }

    it("会社名がない") {
      val content = ContactContent(
        None,
        "佐藤太郎",
        "サトウタロウ",
        Some("メンバー"),
        "000-0000",
        "お問い合わせ"
      ).body.trim
      val answer = """- 会社名
                     |  未記述
                     |- 氏名
                     |  佐藤太郎
                     |- カナ氏名
                     |  サトウタロウ
                     |- 部署役職
                     |  メンバー
                     |- 電話番号
                     |  000-0000
                     |- お問い合わせ内容
                     |  お問い合わせ""".stripMargin
      assert(content === answer)
    }

    it("部署役職がない") {
      val content = ContactContent(
        Some("xxx株式会社"),
        "佐藤太郎",
        "サトウタロウ",
        None,
        "000-0000",
        "お問い合わせ"
      ).body.trim
      val answer = """- 会社名
                     |  xxx株式会社
                     |- 氏名
                     |  佐藤太郎
                     |- カナ氏名
                     |  サトウタロウ
                     |- 部署役職
                     |  未記述
                     |- 電話番号
                     |  000-0000
                     |- お問い合わせ内容
                     |  お問い合わせ""".stripMargin
      assert(content === answer)
    }
  }
}
