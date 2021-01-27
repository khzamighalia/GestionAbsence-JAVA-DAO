/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Models;

/**
 *
 * @author Jamal-Jcyber
 */
public class Speciality {

    private int id_Speciality;
    private String speciality_Title;

    public Speciality() {
    }

    public Speciality(int id_Speciality, String speciality_Title) {
        this.id_Speciality = id_Speciality;
        this.speciality_Title = speciality_Title;
    }

    public Speciality(String speciality_Title) {
        this.speciality_Title = speciality_Title;
    }

    public int getId_Speciality() {
        return id_Speciality;
    }

    public void setId_Speciality(int id_Speciality) {
        this.id_Speciality = id_Speciality;
    }

    public String getSpeciality_Title() {
        return speciality_Title;
    }

    public void setSpeciality_Title(String speciality_Title) {
        this.speciality_Title = speciality_Title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Speciality{id_Speciality=").append(id_Speciality);
        sb.append(", speciality_Title=").append(speciality_Title);
        sb.append('}');
        return sb.toString();
    }

}
