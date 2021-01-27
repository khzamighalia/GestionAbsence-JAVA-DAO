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
public class Groupes {

    private long idGroupe;
    private String title_Groupe;

    public Groupes(long idGroupe, String title_Groupe) {
        this.idGroupe = idGroupe;
        this.title_Groupe = title_Groupe;
    }

    public Groupes(String title_Groupe) {
        this.title_Groupe = title_Groupe;
    }

    public long getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(long idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getTitle_Groupe() {
        return title_Groupe;
    }

    public void setTitle_Groupe(String title_Groupe) {
        this.title_Groupe = title_Groupe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Groupes{idGroupe=").append(idGroupe);
        sb.append(", title_Groupe=").append(title_Groupe);
        sb.append('}');
        return sb.toString();
    }

}
