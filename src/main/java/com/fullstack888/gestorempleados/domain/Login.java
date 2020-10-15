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
public class Login {
    
    private User user;
    private boolean connected;
    
    public Login(User user, boolean connected){
        this.user = user;
        this.connected = connected;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    
}
