package com.swietlica.Frontend;

import com.swietlica.Frontend.Komponenty.ElementDoEkranuPomoc.ObiektPomoc;
import com.swietlica.Frontend.Komponenty.GraZListy.ObiektGra;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;

public class Pomoc {

    @FXML
    private ListView<ObiektPomoc> listaGier= new ListView<>();
    @FXML
    private Label tytul;

    private Stage stage;

    public void inicjuj(ObservableList<ObiektGra> lista, int indeks) throws IOException {
        Iterator<ObiektGra> it=lista.iterator();
        System.out.println(indeks);
        while (it.hasNext())
        {
            listaGier.getItems().add(new ObiektPomoc(it.next()));
        }
        listaGier.getSelectionModel().select(indeks);
        odczytajObiekt();
    }

    public Stage dajStage(){return this.stage;}
    public void wstawStage(Stage st){this.stage=st;}

    public void odczytajObiekt(){
        if(listaGier.getSelectionModel().getSelectedIndex()>=0)
        {
            tytul.setText(listaGier.getSelectionModel().getSelectedItem().ZwrocNazwe());
        }

    }
}


