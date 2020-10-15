/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados.domain;

/**
 *
 * @author tecnara
 */
public class Employee {
    
    private int id;
    private String name;
    private int ubicationId;
    private double salary;
    
    public Employee(int id, String name, int ubicationId, double salary){
        this.id = id;
        this.name = name;
        this.ubicationId = ubicationId;
        this.salary = salary;
    }
    
    public Employee(String name, int ubicationId, double salary){
        this.name = name;
        this.ubicationId = ubicationId;
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

    public int getUbicationId() {
        return ubicationId;
    }

    public void setUbicationId(int ubicationId) {
        this.ubicationId = ubicationId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
