package com.res.kurnikpl;

import com.res.kurnikpl.ekrany.Powitalny.EkranPowitalny;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Inicjacja extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inicjacja.class.getResource("EkranPowitalny.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("[Nazwa Aplikacji]");
        stage.setScene(scene);
        stage.show();
        EkranPowitalny ek=fxmlLoader.getController();

    }
}
