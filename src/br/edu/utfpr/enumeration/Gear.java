package br.edu.utfpr.enumeration;

public enum Gear {
    HELMET("Helmet"),
    SUIT("Suit"),
    GAUNTLETS("Gauntlets"),
    BOOTS("Boots"),
    SHIELD("Shield");
     
    private String description;

    private Gear(String description) {
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
