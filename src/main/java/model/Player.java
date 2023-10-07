package model;

public class Player extends Characters {
    private int healCount;
    private static final double MAX_HEAL_MODIFIER = 0.3;
    private int health;


    public Player(String name, int attack, int defense, int health, int minDamage, int maxDamage) {
        super(name, attack, defense, health, minDamage, maxDamage);
        healCount = 4;
        this.health = health;
    }


    public void heal() {

        if (!isAlive()) {
            System.out.println(this.getName() + " мертв");
        } else if (healCount > 0) {
            int roundedHealAmount = (int) Math.round(MAX_HEAL_MODIFIER * getMaxHealth());
            if (getHealth() + roundedHealAmount < health) {
                setHealth(getHealth() + roundedHealAmount);
                healCount--;
                System.out.println(this.getName() + " исцелил себя на " + roundedHealAmount + " здоровье игрока " + getHealth());
            }
        }
        else {
            System.out.println("У " + this.getName() + " закончились исцеления.");
        }
    }
}

