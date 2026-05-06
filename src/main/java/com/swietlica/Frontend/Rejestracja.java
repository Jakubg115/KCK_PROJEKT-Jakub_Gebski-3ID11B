package com.swietlica.Frontend;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Rejestracja {

    @FXML
    private TextField nowyUzytkownik,mail;
    @FXML
    private PasswordField noweHaslo,powtorzoneHaslo;
    @FXML
    private Label infoDlaUzytkownika,infoZwrotne;

    private Stage st;

    public void przekazScene(Stage st){
        this.st=st;
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
        st.close();
    }
}
