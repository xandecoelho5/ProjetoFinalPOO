package br.edu.utfpr.enumeration;

public enum Type {
    NORMAL("Normal"),
    GIANT("Giant"),
    BOSS("Boss"),
    RAIDBOSS("RaidBoss");
    
    private String description;

    private Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }
}

