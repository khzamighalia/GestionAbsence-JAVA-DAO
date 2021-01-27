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
public class Staff extends Person {

    private int idType;

    public Staff(long idPerson, String username, String password, Role role) {
        super(idPerson, username, password, role);
    }

    public Staff(long idPerson, String username, String password, Role role, int idType) {
        super(idPerson, username, password, role);
        this.idType = idType;
    }

    public Staff(long idPerson, String fullname, String phone, String email, String username, String password, Role role) {
        super(idPerson, fullname, phone, email, username, password, role);
    }

    public Staff(long idPerson, String fullname) {
        super(idPerson, fullname);
    }
    
    

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return super.toString() + "Staff{" + "idType=" + idType + '}';
    }

    @Override
    public String displayInfos() {
        return toString();
    }
}
