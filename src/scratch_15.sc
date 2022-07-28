def allUpper(words: Set[String]): Set[String] =
  words.map(_.toUpperCase)

allUpper(Set("thing", "anotherThing", "Thing"))

def crossMultipler(groupA: Set[Int], groupB: Set[Int]): Set[Int] =
  groupA.flatMap(number => groupB.map(number2 => number * number2))

crossMultipler(Set(1,2,3), Set(2,3,4))