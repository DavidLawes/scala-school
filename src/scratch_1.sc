sealed trait Mode
case object Length extends Mode
case object Letters extends Mode
case object Digits extends Mode
case object Whitespace extends Mode

def predicateSelector(mode: Mode): Char => Boolean =
  mode match {
    case Length => _ => true
    case Letters => _.isLetter
    case Digits => _.isDigit
    case Whitespace => _.isWhitespace
  }

def stats(s: String,
          predicate: Char => Boolean = { _ => true } ): Int =
  s.count(predicate)

val text = "This is my Text Example"
val selector: Char => Boolean = predicateSelector(Whitespace)
stats(text, selector)

def operationWithFallback(n: Int, operation: Int => Int, fallback: Int): Int = {
  val opOfN = operation(n)
  if (opOfN > 0) opOfN else operation(fallback)
}