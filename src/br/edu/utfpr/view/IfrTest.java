package br.edu.utfpr.view;

import br.edu.utfpr.dao.AttackItemDao;
import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.DefenseItemDao;
import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.entity.DefenseItem;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class IfrTest extends javax.swing.JInternalFrame {

    private final AttackItemDao attackItemDao = new AttackItemDao();
    private final DefenseItemDao defenseItemDao = new DefenseItemDao();
    private final CharacterDao characterDao = new CharacterDao();
    private br.edu.utfpr.entity.Character character;
    private int marker;

    public IfrTest() {
        initComponents();

        cbAttackItem.setEnabled(false);
        cbDefenseItem.setEnabled(false);
        cbCharacter.setModel(new DefaultComboBoxModel<>(characterDao.getCharacterNames()));
//        cbAttackItem.setModel(new DefaultComboBoxModel<>(attackItemDao.getAI()));;
//        cbDefenseItem.setModel(new DefaultComboBoxModel<>(defenseItemDao.getDI()));
        cbCharacter.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbAttackItem = new javax.swing.JComboBox<>();
        cbDefenseItem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btGo = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbCharacter = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("IfrTests");
        setToolTipText("");

        jLabel1.setText("Setup the attackItem or defenseITem manually");

        jLabel2.setText("Attack Item:");

        jLabel3.setText("Defense Item:");

        btGo.setText("Go");
        btGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGoActionPerformed(evt);
            }
        });

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Character:");

        cbCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCharacterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbDefenseItem, 0, 270, Short.MAX_VALUE)
                            .addComponent(cbAttackItem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCharacter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btGo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAttackItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDefenseItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGo)
                    .addComponent(btCancel))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGoActionPerformed
        if (cbAttackItem.getSelectedIndex() > -1) {
            AttackItem attackItem = attackItemDao.getAtkItem(cbAttackItem.getSelectedItem().toString());
            characterDao.update(character, attackItem.getId(), 0); // atualiza o character colocando a Arma nele
            characterDao.update(character, attackItem.getAttack(), attackItem.getSpeed(), true); // true para item novo e atualiza os status do char
            JOptionPane.showMessageDialog(null, "Item equipped succesfully!!");
        } else {
            JOptionPane.showMessageDialog(null, "None attackItem selected!");
        }
        if (cbDefenseItem.getSelectedIndex() > -1) {
            DefenseItem defenseItem = defenseItemDao.getDefItem(cbDefenseItem.getSelectedItem().toString());
            characterDao.update(character, defenseItem.getId(), 1);
            characterDao.update(character, defenseItem.getDefense(), true);
            JOptionPane.showMessageDialog(null, "Item equipped succesfully!!");
        } else {
            JOptionPane.showMessageDialog(null, "None DefenseItem selected!");
        }
        dispose();
    }//GEN-LAST:event_btGoActionPerformed

    private void cbCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCharacterActionPerformed
        if (cbCharacter.getSelectedIndex() > -1) {
            marker = cbCharacter.getSelectedIndex();
            character = characterDao.getCharacter(cbCharacter.getSelectedItem().toString());

            cbAttackItem.setEnabled(true);
            cbDefenseItem.setEnabled(true);

            cbAttackItem.setModel(new DefaultComboBoxModel<>(attackItemDao.getAI(character.getJob().toString()))); //seta só os q tem o msm job
            cbAttackItem.setSelectedIndex(-1);
            cbDefenseItem.setModel(new DefaultComboBoxModel<>(defenseItemDao.getDI(character.getJob().toString())));
            cbDefenseItem.setSelectedIndex(-1);
        } 
    }//GEN-LAST:event_cbCharacterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btGo;
    private javax.swing.JComboBox<String> cbAttackItem;
    private javax.swing.JComboBox<String> cbCharacter;
    private javax.swing.JComboBox<String> cbDefenseItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
