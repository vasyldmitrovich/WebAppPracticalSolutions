package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private double price;
    private String manufacturer;//A person or company that makes
    private int yearOfManufacturer;
    private String category;

    public Product(){}

    public Product(long id, String name, double price, String manufacturer,
                   int yearOfManufacturer, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.yearOfManufacturer = yearOfManufacturer;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getYearOfManufacturer() {
        return yearOfManufacturer;
    }

    public void setYearOfManufacturer(int yearOfManufacturer) {
        this.yearOfManufacturer = yearOfManufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                yearOfManufacturer == product.yearOfManufacturer &&
                Objects.equals(name, product.name) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, manufacturer, yearOfManufacturer, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacturer=" + yearOfManufacturer +
                ", category='" + category + '\'' +
                '}';
    }

    public double discountPrice(User user) {
        if (user.getSpend() < 3000) return price;
        if (user.getSpend() < 1000) return price*0.9;
        return price*0.8;
    }//Discount for user if he spend a certain amount money
}
