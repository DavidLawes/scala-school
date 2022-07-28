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

def ownerBelowAgeFor(car: Car, age: Int): Option[String] =
  for {
    person <- car.owner if person.age < age
  } yield person.name

val person = Person("name", 20, Some("123"))
val car = Car("model", Some(person), None)

ownerBelowAgeFor(car, 18)

def carWithLicensedOwner(optCar: Option[Car]): Option[Car] =
  optCar.filter(_.owner.exists(_.drivingLicense.isDefined))

carWithLicensedOwner(Some(car))