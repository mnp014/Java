public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("adam", 30);
        Employee employee2 = new Employee("adam", 30);
        Employee employee3 = new Employee("eve", 30);
        Employee employee4 = employee3;

        System.out.println(employee1.equals(employee2));    // false | checks if memory location is same, unless equals method has been overridden to compare content of class.
        System.out.println(employee1 == employee2);         // false | check if memory location is same.

        System.out.println(employee4.equals(employee3));    // true | checks if memory location is same, unless equals method has been overridden to compare content of class.
        System.out.println(employee4 == employee3);         // true | check if memory location is same.

    }
}
