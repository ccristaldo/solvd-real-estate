package model.apt;

import enums.Operation;
import enums.Zones;
import model.AptAbstract;

import java.util.Objects;

public class Apt extends AptAbstract {

    private double cost;
    private int dimension;
    private int rooms;
    private int id;
    private boolean active;

    public Apt(Zones zone, Operation operation, String address, double cost, int dimension, int rooms, int id, boolean active) {
        super(zone, operation, address);
        this.cost = cost;
        this.dimension = dimension;
        this.rooms = rooms;
        this.id = id;
        this.active = active;
    }

    public Apt() {}

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Apt{" +
                "cost=" + cost +
                ", dimension=" + dimension +
                ", rooms=" + rooms +
                ", id=" + id +
                ", active=" + active +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apt)) return false;
        if (!super.equals(o)) return false;
        Apt apt = (Apt) o;
        return Double.compare(apt.getCost(), getCost()) == 0 && getDimension() == apt.getDimension() && getRooms() == apt.getRooms() && getid() == apt.getid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCost(), getDimension(), getRooms(), getid());
    }
}
