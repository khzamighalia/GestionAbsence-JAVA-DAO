package youcodesafi.ma.handlingyoucodeabsencesystem;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Staff;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.PersonService;

public class PrimaryController implements Initializable {

    static PersonService personService = PersonService.getInstance();
    static Person person;
    static Staff staff;

    @FXML
    private TextField username_Input;
    @FXML
    private PasswordField password_Input;
    @FXML
    private Button primaryButton;
    @FXML
    private Label output_Errors;
    @FXML
    private ComboBox<Role> role_Type;

    @FXML
    private void switchToSecondary() throws IOException, SQLException {
//        App.setRoot("secondary");
        if (username_Input.getText().trim().isEmpty() || password_Input.getText().trim().isEmpty() || role_Type.getValue() == null) {
            output_Errors.setText("All Fields Are Required");
        } else {
            // Process Of The Authentication Goes Here
            person = personService.sign_InPersonBasedOnHisType(username_Input.getText(), password_Input.getText(), role_Type.getValue());
            if (person != null) {
                // code goes here 
                if (person.getRole().equals(Role.ADMINISTRATOR)) {
                    // REDIRECTION ADMINISTRATOR BOARD
                    System.out.println("Administrator_Board");
                    App.setRoot("CreationUser");
                } else if (person.getRole().equals(Role.STAFF)) {
                    // REDIRECTION STAFF BOARD
                    staff = (Staff) SecondaryController.staffService_.return_Staff(person);
                    System.out.println(staff.displayInfos());
                    if (staff.getIdType()== 2) {
                        System.out.println("Staff 2eme Annee _Board");
                        App.setRoot("secondary");
                    } else {
                        System.out.println("Staff 1er Annee _Board");
                        App.setRoot("secondary_Prime");
                    }
//                    System.out.println("Staff_Board");
//                    App.setRoot("secondary");
                } else if (person.getRole().equals(Role.SECRETARY)) {
                    // REDIRECTION APPRENANT BOARD
                    System.out.println("Secretary_Board");
                    App.setRoot("pageSecretaire");
                } else {
                    // REDIRECTION APPRENANT BOARD
                    System.out.println("Apprenant_Board");
                    App.setRoot("pageApprenant");
                }
            } else {
                System.out.println("No Person Was Found ::(( ");
                output_Errors.setText("No Person Was Found");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        role_Type.setItems(FXCollections.observableArrayList(Role.values()));
    }
}
