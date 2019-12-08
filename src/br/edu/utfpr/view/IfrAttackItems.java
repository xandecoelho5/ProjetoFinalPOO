package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;
import br.edu.utfpr.functions.RandomAttackItems;
import br.edu.utfpr.model.AttackItemModel;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IfrAttackItems extends javax.swing.JInternalFrame {

    private AttackItemDao attackItemDao;
    private final Job[] job = Job.values();
    private final Rarity[] rarity = Rarity.values();
    private final AttackItemModel attackItemModel;
    private int selectedRow;
    private final int MAXATK = 500;
    private final int MAXSPD = 30;
    private final ImageIcon wrong = new ImageIcon(getClass().getResource("/32x32/cancel-icon (Custom).png"));
    private final ImageIcon accept = new ImageIcon(getClass().getResource("/32x32/Cute-Ball-Go-icon (Custom).png"));
    private String nameS = "";
    private final CharacterDao characterDao = new CharacterDao();

    public IfrAttackItems(AttackItemModel attackItemModel) {
        initComponents();
        cbJob.setModel(new DefaultComboBoxModel(job));
        cbRarity.setModel(new DefaultComboBoxModel(rarity));
        this.attackItemModel = attackItemModel;
    }

    public IfrAttackItems(AttackItemModel attackItemModel, int attackItemId, int selectedRow) {
        initComponents();
        this.attackItemModel = attackItemModel;
        this.selectedRow = selectedRow;

        attackItemDao = new AttackItemDao();
        AttackItem attackItem = attackItemDao.getAttackItemById(attackItemId);
        characterDao.update(characterDao.getCharacterById(characterDao.getCharByItemIndex(attackItem.getId(), 1)), attackItem.getAttack(), attackItem.getSpeed(), false);

        tfId.setText(String.valueOf(attackItem.getId()));
        tfId.setEnabled(false);
        tfName.setText(attackItem.getName());
        tfAttack.setText(String.valueOf(attackItem.getAttack()));
        tfSpeed.setText(String.valueOf(attackItem.getSpeed()));
        taDescription.setText(attackItem.getDescription());
        cbJob.setModel(new DefaultComboBoxModel(job));
        cbJob.setSelectedItem(attackItem.getJob());
        cbRarity.setModel(new DefaultComboBoxModel(rarity));
        cbRarity.setSelectedItem(attackItem.getRarity());

        this.nameS = attackItem.getName();
        rarityStatsMinus();
        lbMaxAttack.setText(String.valueOf(MAXATK - Integer.parseInt(tfAttack.getText())));
        lbMaxSpeed.setText(String.valueOf(MAXSPD - Integer.parseInt(tfSpeed.getText())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfAttack = new javax.swing.JTextField();
        tfSpeed = new javax.swing.JTextField();
        cbJob = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        cbRarity = new javax.swing.JComboBox<>();
        lbMaxAttack = new javax.swing.JLabel();
        lbMaxSpeed = new javax.swing.JLabel();
        lbAvailable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btConfirm = new javax.swing.JButton();
        btRandom = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Attack Items Register");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Attack");

        jLabel5.setText("Speed");

        jLabel6.setText("Job");

        tfId.setEnabled(false);

        tfName.setName("tfName"); // NOI18N
        tfName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNameFocusLost(evt);
            }
        });

        tfAttack.setName("tfAttack"); // NOI18N
        tfAttack.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAttackFocusLost(evt);
            }
        });

        tfSpeed.setName("tfSpeed"); // NOI18N
        tfSpeed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSpeedFocusLost(evt);
            }
        });

        jLabel10.setText("Description");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        jLabel11.setText("Rarity");

        lbMaxAttack.setText("500");

        lbMaxSpeed.setText("30");

        lbAvailable.setText("Available?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRarity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMaxSpeed))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(tfAttack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaxAttack)
                            .addComponent(lbAvailable)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lbAvailable))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbMaxAttack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lbMaxSpeed))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            Logger.getLogger(IfrAttackItems.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCancelActionPerformed

    private void tfNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfNameFocusLost

    private void tfAttackFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAttackFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfAttackFocusLost

    private void tfSpeedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSpeedFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfSpeedFocusLost

    private void btRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomActionPerformed
        RandomAttackItems randomAttackItems = new RandomAttackItems();
        tfName.setText(randomAttackItems.getNome((int) (Math.random() * randomAttackItems.getSize())));
        verifyText();
        tfAttack.setText(String.valueOf((int) (Math.random() * MAXATK)));
        tfSpeed.setText(String.valueOf((int) (Math.random() * MAXSPD)));
        cbJob.setSelectedIndex((int) (Math.random() * cbJob.getItemCount()));
        cbRarity.setSelectedIndex((int) (Math.random() * cbRarity.getItemCount()));
        lbMaxAttack.setText(String.valueOf(MAXATK - Integer.parseInt(tfAttack.getText())));
        lbMaxSpeed.setText(String.valueOf(MAXSPD - Integer.parseInt(tfSpeed.getText())));
    }//GEN-LAST:event_btRandomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btConfirm;
    private javax.swing.JButton btRandom;
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JComboBox<String> cbRarity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAvailable;
    private javax.swing.JLabel lbMaxAttack;
    private javax.swing.JLabel lbMaxSpeed;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField tfAttack;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSpeed;
    // End of variables declaration//GEN-END:variables

    public void save() {
        try {
            AttackItem attackItem = new AttackItem();
            rarityStats();
            attackItem.setName(tfName.getText());
            attackItem.setAttack(Integer.parseInt(tfAttack.getText()));
            attackItem.setSpeed(Integer.parseInt(tfSpeed.getText()));
            attackItem.setDescription(taDescription.getText());
            attackItem.setJob((Job) cbJob.getSelectedItem());
            attackItem.setRarity((Rarity) cbRarity.getSelectedItem());

            attackItemDao = new AttackItemDao();
            if (tfId.getText().isEmpty()) {
                if (attackItemDao.insert(attackItem)) {
                    JOptionPane.showMessageDialog(null, "Attack Item success inserted");
                    attackItemModel.insertModel(attackItem);
                    clean();
                }
            } else {
                attackItem.setId(Integer.parseInt(tfId.getText()));
                if (attackItemDao.update(attackItem)) {
                    characterDao.update(characterDao.getCharacterById(characterDao.getCharByItemIndex(attackItem.getId(), 1)), attackItem.getAttack(), attackItem.getSpeed(), true);
                    JOptionPane.showMessageDialog(null, "Attack Item success updated");
                    attackItemModel.updateModel(attackItem, selectedRow);
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
        tfAttack.setText("");
        tfSpeed.setText("");
        taDescription.setText("");
        cbJob.setSelectedIndex(0);
        cbRarity.setSelectedIndex(0);
        lbAvailable.setText("Available?");
        lbMaxAttack.setText("500");
        lbMaxSpeed.setText("30");
    }

    private void rarityStats() {
        if (cbRarity.getSelectedItem() == Rarity.RARE) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 2));
        } else if (cbRarity.getSelectedItem() == Rarity.MYTHIC) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 3));;
        } else if (cbRarity.getSelectedItem() == Rarity.LEGENDARY) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) * 5));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) * 2));
        }
    }

    private void rarityStatsMinus() {
        if (cbRarity.getSelectedItem() == Rarity.RARE) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 2));
        } else if (cbRarity.getSelectedItem() == Rarity.MYTHIC) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 3));;
        } else if (cbRarity.getSelectedItem() == Rarity.LEGENDARY) {
            tfAttack.setText(String.valueOf(Integer.parseInt(tfAttack.getText()) / 5));
            tfSpeed.setText(String.valueOf(Integer.parseInt(tfSpeed.getText()) / 2));
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
                        attackItemDao = new AttackItemDao();
                        if (attackItemDao.getAttackItemByName(tfName.getText()) || "".equals(tfName.getText())) {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(wrong);
                        } else {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(accept);
                        }
                    } else {
                        if (!nameS.equals(tfName.getText())) {
                            attackItemDao = new AttackItemDao();
                            if (attackItemDao.getAttackItemByName(tfName.getText()) || "".equals(tfName.getText())) {
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
        attackItemDao = new AttackItemDao();
        if (attackItemDao.getAttackItemByName(tfName.getText()) || "".equals(tfName.getText())) {
            lbAvailable.setText(null);
            lbAvailable.setIcon(wrong);
        } else {
            lbAvailable.setText(null);
            lbAvailable.setIcon(accept);
        }
    }
}
