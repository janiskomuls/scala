package tasks.workshop02.firstclassfunctions

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import junit.framework.Assert._

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

// Make tests below run and pass

// The objective in each exercise is to 
// transform the list 'persons' in some way,
// using the functions filter, map etc. on the list

// Rename bad-named test
// Change assertEquals and matchers
// to ShouldMatchers (should be/have/equal etc.)

@RunWith(classOf[JUnitRunner])
class PersonTest extends FunSuite with ShouldMatchers {

  val alf = Person("Alf", 30, List(EmailAddress("alf.kristian@gmail.com")))
  val fredrik = Person("Fredrik", 33, List(EmailAddress("fredrik@vraalsen.no"), EmailAddress("fvr@knowit.no")))
  val johannes = Person("Johannes", 0, Nil)

  val persons = List(alf, fredrik, johannes)

  test("should be the list of all adults") {

    val adults = Nil

    adults should equal(List(alf, fredrik))

  }

  test("should be the list of names of all persons") {

    val names = Nil

    names should be(List("Alf", "Fredrik", "Johannes"))
  }

  test("testNamesOfAdults") {
    // Create a list containing the names of the adults,
    // by combining the approaches in the two exercises above
    val names = Nil

    assertEquals(List("Alf", "Fredrik"), names)
  }

  test("testAgeLimit") {
    // Partition the list of persons into two new lists,
    // one containing the adults and one containing the kids
    val (adults, kids) = (Nil, Nil)

    assertEquals(List(alf, fredrik), adults)
    assertEquals(List(johannes), kids)
  }

  test("should have two email addresses") {

    val tech: Person = null

    tech.emailAddresses should have size (2)
    tech.emailAddresses should have length (2)
  }

  test("testHasMultipleEmails") {
    // Split the list of persons into two new lists containing
    // techies (more than one email address) and luddites (zero or only one email address)
    val (techies: List[Person], luddites) = (Nil, Nil)

    techies should contain(fredrik)
    luddites should be(List(alf, johannes))
  }

  test("should find Johannes") {
    // Find the person named "Johannes" in the list of persons
    val name = "Johannes"
    val person: Option[Person] = null

    person should be(Some(johannes))
  }

  test("should not find Jon-Anders") {
    // Find the person named "Jon-Anders" (should not match)
    val name = "Jon-Anders"
    val person: Option[Person] = null

    person should be(None)
  }

  test("testFindEmailAddressesByName") {
    // Find the e-mail addresses of the person named "Alf". 
    // Here you must first find the person, 
    // then map the collection to a different type
    val name = "Alf"
    val addresses: Option[List[EmailAddress]] = null

    addresses match {
      case Some(addresses) => assertEquals(alf.emailAddresses, addresses)
      case _ => sys.error("No match")
    }
  }

  test("testFindPersonByEmail") {
    // Find the person who has the e-mail address "fvr@knowit.no".

    // Hint: Try combinining finding the person and checking if
    // there exists an email address matching the criteria in the
    // person's list of email addresses.
    val address = EmailAddress("fredrik@vraalsen.no")
    val person: Option[Person] = null

    person match {
      case Some(person) => assertEquals(fredrik, person)
      case _ => sys.error("No match")
    }
  }

  test("testGetFirstEmailAddress") {
    // Create a new list of the first e-mail address of each person,
    // filtering out persons without e-mail addresses. 

    // Hint: Try combining filtering the list and then 
    // mapping it to a different type, only getting
    // the head of the email address list.
    val addresses = Nil

    assertEquals(List(alf.emailAddresses.head, fredrik.emailAddresses.head), addresses)
  }

  test("testNameToEmailAddress") {
    // Create a map from each persons name to their e-mail addresses,
    // filtering out persons without e-mail addresses
    // Hint: First filter list, then use foldLeft to accumulate...
    val emptyMap: Map[String, List[EmailAddress]] = Map()

    // Insert code here for emptyMap
    val nameToEmail = emptyMap

    assertEquals(Map(alf.name -> alf.emailAddresses, fredrik.name -> fredrik.emailAddresses), nameToEmail)
  }

}
