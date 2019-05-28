package app.view;

import app.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;



/**
 * <b>WelcomePage est la classe représentant le controlleur de la page d'accueil.</b>
 * <p>
 * Les méthodes que cette classe possède, servent uniquement à intéragir avec le FXML
 * </p>
 *
 * @author tjacob3
 * @version 1.0
 */
public class WelcomePage {
    private Main main;
    public WelcomePage() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }


    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Associée à un bouton, cette méthode permet d'accéder à la page {@link MenuMain}.
     */
    @FXML
    private void handlePlay() {
        this.main.showMenuMain();
    }

    /**
     * Associée à un bouton, cette méthode permet de quitter l'application.
     */
    @FXML
    private void handleExit() {
        Platform.exit();
    }
}
