## Projekt zaliczeniowy do przedmiotu "Komunikacja Człowiek-Komputer" jak i część projektu do pracy dyplomowej pod tytułem:

# "Projekt i Implementacja platformy do prostych gier wieloosobowych"

W ramach tego projektu projektowano i implementowano ekrany do aplikacji o wybranym temacie. 

> [!NOTE]
> Temat tego projektu jest bazowany na popularnej stronie internetowej [Kurnik.pl](https://www.kurnik.pl/) odtworzonej na wersję desktopową (okienkową).

Wykorzystane tachnologie:
>- Javafx jako główny język programu
>- SceneBuilder do graficznego projektowania ekranów
>- Intellij Idea w wersji 26.0.1 do operowania na tym środowisku

Wykorzystany Framework:
- jensd.fontawesomefx-fontawesome: framework pozwalający na zaaplikowanie ikonek do ekranów:
 ```
<dependency>
            <groupId>de.jensd</groupId>
            <artifactId>fontawesomefx-fontawesome</artifactId>
            <version>4.7.0-9.1.2</version>
        </dependency>
```

Dla części implementacyjnej w tym przedmiocie (laby 6-8) przygotowano prawie wszystkie przewidziane do tego tematu ekrany:

- [x] Ekran witalny z wbudowanym formularzem do logowania
      <img width="300" height="232" alt="obraz" src="https://github.com/user-attachments/assets/6b9a53f0-80e5-4e4e-ba1d-7bdbd83edb39" /> <img width="300" height="232" alt="obraz" src="https://github.com/user-attachments/assets/7f02e449-7cda-41e7-89f4-0307b1b10204" />
      

- [x] Okno dialogowe z możliwością rejestracji nowego konta
<img width="240" height="266" alt="obraz" src="https://github.com/user-attachments/assets/e26848ec-5738-403c-8cb4-b67230c1bdca" />

- [x] Ekran główny z możliwością przeglądania dostępnych gier
      <img width="402" height="332" alt="obraz" src="https://github.com/user-attachments/assets/77d3f076-d8cf-4845-9f99-feea6f7ba918" />

- [x] Ekran pomocowy, mający być zbiorem instrukcji do każdej gry
      <img width="471" height="357" alt="obraz" src="https://github.com/user-attachments/assets/3889c67e-d735-46ca-81fc-0261ea765694" />

- [x] Ekran przedstawiający gotowy layout do wyszukiwarki pokojów dostępnych w trakcie gry wieloosobowej
      <img width="402" height="332" alt="obraz" src="https://github.com/user-attachments/assets/e6d476ed-0d70-40a5-9b50-c81c23a3c7c0" />

- [ ] Ekran dziejącej się partyjki w daną grę

>[!IMPORTANT]
>Projekt ten posiada uproszczoną nawigację, tak by można było załączyć te ekrany i przejrzeć.
>Tylko w paru ekranach są dodatkowe funkcjonalności, głównie testowe do przygotowania funkcji do następnego etapu

# SPOSÓB URUCHOMIENIA PROGRAMU

### Do uruchomienia programu zaleca się zainstalować:

- Java Development Kit 25
- JDK w wersji 25 (najlepiej w 25.0.3)

Do tego projektu są przygotowane dwa sposoby na uruchomienie:
1. W katalogu projektu jest przygotowany i zbudowany plik wykonywalny dla języka javy (Swietlica.jar). Plik ten zadziała, jeżeli w urządzeniu zostanie pobrane środowisko narzędziowe dla Javy (Ten Development Kit) 
2. W razie braku możliwości uruchomienia przez plik .jar to należy uruchomić ten projekt przez klase "Launcher".

>[!WARNING]
>Nie wszystkie kontrolki w tych ekranach są zaprojektowane. By dostać się do ekranów w projekcie:
>- W ekranie witalnym należy kliknąć w przycisk logowania się jako Gość albo w formularzu wpisać Login Admin z hasłem Admin i spróbować się zalogować
>- Z ekranu głównego do ekranu z instrukcjami należy zejść na sam koniec segmentu z wyświetloną grą do znalezienia przycisku "Jak grać?"
>- Z głównego do Ekranu pokoji można wejść klikając w przycisk "ZNAJDZ POKOJ"

>[!INFO]
>W razie problemów z załączeniem programu kontakt mailowy jest mile widziany.

Z pozdrowieniami

Jakub Gębski
