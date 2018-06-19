package main.scala.fruitshop

object ShoppingCart {

  var shoppingList: List[Fruit] = List[Fruit]()
  
  def add(fruit: Fruit): Unit = { shoppingList = fruit :: shoppingList }
  
  def add(fruit: List[Fruit]): Unit = { shoppingList = fruit ::: shoppingList }
  
  def reset: Unit = {
    shoppingList = List[Fruit]()
  }

  def checkout: Double = {
    shoppingList.map(_.price).sum
  }

 }
