module com.swietlica {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires com.google.gson;

    opens com.swietlica to javafx.fxml;
    exports com.swietlica;
    opens com.swietlica.Frontend to javafx.fxml;
    opens com.swietlica.Frontend.Komponenty.GraZListy to javafx.fxml;
    opens com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc to javafx.fxml;
    opens com.swietlica.Frontend.Komponenty.ElementDoPokoji to javafx.fxml;
}