package youcodesafi.ma.handlingyoucodeabsencesystem.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import youcodesafi.ma.handlingyoucodeabsencesystem.Connection.Singleton;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.AbsenceApprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Secretary;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Staff;
import youcodesafi.ma.handlingyoucodeabsencesystem.Repositories.SecretaireRepository;

public class SecretaireService implements SecretaireRepository {

    private static SecretaireService instance;

    public SecretaireService() {
    }

    public static SecretaireService getInstance() {
        if (instance == null) {
            instance = new SecretaireService();
        }
        return instance;
    }

    @Override
    public List<AbsenceApprenant> getAll(int idStaff) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String nomComplet = "";
        String titrePromo = "";
        Date date;
        int nombreH = 0;
        int idApps = 0;

        List<AbsenceApprenant> persons = new ArrayList<AbsenceApprenant>();

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT p.idPerson,p.fullname,pr.titlePromotion ,bp.Date_Absence , bp.Nbr_Hours FROM belongtopromotion bp ,person p ,promo pr WHERE pr.idPerson =" + idStaff + " AND p.idPerson=bp.Stu_idPerson AND bp.idPromo = pr.idPromo AND bp.Justification=false";
            statement = connection.prepareStatement(recupApp);
//            statement.setInt(1, idStaff);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                idApps = resultSet.getInt(1);
                nomComplet = resultSet.getString(2);
                titrePromo = resultSet.getString(3);
                date = resultSet.getDate(4);
                nombreH = resultSet.getInt(5);

                AbsenceApprenant p = new AbsenceApprenant(nomComplet, titrePromo, date, nombreH, idApps);
                persons.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public List<Person> getStaff() throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        int idPersonne;
        String nomComplet;
        String phone;
        String username;
        String email;
        String motDePasse;
        String role;

        List<Person> persons = new ArrayList<Person>();

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT p.idPerson, p.fullname FROM handlingyasvbetav2.staff stf inner join person p on stf.idPerson = p.idPerson";
            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                Person p = new Staff(resultSet.getInt(1), resultSet.getString(2));
                persons.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecretaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persons;
    }

    @Override
    public void justiferChecks(int id, Date date) {
        Connection connection = null;
        PreparedStatement statement = null;
//        ResultSet resultSet = null;

        try {
            connection = Singleton.getConnection();

            String absenceJusApp = "UPDATE belongtopromotion bp SET Justification = true WHERE bp.Stu_idPerson =? AND Date_Absence= ?";
            statement = connection.prepareStatement(absenceJusApp);
            statement.setInt(1, id);
            statement.setDate(2, (java.sql.Date) date);
            statement.executeUpdate();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecretaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public AbsenceApprenant getInfosSec(int sessionSec) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        AbsenceApprenant St = null;
        String nom = "";

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT p.fullname  FROM person p where p.idPerson=" + sessionSec;
            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                nom = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecretaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

        St = new AbsenceApprenant(nom);
        return St;
    }
    
        public int addSecretary(Secretary p) throws SQLException{
            Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        int id=0; 
        try {
            
            // check if the User Exists Or Not
            // code goes here :: 
            
            if (_isPersonExists(p.getEmail(), p.getUsername())) {
                System.out.println("Person is Already Exists :frowning: ");
            } else {
           
                connection = Singleton.getConnection();
                String query_POST = "INSERT INTO Person (fullname, phone, email,username,password,role) VALUES (?, ?, ?, ?, ?,?)";
                statement = connection.prepareStatement(query_POST,PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, p.getFullname());
                statement.setString(2, p.getPhone());
                statement.setString(3, p.getEmail());
                statement.setString(4, p.getUsername());
                statement.setString(5, p.getPassword());
                statement.setString(6, p.getRole().toString());
                state = statement.executeUpdate();
                ResultSet rs=statement.getGeneratedKeys();
                while(rs.next()) {
                id=rs.getInt(1); 
                }
                   
              
          
              if (p.getRole().toString().equals("SECRETARY")){
                    String query_POST2 = "INSERT INTO secretary (idPerson,Classes) VALUES (?,?)";
                    statement = connection.prepareCall(query_POST2);
                    statement.setInt(1, id);
                    statement.setString(2, p.getClasses());
                    state = statement.executeUpdate();
                   }
              
            
     
            }} catch (ClassNotFoundException | SQLException e) {
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

    @Override
    public int addSecretary(Apprenant p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
