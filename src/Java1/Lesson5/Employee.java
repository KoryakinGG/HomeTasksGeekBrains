package Java1.Lesson5;

public class Employee {
    String name;
    String position;
    String eMail;
    int phoneNumber;
    int salary;
    int age;

    Employee(String surname, String position, String eMail, int phoneNumber, int salary, int age) {
        this.name = surname;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s \nДолжность: %s \nEmail: %s \nНомер телефона: %s \nЗарплата: %d \nВозраст: %d \n",
                name, position, eMail, phoneNumber, salary, age);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Билл Клинтон", "Президент", "BillClinton@gmail.com", 1212234567, 200_000, 73);

        Employee[] arraysOfEmployees = new Employee[5];
        arraysOfEmployees[0] = employee1;
        arraysOfEmployees[1] = new Employee("Киану Ривз", "Актер", "KianuR@gmail.com", 121225454, 2_000_000, 55);
        arraysOfEmployees[2] = new Employee("Билли Айлиш", "Певица", "OceanEyes@gmail.com", 1214546874, 180_000, 18);
        arraysOfEmployees[3] = new Employee("Джеймс Гослинг", "Разработчик", "JammyLanister@gmail.com", 18465454, 900_000, 65);
        arraysOfEmployees[4] = new Employee("Выходец Из Убежища 13", "Выживальщик", "WereIsMyGun@gmail.com", 1212666874, 100_000, 41);

        for (Employee arraysOfEmployee : arraysOfEmployees) {
            if (arraysOfEmployee.age > 40) {
                System.out.println(arraysOfEmployee.toString());
            }
        }
    }
}