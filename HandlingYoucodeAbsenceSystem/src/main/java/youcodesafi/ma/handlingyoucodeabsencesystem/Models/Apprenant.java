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
public class Apprenant extends Person {

    private String groupe_Title;

    private String class_Title;

    private int id_Class;

    public Apprenant(long idPerson, String fullname) {
        super(idPerson, fullname);
    }

    public Apprenant(long idPerson, String username, String password, Role role) {
        super(idPerson, username, password, role);
    }

    public Apprenant(long idPerson, String fullname, String groupe_ID, String class_ID, int id_Class) {
        super(idPerson, fullname);
        this.groupe_Title = groupe_ID;
        this.class_Title = class_ID;
        this.id_Class = id_Class;
    }

    public String getGroupe_ID() {
        return groupe_Title;
    }

    public void setGroupe_ID(String groupe_ID) {
        this.groupe_Title = groupe_ID;
    }

    @Override
    public String toString() {
        return super.toString() + "Apprenant{" + "groupe_Title=" + groupe_Title + ", class_Title=" + class_Title + ", id_Class=" + id_Class + '}';
    }

    @Override
    public String displayInfos() {
        return toString();
    }

    public String getClass_ID() {
        return class_Title;
    }

    public void setClass_ID(String class_ID) {
        this.class_Title = class_ID;
    }

    public int getId_Class() {
        return id_Class;
    }

    public void setId_Class(int id_Class) {
        this.id_Class = id_Class;
    }

}
