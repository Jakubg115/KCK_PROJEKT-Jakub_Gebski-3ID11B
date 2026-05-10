package com.swietlica.Frontend;


import com.swietlica.Frontend.Komponenty.ElementDoPokoji.ObiektPokoj;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Pokoje {

    private Stage glowny;
    private Scene powrot;
    private static int INDEKSPOKOJ,INDEKSGRACZ;

    @FXML
    private VBox listaPokoji, listaGraczy;

    public void zmienIndeksPokoju(int ind){INDEKSPOKOJ=ind;}
    public void zmienIndeksGracza(int ind){INDEKSGRACZ=ind;}

    public void przekazSceny(Stage stage){
        glowny=stage;
        powrot=glowny.getScene();
    }
    public void dodajpokoj(int ilosc, String[] lista) throws IOException {
        if(this.listaPokoji.getChildren().size()==1)
        {
            for(int i=0; i<ilosc; i++)
            {
                this.listaPokoji.getChildren().add(new ObiektPokoj(i,lista,this));
            }
        }

    }



    public void wrocDoGlownego(){glowny.setScene(powrot);}
}
