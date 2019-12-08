package br.edu.utfpr.enumeration;

public enum Rarity {
    COMMON("Common"),
    RARE("Rare"),
    MYTHIC("Mythic"),
    LEGENDARY("Legendary");
    
    private String description;

    private Rarity(String description) {
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
