Set(1, 2, 3).diff(Set(3,4))
Set(3,4).diff(Set(1,2,3))


def sumInRange(numbers: Set[Double]): Double =
  numbers.filter(n => n > 0 && n < 100).sum

sumInRange(Set(0.5, -1, 0, 50.5, 99, 100))

case class Student(id: Int, name: String, topics: Set[String])

def studentsTakingTopics(students: Set[Student], topics: Set[String]): Set[Student] =
  students.filter(_.topics.intersect(topics).nonEmpty)

val student1 = Student(1, "name1", Set("english", "maths", "science"))
val student2 = Student(2, "name2", Set("maths"))
val student3 = Student(3, "name3", Set("english", "science", "art"))
val student4 = Student(4, "name4", Set("art", "history"))
val students = Set(student1, student2, student3, student4)

studentsTakingTopics(students, Set("maths", "science"))

studentsTakingTopics(students, Set("art", "history"))

studentsTakingTopics(students, Set("history"))

val daysByDayOfWeek = Map(
  1 -> "Monday",
  2 -> "Tuesday",
  3 -> "Wednesday",
  4 -> "Thursday",
  5 -> "Friday",
  6 -> "Saturday",
  7 -> "Sunday"
)