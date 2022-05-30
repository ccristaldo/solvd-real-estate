package model.employee;

import model.Person;

import java.util.Objects;

public class Employee extends Person {
    private int employeeId;
    private String branch;
    private boolean active = true;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int employeeId) {
        super(firstName, lastName);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", branch='" + branch + '\'' +
                ", active=" + active +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() && isActive() == employee.isActive() && Objects.equals(getBranch(), employee.getBranch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getBranch(), isActive());
    }
}
