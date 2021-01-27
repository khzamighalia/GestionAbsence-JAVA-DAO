/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Repositories;

import java.sql.SQLException;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;

/**
 *
 * @author Jamal-Jcyber
 */
public interface PersonRepository {

    public Person sign_InPersonBasedOnHisType(String matricule, String password, Role role) throws SQLException;

}
