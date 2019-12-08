package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.functions.RandomNames;
import br.edu.utfpr.model.CharacterModel;
import java.beans.PropertyVetoException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IfrCharacter extends javax.swing.JInternalFrame {

    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private CharacterDao characterDao;
    private final CharacterModel characterModel;
    private final Job[] job = Job.values();
    private int selectedRow;
    private final int MAXHP = 50000;
    private final int MAXATK = 5000;
    private final int MAXDEF = 5000;
    private final int MAXSPD = 100;
    private final ImageIcon wrong = new ImageIcon(getClass().getResource("/32x32/cancel-icon (Custom).png"));
    private final ImageIcon accept = new ImageIcon(getClass().getResource("/32x32/Cute-Ball-Go-icon (Custom).png"));
    private String nameS = "";
    private int characterId = 0;

    public IfrCharacter(CharacterModel characterModel) {
        initComponents();
        buttonGroup1.add(rbMale);
        buttonGroup1.add(rbFemale);
        cbJob.setModel(new DefaultComboBoxModel(job));
        tfDate.setText(LocalDate.now().format(format)); //setLocation(500, 500)
        this.characterModel = characterModel;
    }

    public IfrCharacter(CharacterModel characterModel, int characterId, int selectedRow) {
        initComponents();
        buttonGroup1.add(rbMale);
        buttonGroup1.add(rbFemale);
        this.characterModel = characterModel;
        this.selectedRow = selectedRow;

        characterDao = new CharacterDao();

        br.edu.utfpr.entity.Character character = characterDao.getCharacterById(characterId);

        tfId.setText(String.valueOf(character.getId()));
        tfId.setEnabled(false);
        tfDate.setText(character.getDate().format(format));
        tfNick.setText(character.getNickname());
        if ("Female".equals(character.getSex())) {
            rbFemale.setSelected(true);
        } else {
            rbMale.setSelected(true);
        }
        tfHp.setText(String.valueOf(character.getHp()));
        tfAttack.setText(String.valueOf(character.getAttack()));
        tfDefense.setText(String.valueOf(character.getDefense()));
        tfSpeed.setText(String.valueOf(character.getSpeed()));
        cbJob.setModel(new DefaultComboBoxModel(job));
        cbJob.setSelectedItem(character.getJob());

        this.characterId = characterId;
        this.nameS = character.getNickname();
        jobStatsMinus();
        tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) - character.getAttackItem().getAttack()));
        tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) - character.getDefenseItem().getDefense()));
        tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) - character.getAttackItem().getSpeed()));
        reset();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        tfId = new javax.swing.JTextField();
        tfNick = new javax.swing.JTextField();
        tfHp = new javax.swing.JTextField();
        tfAttack = new javax.swing.JTextField();
        tfDefense = new javax.swing.JTextField();
        tfSpeed = new javax.swing.JTextField();
        cbJob = new javax.swing.JComboBox<>();
        tfDate = new javax.swing.JTextField();
        lbAvailable = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        setTitle("Character Register");

        jPanel1.setToolTipText("");

        jLabel1.setText("ID");

        jLabel2.setText("Nickname");
        jLabel2.setToolTipText("");

        jLabel7.setText("Date");

        rbMale.setText("Male");

        rbFemale.setText("Female");

        tfId.setEnabled(false);

        tfNick.setName("tfNick"); // NOI18N
        tfNick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNickFocusLost(evt);
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

        tfDate.setEnabled(false);

        lbAvailable.setText("Available?");

        jLabel9.setText("Sex");

        jLabel8.setText("HP ");
        jLabel8.setToolTipText("(MAX VALUES)");

        jLabel3.setText("Attack");
        jLabel3.setToolTipText("(MAX VALUES)");

        jLabel4.setText("Defense");
        jLabel4.setToolTipText("(MAX VALUES)");

        jLabel5.setText("Speed");
        jLabel5.setToolTipText("(MAX VALUES)");

        jLabel6.setText("Job");

        lbMaxHp.setText("50000");

        lbMaxAttack.setText("5000");

        lbMaxDefense.setText("5000");

        lbMaxSpeed.setText("100");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbJob, javax.swing.GroupLayout.Alignment.LEADING, 0, 174, Short.MAX_VALUE)
                            .addComponent(tfSpeed, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfAttack, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDefense, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaxAttack)
                            .addComponent(lbMaxHp)
                            .addComponent(lbMaxDefense)
                            .addComponent(lbMaxSpeed)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbMale)
                                .addGap(18, 18, 18)
                                .addComponent(rbFemale))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNick, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAvailable)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbAvailable))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMale)
                    .addComponent(rbFemale)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btConfirm.setText("Confirm");
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void tfNickFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNickFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfNickFocusLost

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

    private void btRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomActionPerformed
        RandomNames randomNames = new RandomNames();
        tfNick.setText(randomNames.getNome((int) (Math.random() * randomNames.getSize())));
        verifyText();
        if ((int) (Math.random() * 2) == 0) {
            rbFemale.setSelected(true);
        } else {
            rbMale.setSelected(true);
        }
        tfHp.setText(String.valueOf((int) (Math.random() * MAXHP)));
        tfAttack.setText(String.valueOf((int) (Math.random() * MAXATK)));
        tfDefense.setText(String.valueOf((int) (Math.random() * MAXDEF)));
        tfSpeed.setText(String.valueOf((int) (Math.random() * MAXSPD)));
        cbJob.setSelectedIndex((int) (Math.random() * cbJob.getItemCount()));
        reset();
    }//GEN-LAST:event_btRandomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btConfirm;
    private javax.swing.JButton btRandom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbAvailable;
    private javax.swing.JLabel lbMaxAttack;
    private javax.swing.JLabel lbMaxDefense;
    private javax.swing.JLabel lbMaxHp;
    private javax.swing.JLabel lbMaxSpeed;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField tfAttack;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDefense;
    private javax.swing.JTextField tfHp;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNick;
    private javax.swing.JTextField tfSpeed;
    // End of variables declaration//GEN-END:variables

    public void save() {
        try {
            br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
            jobStatsPlus();
            character = newCharacter(character);

            characterDao = new CharacterDao();
            if (tfId.getText().isEmpty()) {
                if (characterDao.insert(character)) {
                    JOptionPane.showMessageDialog(null, "Character success inserted");
                    characterModel.insertModel(character);
                    clean();
                }
            } else {
                character.setId(Integer.parseInt(tfId.getText()));
                if (characterDao.update(character)) {
                    characterDao.update(characterDao.getCharacterById(characterId), character.getAttackItem().getAttack(), character.getAttackItem().getSpeed(), true);
                    characterDao.update(characterDao.getCharacterById(characterId), character.getDefenseItem().getDefense(), true);
                    JOptionPane.showMessageDialog(null, "Character success updated");
                    characterModel.updateModel(character, selectedRow);
                }
            }
            close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Insert a valid number! " + ex.getMessage());
        }
        nameS = "";
    }

    private String getSex() {
        return rbFemale.isSelected() ? "Female" : "Male";
    }

    private void clean() {
        tfNick.setText("");
        buttonGroup1.clearSelection();
        tfHp.setText("");
        tfAttack.setText("");
        tfDefense.setText("");
        tfSpeed.setText("");
        cbJob.setSelectedIndex(0);
        lbAvailable.setText("Available?");
        lbMaxAttack.setText("5000");
        lbMaxHp.setText("50000");
        lbMaxDefense.setText("5000");
        lbMaxSpeed.setText("100");
    }

    private void jobStatsPlus() {
        if (cbJob.getSelectedItem() == Job.ARCHER) {
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) / 2));
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 2));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 2));
        } else if (cbJob.getSelectedItem() == Job.NINJA) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 2));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 3));
        } else if (cbJob.getSelectedItem() == Job.ROGUE) {
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) * 2));
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 2));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 2));
        } else if (cbJob.getSelectedItem() == Job.WARRIOR) {
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) * 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 3));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 2));
        }
    }

    private void jobStatsMinus() {
        if (cbJob.getSelectedItem() == Job.ARCHER) {
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) * 2));
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 2));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 2));
        } else if (cbJob.getSelectedItem() == Job.NINJA) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 2));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 3));
        } else if (cbJob.getSelectedItem() == Job.ROGUE) {
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) / 2));
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 2));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 2));
        } else if (cbJob.getSelectedItem() == Job.WARRIOR) {
            tfHp.setText(String.valueOf(Integer.parseInt(tfHp.getText()) / 3));
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 3));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 2));
        }
    }

    private void close() {
        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }

    private br.edu.utfpr.entity.Character newCharacter(br.edu.utfpr.entity.Character character) {
        character.setDate(LocalDate.parse(tfDate.getText(), format));
        character.setNickname(tfNick.getText());
        character.setSex(getSex());
        character.setHp(Integer.parseInt(tfHp.getText()));
        character.setAttack(Integer.parseInt(tfAttack.getText()));
        character.setDefense(Integer.parseInt(tfDefense.getText()));
        character.setSpeed(Integer.parseInt(tfSpeed.getText()));
        character.setJob((Job) cbJob.getSelectedItem());

        AttackItemDao attackItemDao = new AttackItemDao();
        DefenseItemDao defenseItemDao = new DefenseItemDao();
        if (characterId != 0) { //implica que está sendo realizado um update;                      
            character.setAttackItem(characterDao.getCharacterById(characterId).getAttackItem().getId() != 999 ? attackItemDao.getAttackItemByCharId(Integer.parseInt(tfId.getText())) : attackItemDao.getAttackItemById(999));
            character.setDefenseItem(characterDao.getCharacterById(characterId).getDefenseItem().getId() != 999 ? defenseItemDao.getDefenseItemByCharId(Integer.parseInt(tfId.getText())) : defenseItemDao.getDefenseItemById(999));
        } else { //TESTA SE O ATTACK ITEM DO CHARACTER É DIFERENTE DO PADRÃO INICIAL, SE FOR ELE PEGA ESSE MESMO VALOR E SETA NO character, SE NAO, SETA O PADRAO PARA EVITAR ERROS DE NULL POINTERS;
            character.setAttackItem(attackItemDao.getAttackItemById(999)); //seta None
            character.setDefenseItem(defenseItemDao.getDefenseItemById(999)); //seta None
        }

        return character;
    }

    private void verifyInput(java.awt.event.FocusEvent evt) {
        try {
            switch (evt.getComponent().getName()) {
                case "tfNick":
                    if (tfId.getText().isEmpty()) {
                        characterDao = new CharacterDao();
                        if (characterDao.getCharacterByNick(tfNick.getText()) || "".equals(tfNick.getText())) {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(wrong);
                        } else {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(accept);
                        }
                    } else {
                        if (!nameS.equals(tfNick.getText())) {
                            characterDao = new CharacterDao();
                            if (characterDao.getCharacterByNick(tfNick.getText()) || "".equals(tfNick.getText())) {
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
                    if (!"".equals(tfHp.getText())) {
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
        characterDao = new CharacterDao();
        if (characterDao.getCharacterByNick(tfNick.getText()) || "".equals(tfNick.getText())) {
            lbAvailable.setText(null);
            lbAvailable.setIcon(wrong);
        } else {
            lbAvailable.setText(null);
            lbAvailable.setIcon(accept);
        }
    }

    private void reset() {
        lbMaxHp.setText(String.valueOf(MAXHP - Integer.parseInt(tfHp.getText())));
        lbMaxAttack.setText(String.valueOf(MAXATK - Integer.parseInt(tfAttack.getText())));
        lbMaxDefense.setText(String.valueOf(MAXDEF - Integer.parseInt(tfDefense.getText())));
        lbMaxSpeed.setText(String.valueOf(MAXSPD - Integer.parseInt(tfSpeed.getText())));
    }
}
/*characterDao = new CharacterDao();
            AttackItem attackItem = characterDao.getCharacterById(characterId).getAttackItem(); //pega o attackitem do usuário e seta                 
            character.setAttackItem(attackItem);
            DefenseItem defenseItem = characterDao.getCharacterById(characterId).getDefenseItem();
            character.setDefenseItem(defenseItem);*/
