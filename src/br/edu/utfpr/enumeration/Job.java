package br.edu.utfpr.enumeration;

public enum Job {
    WARRIOR("Warrior"),
    ARCHER("Archer"),
    ROGUE("Rogue"),
    NINJA("Ninja");
    
    private String description;

    private Job(String description) {
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