package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Product {

    private long id;
    private double price;
    private String manufacturer;//A person or company that makes
    private int year;

    public Product(){}

    public Product(long id, double price, String manufacturer, int year) {
        this.id = id;
        this.price = price;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                year == product.year &&
                Objects.equals(manufacturer, product.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, manufacturer, year);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }

    public double discountPrice(User user) {
        if (user.getSpend() < 3000) return price;
        if (user.getSpend() < 1000) return price*0.9;
        return price*0.8;
    }//Discount for user if he spend a certain amount money
}
