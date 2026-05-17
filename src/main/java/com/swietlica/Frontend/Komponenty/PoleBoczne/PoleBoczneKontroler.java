package com.swietlica.Frontend.Komponenty.PoleBoczne;

import com.swietlica.Frontend.EkranGlowny;
import com.swietlica.Frontend.Komponenty.ElementDoPokoji.ObiektGracz;
import com.swietlica.Frontend.Pokoje;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PoleBoczneKontroler {

    @FXML
    private Button ustawienia,wylogujSie,zobaczProfil;
    @FXML
    private Label nazwaGracza;
    @FXML
    private ImageView profil;
    @FXML
    private ListView<String> listaZalogowanych=new ListView<>();
    @FXML
    private AnchorPane bocznyPanel;

    private EkranGlowny wskaznik;
    private Stage stage;

    @FXML
    public void wyborPrzelaczeniaKonta(MouseEvent event){

    }
    public void wejdzWProfil(ActionEvent actionEvent) {
    }

    public void wejdzWUstawienia(ActionEvent actionEvent) {
    }

    public void wylogowanie(ActionEvent actionEvent) {
    }

    public void przekazWskaznik(EkranGlowny wskaznik){this.wskaznik=wskaznik;}
    public void wstawNazwe(String nazwa){this.nazwaGracza.setText(nazwa);}
    public void wyjdzZPola(){this.wskaznik.wylaczPoleBoczne();}
    public void przekazStage(Stage st){this.stage=st;}
    public void probaWylaczenia(){
        this.wskaznik.wylaczPoleBoczne();
    }
    public void utworzRekord() {
        this.listaZalogowanych.getItems().add("asd");
    }

}
