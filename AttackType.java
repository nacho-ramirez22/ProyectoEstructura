package pokemon;

public enum AttackType {
  PHYSIC_ATTACK(1),
  SPECIAL_ATTACK(2);

  private final int value;

  AttackType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
