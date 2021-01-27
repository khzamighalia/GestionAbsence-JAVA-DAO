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
public class Referencial {

    private int id_Referencial;
    private String referencial_Title;

    public Referencial() {
    }

    public Referencial(String referencial_Title) {
        this.referencial_Title = referencial_Title;
    }

    public Referencial(int id_Referencial, String referencial_Title) {
        this.id_Referencial = id_Referencial;
        this.referencial_Title = referencial_Title;
    }

    public int getId_Referencial() {
        return id_Referencial;
    }

    public void setId_Referencial(int id_Referencial) {
        this.id_Referencial = id_Referencial;
    }

    public String getReferencial_Title() {
        return referencial_Title;
    }

    public void setReferencial_Title(String referencial_Title) {
        this.referencial_Title = referencial_Title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referencial{id_Referencial=").append(id_Referencial);
        sb.append(", referencial_Title=").append(referencial_Title);
        sb.append('}');
        return sb.toString();
    }
    
    
}
