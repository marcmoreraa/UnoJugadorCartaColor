package uno;
import uno.logica.*;
import uno.interficie.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Jugador 1");
        Pilo pilo = new Pilo();
        Mazo mazo = new Mazo();

        mazo.barrejar();

        for (int i = 0; i<38; i++){
            pilo.getCartes().push(mazo.agafarCarta());
        }

        System.out.println("PILO");
        UI.mostrarCartes(new ArrayList<>(pilo.getCartes()));


        for (Carta c : mazo.getCartes()) {
            j1.addCarta(c);
        }

        System.out.println("MAZO");
        UI.mostrarCartes(j1.getCartes());



    }
}