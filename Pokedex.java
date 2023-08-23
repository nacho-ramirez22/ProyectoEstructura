package pokemon;
import common.PokemonList;

public class Pokedex {
  PokemonList pokemons;
  int capacity;
  int size;

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Pokedex(int capacity) {
    this.capacity = capacity;
    this.pokemons = new PokemonList();
  }
  public boolean addPokemon(AbstractPokemon pokemon) {
    if (this.size < capacity) {
      this.pokemons.addItem(pokemon);
      this.size++;
      return true;
    }
    return false;
  }
  public void clear() {
    this.pokemons.clearItemList();
  }
  public AbstractPokemon getPokemon(int index) {
    return this.pokemons.getItem(index);
  }
  public AbstractPokemon getPokemon(String name) {
    for (int index = 0; index < this.pokemons.getItemCount() ; index++) {
      if (this.getPokemon(index).getName().equals(name)) {
        return this.getPokemon(index);
      }
    }
    return null;
  }
  public AbstractPokemon getNextPokemon() {
    for (int index = 0; index < this.pokemons.getItemCount() ; index++) {
      if ( !(this.getPokemon(index).isDefeatd)) {
        return this.getPokemon(index);
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "Pokedex{" +
            "pokemons=" + pokemons +
            ", capacity=" + capacity +
            ", size=" + size +
            '}';
  }
}
