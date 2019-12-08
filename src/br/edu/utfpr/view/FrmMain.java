package br.edu.utfpr.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrmMain extends javax.swing.JFrame {
    
    private final ImageIcon nana = new ImageIcon(getClass().getResource("/gifs/magic.gif"));
    private final ImageIcon nane = new ImageIcon(getClass().getResource("/gifs/tenor.gif"));
    private final ImageIcon nani = new ImageIcon(getClass().getResource("/gifs/junk.gif"));
    private final ImageIcon nanu = new ImageIcon(getClass().getResource("/gifs/zzz.gif"));       
    private final ImageIcon mana = new ImageIcon(getClass().getResource("/gifs/ain.gif"));       
    private final ImageIcon mane = new ImageIcon(getClass().getResource("/gifs/out.gif"));     
    public FrmMain() {
        initComponents();
        lbTest.setIcon(nani);
        lbBot.setIcon(nane);//seta os gids nos labels
                
        jDesktopPane1.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE); //modo de arrasto
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setIconImage(new ImageIcon(getClass().getResource("/32x32/user.png")).getImage());
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane() {
            private Image image;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);

                try{
                    image = ImageIO.read(getClass().getResource("/32x32/green.gif"));
                } catch(IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
        ;
        lbTest = new javax.swing.JLabel();
        lbBot = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        imnCharacter = new javax.swing.JMenuItem();
        imnMonster = new javax.swing.JMenuItem();
        imnAttackItem = new javax.swing.JMenuItem();
        imnDefenseItem = new javax.swing.JMenuItem();
        imnExit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Final Beta");

        lbTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTestMouseClicked(evt);
            }
        });

        lbBot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBotMouseClicked(evt);
            }
        });

        jDesktopPane1.setLayer(lbTest, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbBot, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(519, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(lbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(lbBot, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(lbTest, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(lbBot, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Register");

        imnCharacter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        imnCharacter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Hero-icon.png"))); // NOI18N
        imnCharacter.setText("Character...");
        imnCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnCharacterActionPerformed(evt);
            }
        });
        jMenu1.add(imnCharacter);

        imnMonster.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        imnMonster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Monster-Sick-icon.png"))); // NOI18N
        imnMonster.setText("Monster...");
        imnMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnMonsterActionPerformed(evt);
            }
        });
        jMenu1.add(imnMonster);

        imnAttackItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        imnAttackItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/62963-crossed-swords-icon.png"))); // NOI18N
        imnAttackItem.setText("Attack Item...");
        imnAttackItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnAttackItemActionPerformed(evt);
            }
        });
        jMenu1.add(imnAttackItem);

        imnDefenseItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        imnDefenseItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/shield-icon.png"))); // NOI18N
        imnDefenseItem.setText("Defense Item...");
        imnDefenseItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnDefenseItemActionPerformed(evt);
            }
        });
        jMenu1.add(imnDefenseItem);

        imnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        imnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Log-Out-icon (Custom).png"))); // NOI18N
        imnExit.setText("Exit");
        imnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnExitActionPerformed(evt);
            }
        });
        jMenu1.add(imnExit);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Consult");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Hero-icon.png"))); // NOI18N
        jMenuItem2.setText("Character");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Monster-Sick-icon.png"))); // NOI18N
        jMenuItem3.setText("Monster");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/62963-crossed-swords-icon.png"))); // NOI18N
        jMenuItem4.setText("AttackItem");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/shield-icon.png"))); // NOI18N
        jMenuItem5.setText("DefenseItem");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Challenges");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Halloween-Scythe-Sword-2icon.png"))); // NOI18N
        jMenuItem6.setText("Combat");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("About");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/brasil-icon (Custom).png"))); // NOI18N
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/Hourglass-icon (Custom).png"))); // NOI18N
        jMenuItem7.setText("TestPurposes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Exit");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/anbo.png"))); // NOI18N
        jMenuItem9.setText("Tributo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/superhero.png"))); // NOI18N
        jMenuItem10.setText("Tributo Pt2");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/32x32/boss-icon (Custom).png"))); // NOI18N
        jMenuItem11.setText("Tributo Pt3");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imnCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnCharacterActionPerformed
        IfrCharacterTable charTable = new IfrCharacterTable();
        jDesktopPane1.add(charTable);
        charTable.setVisible(true);
        charTable.setLocation(450, 250);
    }//GEN-LAST:event_imnCharacterActionPerformed

    private void imnMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnMonsterActionPerformed
        IfrMonsterTable monsterTable = new IfrMonsterTable();
        jDesktopPane1.add(monsterTable);
        monsterTable.setVisible(true);
        monsterTable.setLocation(450, 250);
    }//GEN-LAST:event_imnMonsterActionPerformed

    private void imnAttackItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnAttackItemActionPerformed
            IfrAttackItemTable attackItemTable = new IfrAttackItemTable();
            jDesktopPane1.add(attackItemTable);
            attackItemTable.setVisible(true);
            attackItemTable.setLocation(450, 250);
        }

        /*
        ifrAttackItem.setVisible(true);    }//GEN-LAST:event_imnAttackItemActionPerformed
*/
    private void imnDefenseItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnDefenseItemActionPerformed
            IfrDefenseItemTable defenseItemTable = new IfrDefenseItemTable();
            jDesktopPane1.add(defenseItemTable);
            defenseItemTable.setVisible(true);
            defenseItemTable.setLocation(450, 250);
        }

        /*
        ifrDefenseItem.setVisible(true);    }//GEN-LAST:event_imnDefenseItemActionPerformed
*/
    private void imnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnExitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Sure that you want to Exit?", "Close", JOptionPane.YES_NO_OPTION) == 0) {
            System.exit(0);
        } else {
            requestFocusInWindow();
        }
    }//GEN-LAST:event_imnExitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Feito com muita suor e raiva para encontrar os erros e superá-los!", "VIDA DURA AMIGOS",1,nana);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IfrDefenseItemFilter ifrDefenseItemFilter = new IfrDefenseItemFilter();
        jDesktopPane1.add(ifrDefenseItemFilter);
        ifrDefenseItemFilter.setVisible(true);
        ifrDefenseItemFilter.setLocation(450, 250);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IfrCharacterFilter ifrCharacterFilter = new IfrCharacterFilter();
        jDesktopPane1.add(ifrCharacterFilter);
        ifrCharacterFilter.setVisible(true);
        ifrCharacterFilter.setLocation(450, 250);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        IfrMonsterFilter ifrMonsterFilter = new IfrMonsterFilter();
        jDesktopPane1.add(ifrMonsterFilter);
        ifrMonsterFilter.setVisible(true);
        ifrMonsterFilter.setLocation(450, 250);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        IfrAttackItemFilter ifrAttackItemFilter = new IfrAttackItemFilter();
        jDesktopPane1.add(ifrAttackItemFilter);
        ifrAttackItemFilter.setVisible(true);
        ifrAttackItemFilter.setLocation(450, 250);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        IfrCombat ifrCombat = new IfrCombat(lbBot);
        jDesktopPane1.add(ifrCombat);
        ifrCombat.setVisible(true);
        ifrCombat.setLocation(450, 250);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void lbTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTestMouseClicked
        IfrCombat ifrCombat = new IfrCombat(lbBot);
        jDesktopPane1.add(ifrCombat);
        ifrCombat.setVisible(true);
        ifrCombat.setLocation(450, 250);
    }//GEN-LAST:event_lbTestMouseClicked

    private void lbBotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBotMouseClicked
         lbBot.setEnabled(!lbBot.isEnabled());
    }//GEN-LAST:event_lbBotMouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        IfrTest ifrTest = new IfrTest();
        jDesktopPane1.add(ifrTest);
        ifrTest.setVisible(true);
        ifrTest.setLocation(450, 250);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
       JOptionPane.showMessageDialog(null, "Tributo aos colegas em geral maybe ? otakus!", "VIDA DURA AMIGOS",1,mana); 
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        JOptionPane.showMessageDialog(null, "Tributo ao resto dos colegas!", "VIDA DURA AMIGOS",1,nanu); 
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        JOptionPane.showMessageDialog(null, "Tributo aos professores que tem q me aturar as vezes!", "VIDA DURA AMIGOS",1,mane); 
    }//GEN-LAST:event_jMenuItem11ActionPerformed
        public static void main(String args[]) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new FrmMain().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imnAttackItem;
    private javax.swing.JMenuItem imnCharacter;
    private javax.swing.JMenuItem imnDefenseItem;
    private javax.swing.JMenuItem imnExit;
    private javax.swing.JMenuItem imnMonster;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel lbBot;
    private javax.swing.JLabel lbTest;
    // End of variables declaration//GEN-END:variables
}
