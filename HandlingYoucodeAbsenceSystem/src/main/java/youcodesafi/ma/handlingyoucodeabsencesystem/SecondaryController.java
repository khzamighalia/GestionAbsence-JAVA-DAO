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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Apprenant;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Promotion;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Referencial;
import youcodesafi.ma.handlingyoucodeabsencesystem.Models.Speciality;
import youcodesafi.ma.handlingyoucodeabsencesystem.Services.StaffService;

/**
 * FXML Controller class
 *
 * @author Jamal-Jcyber
 */
public class SecondaryController implements Initializable {

    // ======== Calling The Stuff Service class that have all the logic ==============================
    static StaffService staffService_ = StaffService.getInstance();
    LinkedList<Referencial> _Contents = new LinkedList<Referencial>();
    ObservableList<String> _Obs = FXCollections.observableArrayList();
    // ===============================================================
    LinkedList<Speciality> __Contents = new LinkedList<Speciality>();
    ObservableList<String> _Obs_ = FXCollections.observableArrayList();
    // ===============================================================
    LinkedList<Promotion> PromotionContents_ = new LinkedList<>();

    private LinkedList<Apprenant> ApprenantsContents_ = new LinkedList<>();
    static Apprenant currentLogged_Apprenant;
    static Promotion currentSelectedPromotion;

    @FXML
    private ComboBox<String> referencial_Combo;
    @FXML
    private ComboBox<String> speciality_Combo;
    @FXML
    private Text current_User;

    static Button promo_btn;
    static Button apprenant_btn;
    @FXML
    private VBox vbContent;
    @FXML
    private Pane vContentApprenant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            current_User.setText(PrimaryController.person.getUsername());
            // =============================
            _Contents = staffService_.getListsReferencials();
            _Contents.forEach(referencial -> {
                System.out.println(referencial.toString());
                _Obs.add(referencial.getReferencial_Title());
            });
            referencial_Combo.setPromptText("Pick An Item From The List :)");
            referencial_Combo.setItems(_Obs);
            // =============================
            __Contents = staffService_.getListsSpecialities();
            __Contents.forEach(speciality -> {
                System.out.println(speciality.toString());
                _Obs_.add(speciality.getSpeciality_Title());
            });
            speciality_Combo.setPromptText("Pick An Item From The List :)");
            speciality_Combo.setItems(_Obs_);
            // =============================

            // =============================
        } catch (SQLException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLogOutButton(ActionEvent event) throws IOException {
        // make person to be null
        PrimaryController.person = null;
        App.setRoot("primary");
    }

    @FXML
    private void handleSearchButton(ActionEvent event) throws SQLException {
        System.out.println(referencial_Combo.getSelectionModel().getSelectedItem());
        System.out.println(referencial_Combo.getSelectionModel().getSelectedIndex() + 1);

        PromotionContents_ = staffService_.getPromotionByReferencialOrBySpeciality((long) referencial_Combo.getSelectionModel().getSelectedIndex() + 1, (long) speciality_Combo.getSelectionModel().getSelectedIndex() + 1);
        PromotionContents_.forEach(promotion -> {
            System.out.println(promotion.toString());
            promo_btn = new Button();
            promo_btn.setId("" + promotion.getId_Promo());
            promo_btn.setText(promotion.getTitle_Promo());

            promo_btn.setOnAction((ActionEvent t) -> {
                try {
                    currentSelectedPromotion = promotion;
                    ApprenantsContents_ = staffService_.getListsApprenantByPromotion(promotion.getId_Promo());
                    ApprenantsContents_.forEach(apprenant -> {
                        System.out.println(apprenant.displayInfos());
                        apprenant_btn = new Button();
                        apprenant_btn.setId("" + apprenant.getIdPerson());
                        apprenant_btn.setText(apprenant.getFullname());

                        apprenant_btn.setOnAction((ActionEvent t1) -> {
                            try {
                                currentLogged_Apprenant = apprenant;
                                App.setRoot("details");
                            } catch (IOException ex) {
                                Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
//                         vContentApprenant.getChildren().clear();
                        vContentApprenant.getChildren().add(apprenant_btn);
                    });

                } catch (SQLException ex) {
                    Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
//            vbContent.getChildren().clear();
            vbContent.getChildren().add(promo_btn);

        });
    }

}
