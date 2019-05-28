package app.view;

import app.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.KeyEvent;

public class MenuMain {

    private Main main;
    @FXML
    private TextField LabelJ1 = new TextField();
    @FXML
    private TextField LabelJ2 = new TextField();
    @FXML
    private Label error = new Label("");

    public MenuMain() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    @FXML
    private void buttonPressed(javafx.scene.input.KeyEvent e)
    {
        if(e.getCode().toString().equals("ENTER"))
        {
            checkError();
        }
    }

    @FXML
    private void checkError(){
        String nameJ1 = LabelJ1.getText();
        String nameJ2 = LabelJ2.getText();
        String msgError = "Erreur sur: ";
        int cptErreur = 0;
        if(nameJ1.equals("")){
            cptErreur++;
            msgError = msgError + "|Nom J1| ";
            error.setText(msgError);
        }
        if(nameJ2.equals("")){
            cptErreur++;
            msgError = msgError + "|Nom J2| ";
            error.setText(msgError);
        }
        if(cptErreur == 0){
            error.setText("");
            this.main.showGamePage(nameJ1,nameJ2);
        }


    }


    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleBack() {
        this.main.showWelcomePage();
    }


}