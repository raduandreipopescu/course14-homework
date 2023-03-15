package exercise2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PersonService {

    private List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        if (persons == null) {
            this.persons = new ArrayList<>();
        } else {
            this.persons.addAll(persons);
        }
    }

    public Person addPerson(Person name) {
        Person personToAdd = new Person(name.getName(), name.getAge());
        persons.add(personToAdd);
        return personToAdd;
    }

    public Person removePerson(Integer id) {
        Person personForDelete = null;
        for (Person person : persons) {
            System.out.println(person.getId());
            if (id.intValue() == person.getId().intValue()) {
                personForDelete = new Person(person.getName(), person.getAge());
                personForDelete.setId(person.getId());
                persons.remove(person);
                break;
            }
        }
        if (personForDelete == null) {
            throw new RuntimeException();
        }
        return personForDelete;
    }

    public List<Person> getAllPersons() {
        List<Person> results = new ArrayList<>();
        for (Person person : persons) {
            results.add(person);
        }
        return results;
    }

    public List<Person> getPersonsOlderThan(int ageLimit) {
        List<Person> results = new ArrayList<>();
        int validatedAge = Person.validateAge(ageLimit);

        for (Person person : persons) {
            if (person.getAge() > validatedAge) {
                results.add(person);
            }
        }
        return results;
    }

    public List<String> getAllPersonNames() {
        List<String> results = new ArrayList<>();
        for (Person person : persons) {
            results.add(person.getName());
        }
        return results;
    }


    public Person getPerson(String name) {
        for (Person person : persons) {
            if (name.equals(person.getName())) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonById(Integer id) {
        for (Person person : persons) {
            if (id.intValue() == person.getId().intValue()) {
                return person;
            }
        }
        return null;
    }
}
