/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avanceestructura;

/**
 *
 * @author USUARIO
 */

import java.util.Scanner;

public class JuegoPokemon {
    private Pokemon[] pokedexJugador;
    private Pokemon[] pokedexCPU;

    public JuegoPokemon() {
        pokedexJugador = new Pokemon[4];
        pokedexCPU = new Pokemon[4];
    }

    public void iniciarJuego() {
        System.out.println("Bienvenido al juego de Pokemon!");

        seleccionarPokemonJugador();
        asignarPokemonAleatorioCPU();

        System.out.println("¡Comienza la batalla!");

        Pokemon pokemonJugador = seleccionarPokemonBatallaJugador();
        Pokemon pokemonCPU = pokedexCPU[0];

        batallaPokemon(pokemonJugador, pokemonCPU);

        if (pokemonJugador.getHP() > 0) {
            System.out.println("¡Felicidades! Has ganado la batalla.");
        } else {
            System.out.println("¡Oh no! Has perdido la batalla.");
        }
    }

    private void seleccionarPokemonJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona 4 Pokemon para la batalla:");

        for (int i = 0; i < 4; i++) {
            System.out.println("Selecciona el Pokemon numero " + (i + 1) + ":");

            int opcion;
            do {
                System.out.println("1. Rattata (Normal)");
                System.out.println("2. Charmander (Fuego)");
                System.out.println("3. Squirtle (Agua)");
                System.out.print("Elige una opcion: ");
                opcion = scanner.nextInt();
            } while (opcion < 1 || opcion > 3);

            switch (opcion) {
                case 1:
                    pokedexJugador[i] = new Pokemon("Rattata", "Normal", 150, 50, 35, 70, 60);
                    break;
                case 2:
                    pokedexJugador[i] = new Pokemon("Charmander", "Fuego", 115, 70, 45, 80, 60);
                    break;
                case 3:
                    pokedexJugador[i] = new Pokemon("Squirtle", "Agua", 190, 55, 45, 75, 65);
                    break;
            }
        }
    }

    private void asignarPokemonAleatorioCPU() {
        String[] nombresPokemonCPU = {"Pikachu", "Bulbasaur", "Vulpix"};

        for (int i = 0; i < 4; i++) {
            int indiceAleatorio = (int) (Math.random() * nombresPokemonCPU.length);
            pokedexCPU[i] = new Pokemon(nombresPokemonCPU[indiceAleatorio], obtenerTipoAleatorio(), 150, 50, 35, 70, 60);
        }
    }

    private String obtenerTipoAleatorio() {
        String[] tiposPokemonCPU = {"Normal", "Fuego", "Agua"};
        int indiceAleatorio = (int) (Math.random() * tiposPokemonCPU.length);
        return tiposPokemonCPU[indiceAleatorio];
    }

    private void batallaPokemon(Pokemon pokemonJugador, Pokemon pokemonCPU) {
        boolean turnoJugador = true;
        Scanner scanner = new Scanner(System.in);

        while (pokemonJugador.getHP() > 0 && pokemonCPU.getHP() > 0) {
            if (turnoJugador) {
                System.out.println("¡Es el turno del jugador!");
                System.out.println("Elige una acción:");
                System.out.println("1. Atacar");
                System.out.println("2. Cambiar de Pokemon");
                System.out.print("Elige una opción: ");

                int opcion = obtenerNumeroEntero(scanner);

                if (opcion == 1) {
                    int danio = calcularDanio(pokemonJugador, pokemonCPU);
                    pokemonJugador.atacar(pokemonCPU, danio);
                    System.out.println("El Pokemon del jugador atacó al Pokemon del oponente y le causó " + danio + " de daño.");
                } else if (opcion == 2) {
                    System.out.println("Selecciona un Pokemon para la batalla:");
                    pokemonJugador = seleccionarPokemonBatallaJugador();
                }
            } else {
                System.out.println("¡Es el turno del oponente (CPU)!");
                int danio = calcularDanio(pokemonCPU, pokemonJugador);
                pokemonCPU.atacar(pokemonJugador, danio);
                System.out.println("El Pokemon del oponente atacó al Pokemon del jugador y le causó " + danio + " de daño.");
            }

            System.out.println("Vida restante del Pokemon del jugador: " + pokemonJugador.getHP());
            System.out.println("Vida restante del Pokemon del oponente: " + pokemonCPU.getHP());

            turnoJugador = !turnoJugador;
        }
    }

    private Pokemon seleccionarPokemonBatallaJugador() {
        Scanner scanner = new Scanner(System.in);
        int indicePokemon;

        do {
            System.out.println("1. Rattata (Normal)");
            System.out.println("2. Charmander (Fuego)");
            System.out.println("3. Squirtle (Agua)");
            System.out.print("Elige el número del Pokemon: ");
            indicePokemon = obtenerNumeroEntero(scanner) - 1;
        } while (indicePokemon < 0 || indicePokemon >= pokedexJugador.length || pokedexJugador[indicePokemon] == null);

        return pokedexJugador[indicePokemon];
    }

    private int calcularDanio(Pokemon atacante, Pokemon objetivo) {
        int danio = atacante.getAtaque();

        if (atacante.getTipo().equals("Normal") && objetivo.getTipo().equals("Fuego")) {
            danio = (int) (danio * 1.5);
        } else if (atacante.getTipo().equals("Fuego") && objetivo.getTipo().equals("Normal")) {
            danio = (int) (danio * 1.5);
        } else if (atacante.getTipo().equals("Agua") && objetivo.getTipo().equals("Fuego")) {
            danio = (int) (danio * 1.5);
        } else if (atacante.getTipo().equals("Fuego") && objetivo.getTipo().equals("Agua")) {
            danio = (int) (danio * 1.5);
        }

        return danio;
    }

    private int obtenerNumeroEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Ingresa un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        JuegoPokemon juego = new JuegoPokemon();
        juego.iniciarJuego();
    }
}

