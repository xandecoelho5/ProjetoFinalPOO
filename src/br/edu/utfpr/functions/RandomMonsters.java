package br.edu.utfpr.functions;

import java.util.ArrayList;

public class RandomMonsters {
    private ArrayList<String> nomes = new ArrayList<>();
    
    public RandomMonsters() {
        nomes.add("Acheri");
        nomes.add("Adlet");
        nomes.add("Aigamuxa");
        nomes.add("Ankou");
        nomes.add("Backoo");
        nomes.add("Baku");
        nomes.add("Behemoth");
        nomes.add("Bugul Noz");
        nomes.add("Cerastes");
        nomes.add("Changeling");
        nomes.add("Chukwa");
        nomes.add("Cucuy");
        nomes.add("Dullahan");
        nomes.add("Dybbuk");
        nomes.add("Empusa");
        nomes.add("Fetch");
        nomes.add("Fuath");
        nomes.add("Gallu");
        nomes.add("Garmr");
        nomes.add("Ghoul");
        nomes.add("Hiderigami");
        nomes.add("Ictiocentauro");
        nomes.add("Ishigaq");
        nomes.add("Jackalope");
        nomes.add("Jumbee");
        nomes.add("Kappa");
        nomes.add("Kanedama");
        nomes.add("Leviatã");
        nomes.add("Lilitu");
        nomes.add("Mairu");
        nomes.add("Mogwai");
        nomes.add("Peng");
        nomes.add("Orobas");
        nomes.add("Obake");
        nomes.add("Nurikabe");
        nomes.add("Nekomusume");       
        nomes.add("Blightcrackle");
        nomes.add("Dustmask");
        nomes.add("Thornpod");
        nomes.add("Sorrowghoul");
        nomes.add("The Creepy Eyes");
        nomes.add("The Fickle Hybrid");
        nomes.add("The Icy Horror");
        nomes.add("The Feathered Vision Crocodile");
        nomes.add("The Blind World Leopard");
        nomes.add("The Ebon Mountain Hog");  
        nomes.add("Sorrowfiend");
        nomes.add("Mourngolem");
        nomes.add("Plaguething");
        nomes.add("Smokewoman");
        nomes.add("The Creepy Abortion");
        nomes.add("The Broken Figure");
        nomes.add("The Electric Wraith");
        nomes.add("The Mad Dread Deer");
        nomes.add("The Taloned World Cat");
        nomes.add("The Ravaging Moon Gorilla");
        nomes.add("Taintseeker");
        nomes.add("Vamppest");
        nomes.add("Flameling");
        nomes.add("Steambrood");
        nomes.add("The Aged Being");
        nomes.add("The Disfigured Phenomenon");
        nomes.add("The Blind Creature");
        nomes.add("The Titanic Cinder Spider");
        nomes.add("The Painted Jester Frog");
        nomes.add("The Monstrous Slayer Leopard");
        nomes.add("Mistsnake");
        nomes.add("Vapormouth");
        nomes.add("Soilsoul");
        nomes.add("The Barren Critter");
        nomes.add("Bowelbeast");
        nomes.add("The Feral Spite Dragon");
    }

    public String getNome(int index) {
        return nomes.get(index);
    }
    
    public int getSize(){
        return nomes.size();
    }
}
