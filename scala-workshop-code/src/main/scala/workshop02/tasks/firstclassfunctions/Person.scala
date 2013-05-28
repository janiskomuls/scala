package workshop02.tasks.firstclassfunctions

case class Person(name: String, age: Int, emailAddresses: List[EmailAddress])

case class EmailAddress(address: String)
