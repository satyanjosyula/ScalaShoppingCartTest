package main.scala.fruitshop

import scala.math.BigDecimal.RoundingMode

object ShoppingCart {

  var shoppingList: List[Fruit] = List[Fruit]()

  def add(fruit: Fruit): Unit = { shoppingList = fruit :: shoppingList }

  def add(fruit: List[Fruit]): Unit = { shoppingList = fruit ::: shoppingList }

  var specialOffers: Set[SpecialOffer] = Set[SpecialOffer]()

  def addSpecialOffer(offer: SpecialOffer): Unit = { specialOffers += offer }

  def addSpecialOffer(offer: Set[SpecialOffer]): Unit = { specialOffers = specialOffers union offer }

  def reset: Unit = {
    shoppingList = List[Fruit]()
    specialOffers = Set[SpecialOffer]()
  }

  def checkout: Double = {
    BigDecimal(shoppingList.map(_.price).sum).setScale(2, RoundingMode.HALF_EVEN).toDouble

  }

  def checkoutWithOffers: Double = {

    var finalList: List[Fruit] = shoppingList

    for (offer <- specialOffers) {
      finalList = offer.applyOffer(finalList)
    }
    BigDecimal(finalList.map(_.price).sum).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

}
