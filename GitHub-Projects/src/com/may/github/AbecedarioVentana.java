package com.may.github;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class AbecedarioVentana extends JFrame {
    private JPanel panelContenedor;

    public AbecedarioVentana(String abecedarioOriginal, String abecedarioModificado) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        panelContenedor = new JPanel();
        panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelContenedor);
        panelContenedor.setLayout(null);
        setTitle("Abecedario del Cifrado de César");
        setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Downloads\\icon-fim.png"));

        
        JLabel lblAbecedarioOriginal = new JLabel("Abecedario Original");
        lblAbecedarioOriginal.setFont(new Font("Poppins", Font.BOLD, 16));
        lblAbecedarioOriginal.setBounds(20, 20, 180, 20);
        panelContenedor.add(lblAbecedarioOriginal);

        JLabel lblOriginal = new JLabel(abecedarioOriginal);
        lblOriginal.setBounds(40, 60, 320, 20);
        panelContenedor.add(lblOriginal);

        JLabel lblAbecedarioModificado = new JLabel("Abecedario Modificado");
        lblAbecedarioModificado.setFont(new Font("Poppins", Font.BOLD, 16));
        lblAbecedarioModificado.setBounds(20, 100, 200, 20);
        panelContenedor.add(lblAbecedarioModificado);

        JLabel lblModificado = new JLabel(abecedarioModificado);
        lblModificado.setBounds(40, 140, 320, 20);
        panelContenedor.add(lblModificado);
    }
}

