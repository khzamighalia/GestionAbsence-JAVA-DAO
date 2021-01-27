/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Repositories;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Jamal-Jcyber
 */
public interface SecretaryRepository {

    public int validateTheJustificationOfAnApprenant(int apprenant_ID, int promotion_ID, Date Date_Absence) throws SQLException;

}
