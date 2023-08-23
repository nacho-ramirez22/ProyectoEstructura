package pokemon;

import common.DynamicList;

public class WaterPokemon extends AbstractPokemon{

  public WaterPokemon(String name, boolean b) {
    super(name, b);
    this.type = PokemonType.WATER_TYPE;

    this.baseHP = 190;
    this.actualHP = baseHP;

    this.attack = 55;
    this.defense = 45;
    this.specialAttack = 75;
    this.specialDefense = 65;

    this.weakness = new DynamicList<>();
    this.strenghts = new DynamicList<>();

    weakness.addItem(PokemonType.NORMAL_TYPE);
    strenghts.addItem(PokemonType.FIRE_TYPE);
  }

  public WaterPokemon(AbstractPokemon abstractPokemon) {
    super(abstractPokemon.name, true);
    this.type = PokemonType.WATER_TYPE;

    this.baseHP = 190;
    this.actualHP = baseHP;

    this.attack = 55;
    this.defense = 45;
    this.specialAttack = 75;
    this.specialDefense = 65;

    this.weakness = new DynamicList<>();
    this.strenghts = new DynamicList<>();

    weakness.addItem(PokemonType.NORMAL_TYPE);
    strenghts.addItem(PokemonType.FIRE_TYPE);
  }

  @Override
  public boolean updateStats(AbstractPokemon rival) {
    if (rival.getType() == PokemonType.FIRE_TYPE) {
      // if fire type, boost stats
      this.specialAttack = 85;
      this.specialDefense = 75;

      return true;
    } else {
      // otherwise not, set up to default
      this.attack = 55;
      this.defense = 45;
      this.specialAttack = 75;
      this.specialDefense = 65;
    }
    return false;
  }
}
