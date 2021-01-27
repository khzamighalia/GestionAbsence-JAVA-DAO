package youcodesafi.ma.handlingyoucodeabsencesystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.AbsenceApprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.SecretaireService;

public class PageSecretaire implements Initializable {

    @FXML
    private TableView<AbsenceApprenant> tableview;
    @FXML
    private TableColumn<AbsenceApprenant, String> nc_col;
    @FXML
    private TableColumn<AbsenceApprenant, String> pr_col;
    @FXML
    private TableColumn<AbsenceApprenant, Date> date_col;
    @FXML
    private TableColumn<AbsenceApprenant, Integer> nbrH_col;
    @FXML
    private TableColumn<AbsenceApprenant, String> just_col;

    @FXML
    private AnchorPane anchor1;
    @FXML
    private Label NomComplet;

    ObservableList<AbsenceApprenant> data = null;
    @FXML
    private Button BtnDec;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AbsenceApprenant SecInfos = SecretaireService.getInstance().getInfosSec((int) PrimaryController.person.getIdPerson());
        System.out.println(SecInfos.getNomComplet());

        AjouterBtnStaff();
        remplirInfos(SecInfos);
    }

    public void remplirInfos(AbsenceApprenant a) {
        NomComplet.setText(a.getNomComplet());
    }

    public void RemplissageTableView(int idStaff) {

        nc_col.setCellValueFactory(new PropertyValueFactory<AbsenceApprenant, String>("nomComplet"));
        pr_col.setCellValueFactory(new PropertyValueFactory<AbsenceApprenant, String>("titrePromo"));
        date_col.setCellValueFactory(new PropertyValueFactory<AbsenceApprenant, Date>("date"));
        nbrH_col.setCellValueFactory(new PropertyValueFactory<AbsenceApprenant, Integer>("nombreH"));
        just_col.setCellValueFactory(new PropertyValueFactory<AbsenceApprenant, String>("checkbox"));

        List<AbsenceApprenant> personnes = new ArrayList<>();
        try {
            personnes = SecretaireService.getInstance().getAll(idStaff);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        data = FXCollections.observableArrayList();

        for (AbsenceApprenant personne : personnes) {
            data.add(new AbsenceApprenant(personne.getNomComplet(), personne.getTitrePromo(), personne.getDate(), personne.getNombreH(), personne.getIdApp()));
        }

        if (data != null) {
            tableview.setItems(data);
            System.out.println(data.size());
        } else {
            System.out.println("Erreur data null");
        }
    }

    public void AjouterBtnStaff() {
        int x = 10;
        int y = 15;
        int i = 0;
        List<Person> staffs = new ArrayList<>();
        try {
            staffs = SecretaireService.getInstance().getStaff();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Person staff : staffs) {
            System.out.println(staff.displayInfos());
            i++;
            Button app1 = new Button();

            app1.setMinWidth(130);
            app1.setMinHeight(45);

            app1.setId("" + staff.getIdPerson());
            //System.out.println(staff.getSurnom());
            app1.setText(staff.getFullname());

            if (i % 4 == 0) {
                x = 10;
                y = 80;
            }

            app1.setLayoutY(y);
            app1.setLayoutX(x);
            System.out.println(staff.getFullname() + " " + i + " " + x + " " + y);
            x += 200;

            anchor1.getChildren().add(app1);

            app1.setOnAction(
                    new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    RemplissageTableView((int) staff.getIdPerson());
                }
            }
            );
        }
    }

    @FXML
    public void justiferChecks(ActionEvent actionEvent) {

        ObservableList<AbsenceApprenant> listCheckSelectionnes = FXCollections.observableArrayList();

        for (AbsenceApprenant checks : data) {
            if (checks.getCheckbox().isSelected()) {
                listCheckSelectionnes.add(checks);
            }
        }

        for (AbsenceApprenant listCheckSelectionne : listCheckSelectionnes) {
            int idAppA = (int) listCheckSelectionne.getIdApp();
            Date dateA = listCheckSelectionne.getDate();
            System.out.println(dateA + " " + idAppA);
            SecretaireService.getInstance().justiferChecks(idAppA, dateA);
            data.remove(listCheckSelectionne);
        }

    }

    @FXML
    public void deconnexion(ActionEvent actionEvent) {
        System.exit(1);
    }
}
