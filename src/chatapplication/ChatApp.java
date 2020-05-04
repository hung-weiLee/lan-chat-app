package chatapplication;

import javax.swing.*;

public class ChatApp extends javax.swing.JFrame {

    static  String name;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;

    public ChatApp() {
        this.setTitle("ChatApp");
        initComponents();
        this.setLocationRelativeTo(null); // the window will placed in the center of the screen
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // click "X" to Exit the application
        this.setBackground(new java.awt.Color(255, 255, 153));
        this.setFont(new java.awt.Font("Cambria Math", 3, 10)); // NOI18N
        this.setForeground(new java.awt.Color(255, 0, 0));

        jButton2.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jButton2.setText("Login to Chat Room");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(121, 121, 121)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
        );
        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MultiClient();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        System.exit(1);
    }


    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatApp().setVisible(true);
            }
        });
    }
}
