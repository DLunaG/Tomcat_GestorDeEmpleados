package com.fullstack888.gestorempleados.services;

import com.fullstack888.gestorempleados.DAO.HResourcesDAO;
import com.fullstack888.gestorempleados.domain.Employee;
import com.fullstack888.gestorempleados.domain.Ubication;
import java.util.List;

/**
 *
 * @author DLG
 */
public class HResourcesService {
    
    private HResourcesDAO hr;
    
    public HResourcesService(){
        this.hr = new HResourcesDAO();
    }
    
    //======== Employee services ========
    public List<Employee> selectEmployees(){
        return hr.selectEmployees();
    }
    
    public int insertAnEmployee(Employee e){
        return hr.insertAnEmployee(e);
    }
    
    public int editAnEmployee(Employee e, int id){
        return hr.editAnEmployee(e, id);
    }
    
    public int deleteAnEmployee(int id){
        return hr.deleteAnEmployee(id);
    }
    
    //========== Ubication services ===========
    
    public List<Ubication> selectUbications(){
        return hr.selectUbications();
    }
    
    public int insertAnUbication(Ubication u){
        return hr.insertAnUbication(u);
    }
    
    public int editAnUbication(Ubication u, int id){
        return hr.editAnUbication(u, id);
    }
    
    public int deleteAnUbication(int id){
        return hr.deleteAnUbication(id);
    }
    
    public String findNameUbication(int id){
        return hr.selectUbications()
                .stream()
                .filter(ubi -> ubi.getId() == id)
                .findFirst()
                .get()
                .getName();
    }
    
    public int findIdUbication(String ubiName){
        return hr.selectUbications()
                .stream()
                .filter(ubi -> ubi.getName().equals(ubiName))
                .findFirst()
                .get()
                .getId();
    }
}
