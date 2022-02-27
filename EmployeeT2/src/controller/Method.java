package controller;

import model.Employee;
import model.FulltimeEmployee;
import model.ParttimeEmployee;

import java.util.Scanner;

public class Method {
    public static void displayEmployee(Employee[] employees){
        for (Employee e: employees) {
            System.out.println(e);
        }
    }

    public static Employee createNewFullTimeEmployee(){
        Scanner inputFullTimeID = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số ID của Fulltime Employee:");
        String id = inputFullTimeID.nextLine();

        Scanner inputFullTimeName = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tên của Fulltime Employee:");
        String name = inputFullTimeName.nextLine();

        Scanner inputFullTimeAge = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tuổi của Fulltime Employee:");
        int age = inputFullTimeAge.nextInt();

        Scanner inputFullTimePhoneNumber = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào Phone number của Fulltime Employee:");
        String phoneNumber = inputFullTimePhoneNumber.nextLine();

        Scanner inputFullTimeEmail = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào email của Fulltime Employee:");
        String email = inputFullTimeEmail.nextLine();

        Scanner inputFullTimeBonus = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số tiền thưởng của Fulltime Employee:");
        int bonus = inputFullTimeBonus.nextInt();

        Scanner inputFullTimeFineMoney = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số tiền phạt của Fulltime Employee:");
        int fineMoney = inputFullTimeFineMoney.nextInt();

        Scanner inputFullTimeBaseSalary = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số lương cứng của Fulltime Employee:");
        int baseSalary = inputFullTimeBaseSalary.nextInt();

        Employee newEmployee = new FulltimeEmployee(id, name, age, phoneNumber, email, bonus, fineMoney, baseSalary);
        return newEmployee;
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
