package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

public class IfrAttackItemFilter extends javax.swing.JInternalFrame {

    private IfrAttackItemConsultTable aIConsultTable;
    private final ArrayList<String> fields = new ArrayList<>();

    public IfrAttackItemFilter() { //ao instanciar ja seta o combo box pra pesquisa
        initComponents();

        Job[] job = Job.values();
        cbJob.setModel(new DefaultComboBoxModel(job));
        Rarity[] rarity = Rarity.values();
        cbRarity.setModel(new DefaultComboBoxModel(rarity));

        cbJob.setSelectedIndex(-1);
        cbRarity.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ckId = new javax.swing.JCheckBox();
        ckName = new javax.swing.JCheckBox();
        ckDescription = new javax.swing.JCheckBox();
        ckSpeed = new javax.swing.JCheckBox();
        ckAttack = new javax.swing.JCheckBox();
        ckJob = new javax.swing.JCheckBox();
        ckRarity = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btConfirmSelect = new javax.swing.JButton();
        btCancelz1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfDescription = new javax.swing.JTextField();
        tfAttack = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbJob = new javax.swing.JComboBox<>();
        cbRarity = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btConfirmFill = new javax.swing.JButton();
        btCancelz = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfSpeed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Attack Item's Filter");

        ckId.setText("ID");

        ckName.setText("Name");

        ckDescription.setText("Description");

        ckSpeed.setText("Speed");

        ckAttack.setText("Attack");

        ckJob.setText("Job");

        ckRarity.setText("Rarity");

        btConfirmSelect.setText("Confirm");
        btConfirmSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmSelectActionPerformed(evt);
            }
        });
        jPanel4.add(btConfirmSelect);

        btCancelz1.setText("Cancel");
        btCancelz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelz1ActionPerformed(evt);
            }
        });
        jPanel4.add(btCancelz1);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Choose the fields you want to see");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckName)
                            .addComponent(ckId)
                            .addComponent(ckSpeed)
                            .addComponent(ckAttack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckJob)
                            .addComponent(ckDescription)
                            .addComponent(ckRarity)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckId)
                    .addComponent(ckDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckJob)
                    .addComponent(ckName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckRarity)
                    .addComponent(ckAttack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckSpeed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Select Fields", jPanel1);

        jLabel2.setText("ID");

        jLabel4.setText("Name");

        jLabel7.setText("Description");

        jLabel9.setText("Attack");

        jLabel11.setText("Job");

        jLabel12.setText("Rarity");

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

        jLabel5.setText("Speed");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfSpeed))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbJob, 0, 217, Short.MAX_VALUE)
                                    .addComponent(cbRarity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfAttack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmSelectActionPerformed
        AttackItemDao attackItemDao = new AttackItemDao();
        aIConsultTable = new IfrAttackItemConsultTable((ArrayList) attackItemDao.searchFilter(getSelect()), getSelect()); // faz a busca filtrada no banco, depedendo dos campos selecionados, 
        getParent().add(aIConsultTable);                                                                                 //esse getSelect é pra saber quais campos que a tabela deve criar dinamicamente
        aIConsultTable.setVisible(true);
        aIConsultTable.setLocation(300,300);
        dispose();
    }//GEN-LAST:event_btConfirmSelectActionPerformed

    private void btConfirmFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmFillActionPerformed
        AttackItemDao attackItemDao = new AttackItemDao();
        setArrayList();
        aIConsultTable = new IfrAttackItemConsultTable((ArrayList) attackItemDao.searchFill(getFill()), fields); //faz  a busca dependendo do que foi inserido  nos campos ou selecionado nas combo boxes
        getParent().add(aIConsultTable);                                                                        //esse fiels são os campos que eu vou carregar na tabela (nesse caso todos)
        aIConsultTable.setVisible(true);
        aIConsultTable.setLocation(300,300);
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
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JComboBox<String> cbRarity;
    private javax.swing.JCheckBox ckAttack;
    private javax.swing.JCheckBox ckDescription;
    private javax.swing.JCheckBox ckId;
    private javax.swing.JCheckBox ckJob;
    private javax.swing.JCheckBox ckName;
    private javax.swing.JCheckBox ckRarity;
    private javax.swing.JCheckBox ckSpeed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField tfAttack;
    private javax.swing.JTextField tfDescription;
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
        if (ckAttack.isSelected()) {
            select.add("Attack");
        }
        if (ckSpeed.isSelected()) {
            select.add("Speed");
        }
        if (ckDescription.isSelected()) {
            select.add("Description");
        }
        if (ckJob.isSelected()) {
            select.add("Job");
        }
        if (ckRarity.isSelected()) {
            select.add("Rarity");
        }
        return select;
    }

    private HashMap<String, String> getFill() {
        HashMap<String, String> select = new HashMap<>();

        if (!tfId.getText().isEmpty()) {
            select.put("Id", tfId.getText());
        }
        if (!tfName.getText().isEmpty()) {
            select.put("Name", tfName.getText());
        }
        if (!tfAttack.getText().isEmpty()) {
            select.put("Attack", tfAttack.getText());
        }
        if (!tfSpeed.getText().isEmpty()) {
            select.put("Speed", tfSpeed.getText());
        }
        if (!tfDescription.getText().isEmpty()) {
            select.put("Description", tfDescription.getText());
        }
        if (cbJob.getSelectedIndex() > -1) {
            select.put("Job", cbJob.getSelectedItem().toString());
        }
        if (cbRarity.getSelectedIndex() > -1) {
            select.put("Rarity", cbRarity.getSelectedItem().toString());
        }
        return select;
    }

    private void setArrayList() {
        fields.add("Id");
        fields.add("Name");
        fields.add("Attack");
        fields.add("Speed");
        fields.add("Description");
        fields.add("Job");
        fields.add("Rarity");
    }
}
