package controller;

import model.Employee;

public class Method {
    public static void displayEmployee(Employee[] employees){
        for (Employee e: employees) {
            System.out.println(e);
        }
    }

    public static Employee[] addEmployee(Employee[] employees, Employee newEmployee){
        //Khai báo mảng mới
        Employee[] newEmployeeList = new Employee[employees.length + 1];
        //Copy mảng cũ sang mảng mới
        for (int i = 0; i < employees.length; i++) {
            newEmployeeList[i] = employees[i];
        }
        //Gắn nv mới vào phần tử cuối
        newEmployeeList[employees.length] = newEmployee;
        return newEmployeeList;
    }

    //Sắp xếp theo lương
    public static Employee[] sortBySalary(Employee[] employees){
        for (int i = 0; i < employees.length-1; i++) {
            if (employees[i].getNetSalary() > employees[i+1].getNetSalary()) {
                //doi cho
                Employee temp = employees[i];
                employees[i] = employees[i+1];
                employees[i+1] = temp;
            }
        }
        return employees;
    }
}
