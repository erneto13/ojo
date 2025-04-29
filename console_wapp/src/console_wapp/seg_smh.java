package console_wapp;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.*;

public class seg_smh {

	private JFrame frmConvertidorDeSegundos;
	private JTextField txtSegundos;
	private JTextField txtSegundoss;
	private JTextField txtMinutos;
	private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seg_smh window = new seg_smh();
					window.frmConvertidorDeSegundos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public seg_smh() {
		initialize();
	}

	/**
	 * El inicializador dentro del frame.
	 */
	private void initialize() {
		frmConvertidorDeSegundos = new JFrame();
		frmConvertidorDeSegundos.setResizable(false);
		frmConvertidorDeSegundos.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Desktop\\Servidores\\HYRONIC SURVIVAL (2)\\HYRONIC SURVIVAL\\Hyronic Survival - File\\plugins\\Oraxen\\pack\\textures\\custom\\emojis\\yaranaika.png"));
		frmConvertidorDeSegundos.setTitle("Convertidor de Segundos");
		frmConvertidorDeSegundos.setBounds(100, 100, 319, 300);
		frmConvertidorDeSegundos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConvertidorDeSegundos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convertir segundos a segundos, minutos y horas.");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 347, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los segundos a convertir: ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 44, 254, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_1);
		
		txtSegundos = new JTextField();
		txtSegundos.setBounds(10, 69, 86, 20);
		frmConvertidorDeSegundos.getContentPane().add(txtSegundos);
		txtSegundos.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("seg");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(106, 72, 39, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Estas son sus conversiones: ");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(10, 110, 254, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_1_2);
		
		txtSegundoss = new JTextField();
		txtSegundoss.setEditable(false);
		txtSegundoss.setColumns(10);
		txtSegundoss.setBounds(10, 135, 86, 20);
		frmConvertidorDeSegundos.getContentPane().add(txtSegundoss);
		
		txtMinutos = new JTextField();
		txtMinutos.setEditable(false);
		txtMinutos.setColumns(10);
		txtMinutos.setBounds(10, 166, 86, 20);
		frmConvertidorDeSegundos.getContentPane().add(txtMinutos);
		
		txtHoras = new JTextField();
		txtHoras.setEditable(false);
		txtHoras.setColumns(10);
		txtHoras.setBounds(10, 197, 86, 20);
		frmConvertidorDeSegundos.getContentPane().add(txtHoras);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("seg");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(106, 138, 39, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("minuto/s");
		lblNewLabel_1_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1_1_2.setBounds(106, 169, 70, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("hora/s");
		lblNewLabel_1_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1_1_3.setBounds(106, 200, 39, 14);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_1_1_3);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String texto = txtSegundos.getText(); // Asigno la caja de texto a esta var texto para comprobarla
				
				if (texto.isEmpty()) { // Comprobar si el texto está vacío
					   JOptionPane.showMessageDialog(null, "El campo de los segundos a convertir debe estar llenado previamente", "Advertencia", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de error
					}
					else if (verificador(txtSegundos.getText().trim())) {
						Component rootPane = null;
						JOptionPane.showMessageDialog(rootPane, "Los segundos a convertir deben ser numeros, que loco estás pa", "Has enloquecido Parker", JOptionPane.WARNING_MESSAGE);
					} 
					else {
						// Si ya introdujo los valores necesarios, el código seguirá con normalidad
						int segundos = Integer.parseInt(txtSegundos.getText());
						
						int seg = segundos;
						int convMinutos = segundos/60;
						int convHoras = segundos/3600;
						
						txtSegundoss.setText(String.valueOf(seg));
						txtMinutos.setText(String.valueOf(convMinutos));
						txtHoras.setText(String.valueOf(convHoras));
					}
			}

			private boolean verificador(String trim) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		btnCalcular.setBounds(199, 196, 89, 23);
		frmConvertidorDeSegundos.getContentPane().add(btnCalcular);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String vaciartexto = txtSegundos.getText(); //asigno la caja de texto a esta var texto para comprobarla
				
				if (vaciartexto.isEmpty()) { //comprobar si el texto está vacío
					   JOptionPane.showMessageDialog(null, "No hay nada para limpiar, talvez un 2019, 2020, 2021, 2022 te haga reflexionar", "Error supergrave", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de error
					} else {
						txtSegundoss.setText("");
						txtSegundos.setText("");
						txtMinutos.setText("");
						txtHoras.setText("");
					}
			}
		});
		btnLimpiar.setBounds(199, 160, 89, 23);
		frmConvertidorDeSegundos.getContentPane().add(btnLimpiar);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Pictures\\amlopelon.jpg"));
		lblNewLabel_2.setBounds(193, 36, 100, 103);
		frmConvertidorDeSegundos.getContentPane().add(lblNewLabel_2);
	}
}
