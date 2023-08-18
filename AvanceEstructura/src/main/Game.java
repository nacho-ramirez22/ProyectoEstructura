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
  PokemonList pokemonPool;
  PantallaCombate pantallaCombate;
  PantallaFinal pantallaFinal;

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
    this.cpuPokedex = this.generateRandomPokedex(this.pokemonPool,MAX_POKEMON_TEAM);
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
    Random randomizer = new Random();
    Pokedex randomPokemons = new Pokedex(4);
    DynamicList<Integer> usedIndices = new DynamicList<>();
    int counter = 0;

    while (counter < MAX_POKEMON) {
      int poolIndex = randomizer.nextInt(pokemonPool.getItemCount());
      boolean used = usedIndices.containsItem(poolIndex);

      if (!used) {
        AbstractPokemon selectedPokemon = pokemonPool.getItem(poolIndex);
        AbstractPokemon copiedPokemon = copyPokemon(selectedPokemon); // Make a copy
        randomPokemons.addPokemon(copiedPokemon);
        usedIndices.addItem(poolIndex);
        counter++;
      }
    }

    return randomPokemons;
  }

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

  