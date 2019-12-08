package br.edu.utfpr.entity;

import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;

public class AttackItem {
    private Integer id;
    private String name;
    private int attack;
    private int speed;
    private String description;
    private Job job;
    private Rarity rarity;

    public AttackItem() {
    }

    public AttackItem(Integer id, String name, int attack, int speed, String description, Job job, Rarity rarity) {
        this.id = id;
        this.name = name;
        this.attack = attack;
        this.speed = speed;
        this.description = description;
        this.job = job;
        this.rarity = rarity;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return "AttackItem{" + "id=" + id + ", name=" + name + ", attack=" + attack + ", speed=" + speed + ", description=" + description + ", job=" + job + ", rarity=" + rarity + '}';
    }  
}
