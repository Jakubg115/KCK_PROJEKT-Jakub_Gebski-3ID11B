package com.swietlica.Frontend.Komponenty.ElementDoPokoji;

import com.swietlica.Frontend.Pokoje;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ObiektPokojKontroller {

    private int indeks;
    private Pokoje wskaznik;

    private int rozmiar;

    @FXML
    private Label idPokoju, postepPokoju;
    @FXML
    private GridPane panel;

    private ArrayList<Label> listagraczy=new ArrayList<>();

    public void przekazWskaznik(Pokoje wsk){wskaznik=wsk;}
    public void wstawindeks(int ind){this.indeks=ind+1; this.idPokoju.setText("#"+this.indeks);}

    public void ustawRozmiarPokoju(int rozmiar){
        for(int i=0; i<rozmiar; i++){
            wstawGracza();
            this.panel.add(zwrocGracza(i),1,i);
            GridPane.setHalignment(zwrocGracza(i),HPos.CENTER);
        }
        this.rozmiar=rozmiar;
    }

    public Label zwrocGracza(int indeks){
        return this.listagraczy.get(indeks);
    }
    public void wstawGracza(){this.listagraczy.add(new Label("-"));}
    public void wstawGracza(String gracz){this.listagraczy.add(new Label(gracz));}
    private boolean czyListaPelna(){
        boolean flaga=true;
        for(int i=0; i<this.rozmiar; i++){
            if(zwrocGracza(i).getText().equals("-")) flaga=false;
        }
        return flaga;
    }

    public void inicjuj(){
        this.postepPokoju.setText(czyListaPelna()?"W grze":"W oczekiwaniu");
    }

    public void komunikatON(){
        String style="-fx-background-color:#d9d9d9;"+"-fx-border-color:lightgray;";
        this.panel.setStyle(style);
    }
    public void komunikatOFF(){this.panel.setStyle("-fx-border-color:lightgray;");}


    @FXML
    public void zwrocIndeks(){wskaznik.zmienIndeksPokoju(this.indeks);}
}
