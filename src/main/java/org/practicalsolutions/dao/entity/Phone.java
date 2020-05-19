package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Phone extends Product {

    private double screenDiagonal;
    private double ram;//Random Access Memory
    private double internalMemory;//Computer Definition, flash memory
    private long idCategory;

    public Phone(){}

    public Phone(long id, String name, double price, String manufacturer, int yearOfManufacturer,
                 String category, double screenDiagonal, double ram, double internalMemory, long idCategory) {
        super(id, name, price, manufacturer, yearOfManufacturer, category);
        this.screenDiagonal = screenDiagonal;
        this.ram = ram;
        this.internalMemory = internalMemory;
        this.idCategory = idCategory;
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
        return Double.compare(phone.screenDiagonal, screenDiagonal) == 0 &&
                Double.compare(phone.ram, ram) == 0 &&
                Double.compare(phone.internalMemory, internalMemory) == 0 &&
                idCategory == phone.idCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenDiagonal, ram, internalMemory, idCategory);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenDiagonal=" + screenDiagonal +
                ", ram=" + ram +
                ", internalMemory=" + internalMemory +
                ", idCategory=" + idCategory +
                "} " + super.toString();
    }

    public static class Builder {
        private Phone phone;

        public Builder() {
            phone = new Phone();
        }

        public Builder setId(long id) {
            phone.setId(id);
            return this;
        }

        public Builder setName(String name) {
            phone.setName(name);
            return this;
        }

        public Builder setPrice(Double price) {
            phone.setPrice(price);
            return this;
        }

        public Builder setManufacturer(String manufacturer) {
            phone.setManufacturer(manufacturer);
            return this;
        }

        public Builder setYearOfManufacturer(int yearOfManufacturer) {
            phone.setYearOfManufacturer(yearOfManufacturer);
            return this;
        }

        public Builder setCategory(String category) {
            phone.setCategory(category);
            return this;
        }

        public Builder setScreenDiagonal(Double diagonal) {
            phone.screenDiagonal = diagonal;
            return this;
        }

        public Builder setRam(Double ram) {
            phone.ram = ram;
            return this;
        }

        public Builder setInternalMemory(Double internalMemory) {
            phone.internalMemory = internalMemory;
            return this;
        }

        public Builder setIdCategory(long idCategory) {
            phone.idCategory = idCategory;
            return this;
        }

        public Product build() {
            return phone;
        }


    }
}
