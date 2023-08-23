package pokemon;

import common.DynamicList;

public class NormalPokemon extends AbstractPokemon{
  public NormalPokemon(String name, boolean haveIconImage) {
    super(name, haveIconImage);
    this.type = PokemonType.NORMAL_TYPE;

    this.baseHP = 150;
    this.actualHP = baseHP;

    this.attack = 50;
    this.defense = 35;
    this.specialAttack = 70;
    this.specialDefense = 60;

    this.weakness = new DynamicList<>();
    this.strenghts = new DynamicList<>();

    weakness.addItem(PokemonType.FIRE_TYPE);
    strenghts.addItem(PokemonType.WATER_TYPE);
  }

  public NormalPokemon(AbstractPokemon abstractPokemon) {
    super(abstractPokemon.name, true);
    this.type = PokemonType.NORMAL_TYPE;

    this.baseHP = 150;
    this.actualHP = baseHP;

    this.attack = 50;
    this.defense = 35;
    this.specialAttack = 70;
    this.specialDefense = 60;

    this.weakness = new DynamicList<>();
    this.strenghts = new DynamicList<>();

    weakness.addItem(PokemonType.FIRE_TYPE);
    strenghts.addItem(PokemonType.WATER_TYPE);
  }

  @Override
  public boolean updateStats(AbstractPokemon rival) {
    if (rival.getType() == PokemonType.WATER_TYPE) {
      // if water type, boost stats
      this.specialAttack = 75;
      this.specialDefense = 65;

      return true;
    } else {
      // otherwise not, set up default
      this.attack = 50;
      this.defense = 35;
      this.specialAttack = 70;
      this.specialDefense = 60;
    }
    return false;
  }
}

