package com.res.kurnikpl.ekrany.Powitalny;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class EkranPowitalny {

    private boolean logowanieflaga=false;
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

/*               Funkcje poboczne                     */


/*               Handlery wydarzen                     */

    @FXML
    protected void TekstKlikniety()
    {

    }
    @FXML
    protected void InicjujLogowanie()
    {
        logowanieflaga= !logowanieflaga;
        SplitPane.Divider div=PanelGlowny.getDividers().getFirst();
        div.positionProperty().unbind();
        if(logowanieflaga)
        {
            PanelGlowny.setDividerPosition(0,0.4);
            WyborLogowanie.setText("Wróć");
            Tytul.setText("[Nazwa Aplikacji]");
            Tytul.setStyle("-fx-font-size: 20");
            Tytul.getScaleX();
            Opis.setVisible(false);
        }
        else
        {
            PanelGlowny.setDividerPosition(0,1);
            WyborLogowanie.setText("Dołącz do naszego grona");
            Tytul.setText("Witaj w [Nazwa Aplikacji]");
            Tytul.setStyle("-fx-font-size: 40");
            Opis.setVisible(true);
        }


    }
    @FXML
    protected void InicjujGoscia()
    {

    }
}
