/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados;

import com.fullstack888.gestorempleados.DAO.HResourcesDAO;
import com.fullstack888.gestorempleados.domain.Employee;
import com.fullstack888.gestorempleados.domain.Ubication;
import com.fullstack888.gestorempleados.domain.User;
import com.fullstack888.gestorempleados.services.HResourcesService;
import com.fullstack888.gestorempleados.services.UserService;
import java.util.List;
import java.util.stream.Collectors;


public class Probatinas {
    
    public static void main(String[] args) {
        
       HResourcesService hr = new HResourcesService();
       hr.selectUbications().stream().forEach(ubi -> System.out.println(ubi.getName()));
       
 
    }
}
