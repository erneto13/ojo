package com.may.github;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AbecedarioASCII extends JFrame {

    private JPanel contentPane;
    private JTable tablaMinusculas;
    private JTable tablaMayusculas;

    private final String[] letrasMinusculas = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private final String[] letrasMayusculas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AbecedarioASCII frame = new AbecedarioASCII();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AbecedarioASCII() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        setTitle("Abecedario ASCII del Algoritmo RSA");
        setResizable(false);
        	
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Downloads\\icon-fim.png"));

        JScrollPane scrollPaneMinusculas = new JScrollPane();
        scrollPaneMinusculas.setBounds(10, 10, 220, 240);
        contentPane.add(scrollPaneMinusculas);

        tablaMinusculas = new JTable();
        tablaMinusculas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Letra", "Código ASCII"}
        ));
        scrollPaneMinusculas.setViewportView(tablaMinusculas);

        JScrollPane scrollPaneMayusculas = new JScrollPane();
        scrollPaneMayusculas.setBounds(250, 10, 220, 240);
        contentPane.add(scrollPaneMayusculas);

        tablaMayusculas = new JTable();
        tablaMayusculas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Letra", "Código ASCII"}
        ));
        scrollPaneMayusculas.setViewportView(tablaMayusculas);

        // Llenar tabla de letras minúsculas
        DefaultTableModel modelMinusculas = (DefaultTableModel) tablaMinusculas.getModel();
        for (int i = 0; i < letrasMinusculas.length; i++) {
            modelMinusculas.addRow(new Object[]{letrasMinusculas[i], (int) letrasMinusculas[i].charAt(0)});
        }

        // Llenar tabla de letras mayúsculas
        DefaultTableModel modelMayusculas = (DefaultTableModel) tablaMayusculas.getModel();
        for (int i = 0; i < letrasMayusculas.length; i++) {
            modelMayusculas.addRow(new Object[]{letrasMayusculas[i], (int) letrasMayusculas[i].charAt(0)});
        }
    }
}
