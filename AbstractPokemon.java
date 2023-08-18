package pokemon;
//
import common.GenericList;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public abstract class AbstractPokemon {
  protected PokemonType type;
  protected GenericList<PokemonType> weakness;
  protected GenericList<PokemonType> strenghts;
  protected double baseHP;
  protected double actualHP;
  protected double attack;
  protected double defense;
  protected double specialAttack;
  protected double specialDefense;
  protected  GenericList<AttackType> attacks;
  protected boolean isDefeatd;
  protected URL imageIconLocation;
  protected int turnsInGame;
  protected String name;

  final String POKEMON_IMAGES_API = "https://img.pokemondb.net/sprites/lets-go-pikachu-eevee/normal/";
  final String POKEMON_IMAGES_EXTENSION = ".png";

  public AbstractPokemon(final String name) {
    this.name = name;
  }
  public AbstractPokemon(final String name, boolean haveIconImage) {
    this.name = name;
    if (haveIconImage) {
      try {
        this.imageIconLocation = new URL(POKEMON_IMAGES_API + name.toLowerCase() + POKEMON_IMAGES_EXTENSION);
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void attack(AbstractPokemon pokemon, AttackType attackType) {
    double damage;
    if (attackType == AttackType.SPECIAL_ATTACK) {
      damage = this.specialAttack;
      damage = pokemon.getSpecialDefense() - damage;
    } else {
      damage = pokemon.getDefense() - this.attack;
    }

    pokemon.setActualHP(pokemon.actualHP - damage);
  }
  public abstract boolean updateStats(AbstractPokemon rival);

  // Getters and Setters
  public PokemonType getType() {
    return type;
  }

  public void setType(PokemonType type) {
    this.type = type;
  }

  public GenericList<PokemonType> getWeakness() {
    return weakness;
  }

  public void setWeakness(GenericList<PokemonType> weakness) {
    this.weakness = weakness;
  }

  public GenericList<PokemonType> getStrenghts() {
    return strenghts;
  }

  public void setStrenghts(GenericList<PokemonType> strenghts) {
    this.strenghts = strenghts;
  }

  public double getBaseHP() {
    return baseHP;
  }

  public void setBaseHP(double baseHP) {
    this.baseHP = baseHP;
  }

  public double getActualHP() {
    return actualHP;
  }

  public void setActualHP(double actualHP) {
    this.actualHP = actualHP;
  }

  public double getAttack() {
    return attack;
  }

  public void setAttack(double attack) {
    this.attack = attack;
  }

  public double getDefense() {
    return defense;
  }

  public void setDefense(double defense) {
    this.defense = defense;
  }

  public double getSpecialAttack() {
    return specialAttack;
  }

  public void setSpecialAttack(double specialAttack) {
    this.specialAttack = specialAttack;
  }

  public double getSpecialDefense() {
    return specialDefense;
  }

  public void setSpecialDefense(double specialDefense) {
    this.specialDefense = specialDefense;
  }

  public GenericList<AttackType> getAttacks() {
    return attacks;
  }

  public void setAttacks(GenericList<AttackType> attacks) {
    this.attacks = attacks;
  }

  public boolean isDefeatd() {
    return isDefeatd;
  }

  public void setDefeatd(boolean defeatd) {
    isDefeatd = defeatd;
  }

  public URL getImageIcon() {
    return this.imageIconLocation;
  }

  public void setImageIcon(URL imageIcon) {
    this.imageIconLocation = imageIcon;
  }

  public int getTurnsInGame() {
    return turnsInGame;
  }

  public void setTurnsInGame(int turnsInGame) {
    this.turnsInGame = turnsInGame;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AbstractPokemon that)) return false;
    return Double.compare(that.baseHP, baseHP) == 0 && Double.compare(that.actualHP, actualHP) == 0 && Double.compare(that.attack, attack) == 0 && Double.compare(that.defense, defense) == 0 && Double.compare(that.specialAttack, specialAttack) == 0 && Double.compare(that.specialDefense, specialDefense) == 0 && isDefeatd == that.isDefeatd && turnsInGame == that.turnsInGame && type == that.type && Objects.equals(weakness, that.weakness) && Objects.equals(strenghts, that.strenghts) && Objects.equals(attacks, that.attacks) && Objects.equals(imageIconLocation, that.imageIconLocation) && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, weakness, strenghts, baseHP, actualHP, attack, defense, specialAttack, specialDefense, attacks, isDefeatd, imageIconLocation, turnsInGame, name);
  }

  @Override
  public String toString() {
    return "AbstractPokemon{" +
            "name='" + name +
            "type=" + type +
            ", baseHP=" + baseHP +
            ", actualHP=" + actualHP +
            ", attack=" + attack +
            ", defense=" + defense +
            ", specialAttack=" + specialAttack +
            ", specialDefense=" + specialDefense +
            ", isDefeatd=" + isDefeatd +
            ", imageIconLocation=" + imageIconLocation + '\'' +
            '}';
  }
}