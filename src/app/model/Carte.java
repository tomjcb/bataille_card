package app.model;

/**
 * <b>Carte est la classe représentant une Carte d'un Jeu de cartes..</b>
 * <p>
 * Une carte est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un type de forme, c'est-à-dire : Coeur, Pique, etc...</li>
 * <li>Un "type", qui permet de savoir si c'est un Sept, une Reine etc</li>
 * <li>Une "force" qui permet d'avoir un rapport de force entre les cartes</li>
 * </ul>
 * </p>
 * <p>
 * On utilise principalement cette classe pour créer le Jeu des Joueurs, mais elle est également utilisée pour initialiser le deck principal qui aura pour nom : <B>"Paquet"</B>
 * </p>
 *
 *
 * @author tjacob3
 */
public class Carte {
    private String typeForme;
    private String type;
    private int force;
    private String cheminimg;

    public Carte() {
    }

    public Carte(String typeForme, String type, int force, String cheminimg) {
        this.typeForme = typeForme;
        this.type = type;
        this.force = force;
        this.cheminimg = cheminimg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getForce() {
        return force;
    }

    public String getCheminimg() {
        return cheminimg;
    }

    @Override
    public String toString() {
        return  type + " de " + typeForme;
    }
}
