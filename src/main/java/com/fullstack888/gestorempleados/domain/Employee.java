/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados.domain;

import java.io.Serializable;

/**
 *
 * @author tecnara
 */
public class Employee implements Serializable {
    
    private int id;
    private String name;
    private Ubication ubication;
    private double salary;
    
    public Employee(int id, String name, Ubication ubication, double salary){
        this.id = id;
        this.name = name;
        this.ubication = ubication;
        this.salary = salary;
    }
    
    public Employee(String name, Ubication ubication, double salary){
        this.name = name;
        this.ubication = ubication;
        this.salary = salary;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ubication getUbication() {
        return ubication;
    }

    public void setUbication(Ubication ubication) {
        this.ubication = ubication;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
