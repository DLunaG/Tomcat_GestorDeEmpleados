/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados;

import com.fullstack888.gestorempleados.DAO.HResourcesDAO;
import com.fullstack888.gestorempleados.domain.User;
import com.fullstack888.gestorempleados.services.UserService;
import java.util.List;
import java.util.stream.Collectors;


public class Probatinas {
    
    public static void main(String[] args) {
        
        UserService us = new UserService();
        String userName = "Admin";
        String password = "1234";
        List<User> usersVerified = us.selectUsers().stream()
                .filter(user -> userName.equals(user.getName()) && password.equals(user.getPassword()))
                .collect(Collectors.toList());
        
        for(User u: usersVerified){
            System.out.println(u.getName());
        }
    }
}
