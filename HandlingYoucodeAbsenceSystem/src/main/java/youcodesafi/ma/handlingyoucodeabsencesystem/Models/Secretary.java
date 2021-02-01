/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Models;

import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;

/**
 *
 * @author Jamal-Jcyber
 */
public class Secretary extends Person {
    private String Classes;

    public Secretary(long idPerson, String username, String password, Role role) {
        super(idPerson, username, password, role);
    }
     public Secretary(String fullname, String phone, String email, String username, String password, Role role,String Classes) {
        super(fullname,phone,email,username,password,role);
        this.Classes=Classes;
    }

    @Override
    public String displayInfos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getClasses() {
        return Classes;
    }

    public void setClasses(String Classes) {
        this.Classes = Classes;
    }

}
