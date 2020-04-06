package org.practicalsolutions.dao.entity;

import java.util.Objects;

public class User {

    private long id;
    private String name;
    private boolean gender;
    private String email;
    private String password;
    private String address;
    private double balance;
    private double spend;

    public User(){}

    public User(long id, String name, boolean gender, String email, String password,
                String address, double balance, double spend) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
        this.balance = balance;
        this.spend = spend;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSpend() {
        return spend;
    }

    public void setSpend(double spend) {
        this.spend = spend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                gender == user.gender &&
                Double.compare(user.balance, balance) == 0 &&
                Double.compare(user.spend, spend) == 0 &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, email, password, address, balance, spend);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", spend=" + spend +
                '}';
    }

    public void reduceBalance(double price) {
        this.balance -= price;
        this.spend += price;
    }//Subtraction from balance and additive to spend
}
