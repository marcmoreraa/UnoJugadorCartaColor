package uno.logica;

public class Regles {
    public static boolean sonCartesCompatibles(Carta carta1, Carta carta2) {
        return carta1.getNumero() == carta2.getNumero() ||
                carta1.getColor() == carta2.getColor();
    }
}
