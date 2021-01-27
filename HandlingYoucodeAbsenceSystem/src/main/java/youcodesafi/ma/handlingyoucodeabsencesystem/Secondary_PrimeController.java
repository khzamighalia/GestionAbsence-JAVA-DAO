/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.ClassRoom;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Groupes;

/**
 * FXML Controller class
 *
 * @author Jamal-Jcyber
 */
public class Secondary_PrimeController implements Initializable {

    // SecondaryController.staffService_ ;
    LinkedList<ClassRoom> _Lists = new LinkedList<ClassRoom>();
    static ObservableList<ClassRoom> _Obs = FXCollections.observableArrayList();
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    static LinkedList<Apprenant> ApprenantsContents_ = new LinkedList<>();
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    LinkedList<Groupes> _ListsG = new LinkedList<Groupes>();
    static ObservableList<Groupes> _ObsG = FXCollections.observableArrayList();

    static ClassRoom classRoom_;
    static Apprenant apprenant_;

    @FXML
    private ComboBox<ClassRoom> lists_Classes;
    @FXML
    private Text current_User;
    @FXML
    private ComboBox<Groupes> lists_Groupes;
    @FXML
    private VBox lists_ApprenantsByCG;

    static Button app_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        current_User.setText(PrimaryController.person.getUsername());
        try {
            // TODO
            _Lists = SecondaryController.staffService_.get_ClassRoomsListsBasedOnTheStaff(PrimaryController.person.getIdPerson());
            _Lists.stream().forEach(classroom -> {
                classRoom_ = classroom;
                _Obs.add(classRoom_);
            });
            lists_Classes.setItems(_Obs);
            // ==========================
            _ListsG = SecondaryController.staffService_.getListsGroupes();
            _ListsG.stream().forEach(groupe -> {
                _ObsG.add(groupe);
            });
            lists_Groupes.setItems(_ObsG);
            // ==========================
        } catch (SQLException ex) {
            Logger.getLogger(Secondary_PrimeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSearchButton(ActionEvent event) throws SQLException {
        System.out.println(lists_Classes.getValue().getId_Class());
        System.out.println(lists_Groupes.getValue().getIdGroupe());
        ApprenantsContents_ = SecondaryController.staffService_.getListsApprenantByClassANDGroupes(lists_Classes.getValue().getId_Class(), (int) lists_Groupes.getValue().getIdGroupe());
        ApprenantsContents_.stream().forEach(apprenant -> {
            apprenant_ = apprenant;
            app_btn = new Button();
            app_btn.setId("" + apprenant_.getIdPerson());
            app_btn.setText(apprenant_.getFullname());

            app_btn.setOnAction((ActionEvent t) -> {
                try {
                    App.setRoot("details_");
                } catch (IOException ex) {
                    Logger.getLogger(Secondary_PrimeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            System.out.println(apprenant_.displayInfos());

        });
        lists_ApprenantsByCG.getChildren().clear();
        lists_ApprenantsByCG.getChildren().add(app_btn);
    }

}
