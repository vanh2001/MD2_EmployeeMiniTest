package controller;

import model.Employee;
import model.FulltimeEmployee;
import model.ParttimeEmployee;
import storage.EmployeeFromFileBinary;
import storage.IEmployeeData;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeManager {
    public static IEmployeeData employeeData = new EmployeeFromFileBinary();
    public static ArrayList<Employee> employeeList = new ArrayList<>();

    //    hiển thị danh sách
    public static void displayAllEmployee() {
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    //    Thêm mới nhân viên
    public static void addNewEmployee(Employee employee) {
        employeeList.add(employee);
        try {
            employeeData.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getEmployeeById(String employeeId) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getEmployeeId().equals(employeeId)) {
                return i;
            }
        }
        return -1;
    }

    //    Sửa nhân viên
    public static void editEmployeeByIndex(int index, Employee employee) {
        employeeList.set(index, employee);
        try {
            employeeData.writeFile(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Viết phương thức liệt kê danh sách nhân viên toàn thời gian
//    có mức lương thấp hơn mức lương trung bình
//    của các nhân viên trong công ty

    //    Lấy ra nhân viên toàn thời gian
    public static ArrayList<FulltimeEmployee> getFullTimeEmployee() {
        ArrayList<FulltimeEmployee> employeeFulltime = new ArrayList<>();
        for (Employee e :
                employeeList) {
            if (e instanceof FulltimeEmployee) {
                employeeFulltime.add((FulltimeEmployee) e);
            }
        }
        return employeeFulltime;
    }

    public static ArrayList<ParttimeEmployee> getPartTimeEmployee() {
        ArrayList<ParttimeEmployee> employeeFulltime = new ArrayList<>();
        for (Employee e :
                employeeList) {
            if (e instanceof ParttimeEmployee) {
                employeeFulltime.add((ParttimeEmployee) e);
            }
        }
        return employeeFulltime;
    }

    //cleanCode
    public static ArrayList<Employee> getEmployeesByCode(int code) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        for (Employee e : employeeList) {
            if (code == 1) {
                if (e instanceof FulltimeEmployee) {
                    employeeArrayList.add(e);
                }
            } else {
                if (e instanceof ParttimeEmployee) {
                    employeeArrayList.add(e);
                }
            }
        }
        return employeeArrayList;
    }

    //Tính lương trung bình
    public static double getAverageSalary() {
        double sum = 0;
        for (Employee e : employeeList) {
            sum += e.getNetSalary();
        }
        double average = sum / employeeList.size();
        return average;
    }
}
