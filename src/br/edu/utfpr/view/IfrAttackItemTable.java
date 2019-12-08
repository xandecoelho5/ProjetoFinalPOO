package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.model.AttackItemModel;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class IfrAttackItemTable extends javax.swing.JInternalFrame {

    private AttackItemModel attackItemModel;

    public IfrAttackItemTable() {
        initComponents();
        attackItemModel = new AttackItemModel(new AttackItemDao().getAttackItems()); //seta o arraylist como model pra table
        tbAttackItem.setModel(attackItemModel);
        cbColumnList.setModel(new DefaultComboBoxModel(attackItemModel.getColumns()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAttackItem = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        cbColumnList = new javax.swing.JComboBox<>();
        tfQuery = new javax.swing.JTextField();
        cbValidate = new javax.swing.JComboBox<>();
        cbSearch = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AttackItems's List");

        tbAttackItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbAttackItem);

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/1297713679_list-add-user (Custom).png"))); // NOI18N
        btNew.setText("New");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jPanel1.add(btNew);

        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/draft (Custom).png"))); // NOI18N
        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btUpdate);

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/1297714394_mypc_close (Custom).png"))); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btDelete);

        btClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Toolbar-Browser-Delete-icon (Custom).png"))); // NOI18N
        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btClose);

        cbValidate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equal", "Contains", "Initiates", "Ends" }));

        cbSearch.setText("Search");
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbColumnList, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbColumnList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbValidate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        IfrAttackItems ifrAttackItems = new IfrAttackItems(attackItemModel);
        getParent().add(ifrAttackItems);
        ifrAttackItems.setVisible(true);
        ifrAttackItems.setLocation(450, 250);
    }//GEN-LAST:event_btNewActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        edit();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btCloseActionPerformed

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed
        if (!tfQuery.getText().isEmpty()) { //trycatch aki
            try {
                attackItemModel = new AttackItemModel(new AttackItemDao().search(cbColumnList.getSelectedItem().toString(), tfQuery.getText(), cbValidate.getSelectedIndex(), getField()));
                tbAttackItem.setModel(attackItemModel); //faz a pesquisa no banco, verifica o campo primeiro, depois o que foi digitado na string, depois a condição de equivalencia e daí se é string ou int o campo 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Não informe strings para um campo de Inteiros!");
            }
        } else {
            attackItemModel = new AttackItemModel(new AttackItemDao().getAttackItems());
            tbAttackItem.setModel(attackItemModel);
        }
    }//GEN-LAST:event_cbSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbColumnList;
    private javax.swing.JButton cbSearch;
    private javax.swing.JComboBox<String> cbValidate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAttackItem;
    private javax.swing.JTextField tfQuery;
    // End of variables declaration//GEN-END:variables

    public void delete() {
        int selectedRow = tbAttackItem.getSelectedRow();
        if (selectedRow >= 0) {
            int attackItemId = (int) tbAttackItem.getValueAt(selectedRow, 0);

            AttackItemDao attackItemDao = new AttackItemDao();
            if (!attackItemDao.getBoundedItem(attackItemId)) {
                if (JOptionPane.showConfirmDialog(null, "Sure that you wanna delete " + tbAttackItem.getValueAt(selectedRow, 1) + " ?", "Delete?", JOptionPane.YES_NO_OPTION) == 0) {
                    attackItemDao.delete(attackItemId);
                    JOptionPane.showMessageDialog(null, "Successfully deleted!!");
                    attackItemModel.deleteModel(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can't delete a item that is equiped to someone!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Select a row to delete dude!");
        }
    }

    public void edit() {
        int selectedRow = tbAttackItem.getSelectedRow();
        if (selectedRow >= 0) {
            int attackItemId = (int) tbAttackItem.getValueAt(selectedRow, 0);

            if (attackItemId != 999) {
                IfrAttackItems ifrAttackItems = new IfrAttackItems(attackItemModel, attackItemId, selectedRow);
                getParent().add(ifrAttackItems);
                ifrAttackItems.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "You can't edit this item!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to update dude!");
        }
    }

    private int getField() {
        switch (cbColumnList.getSelectedItem().toString()) {
            case "Id":
                return 1;
            case "Name":
                return 0;
            case "Attack":
                return 1;
            case "Speed":
                return 1;
            case "Description":
                return 0;
            case "Job":
                return 0;
            case "Rarity":
                return 0;
        }
        return 0;
    }
}
