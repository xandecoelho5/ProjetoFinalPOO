package br.edu.utfpr.enumeration;

public enum Race {
    ORC("Orc"),
    UNDEAD("Undead"),
    HUMAN("Human"),
    DEMON("Demon"),
    TROLL("Troll");
    
    private String description;

    private Race(String description) {
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
