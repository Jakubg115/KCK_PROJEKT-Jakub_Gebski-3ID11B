package com.swietlica.Frontend;

import javafx.animation.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;


public class EkranPowitalny {

    private String logowanie="Admin",haslowanie="Admin";


    private static String TYTUL_PROGRAMU="Świetlica PL";

    private boolean logowanieflaga=false;
    public void ustawflageLogowania(boolean flaga){this.logowanieflaga=flaga;}

    private boolean easterEgg=false;
/*                    Kontrolki                     */
    @FXML
    private Button wyborLogowanie,wyborGosc,probaLogowania,rejestracja;
    @FXML
    private Label Tytul,OdpowiedzSerwera;
    @FXML
    private SplitPane PanelGlowny;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField Haslo;
    @FXML
    private CheckBox Pamietanie;
    @FXML
    private HBox ramkaOpis;


    private Stage kopia;

    private SplitPane.Divider rozdzialka;

    private final InvalidationListener nasluch=new InvalidationListener() {
        @Override
        public void invalidated(Observable observable) {
            double pozycjarozdzialki=rozdzialka.getPosition();
            boolean flaga=pozycjarozdzialki<=0.6;
            przejscieMiedzyStronami(flaga);
            ustawflageLogowania(flaga);
        }
    };

    public void inicjujNasluchy(Stage stage){
        Tytul.setText("Witaj w "+TYTUL_PROGRAMU);
        rozdzialka=PanelGlowny.getDividers().get(0);
        rozdzialka.positionProperty().addListener(nasluch);
        this.kopia=stage;
        BackgroundImage image=new BackgroundImage(
                new Image(
                        "bgImage.png",
                        this.kopia.getWidth(),
                        this.kopia.getHeight(),
                        true,true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        PanelGlowny.setBackground(new Background(image));

        this.kopia.setResizable(false);
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
        KeyValue x=new KeyValue(rozdzialka.positionProperty(),this.logowanieflaga?0.4:1,Interpolator.EASE_BOTH);
        KeyFrame frame=new KeyFrame(Duration.seconds(1),x);
        Timeline timeline=new Timeline(frame);
        timeline.play();

    }

    public void przejscieMiedzyStronami(boolean flaga){
        wyborLogowanie.setText(flaga?"Wróć":"Dołącz do naszego grona");
        ramkaOpis.setVisible(!flaga);

    }

    @FXML
    protected void InicjujGoscia() throws IOException {
        inicjujGlowny(true);
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
        r.przekazScene(rejestracja,this);

        rejestracja.addEventHandler(WindowEvent.WINDOW_HIDDEN, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                PanelGlowny.setDisable(false);
                if(!kopia.isShowing()){kopia.show();}
            }
        });

    }
    @FXML
    public void Walidacja() throws IOException {
        String login=Login.getText();
        String haslo=Haslo.getText();

        if(login.equals(this.logowanie)&&haslo.equals(this.haslowanie))
        {
            OdpowiedzSerwera.setTextFill(Color.valueOf("green"));
            OdpowiedzSerwera.setText("Zalogowano");
            Login.setStyle("-fx-border-color: black");
            Haslo.setStyle("-fx-border-color: black");
            inicjujGlowny(false);
        }
        else {
            OdpowiedzSerwera.setText("Nieprawidlowy login lub haslo");
            Login.setStyle("-fx-border-color: red");
            Haslo.setStyle("-fx-border-color: red");
        }
    }

    public void inicjujGlowny(boolean czyGosc) throws IOException {
        Stage glowny=new Stage();
        FXMLLoader l=new FXMLLoader(getClass().getResource("/com/swietlica/EkranGlowny.fxml"));
        Parent root=l.load();
        glowny.setScene(new Scene(root,800,600));
        glowny.setTitle("Witamy w Swietlicy!!!");
        EkranGlowny dostagea=l.getController();
        dostagea.przekazScene(glowny);
        dostagea.inicjacja(czyGosc?"Gosc":Login.getText());
        glowny.show();
        kopia.hide();

    }
    private void komunikatON(Button but){but.setStyle(
            "-fx-background-color:white;"+
                    "-fx-text-fill:blue;");}

    private void komunikatOFF(Button but){but.setStyle(
            "-fx-background-color:blue;"
    );}

    @FXML
    public void onlineKomunikatON(){komunikatON(this.wyborLogowanie);}
    @FXML
    public void onlineKomunikatOFF(){komunikatOFF(this.wyborLogowanie);}
    @FXML
    public void offlineKomunikatON(){komunikatON(this.wyborGosc);}
    @FXML
    public void offlineKomunikatOFF(){komunikatOFF(this.wyborGosc);}
    @FXML
    public void walKomunikatON(){komunikatON(this.probaLogowania);}
    @FXML
    public void walKomunikatOFF(){komunikatOFF(this.probaLogowania);}
    @FXML
    public void rejKomunikatON(){komunikatON(this.rejestracja);}
    @FXML
    public void rejKomunikatOFF(){komunikatOFF(this.rejestracja);}


    public void nowekonto(String login, String haslo){this.logowanie=login; this.haslowanie=haslo;}
}
