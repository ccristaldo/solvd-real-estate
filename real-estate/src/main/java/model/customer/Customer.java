package model.customer;

import model.Person;

import java.util.Objects;

public class Customer extends Person {
    private double avalaibleAmount;
    private String tel;
    private int id;

    public Customer() {}

    public Customer(String firstName, String lastName, double avalaibleAmount, String tel, int id) {
        super(firstName, lastName);
        this.avalaibleAmount = avalaibleAmount;
        this.tel = tel;
        this.id = id;
    }

    public double getAvalaibleAmount() {
        return avalaibleAmount;
    }

    public void setAvalaibleAmount(double avalaibleAmount) {
        this.avalaibleAmount = avalaibleAmount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "avalaibleAmount=" + avalaibleAmount +
                ", tel='" + tel + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() && Objects.equals(getTel(), customer.getTel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTel(), getId());
    }
}
