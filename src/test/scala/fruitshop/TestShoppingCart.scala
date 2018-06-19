package test.scala.fruitshop

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterEach
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import main.scala.fruitshop.Apple
import main.scala.fruitshop.Orange
import main.scala.fruitshop.ShoppingCart
import main.scala.fruitshop.BuyOneGetOneOffer
import main.scala.fruitshop.ThreeForTwoOffer

@RunWith(classOf[JUnitRunner])
class TestShoppingCart extends FunSuite with BeforeAndAfterEach {

  test("Adding a fruit") {

    ShoppingCart.add(Apple())
    assert(ShoppingCart.shoppingList.size == 1)
    assert(ShoppingCart.shoppingList.head.isInstanceOf[Apple])
  }

  test("Adding multiple fruits") {

    ShoppingCart.add(List(Apple(), Apple(), Orange()))
    assert(ShoppingCart.shoppingList.size == 3)
    assert(ShoppingCart.shoppingList.head.isInstanceOf[Apple])
    assert(ShoppingCart.shoppingList.last.isInstanceOf[Orange])
  }

  test("Cost of 1 Apple is 60p") {

    ShoppingCart.add(Apple())

    assert(ShoppingCart.checkout == 0.60)

  }

  test("Cost of 1 Orange is 25p") {

    ShoppingCart.add(Orange())

    assert(ShoppingCart.checkout == 0.25)

  }

  test("Cost of 1 Apple and 1 Orange is 85p") {

    ShoppingCart.add(Apple())
    ShoppingCart.add(Orange())

    assert(ShoppingCart.checkout == 0.85)

  }

  test("Cost of 3 Apples and 1 Orange is 2.05 GBP ") {

    ShoppingCart.add(List(Apple(), Apple(), Orange(), Apple()))

    assert(ShoppingCart.checkout == 2.05)

  }

  test("Cost of 3 Apples with BuyOneGetOne Offer is 1.20 GBP ") {

    ShoppingCart.add(List(Apple(), Apple(), Apple()))
    ShoppingCart.addSpecialOffer(BuyOneGetOneOffer(Apple()))

    assert(ShoppingCart.checkoutWithOffers == 1.20)

  }

  test("Cost of 3 Apples and 1 orange with BuyOneGetOne Offer is 1.45 GBP ") {

    ShoppingCart.add(List(Apple(), Apple(), Orange(), Apple()))
    ShoppingCart.addSpecialOffer(BuyOneGetOneOffer(Apple()))

    assert(ShoppingCart.checkoutWithOffers == 1.45)

  }

  test("Cost of 3 oranges with ThreeForTwoOffer  is 0.50 GBP ") {

    ShoppingCart.add(List(Orange(), Orange(), Orange()))
    ShoppingCart.addSpecialOffer(ThreeForTwoOffer(Orange()))

    assert(ShoppingCart.checkoutWithOffers == 0.50)

  }

  test("Cost of 3 Apples and 3 oranges with BuyOneGetOne offer on Apples and ThreeForTwoOffer on Oranges is 1.70 GBP ") {

    ShoppingCart.add(List(Apple(), Apple(), Apple(), Orange(), Orange(), Orange()))
    ShoppingCart.addSpecialOffer(BuyOneGetOneOffer(Apple()))
    ShoppingCart.addSpecialOffer(ThreeForTwoOffer(Orange()))

    assert(ShoppingCart.checkoutWithOffers == 1.70)

  }

  override def afterEach() {
    ShoppingCart.reset
  }
}