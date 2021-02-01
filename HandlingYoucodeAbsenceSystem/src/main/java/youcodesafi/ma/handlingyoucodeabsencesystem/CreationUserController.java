/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Administrator;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Person;
import youcodesafi.ma.handlingyoucodeabsencesystem.Enums.Role;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Secretary;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Staff;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.AdminService;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.ApprenantService;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.SecretaireService;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.StaffService;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CreationUserController implements Initializable{

    @FXML
    private Label LabelGroup;
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
    private ComboBox<String> CGroup;
    
    @FXML
    private ComboBox<String> RoleCombo; 
     @FXML
    private Label CAnnee;

    @FXML
    private ComboBox<String> AnneeCombo1;
    
    @FXML
    private CheckBox Check1;

    @FXML
    private CheckBox Check2;
    
    @FXML
    private CheckBox Check3;

    @FXML
    private CheckBox Check4;
    @FXML
    private CheckBox Check5;

    @FXML
    private CheckBox Check6;
      @FXML
    private Label CClasses;



        
        @FXML
    void Select(ActionEvent event) {
        String s= RoleCombo.getSelectionModel().getSelectedItem();
        if(s.equals("APPRENANT")){
            CGroup.setVisible(true);
            LabelGroup.setVisible(true);
            Check1.setVisible(false);
            Check2.setVisible(false);
            Check3.setVisible(false);
            Check4.setVisible(false);
            Check5.setVisible(false);
            Check6.setVisible(false);
            CClasses.setVisible(false);
            CAnnee.setVisible(false);
            AnneeCombo1.setVisible(false);
            
        }
        else if(s.equals("STAFF")){
            CAnnee.setVisible(true);
            AnneeCombo1.setVisible(true);
            Check1.setVisible(false);
            Check2.setVisible(false);
            Check3.setVisible(false);
            Check4.setVisible(false);
            Check5.setVisible(false);
            Check6.setVisible(false);
            CClasses.setVisible(false);
            CGroup.setVisible(false);
            LabelGroup.setVisible(false);
            
        }
          else if(s.equals("SECRETARY")){
            Check1.setVisible(true);
            Check2.setVisible(true);
            Check3.setVisible(true);
            Check4.setVisible(true);
            Check5.setVisible(true);
            Check6.setVisible(true);
            CClasses.setVisible(true);
            CGroup.setVisible(false);
            LabelGroup.setVisible(false);
            CAnnee.setVisible(false);
            AnneeCombo1.setVisible(false);
            
        }
        else if(s.equals("ADMINISTRATOR")){
            Check1.setVisible(false);
            Check2.setVisible(false);
            Check3.setVisible(false);
            Check4.setVisible(false);
            Check5.setVisible(false);
            Check6.setVisible(false);
            CClasses.setVisible(false);
            CGroup.setVisible(false);
            LabelGroup.setVisible(false);
            CAnnee.setVisible(false);
            AnneeCombo1.setVisible(false);
            
        }

    }


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    RoleCombo.getItems().removeAll(RoleCombo.getItems());
    RoleCombo.getItems().addAll( "ADMINISTRATOR",
    "STAFF",
    "APPRENANT",
    "SECRETARY");
    
    AnneeCombo1.getItems().removeAll(AnneeCombo1.getItems());
    AnneeCombo1.getItems().addAll( "1ere année","2eme année");
    CGroup.getItems().removeAll(CGroup.getItems());
    CGroup.getItems().addAll( "A","B","C","D","E","F");
    }    

    private String CheckClasses(){
        String s="";
        if(Check1.isSelected()){
            s+=Check1.getText()+" ";
        }
        if(Check2.isSelected()){
            s+=Check2.getText()+" ";
        }
        if(Check3.isSelected()){
            s+=Check3.getText()+" ";
        }
        if(Check4.isSelected()){
            s+=Check4.getText()+" ";
        }
        if(Check5.isSelected()){
            s+=Check5.getText()+" ";
        }
        if(Check6.isSelected()){
            s+=Check6.getText()+" ";
        }
        
        return s;
    }
    @FXML
    private void AddUserEvent() throws ClassNotFoundException, SQLException {
     int i=0;
     String Cl=CheckClasses();
        AdminService as=AdminService.getInstance();
        ApprenantService aps=ApprenantService.getInstance();
        SecretaireService asec=SecretaireService.getInstance();
        StaffService ast=StaffService.getInstance();
        int annee=0;
        int classe=0;
        Person p=null; 
        Apprenant a=null;
        Secretary ss=null;
        Staff st=null;
        String r=RoleCombo.getValue();
        
      
        switch (r) {
            case "ADMINISTRATOR":{
                p=new Administrator(Cfullname.getText(),Cphone.getText(),Cemail.getText(),Cusername.getText(),Cpassword.getText(),Role.ADMINISTRATOR);
                i =as.addUser(p);
                break;}
            case "STAFF":{
                String Ann=AnneeCombo1.getValue();
                 if(Ann.equals("1ere année")){
            annee=1;
        }
        else if(Ann.equals("2eme année")){
            annee=2;
        }
                
                st=new Staff(Cfullname.getText(),Cphone.getText(),Cemail.getText(),Cusername.getText(),Cpassword.getText(),Role.STAFF,annee);
                i =ast.addStaff(st);
                break;}
            case "APPRENANT":{
                String CG=CGroup.getValue();
        switch (CG) {
            case "A":
                classe=1;
                break;
            case "B":
                classe=2;
                break;
            case "C":
                classe=3;
                break;
            case "D":
                classe=4;
                break;
            case "E":
                classe=5;
                break;
            case "F":
                classe=6;
                break;
            default:
                break;
        }
      
                a=new Apprenant(Cfullname.getText(),Cphone.getText(),Cemail.getText(),Cusername.getText(),Cpassword.getText(),Role.APPRENANT,classe);
                i =aps.addApprenant(a);
                break;}
            case "SECRETARY":{
                ss=new Secretary(Cfullname.getText(),Cphone.getText(),Cemail.getText(),Cusername.getText(),Cpassword.getText(),Role.SECRETARY,Cl);
                i =asec.addSecretary(ss);
                break;}
            default:
                break;
        }  
    
    if(i>0){
    System.out.println(" Data inserted successfully ");
    }
    else{
        System.out.println(" Data not inserted successfully ");
    }
    }
 
  
   
    
    
    
}
