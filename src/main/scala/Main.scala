import business.cabin.RateEvaluator
import business.promotion.PromotionEvaluator
import data.cabin.CabinTestData
import data.promotion.PromotionTestData
import model.promotion.PromotionCombo

object Main extends App {
  val bestGroupPrices = RateEvaluator.getBestGroupPrices(CabinTestData.Rates, CabinTestData.cabinPrices)
  val p1Promotions: Seq[PromotionCombo] = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP1, PromotionTestData.Promotions)
  val p3Promotions: Seq[PromotionCombo] = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP3, PromotionTestData.Promotions)
  val allPromotions: Seq[PromotionCombo] = PromotionEvaluator.allCombinablePromotions(PromotionTestData.Promotions)

  println("\n===== Calculated Best Prices =====")
  bestGroupPrices.sortBy(_.cabinCode).foreach( bestGroupPrice => println(bestGroupPrice) )

  println("\n===== Calculated Promotions for P1 =====")
  println(p1Promotions)

  println("\n===== Calculated Promotions for P3 =====")
  println(p3Promotions)

  println("\n===== All Calculated Promotions =====")
  println(allPromotions)
}
