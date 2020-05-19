package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Television extends Product {

    private double screenDiagonal;
    private long idCategory;

    public Television(){}

    public Television(long id, String name, double price, String manufacturer,
                      int yearOfManufacturer, String category, double screenDiagonal, long idCategory) {
        super(id, name, price, manufacturer, yearOfManufacturer, category);
        this.screenDiagonal = screenDiagonal;
        this.idCategory = idCategory;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
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
        Television that = (Television) o;
        return Double.compare(that.screenDiagonal, screenDiagonal) == 0 &&
                idCategory == that.idCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenDiagonal, idCategory);
    }

    @Override
    public String toString() {
        return "Television{" +
                "screenDiagonal=" + screenDiagonal +
                ", idCategory=" + idCategory +
                "} " + super.toString();
    }

    public static class Builder {
        private Television television;

        public Builder() {
            television = new Television();
        }

        public Builder setId(long id) {
            television.setId(id);
            return this;
        }

        public Builder setName(String name) {
            television.setName(name);
            return this;
        }

        public Builder setPrice(Double price) {
            television.setPrice(price);
            return this;
        }

        public Builder setManufacturer(String manufacturer) {
            television.setManufacturer(manufacturer);
            return this;
        }

        public Builder setYearOfManufacturer(int yearOfManufacturer) {
            television.setYearOfManufacturer(yearOfManufacturer);
            return this;
        }

        public Builder setCategory(String category) {
            television.setCategory(category);
            return this;
        }

        public Builder setScreenDiagonal(Double diagonal) {
            television.screenDiagonal = diagonal;
            return this;
        }

        public Builder setIdCategory(long idCategory) {
            television.idCategory = idCategory;
            return this;
        }

        public Product build() {
            return television;
        }

    }
}
