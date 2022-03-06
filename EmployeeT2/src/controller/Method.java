package controller;

import model.Employee;
import model.FulltimeEmployee;
import model.ParttimeEmployee;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {

    public static void displayEmployee(Employee[] employees){
        if(employees.length == 0){
            System.out.println("Nothing to see here...");
        }else {
            for (Employee e: employees) {
                System.out.println(e);
            }
        }
    }

    public static Employee createNewFullTimeEmployee(){
        Scanner FullTimeID = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số ID của Fulltime Employee:");
        String id = FullTimeID.nextLine();
        Scanner FullTimeName = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tên của Fulltime Employee:");
        String name = FullTimeName.nextLine();
        Scanner FullTimeAge = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tuổi của Fulltime Employee:");
        int age = FullTimeAge.nextInt();
        Scanner FullTimePhoneNumber = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào Phone number của Fulltime Employee:");
        String phoneNumber = FullTimePhoneNumber.nextLine();
        Scanner FullTimeEmail = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào email của Fulltime Employee:");
        String email = FullTimeEmail.nextLine();
        Scanner FullTimeBonus = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số tiền thưởng của Fulltime Employee:");
        int bonus = FullTimeBonus.nextInt();
        Scanner FullTimeFineMoney = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số tiền phạt của Fulltime Employee:");
        int fineMoney = FullTimeFineMoney.nextInt();
        Scanner FullTimeBaseSalary = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số lương cứng của Fulltime Employee:");
        int baseSalary = FullTimeBaseSalary.nextInt();

        Employee newEmployee = new FulltimeEmployee(id, name, age, phoneNumber, email, bonus, fineMoney, baseSalary);
        return newEmployee;
    }

    public static Employee createNewPartTimeEmployee(){
        Scanner partTimeID = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số ID của Parttime Employee:");
        String id2 = partTimeID.nextLine();
        Scanner partTimeName = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tên của Parttime Employee:");
        String name2 = partTimeName.nextLine();
        Scanner partTimeAge = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào tuổi của Parttime Employee:");
        int age2 = partTimeAge.nextInt();
        Scanner partTimePhoneNumber = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào Phone number của Parttime Employee:");
        String phoneNumber2 = partTimePhoneNumber.nextLine();
        Scanner partTimeEmail = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào email của Parttime Employee:");
        String email2 = partTimeEmail.nextLine();
        Scanner partTimeWorkhour = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số giờ làm của Parttime Employee:");
        int workHour = partTimeWorkhour.nextInt();

        Employee newEmployee = new ParttimeEmployee(id2, name2, age2, phoneNumber2, email2, workHour);
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

    //Viết phương thức liệt kê danh sách nhân viên toàn thời gian
    // có mức lương thấp hơn mức lương trung bình của các nhân viên trong công ty.
    public static double averageSalary(Employee[] employees){
        double sum = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getNetSalary();
            count++;
        }
        double avg = sum / count;
        return avg;
    }
    public static void displayLowerFTSalary(Employee[] employees){
        int count= 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof FulltimeEmployee){
                if (employees[i].getNetSalary() < Method.averageSalary(employees)){
                    System.out.println(count + ". " + employees[i].getFullName());
                    count++;
                }
            }
        }
    }

//    Viết phương thức tính tổng số lương phải trả cho tất cả các nhân viên bán thời gian.
    public static double sumSalaryforPT (Employee[] employees){
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] instanceof ParttimeEmployee){
                sum += employees[i].getNetSalary();
                sum++;
            }
        }
        return sum;
    }

    //Viết phương thức sắp xếp nhân viên toàn thời gian theo số lương tăng dần.
    public static void sortSalaryFL (Employee[] employees){

    }
}
