package com.fullstack888.gestorempleados.services;

import com.fullstack888.gestorempleados.DAO.UserDAO;
import com.fullstack888.gestorempleados.domain.User;
import java.util.List;

/**
 *
 * @author DLG
 */
public class UserService {
    
    UserDAO udao;
    
    public UserService(){
        this.udao = new UserDAO();
    }
    
    public List<User> selectUsers(){
        return udao.selectUsers();
    }
    
    public int insertAnUser(User u){
        return udao.insertAnUser(u);
    }
    
    public int deleteAnUser(int id){
        return udao.deleteAnUser(id);
    }
}
