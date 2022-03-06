package model;

public class FulltimeEmployee extends Employee {
    private int bonus;
    private int fineMoney;
    private int baseSalary;

    @Override
    public double getNetSalary() {
        double result = baseSalary + (bonus - fineMoney);
        return result;
    }

    public FulltimeEmployee() {
    }

    public FulltimeEmployee(String employeeId, String fullName, int age, String phoneNumber, String email, int bonus, int fineMoney, int baseSalary) {
        super(employeeId, fullName, age, phoneNumber, email);
        this.bonus = bonus;
        this.fineMoney = fineMoney;
        this.baseSalary = baseSalary;
    }

    public FulltimeEmployee(int bonus, int fineMoney, int baseSalary) {
        this.bonus = bonus;
        this.fineMoney = fineMoney;
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFineMoney() {
        return fineMoney;
    }

    public void setFineMoney(int fineMoney) {
        this.fineMoney = fineMoney;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "FulltimeEmployee{" +
                "employeeId='" + getEmployeeId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", age=" + getAge() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", bonus=" + bonus +
                ", fineMoney=" + fineMoney +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
