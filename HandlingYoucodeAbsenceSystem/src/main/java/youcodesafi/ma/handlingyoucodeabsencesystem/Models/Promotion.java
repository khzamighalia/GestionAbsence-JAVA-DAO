/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Models;

import java.sql.Date;

/**
 *
 * @author Jamal-Jcyber
 */
public class Promotion {

    private int id_Promo;

    private int staff_ID;
    private int speciality_ID;
    private int type_ID;
    private int referencial_ID;
    private String title_Promo;
    private Date date_Creation;
    private Date date_Expiration;
    private String description;

    public Promotion(int id_Promo, String title_Promo) {
        this.id_Promo = id_Promo;
        this.title_Promo = title_Promo;
    }

    public int getId_Promo() {
        return id_Promo;
    }

    public void setId_Promo(int id_Promo) {
        this.id_Promo = id_Promo;
    }

    public int getStaff_ID() {
        return staff_ID;
    }

    public void setStaff_ID(int staff_ID) {
        this.staff_ID = staff_ID;
    }

    public int getSpeciality_ID() {
        return speciality_ID;
    }

    public void setSpeciality_ID(int speciality_ID) {
        this.speciality_ID = speciality_ID;
    }

    public int getType_ID() {
        return type_ID;
    }

    public void setType_ID(int type_ID) {
        this.type_ID = type_ID;
    }

    public int getReferencial_ID() {
        return referencial_ID;
    }

    public void setReferencial_ID(int referencial_ID) {
        this.referencial_ID = referencial_ID;
    }

    public String getTitle_Promo() {
        return title_Promo;
    }

    public void setTitle_Promo(String title_Promo) {
        this.title_Promo = title_Promo;
    }

    public Date getDate_Creation() {
        return date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        this.date_Creation = date_Creation;
    }

    public Date getDate_Expiration() {
        return date_Expiration;
    }

    public void setDate_Expiration(Date date_Expiration) {
        this.date_Expiration = date_Expiration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Promotion{id_Promo=").append(id_Promo);
        sb.append(", staff_ID=").append(staff_ID);
        sb.append(", speciality_ID=").append(speciality_ID);
        sb.append(", type_ID=").append(type_ID);
        sb.append(", referencial_ID=").append(referencial_ID);
        sb.append(", title_Promo=").append(title_Promo);
        sb.append(", date_Creation=").append(date_Creation);
        sb.append(", date_Expiration=").append(date_Expiration);
        sb.append(", description=").append(description);
        sb.append('}');
        return sb.toString();
    }

}
