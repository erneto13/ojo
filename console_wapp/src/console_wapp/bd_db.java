package console_wapp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class bd_db {

	private JFrame frmOriginRealmsLauncher;
	private JTextField txtBinario;
	private JTextField txtDecimalRes;
	private JTextField txtDecimal;
	private JTextField txtBinarioRes;
	private JButton btnConvertirDB;
	private JButton btnConvertirBD;
	private JButton btnLimpiarBD;
	private JButton btnLimpiarDB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bd_db window = new bd_db();
					window.frmOriginRealmsLauncher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bd_db() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOriginRealmsLauncher = new JFrame();
		frmOriginRealmsLauncher.setTitle("Convertidor de binario a decimal");
		frmOriginRealmsLauncher.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Pictures\\a.png"));
		frmOriginRealmsLauncher.setResizable(false);
		frmOriginRealmsLauncher.setBounds(100, 100, 450, 365);
		frmOriginRealmsLauncher.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convertidor de números binarios a decimal y viceversa.");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 28, 346, 14);
		frmOriginRealmsLauncher.getContentPane().add(lblNewLabel);
		
		JLabel lblEligaUnaOpcion = new JLabel("Eliga una opcion a realizar:");
		lblEligaUnaOpcion.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEligaUnaOpcion.setBounds(10, 64, 170, 14);
		frmOriginRealmsLauncher.getContentPane().add(lblEligaUnaOpcion);
		
		
		// Estos son mis botones seleccionadores
		final JRadioButton rbtnBinarioDecimal = new JRadioButton("Convertir binario a decimal");
		rbtnBinarioDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					txtBinario.setEnabled(true);
					txtDecimalRes.setEnabled(true);
					txtBinario.setEditable(true);
					txtDecimal.setEnabled(false);
					txtBinarioRes.setEnabled(false);
					txtDecimal.setEditable(false);
					txtDecimal.setText("");
					txtBinarioRes.setText("");

				}
		});
		rbtnBinarioDecimal.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rbtnBinarioDecimal.setBounds(10, 85, 215, 23);
		frmOriginRealmsLauncher.getContentPane().add(rbtnBinarioDecimal);
		
		final JRadioButton rbtnDecimalBinario = new JRadioButton("Convertir decimal a binario");
		rbtnDecimalBinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDecimal.setEnabled(true);
				txtBinarioRes.setEnabled(true);
				txtDecimal.setEditable(true);
				txtBinario.setEnabled(false);
				txtDecimalRes.setEnabled(false);
				txtBinario.setEditable(false);
				txtBinario.setText("");
				txtDecimalRes.setText("");
			}
		});
		rbtnDecimalBinario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		rbtnDecimalBinario.setBounds(10, 111, 215, 23);
		frmOriginRealmsLauncher.getContentPane().add(rbtnDecimalBinario);
		
		// Agrega los botones de opción a un ButtonGroup
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rbtnBinarioDecimal);
		buttonGroup.add(rbtnDecimalBinario);
		
		JLabel lblBinarioADecimal = new JLabel("Binario a decimal");
		lblBinarioADecimal.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblBinarioADecimal.setBounds(45, 155, 116, 14);
		frmOriginRealmsLauncher.getContentPane().add(lblBinarioADecimal);
		
		JLabel lblDecimalABinario = new JLabel("Decimal a binario");
		lblDecimalABinario.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblDecimalABinario.setBounds(282, 156, 116, 14);
		frmOriginRealmsLauncher.getContentPane().add(lblDecimalABinario);
		
		txtBinario = new JTextField();
		txtBinario.setEnabled(false);
		txtBinario.setEditable(false);
		txtBinario.setBounds(45, 180, 100, 20);
		frmOriginRealmsLauncher.getContentPane().add(txtBinario);
		txtBinario.setColumns(10);
		
		txtDecimalRes = new JTextField();
		txtDecimalRes.setEnabled(false);
		txtDecimalRes.setEditable(false);
		txtDecimalRes.setColumns(10);
		txtDecimalRes.setBounds(45, 211, 100, 20);
		frmOriginRealmsLauncher.getContentPane().add(txtDecimalRes);
		
		txtDecimal = new JTextField();
		txtDecimal.setEnabled(false);
		txtDecimal.setEditable(false);
		txtDecimal.setColumns(10);
		txtDecimal.setBounds(282, 180, 100, 20);
		frmOriginRealmsLauncher.getContentPane().add(txtDecimal);
		
		txtBinarioRes = new JTextField();
		txtBinarioRes.setEnabled(false);
		txtBinarioRes.setEditable(false);
		txtBinarioRes.setColumns(10);
		txtBinarioRes.setBounds(282, 211, 100, 20);
		frmOriginRealmsLauncher.getContentPane().add(txtBinarioRes);
		
		JButton btnConvertirBD = new JButton("Convertir");
		btnConvertirBD.setBounds(45, 245, 89, 23);
		btnConvertirBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String vaciartexto = txtBinario.getText(); //asigno la caja de texto a esta var texto para comprobarla
				
				if (vaciartexto.isEmpty()) { //comprobar si el texto está vacío
					   JOptionPane.showMessageDialog(null, "Debe llenar el campo necesario antes de continua", "Error", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de error
				}
				else if (rbtnBinarioDecimal.isSelected()) {
					try {
						int decimal = binarioDecimal(txtBinario.getText());
						txtDecimalRes.setText(String.valueOf(decimal));
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Formato inválido, ", "Atención", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de error
					}
				}
			}
		});
		frmOriginRealmsLauncher.getContentPane().add(btnConvertirBD);
		
		JButton btnLimpiarBD = new JButton("Limpiar");
		btnLimpiarBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vaciartexto = txtBinario.getText(); //asigno la caja de texto a esta var texto para comprobarla

				if (vaciartexto.isEmpty()) { //comprobar si el texto está vacío
					   JOptionPane.showMessageDialog(null, "Dentro del campo para limpiar no se encuentra nada", "Atención", JOptionPane.WARNING_MESSAGE); //mostrar mensaje de error
					} else 
						txtBinario.setText("");
						txtDecimalRes.setText("");
			}
		});
		btnLimpiarBD.setBounds(45, 279, 89, 23);
		frmOriginRealmsLauncher.getContentPane().add(btnLimpiarBD);
		
		JButton btnConvertirDB = new JButton("Convertir");
		btnConvertirDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtnDecimalBinario.isSelected()) {
					try {
						String binary = decimalBinario(Integer.parseInt(txtDecimal.getText()));
						txtBinarioRes.setText(binary);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Debe llenar el campo necesario antes de continua", "Error", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de error
					}
				}
			}
		});
		btnConvertirDB.setBounds(282, 242, 89, 23);
		frmOriginRealmsLauncher.getContentPane().add(btnConvertirDB);
		
		JButton btnLimpiarDB = new JButton("Limpiar");
		btnLimpiarDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String vaciartexto = txtDecimal.getText(); //asigno la caja de texto a esta var texto para comprobarla
				
				if (vaciartexto.isEmpty()) { //comprobar si el texto está vacío
					   JOptionPane.showMessageDialog(null, "Dentro del campo para limpiar no se encuentra nada", "Atención", JOptionPane.WARNING_MESSAGE); //mostrar mensaje de error
					} else {
						txtDecimal.setText("");
						txtBinarioRes.setText("");
				}
			}
		});
		btnLimpiarDB.setBounds(282, 279, 89, 23);
		frmOriginRealmsLauncher.getContentPane().add(btnLimpiarDB);
	}
	
	// Constantes creadas para las soluciones
	private int binarioDecimal(String binario) {
		int decimal = 0;
		int power = 0;
		for (int i = binario.length() - 1; i >= 0; i--) {
			char c = binario.charAt(i);
			if (c == '1') {
				decimal += Math.pow(2, power);
			}
			power++;
		}
		return decimal;
	}

	private String decimalBinario(int decimal) {
		StringBuilder binary = new StringBuilder();
		if (decimal == 0) {
			return "0";
		}
		while (decimal > 0) {
			int remainder = decimal % 2;
			binary.append(String.valueOf(remainder));
			decimal = decimal / 2;
		}
		return binary.reverse().toString();
	}
}
