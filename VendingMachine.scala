// file VendingMachine.scala

class VendingMachine {

  var chocolateBar = 0
  var granolaBar = 0

  var totalMoney = 0.0

  def buy(product: String, money: Double): String =
    if (!isProductAvailable(product))
      s"Sorry, product $product not available"
    else if (!isMoneyEnough(product, money))
      s"Please insert more money"
    else completeRequest(product, money)

  def isProductAvailable(product: String): Boolean = {
    val requestedProduct =
      if (product == "chocolateBar") chocolateBar
      else if (product == "granolaBar") granolaBar
      else 0

    requestedProduct > 0
  }

  def isMoneyEnough(product: String, money: Double): Boolean = {
    val cost = if (product == "chocolateBar") 1.5 else 1
    money >= cost
  }

  def completeRequest(product: String, money: Double): String = {
    collectMoney(product, money)
    releaseProduct(product)
    s"Have $product"
  }

  def collectMoney(product: String, money: Double): Unit =
    totalMoney += money

  def releaseProduct(product: String): Unit =
    if (product == "chocolateBar") chocolateBar -= 1
    else if (product == "granolaBar") granolaBar -= 1
}

def foo(f: Int => Double = _.toDouble): Double = {
  f(42) + 2
}