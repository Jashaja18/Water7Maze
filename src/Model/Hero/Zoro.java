package Model.Hero;

import Model.MazeCharacter;

import java.util.Random;

public class Zoro extends Hero {
    private final int myMinSpecialDamage = 40;
    private final int myMaxSpecialDamage = 60;

    public Zoro() {
        super("Zoro", 110, 8, 15, 25,
                .6, .2, .4, 4);
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        Random chance = new Random();
        Random damage = new Random();
        if (chance.nextFloat() <= getSpecialChance()) {
            int damageDealt = damage.nextInt(myMaxSpecialDamage + 1 - myMinSpecialDamage) + myMinSpecialDamage;
            theEnemy.subtractHealth(damageDealt);
            System.out.println(getName() + " used purgatory onigiri and dealt " + damageDealt + " damage!");
        } else {
            System.out.println(getName() + " failed to use purgatory onigiri!");
        }
    }
}
