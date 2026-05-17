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
    public void wstawIndeks(int indeks){this.idPokoju.setText("#"+indeks);}
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
        this.panel.setStyle("-fx-background-color:#d9d9d9;");
    }
    public void komunikatOFF(){this.panel.setStyle("");}

}
