def sum(listInts: List[Int]): Int = {
  listInts match {
    case Nil => 0
    case head :: tail => head + sum(tail)
  }
}

sum(List(1,2,3,4))

def plus5(ns: List[Int]): List[Int] =
  ns.map(_ + 5)

val ls = List(1,2,3)
plus5(ls)


def triple(ns: List[Int]): List[Int] =
  ns.flatMap(List.fill(3)(_))

triple(ls)

def tripleFor(ns: List[Int]): List[Int] =
  for {
    i <- ns
    thing <- List.fill(3)(i)
  } yield thing

tripleFor(ls)

case class Person(name: String, age: Int)

def peopleOver18(people: List[Person]): List[String] = for {
    person <- people if person.age > 18
  } yield person.name

val people = List(Person("John", 19), Person("Bob", 17))

peopleOver18(people)