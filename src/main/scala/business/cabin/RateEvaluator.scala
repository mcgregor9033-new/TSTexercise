package business.cabin

import model.cabin.{BestGroupPrice, CabinPrice, Rate}

object RateEvaluator {
  def getBestGroupPrices(rates: Seq[Rate], prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {
    rates
      .groupBy(rate => rate.rateGroup)
      .flatMap(rgm => {
        val keyRateCodes = rgm._2.map(rate => rate.rateCode)
        val keyPricesSubset = prices
          .filter(cabinPrice => keyRateCodes.contains(cabinPrice.rateCode))
          .sortBy(_.price)
          .groupBy(cabinPrice => cabinPrice.cabinCode)
        keyPricesSubset.flatMap(keyPrice => {
          val head = keyPrice._2.head
          Seq(BestGroupPrice(head.cabinCode, head.rateCode, head.price, rgm._1))
        })
      }
    ).toSeq
  }
}
