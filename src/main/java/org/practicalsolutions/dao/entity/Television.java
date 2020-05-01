package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Television extends Product {

    private long id;
    private double screenDiagonal;
    private long id_category;

    public Television(){}

    public Television(String name, double price, String manufacturer, int yearOfManufacturer,
                      String category, double screenDiagonal) {
        super(name, price, manufacturer, yearOfManufacturer, category);
        this.screenDiagonal = screenDiagonal;
    }

    public Television(long id, String name, double price, String manufacturer, int yearOfManufacturer,
                      String category, long id1, double screenDiagonal, long id_category) {
        super(id, name, price, manufacturer, yearOfManufacturer, category);
        this.id = id1;
        this.screenDiagonal = screenDiagonal;
        this.id_category = id_category;
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

    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Television that = (Television) o;
        return id == that.id &&
                Double.compare(that.screenDiagonal, screenDiagonal) == 0 &&
                id_category == that.id_category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, screenDiagonal, id_category);
    }

    @Override
    public String toString() {
        return "Television{" +
                "id=" + id +
                ", screenDiagonal=" + screenDiagonal +
                ", id_category=" + id_category +
                '}';
    }
}
