package business.cabin

import data.cabin.CabinTestData
import model.cabin.BestGroupPrice
import org.scalatest._

class RateEvaluatorSpec extends FlatSpec with Matchers with expectedResults {
  "The RateEvaluator" should " should return best group price for test data" in {
    val actualBestGroupPrices = RateEvaluator.getBestGroupPrices(CabinTestData.Rates, CabinTestData.cabinPrices)

    assert(actualBestGroupPrices.size == 4)
    keyBestGroupPrices.forall( keyBestGroupPrice => actualBestGroupPrices.contains(keyBestGroupPrice))
  }
}

trait expectedResults {
  val keyBestGroupPrices: Seq[BestGroupPrice] = Seq(
  BestGroupPrice("CA", "M1", 200.00, "Military"),
  BestGroupPrice("CA", "S1", 225.00, "Senior"),
  BestGroupPrice("CB", "M1", 230.00, "Military"),
  BestGroupPrice("CB", "S1", 245.00, "Senior")
  )
}
