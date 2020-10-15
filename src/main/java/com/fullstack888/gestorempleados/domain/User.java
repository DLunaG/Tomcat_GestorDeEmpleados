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
public class User {
    
    private int id;
    private String name;
    private String password;
    private boolean admin;
    
    public User(int id, String name, String password, boolean admin){
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin = admin;
    }
    
    public User(String name, String password, boolean admin){
        this.name = name;
        this.password = password;
        this.admin = admin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
