package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.entity.DefenseItem;
import br.edu.utfpr.entity.Monster;
import br.edu.utfpr.functions.SmartScroller;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IfrFight extends javax.swing.JInternalFrame {

    private final br.edu.utfpr.entity.Character character;
    private br.edu.utfpr.entity.Character characterReturn;
    private final Monster monster;
    private AttackItem attackItem;
    private DefenseItem defenseItem;
    private String winner = "";
    private int damage;
    private final JLabel test;
    private final ImageIcon nano = new ImageIcon(getClass().getResource("/gifs/sad.gif"));
    private final ImageIcon nani = new ImageIcon(getClass().getResource("/gifs/vic.gif"));
    private final ImageIcon nane = new ImageIcon(getClass().getResource("/gifs/fig.gif"));
    private final ImageIcon nana = new ImageIcon(getClass().getResource("/gifs/tenor.gif"));
    private boolean finishedC = false;
    private boolean finishedM = false;
    private boolean exit = false;
    Thread thCharacter;
    Thread thMonster;

    public IfrFight(br.edu.utfpr.entity.Character character, Monster monster, JLabel test) {
        initComponents();
        this.test = test;
        test.setIcon(nane);
        new SmartScroller(jScrollPane1);
        this.character = character;
        this.monster = monster;
        this.characterReturn = character;
        lbNick.setText(character.getNickname());
        lbName.setText(monster.getName());

        pbMonster.setMaximum(monster.getHp());
        pbMonster.setValue(monster.getHp());
        pbCharacter.setMaximum(character.getHp());
        pbCharacter.setValue(character.getHp());
        pbMonster.setStringPainted(true);
        pbCharacter.setStringPainted(true);

        war();
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < 15) {
                i++;
                setTitle("OK? " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
            dispose();
        });
        thread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbMonster = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbNick = new javax.swing.JLabel();
        pbCharacter = new javax.swing.JProgressBar();
        pbMonster = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        lbCharDamage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbMonsterDamage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbCharacter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("UFCcOMBAT");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel3.setText("Action Fight");

        lbName.setText("jLabel9");

        lbMonster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/monster.png"))); // NOI18N

        jLabel10.setText("Name: ");

        lbNick.setText("jLabel8");

        jLabel4.setText("Last Hit: ");

        lbCharDamage.setText("0");

        jLabel6.setText("Last Hit: ");

        lbMonsterDamage.setText("0");

        jLabel8.setText("Nickname: ");

        lbCharacter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/man-with-sword-and-shield.png"))); // NOI18N

        jLabel1.setText("Log:");

        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pbCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbCharDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(lbCharacter)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbMonsterDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pbMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbName))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(lbMonster))))
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNick)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(88, 88, 88)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNick)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbName))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pbMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCharacter)
                    .addComponent(lbMonster))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbMonsterDamage)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbCharDamage))))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(12, 12, 12))
        );

        taLog.setEditable(false);
        taLog.setColumns(20);
        taLog.setRows(5);
        jScrollPane1.setViewportView(taLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        exit = true;
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        test.setIcon(nana);
    }//GEN-LAST:event_formInternalFrameClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCharDamage;
    private javax.swing.JLabel lbCharacter;
    private javax.swing.JLabel lbMonster;
    private javax.swing.JLabel lbMonsterDamage;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNick;
    private javax.swing.JProgressBar pbCharacter;
    private javax.swing.JProgressBar pbMonster;
    private javax.swing.JTextArea taLog;
    // End of variables declaration//GEN-END:variables

    private String war() {
        finishedC = false;
        finishedM = false;

        System.out.println(
                "\nCharacter \tx\t Monster \nNick: " + character.getNickname() + " \t\t Name: " + monster.getName() + "\n" + "HP: " + character.getHp() + " \t\t HP: " + monster.getHp() + "\n"
                + "Atk: " + character.getAttack() + " \t\t Atk: " + monster.getAttack() + "\n" + "Def: " + character.getDefense() + " \t\t Def: " + monster.getDefense() + "\n"
                + "Speed: " + character.getSpeed() + " \t\t Speed: " + monster.getSpeed() + "\n");
        taLog.append(
                "Figth Begins!\n");

        thCharacter = new Thread(() -> {
            while ((character.getHp() > 0 && monster.getHp() > 0) || exit) {
                try {
                    System.out.println("11CharHP: " + character.getHp() + "  MonsterHp: " + monster.getHp());
                    if (character.getHp() > 0 && monster.getHp() > 0) {
                        Thread.sleep((1000/character.getSpeed())*2);
                        fight(getAtkChar(), getDefMonster());
                        monster.setHp(monster.getHp() - damage > 0 ? monster.getHp() - damage : 0);
                        synchronized (taLog) {
                            taLog.append(character.getNickname() + " deals " + damage + " damage on " + monster.getName() + " and " + monster.getName() + " is " + monster.getHp() + " left!\n");
                        }
                        lbCharDamage.setText(String.valueOf(damage));
                        pbMonster.setValue(monster.getHp());
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu erro: " + ex.getMessage());
                }
            }
            if (!exit) {
                finishedC = true;
                winnerSets();
            }
        });
        thCharacter.start();

        thMonster = new Thread(() -> {
            while ((character.getHp() > 0 && monster.getHp() > 0) || exit) {
                try {
                    System.out.println("22CharHP: " + character.getHp() + "  MonsterHp: " + monster.getHp());
                    if (character.getHp() > 0 && monster.getHp() > 0) {
                        Thread.sleep((1000/monster.getSpeed())*2);
                        fight(getAtkMonster(), getDefChar());
                        character.setHp(character.getHp() - damage > 0 ? character.getHp() - damage : 0);
                        synchronized (taLog) {
                            taLog.append(monster.getName() + " deals " + damage + " damage on " + character.getNickname() + " and " + character.getNickname() + " is " + character.getHp() + " left!\n");
                        }
                        lbMonsterDamage.setText(String.valueOf(damage));
                        pbCharacter.setValue(character.getHp());
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu erro: " + ex.getMessage());
                }
            }
            if (!exit) {
                finishedM = true;
                winnerSets();
            }
        });
        thMonster.start();
        
        return winner;
    }

    private void winnerSets() {
        if (finishedC && finishedM) {//if (thCharacter.getState() == Thread.State.TERMINATED && thMonster.getState() == Thread.State.TERMINATED) {
            setDead();
            taLog.append("GAME OVER!\n" + (character.getHp() > 0 ? character.getNickname() + " WON" : monster.getName() + " WON"));
            JOptionPane.showMessageDialog(null, "GAME OVER!\n" + (character.getHp() > 0 ? character.getNickname() + " WON" : monster.getName() + " WON"), "IS OVER!!", JOptionPane.CLOSED_OPTION);
            winner = character.getHp() > 0 ? "Character" : "Monster";
            getRandomItem();
        } else {
            System.out.println("Not Yet Done");
        }
    }

    private void fight(int Attack, int Defense) {
        damage = absol(Attack - Defense) > 0 ? absol(Attack - Defense) : 0;
    }

    private void getRandomItem() {
        if (winner.equals("Character")) {
            test.setIcon(nani);
            int i = (int) (Math.random() * 4);
            System.out.println("I: " + i);
            if (i == 0) {
                AttackItemDao attackItemDao = new AttackItemDao();//EU PODIA COMPARAR SE OS STATUS DA ARMA DROPADA SAO MELHORES QUE OS STATUS DA ARMA ATUAL PARA O USUÁRIO PENSAR SE QR OU NÃO USAR KK
                if (attackItemDao.getCount() > 0) {
                    ArrayList<AttackItem> attackItems = (ArrayList) attackItemDao.getAttackItems(getRarity());
                    attackItem = attackItems.get((int) (Math.random() * attackItems.size()));
                    if (getReqAtk()) {
                        if (JOptionPane.showConfirmDialog(null, "You dropped the Attack Item: " + attackItem.getName() + ", want to use it?", "Wow", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            if (characterReturn.getAttackItem().getId() != 999) {
                                if (JOptionPane.showConfirmDialog(null, "You already have the Attack Item : " + characterReturn.getAttackItem().getName() + ", want to trade anyway?", "Wow", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    CharacterDao characterDao = new CharacterDao();
                                    characterDao.update(characterReturn, attackItem.getAttack(), attackItem.getSpeed(), false);//remove os status do antigo item (para não acumular com o novo);
                                    characterDao.update(characterReturn, attackItem.getId(), 0); //atualiza o item                                  
                                    characterDao.update(characterReturn, attackItem.getAttack(), attackItem.getSpeed(), true); //adiciona os atribs to attack item ao (true para item novo, false para remover o antigo);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ok, so the item will be released!!");
                                }
                            } else {
                                CharacterDao characterDao = new CharacterDao();
                                characterDao.update(characterReturn, attackItem.getId(), 0);
                                characterDao.update(characterReturn, attackItem.getAttack(), attackItem.getSpeed(), true); // true para item novo
                                JOptionPane.showMessageDialog(null, "Item equipped succesfully!!");
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
                    defenseItem = defenseItems.get((int) (Math.random() * defenseItems.size()));
                    if (getReqDef()) {
                        if (JOptionPane.showConfirmDialog(null, "You dropped the Defense Item: " + defenseItem.getName() + ", want to use it?", "Wow", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            if (characterReturn.getDefenseItem().getId() != 999) {
                                if (JOptionPane.showConfirmDialog(null, "You already have the Attack Item : " + characterReturn.getDefenseItem().getName() + ", want to trade anyway?", "Wow", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                    CharacterDao characterDao = new CharacterDao();
                                    characterDao.update(characterReturn, defenseItem.getDefense(), false); //remove valor antigo
                                    characterDao.update(characterReturn, defenseItem.getId(), 1);
                                    characterDao.update(characterReturn, defenseItem.getDefense(), true); //adiciona valor novo
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ok, so the item will be released!!");
                                }
                            } else {
                                CharacterDao characterDao = new CharacterDao();
                                characterDao.update(characterReturn, defenseItem.getId(), 1);
                                characterDao.update(characterReturn, defenseItem.getDefense(), true);
                                JOptionPane.showMessageDialog(null, "Item equipped succesfully!!");
                            }
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null, "You dropped the Defense Item: " + defenseItem.getName() + ", but u can't use it... Sorry!\n"
                                + "Obs: Your Job: " + characterReturn.getJob().toString() + " and item Job: " + defenseItem.getJob(), "Sorry", JOptionPane.CLOSED_OPTION);
                    }
                }
            } else {
                JOptionPane.showConfirmDialog(null, "You dropped nothing JS,t... Sorry!", "Sorry", JOptionPane.CLOSED_OPTION);
            }
        } else {
            test.setIcon(nano);
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
        return characterReturn.getJob().equals(attackItem.getJob());
    }

    private boolean getReqDef() {
        return characterReturn.getJob().equals(defenseItem.getJob());
    }

    private int absol(int value) {
        if (value < 0) {
            return 0;
        }
        return value;
    }

    private void setDead() {
        if (character.getHp() <= 0) {
            lbCharacter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/tombstone.png")));
        } else if (monster.getHp() <= 0) {
            lbMonster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/dead.png")));
        }
    }
}
