package com.swietlica.Frontend;


import com.swietlica.Frontend.Komponenty.ElementDoPokoji.ObiektGracz;
import com.swietlica.Frontend.Komponenty.ElementDoPokoji.ObiektPokoj;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Pokoje {

    private Stage glowny;
    private Scene powrot;
    private static int INDEKSPOKOJ,INDEKSGRACZ;

    @FXML
    private Label nazwaGry;
    @FXML
    private VBox listaPokoji, listaGraczy;
    @FXML
    private Button wroc;

    public void zmienIndeksPokoju(int ind){INDEKSPOKOJ=ind;}
    public void zmienIndeksGracza(int ind){INDEKSGRACZ=ind;}

    public void przekazSceny(Stage stage){
        glowny=stage;
        powrot=glowny.getScene();
    }
    public void dodajpokoj(int ilosc) throws IOException {
        if(this.listaPokoji.getChildren().size()==1) {
            for(int i=0; i<ilosc; i++) {listaPokoji.getChildren().add(new ObiektPokoj(i,new Random().nextInt(2,5),this));}
        }
    }

    public void dodajgraczy(int ilosc) throws IOException {
        for(int i=0; i<ilosc; i++)
        {
            listaGraczy.getChildren().add(new ObiektGracz(ObiektGracz.DEFAULT,"Gracz "+(i+1),new Random().nextInt(1,51),i,this));
        }
    }

    public void wrocDoGlownego(){glowny.setScene(powrot);}
    public void wstawTytul(String nazwa){nazwaGry.setText(nazwa);}
    public void zwrocIndeksPokoj(){System.out.println(INDEKSPOKOJ);}

    private void komunikatON(Button but){but.setStyle(
            "-fx-background-color:white;"+
                    "-fx-text-fill:blue;");}

    private void komunikatOFF(Button but){but.setStyle(
            "-fx-background-color:blue;"
    );}

    public void wrocKomunikatON(){komunikatON(this.wroc);}
    public void wrocKomunikatOFF(){komunikatOFF(this.wroc);}

}
