package youcodesafi.ma.handlingyoucodeabsencesystem.Services;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import youcodesafi.ma.handlingyoucodeabsencesystem.Connection.Singleton;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.StatistiqueAbsence;
import youcodesafi.ma.handlingyoucodeabsencesystem.Repositories.ApprenantRepository;

public class ApprenantService implements  ApprenantRepository {

    private static ApprenantService instance;

    public ApprenantService() {
    }

    public static ApprenantService getInstance(){
        if (instance == null){
            instance = new ApprenantService();
        }
        return instance;
    }

    @Override
    public void pourcentageProgress(ProgressBar x, Label y, int pourcentage){
        double pourcent = ((double)pourcentage/35);
        DecimalFormat df = new DecimalFormat("00");
        x.setProgress(pourcent);
        y.setText(""+df.format(pourcent*100)+"%");
    }

    @Override
    public StatistiqueAbsence getAbsenceWeek(int sessionApp, int week){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        StatistiqueAbsence St;
        int heureAbsence=0;
        int heureDemiAbsence=0;
        int heureAbsenceTotale=0;
        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT SUM(bp.Nbr_Hours) from person p ,belongtopromotion bp where p.idPerson = bp.Stu_idPerson AND p.idPerson ="+sessionApp+" AND WEEK(bp.Date_Absence,3)="+week;
            //System.out.println(recupApp);
            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);
            while (resultSet.next()) {
                heureAbsenceTotale = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT SUM(bp.Nbr_Hours) from person p ,belongtopromotion bp where p.idPerson = bp.Stu_idPerson AND p.idPerson =1 AND bp.Nbr_Hours = 7 AND WEEK(bp.Date_Absence,3)="+week;
            //System.out.println(recupApp);
            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);
            while (resultSet.next()) {
                heureAbsence = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT SUM(bp.Nbr_Hours) from person p ,belongtopromotion bp where p.idPerson = bp.Stu_idPerson AND p.idPerson =1 AND bp.Nbr_Hours = 3 AND WEEK(bp.Date_Absence,3)="+week;
            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);
            while (resultSet.next()) {
                heureDemiAbsence = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }
        St = new StatistiqueAbsence(sessionApp,heureAbsence,heureAbsenceTotale,heureDemiAbsence);
        return St;
    }

    @Override
    public StatistiqueAbsence getAbsenceJustification(int Month,int sessionApp) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StatistiqueAbsence St;
        int absenceJus=0;
        int absenceNJus=0;
        int nombreAbsence=0;

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT Count(bp.Justification) from person p ,belongtopromotion bp where p.idPerson = bp.Stu_idPerson AND p.idPerson ="+sessionApp+"  AND Month(bp.Date_Absence)="+ Month;

            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                nombreAbsence = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT Count(bp.Justification) from person p ,belongtopromotion bp where p.idPerson = bp.Stu_idPerson AND p.idPerson ="+sessionApp+" AND bp.Justification = true  AND Month(bp.Date_Absence)="+ Month;

            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                absenceJus = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT Count(bp.Justification) from person p ,belongtopromotion bp where p.idPerson = bp.Stu_idPerson AND p.idPerson ="+sessionApp+" AND bp.Justification = false AND Month(bp.Date_Absence)="+ Month;

            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                absenceNJus = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }

        St = new StatistiqueAbsence(absenceJus,absenceNJus,nombreAbsence) ;
        return St;
    }

    @Override
    public StatistiqueAbsence getInfos(int sessionApp){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StatistiqueAbsence St;
        String nom = "";
        String promo = "";
        String referencielle = "";

        try {
            connection = Singleton.getConnection();
            String recupApp = "SELECT DISTINCT p.fullname , pro.titlePromotion , ref.referencialTitle FROM belongtopromotion bp , person p , promo pro , referencial ref where bp.idPromo = pro.idPromo AND bp.Stu_idPerson = p.idPerson AND pro.idReferencial = ref.idReferencial AND p.idPerson="+sessionApp;
            statement = connection.prepareStatement(recupApp);
            resultSet = statement.executeQuery(recupApp);

            while (resultSet.next()) {
                nom = resultSet.getString(1);
                promo= resultSet.getString(2);
                referencielle = resultSet.getString(3);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApprenantService.class.getName()).log(Level.SEVERE, null, ex);
        }

        St = new StatistiqueAbsence(nom,promo,referencielle) ;
        return St;
    }

}
