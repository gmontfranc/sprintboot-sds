//package fmont.sds.model;
//
//import java.util.ArrayList;
//import java.util.Random;
//
//import static com.francisco.game.Generator.FAKER;
//
//public class Level {
//
//    private int number;
//
//    private ArrayList<Demon> demonList;
//
//    private final Random rng = new Random();
//    private Player hero;
//    private LevelStatus status;
//    private LevelType levelType;
//
//    private Level(int number, LevelType levelType) {
//        this.levelType = levelType;
//        this.status = LevelStatus.NOT_STARTED;
//        this.number = number;
//        demonList = new ArrayList<>();
//        this.createLevel(number);
//    }
//
//    public Level(LevelType levelType, ArrayList<Demon> demons, int difficulty) {
//        this.levelType = levelType;
//        this.status = LevelStatus.NOT_STARTED;
//        this.number = difficulty;
//        demonList = demons;
//    }
//
//    public Level() {
//
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public ArrayList<Demon> getDemonList() {
//        return demonList;
//    }
//
//    public LevelType getLevelType() {
//        return levelType;
//    }
//
//    public static Level generateLevel(int number, LevelType levelType) {
//        return new Level(number, levelType);
//    }
//
//    public void resetLevel() {
//        if (status == LevelStatus.IN_PROGRESS || status == LevelStatus.DONE) {
//            for (Demon d : demonList) {
//                d.resetDemons();
//            }
//        } else {
//            throw new IllegalStateException(getLevelType().getName() + ", cannot be reset right now.");
//        }
//
//    }
//
//    public void handleStatus() {
//        switch (status) {
//
//            case NOT_STARTED:
//                break;
//            case IN_PROGRESS:
//                break;
//            case DONE:
//                break;
//        }
//    }
//
//
//    public Player getHero() {
//            return hero;
//
//    }
//
//    public void admitHero(Player player) {
//        if (hasAlreadyHeroIn()) {
//            throw new IllegalArgumentException(this.levelType.getName() + ", is already taken by: " + this.hero.getName());
//        }
//        this.status = LevelStatus.IN_PROGRESS;
//        this.hero = player;
//    }
//
//    public void kickHero(Player player) {
//        if (hasAlreadyHeroIn(player)) {
//            System.out.println(this.hero.getName() + " has been removed from " + this.levelType.getName());
//            this.hero = null;
//            this.status = LevelStatus.NOT_STARTED;
//            player.setCurrentLevel(null);
//        } else {
//            System.out.println("Sorry, " + player.getName() + " is not in this level.");
//        }
//
//    }
//
//    private boolean hasAlreadyHeroIn() {
//        return this.hero != null;
//    }
//
//
//    private boolean hasAlreadyHeroIn(Player player) {
//        return this.hero != null && this.hero.equals(player);
//    }
//
//    public void showHeroInLevel() {
//        if (hasAlreadyHeroIn()) {
//            System.out.println(this.hero.getName() + " is currently in " + this.levelType.getName() + " with " + this.demonList.size() + " demons remaining.");
//        } else {
//            System.out.println("Sorry there is no one yet on this level.");
//        }
//    }
//
//    private void createLevel(int number) {
//        switch (number) {
//            case 1:
//                this.createEasyLevel(rng.nextInt(2) + 1);
//                System.out.println("Level 1 created with : " + demonList.size() + " demons");
//                break;
//            case 2:
//                this.createMediumLevel(rng.nextInt(4) + 2);
//                System.out.println("Level 2 created with : " + demonList.size() + " demons");
//                break;
//        }
//    }
//
//    public void showMonstersInLevel() {
//        if (this.demonList.size() > 0) {
//            System.out.println("Castle level: " + this.number + ", contains the following demons: \n");
//            for (Demon d : demonList) {
//                System.out.println("- " + d.getName() + ", power level: " + d.getPowerLevel() + ", health: " + d.getHealth() + " HP.");
//            }
//        } else {
//            System.out.println("Castle level: " + this.number + " is empty at the moment. Demons should arrive shortly");
//        }
//    }
//
//    private void createEasyLevel(int random) {
//        for (int i = 0; i < random; i++) {
//            switch (levelType.getDemonType()) {
//
//                case CRIMSONDEMON:
//                    demonList.add(new CrimsonDemon(FAKER.dragonBall().character(), rng.nextInt(1001) + 500));
//                    break;
//                case BLUEDEMON:
//                    demonList.add(new BlueDemon(FAKER.dragonBall().character(), rng.nextInt(1251) + 500));
//                    break;
//                case JIKKAI:
//                    break;
//            }
//        }
//    }
//
//    private void createMediumLevel(int random) {
//        for (int i = 0; i < random; i++) {
//            switch (levelType.getDemonType()) {
//
//                case CRIMSONDEMON:
//                    demonList.add(new CrimsonDemon(FAKER.dragonBall().character(), rng.nextInt(1501) + 500));
//                    break;
//                case BLUEDEMON:
//                    demonList.add(new BlueDemon(FAKER.dragonBall().character(), rng.nextInt(1751) + 500));
//                    break;
//                case JIKKAI:
//                    break;
//            }
//
//        }
//    }
//
//}
