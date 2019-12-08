package br.edu.utfpr.view;

import br.edu.utfpr.dao.MonsterDao;
import br.edu.utfpr.entity.Monster;
import br.edu.utfpr.enumeration.Race;
import br.edu.utfpr.enumeration.Type;
import br.edu.utfpr.functions.RandomMonsters;
import br.edu.utfpr.model.MonsterModel;
import java.beans.PropertyVetoException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IfrMonster extends javax.swing.JInternalFrame {

    private MonsterDao monsterDao;
    private final MonsterModel monsterModel;
    private final Race[] race = Race.values();
    private final Type[] type = Type.values();
    private int selectedRow;
    private final int MAXHP = 50000;
    private final int MAXATK = 5000;
    private final int MAXDEF = 4000;
    private final int MAXSPD = 100;
    private final ImageIcon wrong = new ImageIcon(getClass().getResource("/32x32/cancel-icon (Custom).png"));
    private final ImageIcon accept = new ImageIcon(getClass().getResource("/32x32/Cute-Ball-Go-icon (Custom).png"));
    private String nameS = "";

    public IfrMonster(MonsterModel monsterModel) {
        initComponents();
        cbRace.setModel(new DefaultComboBoxModel(race));
        cbType.setModel(new DefaultComboBoxModel(type));
        this.monsterModel = monsterModel;
    }

    public IfrMonster(MonsterModel monsterModel, int monsterId, int selectedRow) {
        initComponents();
        this.monsterModel = monsterModel;
        this.selectedRow = selectedRow;

        monsterDao = new MonsterDao();
        Monster monster = monsterDao.getMonsterById(monsterId);

        tfId.setText(String.valueOf(monster.getId()));
        tfId.setEnabled(false);
        tfName.setText(monster.getName());
        tfHp.setText(String.valueOf(monster.getHp()));
        tfAttack.setText(String.valueOf(monster.getAttack()));
        tfDefense.setText(String.valueOf(monster.getDefense()));
        tfSpeed.setText(String.valueOf(monster.getSpeed()));
        cbRace.setModel(new DefaultComboBoxModel(race));
        cbRace.setSelectedItem(monster.getRace());
        cbType.setModel(new DefaultComboBoxModel(type));
        cbType.setSelectedItem(monster.getType());

        this.nameS = monster.getName();
        typeStatsMinus();
        reset();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfHp = new javax.swing.JTextField();
        tfAttack = new javax.swing.JTextField();
        tfDefense = new javax.swing.JTextField();
        tfSpeed = new javax.swing.JTextField();
        cbRace = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        lbAvailable = new javax.swing.JLabel();
        lbMaxHp = new javax.swing.JLabel();
        lbMaxAttack = new javax.swing.JLabel();
        lbMaxDefense = new javax.swing.JLabel();
        lbMaxSpeed = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btConfirm = new javax.swing.JButton();
        btRandom = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Monster Register");
        setToolTipText("");

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Attack");
        jLabel3.setToolTipText("(MAX VALUES)");

        jLabel4.setText("Defense");
        jLabel4.setToolTipText("(MAX VALUES)");

        jLabel5.setText("Speed");
        jLabel5.setToolTipText("(MAX VALUES)");

        jLabel6.setText("Race");

        jLabel8.setText("HP");
        jLabel8.setToolTipText("(MAX VALUES)");

        tfId.setEnabled(false);

        tfName.setName("tfName"); // NOI18N
        tfName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNameFocusLost(evt);
            }
        });

        tfHp.setName("tfHp"); // NOI18N
        tfHp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfHpFocusLost(evt);
            }
        });

        tfAttack.setName("tfAttack"); // NOI18N
        tfAttack.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAttackFocusLost(evt);
            }
        });

        tfDefense.setName("tfDefense"); // NOI18N
        tfDefense.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDefenseFocusLost(evt);
            }
        });

        tfSpeed.setName("tfSpeed"); // NOI18N
        tfSpeed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSpeedFocusLost(evt);
            }
        });

        jLabel10.setText("Type");

        lbAvailable.setText("Available?");

        lbMaxHp.setText("50000");

        lbMaxAttack.setText("5000");

        lbMaxDefense.setText("4000");

        lbMaxSpeed.setText("100");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRace, 0, 180, Short.MAX_VALUE)
                    .addComponent(tfDefense)
                    .addComponent(tfAttack)
                    .addComponent(tfHp)
                    .addComponent(cbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfName)
                    .addComponent(tfSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvailable)
                    .addComponent(lbMaxHp)
                    .addComponent(lbMaxAttack)
                    .addComponent(lbMaxDefense)
                    .addComponent(lbMaxSpeed))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lbAvailable))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(lbMaxHp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbMaxAttack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lbMaxDefense))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lbMaxSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tfName.getAccessibleContext().setAccessibleName("");
        tfName.getAccessibleContext().setAccessibleDescription("");

        btConfirm.setText("Confirm");
        btConfirm.setName("btConfirm"); // NOI18N
        btConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmActionPerformed(evt);
            }
        });
        jPanel2.add(btConfirm);

        btRandom.setText("Random");
        btRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRandomActionPerformed(evt);
            }
        });
        jPanel2.add(btRandom);

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btCancel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmActionPerformed
        if (lbAvailable.getIcon().equals(accept)) {
            save();
        } else {
            JOptionPane.showMessageDialog(null, "An error ocurred, verify ur info please!!");
        }
    }//GEN-LAST:event_btConfirmActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error to close:" + ex.getMessage());
        }
    }//GEN-LAST:event_btCancelActionPerformed

    private void tfHpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfHpFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfHpFocusLost

    private void tfAttackFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAttackFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfAttackFocusLost

    private void tfDefenseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDefenseFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfDefenseFocusLost

    private void tfSpeedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSpeedFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfSpeedFocusLost

    private void tfNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfNameFocusLost

    private void btRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomActionPerformed
        RandomMonsters randomMonsters = new RandomMonsters();
        tfName.setText(randomMonsters.getNome((int) (Math.random() * randomMonsters.getSize())));
        verifyText();
        tfHp.setText(String.valueOf((int) (Math.random() * MAXHP)));
        tfAttack.setText(String.valueOf((int) (Math.random() * MAXATK)));
        tfDefense.setText(String.valueOf((int) (Math.random() * MAXDEF)));
        tfSpeed.setText(String.valueOf((int) (Math.random() * MAXSPD)));
        cbRace.setSelectedIndex((int) (Math.random() * cbRace.getItemCount()));
        cbType.setSelectedIndex((int) (Math.random() * cbType.getItemCount()));
        reset();
    }//GEN-LAST:event_btRandomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btConfirm;
    private javax.swing.JButton btRandom;
    private javax.swing.JComboBox<String> cbRace;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbAvailable;
    private javax.swing.JLabel lbMaxAttack;
    private javax.swing.JLabel lbMaxDefense;
    private javax.swing.JLabel lbMaxHp;
    private javax.swing.JLabel lbMaxSpeed;
    private javax.swing.JTextField tfAttack;
    private javax.swing.JTextField tfDefense;
    private javax.swing.JTextField tfHp;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSpeed;
    // End of variables declaration//GEN-END:variables

    public void save() {
        try {
            Monster monster = new Monster();
            typeStats();
            monster.setName(tfName.getText());
            monster.setHp(Integer.parseInt(tfHp.getText()));
            monster.setAttack(Integer.parseInt(tfAttack.getText()));
            monster.setDefense(Integer.parseInt(tfDefense.getText()));
            monster.setSpeed(Integer.parseInt(tfSpeed.getText()));
            monster.setRace((Race) cbRace.getSelectedItem());
            monster.setType((Type) cbType.getSelectedItem());

            monsterDao = new MonsterDao();
            if (tfId.getText().isEmpty()) {
                if (monsterDao.insert(monster)) {
                    JOptionPane.showMessageDialog(null, "Monster success inserted");
                    monsterModel.insertModel(monster);
                    clean();
                }
            } else {
                monster.setId(Integer.parseInt(tfId.getText()));
                if (monsterDao.update(monster)) {
                    JOptionPane.showMessageDialog(null, "Monster success updated");
                    monsterModel.updateModel(monster, selectedRow);
                }
            }
            close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Insert a valid number! " + ex.getMessage());
        }
        nameS = "";
    }

    private void clean() {
        tfName.setText("");
        tfHp.setText("");
        tfAttack.setText("");
        tfDefense.setText("");
        tfSpeed.setText("");
        cbRace.setSelectedIndex(0);
        cbType.setSelectedIndex(0);
        lbAvailable.setText("Available?");
        lbMaxAttack.setText("5000");
        lbMaxHp.setText("50000");
        lbMaxDefense.setText("4000");
        lbMaxSpeed.setText("100");
    }

    private void typeStats() {
        if (cbType.getSelectedItem() == Type.GIANT) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 2));
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) * 2));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 2));
        } else if (cbType.getSelectedItem() == Type.BOSS) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 3));
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) * 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 3));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 2));
        } else if (cbType.getSelectedItem() == Type.RAIDBOSS) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 6));
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) * 4));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 4));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 3));
        }
    }

    private void typeStatsMinus() {
        if (cbType.getSelectedItem() == Type.GIANT) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 2));
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) / 2));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 2));
        } else if (cbType.getSelectedItem() == Type.BOSS) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 3));
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) / 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 3));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 2));
        } else if (cbType.getSelectedItem() == Type.RAIDBOSS) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 6));
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) / 4));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 4));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 3));
        }
    }

    private void close() {
        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }

    private void verifyInput(java.awt.event.FocusEvent evt) {
        try {
            switch (evt.getComponent().getName()) {
                case "tfName":
                    if (tfId.getText().isEmpty()) {
                        monsterDao = new MonsterDao();
                        if (monsterDao.getMonsterByName(tfName.getText()) || "".equals(tfName.getText())) {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(wrong);
                        } else {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(accept);
                        }
                    } else {
                        if (!nameS.equals(tfName.getText())) {
                            monsterDao = new MonsterDao();
                            if (monsterDao.getMonsterByName(tfName.getText()) || "".equals(tfName.getText())) {
                                lbAvailable.setText(null);
                                lbAvailable.setIcon(wrong);
                            } else {
                                lbAvailable.setText(null);
                                lbAvailable.setIcon(accept);
                            }
                        } else {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(accept);
                        }
                    }
                    break;
                case "tfHp":
                    if (!"".equals(tfHp.getText())) { //int i = Integer.parseInt(lbMaxHp.getText());
                        lbMaxHp.setText(String.valueOf(MAXHP - Integer.parseInt(tfHp.getText())));
                        if (Integer.parseInt(tfHp.getText()) > MAXHP || Integer.parseInt(lbMaxHp.getText()) > MAXHP) {
                            JOptionPane.showMessageDialog(null, "Value higher than max, changed to max!");
                            tfHp.setText(String.valueOf(MAXHP));
                            lbMaxHp.setText("0");
                        }
                    }
                    break;
                case "tfAttack":
                    if (!"".equals(tfAttack.getText())) {
                        lbMaxAttack.setText(String.valueOf(MAXATK - Integer.parseInt(tfAttack.getText())));
                        if (Integer.parseInt(tfAttack.getText()) > MAXATK || Integer.parseInt(lbMaxAttack.getText()) > MAXATK) {
                            JOptionPane.showMessageDialog(null, "Value higher than max, changed to max!");
                            tfAttack.setText(String.valueOf(MAXATK));
                            lbMaxAttack.setText("0");
                        }
                    }
                    break;
                case "tfDefense":
                    if (!"".equals(tfDefense.getText())) {
                        lbMaxDefense.setText(String.valueOf(MAXDEF - Integer.parseInt(tfDefense.getText())));
                        if (Integer.parseInt(tfDefense.getText()) > MAXDEF || Integer.parseInt(lbMaxDefense.getText()) > MAXDEF) {
                            JOptionPane.showMessageDialog(null, "Value higher than max, changed to max!");
                            tfDefense.setText(String.valueOf(MAXDEF));
                            lbMaxDefense.setText("0");
                        }
                    }
                    break;
                case "tfSpeed":
                    if (!"".equals(tfSpeed.getText())) {
                        lbMaxSpeed.setText(String.valueOf(MAXSPD - Integer.parseInt(tfSpeed.getText())));
                        if (Integer.parseInt(tfSpeed.getText()) > MAXSPD || Integer.parseInt(lbMaxSpeed.getText()) > MAXSPD) {
                            JOptionPane.showMessageDialog(null, "Value higher than max, changed to max!");
                            tfSpeed.setText(String.valueOf(MAXSPD));
                            lbMaxSpeed.setText("0");
                        }
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Insert a valid number! " + ex.getMessage());
        }
    }

    private void verifyText() {
        monsterDao = new MonsterDao();
        if (monsterDao.getMonsterByName(tfName.getText()) || "".equals(tfName.getText())) {
            lbAvailable.setText(null);
            lbAvailable.setIcon(wrong);
        } else {
            lbAvailable.setText(null);
            lbAvailable.setIcon(accept);
        }
    }
    
    private void reset(){
        lbMaxHp.setText(String.valueOf(MAXHP - Integer.parseInt(tfHp.getText())));
        lbMaxAttack.setText(String.valueOf(MAXATK - Integer.parseInt(tfAttack.getText())));
        lbMaxDefense.setText(String.valueOf(MAXDEF - Integer.parseInt(tfDefense.getText())));
        lbMaxSpeed.setText(String.valueOf(MAXSPD - Integer.parseInt(tfSpeed.getText())));
    }
}
