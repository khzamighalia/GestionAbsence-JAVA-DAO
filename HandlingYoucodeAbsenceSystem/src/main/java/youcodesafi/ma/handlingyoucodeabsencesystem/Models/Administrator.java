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
public class Administrator extends Person{

    public Administrator(long idPerson, String username, String password, Role role) {
        super(idPerson, username, password, role);
    }

    public Administrator(String fullname, String phone, String email, String username, String password, Role role) {
        super(fullname, phone, email, username, password, role);
    }
    
    

    @Override
    public String displayInfos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
