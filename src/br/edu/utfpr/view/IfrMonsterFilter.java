package br.edu.utfpr.view;

import br.edu.utfpr.dao.MonsterDao;
import br.edu.utfpr.enumeration.Race;
import br.edu.utfpr.enumeration.Type;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

public class IfrMonsterFilter extends javax.swing.JInternalFrame {
    
    private IfrMonsterConsultTable monsterConsult;
    private final ArrayList<String> fields = new ArrayList<>();
    
    public IfrMonsterFilter() {
        initComponents();

        Race[] race = Race.values();
        cbRace.setModel(new DefaultComboBoxModel(race)); 
        Type[] type = Type.values();
        cbType.setModel(new DefaultComboBoxModel(type));
        
        cbRace.setSelectedIndex(-1);
        cbType.setSelectedIndex(-1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ckId = new javax.swing.JCheckBox();
        ckName = new javax.swing.JCheckBox();
        ckHp = new javax.swing.JCheckBox();
        ckAttack = new javax.swing.JCheckBox();
        ckDefense = new javax.swing.JCheckBox();
        ckSpeed = new javax.swing.JCheckBox();
        ckRace = new javax.swing.JCheckBox();
        ckType = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btConfirmSelect = new javax.swing.JButton();
        btCancelz = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfHp = new javax.swing.JTextField();
        tfDefense = new javax.swing.JTextField();
        tfSpeed = new javax.swing.JTextField();
        tfAttack = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbRace = new javax.swing.JComboBox<>();
        cbType = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btConfirmFill = new javax.swing.JButton();
        btCancelz1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Monster's FIlter");
        setToolTipText("");

        ckId.setText("ID");

        ckName.setText("Name");

        ckHp.setText("HP");

        ckAttack.setText("Attack");

        ckDefense.setText("Defense");

        ckSpeed.setText("Speed");

        ckRace.setText("Race");

        ckType.setText("Type");

        btConfirmSelect.setText("Confirm");
        btConfirmSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmSelectActionPerformed(evt);
            }
        });
        jPanel4.add(btConfirmSelect);

        btCancelz.setText("Cancel");
        btCancelz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelzActionPerformed(evt);
            }
        });
        jPanel4.add(btCancelz);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Choose the fields you want to see");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckHp)
                    .addComponent(ckName)
                    .addComponent(ckId)
                    .addComponent(ckAttack))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckDefense)
                    .addComponent(ckSpeed)
                    .addComponent(ckRace)
                    .addComponent(ckType))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckSpeed)
                    .addComponent(ckName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckRace)
                    .addComponent(ckHp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckType)
                    .addComponent(ckAttack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Select Fields", jPanel1);

        jLabel2.setText("ID");

        jLabel4.setText("Name");

        jLabel5.setText("Speed");

        jLabel7.setText("Hp");

        jLabel8.setText("Attack");

        jLabel9.setText("Defense");

        jLabel11.setText("Race");

        jLabel12.setText("Type");

        btConfirmFill.setText("Confirm");
        btConfirmFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmFillActionPerformed(evt);
            }
        });
        jPanel3.add(btConfirmFill);

        btCancelz1.setText("Cancel");
        btCancelz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelz1ActionPerformed(evt);
            }
        });
        jPanel3.add(btCancelz1);

        jLabel14.setText("Fill the fields you want to search for");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(tfAttack))
                            .addComponent(jLabel14)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDefense))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(tfHp, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tfSpeed))
                            .addComponent(cbRace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tfAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tfDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbRace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fill Fields", jPanel2);

        jLabel1.setText("Select the fields for consult or fill the fields for a query");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmSelectActionPerformed
        MonsterDao monsterDao = new MonsterDao();
        monsterConsult = new IfrMonsterConsultTable((ArrayList) monsterDao.searchFilter(getSelect()), getSelect());
        getParent().add(monsterConsult);
        monsterConsult.setVisible(true);
        monsterConsult.setLocation(300,300);
        dispose();
    }//GEN-LAST:event_btConfirmSelectActionPerformed

    private void btConfirmFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmFillActionPerformed
        MonsterDao monsterDao = new MonsterDao();
        setArrayList();
        monsterConsult = new IfrMonsterConsultTable((ArrayList) monsterDao.searchFill(getFill()), fields);
        getParent().add(monsterConsult);
        monsterConsult.setVisible(true);
        monsterConsult.setLocation(300,300);
        dispose();
    }//GEN-LAST:event_btConfirmFillActionPerformed

    private void btCancelzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelzActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelzActionPerformed

    private void btCancelz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelz1ActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelz1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelz;
    private javax.swing.JButton btCancelz1;
    private javax.swing.JButton btConfirmFill;
    private javax.swing.JButton btConfirmSelect;
    private javax.swing.JComboBox<String> cbRace;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JCheckBox ckAttack;
    private javax.swing.JCheckBox ckDefense;
    private javax.swing.JCheckBox ckHp;
    private javax.swing.JCheckBox ckId;
    private javax.swing.JCheckBox ckName;
    private javax.swing.JCheckBox ckRace;
    private javax.swing.JCheckBox ckSpeed;
    private javax.swing.JCheckBox ckType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField tfAttack;
    private javax.swing.JTextField tfDefense;
    private javax.swing.JTextField tfHp;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSpeed;
    // End of variables declaration//GEN-END:variables

    private ArrayList<String> getSelect() {
        ArrayList<String> select = new ArrayList<>();

        if (ckId.isSelected()) {
            select.add("Id");
        }
        if (ckName.isSelected()) {
            select.add("Name");
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
        if (ckRace.isSelected()) {
            select.add("Race");
        }
        if (ckType.isSelected()) {
            select.add("Type");
        }
        return select;
    }
    
    private HashMap<String, String> getFill() { //HashMap<HashMap<String, String>, ArrayList<String>>
        HashMap<String, String> select = new HashMap<>();

        if (!tfId.getText().isEmpty()) {
            select.put("Id", tfId.getText());
        }
        if (!tfName.getText().isEmpty()) {
            select.put("Name", tfName.getText());
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
        if (cbRace.getSelectedIndex() > -1) {
            select.put("Race", cbRace.getSelectedItem().toString());
        }
        if (cbType.getSelectedIndex() > -1) {
            select.put("Type", cbType.getSelectedItem().toString());
        }
        return select;
    }
    
    private void setArrayList(){
        fields.add("Id");
        fields.add("Name");
        fields.add("Hp");
        fields.add("Attack");
        fields.add("Defense");
        fields.add("Speed");
        fields.add("Race");
        fields.add("Type");
    }
}
