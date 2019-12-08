package br.edu.utfpr.entity;

import br.edu.utfpr.enumeration.Job;
import java.time.LocalDate;

public class Character {

    private Integer id;
    private LocalDate date;
    private String nickname;
    private String sex;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private Job job;
    private AttackItem attackItem;
    private DefenseItem defenseItem;

    public Character() {
    }

    public Character(Integer id, LocalDate date, String nickname, String sex, int hp, int attack, int defense, int speed, Job job, AttackItem attackItem, DefenseItem defenseItem) {
        this.id = id;
        this.date = date;
        this.nickname = nickname;
        this.sex = sex;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.job = job;
        this.attackItem = attackItem;
        this.defenseItem = defenseItem;
    }

    public AttackItem getAttackItem() {
        return attackItem;
    }

    public void setAttackItem(AttackItem attackItem) {
        this.attackItem = attackItem;
    }

    public DefenseItem getDefenseItem() {
        return defenseItem;
    }

    public void setDefenseItem(DefenseItem defenseItem) {
        this.defenseItem = defenseItem;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Character{" + "id=" + id + ", date=" + date + ", nickname=" + nickname + ", sex=" + sex + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", speed=" + speed + ", "
                + "job=" + job + ", attackItem=" + attackItem + ", defenseItem=" + defenseItem + '}';
    }
}
