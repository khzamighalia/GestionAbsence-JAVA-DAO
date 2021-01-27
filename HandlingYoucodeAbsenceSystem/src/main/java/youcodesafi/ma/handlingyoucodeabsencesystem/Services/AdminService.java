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
import java.sql.Statement;
import java.util.logging.Level;
import youcodesafi.ma.handlingyoucodeabsencesystem.Connection.Singleton;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Repositories.AdminRepository;

/**
 *
 * @author Admin
 */
public class AdminService implements AdminRepository {
    
    private static AdminService instance;
    public AdminService(){
    }
    
    public static AdminService getInstance(){
        if(instance==null){
            instance = new AdminService();
        }
        return instance;
    }
    /**
     *
     * @param fullnamec
     * @param phonec
     * @param emailc
     * @param usernamec
     * @param passwordc
     * @param rolec
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    
   /* public int addUser(Person p) throws SQLException, ClassNotFoundException{
        
        
        
        
       	System.out.println("before");
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        //int id=0; 
        try {
            // check if the User Exists Or Not
            // code goes here :: 
            /*if (_isPersonExists(p.getEmail(), p.getMatricule())) {
                System.out.println("Person is Already Exists :frowning: ");
            } else {*/
        
       /* connection = Singleton.getConnection();
        String query_POST = "INSERT INTO Person (fullname, phone, email,username,password,role) VALUES (?, ?, ?, ?, ?,?)";
        statement = connection.prepareStatement(query_POST,PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, p.getFullname());
        statement.setString(2, p.getPhone());
        statement.setString(3, p.getEmail());
        statement.setString(4, p.getUsername());
        statement.setString(5,p.getPassword());
        statement.setString(6,p.getRole().toString());
        //statement.setString(6, p.getRole());*/
        
        //state = statement.executeUpdate();
        //ResultSet rs=statement.getGeneratedKeys();
        //id=rs.getInt(1);     
              /*  if(p.getRole().toString().equals("Administrator")){
                    String query_POST2 = "INSERT INTO Administrator (idPerson) VALUES (?)";
                    statement = connection.prepareCall(query_POST2);
                    statement.setInt(1, id);
                    state = statement.executeUpdate();
                   }
                else if (p.getRole().toString().equals("STAFF")){
                    String query_POST2 = "INSERT INTO Administrator (idPerson) VALUES (?)";
                    statement = connection.prepareCall(query_POST2);
                    statement.setInt(1, id);
                    state = statement.executeUpdate();
                   }
                else if (p.getRole().toString().equals("APPRENANT")){
                    String query_POST2 = "INSERT INTO Apprenant (idPerson,dGroup) VALUES (?,?)";
                    statement = connection.prepareCall(query_POST2);
                    statement.setInt(1, id);
                    statement.setInt(2,1);
                    state = statement.executeUpdate();
                   }
                else if (p.getRole().toString().equals("SECRETARY")){
                    String query_POST2 = "INSERT INTO Secretary (idPerson) VALUES (?)";
                    statement = connection.prepareCall(query_POST2);
                    statement.setInt(1, id);
                    state = statement.executeUpdate();
                   }
            */
      /*  } catch (ClassNotFoundException | SQLException e) {
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return state;
		
    }*/
    
    @Override
    public int addUser(Person p) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {
            
            // check if the User Exists Or Not
            // code goes here :: 
            
            if (_isPersonExists(p.getEmail(), p.getUsername())) {
                System.out.println("Person is Already Exists :frowning: ");
            } else {
           
                connection = Singleton.getConnection();
                String query_POST = "INSERT INTO Person (fullname, phone, email,username,password,role) VALUES (?, ?, ?, ?, ?,?)";
                statement = connection.prepareCall(query_POST);
                statement.setString(1, p.getFullname());
                statement.setString(2, p.getPhone());
                statement.setString(3, p.getEmail());
                statement.setString(4, p.getUsername());
                statement.setString(5, p.getPassword());
                statement.setString(6, p.getRole().toString());
                state = statement.executeUpdate();
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
        }
        return state;
    }
    
    private boolean _isPersonExists(String email, String matricule) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exist = false;
          
        try {
              
            connection = Singleton.getConnection();
            String query_CHECK = "SELECT * FROM Person WHERE email=? OR username=?";
            statement = connection.prepareStatement(query_CHECK);
            statement.setString(1, email);
            statement.setString(2, matricule);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(4).equals(email)) {
                    System.out.println("Email Already Exists ");
                    exist = true;
                }
                if (resultSet.getString(5).equals(matricule)) {
                    System.out.println("Username Already Exists ");
                    exist = true;
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
        return exist;
    }
    
}
