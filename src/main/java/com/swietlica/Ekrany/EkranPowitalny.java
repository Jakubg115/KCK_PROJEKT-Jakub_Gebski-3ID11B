package com.swietlica.Ekrany;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class EkranPowitalny {

    private final String TYTUL_PROGRAMU="Swietlica PL";

    public String PobierzTytul(){return TYTUL_PROGRAMU;}
    private boolean logowanieflaga=false;
    public void ustawflageLogowania(boolean flaga){this.logowanieflaga=flaga;}
/*                    Kontrolki                     */
    @FXML
    private VBox EkranLogowania;
    @FXML
    private VBox Witalny;
    @FXML
    private Button WyborGosc;
    @FXML
    private Button WyborLogowanie;
    @FXML
    private Button ProbaLogowania;
    @FXML
    private Button Rejestracja;
    @FXML
    private Label Tytul;
    @FXML
    private Label Opis;
    @FXML
    private Label OdpowiedzSerwera;
    @FXML
    private SplitPane PanelGlowny;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField Haslo;
    @FXML
    private CheckBox Pamietanie;

    private final InvalidationListener nasluch=new InvalidationListener() {
        @Override
        public void invalidated(Observable observable) {
            double pozycjarozdzialki=PanelGlowny.getDividerPositions()[0];
            boolean flaga=pozycjarozdzialki<=0.6;
            przejscieMiedzyStronami(flaga);
            ustawflageLogowania(flaga);
        }
    };

    public void inicjujNasluchy(){
        PanelGlowny.getDividers().get(0).positionProperty().addListener(nasluch);
    }

    @FXML
    protected void TekstKlikniety()
    {

    }
    @FXML
    protected void InicjujLogowanie()
    {
        ustawflageLogowania(!this.logowanieflaga);
        PanelGlowny.setDividerPosition(0,this.logowanieflaga?0.4:1);
    }

    public void przejscieMiedzyStronami(boolean flaga){
        WyborLogowanie.setText(flaga?"Wróć":"Dołącz do naszego grona");
        Opis.setVisible(!flaga);
        Tytul.setStyle("-fx-font-size: "+(flaga?20:40));
        Tytul.setText((flaga?"":"Witaj w ")+TYTUL_PROGRAMU);
        EkranLogowania.setVisible(flaga);
    }

    @FXML
    protected void InicjujGoscia()
    {

    }
}
