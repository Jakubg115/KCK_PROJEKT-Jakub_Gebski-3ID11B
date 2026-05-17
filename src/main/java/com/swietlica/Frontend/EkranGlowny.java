package com.swietlica.Frontend;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import com.swietlica.Frontend.Komponenty.PoleBoczne.PoleBoczne;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;

public class EkranGlowny {

    @FXML
    private AnchorPane glownyEkran;
    @FXML
    private Label uzytkownik, iloscGraczy, nazwaGry ,opisGry;
    @FXML
    private ImageView profil, obrazGry;
    @FXML
    private TextField wyszukiwarka;
    @FXML
    private ListView<ObiektGra> lista=new ListView<>();
    @FXML
    private Button znajdzPokoj,jakGrac;
    @FXML
    private ScrollPane menuDoGry;

    private Stage kopia;
    private PoleBoczne boczne;

    public void przekazScene(Stage st){
        this.kopia=st;
    }

    public void inicjacja(String nazwa){
        uzytkownik.setText(nazwa);
        menuDoGry.setVisible(false);
        for (int i=0; i<10; i++){
            lista.getItems().add(new ObiektGra("Gra "+(i+1)));
        }
        inicjujBoczne();
        boczne.utworzPole(3);
        glownyEkran.widthProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                boczne.setLayoutX(glownyEkran.getWidth());
            }
        });

    }
    private void inicjujBoczne(){
        this.boczne=new PoleBoczne(this.uzytkownik.getText(),this.kopia,this);
        this.glownyEkran.getChildren().add(boczne);
        this.boczne.setLayoutX(this.glownyEkran.getWidth());
        AnchorPane.setBottomAnchor(this.boczne,0.0);
        AnchorPane.setTopAnchor(this.boczne,0.0);
    }

    public void odczytajObiekt(){
        if(lista.getSelectionModel().getSelectedIndex()!=-1)
        {
            menuDoGry.setVisible(true);
            this.nazwaGry.setText(lista.getSelectionModel().getSelectedItem().zwrocNazwe());
        }

    }

    private void pomocMenu(int indeks) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/Pomoc.fxml"));
        Stage pomoc=new Stage();
        Parent root=loader.load();

        pomoc.setScene(new Scene(root));
        Pomoc pom=loader.getController();
        pom.wstawStage(pomoc);
        pomoc.setTitle("Instrukcje oblugi gier");
        this.jakGrac.setDisable(true);
        pom.inicjuj(lista.getItems(),indeks);
        this.kopia.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                pom.dajStage().close();
            }
        });
        pom.dajStage().addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                jakGrac.setDisable(false);
            }
        });
        pomoc.show();
    }

    @FXML
    public void zalaczPomoc() throws IOException {
        pomocMenu(lista.getSelectionModel().getSelectedIndex());
    }

    @FXML
    public void inicjujPomocMenu() throws IOException {
        pomocMenu(-1);
    }

//    @FXML
//    public void cos(){
//        int rozmiar=lista.getChildren().size();
//        lista.getChildren().add(new ObiektGra(rozmiar,"Gra "+(rozmiar+1),this));
//    }

    @FXML
    public void otworzPokoj() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/Pokoje.fxml"));
        Parent root=loader.load();
        Pokoje pok=loader.getController();
        pok.przekazSceny(this.kopia);
        this.kopia.setScene(new Scene(root));
        ObiektGra s= lista.getSelectionModel().getSelectedItem();
        pok.wstawTytul(s.zwrocNazwe());
        pok.dodajpokoj(3);
        pok.dodajgraczy(5);
    }

    private void komunikatON(Button but){but.setStyle(
                    "-fx-background-color:white;"+
                    "-fx-text-fill:blue;");}

    private void komunikatOFF(Button but){but.setStyle(
            "-fx-background-color:blue;"
    );}

    @FXML
    public void onlineKomunikatON(){komunikatON(this.znajdzPokoj);}
    @FXML
    public void onlineKomunikatOFF(){komunikatOFF(this.znajdzPokoj);}
    @FXML
    public void jgKomunikatON(){komunikatON(this.jakGrac);}
    @FXML
    public void jgKomunikatOFF(){komunikatOFF(this.jakGrac);}


    @FXML
    public void listaUzytkownikow(){

    }
    @FXML
    public void wylogowanie(){

    }
    @FXML
    public void zakonczProgram(){
        this.kopia.close();
    }

    private void PoleBoczne(boolean flaga){
        TranslateTransition transition=new TranslateTransition(Duration.seconds(0.5),this.boczne);
        transition.setToX(this.boczne.getWidth()*(flaga?-1:1));
        transition.setInterpolator(flaga?Interpolator.EASE_OUT:Interpolator.EASE_IN);
        transition.play();
    }

    public void zalaczPoleBoczne() {
        PoleBoczne(true);
    }
    public void wylaczPoleBoczne(){PoleBoczne(false);}

    public void wyszukajGre(){
        
    }
}
