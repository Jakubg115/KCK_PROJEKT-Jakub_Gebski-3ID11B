package com.swietlica.Frontend;

import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;

public class EkranGlowny {

    public static int INDEKS=0;

    private Stage kopia;

    @FXML
    private Label uzytkownik, iloscGraczy, nazwaGry ,opisGry;
    @FXML
    private ImageView profil, obrazGry;
    @FXML
    private TextField wyszukiwarka;
    @FXML
    private VBox lista;

    public void przekazScene(Stage st){
        this.kopia=st;
    }

    public void inicjacja(String nazwa){
        this.uzytkownik.setText(nazwa);
        ArrayList<ObiektGra> gotowce=new ArrayList<>();
        for (int i=0; i<10; i++){
            gotowce.add(new ObiektGra(i,"Gra "+(i+1)));
            int finalI = i;
            gotowce.get(i).wstawHandler(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    INDEKS=gotowce.get(finalI).zwrocKontrolke().zwrocIndeks();
                }
            });
        }
        this.lista.getChildren().addAll(gotowce);


    }
    public ObiektGra PobierzDanaGre(int indeks){
        return (ObiektGra) this.lista.getChildren().get(indeks);
    }

    public void przeczytajWybranyIndeks(){
        this.nazwaGry.setText(PobierzDanaGre(INDEKS).zwrocKontrolke().zwrocNazwe());

    }

    @FXML
    public void zalaczPomoc() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/Pomoc.fxml"));
        Stage pomoc=new Stage();
        Parent root=loader.load();

        pomoc.setScene(new Scene(root));


        Pomoc pom=loader.getController();
        pom.inicjuj(pomoc);
        this.kopia.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                pom.dajStage().close();
            }
        });
        pomoc.show();
    }

}
