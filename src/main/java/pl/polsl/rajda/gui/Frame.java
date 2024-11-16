package pl.polsl.rajda.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pl.polsl.rajda.model.*;

/**
   * Class supports user graphical interface
   *
   * @author Radosław Rajda 
   * @version 2.0
*/
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame and centers objects
     */
    public Frame() {
        initComponents();
        initializeTable();
        
        getContentPane().setLayout(new BorderLayout());

        jLabel2.setHorizontalAlignment(JLabel.CENTER);

        jScrollPane1.setAlignmentX(Component.CENTER_ALIGNMENT);

        getContentPane().add(jLabel2, BorderLayout.NORTH);
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        getContentPane().add(jPanel1, BorderLayout.SOUTH);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Berger Table Generator");
        jLabel2.setToolTipText("App title label");

        jScrollPane1.setToolTipText("Panel to scroll the table");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setToolTipText("Players table");
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("playersTable");

        jPanel1.setToolTipText("Settings panel");

        jButton1.setMnemonic('r');
        jButton1.setText("Run");
        jButton1.setToolTipText("Generate gerber table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter number of players:");
        jLabel1.setToolTipText("Players number label");

        jSpinner1.setToolTipText("Insert players number");
        jSpinner1.setMinimumSize(new java.awt.Dimension(300, 22));
        jSpinner1.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setToolTipText("Label for displaying exceptions");

        jCheckBox1.setMnemonic('n');
        jCheckBox1.setText("Use custom players names");
        jCheckBox1.setToolTipText("Enable asking for players names");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jCheckBox1)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        jSpinner1.getAccessibleContext().setAccessibleName("playersAmount");
        jCheckBox1.getAccessibleContext().setAccessibleDescription("Enable asking for players names");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.getAccessibleContext().setAccessibleName("Scroll panel");
        jScrollPane1.getAccessibleContext().setAccessibleDescription("Panel used to scroll the table");
        jPanel1.getAccessibleContext().setAccessibleName("Settings panel");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Function for error display
     */
    private void showError(String msg) {
        jLabel3.setText(msg);
    }

    /**
     * Initializes the table model for jTable1.
     */
    private void initializeTable() {
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ));
    }

    /**
     * Updates the table with tournament rounds.
     *
     * @param table the tournament table containing rounds
     */
    private void updateTable(Table table) {
        List<Round> rounds = table.getRounds();

        int colCount = rounds.get(0).getPairs().size();
        int rowCount = rounds.size();

        List<String> columnNames = java.util.stream.IntStream.rangeClosed(1, colCount)
            .mapToObj(i -> "Game " + i)
            .toList();

        List<List<String>> tableData = new ArrayList<>();
        rounds.forEach(round -> {
            List<String> row = new ArrayList<>();
            round.getPairs().forEach(pair -> row.add(pair.player1().name() + " vs " + pair.player2().name()));
            tableData.add(row);
        });

        DefaultTableModel tableModel = new DefaultTableModel(columnNames.toArray(), rowCount);
        for (int row = 0; row < tableData.size(); row++) {
            for (int col = 0; col < tableData.get(row).size(); col++) {
                tableModel.setValueAt(tableData.get(row).get(col), row, col);
            }
        }

        jTable1.setModel(tableModel);

        List<String> rowHeaders = java.util.stream.IntStream.rangeClosed(1, rowCount)
            .mapToObj(i -> "Round " + i)
            .toList();

        JList<String> rowHeaderList = new JList<>(rowHeaders.toArray(new String[0]));
        rowHeaderList.setFixedCellWidth(100);
        rowHeaderList.setFixedCellHeight(jTable1.getRowHeight());
        rowHeaderList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            }
        });

        jScrollPane1.setRowHeaderView(rowHeaderList);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getTableHeader().setDefaultRenderer(headerRenderer);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int minColumnWidth = 170;
        java.util.stream.IntStream.range(0, jTable1.getColumnModel().getColumnCount())
            .forEach(i -> {
                jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                jTable1.getColumnModel().getColumn(i).setMinWidth(minColumnWidth);
                jTable1.getColumnModel().getColumn(i).setPreferredWidth(minColumnWidth);
            });

        int tableWidth = colCount * minColumnWidth;
        jTable1.setPreferredScrollableViewportSize(new Dimension(tableWidth, jTable1.getPreferredScrollableViewportSize().height));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }



    /**
     * Starts the generation of the tournament table.
     */
    private void start() {
        int playersAmount = (Integer) jSpinner1.getValue();
        boolean useCustomNames = jCheckBox1.isSelected();

        try {
            if (playersAmount < 2) {
                throw new InvalidPlayerAmountException("The number of players must be greater than 1.");
            }

            List<Player> players = new ArrayList<>();

            if (useCustomNames) {
                for (int i = 1; i <= playersAmount; i++) {
                    String playerName = JOptionPane.showInputDialog(this, "Enter name for player " + i + ":");
                    players.add(new Player((playerName == null || playerName.trim().isEmpty()) ? "Player " + i : playerName));
                }
            } else {
                java.util.stream.IntStream.rangeClosed(1, playersAmount)
                    .forEach(i -> players.add(new Player("Player " + i)));
            }

            TableGenerationStrategy strategy = new BergerTableGenerationStrategy();
            Table table = new Table(players, strategy);

            updateTable(table);

            jLabel3.setText("");

        } catch (InvalidPlayerAmountException e) {
            showError(e.getMessage());
        }
    }




    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
