package br.edu.utfpr.functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class RandomDefenseItems {
    
    private ArrayList<String> nomes = new ArrayList<>();
    
    public RandomDefenseItems() {
        nomes.add("Wit's End"); //0
        nomes.add("Cataclysm");
        nomes.add("Honor's End");
        nomes.add("Tormented Carapace");
        nomes.add("Vindication Shield Wall");
        nomes.add("Guard's Bronze Armament");
        nomes.add("Banished Copper Visage");
        nomes.add("Chaos Eater");
        nomes.add("Wisdom's Grasp, Light Shield of Thunder");
        nomes.add("Dawnbreaker, Guard of Darkness");  
        nomes.add("Soul Calibur");
        nomes.add("Last Rites");
        nomes.add("Supernova");
        nomes.add("Hero's Stand");
        nomes.add("Fusion Bastion");
        
        nomes.add("Footguards of Haunted Voices");//15
        nomes.add("Boots of Damned Illusions");
        nomes.add("Ivory Stompers of Lost Misery");
        nomes.add("Hidden Blade");
        nomes.add("Adamantite Greaves of Blind Torment");
        nomes.add("Ruby Infused Ivory Stompers");
        nomes.add("Protector's Ivory Sabatons");
        nomes.add("Sandals of Infinite Protection");
        nomes.add("Feet of Eternal Kings");
        nomes.add("Wool Footguards");
        
        nomes.add("Chestguard of Fleeting Punishment");//25
        nomes.add("Chestpiece of Haunted Vengeance");
        nomes.add("Ivory Greatplate of Conquered Visions");
        nomes.add("Titanium Tunic of Distant Lands");
        nomes.add("Recruit's Adamantite Armor");
        nomes.add("Guardian of the Lion");
        nomes.add("Raiment of Hallowed Lands");
        nomes.add("Vestment of Unholy Souls");
        nomes.add("Cloth Jerkin");
        nomes.add("Soulless Leather Robes");
        
        nomes.add("Casque of Ending Powers");//35
        nomes.add("Crown of Twisted Hope");
        nomes.add("Demise of Silence");
        nomes.add("Protector's Headguard of Life");
        nomes.add("Hero's Obsidian Visage");
        nomes.add("Coif of Lost Whispers");
        nomes.add("Mask of Smoldering Warlords");
        nomes.add("Tribute of Ashes");
        nomes.add("Blight of Fury");
        nomes.add("War-Forged Cap of the Mountain");
        nomes.add("Heavy Hide Mask of Broken Nightmares");
        nomes.add("Proud Wool Coif");      
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
