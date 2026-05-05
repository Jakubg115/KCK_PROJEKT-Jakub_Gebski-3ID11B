module com.swietlica {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.swietlica to javafx.fxml;
    exports com.swietlica;
    opens com.swietlica.Ekrany to javafx.fxml;
}