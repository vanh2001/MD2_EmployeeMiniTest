package views;

import controller.Method;
import model.Employee;
import model.FulltimeEmployee;
import model.ParttimeEmployee;

import java.util.Scanner;

public class Main {
//    Mô hình MVC:
//    Controller: Chứa logic nghiệp vụ
//    Views: Chứa thao tác với người dùng
//    Model: Chứa các lớp chứa dữ liệu objects
    public static Employee[] employees;

    public static void main(String[] args) {
        employees = new Employee[0];
        employees = Method.addEmployee(employees, Method.createNewFullTimeEmployee());
        Method.displayEmployee(employees);
    }


}
