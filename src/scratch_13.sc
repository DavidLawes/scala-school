def sumOfFirstN(n: Int): Int = (0 to n).sum

sumOfFirstN(10)

sealed trait Label
case object Work extends Label
case object Home extends Label
case class ContactNumber(number: String, label: Label)

case class Contact(name: String,
                   surname: String,
                   numbers: List[ContactNumber] = List.empty,
                   company: Option[String] = None,
                   email: Option[String] = None)
val contacts = List(
  Contact("Roberto", "Tyley"),
  Contact("Fred", "Tyley"),
  Contact("Bob", "Tyley"),
  Contact("Neo", ""),
  Contact("Madonna", "")
)

def perLetter(addressBook: List[Contact]): Map[Char, List[Contact]] =
  addressBook.groupBy(_.surname.headOption.getOrElse(' '))



perLetter(contacts)