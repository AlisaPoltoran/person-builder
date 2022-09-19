import java.util.Objects;

public class Person {
    protected String name;
    protected String surname;
    protected String age = "не известен";
    protected String placeOfResidence = "не известно";

    Person() {
    }

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = Integer.toString(age);
    }

    public boolean hasAge() {
        return !age.equals("не известен");
    }

    public boolean hasAddress() {
        return !placeOfResidence.equals("не известно");
    }


    public String getAge() throws IllegalStateException {
        if (age.equals("не известен")) {
            throw new IllegalStateException("Возраст неизвестен");
        } else {
            return age;
        }

    }

    public void happyBirthday() throws IllegalStateException {
        if (age.equals("не известен")) {
            throw new IllegalStateException("Возраст неизвестен");
        } else {
            this.age = String.valueOf(Integer.parseInt(age) + 1);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", placeOfResidence='" + placeOfResidence + '\'' +
                '}';
    }
//TODO
//    @Override
//    public int hashCode() { /*...*/ }

    public PersonBuilder newChildBuilder() throws IllegalStateException {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(0);
        child.setPlaceOfResidence(this.placeOfResidence);
        return child;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPlaceOfResidence() {
        return Objects.requireNonNullElse(placeOfResidence, "Адрес неизвестен");
    }


    public static class PersonBuilder implements IPersonBuilder {
        private final Person newPerson;

        public PersonBuilder() {
            newPerson = new Person();
        }

        public PersonBuilder setName(String name) {
            newPerson.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            newPerson.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) throws IllegalStateException {
            if (age < 0) {
                throw new IllegalStateException("Возраст не может быть отрицательным");
            } else {
                newPerson.age = String.valueOf(age);
            }
            return this;
        }

        public PersonBuilder setPlaceOfResidence(String placeOfResidence) {
            newPerson.placeOfResidence = placeOfResidence;
            return this;
        }

        @Override
        public Person build() throws IllegalStateException {
            if (newPerson.name == null && newPerson.surname == null) {
                throw new IllegalStateException("Не заданы обязательные поля: Имя или Фамилия");
            } else {
                return newPerson;
            }

        }
    }
}