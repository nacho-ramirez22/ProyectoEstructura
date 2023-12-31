package main;

import common.DynamicList;
import common.PokemonList;
import gui.PantallaCombate;
import gui.PantallaFinal;
import gui.PokemonPoolDialog;
import pokemon.*;

import javax.swing.*;
import java.util.Random;

public class Game {

    final int MAX_POKEMON_TEAM = 4;

    public static Game instance;
    Pokedex cpuPokedex;
    Pokedex userPokedex;
    PokemonList pokemonPool; // Lista de Pokémon disponibles para el juego
    PantallaCombate pantallaCombate;
    PantallaFinal pantallaFinal;

    //constructor 
    public Game() {
        instance = this;

        this.pokemonPool = new PokemonList();
        this.cpuPokedex = new Pokedex(MAX_POKEMON_TEAM);
        this.userPokedex = new Pokedex(MAX_POKEMON_TEAM);
        this.generatePokemonPool();

    }

    public void startGame() {
        // launch principal GUI
        this.cpuPokedex.clear();
        this.userPokedex.clear();
        startBattle();
    }

    public void restartGame() {
        this.cpuPokedex.clear();
        this.userPokedex.clear();
        // send principal
    }

    public void stopGame() {

    }

    public void startBattle() {
        pokemonPool.printItemList();
        this.cpuPokedex = this.generateRandomPokedex(this.pokemonPool, MAX_POKEMON_TEAM);
        generateUserPokedex(MAX_POKEMON_TEAM);
    }

    public void generatePokemonPool() {
        this.pokemonPool.addItem(new WaterPokemon("Lapras", true));
        this.pokemonPool.addItem(new WaterPokemon("Blastoise", true));
        this.pokemonPool.addItem(new WaterPokemon("Golduck", true));

        this.pokemonPool.addItem(new FirePokemon("Arcanine", true));
        this.pokemonPool.addItem(new FirePokemon("Charizard", true));
        this.pokemonPool.addItem(new FirePokemon("Ninetales", true));

        this.pokemonPool.addItem(new NormalPokemon("Chansey", true));
        this.pokemonPool.addItem(new NormalPokemon("Snorlax", true));
        this.pokemonPool.addItem(new NormalPokemon("Ditto", true));
    }

    private Pokedex generateRandomPokedex(DynamicList<AbstractPokemon> pokemonPool, final int MAX_POKEMON) {
        Random randomizer = new Random(); // Creación de una instancia de Random 
        Pokedex randomPokemons = new Pokedex(4); //creación de una instancia de Pokedex con un tamaño inicial de 4.
        DynamicList<Integer> usedIndices = new DynamicList<>(); // Creación de una lista para mantener un seguimiento de los índices utilizados
        int counter = 0;

        while (counter < MAX_POKEMON) {
            int poolIndex = randomizer.nextInt(pokemonPool.getItemCount()); // Genera un índice aleatorio en el rango de la lista de Pokémon
            boolean used = usedIndices.containsItem(poolIndex); // Verifica si ya ha sido utilizado

            if (!used) {
                AbstractPokemon selectedPokemon = pokemonPool.getItem(poolIndex); // Obtiene el Pokémon seleccionado desde la lista
                AbstractPokemon copiedPokemon = copyPokemon(selectedPokemon); // Hace una copia
                randomPokemons.addPokemon(copiedPokemon); // Agrega el Pokémon copiado a la Pokedex aleatoria
                usedIndices.addItem(poolIndex); // Marca el índice como utilizado
                counter++;
            }
        }

        return randomPokemons;
    }

    //esto es para que el pokemon de user y pokemon cpu no sea el mismo
    public AbstractPokemon copyPokemon(AbstractPokemon abstractPokemon) {
        switch (abstractPokemon.getType()) {
            case WATER_TYPE -> {
                return new WaterPokemon(abstractPokemon);
            }
            case NORMAL_TYPE -> {
                return new NormalPokemon(abstractPokemon);
            }
            default -> {
                return new FirePokemon(abstractPokemon);
            }
        }
    }

   //pokedex user
    private void generateUserPokedex(int MAX_POKEMON) {
        JFrame frame = new JFrame();
        frame.setSize(750, 750);
        // frame.setVisible(true);
        PokemonPoolDialog pokemonPoolDialog = new PokemonPoolDialog(frame, this.pokemonPool);
        pokemonPoolDialog.setVisible(true);
        // System.out.println(this.userPokedex);
    }

    public void launchBattleGUI() {
        this.pantallaCombate = new PantallaCombate(this.userPokedex, this.cpuPokedex);
        this.pantallaCombate.setVisible(true);
    }

    public void launchFinishGUI(boolean win) {
        if (this.pantallaCombate != null) {
            this.pantallaCombate.dispose();
        }
        if (win) {
            this.pantallaFinal = new PantallaFinal("¡Felicidades!Has ganado");
        } else {
            this.pantallaFinal = new PantallaFinal("¡Uy!Has perdido");
        }
        pantallaFinal.setVisible(true);
    }

     //getter and setter
    public void setUserPokedex(Pokedex userPokedex) {
        this.userPokedex = userPokedex;
    }

    public Pokedex getUserPokedex() {
        return this.userPokedex;
    }

    public int getMAX_POKEMON_TEAM() {
        return MAX_POKEMON_TEAM;
    }

    public static Game getInstance() {
        return instance;
    }

    public static void setInstance(Game instance) {
        Game.instance = instance;
    }

    public Pokedex getCpuPokedex() {
        return cpuPokedex;
    }

    public void setCpuPokedex(Pokedex cpuPokedex) {
        this.cpuPokedex = cpuPokedex;
    }

    public PokemonList getPokemonPool() {
        return pokemonPool;
    }

    public void setPokemonPool(PokemonList pokemonPool) {
        this.pokemonPool = pokemonPool;
    }

    public PantallaCombate getPantallaCombate() {
        return pantallaCombate;
    }

    public void setPantallaCombate(PantallaCombate pantallaCombate) {
        this.pantallaCombate = pantallaCombate;
    }

    public PantallaFinal getPantallaFinal() {
        return pantallaFinal;
    }

    public void setPantallaFinal(PantallaFinal pantallaFinal) {
        this.pantallaFinal = pantallaFinal;
    }
}
