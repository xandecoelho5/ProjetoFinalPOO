package br.edu.utfpr.view;

import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.entity.DefenseItem;
import br.edu.utfpr.enumeration.Gear;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;
import br.edu.utfpr.functions.RandomDefenseItems;
import br.edu.utfpr.model.DefenseItemModel;
import java.beans.PropertyVetoException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IfrDefenseItems extends javax.swing.JInternalFrame {

    private DefenseItemDao defenseItemDao;
    private final DefenseItemModel defenseItemModel;
    private final Gear[] gear = Gear.values();
    private final Job[] job = Job.values();
    private final Rarity[] rarity = Rarity.values();
    private int selectedRow;
    private final int MAXDEF = 500;
    private final ImageIcon wrong = new ImageIcon(getClass().getResource("/32x32/cancel-icon (Custom).png"));
    private final ImageIcon accept = new ImageIcon(getClass().getResource("/32x32/Cute-Ball-Go-icon (Custom).png"));
    private String nameS = "";
    private final CharacterDao characterDao = new CharacterDao();

    public IfrDefenseItems(DefenseItemModel defenseItemModel) {
        initComponents();
        cbGear.setModel(new DefaultComboBoxModel(gear));
        cbJob.setModel(new DefaultComboBoxModel(job));
        cbRarity.setModel(new DefaultComboBoxModel(rarity));
        this.defenseItemModel = defenseItemModel;
    }

    public IfrDefenseItems(DefenseItemModel defenseItemModel, int defenseItemId, int selectedRow) {
        initComponents();
        this.defenseItemModel = defenseItemModel;
        this.selectedRow = selectedRow;

        defenseItemDao = new DefenseItemDao();
        DefenseItem defenseItem = defenseItemDao.getDefenseItemById(defenseItemId);
        characterDao.update(characterDao.getCharacterById(characterDao.getCharByItemIndex(defenseItem.getId(), 0)), defenseItem.getDefense(), false);

        tfId.setText(String.valueOf(defenseItem.getId()));
        tfId.setEnabled(false);
        tfName.setText(defenseItem.getName());
        tfDefense.setText(String.valueOf(defenseItem.getDefense()));
        cbGear.setModel(new DefaultComboBoxModel(gear));
        cbGear.setSelectedItem(defenseItem.getGear());
        taDescription.setText(defenseItem.getDescription());
        cbJob.setModel(new DefaultComboBoxModel(job));
        cbJob.setSelectedItem(defenseItem.getJob());
        cbRarity.setModel(new DefaultComboBoxModel(rarity));
        cbRarity.setSelectedItem(defenseItem.getRarity());

        this.nameS = defenseItem.getName();
        rarityStatsMinus();
        lbMaxDefense.setText(String.valueOf(MAXDEF - Integer.parseInt(tfDefense.getText())));
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
        tfDefense = new javax.swing.JTextField();
        cbJob = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        cbRarity = new javax.swing.JComboBox<>();
        cbGear = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbMaxDefense = new javax.swing.JLabel();
        lbAvailable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btConfirm = new javax.swing.JButton();
        btRandom = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Defense Items Register");

        jLabel1.setText("ID");

        jLabel2.setText("Name");

        jLabel3.setText("Defense");

        jLabel6.setText("Job");

        tfId.setEnabled(false);

        tfName.setName("tfName"); // NOI18N
        tfName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNameFocusLost(evt);
            }
        });

        tfDefense.setName("tfDefense"); // NOI18N
        tfDefense.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDefenseFocusLost(evt);
            }
        });

        jLabel10.setText("Description");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        jLabel11.setText("Rarity");

        jLabel4.setText("Gear");

        lbMaxDefense.setText("500");

        lbAvailable.setText("Available?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfDefense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMaxDefense)
                        .addGap(177, 177, 177))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbRarity, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbJob, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbGear, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                    .addComponent(tfName, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAvailable)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(tfDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbMaxDefense))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addContainerGap(14, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tfNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfNameFocusLost

    private void tfDefenseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDefenseFocusLost
        verifyInput(evt);
    }//GEN-LAST:event_tfDefenseFocusLost

    private void btRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomActionPerformed
        RandomDefenseItems randomDefenseItems = new RandomDefenseItems();
        tfName.setText(randomDefenseItems.getNome((int) (Math.random() * randomDefenseItems.getSize())));
        verifyText();
        tfDefense.setText(String.valueOf((int) (Math.random() * MAXDEF)));
        cbGear.setSelectedIndex((int) (Math.random() * cbGear.getItemCount()));
        cbJob.setSelectedIndex((int) (Math.random() * cbJob.getItemCount()));
        cbRarity.setSelectedIndex((int) (Math.random() * cbRarity.getItemCount()));
        lbMaxDefense.setText(String.valueOf(MAXDEF - Integer.parseInt(tfDefense.getText())));
    }//GEN-LAST:event_btRandomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btConfirm;
    private javax.swing.JButton btRandom;
    private javax.swing.JComboBox<String> cbGear;
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JComboBox<String> cbRarity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAvailable;
    private javax.swing.JLabel lbMaxDefense;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField tfDefense;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    public void save() {
        try {
            DefenseItem defenseItem = new DefenseItem();
            rarityStats();
            defenseItem.setName(tfName.getText());
            defenseItem.setDefense(Integer.parseInt(tfDefense.getText()));
            defenseItem.setGear((Gear) cbGear.getSelectedItem());
            defenseItem.setDescription(taDescription.getText());
            defenseItem.setJob((Job) cbJob.getSelectedItem());
            defenseItem.setRarity((Rarity) cbRarity.getSelectedItem());

            defenseItemDao = new DefenseItemDao();
            if (tfId.getText().isEmpty()) {
                if (defenseItemDao.insert(defenseItem)) {
                    JOptionPane.showMessageDialog(null, "Defense Item success inserted");
                    defenseItemModel.insertModel(defenseItem);
                    clean();
                }
            } else {
                defenseItem.setId(Integer.parseInt(tfId.getText()));
                if (defenseItemDao.update(defenseItem)) {
                    characterDao.update(characterDao.getCharacterById(characterDao.getCharByItemIndex(defenseItem.getId(), 0)), defenseItem.getDefense(), true);
                    JOptionPane.showMessageDialog(null, "Defense Item success updated");
                    defenseItemModel.updateModel(defenseItem, selectedRow);
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
        tfDefense.setText("");
        cbGear.setSelectedIndex(0);
        taDescription.setText("");
        cbJob.setSelectedIndex(0);
        cbRarity.setSelectedIndex(0);
        lbAvailable.setText("Available?");
        lbMaxDefense.setText("500");
    }

    private void rarityStats() {
        if (cbRarity.getSelectedItem() == Rarity.RARE) {
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 2));
        } else if (cbRarity.getSelectedItem() == Rarity.MYTHIC) {
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 3));;
        } else if (cbRarity.getSelectedItem() == Rarity.LEGENDARY) {
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) * 5));
        }
    }

    private void rarityStatsMinus() {
        if (cbRarity.getSelectedItem() == Rarity.RARE) {
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 2));
        } else if (cbRarity.getSelectedItem() == Rarity.MYTHIC) {
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 3));;
        } else if (cbRarity.getSelectedItem() == Rarity.LEGENDARY) {
            tfDefense.setText(String.valueOf(Integer.parseInt(tfDefense.getText()) / 5));
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
                        defenseItemDao = new DefenseItemDao();
                        if (defenseItemDao.getDefenseItemByName(tfName.getText()) || "".equals(tfName.getText())) {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(wrong);
                        } else {
                            lbAvailable.setText(null);
                            lbAvailable.setIcon(accept);
                        }
                    } else {
                        if (!nameS.equals(tfName.getText())) {
                            defenseItemDao = new DefenseItemDao();
                            if (defenseItemDao.getDefenseItemByName(tfName.getText()) || "".equals(tfName.getText())) {
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
            }
        } catch (NumberFormatException ex) {
            System.out.println("Insert a valid number! " + ex.getMessage());
        }
    }

    private void verifyText() {
        defenseItemDao = new DefenseItemDao();
        if (defenseItemDao.getDefenseItemByName(tfName.getText()) || "".equals(tfName.getText())) {
            lbAvailable.setText(null);
            lbAvailable.setIcon(wrong);
        } else {
            lbAvailable.setText(null);
            lbAvailable.setIcon(accept);
        }
    }
}
