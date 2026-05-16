package com.swietlica.Frontend;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Rejestracja {

    @FXML
    private TextField nowyUzytkownik,mail;
    @FXML
    private PasswordField noweHaslo,powtorzoneHaslo;
    @FXML
    private Label infoDlaUzytkownika,infoZwrotne;

    private Stage st;
    private EkranPowitalny powrotne;

    public void przekazScene(Stage st, EkranPowitalny ek){
        this.st=st;
        this.powrotne=ek;
    }


    private static final String[] informacje = {
            "Nazwa użytkownika powinna posiadać 3 albo więcej znaków",
            "Hasło powinno być silne i posiadać 6 lub więcej znaków",
            "Hasło należy powtórzyć w celu zapamiętania",
            "Mail używany jest do kontaktu poprzez pocztę lub do przywracania hasła"
    };

    private void UstawInformacje(int info){
        infoDlaUzytkownika.setText(informacje[info]);

    }

    @FXML
    public void InfoLogin() {
        UstawInformacje(0);
    }

    @FXML
    public void InfoHaslo() {
        UstawInformacje(1);
    }

    @FXML
    public void InfoHasPon() {
        UstawInformacje(2);
    }

    @FXML
    public void InfoMail() {
        UstawInformacje(3);
    }
    @FXML
    public void Walidacja(){
        infoZwrotne.setAlignment(Pos.CENTER);
        infoZwrotne.setTextFill(Color.valueOf("red"));
        String nowyuz=nowyUzytkownik.getText();
        String hasl=noweHaslo.getText();
        if(!nowyuz.isEmpty())
        {
            if(!hasl.isEmpty())
            {
                String powt=powtorzoneHaslo.getText();
                if (powt.equals(hasl))
                {
                    powrotne.nowekonto(nowyuz,hasl);
                    st.close();
                }
                else {
                    ustawInfoZwrotne("Rozne wartosci w polach zwiazanych z haslem. Musza byc takie same");
                }
            }
            else
            {
                ustawInfoZwrotne("Brakuje hasla do weryfikacji");
            }
        }
        else {
            ustawInfoZwrotne("Uzytkownik nie moze byc utworzony! Brakuje nazwy uzytkownika");
        }

    }
    private void ustawInfoZwrotne(String wiadomosc){
        infoZwrotne.setText(wiadomosc);
    }
}
