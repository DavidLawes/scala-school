val t = (5, "Jane", 3)
val (_, name, num) = t

name * num


case class Person(name: String,  age: Int)

object Person {
  def unapply(p: Person): Option[(String, Int)] =
    p.name match {
      case "James Bond" => None
      case _ => Some((p.name, p.age))
    }
}

import java.time.Instant

case class Book(title: String, author: String,
                publicationDate: Instant, editor: String,
                isbn: String, totalPageNumber: Int)

object Search {
  def unapply(book: Book): Option[(String, String, String)] = {
    Option.when(book.totalPageNumber >= 10)(book.title, book.author, book.isbn)
  }
}

val book = Book("Get Programming with Scala", "Charles Dickens",
  Instant.now(), "Penguin Books", "649202817", 300)

case class Library(books: Set[Book])
val library = Library(Set(book))

library.books.collect {
  case Search("Get Programming with Scala", _, _) => book
  case Search(_, "Charles Dickens", _) => book
}
