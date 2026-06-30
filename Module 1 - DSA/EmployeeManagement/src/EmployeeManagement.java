class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name,
                    String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagement {

    static Employee[] employees = new Employee[100];
    static int count = 0;

    static void add(Employee e) {
        employees[count++] = e;
    }

    static Employee search(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    static void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name);
        }
    }

    static void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                count--;
                break;
            }
        }
    }
    public static void main(String[] args) {

        add(new Employee(101,
                "Arvind",
                "Developer",
                50000));

        add(new Employee(102,
                "Rahul",
                "Tester",
                40000));

        add(new Employee(103,
                "Priya",
                "Manager",
                70000));

        System.out.println("All Employees:");
        traverse();
        System.out.println("\nSearching Employee 102:");

        Employee emp = search(102);

        if (emp != null) {
            System.out.println(emp.name + " " + emp.position);
        }

        System.out.println("\nDeleting Employee 102");
        delete(102);
        System.out.println("\nEmployees After Deletion:");
        traverse();
    }
}