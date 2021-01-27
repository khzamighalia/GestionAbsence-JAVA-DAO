/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Administrator;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.AdminService;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CreationUserController implements Initializable {

    @FXML
    private Button CajouterBtn;
    @FXML
    private TextField Cfullname;
    @FXML
    private TextField Cphone;
    @FXML
    private TextField Cemail;
    @FXML
    private TextField Cusername;
    @FXML
    private TextField Cpassword;
    @FXML
    private TextField Crole;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void AddUserEvent() throws ClassNotFoundException, SQLException {
  
        AdminService as=AdminService.getInstance();
        Person p; 

    p = new Administrator(Cfullname.getText(),Cphone.getText(),Cemail.getText(),Cusername.getText(),Cpassword.getText(),Role.ADMINISTRATOR);
        
    int i =as.addUser(p);
    if(i>0){
    System.out.println(" Data inserted successfully ");
    }
    else{
        System.out.println(" Data not inserted successfully ");
    }
    }
    
    
    
}
