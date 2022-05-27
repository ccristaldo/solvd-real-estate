package model.apt;

import enums.Operation;
import enums.Zones;

import java.util.Objects;

public class AptAbstract {
    private Zones zone;
    private Operation operation;
    private String address;

    public AptAbstract(Zones zone, Operation operation, String address) {
        this.zone = zone;
        this.operation = operation;
        this.address = address;
    }

    public AptAbstract(){}

    public Zones getZone() {
        return zone;
    }

    public void setZone(Zones zone) {
        this.zone = zone;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "zone=" + zone +
                ", operation='" + operation + '\'' +
                ", address='" + address + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AptAbstract)) return false;
        AptAbstract that = (AptAbstract) o;
        return getZone() == that.getZone() && Objects.equals(getOperation(), that.getOperation()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZone(), getOperation(), getAddress());
    }
}
