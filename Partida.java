package uno;

import uno.logica.*;
import uno.interficie.UI;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    private OrdreJugadors ordreJugadors;
    private Mazo mazo;
    private Pilo pilo;
    private ArrayList<Jugador> jugadors;

    public void jugar() {
        ordreJugadors = new OrdreJugadors();
        mazo = new Mazo();
        pilo = new Pilo();
        jugadors = ordreJugadors.crearJugadors();

        preparar();

        while (torn()) {
        }

        System.out.println("¡" + ordreJugadors.getJugadorActiu() + " ha guanyat!");
    }

    private void preparar() {
        mazo.barrejar();
        repartirCartes();
        mazo.tirarCartaPilo(pilo);
    }

    private boolean torn() {
        Jugador jugadorActiu = getJugadorActiu();

        if (jugadorActiu.nombreDeCartes() == 0) {
            return false;
        }

        System.out.println("Torn de " + jugadorActiu.getNom());
        System.out.println("Carta en joc:");
        UI.mostrarCarta(pilo.consultarCarta());

        System.out.println("Les teves cartes:");
        UI.mostrarCartes(jugadorActiu.getCartes());

        Scanner scanner = new Scanner(System.in);

        // Robar fins poder tirar
        while (!jugadorActiu.potTirarCarta(pilo.consultarCarta())) {
            if (mazo.getCartes().isEmpty()) {
                mazo.reiniciarMazo(pilo.consultarCarta(), pilo);
            }
            System.out.println("No pots tirar, robes una carta...");
            jugadorActiu.robarCarta(mazo);
            System.out.println("Cartes despres de robar(Resa perque no siguin moltes )");
            UI.mostrarCartes(jugadorActiu.getCartes());
        }


        boolean cartaTirada = false;
        while (!cartaTirada) {
            System.out.println("Tria una carta:");
            int eleccio = scanner.nextInt() - 1; // sino amb peta

            if (eleccio >= 0 && eleccio < jugadorActiu.getCartes().size()) {
                Carta cartaSeleccionada = jugadorActiu.getCartes().get(eleccio);

                if (Regles.sonCartesCompatibles(cartaSeleccionada, pilo.consultarCarta())) {
                    jugadorActiu.tirarCartes(pilo, cartaSeleccionada);
                    System.out.println(jugadorActiu.getNom() + " tira:");
                    UI.mostrarCarta(cartaSeleccionada);
                    cartaTirada = true;
                } else {
                    System.out.println("No pots tirar aquesta carta. Torna a provar.");
                }
            } else {
                System.out.println("Número de carta invàlid. Torna a provar.");
            }
        }

        ordreJugadors.passarTorn();
        return true;
    }

    private Jugador getJugadorActiu() {
        String nomJugadorActiu = ordreJugadors.getJugadorActiu();
        for (Jugador jugador : jugadors) {
            if (jugador.getNom().equals(nomJugadorActiu)) {
                return jugador;
            }
        }
        return null;
    }

    private void repartirCartes() {
        for (Jugador jugador : jugadors) {
            for (int i = 0; i < 7; i++) {
                jugador.robarCarta(mazo);
            }
        }
    }
}
