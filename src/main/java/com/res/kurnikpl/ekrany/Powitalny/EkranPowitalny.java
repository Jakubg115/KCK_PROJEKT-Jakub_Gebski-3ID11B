package com.res.kurnikpl.ekrany.Powitalny;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
        PanelGlowny.setDividerPosition(0,0.4);
    }
    @FXML
    protected void InicjujGoscia()
    {

    }
}
