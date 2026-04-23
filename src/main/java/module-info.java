module com.res.kurnikpl {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.res.kurnikpl to javafx.fxml;
    exports com.res.kurnikpl;
    exports com.res.kurnikpl.ekrany.Powitalny;
    opens com.res.kurnikpl.ekrany.Powitalny to javafx.fxml;
}