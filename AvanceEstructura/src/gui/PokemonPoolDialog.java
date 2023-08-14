package gui;

import common.PokemonList;
import pokemon.AbstractPokemon;
import main.Game;
import pokemon.Pokedex;
import javax.swing.*;
import java.awt.*;

public class PokemonPoolDialog extends JDialog {
  private final JPanel buttonPanel;
  private final PokemonList pokemonPool;
  private Pokedex selectedPokemons;
  private int pokemonCounter;

  public PokemonPoolDialog(JFrame parent, PokemonList pokemonPool) {
    super(parent, "Pokemon Pool", true);
    setLayout(new BorderLayout());
    this.pokemonPool = pokemonPool;
    selectedPokemons = new Pokedex(4);

    buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
    buttonPanel.setPreferredSize(new Dimension(600, 600)); // Increase the panel size to show buttons properly

    for (int index = 0; index < this.pokemonPool.getItemCount(); index++) {
      AbstractPokemon pokemon = this.pokemonPool.getItem(index);
      JButton newButton = new JButton(pokemon.getName());
      newButton.setIcon(new ImageIcon(pokemon.getImageIcon()));
      newButton.setPreferredSize(new Dimension(200, 200)); // Increase the button size to make them visible

      newButton.addActionListener(e -> {
        newButton.setEnabled(false);
        this.pokemonCounter++;
        AbstractPokemon clickedPokemon = pokemonPool.getPokemonByName(newButton.getText());
        System.out.println("Click: " + clickedPokemon);
        System.out.println(selectedPokemons.addPokemon(clickedPokemon));
        if (this.pokemonCounter >= 4) {
          this.dispose();
          Game.instance.setUserPokedex(this.selectedPokemons);
          System.out.println(Game.instance.getUserPokedex());
          Game.instance.launchBattleGUI();
        }
      });
      buttonPanel.add(newButton);
    }

    add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center of the dialog

    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setSize(750, 750);
    setLocationRelativeTo(parent);
    setResizable(false);
  }


  public JPanel getButtonPanel() {
    return buttonPanel;
  }

  public PokemonList getPokemonPool() {
    return pokemonPool;
  }

  public Pokedex getSelectedPokemons() {
    return selectedPokemons;
  }

  public int getPokemonCounter() {
    return pokemonCounter;
  }

  public void setPokemonCounter(int pokemonCounter) {
    this.pokemonCounter = pokemonCounter;
  }
}
