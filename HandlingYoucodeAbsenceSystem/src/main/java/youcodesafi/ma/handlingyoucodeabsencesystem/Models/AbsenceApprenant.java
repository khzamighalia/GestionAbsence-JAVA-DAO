/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Models;

import javafx.scene.control.CheckBox;

import java.util.Date;

/**
 *
 * @author Jamal-Jcyber
 */
public class AbsenceApprenant {

    private String nomComplet ;
    private String titrePromo ;
    private Date date ;
    private int nombreH ;
    private CheckBox checkbox;
    private int idApp;




    public AbsenceApprenant(String nomComplet, String titrePromo, Date date, int nombreH,int id) {
        this.idApp= id;
        this.nomComplet = nomComplet;
        this.titrePromo = titrePromo;
        this.date = date;
        this.nombreH = nombreH;
        this.checkbox = new CheckBox();
    }

    public AbsenceApprenant(String nomComplet) {
        this.nomComplet = nomComplet;
    }



    public int getIdApp() {
        return idApp;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getTitrePromo() {
        return titrePromo;
    }

    public void setTitrePromo(String titrePromo) {
        this.titrePromo = titrePromo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNombreH() {
        return nombreH;
    }

    public void setNombreH(int nombreH) {
        this.nombreH = nombreH;
    }

    public void setCheckbox(CheckBox checkbox) {
        this.checkbox = checkbox;
    }

    public CheckBox getCheckbox() {
        return checkbox;
    }
}
