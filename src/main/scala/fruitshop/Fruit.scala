package main.scala.fruitshop

trait Fruit {
  def price: Double = 0.0
}

case class Apple() extends Fruit {
  override def price: Double = 0.60
}

case class Orange() extends Fruit {
  override def price: Double = 0.25
}
