package exercise2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest {


    @Test
    public void personServiceClass() {
        Class<PersonService> personService = PersonService.class;
    }

    @Test
    public void addPersonTest() {
        PersonService personService = new PersonService(new ArrayList<>());
        Person person = personService.addPerson(new Person("Username", 22));
    }

    @Test
    public void addPersonTestReturnPerson() {
        PersonService personService = new PersonService(new ArrayList<>());

        Person personFromAdd = personService.addPerson(new Person("Username", 22));

        Assertions.assertThat(personFromAdd).hasSameClassAs(new Person("Name", 1));
    }

    @Test
    public void removePersonTest() {
        Integer idForDelete = 1;
        List<Person> persons = List.of(
                new Person("Ioan", 80),
                new Person("Luca", 43),
                new Person("Matei", 53)
        );

        PersonService personService = new PersonService(persons);

        Assertions.assertThat(personService.removePerson(idForDelete)).isInstanceOf(Person.class);
    }

    @Test
    public void removePersonTestThrowExceptionForIncorrectId() {
        Integer idForDelete = 500;
        List<Person> persons = List.of(new Person("Luca", 43), new Person("Matei", 53));

        PersonService personService = new PersonService(persons);

        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> personService.removePerson(idForDelete));
    }

    @Test
    public void getAllPersonsTest() {
        List<Person> persons = List.of(
                new Person("Ioan", 80),
                new Person("Luca", 43),
                new Person("Matei", 53)
        );

        PersonService personService = new PersonService(persons);

        Assertions.assertThat(personService.getAllPersons().size()).isEqualTo(3);
    }

    @Test
    public void getPersonsOlderThanTest() {
        int ageLimit = 50;
        List<Person> persons = List.of(
                new Person("Ioan", 80),
                new Person("Luca", 43),
                new Person("Matei", 53)
        );

        PersonService personService = new PersonService(persons);

        Assertions.assertThat(personService.getPersonsOlderThan(ageLimit).size()).isEqualTo(2);
    }

    @Test
    public void getAllPersonNamesTest() {
        List<Person> persons = List.of(
                new Person("Ioan", 80),
                new Person("Luca", 43),
                new Person("Matei", 53)
        );

        PersonService personService = new PersonService(persons);

        Assertions.assertThat(personService.getAllPersonNames()).containsExactlyInAnyOrder("Ioan", "Matei", "Luca");
    }

    @Test
    public void getPersonTest() {
        List<Person> persons = List.of(
                new Person("Ioan", 80),
                new Person("Luca", 43),
                new Person("Matei", 53)
        );
        String lookUpName = "Luca";

        PersonService personService = new PersonService(persons);

        Assertions.assertThat(personService.getPerson(lookUpName)).isEqualTo(persons.get(1));
    }

    @Test
    public void getPersonByIdTest() {
        List<Person> persons = List.of(
                new Person("Ioan", 80),
                new Person("Luca", 43),
                new Person("Matei", 53)
        );
        Integer lookUpId = 2;

        PersonService personService = new PersonService(persons);

        Assertions.assertThat(personService.getPersonById(lookUpId)).isEqualTo(persons.get(1));
    }
}
