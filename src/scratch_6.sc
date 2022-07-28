case class Person(name: String,
                  age: Int,
                  drivingLicense: Option[String])

case class Car(model: String,
               owner: Option[Person],
               registrationPlate: Option[String])

def ownerBelowAge(car: Car, age: Int): Option[String] =
  car.owner.flatMap(person =>
    if (person.age < age) Some(person.name) else None
  )

def ownerBelowAge2(car: Car, age: Int): Option[String] =
  car.owner.filter(_.age < age).map(_.name)

val person = Person("James", 20, None)
val car = Car("model", Some(person), None)

ownerBelowAge(car, 22)

case class Assistant(id: Long, name: String)
case class Professor(id: Long, name: String, assistant: Option[Assistant])
case class Student(id: Long, name: String, tutor: Option[Professor])

val tutor = Professor(4321, "Tutor", None)
val student = Student(1234, "Student", Some(tutor))

val assistant1 = Assistant(9876, "Assistant1")
val tutor1 = Professor(8765, "Tutor1", Some(assistant1))
val student1 = Student(5678, "Student1", Some(tutor1))

def getTutorForStudent(student: Student): Option[String] =
  student.tutor.map(_.name)

def getAssistantIdForStudent(student: Student): Option[Long] =
  student.tutor.flatMap(_.assistant).map(_.id)

def getStudentByTutorId(student: Student, id: Long): Option[Student] =
  student.tutor.flatMap { tutor =>
    if (tutor.id == id) Some(student) else None
  }

getTutorForStudent(student)
getAssistantIdForStudent(student)

getTutorForStudent(student1)
getAssistantIdForStudent(student1)

getStudentByTutorId(student1, 8765)
getStudentByTutorId(student1, 4321)