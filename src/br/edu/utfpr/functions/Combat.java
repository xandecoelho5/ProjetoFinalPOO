package br.edu.utfpr.functions;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.entity.DefenseItem;
import br.edu.utfpr.entity.Monster;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Combat {

    private br.edu.utfpr.entity.Character character;
    private br.edu.utfpr.entity.Character characterReturn;
    private Monster monster;
    private AttackItem attackItem;
    private DefenseItem defenseItem;
    private String winner = "";
    private boolean detail = false;

    public Combat(br.edu.utfpr.entity.Character character, Monster monster, boolean detail) {
        this.character = character;
        this.monster = monster;
        this.characterReturn = character;
        this.detail = detail;
    }

    public String war() {
        System.out.println("\nCharacter \tx\t Monster \nNick: " + character.getNickname() + " \t\t Name: " + monster.getName() + "\n" + "HP: " + character.getHp() + " \t\t HP: " + monster.getHp() + "\n"
                + "Atk: " + character.getAttack() + " \t\t Atk: " + monster.getAttack() + "\n" + "Def: " + character.getDefense() + " \t\t Def: " + monster.getDefense() + "\n"
                + "Speed: " + character.getSpeed() + " \t\t Speed: " + monster.getSpeed() + "\n");
        System.out.println("Figth Begins!");
        if (character.getSpeed() >= monster.getSpeed()) {
            System.out.println(character.getNickname() + " is faster than " + monster.getName() + ", so he starts attacking!");
            while (character.getHp() > 0 && monster.getHp() > 0) {
                fight(getAtkChar(), getDefMonster(), 0);
                if (monster.getHp() > 0) {
                    fight(getAtkMonster(), getDefChar(), 1);
                }
            }
        } else {
            System.out.println(monster.getName() + " is faster than " + character.getNickname() + ", so he starts attacking!");
            while (character.getHp() > 0 && monster.getHp() > 0) {
                fight(getAtkMonster(), getDefChar(), 1);
                if (character.getHp() > 0) {
                    fight(getAtkChar(), getDefMonster(), 0);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "GAME OVER!\n" + (character.getHp() > 0 ? character.getNickname() + " WON" : monster.getName() + " WON"));

        winner = character.getHp() > 0 ? "Character" : "Monster";
        getRandomItem();
        return winner;
    }

    private void fight(int Attack, int Defense, int val) {
        int hp = 0;
        if (detail) {
            if (val == 0) {
                hp = monster.getHp();
                monster.setHp(monster.getHp() - absol(Attack - Defense) > 0 ? monster.getHp() - absol(Attack - Defense) : 0);
                System.out.println(character.getNickname() + " deals " + absol(Attack - Defense) + "(" + Attack + "-" + Defense + ") damage on " + monster.getName()
                        + " and " + monster.getName() + " is " + monster.getHp() + "(" + hp + "-" + absol(Attack - Defense) + ") left!");
            } else {
                hp = character.getHp();
                character.setHp(character.getHp() - absol(Attack - Defense) > 0 ? character.getHp() - absol(Attack - Defense) : 0);
                System.out.println(monster.getName() + " deals " + absol(Attack - Defense) + "(" + Attack + "-" + Defense + ") damage on " + character.getNickname()
                        + " and " + character.getNickname() + " is " + character.getHp() + "(" + hp + "-" + absol(Attack - Defense) + ") left!");
            }
        } else {
            if (val == 0) {
                monster.setHp(monster.getHp() - absol(Attack - Defense) > 0 ? monster.getHp() - absol(Attack - Defense) : 0);
                System.out.println(character.getNickname() + " deals " + absol(Attack - Defense) + " damage on " + monster.getName()
                        + " and " + monster.getName() + " is " + monster.getHp() + " left!");
            } else {
                character.setHp(character.getHp() - absol(Attack - Defense) > 0 ? character.getHp() - absol(Attack - Defense) : 0);
                System.out.println(monster.getName() + " deals " + absol(Attack - Defense) + " damage on " + character.getNickname()
                        + " and " + character.getNickname() + " is " + character.getHp() + " left!");
            }
        }
    }

    private void getRandomItem() {
        if (winner.equals("Character")) {
            int i = (int) (Math.random() * 4);
            System.out.println("I: " + i);
            if (i == 0) {
                AttackItemDao attackItemDao = new AttackItemDao(); //talvez setar como -1 para não pegar o none dnv kk
                if (attackItemDao.getCount() > 0) {
                    ArrayList<AttackItem> attackItems = (ArrayList) attackItemDao.getAttackItems(getRarity());
                    System.out.println("attackItemss: " + attackItems);
                    attackItem = attackItems.get((int) (Math.random() * attackItems.size()));
                    System.out.println("AttackItem: " + attackItem);
                    System.out.println("char:" + characterReturn);
                    if (getReqAtk()) {
                        if (JOptionPane.showConfirmDialog(null, "You dropped the Attack Item: " + attackItem.getName() + ", want to use it?", "Wow", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            if (characterReturn.getAttackItem() != null) {
                                if (JOptionPane.showConfirmDialog(null, "You already have the Attack Item : " + characterReturn.getAttackItem().getName() + "want to trade anyway?") == JOptionPane.YES_OPTION) {
                                    CharacterDao characterDao = new CharacterDao();
                                    characterDao.update(characterReturn, attackItem.getAttack(), attackItem.getSpeed(), false);//remove os status do antigo item (para não acumular com o novo);
                                    characterDao.update(characterReturn, attackItem.getId(), 0); //atualiza o item                                  
                                    characterDao.update(characterReturn, attackItem.getAttack(), attackItem.getSpeed(), true); //adiciona os atribs to attack item ao (true para item novo, false para remover o antigo);
                                } else {
                                    JOptionPane.showConfirmDialog(null, "Ok, so the item will be released!!");
                                }
                            } else {
                                CharacterDao characterDao = new CharacterDao();
                                characterDao.update(characterReturn, attackItem.getId(), 0);
                                characterDao.update(characterReturn, attackItem.getAttack(), attackItem.getSpeed(), true); // true para item novo
                            }
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null, "You dropped the Attack Item: " + attackItem.getName() + ", but u can't use it... Sorry!\n"
                                + "Obs: Your Job: " + characterReturn.getJob().toString() + " and item Job: " + attackItem.getJob(), "Sorry", JOptionPane.CLOSED_OPTION);
                    }
                }
            } else if (i == 1) {
                DefenseItemDao defenseItemDao = new DefenseItemDao(); //talvez setar como -1 para não pegar o none dnv kk
                if (defenseItemDao.getCount() > 0) {
                    ArrayList<DefenseItem> defenseItems = (ArrayList) defenseItemDao.getDefenseItems();
                    System.out.println("DefenseItems: " + defenseItems);
                    defenseItem = defenseItems.get((int) (Math.random() * defenseItems.size()));
                    System.out.println("DefenseItems: " + defenseItem);
                    System.out.println("char:" + characterReturn);
                    if (getReqDef()) {
                        if (JOptionPane.showConfirmDialog(null, "You dropped the Defense Item: " + defenseItem.getName() + ", want to use it?", "Wow", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            if (characterReturn.getDefenseItem() != null) {
                                if (JOptionPane.showConfirmDialog(null, "You already have the Attack Item : " + characterReturn.getDefenseItem().getName() + "want to trade anyway?") == JOptionPane.YES_OPTION) {
                                    CharacterDao characterDao = new CharacterDao();
                                    characterDao.update(characterReturn, defenseItem.getDefense(), false); //remove valor antigo
                                    characterDao.update(characterReturn, defenseItem.getId(), 1);
                                    characterDao.update(characterReturn, defenseItem.getDefense(), true); //adiciona valor novo
                                } else {
                                    JOptionPane.showConfirmDialog(null, "Ok, so the item will be released!!");
                                }
                            } else {
                                CharacterDao characterDao = new CharacterDao();
                                characterDao.update(characterReturn, defenseItem.getId(), 1);
                                characterDao.update(characterReturn, defenseItem.getDefense(), true);
                            }
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null, "You dropped the Defense Item: " + defenseItem.getName() + ", but u can't use it... Sorry!\n"
                                + "Obs: Your Job: " + characterReturn.getJob().toString() + " and item Job: " + attackItem.getJob(), "Sorry", JOptionPane.CLOSED_OPTION);
                    }
                }
            } else {
                JOptionPane.showConfirmDialog(null, "You dropped nothing JS,t... Sorry!", "Sorry", JOptionPane.CLOSED_OPTION);
            }
        }
    }

    private String getRarity() {
        switch (monster.getType().toString()) {
            case "Normal":
                return "Common";
            case "Giant":
                return "Rare";
            case "Boss":
                return "Mythic";
            case "RaidBoss":
                return "Legendary";
        }
        return "xd";
    }

    private int getAtkChar() {
        return (int) (Math.random() * character.getAttack());
    }

    private int getDefChar() {
        return (int) (Math.random() * character.getDefense());
    }

    private int getAtkMonster() {
        return (int) (Math.random() * monster.getAttack());
    }

    private int getDefMonster() {
        return (int) (Math.random() * monster.getDefense());
    }

    private boolean getReqAtk() {
        return character.getJob().equals(attackItem.getJob());
    }

    private boolean getReqDef() {
        return character.getJob().equals(defenseItem.getJob());
    }

    private int absol(int value) {
        if (value < 0) {
            return 0;
        }
        return value;
    }
}

/*
    private void fight(int Attack, int Defense, int val) {
        if (val == 0) {
            monster.setHp(monster.getHp() - absol(Attack - Defense) > 0 ? monster.getHp() - absol(Attack - Defense) : 0);
            System.out.println(character.getNickname() + " deals " + absol(Attack - Defense) + " damage on " + monster.getName()
                    + " and " + monster.getName() + " is " + monster.getHp() + " left!");
        } else {
            character.setHp(character.getHp() - absol(Attack - Defense) > 0 ? character.getHp() - absol(Attack - Defense) : 0);
            System.out.println(monster.getName() + " deals " + absol(Attack - Defense) + " damage on " + character.getNickname()
                    + " and " + character.getNickname() + " is " + character.getHp() + " left!");
        }
    }
 */
 /* System.out.println("Character: Nick: " + character.getNickname() + ", HP: " + character.getHp() +  ", Atk: " + character.getAttack() + 
                 ", Def: " + character.getDefense() + ", Speed: " + character.getSpeed());
        System.out.println("Character: Name: " + monster.getName()+ ", HP: " + monster.getHp() +  ", Atk: " + monster.getAttack() + 
                 ", Def: " + monster.getDefense() + ", Speed: " + monster.getSpeed());*/
 /*public String fight(br.edu.utfpr.entity.Character character, Monster monster){
        int charAttack = (int)(Math.random() * character.getAttack());
        int charDef = (int)(Math.random() * character.getDefense());
        int monsterAttack = (int)(Math.random() * monster.getAttack());
        int monsterDef = (int)(Math.random() * monster.getDefense());
        int damage = 0;
        if(character.getSpeed() > monster.getSpeed()){
            while(character.getHp() >= 0 && monster.getHp() >= 0){
                damage = absol(charAttack - monsterDef);  
                System.out.print(character.getNickname() + " deals " + damage  + " damage on " + monster.getName());
                monster.setHp(monster.getHp() - damage);
                System.out.println(" and is " + monster.getHp() + " left!");
                damage = absol(monsterAttack - charDef);   
                System.out.print(monster.getName()+ " deals " + damage  + " damage on " + character.getNickname());
                character.setHp(character.getHp() - damage);
                System.out.println(" and is " + character.getHp() + " left!");
            } 
        } else {
            while(character.getHp() >= 0 && monster.getHp() >= 0){              
                damage = absol(monsterAttack - charDef);  
                System.out.print(monster.getName()+ " deals " + damage  + " damage on " + character.getNickname());
                character.setHp(character.getHp() - damage);
                System.out.println(" and is " + character.getHp() + " left!");
                damage = absol(charAttack - monsterDef);
                System.out.print(character.getNickname() + " deals " + damage  + " damage on " + monster.getName());
                monster.setHp(monster.getHp() - damage);
                System.out.println(" and is " + monster.getHp() + " left!");
            } 
        }
        if(character.getHp()<0) character.setHp(0);
        if(monster.getHp()<0) monster.setHp(0);
        return character.getHp()>0 ? "Character" : "Monster";
    }*/
 /*
    private String fight(br.edu.utfpr.entity.Character character, Monster monster){
        System.out.println("Character: " + character.toString());//mostrar so os campos de VALOR para a funciton;
        System.out.println("Monster: " + monster.toString());
        int damage = 0; //se chegar a 0  dar um break para parar o loop;
        if(character.getSpeed() > monster.getSpeed()){
            while(character.getHp() > 0 && monster.getHp() > 0){
                damage = absol((int)(Math.random() * character.getAttack()) - (int)(Math.random() * character.getDefense()));  
                System.out.print(character.getNickname() + " deals " + damage  + " damage on " + monster.getName());
                monster.setHp(monster.getHp() - damage);
                if(monster.getHp()<0) monster.setHp(0);
                System.out.println(" and is " + monster.getHp() + " left!");
                damage = absol((int)(Math.random() * monster.getAttack()) - (int)(Math.random() * monster.getDefense()));   
                System.out.print(monster.getName()+ " deals " + damage  + " damage on " + character.getNickname());
                character.setHp(character.getHp() - damage);
                if(character.getHp()<0) character.setHp(0);
                System.out.println(" and is " + character.getHp() + " left!");
            } 
        } else {
            while(character.getHp() > 0 && monster.getHp() > 0){              
                damage = absol((int)(Math.random() * monster.getAttack()) - (int)(Math.random() * monster.getDefense()));
                System.out.print(monster.getName()+ " deals " + damage  + " damage on " + character.getNickname());
                character.setHp(character.getHp() - damage);
                if(character.getHp()<0) character.setHp(0);
                System.out.println(" and is " + character.getHp() + " left!");
                damage = absol((int)(Math.random() * character.getAttack()) - (int)(Math.random() * character.getDefense()));
                System.out.print(character.getNickname() + " deals " + damage  + " damage on " + monster.getName());
                monster.setHp(monster.getHp() - damage);
                if(monster.getHp()<0) monster.setHp(0);
                System.out.println(" and is " + monster.getHp() + " left!");
            } 
        }
        return character.getHp()>0 ? "Character" : "Monster";
    }
 */
