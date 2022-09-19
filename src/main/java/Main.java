public class Main {
    public static void main(String[] args) throws IllegalStateException {
        Person mom = new Person.PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setPlaceOfResidence("Сидней")
                .build();

        System.out.println(mom);

        Person person = new Person.PersonBuilder()
                .setName("Tony")
                .setSurname("Stark")
                .build();

        try {
            //  др с неизвестным возрастом
            person.happyBirthday();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        System.out.println(person);

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new Person.PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new Person.PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}