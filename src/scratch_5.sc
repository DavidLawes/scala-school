import Person.unapply

val (_, name, n) = (5, "jane", 3)

name * n

case class Person(name: String,  age: Int)

object Person {
  def unapply(p: Person): Option[(String, Int)] = {
    if (p.name == "James Bond") None
    else Some((p.name, p.age))
  }
}

case class Book(title: String, author: String, publicationDate: String, isbn: Long, pageCount: Int)

object Book {
  def unapply(book: Book): Option[(String, String, Long)] = {
    if (book.pageCount < 10) None
    else Some((book.title, book.author, book.isbn))
  }
}
