public class RangedWeapon extends Weapon {

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int damage, int ammunition) {
        super(shortName, longName, damage);
        this.ammunition = ammunition;
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public void use() {
        ammunition--;
    }

    @Override
    public String getAttackVerb() {
        return "fire";
    }

    @Override
    public String getUsesLeftText() {
        return ammunition + " shots left.";
    }
}