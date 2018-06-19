package main.scala.fruitshop

trait SpecialOffer {
  val fruitType: Any
  def applyOffer(itemList: List[Fruit]): List[Fruit]

  def removeFreeItems(list: List[Fruit], n: Int): List[Fruit] = {
    list.zipWithIndex
      .filter { case (_, i) => (i + 1) % n != 0 }
      .map { case (e, _) => e }
  }
}

case class BuyOneGetOneOffer(fruitType: Any) extends SpecialOffer {

  def applyOffer(itemList: List[Fruit]): List[Fruit] = {
    var fruitList = itemList.filter(_.getClass == fruitType.getClass)
    fruitList = removeFreeItems(fruitList, 2)
    fruitList ::: itemList.filter(_.getClass != fruitType.getClass)
  }
}

case class ThreeForTwoOffer(fruitType: Any) extends SpecialOffer {

  def applyOffer(itemList: List[Fruit]): List[Fruit] = {
    var fruitList = itemList.filter(_.getClass == fruitType.getClass)
    fruitList = removeFreeItems(fruitList, 3)
    fruitList ::: itemList.filter(_.getClass != fruitType.getClass)
  }
}