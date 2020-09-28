package fmont.sds.model;

import java.util.Objects;

public abstract class Demon {

    protected String name;
    protected int powerLevel;
    protected double hitRatio;
    protected int health;
    protected boolean isDown;
    protected int initialHealth;

    public Demon(String name, int powerLevel, double hitRatio, int health) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.hitRatio = hitRatio;
        this.health = health;
        this.isDown = false;
    }

    public Demon() {
    }

    public String getName() {
        return name;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public double getHitRatio() {
        return hitRatio;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDown() {
        return isDown;
    }
    public void setDown(boolean down) {
        isDown = down;
    }

    public void resetDemons() {
        health = initialHealth;
        isDown = false;
    }

    abstract void receiveDamage(Knight knight);

    abstract void attack (Knight knight);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demon demon = (Demon) o;
        return powerLevel == demon.powerLevel &&
                Double.compare(demon.hitRatio, hitRatio) == 0 &&
                health == demon.health &&
                Objects.equals(name, demon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, powerLevel, hitRatio, health);
    }

    @Override
    public String toString() {
        return "Demon{" +
                "name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                ", hitRatio=" + hitRatio +
                ", health=" + health +
                ", isDown=" + isDown +
                '}';
    }
}
