package views;

import controller.Method;
import model.Employee;
import model.ParttimeEmployee;

import java.util.Scanner;

public class Main {
//    Mô hình MVC:
//    Controller: Chứa logic nghiệp vụ
//    Views: Chứa thao tác với người dùng
//    Model: Chứa dữ liệu của ứng dụng
    public static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[0];
        Employee vanh = createNewEmployee();
        employees = Method.addEmployee(employees, vanh);
        Method.displayEmployee(employees);
    }

    public static Employee createNewEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số giờ làm việc:");
        double workHour = scanner.nextDouble();
        Employee employee = new ParttimeEmployee(workHour);
        return employee;
    }
}
