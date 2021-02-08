package business.promotion

import model.promotion.{Promotion, PromotionCombo}

import scala.collection.mutable

object PromotionEvaluator {
  def combinablePromotions(promotionCode: String, allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    val filteredPromotions = allPromotions
      .filter(promotion => promotion.code != promotionCode)
      .filter(promotion => !promotion.notCombinableWith.contains(promotionCode))

    filteredPromotions.map(keyFilteredPromotion => {
      val promotionInclusionBuffer: mutable.Set[String] = mutable.Set(promotionCode)

      filteredPromotions.foreach(filteredPromotion =>
        if (!keyFilteredPromotion.notCombinableWith.contains(filteredPromotion.code) &&
          promotionInclusionBuffer.forall(promotionCode => !filteredPromotion.notCombinableWith.contains(promotionCode))) {
          promotionInclusionBuffer.add(filteredPromotion.code)
        })

      PromotionCombo(promotionInclusionBuffer.toSeq.sorted)
    }).distinct
  }

  def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    allPromotions.flatMap(promotion => combinablePromotions(promotion.code, allPromotions)).distinct
  }
}
