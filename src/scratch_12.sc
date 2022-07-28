val l = List("1","2","3","4","5","6","7","8")
// pageSize = 3
// pageN = 2 ==> 7,8
// start from the nth page (pageN * pageSize)?
// take pageSize

def paginate(data: List[String],
             pageN: Int,
             pageSize: Int): List[String] = {
  val firstItem = pageSize * (pageN - 1)

  data.drop(firstItem).take(pageSize)
}

paginate(l,1,3)


def filterNonNegative(numbers: List[Double]): List[Double] =
  numbers.filter(_ >= 0)

val numbers = List(0.0,1.0,-2.1,-3.5,5.0)

filterNonNegative(numbers)

case class A(i: Int)

val myList = List(new A(1), new A(2), new A(1))
myList.distinct

sealed trait Genre
object Action extends Genre
object Comic extends Genre
object Drama extends Genre

case class Book(title: String, author: List[String], genre: Genre)

val book1 = Book("book1", List("author1"), Action)
val book2 = Book("book2", List("author2", "author3"), Drama)
val book3 = Book("book3", List("author3"), Drama)
val book4 = Book("book3", List("author3"), Drama)

val books = Set(book1, book2, book3, book4)

def getDistinctDramaBooks(books: Set[Book]): Set[String] =
  books.filter(_.genre == Drama).flatMap(_.author)

getDistinctDramaBooks(books)