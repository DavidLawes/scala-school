def safeApply[A](list: List[A], n: Int): Option[A] =
  if (n < list.size) Some(list(n)) else None



// match/case?
// different list method available (other than size?)

val l = List(0, 1, 2)
l.indices
safeApply(l, 3)
safeApply(l, 6)
safeApply(l, 0)


sealed trait Label
case object Work extends Label
case object Home extends Label
case class ContactNumber(number: String, label: Label)
case class Contact(name: String,
                   surname: String,
                   numbers: List[ContactNumber],
                   company: Option[String],
                   email: Option[String])

def findByCompany(addressBook: List[Contact],
                  company: String): Option[Contact] =
  addressBook.find(_.company.exists(_.equalsIgnoreCase(company)))

val addressBook = List(
  Contact("Roberto", "Tyley", List.empty, Some("Daily Mail"), None),
  Contact("David", "Lawes", List.empty, Some("The Guardian"), None),
  Contact("Frederick", "O'Brien", List.empty, Some("The Guardian"), None)
)

findByCompany(addressBook, "daily mail")

