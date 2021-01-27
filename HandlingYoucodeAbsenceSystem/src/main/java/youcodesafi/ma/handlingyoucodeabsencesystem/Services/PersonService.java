/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import youcodesafi.ma.handlingyoucodeabsencesystem.Connection.Singleton;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Administrator;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Secretary;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Staff;
import youcodesafi.ma.handlingyoucodeabsencesystem.Repositories.PersonRepository;

/**
 *
 * @author Jamal-Jcyber
 */
public class PersonService implements PersonRepository {

    private static PersonService personService;

    public PersonService() {
    }

    public static PersonService getInstance() {
        if (personService == null) {
            personService = new PersonService();
        }
        return personService;
    }

    @Override
    public Person sign_InPersonBasedOnHisType(String matricule, String password, Role role) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Person person = null;
        try {
            connection = Singleton.getConnection();
            String query_Authentication = "SELECT p.idPerson, p.username, p.password, p.role FROM handlingyasvbetav2.person p where p.username =? and p.password=? and p.role=?";
            statement = connection.prepareStatement(query_Authentication);
            statement.setString(1, matricule);
            statement.setString(2, password);
            statement.setString(3, role.toString());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(2).equals(matricule) && resultSet.getString(3).equals(password) && resultSet.getString(4).equals(role.toString())) {
                    if (resultSet.getString(4).equals("ADMINISTRATOR")) {
                        person = new Administrator(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Role.valueOf(resultSet.getString(4)));
                    } else if (resultSet.getString(4).equals("STAFF")) {
                        person = new Staff(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Role.valueOf(resultSet.getString(4)));
                    } else if (resultSet.getString(4).equals("SECRETARY")) {
                        person = new Secretary(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Role.valueOf(resultSet.getString(4)));
                    } else {
                        person = new Apprenant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), Role.valueOf(resultSet.getString(4)));
                    }
                } else {
                    System.out.println("Username & Password & Role Incorrect :( ");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return person;
    }

}
