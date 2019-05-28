package app.model;
import Colored.Color;
import java.util.ArrayList;
import java.util.Random;


/**
 * <b>Jeu est la classe représentant un Jeu de carte.</b>
 * <p>
 * Un Jeu est caractérisé par les informations suivantes :
 * <ul>
 * <li>Une main de carte (une <B>ArrayList</B> de <B>Carte</B>.)</li>
 * <li>Un nom pour le joueur qui possède ce jeu</li>
 * <li>Un booléen qui indique si le joueur a gagné ou non.</li>
 * </ul>
 * </p>
 * <p>
 * On utilise principalement cette classe pour créer le Jeu des Joueurs, mais elle est également utilisée pour initialiser le deck principal qui aura pour nom : <B>"Paquet"</B>
 * </p>
 *
 * @see #generateMainDeck()
 *
 * @author tjacob3
 */
public class Jeu {
    private ArrayList<Carte> main;
    private String nomJoueur;
    private boolean isGameWon;

    public Jeu() {
        this.isGameWon = false;
    }

    public Jeu(ArrayList<Carte> main, String nomJoueur) {
        this.main = main;
        this.nomJoueur = nomJoueur;
        this.isGameWon = false;
    }

    public ArrayList<Carte> getMain() {
        return main;
    }

    public void setMain(ArrayList<Carte> main) {
        this.main = main;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameWon(boolean gameWon) {
        isGameWon = gameWon;
    }



    /**
     * Cette fonction permet d'initialiser le deck dit "principal" <br>
     * Le deck contient les 32 cartes rangées dans l'ordre.
     * Le deck est une <B>ArrayList</B> qui contient des Objets de type {@link Carte}.
     */
    public void generateMainDeck(){
        ArrayList<Carte> deckPrincipal = new ArrayList<Carte>();
        deckPrincipal.add(new Carte("Trèfle", "Sept", 1, "/app/resource/cards/sept_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "Huit", 2, "/app/resource/cards/huit_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "Neuf", 3, "/app/resource/cards/neuf_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "Dix", 4, "/app/resource/cards/dix_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "Valet", 5, "/app/resource/cards/valet_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "Dame", 6, "/app/resource/cards/dame_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "Roi", 7, "/app/resource/cards/roi_trefle.png"));
        deckPrincipal.add(new Carte("Trèfle", "As", 8, "/app/resource/cards/as_trefle.png"));

        deckPrincipal.add(new Carte("Carreau", "Sept", 1, "/app/resource/cards/sept_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "Huit", 2, "/app/resource/cards/huit_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "Neuf", 3, "/app/resource/cards/neuf_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "Dix", 4, "/app/resource/cards/dix_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "Valet", 5, "/app/resource/cards/valet_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "Dame", 6, "/app/resource/cards/dame_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "Roi", 7, "/app/resource/cards/roi_carreau.png"));
        deckPrincipal.add(new Carte("Carreau", "As", 8, "/app/resource/cards/as_carreau.png"));

        deckPrincipal.add(new Carte("Coeur", "Sept", 1, "/app/resource/cards/sept_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "Huit", 2, "/app/resource/cards/huit_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "Neuf", 3, "/app/resource/cards/neuf_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "Dix", 4, "/app/resource/cards/dix_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "Valet", 5, "/app/resource/cards/valet_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "Dame", 6, "/app/resource/cards/dame_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "Roi", 7, "/app/resource/cards/roi_coeur.png"));
        deckPrincipal.add(new Carte("Coeur", "As", 8, "/app/resource/cards/as_coeur.png"));

        deckPrincipal.add(new Carte("Pique", "Sept", 1, "/app/resource/cards/sept_pique.png"));
        deckPrincipal.add(new Carte("Pique", "Huit", 2, "/app/resource/cards/huit_pique.png"));
        deckPrincipal.add(new Carte("Pique", "Neuf", 3, "/app/resource/cards/neuf_pique.png"));
        deckPrincipal.add(new Carte("Pique", "Dix", 4, "/app/resource/cards/dix_pique.png"));
        deckPrincipal.add(new Carte("Pique", "Valet", 5, "/app/resource/cards/valet_pique.png"));
        deckPrincipal.add(new Carte("Pique", "Dame", 6, "/app/resource/cards/dame_pique.png"));
        deckPrincipal.add(new Carte("Pique", "Roi", 7, "/app/resource/cards/roi_pique.png"));
        deckPrincipal.add(new Carte("Pique", "As", 8, "/app/resource/cards/as_pique.png"));

        this.main = deckPrincipal;
    }

    /**
     * Cette fonction sert à distribuer les cartes de manière aléatoire du Deck principal (voir {@link #generateMainDeck()}), aux deux joueur désignés par les paramètres j1 et j2
     * @param j1 représentant le joueur N°1
     * @param j2 représentant le joueur N°2
     */
    public void distribuer(Jeu j1, Jeu j2){
        System.out.println("Distribution des cartes en cours...");
        int taille = this.main.size();
        for(int i =0; i < taille/2; i++){
            int size = main.size()-1;
            Random r = new Random();
            int n = r.nextInt(size);
            j1.main.add(this.main.get(n));
            this.main.remove(n);
            n = r.nextInt(size);
            j2.main.add(this.main.get(n));
            this.main.remove(n);

        }
        System.out.println("Voici la main de " + j1.nomJoueur + ": ");
        System.out.println(j1.main);
        System.out.println();
        System.out.println("voici la main de " + j2.nomJoueur + ": ");
        System.out.println(j2.main);
        System.out.println(this.main.size());
    }

    /**
     * Cette fonction sert à lancer une partie contre un autre Joueur (un autre Jeu)
     * @param jeu
     */
    public void lancerJeuContre(Jeu jeu){
        int test = 0;
        ArrayList<Carte> cardsPlayed = new ArrayList<Carte>();
        while(!this.isGameWon && !jeu.isGameWon){ //on regarde si le Jeu est perdu pour l'un des deux joueurs
            if(this.main.size() == 0){//Si la Main du J1 est vide, alors le J2 gagne.
                jeu.isGameWon = true;
                System.out.println(jeu.nomJoueur + " gagne la partie");
                break;
            }
            if(jeu.main.size() == 0){// Pareil mais l'inverse.
                this.isGameWon = true;
                System.out.println(this.nomJoueur + " gagne la partie");
                break;
            }

            Carte cardPlayedJ1; //Cette variable représente la carte que vient de prendre le J1 de sa pioche
            Carte cardPlayedJ2; //Cette variable représente la carte que vient de prendre le J2 de sa pioche

            cardPlayedJ1 = this.main.get(0);
            cardPlayedJ2 = jeu.main.get(0);
            System.out.println(Color.cyan("Le J1 pose: ") + cardPlayedJ1);
            System.out.println(Color.green("Le J2 pose: ") + cardPlayedJ2);
            poseCarte(jeu, cardsPlayed, cardPlayedJ1, cardPlayedJ2);
            if(cardPlayedJ1.getForce() == cardPlayedJ2.getForce()){ //Si les deux cartes posées provoquent une égalité
                //-------------------------- On regarde d'abord si après cette égalité, les deux joueurs ont encore des cartes, sinon, celui qui n'en a plus a perdu.
                if(this.main.size() == 0){
                    jeu.isGameWon = true;
                    break;
                }
                if(jeu.main.size() == 0){
                    this.isGameWon = true;
                    break;
                }
                //-------------------------- Comme on a eu une égalité, on pose deux cartes normalement face cachées par dessus. Puis on recommence en reposant deux cartes normalement par dessus.
                System.out.println(Color.yellow("Bataille!"));
                cardPlayedJ1 = this.main.get(0);
                cardPlayedJ2 = jeu.main.get(0);
                System.out.println(Color.cyan("Le J1 pose: ") + cardPlayedJ1 + Color.purple(" face cachée"));
                System.out.println(Color.green("Le J2 pose: ") + cardPlayedJ2 + Color.purple(" face cachée"));
                poseCarte(jeu, cardsPlayed, cardPlayedJ1, cardPlayedJ2);
                //----------------------------
            }
            else{
                if(cardPlayedJ1.getForce() > cardPlayedJ2.getForce()){
                    Random rand = new Random();
                    int nb;
                    while(cardsPlayed.size() != 0){
                        nb = rand.nextInt(cardsPlayed.size());
                        this.main.add(cardsPlayed.get(nb));
                        cardsPlayed.remove(nb);
                    }
                    System.out.println(Color.cyan("J1 Gagne Duel"));
                }
                else if (cardPlayedJ2.getForce() > cardPlayedJ1.getForce()){
                    Random rand = new Random();
                    int nb;

                    while(cardsPlayed.size() != 0){
                        nb = rand.nextInt(cardsPlayed.size());
                        jeu.main.add(cardsPlayed.get(nb));
                        cardsPlayed.remove(nb);
                    }
                    Color.green("J2 Gagne Duel");
                }
            }
            System.out.println(Color.cyan("Main de " + this.nomJoueur + " ->") +  this.main);
            System.out.println(Color.green("Main de " + jeu.nomJoueur + " ->") + jeu.main);
            System.out.println();
            if(this.main.size() == 0){
                jeu.isGameWon = true;
                System.out.println(Color.green(jeu.nomJoueur) +  Color.red(" gagne la partie"));
            }
            if(jeu.main.size() == 0){
                this.isGameWon = true;
                System.out.println(Color.cyan(this.nomJoueur) +  Color.red(" gagne la partie"));
            }
            System.out.println();
            test++;

        }
        System.out.println(Color.yellow(test +  " tours effectués"));
    }

    /**
     * Cette petite fonction sert à prendre une carte de chaque joueur, et à les "poser"
     * @param jeu
     * @param cardsPlayed
     * @param cardPlayedJ1
     * @param cardPlayedJ2
     */
    public void poseCarte(Jeu jeu, ArrayList<Carte> cardsPlayed, Carte cardPlayedJ1, Carte cardPlayedJ2) {
        cardsPlayed.add(cardPlayedJ1);// On ajoute à la liste des "Cartes Jouées", les cartes des deux joueurs.
        cardsPlayed.add(cardPlayedJ2);
        System.out.println(cardsPlayed);
        this.main.remove(0); //On enlève la carte de J1 de l'ArrayList(Main), celle qu'il vient de poser, pour bien montrer qu'elle n'est plus dans son paquet
        jeu.main.remove(0); // Idem mais pour J2
    }

    @Override
    public String toString() {
        return "Nombre de carte de " + nomJoueur + " :" + this.main.size();
    }
}