package view;

import controller.EmployeeManager;
import model.Employee;
import model.FulltimeEmployee;
import model.ParttimeEmployee;

import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<Employee> employeeListClient = EmployeeManager.employeeList;

    public static void main(String[] args) {
        Scanner inputChoice = new Scanner(System.in);
        int choice = -1;
        while (choice != 0){
            System.out.println("Menu");
            System.out.println("1. Add new employee");
            System.out.println("2. Show all employee");
            System.out.println("3. Edit Employee");
            System.out.println("4. Show full time employee have lower salary");
            System.out.println("5. Salary pay for part time employee.");
            System.out.println("0. Exit");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    EmployeeManager.displayAllEmployee();
                    break;
                case 3:
                    editEmployeeById();
                    break;
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    System.exit(0);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please let's choose one!");
            }
        }
    }

    public static void addNewEmployee() {
        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Add new employee:");
            System.out.println("1. New part time");
            System.out.println("2. New full time ");
            System.out.println("0. Return to main menu ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    ParttimeEmployee partTimeEmployee = createNewPartTimeEmployee();
                    EmployeeManager.addNewEmployee(partTimeEmployee);
                    break;
                case 2:
                    FulltimeEmployee fullTimeEmployee = createNewFullTimeEmployee();
                    EmployeeManager.addNewEmployee(fullTimeEmployee);
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Please let's choose one!");
            }
        }
    }

    public static ParttimeEmployee createNewPartTimeEmployee() {
        Scanner inputId = new Scanner(System.in);
        System.out.print("Input id:");
        String id = inputId.nextLine();

        Scanner inputName = new Scanner(System.in);
        System.out.print("Input name:");
        String name = inputName.nextLine();

        Scanner inputAge = new Scanner(System.in);
        System.out.print("Input Age:");
        int age = inputAge.nextInt();

        Scanner inputPhone = new Scanner(System.in);
        System.out.print("Input Phone Number:");
        String phoneNumber = inputPhone.nextLine();

        Scanner inputEmail = new Scanner(System.in);
        System.out.print("Input Email:");
        String email = inputEmail.nextLine();

        Scanner inputWorkhour = new Scanner(System.in);
        System.out.print("Input WorkHour:");
        int workHour = inputWorkhour.nextInt();

        ParttimeEmployee newPartTimeEmployee = new ParttimeEmployee(id, name, age, phoneNumber, email, workHour);
        return newPartTimeEmployee;
    }

    public static Employee createNewFullTimeEmployee(){
        Scanner inputId = new Scanner(System.in);
        System.out.print("Input id:");
        String id = inputId.nextLine();

        Scanner inputName = new Scanner(System.in);
        System.out.print("Input name:");
        String name = inputName.nextLine();

        Scanner inputAge = new Scanner(System.in);
        System.out.print("Input Age:");
        int age = inputAge.nextInt();

        Scanner inputPhone = new Scanner(System.in);
        System.out.print("Input Phone Number:");
        String phoneNumber = inputPhone.nextLine();

        Scanner inputEmail = new Scanner(System.in);
        System.out.print("Input Email:");
        String email = inputEmail.nextLine();

        Scanner inputBonus = new Scanner(System.in);
        System.out.print("Input Bonus:");
        int bonus = inputBonus.nextInt();

        Scanner inputFineMoney = new Scanner(System.in);
        System.out.print("Input Fine Money:");
        int fineMoney = inputFineMoney.nextInt();

        Scanner inputBaseSalary = new Scanner(System.in);
        System.out.print("Input Base Salary:");
        int baseSalary = inputBaseSalary.nextInt();

        FulltimeEmployee newFullTimeEmployee = new FulltimeEmployee(id, name, age, phoneNumber, email, bonus, fineMoney, baseSalary);
        return newFullTimeEmployee;
    }

    public static void editEmployeeById() {
        Scanner inputId = new Scanner(System.in);
        System.out.println("Input employee's id need edit: ");
        String id = inputId.nextLine();
        int check = -1;
        if (EmployeeManager.getEmployeeById(id) == check) {
            System.err.println("Can't find the id!");
        } else {
            int index = EmployeeManager.getEmployeeById(id);
            if (employeeListClient.get(index) instanceof FulltimeEmployee) {
                System.out.println("Editing full time employee...");

                Scanner editIdEmpFT = new Scanner(System.in);
                System.out.print("Edit id:" + "(" + employeeListClient.get(index).getEmployeeId() + ")");
                String editId = editIdEmpFT.nextLine();

                Scanner editNameEmpFT = new Scanner(System.in);
                System.out.println("Edit name:" + "(" + employeeListClient.get(index).getFullName() + ")");
                String editName = editNameEmpFT.nextLine();

                Scanner editAgeEmpFT = new Scanner(System.in);
                System.out.println("Edit name:" + "(" + employeeListClient.get(index).getAge() + ")");
                int editAge = editAgeEmpFT.nextInt();

                Scanner editPhoneNumberEmpFT = new Scanner(System.in);
                System.out.println("Edit phone number:" + "(" + employeeListClient.get(index).getPhoneNumber() + ")");
                String editPhone = editPhoneNumberEmpFT.nextLine();

                Scanner editEmailEmpFT = new Scanner(System.in);
                System.out.println("Edit email:" + "(" + employeeListClient.get(index).getEmail() + ")");
                String editEmail = editEmailEmpFT.nextLine();

                Scanner editBonusEmp = new Scanner(System.in);
                System.out.println("Edit bonus:" + "(" + ((FulltimeEmployee) employeeListClient.get(index)).getBonus() + ")");
                int editBonus = editBonusEmp.nextInt();

                Scanner editFineMoneyEmp = new Scanner(System.in);
                System.out.println("Edit fine money:" + "(" + ((FulltimeEmployee) employeeListClient.get(index)).getFineMoney() + ")");
                int editFineMoney = editFineMoneyEmp.nextInt();

                Scanner editBasicSalaryEmp = new Scanner(System.in);
                System.out.println("Edit basic salary:" + "(" + ((FulltimeEmployee) employeeListClient.get(index)).getBaseSalary() + ")");
                int editBasicSalary = editBasicSalaryEmp.nextInt();

                FulltimeEmployee fullTimeEmployee = new FulltimeEmployee(editId, editName, editAge, editPhone, editEmail, editBonus, editFineMoney, editBasicSalary);
                EmployeeManager.editEmployeeByIndex(index, fullTimeEmployee);
            }
            if (employeeListClient.get(index) instanceof ParttimeEmployee) {
                System.out.println("Editing part time employee...");

                Scanner editIdEmpPT = new Scanner(System.in);
                System.out.print("Edit id:" + "(" + employeeListClient.get(index).getEmployeeId() + ")");
                String editId = editIdEmpPT.nextLine();

                Scanner editNameEmpPT = new Scanner(System.in);
                System.out.println("Edit name:" + "(" + employeeListClient.get(index).getFullName() + ")");
                String editName = editNameEmpPT.nextLine();

                Scanner editAgeEmpPT = new Scanner(System.in);
                System.out.println("Edit name:" + "(" + employeeListClient.get(index).getAge() + ")");
                int editAge = editAgeEmpPT.nextInt();

                Scanner editPhoneNumberEmpPT = new Scanner(System.in);
                System.out.println("Edit phone number:" + "(" + employeeListClient.get(index).getPhoneNumber() + ")");
                String editPhone = editPhoneNumberEmpPT.nextLine();

                Scanner editEmailEmpPT = new Scanner(System.in);
                System.out.println("Edit email:" + "(" + employeeListClient.get(index).getEmail() + ")");
                String editEmail = editEmailEmpPT.nextLine();

                Scanner editWorkHourPT = new Scanner(System.in);
                System.out.println("Edit work hour:" + "(" + ((ParttimeEmployee) employeeListClient.get(index)).getWorkHour() + ")");
                double editWorkHour = editWorkHourPT.nextDouble();

                ParttimeEmployee partTimeEmployee = new ParttimeEmployee(editId, editName, editAge, editPhone, editEmail, editWorkHour);
                EmployeeManager.editEmployeeByIndex(index, partTimeEmployee);
            }
        }
    }
}
