package common;

import pokemon.AbstractPokemon;

public class PokemonList extends DynamicList<AbstractPokemon> {
  public PokemonList() {

  }
  public AbstractPokemon getPokemonByName(String name) {
    Node<AbstractPokemon> current = this.head;
    while (current != null) {
      if (current.data.getName().equals(name)) {
        return current.data;
      }
      current = current.next;
    }
    return null;
  }

  @Override
  public String toString() {
    String str = "\nPokemons on the list:\n";
    Node<AbstractPokemon> current = this.head;
    while (current != null) {
      AbstractPokemon pkm = current.data;
      str += pkm.getName() + "HP: " + pkm.getBaseHP() + "/" + pkm.getActualHP() + ", ";
      current = current.next;
    }
    return str;
  }
}
