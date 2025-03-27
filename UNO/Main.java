package UNO;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Jugador 1");

        Mazo mazo = new Mazo();

        for (Carta c : mazo.getCartes()) {
            j1.addCarta(c);
        }


        UI.mostrarCartes(j1.getCartes());


    }
}