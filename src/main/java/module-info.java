module ma.enset.gestion_consultations {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens ma.enset.gestion_consultations.Controllers to javafx.fxml;
    opens ma.enset.gestion_consultations.Entities to javafx.base;
    exports ma.enset.gestion_consultations;
}