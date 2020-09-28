package fmont.sds.model;

import java.util.Objects;

public abstract class Knight implements Comparable<Knight>{

    protected String name;
    protected int powerLevel;
    protected double hitRatio;
    protected int health;
    protected double money;
    protected boolean isDown = false;
    protected Level currentLevel;

    public Knight(String name, int powerLevel, double hitRatio, int health, double money) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.hitRatio = hitRatio;
        this.health = health;
        this.money = money;
        this.isDown = false;
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

    public double getMoney() {
        return money;
    }

    public boolean isDown() {
        return isDown;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void showHealth() {
        System.out.println("Current health: "+this.getHealth()+" HP.");
    }

    public boolean enterInLevel(Level level) {
        if(isNotYetInLevel() && level.getHero() == null) {
            level.admitHero(this);
            this.currentLevel = level;
            return true;
        }else {
            System.out.println("Not possible");
            return false;
        }
    }

    private boolean isNotYetInLevel() {
        return this.currentLevel == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return powerLevel == knight.powerLevel &&
                Double.compare(knight.hitRatio, hitRatio) == 0 &&
                health == knight.health &&
                Objects.equals(name, knight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, powerLevel, hitRatio, health);
    }

    @Override
    public int compareTo(Knight o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", powerLevel=" + powerLevel +
                ", hitRatio=" + hitRatio +
                ", health=" + health +
                ", money=" + money +
                ", isDown=" + isDown +
                ", currentLevel=" + currentLevel +
                '}';
    }

    abstract void receiveDamage(Demon demon);

    abstract void attack(Demon demon);
}
