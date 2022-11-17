package Model.Enemy;

import Model.MazeCharacter;

public class SadBoySea extends Enemy {

    public SadBoySea() {
        super("SadBoySea");
    }

    @Override
    public void specialAttack(MazeCharacter theEnemy) {
        System.out.println(getName() + " used Santoryu Ougi: Ichidai Sanzen Daisen Sekai!");
        int damageDealt = theEnemy.getHealthPoints() / 4;
        theEnemy.subtractHealth(damageDealt);
        System.out.println(theEnemy.getName() + " has " + theEnemy.getHealthPoints() + " health left!");
        theEnemy.subtractHealth(damageDealt);
    }
}
