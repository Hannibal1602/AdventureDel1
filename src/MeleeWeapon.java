public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortName, String longName, int damage) {
        super(shortName, longName, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
        // ingenting - sværdet slides ikke
    }

    @Override
    public String getAttackVerb() {
        return "swing";
    }

    @Override
    public String getUsesLeftText() {
        return "";
    }
}