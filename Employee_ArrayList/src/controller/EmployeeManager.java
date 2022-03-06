package controller;

import model.Employee;
import model.FulltimeEmployee;
import model.ParttimeEmployee;

import java.util.ArrayList;

public class EmployeeManager {
    public static
    public static ArrayList<Employee> employeeList = new ArrayList<>();

//    hiển thị danh sách
    public static void displayAllEmployee(){
        for (Employee e:
             employees) {
            System.out.println(e);
        }
    }

//    Thêm mới nhân viên
    public static void addNewEmployee(Employee employee){
        employees.add(employee);
    }

//    Viết phương thức liệt kê danh sách nhân viên toàn thời gian
//    có mức lương thấp hơn mức lương trung bình
//    của các nhân viên trong công ty

//    Lấy ra nhân viên toàn thời gian
    public static ArrayList<FulltimeEmployee> getFullTimeEmployee() {
        ArrayList<FulltimeEmployee> employeeFulltime = new ArrayList<>();
        for (Employee e:
             employees) {
            if(e instanceof FulltimeEmployee){
                employeeFulltime.add((FulltimeEmployee) e);
            }
        }
        return employeeFulltime;
    }

    public static ArrayList<ParttimeEmployee> getPartTimeEmployee() {
        ArrayList<ParttimeEmployee> employeeFulltime = new ArrayList<>();
        for (Employee e:
                employees) {
            if(e instanceof ParttimeEmployee){
                employeeFulltime.add((ParttimeEmployee) e);
            }
        }
        return employeeFulltime;
    }

    //cleanCode
    public static ArrayList<Employee> getEmployeesByCode(int code){
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        for (Employee e: employees) {
            if(code == 1){
                if(e instanceof FulltimeEmployee){
                    employeeArrayList.add(e);
                }
            }else {
                if(e instanceof ParttimeEmployee){
                    employeeArrayList.add(e);
                }
            }
        }
        return employeeArrayList;
    }

    //Tính lương trung bình
    public static double getAverageSalary(){
        double sum = 0;
        for (Employee e: employees) {
            sum += e.getNetSalary();
        }
        double average = sum / employees.size();
        return average;
    }
}
