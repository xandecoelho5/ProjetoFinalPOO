package br.edu.utfpr.entity;

import br.edu.utfpr.enumeration.Gear;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;

public class DefenseItem {
    private Integer id;
    private String name;
    private int defense;
    private Gear gear;
    private String description;
    private Job job;
    private Rarity rarity;

    public DefenseItem() {
    }

    public DefenseItem(Integer id, String name, int defense, Gear gear, String description, Job job, Rarity rarity) {
        this.id = id;
        this.name = name;
        this.defense = defense;
        this.gear = gear;
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
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
        return "DefenseItem{" + "id=" + id + ", name=" + name + ", defense=" + defense + ", gear=" + gear + ", description=" + description + ", job=" + job + ", rarity=" + rarity + '}';
    }
}
