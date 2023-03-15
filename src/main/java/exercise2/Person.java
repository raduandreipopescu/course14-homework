package exercise2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private static Integer counter = 1;
    private Integer id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.id = counter;
        this.name = validateName(name);
        this.age = validateAge(age);
        counter++;
    }

    static int validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new WrongAgeException();
        }
        return age;
    }

    static String validateName(String name) {
        if (name == null || name.length() < 2) {
            throw new WrongNameException();
        }
        return name;
    }
}
