package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Phone extends Product {

    private double screenDiagonal;
    private double ram;//Random Access Memory
    private double internalMemory;//Computer Definition, flash memory

    public Phone(){}

    public Phone(long id, double price, String manufacturer, int year, double screenDiagonal) {
        super(id, price, manufacturer, year);
        this.screenDiagonal = screenDiagonal;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(double internalMemory) {
        this.internalMemory = internalMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Double.compare(phone.screenDiagonal, screenDiagonal) == 0 &&
                Double.compare(phone.ram, ram) == 0 &&
                Double.compare(phone.internalMemory, internalMemory) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenDiagonal, ram, internalMemory);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenDiagonal=" + screenDiagonal +
                ", ram=" + ram +
                ", internalMemory=" + internalMemory +
                '}';
    }
}
