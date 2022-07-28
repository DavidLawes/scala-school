def foo(f: Int => Double = _.toDouble): Double = {
  f(42) + 2
}

def operationWithFallback(n: Int, operation: Int => Int, fallback: Int): Int = {
  val op = operation(n)
  if (op > 0) op else fallback
}