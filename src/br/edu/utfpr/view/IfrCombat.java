package br.edu.utfpr.view;

import br.edu.utfpr.dao.CharacterDao;
import br.edu.utfpr.dao.MonsterDao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IfrCombat extends javax.swing.JInternalFrame {

    private final CharacterDao characterDao;
    private final MonsterDao monsterDao;
    private final JLabel test;

    public IfrCombat(JLabel test) {
        initComponents();
        this.test = test;
        
        characterDao = new CharacterDao();
        monsterDao = new MonsterDao();

        cbCharacter.setModel(new DefaultComboBoxModel<>(characterDao.getCharacterNames()));
        cbMonster.setModel(new DefaultComboBoxModel<>(monsterDao.getMonsterNames()));

        cbCharacter.setSelectedIndex(-1);
        cbMonster.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbMonster = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCharacter = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btRandomMonster = new javax.swing.JButton();
        btRandomCharacter = new javax.swing.JButton();
        btRandomBoth = new javax.swing.JButton();
        btSeeMonster = new javax.swing.JButton();
        btSeeCharacter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btCancel = new javax.swing.JButton();
        btStart = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Combat Prepare");
        setToolTipText("");

        jLabel1.setText("Select a character and a monster");

        jLabel3.setText("Monster");

        jLabel2.setText("Character");

        jLabel4.setText("X");

        btRandomMonster.setText("RandomMonster");
        btRandomMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRandomMonsterActionPerformed(evt);
            }
        });

        btRandomCharacter.setText("RandomCharacter");
        btRandomCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRandomCharacterActionPerformed(evt);
            }
        });

        btRandomBoth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/competitors-icon (Custom).png"))); // NOI18N
        btRandomBoth.setText("BothRandom(Auto)");
        btRandomBoth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRandomBothActionPerformed(evt);
            }
        });

        btSeeMonster.setText("SeeStats");
        btSeeMonster.setName("seeMonster"); // NOI18N
        btSeeMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeeMonsterActionPerformed(evt);
            }
        });

        btSeeCharacter.setText("SeeStats");
        btSeeCharacter.setName("seeChar"); // NOI18N
        btSeeCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeeCharacterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(btSeeCharacter)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btRandomCharacter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btRandomBoth)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRandomMonster)
                    .addComponent(btSeeMonster))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cbCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRandomCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btRandomBoth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSeeCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btRandomMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSeeMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Toolbar-Browser-Delete-icon (Custom).png"))); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btCancel);

        btStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Hero-icon.png"))); // NOI18N
        btStart.setText("Start");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });
        jPanel2.add(btStart);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRandomBothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomBothActionPerformed
        cbCharacter.setSelectedIndex((int) (Math.random() * cbCharacter.getItemCount()));
        cbMonster.setSelectedIndex((int) (Math.random() * cbMonster.getItemCount()));
        btStartActionPerformed(evt);
    }//GEN-LAST:event_btRandomBothActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btRandomCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomCharacterActionPerformed
        cbCharacter.setSelectedIndex((int) (Math.random() * cbCharacter.getItemCount()));
    }//GEN-LAST:event_btRandomCharacterActionPerformed

    private void btRandomMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRandomMonsterActionPerformed
        cbMonster.setSelectedIndex((int) (Math.random() * cbMonster.getItemCount()));
    }//GEN-LAST:event_btRandomMonsterActionPerformed

    private void btSeeCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeeCharacterActionPerformed
        if (cbCharacter.getSelectedIndex() > -1) {
            IfrStats ifrStats = new IfrStats(0, cbCharacter.getSelectedItem().toString());
            getParent().add(ifrStats);
            ifrStats.setVisible(true);
            ifrStats.setLocation(300, 300);
        } else {
            JOptionPane.showMessageDialog(null, "Select an character on ComboBox ");
        }
    }//GEN-LAST:event_btSeeCharacterActionPerformed

    private void btSeeMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeeMonsterActionPerformed
        if (cbMonster.getSelectedIndex() > -1) {
            IfrStats ifrStats = new IfrStats(1, cbMonster.getSelectedItem().toString());
            getParent().add(ifrStats);
            ifrStats.setVisible(true);
            ifrStats.setLocation(300, 300);
        } else {
            JOptionPane.showMessageDialog(null, "Select a monster on ComboBox ");
        }
    }//GEN-LAST:event_btSeeMonsterActionPerformed

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        if (cbMonster.getSelectedIndex() > -1 || cbCharacter.getSelectedIndex() > -1) {
            //Combat combat = new Combat(characterDao.getCharacter(cbCharacter.getSelectedItem().toString()), monsterDao.getMonster(cbMonster.getSelectedItem().toString()), ckDetail.isSelected());
            IfrFight ifrFight= new IfrFight(characterDao.getCharacter(cbCharacter.getSelectedItem().toString()), monsterDao.getMonster(cbMonster.getSelectedItem().toString()), test);
            getParent().add(ifrFight);
            ifrFight.setVisible(true);
            ifrFight.setLocation(300, 300);
        } else {
            JOptionPane.showMessageDialog(null, "Select a character and a monster to Start!!");
        }
    }//GEN-LAST:event_btStartActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btRandomBoth;
    private javax.swing.JButton btRandomCharacter;
    private javax.swing.JButton btRandomMonster;
    private javax.swing.JButton btSeeCharacter;
    private javax.swing.JButton btSeeMonster;
    private javax.swing.JButton btStart;
    private javax.swing.JComboBox<String> cbCharacter;
    private javax.swing.JComboBox<String> cbMonster;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
