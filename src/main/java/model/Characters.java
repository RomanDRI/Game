package model;

import java.util.Random;

abstract class Characters {

    private static final int SIDES = 6;
    private static final int MIN_ROLL = 5;
    private static final int MIN_ATTACK_DAMAGE_VALUE = 1;
    private static final int MAX_ATTACK_DAMAGE_VALUE = 30;
    private final Random random = new Random();

    private final String name;
    private final int attack;
    private final int defense;
    private int health;
    private final int minDamage;
    private final int maxDamage;
    private final int maxHealth;


    public Characters(String name, int attack, int defense, int health, int minDamage, int maxDamage) {
        if (isValidAttributeValue(attack) && isValidAttributeValue(defense)) {
            this.name = name;
            this.attack = attack;
            this.defense = defense;
            this.health = health;
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
            this.maxHealth = health;
        } else {
            throw new IllegalArgumentException("Значение атаки или защиты должно быть между "
                    + MIN_ATTACK_DAMAGE_VALUE + " и " + MAX_ATTACK_DAMAGE_VALUE + ".");
        }
    }

    public void attack(Characters target) {
        int attackModifier = calculateAttackModifier(target);
        if (isAttackSuccessful(attackModifier)) {
            int damage = calculateDamage();
            System.out.println(name + " атакует и наносит " + damage + " урона " + target.getName() + ".");
            target.takeDamage(damage);
        } else {
            System.out.println(name + " попытался атаковать, но не нанес урона " + target.getName() + ".");
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " получает " + damage + " урона и остается с " + health + " здоровья.");
    }

    public boolean isAlive() {
        return health > 0;
    }

    protected String getName() {
        return name;
    }

    protected int getHealth() {
        return health;
    }

    protected int getMaxHealth() {
        return maxHealth;
    }

    protected void setHealth(int health) {
        this.health = health;
    }


    protected int calculateAttackModifier(Characters target) {
        return attack - target.defense + 1;
    }

    protected boolean isAttackSuccessful(int attackModifier) {
        int numDice = Math.max(attackModifier, 1);
        for (int i = 0; i < numDice; i++) {
            int roll = random.nextInt(SIDES) + 1;
            if (roll >= MIN_ROLL) {
                return true;
            }
        }
        return false;
    }

    protected int calculateDamage() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    private boolean isValidAttributeValue(int value) {
        return value >= MIN_ATTACK_DAMAGE_VALUE && value <= MAX_ATTACK_DAMAGE_VALUE;
    }
}