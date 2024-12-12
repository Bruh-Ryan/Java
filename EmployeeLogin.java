import java.util.Scanner;

abstract class employeeID {
    abstract double calculateMonthlySalary();
    abstract String displayEmpDetails();
}

public class Manager extends employeeID {
    private int baseSal = 6000;
    private String empID;
    private String name;
    private int bonus = 1000;

    Manager(String name, String empID) {
        this.name = name;
        this.empID = empID;
    }

    @Override
    double calculateMonthlySalary() {
        return baseSal + bonus;
    }

    @Override
    String displayEmpDetails() {
        return "Your Employee ID is: " + empID + "\nEmployee Name: " + name;
    }
}

public class Developer extends employeeID {
    private int baseSal = 10;
    private String empID;
    private String name;
    private int hoursWorked = 23 * 30 * 6;  // 23 units * 30 days * 6 hours per day

    Developer(String name, String empID) {
        this.name = name;
        this.empID = empID;
    }

    @Override
    double calculateMonthlySalary() {
        return baseSal * hoursWorked;
    }

    @Override
    String displayEmpDetails() {
        return "Your Employee ID is: " + empID + "\nEmployee Name: " + name;
    }
}

public class Intern extends employeeID {
    private int baseSal = 1000;
    private String empID;
    private String name;

    Intern(String name, String empID) {
        this.name = name;
        this.empID = empID;
    }

    @Override
    double calculateMonthlySalary() {
        return baseSal;
    }

    @Override
    String displayEmpDetails() {
        return "Your Employee ID is: " + empID + "\nEmployee Name: " + name;
    }
}

public class EmployeeLogin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = in.nextLine();
        String empID;

      
        while (true) {
            System.out.println("Enter a 10 char employee ID:");
            empID = in.nextLine();

            if (empID.length() == 10) {
                break; 
            } else {
                System.out.println("Invalid input. Employee ID must be exactly 10 characters.");
            }
        }

        String last3chars = empID.substring(empID.length() - 3);

    
        if (last3chars.equals("MAN")) {
            System.out.println("MANAGER DETAILS:::::\n");
            employeeID info = new Manager(name, empID);

            double salary = info.calculateMonthlySalary();
            System.out.println(info.displayEmpDetails());  // Displaying employee details
            System.out.println("Your Salary is: " + salary + ".");

        } else if (last3chars.equals("DEV")) {
            System.out.println("DEVELOPER DETAILS:::::\n");
            employeeID info = new Developer(name, empID);

            double salary = info.calculateMonthlySalary();
            System.out.println(info.displayEmpDetails());  // Displaying employee details
            System.out.println("Your Salary is: " + salary + ".");

        } else if (last3chars.equals("INT")) {
            System.out.println("INTERN DETAILS:::::\n");
            employeeID info = new Intern(name, empID);

            double salary = info.calculateMonthlySalary();
            System.out.println(info.displayEmpDetails());  // Displaying employee details
            System.out.println("Your Salary is: " + salary + ".");
        } else {
            System.out.println("Invalid Employee ID, please enter a valid ID");
        }

        in.close();
    }
}