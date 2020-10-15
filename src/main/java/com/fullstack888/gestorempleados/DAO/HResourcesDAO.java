/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullstack888.gestorempleados.DAO;

import com.fullstack888.gestorempleados.domain.Employee;
import com.fullstack888.gestorempleados.domain.Ubication;
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
public class HResourcesDAO {
    
    Connection cn;
    
    public HResourcesDAO(){
       
        try{
        Class.forName("org.postgresql.Driver");
        this.cn = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost/gestorempleados", "postgres", "1234");
            System.out.println("Clase encontrada");
        }catch(ClassNotFoundException ce){
            System.out.println("Class not found.");
        }catch(SQLException sqle){
            System.out.println("SQL ERROR: " + sqle.getMessage());
        }
    }
   
    //====== EMPLOYEE DAO =======
    
    
    
    public List<Employee> selectEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        
        try{
            Statement st = cn.createStatement();
            System.out.println("Statement creado");
            ResultSet rs = st.executeQuery("SELECT e.id, e.nombre, e.ub_id, u.nombre AS ubiNombre, e.salario FROM empleado AS e, ubicacion AS u WHERE e.ub_id = u.id ORDER BY e.id;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                int ubicationId = rs.getInt("ub_id");
                String ubiName = rs.getString("ubiNombre");
                double salary = rs.getDouble("salario");
                
                employees.add(new Employee(id, name, new Ubication(ubicationId, ubiName), salary));
            }
            st.close();           
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        
        return employees;
    }
    
    public int insertAnEmployee(Employee e){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("INSERT INTO empleado(nombre, ub_id, salario) VALUES ('");
        sb.append(e.getName()).append("', ").append(e.getUbication().getId()).append(", ")
                .append(e.getSalary()).append(");");
        try{
        Statement st = cn.createStatement();
        result = st.executeUpdate(sb.toString());
        st.close();
        }catch(SQLException exc){
            System.out.println("SQL ERROR: " + exc.getMessage());
        }
        return result;
    }
    
    public int editAnEmployee(Employee emp, int id){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("UPDATE empleado SET nombre='").append(emp.getName())
                .append("', ub_id=").append(emp.getUbication().getId())
                .append(", salario=").append(emp.getSalary())
                .append(" WHERE id=").append(id).append(";");
        try{
            Statement st = cn.createStatement();
            result = st.executeUpdate(sb.toString());
            st.close();
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        return result;
    }
    
    public int deleteAnEmployee(int id){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("DELETE FROM empleado WHERE id = ").append(id).append(";");
        try{
            Statement st = cn.createStatement();
            result = st.executeUpdate(sb.toString());
            st.close();
        }catch(SQLException e){
            System.out.println("SQL ERROR: " + e.getMessage());
        }
        return result;
    } 
    
    
    //======= UBICATION DAO =========
    
    public List<Ubication> selectUbications(){
        List<Ubication> ubications = new ArrayList<Ubication>();
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ubicacion ORDER BY id;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                
                ubications.add(new Ubication(id, name));
            }
            st.close();           
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        
        return ubications;
    }
    
    public int insertAnUbication(Ubication u){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("INSERT INTO ubicacion(nombre) VALUES ('");
        sb.append(u.getName()).append("');");
        try{
        Statement st = cn.createStatement();
        result = st.executeUpdate(sb.toString());
        st.close();
        }catch(SQLException e){
            System.out.println("SQL ERROR: " + e.getMessage());
        }
        return result;
    }
    
    public int editAnUbication(Ubication u, int id){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("UPDATE ubicacion SET nombre='").append(u.getName())
                .append("' WHERE id=").append(id).append(";");
        try{
            Statement st = cn.createStatement();
            result = st.executeUpdate(sb.toString());
            st.close();
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        return result;
    }
    
    public int deleteAnUbication(int id){
        StringBuilder sb = new StringBuilder();
        int result = -1;
        sb.append("DELETE FROM ubicacion WHERE id = ").append(id).append(";");
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
