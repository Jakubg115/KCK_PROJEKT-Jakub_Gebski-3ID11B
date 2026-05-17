package com.swietlica.Frontend;


import com.swietlica.Frontend.Komponenty.ElementDoPokoji.ObiektGracz;
import com.swietlica.Frontend.Komponenty.ElementDoPokoji.ObiektPokoj;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Pokoje {

    private Stage glowny;
    private Scene powrot;

    @FXML
    private Label nazwaGry;
    @FXML
    private Button wroc;
    @FXML
    private ListView<ObiektPokoj> listaPokoji=new ListView<>();
    @FXML
    private ListView<ObiektGracz> listaGraczy=new ListView<>();

    public void przekazSceny(Stage stage){
        glowny=stage;
        powrot=glowny.getScene();
    }
    public void dodajpokoj(int ilosc) throws IOException {
        for(int i=0; i<ilosc; i++) {dodajObiekt(new ObiektPokoj(i+1,new Random().nextInt(2,5)));}
    }

    public void dodajgraczy(int ilosc) throws IOException {
        for(int i=0; i<ilosc; i++)
        {
            dodajGraczaDoListy(new ObiektGracz(ObiektGracz.DEFAULT,"Gracz"+(i+1),new Random().nextInt(2,51)));
        }
    }
    public void dodajObiekt(ObiektPokoj pokoj)
    {
        this.listaPokoji.getItems().add(pokoj);
    }
    public void dodajGraczaDoListy(ObiektGracz gracz){
        this.listaGraczy.getItems().add(gracz);
    }
    public void wrocDoGlownego(){glowny.setScene(powrot);}
    public void wstawTytul(String nazwa){nazwaGry.setText(nazwa);}

    private void komunikatON(Button but){but.setStyle(
            "-fx-background-color:white;"+
                    "-fx-text-fill:blue;");}

    private void komunikatOFF(Button but){but.setStyle(
            "-fx-background-color:blue;"
    );}

    public void wrocKomunikatON(){komunikatON(this.wroc);}
    public void wrocKomunikatOFF(){komunikatOFF(this.wroc);}

}
