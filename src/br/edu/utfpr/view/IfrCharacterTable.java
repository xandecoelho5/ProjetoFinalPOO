package br.edu.utfpr.view;

import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.model.CharacterModel;
import java.beans.PropertyVetoException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class IfrCharacterTable extends javax.swing.JInternalFrame {

    private CharacterModel characterModel;

    public IfrCharacterTable() {
        initComponents();
        characterModel = new CharacterModel(new CharacterDao().getCharactersAll());
        tbCharacter.setModel(characterModel);
        cbColumnList.setModel(new DefaultComboBoxModel(characterModel.getColumns()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btNew = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCharacter = new javax.swing.JTable();
        cbColumnList = new javax.swing.JComboBox<>();
        tfQuery = new javax.swing.JTextField();
        cbValidate = new javax.swing.JComboBox<>();
        btSearch = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Character's List");

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

        tbCharacter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbCharacter);

        cbValidate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equal", "Contains", "Initiates", "Ends" }));

        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
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
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbColumnList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbValidate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        IfrCharacter ifrCharacter = new IfrCharacter(characterModel);
        getParent().add(ifrCharacter);
        ifrCharacter.setVisible(true);
        ifrCharacter.setLocation(450, 250);
    }//GEN-LAST:event_btNewActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        try {
            setClosed(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btCloseActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        edit();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        if (!tfQuery.getText().isEmpty()) {
            try {
                characterModel = new CharacterModel(new CharacterDao().search(cbColumnList.getSelectedItem().toString(), tfQuery.getText(), cbValidate.getSelectedIndex(), getField()));
                tbCharacter.setModel(characterModel);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Não informe strings para um campo de Inteiros!");
            }
        } else {
            characterModel = new CharacterModel(new CharacterDao().getCharactersAll());
            tbCharacter.setModel(characterModel);
        }
    }//GEN-LAST:event_btSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> cbColumnList;
    private javax.swing.JComboBox<String> cbValidate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCharacter;
    private javax.swing.JTextField tfQuery;
    // End of variables declaration//GEN-END:variables

    public void delete() {
        int selectedRow = tbCharacter.getSelectedRow();
        if (selectedRow >= 0) {
            int charId = (int) tbCharacter.getValueAt(selectedRow, 0);

            CharacterDao characterDao = new CharacterDao();
            if (JOptionPane.showConfirmDialog(null, "Sure that you wanna delete " + tbCharacter.getValueAt(selectedRow, 2) + " ?", "Delete?", JOptionPane.YES_NO_OPTION) == 0) {
                characterDao.delete(charId);
                JOptionPane.showMessageDialog(null, "Successfully deleted!!");
                characterModel.deleteModel(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to delete dude!");
        }
    }

    public void edit() {
        int selectedRow = tbCharacter.getSelectedRow();
        if (selectedRow >= 0) {
            int characterId = (int) tbCharacter.getValueAt(selectedRow, 0);
            IfrCharacter ifrCharacter = new IfrCharacter(characterModel, characterId, selectedRow);
            getParent().add(ifrCharacter);
            ifrCharacter.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to update dude!");
        }
    }

    private int getField() {
        switch (cbColumnList.getSelectedItem().toString()) {
            case "Id":
                return 1;
            case "Data":
                return 0;
            case "Nickname":
                return 0;
            case "Sex":
                return 0;
            case "Hp":
                return 1;
            case "Attack":
                return 1;
            case "Defense":
                return 1;
            case "Speed":
                return 1;
            case "Job":
                return 0;
            case "idAttack":
                return 0;
            case "idDefense":
                return 0;
        }
        return 0;
    }
}
