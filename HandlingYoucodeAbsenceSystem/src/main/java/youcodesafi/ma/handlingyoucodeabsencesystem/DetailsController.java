/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jamal-Jcyber
 */
public class DetailsController implements Initializable {

    private ObservableList<Integer> _Obs_ = FXCollections.observableArrayList(3, 7);

    @FXML
    private TextField current_ApprenantFullname;
    @FXML
    private TextField current_ApprenantPromotion;

    @FXML
    private Label statusOutput;
    @FXML
    private ComboBox<Integer> hours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        hours.setItems(_Obs_);
        current_ApprenantFullname.setText(SecondaryController.currentLogged_Apprenant.getFullname());
        current_ApprenantPromotion.setText(SecondaryController.currentSelectedPromotion.getTitle_Promo());
        System.out.println(SecondaryController.currentLogged_Apprenant.displayInfos());
    }

    @FXML
    private void handleAbsenceSaveButton(ActionEvent event) throws SQLException {
        System.out.println(hours.getSelectionModel().getSelectedItem());
        if (hours.getValue() == null) {
            System.out.println("Please Pick Up a Value Of How Many Hour That Person Have :) ");
        } else {
            int count = SecondaryController.staffService_.makeAbsenceForOneSpecificApprenant(
                    (int) SecondaryController.currentLogged_Apprenant.getIdPerson(),
                    SecondaryController.currentSelectedPromotion.getId_Promo(),
                    hours.getSelectionModel().getSelectedItem());
            if (count > 0) {
                statusOutput.setText("Operation Passed Successfully");
            } else {
                statusOutput.setText("Operation != Passed Successfully :( :( :(");
            }

        }
    }

    @FXML
    private void handlePreviousOperation(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

}
