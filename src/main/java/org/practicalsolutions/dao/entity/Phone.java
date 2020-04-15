package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Phone extends Product {

    private long id;
    private double screenDiagonal;
    private double ram;//Random Access Memory
    private double internalMemory;//Computer Definition, flash memory
    private long idCategory;

    public Phone(){}

    public Phone(long id, String name, double price, String manufacturer,
                 int yearOfManufacturer, String category, long id1,
                 double screenDiagonal, double ram, double internalMemory, long idCategory) {
        super(id, name, price, manufacturer, yearOfManufacturer, category);
        this.id = id1;
        this.screenDiagonal = screenDiagonal;
        this.ram = ram;
        this.internalMemory = internalMemory;
        this.idCategory = idCategory;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
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

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return id == phone.id &&
                Double.compare(phone.screenDiagonal, screenDiagonal) == 0 &&
                Double.compare(phone.ram, ram) == 0 &&
                Double.compare(phone.internalMemory, internalMemory) == 0 &&
                idCategory == phone.idCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, screenDiagonal, ram, internalMemory, idCategory);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", screenDiagonal=" + screenDiagonal +
                ", ram=" + ram +
                ", internalMemory=" + internalMemory +
                ", idCategory=" + idCategory +
                '}';
    }
}
