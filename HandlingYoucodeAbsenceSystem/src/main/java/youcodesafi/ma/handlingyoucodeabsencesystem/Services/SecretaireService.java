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
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
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

}
