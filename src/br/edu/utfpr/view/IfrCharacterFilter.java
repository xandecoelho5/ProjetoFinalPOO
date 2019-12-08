package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.entity.DefenseItem;
import br.edu.utfpr.enumeration.Job;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

public class IfrCharacterFilter extends javax.swing.JInternalFrame {

    private IfrCharacterConsultTable charConsultTable;
    private ArrayList<String> fields = new ArrayList<>();
    //cbUserType.setModel(new DefaultComboBoxModel<>(new Vector<Object>(estado.getEstados)));

    public IfrCharacterFilter() {
        initComponents();
        Job[] job = Job.values();
        cbJob.setModel(new DefaultComboBoxModel(job));

        cbAttackItem.setModel(new DefaultComboBoxModel<>(new AttackItemDao().getAI(""))); //faz sentido se eu tiver maais de um attack or defense item equipados em chars diferentes;        
        cbDefenseItem.setModel(new DefaultComboBoxModel<>(new DefenseItemDao().getDI("")));

        cbJob.setSelectedIndex(-1);
        cbDefenseItem.setSelectedIndex(-1);
        cbAttackItem.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ckId = new javax.swing.JCheckBox();
        ckDate = new javax.swing.JCheckBox();
        ckNickname = new javax.swing.JCheckBox();
        ckSex = new javax.swing.JCheckBox();
        ckHp = new javax.swing.JCheckBox();
        ckAttack = new javax.swing.JCheckBox();
        ckDefense = new javax.swing.JCheckBox();
        ckSpeed = new javax.swing.JCheckBox();
        ckJob = new javax.swing.JCheckBox();
        ckAttackItem = new javax.swing.JCheckBox();
        ckDefenseItem = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btConfirmSelect = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btSelect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        tfNickname = new javax.swing.JTextField();
        tfHp = new javax.swing.JTextField();
        tfDefense = new javax.swing.JTextField();
        tfSpeed = new javax.swing.JTextField();
        tfAttack = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbSex = new javax.swing.JComboBox<>();
        cbJob = new javax.swing.JComboBox<>();
        cbAttackItem = new javax.swing.JComboBox<>();
        cbDefenseItem = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btConfirmFill = new javax.swing.JButton();
        btCancelz = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        ckId.setText("ID");

        ckDate.setText("Date");

        ckNickname.setText("Nickname");

        ckSex.setText("Sex");

        ckHp.setText("HP");

        ckAttack.setText("Attack");

        ckDefense.setText("Defense");

        ckSpeed.setText("Speed");

        ckJob.setText("Job");

        ckAttackItem.setText("Attack Item");

        ckDefenseItem.setText("Defense Item");

        btConfirmSelect.setText("Confirm");
        btConfirmSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmSelectActionPerformed(evt);
            }
        });
        jPanel4.add(btConfirmSelect);

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        jPanel4.add(btCancel);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Choose the fields you want to see");

        btSelect.setText("Select All");
        btSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckHp)
                    .addComponent(ckSex)
                    .addComponent(ckNickname)
                    .addComponent(ckDate)
                    .addComponent(ckId)
                    .addComponent(ckAttack))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckDefense)
                    .addComponent(ckSpeed)
                    .addComponent(ckJob)
                    .addComponent(ckAttackItem)
                    .addComponent(ckDefenseItem)
                    .addComponent(btSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckDefense, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ckId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckDate)
                    .addComponent(ckSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckNickname)
                    .addComponent(ckJob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckSex)
                    .addComponent(ckAttackItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckHp)
                    .addComponent(ckDefenseItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckAttack)
                    .addComponent(btSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Select Fields", jPanel1);

        jLabel2.setText("ID");

        jLabel3.setText("Date");

        jLabel4.setText("Nickname");

        jLabel5.setText("Speed");

        jLabel6.setText("Sex");

        jLabel7.setText("Hp");

        jLabel8.setText("Attack");

        jLabel9.setText("Defense");

        jLabel10.setText("Job");

        jLabel11.setText("Attack Item");

        jLabel12.setText("Defense Item");

        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cbSex.setSelectedIndex(-1);

        btConfirmFill.setText("Confirm");
        btConfirmFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmFillActionPerformed(evt);
            }
        });
        jPanel3.add(btConfirmFill);

        btCancelz.setText("Cancel");
        btCancelz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelzActionPerformed(evt);
            }
        });
        jPanel3.add(btCancelz);

        jLabel14.setText("Fill the fields you want to search for");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(78, 78, 78)
                                        .addComponent(tfHp, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDate)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(tfId))))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfAttack, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(tfDefense)
                            .addComponent(tfSpeed)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(22, 22, 22))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbJob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAttackItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbDefenseItem, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAttackItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbDefenseItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fill Fields", jPanel2);

        jLabel1.setText("Select the fields for consult or fill the fields for a query");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmSelectActionPerformed
        CharacterDao characterDao = new CharacterDao();
        charConsultTable = new IfrCharacterConsultTable((ArrayList) characterDao.searchFilter(getSelectHash()), getSelect());
        getParent().add(charConsultTable);
        charConsultTable.setVisible(true);
        charConsultTable.setLocation(300,300);
        dispose();
    }//GEN-LAST:event_btConfirmSelectActionPerformed

    private void btConfirmFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmFillActionPerformed
        CharacterDao characterDao = new CharacterDao();
        setArrayList();
        //charConsultTable = new IfrCharacterConsultTable((ArrayList) characterDao.searchFill(getFill()), getArray(getFill()));
        charConsultTable = new IfrCharacterConsultTable((ArrayList) characterDao.searchFill(getFill()), fields);
        getParent().add(charConsultTable);
        charConsultTable.setVisible(true);
        charConsultTable.setLocation(300,300);
        dispose();
    }//GEN-LAST:event_btConfirmFillActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btCancelzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelzActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelzActionPerformed

    private void btSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectActionPerformed
        ckAttack.setSelected(true);
        ckAttackItem.setSelected(true);
        ckDate.setSelected(true);
        ckDefense.setSelected(true);
        ckDefenseItem.setSelected(true);
        ckHp.setSelected(true);
        ckId.setSelected(true);
        ckJob.setSelected(true);
        ckNickname.setSelected(true);
        ckSex.setSelected(true);
        ckSpeed.setSelected(true);
    }//GEN-LAST:event_btSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btCancelz;
    private javax.swing.JButton btConfirmFill;
    private javax.swing.JButton btConfirmSelect;
    private javax.swing.JButton btSelect;
    private javax.swing.JComboBox<String> cbAttackItem;
    private javax.swing.JComboBox<String> cbDefenseItem;
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JCheckBox ckAttack;
    private javax.swing.JCheckBox ckAttackItem;
    private javax.swing.JCheckBox ckDate;
    private javax.swing.JCheckBox ckDefense;
    private javax.swing.JCheckBox ckDefenseItem;
    private javax.swing.JCheckBox ckHp;
    private javax.swing.JCheckBox ckId;
    private javax.swing.JCheckBox ckJob;
    private javax.swing.JCheckBox ckNickname;
    private javax.swing.JCheckBox ckSex;
    private javax.swing.JCheckBox ckSpeed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField tfAttack;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDefense;
    private javax.swing.JTextField tfHp;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JTextField tfSpeed;
    // End of variables declaration//GEN-END:variables

    private ArrayList<String> getSelect() {
        ArrayList<String> select = new ArrayList<>();

        if (ckId.isSelected()) {
            select.add("Id");
        }
        if (ckDate.isSelected()) {
            select.add("Data");
        }
        if (ckNickname.isSelected()) {
            select.add("Nickname");
        }
        if (ckSex.isSelected()) {
            select.add("Sex");
        }
        if (ckHp.isSelected()) {
            select.add("Hp");
        }
        if (ckAttack.isSelected()) {
            select.add("Attack");
        }
        if (ckDefense.isSelected()) {
            select.add("Defense");
        }
        if (ckSpeed.isSelected()) {
            select.add("Speed");
        }
        if (ckJob.isSelected()) {
            select.add("Job");
        }
        if (ckAttackItem.isSelected()) {
            select.add("IdAttack");
        }
        if (ckDefenseItem.isSelected()) {
            select.add("IdDefense");
        }
        return select;
    }

    private TreeMap<Integer, String> getSelectHash() {
        TreeMap<Integer, String> select = new TreeMap<>();
        if (ckId.isSelected()) {
            select.put(select.size(), "Character.Id");
        }
        if (ckDate.isSelected()) {
            select.put(select.size(), "Data");
        }
        if (ckNickname.isSelected()) {
            select.put(select.size(), "Nickname");
        }
        if (ckSex.isSelected()) {
            select.put(select.size(), "Sex");
        }
        if (ckHp.isSelected()) {
            select.put(select.size(), "Hp");
        }
        if (ckAttack.isSelected()) {
            select.put(select.size(), "Character.Attack");
        }
        if (ckDefense.isSelected()) {
            select.put(select.size(), "Character.Defense");
        }
        if (ckSpeed.isSelected()) {
            select.put(select.size(), "Character.Speed");
        }
        if (ckJob.isSelected()) {
            select.put(select.size(), "Character.Job");
        }
        if (ckAttackItem.isSelected()) {
            select.put(select.size(), "IdAttack");
        }
        if (ckDefenseItem.isSelected()) {
            select.put(select.size(), "IdDefense");
        }
        return select;
    }

    private HashMap<String, String> getFill() {
        HashMap<String, String> select = new HashMap<>();

        if (!tfId.getText().isEmpty()) {
            select.put("Id", tfId.getText());
        }
        if (!tfDate.getText().isEmpty()) {
            select.put("Data", tfDate.getText());
        }
        if (!tfNickname.getText().isEmpty()) {
            select.put("Nickname", tfNickname.getText());
        }
        if (!tfHp.getText().isEmpty()) {
            select.put("Hp", tfHp.getText());
        }
        if (!tfAttack.getText().isEmpty()) {
            select.put("Attack", tfAttack.getText());
        }
        if (!tfDefense.getText().isEmpty()) {
            select.put("Defense", tfDefense.getText());
        }
        if (!tfSpeed.getText().isEmpty()) {
            select.put("Speed", tfSpeed.getText());
        }
        if (cbSex.getSelectedIndex() > -1) {
            select.put("Sex", cbSex.getSelectedItem().toString());
        }
        if (cbJob.getSelectedIndex() > -1) {
            select.put("Job", cbJob.getSelectedItem().toString());
        }
        if (cbAttackItem.getSelectedIndex() > -1) {
            AttackItemDao attackItemDao = new AttackItemDao();
            AttackItem attackItem = attackItemDao.getAtkItem(cbAttackItem.getSelectedItem().toString());
            select.put("IdAttack", attackItem.getId().toString());
        }
        if (cbDefenseItem.getSelectedIndex() > -1) {
            DefenseItemDao defenseItemDao = new DefenseItemDao();
            DefenseItem defenseItem = defenseItemDao.getDefItem(cbDefenseItem.getSelectedItem().toString());
            select.put("IdDefense", defenseItem.getId().toString());
        }

        return select;
    }

    private ArrayList<String> getArray(HashMap<String, String> select) {
        ArrayList<String> lista = new ArrayList<>();
        for (HashMap.Entry<String, String> en : select.entrySet()) {
            lista.add(en.getKey());
        }
        return lista;
    }

    private void setArrayList() {
        fields.add("Id");
        fields.add("Data");
        fields.add("Nickname");
        fields.add("Hp");
        fields.add("Attack");
        fields.add("Defense");
        fields.add("Speed");
        fields.add("Sex");
        fields.add("Job");
        fields.add("IdAttack");
        fields.add("IdDefense");
    }
}
