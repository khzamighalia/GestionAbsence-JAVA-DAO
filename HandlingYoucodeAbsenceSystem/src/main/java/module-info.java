module youcodesafi.ma.handlingyoucodeabsencesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires mysql.connector.java;
//    requires jbcrypt;
//    requires jfoenix;

    opens youcodesafi.ma.handlingyoucodeabsencesystem to javafx.fxml;
    opens youcodesafi.ma.handlingyoucodeabsencesystem.Models to javafx.base ;
    exports youcodesafi.ma.handlingyoucodeabsencesystem;
}
