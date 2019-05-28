package app.view;

import app.Main;
import app.model.Carte;
import app.model.Jeu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class GamePage {
    private Main main;
    private String J1;
    private String J2;
    private int egalite = 0;
    private String info = "";
    private int nbTours = 0;

    @FXML
    Label cardJ1 = new Label();

    @FXML
    Label cardJ2 = new Label();

    @FXML
    Label nomJ1 = new Label();

    @FXML
    Label nomJ2 = new Label();

    @FXML
    Label infoGame = new Label();

    @FXML
    Label nbCartesJ1 = new Label();

    @FXML
    Label nbCartesJ2 = new Label();

    @FXML
    Label nbCartesEnJeu = new Label();

    @FXML
    TextArea infos = new TextArea();

    ArrayList<Carte> deckPrincipal= new ArrayList<Carte>();
    Jeu jeu = new Jeu(deckPrincipal, "Paquet");
    ArrayList<Carte> deckJ1 = new ArrayList<Carte>();
    ArrayList<Carte> deckJ2 = new ArrayList<Carte>();
    Jeu joueur1;
    Jeu joueur2;
    ArrayList<Carte> cardsPlayed;

    @FXML
    Button btnTourSuivant = new Button(); //Element FXML lié à un bouton

    @FXML
    Button btnGoToTheEnd = new Button(); //Element FXML lié à un bouton


    public GamePage() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {

    }

    /**
     * <b>init()</b> est la méthode appellée lors de l'affichage de la page; <br>
     * <p>
     * Cette méthode permet de :
     * <ul>
     * <li>Initialiser les <b>Labels</b></li>
     * <li>Récupérer les noms des deux joueurs</li>
     * <li>Créer les decks des deux joueurs ainsi que le deck principal contenant les 32 cartes</li>
     * <li>Distribuer les cartes de deck principal aléatoirement aux deux joueurs</li>
     * </ul>
     * </p>
     * @param j1 String contenant le nom du joueur 1 saisit précédemment
     * @param j2 String contenant le nom du joueur 2 saisit précédemment
     */
    public void init(String j1, String j2){

        J1 = j1;
        J2 = j2;
        nomJ1.setText("Carte de " + J1);
        nomJ2.setText("Carte de " + J2);
        nbCartesJ1.setText("Nb Cartes : ");
        nbCartesJ2.setText("Nb Cartes : ");
        nbCartesEnJeu.setText("Nb Cartes en jeu : ");
        infoGame.setText("");
        joueur1 = new Jeu(deckJ1, J1);
        joueur2 = new Jeu(deckJ2, J2);
        jeu.generateMainDeck();
        jeu.distribuer(joueur1, joueur2);
        cardJ1.setText("");
        cardJ2.setText("");
        cardsPlayed = new ArrayList<Carte>();
        infos.setEditable(false);

    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void goToEndOfGame(){
        while(!joueur1.isGameWon() && !joueur2.isGameWon()){
            showCard();
        }
    }

    @FXML
    public void showCard(){
        if(egalite == 0) {
            info = "";
            cardsPlayed = new ArrayList<Carte>();
        }
            if(joueur1.getMain().size() == 0){//Si la Main du J1 est vide, alors le J2 gagne.
                joueur2.setGameWon(true);
                System.out.println(joueur2.getNomJoueur() + " gagne la partie");
                info = info + "J1 n'a plus de cartes : J2 gagne la partie";
                infos.setText(info);
            }
            if(joueur2.getMain().size() == 0){// Pareil mais l'inverse.
                joueur1.setGameWon(true);
                System.out.println(joueur1.getNomJoueur() + " gagne la partie");
                info = info + "J2 n'a plus de cartes : J1 gagne la partie";
                infos.setText(info);
            }

            Carte cardPlayedJ1; //Cette variable représente la carte que vient de prendre le J1 de sa pioche
            Carte cardPlayedJ2; //Cette variable représente la carte que vient de prendre le J2 de sa pioche

            cardPlayedJ1 = joueur1.getMain().get(0);
            cardPlayedJ2 = joueur2.getMain().get(0);
            System.out.println(Colored.Color.cyan("Le J1 pose: ") + cardPlayedJ1);
            System.out.println(Colored.Color.green("Le J2 pose: ") + cardPlayedJ2);
            info = info + "Le J1 pose: " + cardPlayedJ1 + "\n" + "Le J2 pose: " + cardPlayedJ2 + "\n";
            infos.setText(info);
            cardJ1.setGraphic(new ImageView(cardPlayedJ1.getCheminimg()));
            cardJ2.setGraphic(new ImageView(cardPlayedJ2.getCheminimg()));
            poseCarteEtUpdateInfo(cardPlayedJ1, cardPlayedJ2);
        egalite = 0;
            if(cardPlayedJ1.getForce() == cardPlayedJ2.getForce()){ //Si les deux cartes posées provoquent une égalité
                //-------------------------- On regarde d'abord si après cette égalité, les deux joueurs ont encore des cartes, sinon, celui qui n'en a plus a perdu.
                if(joueur1.getMain().size() == 0){
                    joueur2.setGameWon(true);
                    //info = info + "J1 n'a plus de cartes : J2 gagne la partie";
                    infos.setText(info);
                }
                else if(joueur2.getMain().size() == 0){
                    joueur1.setGameWon(true);
                    //info = info + "J2 n'a plus de cartes : J1 gagne la partie";
                    infos.setText(info);
                }
                else {
                    //-------------------------- Comme on a eu une égalité, on pose deux cartes normalement face cachées par dessus. Puis on recommence en reposant deux cartes normalement par dessus.
                    System.out.println(Colored.Color.yellow("Bataille!"));
                    infoGame.setText("BATAILLE !");
                    cardPlayedJ1 = joueur1.getMain().get(0);
                    cardPlayedJ2 = joueur2.getMain().get(0);
                    System.out.println(Colored.Color.cyan("Le J1 pose: ") + cardPlayedJ1 + Colored.Color.purple(" face cachée"));
                    System.out.println(Colored.Color.green("Le J2 pose: ") + cardPlayedJ2 + Colored.Color.purple(" face cachée"));
                    info = info + "Le J1 pose: " + cardPlayedJ1 + " face cachée" + "\n" + "Le J2 pose: " + cardPlayedJ2 + " face cachée" + "\n";
                    infos.setText(info);
                    poseCarteEtUpdateInfo(cardPlayedJ1, cardPlayedJ2);
                    egalite = 1;
                    //----------------------------
                }
            }
            else{
                if(cardPlayedJ1.getForce() > cardPlayedJ2.getForce()){
                    int nbCartesGagnees = cardsPlayed.size();
                    giveCartesToJoueur(joueur1);
                    System.out.println(Colored.Color.cyan("J1 Gagne Duel"));
                    infoGame.setText(J1 + " Gagne Duel");
                    info = info +  "Le J1 gagne le duel et remporte " + nbCartesGagnees + " cartes" + "\n";
                    infos.setText(info);
                    nbCartesJ1.setText("Nb Cartes : " + (joueur1 .getMain().size()+ cardsPlayed.size()) );
                    nbCartesEnJeu.setText("Nb Cartes en jeu : " + "0");

                }
                else if (cardPlayedJ2.getForce() > cardPlayedJ1.getForce()){
                    int nbCartesGagnees = cardsPlayed.size();
                    giveCartesToJoueur(joueur2);
                    Colored.Color.green("J2 Gagne Duel");
                    infoGame.setText(J2 + " Gagne Duel");
                    info = info +  "Le J2 gagne le duel et remporte " + nbCartesGagnees + " cartes" + "\n";
                    infos.setText(info);
                    nbCartesJ2.setText("Nb Cartes : " + (joueur2.getMain().size()+ cardsPlayed.size()) );
                    nbCartesEnJeu.setText("Nb Cartes en jeu : " + "0");
                }
            }
            System.out.println(Colored.Color.cyan("Main de " + joueur1.getNomJoueur() + " ->") +  joueur1.getMain());
            System.out.println(Colored.Color.green("Main de " + joueur2.getNomJoueur() + " ->") + joueur2.getMain());
            System.out.println();
            if(joueur1.getMain().size() == 0){
                joueur2.setGameWon(true);
                System.out.println(Colored.Color.green(joueur2.getNomJoueur()) +  Colored.Color.red(" gagne la partie"));
                infoGame.setText(J2 + " gagne la partie");
                btnTourSuivant.setDisable(true);
                btnGoToTheEnd.setDisable(true);
                btnTourSuivant.setText("Partie Terminée");
                info = info + "J1 n'a plus de cartes : J2 gagne la partie";
                infos.setText(info);
                nbCartesJ2.setText("Nb Cartes : " + "32");
                nbCartesEnJeu.setText("Nb Cartes en jeu : " + "0");


            }
            if(joueur2.getMain().size() == 0){
                joueur1.setGameWon(true);
                System.out.println(Colored.Color.cyan(joueur1.getNomJoueur()) +  Colored.Color.red(" gagne la partie"));
                infoGame.setText(J1 + " gagne la partie");
                btnTourSuivant.setDisable(true);
                btnGoToTheEnd.setDisable(true);
                btnTourSuivant.setText("Partie Terminée");
                info = info + "J2 n'a plus de cartes : J1 gagne la partie";
                infos.setText(info);
                nbCartesJ1.setText("Nb Cartes : " + "32");
                nbCartesEnJeu.setText("Nb Cartes en jeu : " + "0");
            }

            System.out.println();
            nbTours++;
        System.out.println(Colored.Color.yellow(nbTours +  " tours effectués"));
    }

    /**
     * La méthode <b>giveCartesToJoueur()</b> est utilisée lorsqu'un des deux joueurs à gagner un duel. <br>
     * On prend les cartes qui ont été jouées, et on les donne au joueur qui a gagné le duel.
     * @param joueur2 est le joueur qui va recevoir les cartes
     */
    public void giveCartesToJoueur(Jeu joueur2) {
        Random rand = new Random();
        int nb;
        while(cardsPlayed.size() != 0){
            nb = rand.nextInt(cardsPlayed.size());
            joueur2.getMain().add(cardsPlayed.get(nb));
            cardsPlayed.remove(nb);
        }
    }

    /**
     * La méthode <b>poseCarte()</b> esr utilisée afin de prendre une carte de chaucun des decks des deux joueurs (des Listes contenant leurs cartes). <br<
     * Et ensuite, on place ces deux cartes, dans la liste des carte jouées : <b>cartesPlayed</b>
     * @param j1 désigne le joueur 1
     * @param j2 désigne le joueur 2
     * @param cardsPlayed est la liste contenant les cartes posées sur le terrain
     * @param cardPlayedJ1 est la liste contenant les cartes dans la main du joueur 1
     * @param cardPlayedJ2 est la liste contenant les cartes de la main du joueur 2
     */
    public void poseCarte(Jeu j1, Jeu j2, ArrayList<Carte> cardsPlayed, Carte cardPlayedJ1, Carte cardPlayedJ2) {
        cardsPlayed.add(cardPlayedJ1);// On ajoute à la liste des "Cartes Jouées", les cartes des deux joueurs.
        cardsPlayed.add(cardPlayedJ2);
        System.out.println(cardsPlayed);
        j1.getMain().remove(0); //On enlève la carte de J1 de l'ArrayList(Main), celle qu'il vient de poser, pour bien montrer qu'elle n'est plus dans son paquet
        j2.getMain().remove(0); // Idem mais pour J2
    }

    public void poseCarteEtUpdateInfo(Carte cardPlayedJ1, Carte cardPlayedJ2) {
        poseCarte(joueur1,joueur2, cardsPlayed, cardPlayedJ1, cardPlayedJ2);
        nbCartesJ1.setText("Nb Cartes : " + joueur1.getMain().size());
        nbCartesJ2.setText("Nb Cartes : " + joueur2.getMain().size());
        nbCartesEnJeu.setText("Nb Cartes en jeu : " + cardsPlayed.size());
    }


}
