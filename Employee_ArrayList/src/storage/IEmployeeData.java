package storage;

import model.Employee;

import java.io.IOException;
import java.util.ArrayList;

public interface IEmployeeData {
    ArrayList<Employee> readfile(ArrayList<Employee> employeeList) throws IOException;
    void writeFile(ArrayList<Employee> employeeList) throws IOException;
}
