package youcodesafi.ma.handlingyoucodeabsencesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.StatistiqueAbsence;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.ApprenantService;


public class PageApprenant implements Initializable {
    @FXML
    ProgressIndicator progGlo1;
    @FXML
    ProgressIndicator progGlo2;

    @FXML
    ProgressBar progA1;
    @FXML
    ProgressBar progA2;
    @FXML
    ProgressBar progA3;
    @FXML
    ProgressBar progA4;
    @FXML
    ProgressBar progP1;
    @FXML
    ProgressBar progP2;
    @FXML
    ProgressBar progP3;
    @FXML
    ProgressBar progP4;


    @FXML
    Label LabelA1;
    @FXML
    Label LabelP1;
    @FXML
    Label LabelA2;
    @FXML
    Label LabelP2;
    @FXML
    Label LabelA3;
    @FXML
    Label LabelP3;
    @FXML
    Label LabelA4;
    @FXML
    Label LabelP4;
    @FXML
    Label NomComplet;
    @FXML
    Label Promo;
    @FXML
    Label REFRENCE;
    @FXML
    Button  BtnA1;
    @FXML
    Button  BtnR1;
    @FXML
    Button  BtnAT1;
    @FXML
    Button  BtnA2;
    @FXML
    Button  BtnR2;
    @FXML
    Button  BtnAT2;
    @FXML
    Button  BtnA3;
    @FXML
    Button  BtnR3;
    @FXML
    Button  BtnAT3;
    @FXML
    Button  BtnA4;
    @FXML
    Button  BtnR4;
    @FXML
    Button  BtnAT4;
    @FXML
    Button  BtnJus;
    @FXML
    Button  BtnNJus;
    @FXML
    Button  BtnAbsence;
    @FXML
    AnchorPane anchor1;
    @FXML
    private Button BtnDec;
    @FXML
    private Button Btn10;
    @FXML
    private Button Btn11;
    @FXML
    private Button Btn1;
    @FXML
    private Button Btn12;
    @FXML
    private Button Btn2;
    @FXML
    private Button Btn3;
    @FXML
    private Button Btn4;
    @FXML
    private Button Btn5;
    @FXML
    private Button Btn6;
    @FXML
    private Button Btn7;
    @FXML
    private Button red;
    @FXML
    private Button yellow;
    @FXML
    private Button orange;
    @FXML
    private Button green;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StatistiqueAbsence AppInfos = ApprenantService.getInstance().getInfos((int) PrimaryController.person.getIdPerson());
        remplirInfos(AppInfos);

    }

    public void remplirInfos(StatistiqueAbsence s){

        NomComplet.setText(s.getNom());
        Promo.setText(s.getPromo());
        REFRENCE.setText(s.getReferencielle());

    }
    public void viderProgress(){
        progA1.setProgress(0);
        progA2.setProgress(0);
        progA3.setProgress(0);
        progA4.setProgress(0);
        progP1.setProgress(0);
        progP2.setProgress(0);
        progP3.setProgress(0);
        progP4.setProgress(0);
        BtnA1.setText("");
        BtnA2.setText("");
        BtnA3.setText("");
        BtnA4.setText("");
        BtnR1.setText("");
        BtnR2.setText("");
        BtnR3.setText("");
        BtnR4.setText("");
        BtnAT1.setText("");
        BtnAT2.setText("");
        BtnAT3.setText("");
        BtnAT4.setText("");
        progGlo1.setProgress(0);
        progGlo2.setProgress(0);

        LabelA1.setText("");
        LabelA2.setText("");
        LabelA3.setText("");
        LabelA4.setText("");
        LabelP1.setText("");
        LabelP2.setText("");
        LabelP3.setText("");
        LabelP4.setText("");


    }

    public void remplissageWeek(StatistiqueAbsence s,int n){
        if(n==0){
            BtnA1.setText(""+s.getHeureAbsence()+"H/35H");
            BtnR1.setText(""+s.getHeureDemiAbsence()+"H/35H");
            BtnAT1.setText(""+s.getHeureAbsenceTotale()+"H/35H");
            ApprenantService.getInstance().pourcentageProgress(progA1,LabelA1,s.getHeureAbsenceTotale());
            ApprenantService.getInstance().pourcentageProgress(progP1,LabelP1,35-s.getHeureAbsenceTotale());
        }
        switch(n) {
            case 0:
                BtnA1.setText("" + s.getHeureAbsence() + "H/35H");
                BtnR1.setText("" + s.getHeureDemiAbsence() + "H/35H");
                BtnAT1.setText("" + s.getHeureAbsenceTotale() + "H/35H");
                ApprenantService.getInstance().pourcentageProgress(progA1, LabelA1, s.getHeureAbsenceTotale());
                ApprenantService.getInstance().pourcentageProgress(progP1, LabelP1, 35 - s.getHeureAbsenceTotale());
                break;
            case 1:
                BtnA2.setText("" + s.getHeureAbsence() + "H/35H");
                BtnR2.setText("" + s.getHeureDemiAbsence() + "H/35H");
                BtnAT2.setText("" + s.getHeureAbsenceTotale() + "H/35H");
                ApprenantService.getInstance().pourcentageProgress(progA2, LabelA2, s.getHeureAbsenceTotale());
                ApprenantService.getInstance().pourcentageProgress(progP2, LabelP2, 35 - s.getHeureAbsenceTotale());
            case 2:
                BtnA3.setText("" + s.getHeureAbsence() + "H/35H");
                BtnR3.setText("" + s.getHeureDemiAbsence() + "H/35H");
                BtnAT3.setText("" + s.getHeureAbsenceTotale() + "H/35H");
                ApprenantService.getInstance().pourcentageProgress(progA3, LabelA3, s.getHeureAbsenceTotale());
                ApprenantService.getInstance().pourcentageProgress(progP3, LabelP3, 35 - s.getHeureAbsenceTotale());
                break;
            case 3:
                BtnA4.setText("" + s.getHeureAbsence() + "H/35H");
                BtnR4.setText("" + s.getHeureDemiAbsence() + "H/35H");
                BtnAT4.setText("" + s.getHeureAbsenceTotale() + "H/35H");
                ApprenantService.getInstance().pourcentageProgress(progA4, LabelA4, s.getHeureAbsenceTotale());
                ApprenantService.getInstance().pourcentageProgress(progP4, LabelP4, 35 - s.getHeureAbsenceTotale());
                break;
        }

  }

    public void remplissageProgressIndic(StatistiqueAbsence s){

        double pourcentageJus = 0 ;
        double pourcentageNJus = 0;

        pourcentageJus = (double) s.getAbsenceJus() / s.getNombreAbsence();
        pourcentageNJus = (double) s.getAbsenceNonJus() / s.getNombreAbsence();
        progGlo1.setProgress(pourcentageJus);
        progGlo2.setProgress(pourcentageNJus);
        BtnJus.setText(""+s.getAbsenceJus());
        BtnNJus.setText(""+s.getAbsenceNonJus());
        BtnAbsence.setText(""+s.getNombreAbsence());

    }


    @FXML
    public void ClickJan(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;

        for(int i = 1;i<=4;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(1,1);
        remplissageProgressIndic(Sb);

    }

    @FXML
    public void ClickFev(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 5;i<=8;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(2,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickMars(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 9;i<=12;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(4,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickAvr(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 13;i<=16;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(4,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickMai(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 17;i<=20;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(5,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickJuin(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 21;i<=24;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(6,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickJuillet(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 25;i<=28;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(7,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickOct(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 41;i<=44;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(10,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickNov(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 45;i<=48;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(11,1);
        remplissageProgressIndic(Sb);
    }

    @FXML
    public void ClickDec(ActionEvent actionEvent) {
        anchor1.setVisible(true);
        viderProgress();
        ArrayList<StatistiqueAbsence> listStatisticWeek = (new ArrayList<StatistiqueAbsence>());
        StatistiqueAbsence  Sa =null;
        StatistiqueAbsence  Sb =null;
        for(int i = 49;i<=52;i++){
            Sa= ApprenantService.getInstance().getAbsenceWeek(1, i);
            listStatisticWeek.add(Sa);
        }
        for(int i = 0;i<4;i++){
            remplissageWeek(listStatisticWeek.get(i), i);
        }
        Sb = ApprenantService.getInstance().getAbsenceJustification(12,1);
        remplissageProgressIndic(Sb);

    }


    @FXML
    public void deconnexion(ActionEvent actionEvent) {
        System.exit(1);

    }
}
