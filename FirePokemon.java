package pokemon;

import common.DynamicList;

public class FirePokemon extends AbstractPokemon{
  public FirePokemon(String name, boolean haveIconImage) {
    super(name, haveIconImage);
    this.type = PokemonType.FIRE_TYPE;

    this.baseHP = 115;
    this.actualHP = baseHP;

    this.attack = 70;
    this.defense = 45;
    this.specialAttack = 80;
    this.specialDefense = 60;

    this.weakness = new DynamicList<>();
    this.strenghts = new DynamicList<>();

    weakness.addItem(PokemonType.WATER_TYPE);
    strenghts.addItem(PokemonType.NORMAL_TYPE);
  }

  public FirePokemon(AbstractPokemon abstractPokemon) {
    super(abstractPokemon.name, true);
    this.type = PokemonType.FIRE_TYPE;

    this.baseHP = 115;
    this.actualHP = baseHP;

    this.attack = 70;
    this.defense = 45;
    this.specialAttack = 80;
    this.specialDefense = 60;

    this.weakness = new DynamicList<>();
    this.strenghts = new DynamicList<>();

    weakness.addItem(PokemonType.WATER_TYPE);
    strenghts.addItem(PokemonType.NORMAL_TYPE);
  }

  @Override
  public boolean updateStats(AbstractPokemon rival) {
    if (rival.getType() == PokemonType.NORMAL_TYPE) {
      // if water type, boost stats
      this.specialAttack = 85;
      this.specialDefense = 70;

      return true;
    } else {
      // otherwise not, set up default
      this.attack = 70;
      this.defense = 45;
      this.specialAttack = 80;
      this.specialDefense = 60;
    }
    return false;
  }
}
