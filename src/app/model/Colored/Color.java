package Colored;
/**
 * <b>Color est la classe permettant d'ajouter des couleurs au terminal.</b>
 * <p>
 * Cette classe sert + de raccourci, afin de pouvoir mettre de la couleur dans le terminal très simplement.
 * </p>
 *
 * @author tjacob3
 */
public class Color {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public Color() {
    }
    Color color = new Color();

    public static String red(String s){
        return RED + s + RESET;
    }
    public static String black(String s){
        return BLACK + s + RESET;
    }
    public static String green(String s){
        return GREEN + s + RESET;
    }
    public static String yellow(String s){
        return YELLOW + s + RESET;
    }
    public static String blue(String s){
        return BLUE + s + RESET;
    }
    public static String purple(String s){
        return PURPLE + s + RESET;
    }
    public static String cyan(String s){
        return CYAN + s + RESET;
    }
    public static String white(String s){
        return WHITE + s + RESET;
    }
}
