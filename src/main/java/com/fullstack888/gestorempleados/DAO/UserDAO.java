/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados.DAO;

import com.fullstack888.gestorempleados.domain.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tecnara
 */
public class UserDAO {
    
    Connection cn;
    
    public UserDAO(){
        
        try{
        Class.forName("org.postgresql.Driver");
        this.cn = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost/gestorempleados", "postgres", "1234");
        }catch(ClassNotFoundException ce){
            System.out.println("Class not found.");
        }catch(SQLException sqle){
            System.out.println("SQL ERROR: " + sqle.getMessage());
        }
    }
   
    public List<User> selectUsers(){
        List<User> users = new ArrayList<User>();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios ORDER BY id;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                String password = rs.getString("password");
                boolean admin = rs.getBoolean("admin");
                
                users.add(new User(id, name, password, admin));
            }
            st.close();           
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        
        return users;
    }

    
    public int insertAnUser(User u){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("INSERT INTO usuarios(nombre, password, admin) VALUES ('");
        sb.append(u.getName()).append("', '").append(u.getPassword()).append("', ")
                .append(u.isAdmin()).append(");");
        try{
        Statement st = cn.createStatement();
        result = st.executeUpdate(sb.toString());
        st.close();
        }catch(SQLException exc){
            System.out.println("SQL ERROR: " + exc.getMessage());
        }
        return result;
    }
    
//no se ha puesto un editAnUser(User u, int id)
    
    
    public int deleteAnUser(int id){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("DELETE FROM usuario WHERE id = ").append(id).append(";");
        try{
            Statement st = cn.createStatement();
            result = st.executeUpdate(sb.toString());
            st.close();
        }catch(SQLException e){
            System.out.println("SQL ERROR: " + e.getMessage());
        }
        return result;
    } 
    
    
}
