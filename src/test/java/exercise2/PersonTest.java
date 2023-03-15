package exercise2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void personClass() {
        Class<Person> person = Person.class;
    }

    @Test
    public void instantiatePersonWithParams() {
        String name = "Name";
        int age = 1;
        Person person = new Person(name, age);
    }

    @Test
    public void existsAgeValidator() {
        int inputAge = 0;
        int ageFromValidator = Person.validateAge(inputAge);

        Assertions.assertThat(ageFromValidator).hasSameClassAs(inputAge);
    }

    @Test
    public void doNotCreatePersonWithNegativeAge() {
        String name = "Name";
        int age = -5;

        org.junit.jupiter.api.Assertions.assertThrows(WrongAgeException.class, () -> new Person(name, age));
    }

    @Test
    public void doNotCreatePersonWithAgeOverOneHundredAndTwentyYears() {
        String name = "Name";
        int age = 121;

        org.junit.jupiter.api.Assertions.assertThrows(WrongAgeException.class, () -> new Person(name, age));
    }

    @Test
    public void doNotCreatePersonWithNullName() {
        String name = null;
        int age = 55;

        org.junit.jupiter.api.Assertions.assertThrows(WrongNameException.class, () -> new Person(name, age));
    }

    @Test
    public void doNotCreatePersonWithEmptyName() {
        String name = "";
        int age = 55;

        org.junit.jupiter.api.Assertions.assertThrows(WrongNameException.class, () -> new Person(name, age));
    }

    @Test
    public void doNotCreatePersonWithVeryShortName() {
        String name = "k";
        int age = 55;

        org.junit.jupiter.api.Assertions.assertThrows(WrongNameException.class, () -> new Person(name, age));
    }

    //end of TDD

    //Beginning testing for coverage
    @Test
    public void validateAgeTestForNegativeAge() {
        int inputAge = -5;
        org.junit.jupiter.api.Assertions.assertThrows(WrongAgeException.class, () -> Person.validateAge(inputAge));
    }

    @Test
    public void validateAgeTestForVeryHighAge() {
        int inputAge = 121;
        org.junit.jupiter.api.Assertions.assertThrows(WrongAgeException.class, () -> Person.validateAge(inputAge));
    }

    @Test
    public void validateAgeTest() {
        int inputAge = 11;
        Assertions.assertThat(Person.validateAge(inputAge)).isEqualTo(11);
    }

    @Test
    public void validateNameWithVeryShortName() {
        String name = "k";

        org.junit.jupiter.api.Assertions.assertThrows(WrongNameException.class, () -> Person.validateName(name));
    }

    @Test
    public void validateNameWithEmptyName() {
        String name = "";

        org.junit.jupiter.api.Assertions.assertThrows(WrongNameException.class, () -> Person.validateName(name));
    }

    @Test
    public void validateNameWithNullName() {
        String name = null;

        org.junit.jupiter.api.Assertions.assertThrows(WrongNameException.class, () -> Person.validateName(name));
    }

    @Test
    public void validateNameTest() {
        String name = "Username";
        Assertions.assertThat(Person.validateName(name)).isEqualTo("Username");
    }

    @Test
    public void newPersonTest() {
        String name = "Username";
        int age = 11;
        Person person = new Person(name, age);

        Assertions.assertThat(person.getName()).isEqualTo("Username");
        Assertions.assertThat(person.getAge()).isEqualTo(11);
    }

    @Test
    public void newPersonTestCorectId() {
        String name = "Username";
        int age = 11;
        Person person1 = new Person(name, age);
        Person person2 = new Person(name, age);

        Assertions.assertThat(person1.getId()).isEqualTo(1);
        Assertions.assertThat(person2.getId()).isEqualTo(2);
    }
}
