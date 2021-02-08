package data.promotion


import model.promotion.Promotion

object PromotionTestData {
  val promotionCodeP1 = "P1"
  val promotionCodeP2 = "P2"
  val promotionCodeP3 = "P3"
  val promotionCodeP4 = "P4"
  val promotionCodeP5 = "P5"

  val Promotions: Seq[Promotion] = Seq(
    Promotion("P1", Seq("P3")), // P1 is not combinable with P3
    Promotion("P2", Seq("P4", "P5")), // P2 is not combinable with P4 and P5
    Promotion("P3", Seq("P1")), // P3 is not combinable with P1
    Promotion("P4", Seq("P2")), // P4 is not combinable with P2
    Promotion("P5", Seq("P2")) // P5 is not combinable with P2
  )
}
