package com.example.startservlet.logic;

public class User {
    String name;
    String surname;
    Double salary;

    public String getName() {
        return name;
    }

    public String getFam() {
        return surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFam(String surname) {
        this.surname = surname;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public User(String name, String surname, Double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }
}
