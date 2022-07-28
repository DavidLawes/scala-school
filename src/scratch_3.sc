def filter(text: String, word: String): Option[String] =
  if (text.contains(word)) Some(text) else None

filter("this text", "this")

def sqrt(n: Int): Option[Double] =
  if (n >= 0) Some(Math.sqrt(n)) else None

def sqrtOrZero(n: Int): Double =
  sqrt(n) match {
    case Some(result) => result
    case None => 0
}

sqrtOrZero(-9)
sqrt(-9)


case class Person(first: String, middle: Option[String], last: String)

def printName(person: Person): String =
  person.middle match {
    case Some(middle) => s"${person.first} $middle ${person.last}"
    case None => s"${person.first} ${person.last}"
  }

val person1 = Person("first", None, "last")
val person2 = Person("first2", Some("middle"), "last2")

printName(person1)
printName(person2)

"test".mkString("yy")