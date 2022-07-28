case class Student(id: Long,
                   name: String,
                   tutor: Option[Professor])
case class Professor(id: Long,
                     name: String,
                     assistant: Option[Assistant])
case class Assistant(id: Long, name: String)

def