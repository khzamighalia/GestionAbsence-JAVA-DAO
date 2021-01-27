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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jamal-Jcyber
 */
public class Details_Controller implements Initializable {

    private ObservableList<Integer> _Obs_ = FXCollections.observableArrayList(3, 7);

    @FXML
    private TextField current_ApprenantFullname;
    @FXML
    private TextField current_ApprenantC;
    @FXML
    private Label statusOutput;
    @FXML
    private ComboBox<Integer> hours;
    @FXML
    private TextField current_ApprenantG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hours.setItems(_Obs_);
        current_ApprenantFullname.setText(Secondary_PrimeController.apprenant_.getFullname());
        current_ApprenantC.setText(Secondary_PrimeController.apprenant_.getClass_ID());
        current_ApprenantG.setText(Secondary_PrimeController.apprenant_.getGroupe_ID());
    }

    @FXML
    private void handleAbsenceSaveButton(ActionEvent event) throws SQLException {
        System.out.println(hours.getSelectionModel().getSelectedItem());
        if (hours.getValue() == null) {
            System.out.println("Please Pick Up a Value Of How Many Hour That Person Have :) ");
        } else {
            int count = SecondaryController.staffService_.makeAbsenceByClassForOneSpecificApprenant(
                    (int) Secondary_PrimeController.apprenant_.getIdPerson(),
                    Secondary_PrimeController.apprenant_.getId_Class(),
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

    }

}
