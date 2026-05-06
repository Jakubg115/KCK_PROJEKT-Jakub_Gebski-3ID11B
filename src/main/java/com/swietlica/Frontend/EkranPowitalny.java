package com.swietlica.Frontend;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;



public class EkranPowitalny {

    private static String TYTUL_PROGRAMU="Świetlica PL";

    public String PobierzTytul(){return TYTUL_PROGRAMU;}
    private boolean logowanieflaga=false;
    public void ustawflageLogowania(boolean flaga){this.logowanieflaga=flaga;}

    private boolean easterEgg=false;
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
    private Label Tytul,Opis;
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

    private Stage kopia;

    private final InvalidationListener nasluch=new InvalidationListener() {
        @Override
        public void invalidated(Observable observable) {
            double pozycjarozdzialki=PanelGlowny.getDividerPositions()[0];
            boolean flaga=pozycjarozdzialki<=0.6;
            przejscieMiedzyStronami(flaga);
            ustawflageLogowania(flaga);
            Tytul.setText("Witaj w "+TYTUL_PROGRAMU);

        }
    };

    public void inicjujNasluchy(Stage stage){
        Tytul.setText("Witaj w "+TYTUL_PROGRAMU);
        PanelGlowny.getDividers().get(0).positionProperty().addListener(nasluch);
        this.kopia=stage;
    }

    @FXML
    protected void TekstKlikniety()
    {
        this.easterEgg=!this.easterEgg;
        TYTUL_PROGRAMU=this.easterEgg?"Kurnik PL":"Swietlica PL";
        Tytul.setText("Witaj w "+TYTUL_PROGRAMU);
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
        EkranLogowania.setVisible(flaga);
    }

    @FXML
    protected void InicjujGoscia()
    {

    }

    @FXML
    protected void InicjujRejestracje() throws IOException {
        PanelGlowny.setDisable(true);
        Stage rejestracja=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/swietlica/Rejestracja.fxml"));
        Parent root=loader.load();
        rejestracja.setScene(new Scene(root));
        rejestracja.show();

        Rejestracja r=loader.getController();
        r.przekazScene(rejestracja);

        rejestracja.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                PanelGlowny.setDisable(false);
                if(!kopia.isShowing()){kopia.show();}
            }
        });

    }
    @FXML
    public void Walidacja() throws InterruptedException {
        String login=Login.getText();
        String haslo=Haslo.getText();

        if(login.equals("Admin")&&haslo.equals("Admin"))
        {
            OdpowiedzSerwera.setTextFill(Color.valueOf("green"));
            OdpowiedzSerwera.setText("Zalogowano");
            Login.setStyle("-fx-border-color: black");
            Haslo.setStyle("-fx-border-color: black");

            kopia.hide();
        }
        else {
            OdpowiedzSerwera.setText("Nieprawidlowy login lub haslo");
            Login.setStyle("-fx-border-color: red");
            Haslo.setStyle("-fx-border-color: red");
        }
    }


}
