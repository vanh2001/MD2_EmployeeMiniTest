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

    public static void main(String[] args) {
        Employee[] employees = new Employee[8];

        employees[0] = new FulltimeEmployee("FT01", "Kieu Minh Tuan", 35, "0364578989", "tuanBip@gmail.com", 3000000, 400000, 9000000);
        employees[1] = new FulltimeEmployee("FT02", "Vu Binh Giang", 20, "0364578915", "giangKoi@gmail.com", 4000000, 200000, 17000000);
        employees[2] = new FulltimeEmployee("FT03", "Le Van Luong", 45, "0364578922", "leLuong@gmail.com", 2000000, 600000, 15000000);
        employees[3] = new FulltimeEmployee("FT04", "Huynh Hieu Huy", 19, "0364578123", "huyGG@gmail.com", 0, 100000, 5000000);
        employees[4] = new FulltimeEmployee("FT05", "Tran Van Minh", 21, "0364578456", "minhMan@gmail.com", 0, 100000, 3000000);

        employees[5] = new ParttimeEmployee("PT01", "Vu Minh Hieu", 19, "0367879658", "hieucave@gmail.com", 40);
        employees[6] = new ParttimeEmployee("PT02", "Tran Thai Duong", 21, "0367573937", "DuongGym@gmail.com", 60);
        employees[7] = new ParttimeEmployee("PT03", "Nguyen Trung Duc", 33, "0361234569", "DucGay@gmail.com", 30);

        Employee a1  = new ParttimeEmployee("PT04", "To Viet Anh", 20, "0329605770", "anhviet1709@gmail.com", 30);
        employees = Method.addEmployee(employees,a1);

        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Hiển thị lương trung bình toàn bộ nhân viên");
            System.out.println("3. Hiển thụ nhân viên FullTime có lương thấp hơn trung bình toàn công ty");
            System.out.println("4. Hiển thị số lương phải trả cho nhân viên Part Time");
            System.out.println("5. Thứ tự nhân viên Full Time theo lương tăng dần");
            System.out.println("6. Thêm mới nhân viên Full Time");
            System.out.println("7. Thêm mới nhân viên Part Time");
            System.out.println("0. Exit!");
            System.out.println("Nhập lựa chọn: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    int count =0;
                    for (int i = 0; i < employees.length; i++) {
                        count++;
                    }
                    System.out.println("số lượng nhân viên có trong công ty là: " + count);

                    System.out.println("Danh sách nhân viên: ");
                    Method.displayEmployee(employees);
                    break;
                case 2:
                    System.out.println("Lương trung bình toàn bộ nhân viên là: " + Method.averageSalary(employees));
                    break;
                case 3:
                    System.out.println("Nhân viên Full Time có lương thấp hơn lương trung bình toàn công ty: ");
                    Method.displayLowerFTSalary(employees);
                    break;
                case 4:
                    System.out.println("Số lương phải trả cho nhân viên Part Time là: " + Method.sumSalaryforPT(employees));
                    break;
                case 5:
                    System.out.println("Thứ tự nhân viên Full Time theo lương tăng dần là: ");
                    Method.sortSalaryFL(employees);
                    break;
                case 6:
                    Method.addEmployee(employees, Method.createNewFullTimeEmployee());
                    break;
                case 7:
                    Method.addEmployee(employees, Method.createNewPartTimeEmployee());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chưa nhập lựa chọn!");
            }
        }
    }
}

