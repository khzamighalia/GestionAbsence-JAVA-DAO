/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Repositories;

import java.sql.SQLException;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;

/**
 *
 * @author Admin
 */
public interface AdminRepository {
    
    /**
     *
     * @param p
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public int addUser(Person p) throws SQLException, ClassNotFoundException;
}
