package br.edu.utfpr.entity;

import br.edu.utfpr.enumeration.Race;
import br.edu.utfpr.enumeration.Type;

public class Monster {
    private Integer id;
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private Race race;
    private Type type;

    public Monster() {
    }

    public Monster(Integer id, String name, int hp, int attack, int defense, int speed, Race race, Type type) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.race = race;
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Monster{" + "id=" + id + ", name=" + name + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", speed=" + speed + ", race=" + race + ", type=" + type + '}';
    }   
}
