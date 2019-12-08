package br.edu.utfpr.functions;

import java.util.ArrayList;

public class RandomAttackItems {
    
    private final ArrayList<String> nomes = new ArrayList<>();
    
    public RandomAttackItems() {
        nomes.add("Z Saber"); //0
        nomes.add("Buster Sword");
        nomes.add("Frostmourne");
        nomes.add("High Frequency Blade");
        nomes.add("Sabre de Luz");
        nomes.add("Sparda");
        nomes.add("Master Sword");
        nomes.add("Chaos Eater");
        nomes.add("Blade of Olympus");
        nomes.add("Energy Sword");  
        nomes.add("Soul Calibur");
        nomes.add("Dragon Sword");
        nomes.add("Blade of the Grave");
        nomes.add("Desolation Claymore");
        nomes.add("Blood-Forged Blade");
        
        nomes.add("Katana");//15
        nomes.add("Gunblade");
        nomes.add("Sword of Mana");
        nomes.add("Hidden Blade");
        nomes.add("Masamune");
        nomes.add("Murasame");
        nomes.add("Sabre Curvo");
        nomes.add("Curtana");
        nomes.add("Broken Promise");
        nomes.add("Trinity");
        
        nomes.add("Arco da Morte Sussurrante");//25
        nomes.add("Arco Rubrica de Câncer");
        nomes.add("Arco Ishis Klamaria");
        nomes.add("Arco Pingo de Dor");
        nomes.add("Dracarys");
        nomes.add("Red Scorpion");
        nomes.add("Phoenix Inferno");
        nomes.add("Stringbean");
        nomes.add("Stardust");
        nomes.add("Siren's Song");
        
        nomes.add("Venom");//35
        nomes.add("Ray");
        nomes.add("Lament");
        nomes.add("Doom's Boomerang");
        nomes.add("Greedy Throwing Knife");
        nomes.add("Scarlet");
        nomes.add("Vengeful Bolt");
        nomes.add("Lustful Javelin");
        nomes.add("Oblivion");
        nomes.add("Hero's Boomerang");
        nomes.add("Uppercut");
        nomes.add("Cosmo");      
    }
    
    public int getSize(){
        return nomes.size();
    }
    
    public String getNome(int index){
        return nomes.get(index);
    }
    
    public boolean verifyText(String name){
        for (String nome : nomes) {
            if(name.equals(nome))
                return true;
        }
        return false;
    }
    //return nomes.stream().anyMatch((String item) -> j.equals(nomes)); //returb true if there's a name equal of any of list
}
