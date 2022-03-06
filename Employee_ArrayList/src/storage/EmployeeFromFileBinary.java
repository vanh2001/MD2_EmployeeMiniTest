package storage;

import model.Employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeFromFileBinary implements IEmployeeData{

    @Override
    public ArrayList<Employee> readfile(ArrayList<Employee> employeeList) throws IOException{
        File file = new File("employee.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            employeeList = (ArrayList<Employee>) result;
            return employeeList;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            ois.close();
            fis.close();
        }
        return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<Employee> employeeList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("employee.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            oos.close();
            fos.close();
        }
    }
}
