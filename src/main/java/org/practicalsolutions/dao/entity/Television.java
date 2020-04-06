package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Television extends Product {

    private double screenDiagonal;

    public Television(){}

    public Television(long id, double price, String manufacturer, int year, double screenDiagonal) {
        super(id, price, manufacturer, year);
        this.screenDiagonal = screenDiagonal;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Television that = (Television) o;
        return Double.compare(that.screenDiagonal, screenDiagonal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenDiagonal);
    }

    @Override
    public String toString() {
        return "Television{" +
                "screenDiagonal=" + screenDiagonal +
                '}';
    }
}
