package tasks.workshop02.firstclassfunctions

case class Person(name: String, age: Int, emailAddresses: List[EmailAddress])

case class EmailAddress(address: String)
