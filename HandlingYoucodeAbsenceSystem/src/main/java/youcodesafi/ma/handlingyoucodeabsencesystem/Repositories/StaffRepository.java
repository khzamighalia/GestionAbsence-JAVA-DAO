/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Repositories;

import java.sql.SQLException;
import java.util.LinkedList;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.ClassRoom;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Groupes;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Promotion;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Referencial;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Speciality;

/**
 *
 * @author Jamal-Jcyber
 */
public interface StaffRepository {

    // SECOND YEAR
    public LinkedList<Referencial> getListsReferencials() throws SQLException;

    public LinkedList<Speciality> getListsSpecialities() throws SQLException;

    public LinkedList<Promotion> getPromotionByReferencialOrBySpeciality(long search_Key1, long search_Key2) throws SQLException;

    // public LinkedList<Promotion> getPromotionBySpeciality(long speciality_ID) throws SQLException;
    public LinkedList<Apprenant> getListsApprenantByPromotion(long promotion_ID) throws SQLException;

    public int makeAbsenceForOneSpecificApprenant(int Stu_ID, int Promo_ID, int Nbr_Hours) throws SQLException;

    // FIRST YEAR
    public LinkedList<ClassRoom> get_ClassRoomsListsBasedOnTheStaff(long staff_ID) throws SQLException;

    public Person return_Staff(Person p) throws SQLException;
    
    public LinkedList<Apprenant> getListsApprenantByClassANDGroupes(long clssRoom_ID, int groupe_ID) throws SQLException;
    
    public LinkedList<Groupes> getListsGroupes() throws SQLException;
    
    public int makeAbsenceByClassForOneSpecificApprenant(int Stu_ID, int class_ID, int Nbr_Hours) throws SQLException;

}
