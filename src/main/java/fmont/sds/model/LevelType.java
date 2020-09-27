package fmont.sds.model;

public enum LevelType {

    CASTLEVANIA("Castelvania", DemonType.CRIMSONDEMON), DANAFOR("Danafor", DemonType.BLUEDEMON);

    private final String name;
    private final DemonType demonType;

    LevelType(String name, DemonType demonType) {
        this.name = name;
        this.demonType = demonType;
    }

    public String getName() {
        return name;
    }

    public DemonType getDemonType() {
        return demonType;
    }


}
