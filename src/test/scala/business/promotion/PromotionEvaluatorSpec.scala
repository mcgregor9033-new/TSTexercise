package business.promotion

import data.promotion.PromotionTestData
import model.promotion.PromotionCombo
import org.scalatest._

class PromotionEvaluatorSpec extends FlatSpec with Matchers with expectedResults {
  "The PromotionEvaluatorSpec" should " should return all combinations for promotion P1" in {
    val actualPromotions = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP1, PromotionTestData.Promotions)

    assert(actualPromotions.size == 2)
    assert(expectedPromotionCombinationP1.forall( testCombo => actualPromotions.contains(testCombo)))
  }

  "The PromotionEvaluatorSpec" should " should return all combinations for promotion P2" in {
    val actualPromotions: Seq[PromotionCombo] = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP2, PromotionTestData.Promotions)

    assert(actualPromotions.size == 2)
    assert(expectedPromotionCombinationP2.forall( testCombo => actualPromotions.contains(testCombo)))
  }

  "The PromotionEvaluatorSpec" should " should return all combinations for promotion P3" in {
    val actualPromotions = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP3, PromotionTestData.Promotions)

    assert(actualPromotions.size == 2)
    assert(expectedPromotionCombinationP3.forall( testCombo => actualPromotions.contains(testCombo)))
  }

  "The PromotionEvaluatorSpec" should " should return all combinations for promotion P4" in {
    val actualPromotions = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP4, PromotionTestData.Promotions)

    assert(actualPromotions.size == 2)
    assert(expectedPromotionCombinationP4.forall( testCombo => actualPromotions.contains(testCombo)))
  }

  "The PromotionEvaluatorSpec" should " should return all combinations for promotion P5" in {
    val actualPromotions = PromotionEvaluator.combinablePromotions(PromotionTestData.promotionCodeP5, PromotionTestData.Promotions)

    assert(actualPromotions.size == 2)
    assert(expectedPromotionCombinationP5.forall( testCombo => actualPromotions.contains(testCombo)))
  }

  "The PromotionEvaluatorSpec" should " should return all promotion combinations" in {
    val actualPromotions = PromotionEvaluator.allCombinablePromotions(PromotionTestData.Promotions)

    assert(actualPromotions.size == 4)
    assert(expectedPromotionCombinationAll.forall( testCombo => actualPromotions.contains(testCombo)))
  }
}

trait expectedResults {
  val expectedPromotionCombinationP1 = Seq(
    PromotionCombo(Seq("P1", "P2")),
    PromotionCombo(Seq("P1", "P4", "P5"))
  )

  val expectedPromotionCombinationP2 = Seq(
    PromotionCombo(Seq("P1", "P2")),
    PromotionCombo(Seq("P2", "P3"))
  )

  val expectedPromotionCombinationP3 = Seq(
    PromotionCombo(Seq("P2", "P3")),
    PromotionCombo(Seq("P3", "P4", "P5"))
  )

  val expectedPromotionCombinationP4 = Seq(
    PromotionCombo(Seq("P1", "P4", "P5")),
    PromotionCombo(Seq("P3", "P4", "P5"))
  )

  val expectedPromotionCombinationP5 = Seq(
    PromotionCombo(Seq("P1", "P4", "P5")),
    PromotionCombo(Seq("P3", "P4", "P5"))
  )

  val expectedPromotionCombinationAll = Seq(
    PromotionCombo(Seq("P1", "P2")),
    PromotionCombo(Seq("P1", "P4", "P5")),
    PromotionCombo(Seq("P2", "P3")),
    PromotionCombo(Seq("P3", "P4", "P5"))
  )
}
