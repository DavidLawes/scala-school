case class Person(name: String,
                  age: Int,
                  drivingLicense: Option[String])

case class Car(model: String,
               owner: Option[Person],
               registrationPlate: Option[String])


def extractRegistrationPlate(car: Car): Option[String] =
  car.registrationPlate.map(_.toUpperCase)

def ownerBelowAge(car: Car, age: Int): Option[String] =
  for {
    owner <- car.owner
    if owner.age < age
  } yield owner.name

val person = Person("name", 18, None)
val car = Car("car", Some(person), None)

ownerBelowAge(car, 17)

def carWithLicensedOwner(optCar: Option[Car]): Option[Car] =
  optCar.find(_.owner.isDefined)

carWithLicensedOwner(Some(car))

case class Student(id: Long, name: String, tutor: Option[Professor])
case class Professor(id: Long, name: String, assistant: Option[Assistant])
case class Assistant(id: Long, name: String)

def tutorName(student: Student): Option[String] =
  for {
    tutor <- student.tutor
  } yield tutor.name

def assistantId(student: Student): Option[Long] =
  for {
    tutor <- student.tutor
    assistant <- tutor.assistant
  } yield assistant.id

def studentWithMatchingTutorId(student: Student, id: Long): Option[Student] =
  for {
    tutor <- student.tutor
    if tutor.id == id
  } yield student