package console_wapp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Toolkit;

public class doce_c {

	private JFrame frmConvertidor;
	private JTextField txtFormato24;
	private JTextField txtFormato12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doce_c window = new doce_c();
					window.frmConvertidor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public doce_c() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConvertidor = new JFrame();
		frmConvertidor.setTitle("Convertidor de horas");
		frmConvertidor.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Pictures\\4.png"));
		frmConvertidor.setResizable(false);
		frmConvertidor.setBounds(100, 100, 304, 209);
		frmConvertidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConvertidor.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Convertir formato de 24 horas a 12 horas.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 340, 14);
		frmConvertidor.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dígite el formato de 24 horas (hh:mm)");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 44, 226, 14);
		frmConvertidor.getContentPane().add(lblNewLabel_1);
		
		txtFormato24 = new JTextField();
		txtFormato24.setBounds(10, 69, 105, 20);
		frmConvertidor.getContentPane().add(txtFormato24);
		txtFormato24.setColumns(5);
		
		JLabel lblNewLabel_1_1 = new JLabel("He aquí su formato en 12 horas:");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(10, 100, 226, 14);
		frmConvertidor.getContentPane().add(lblNewLabel_1_1);
		
		txtFormato12 = new JTextField();
		txtFormato12.setEditable(false);
		txtFormato12.setColumns(10);
		txtFormato12.setBounds(10, 125, 105, 20);
		frmConvertidor.getContentPane().add(txtFormato12);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodo_calcular();
			}
		});
		btnCalcular.setBounds(189, 125, 89, 23);
		frmConvertidor.getContentPane().add(btnCalcular);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar_campos();
			}
		});
		btnLimpiar.setBounds(189, 91, 89, 23);
		frmConvertidor.getContentPane().add(btnLimpiar);
	}
	
	
	// Método para calcular el formato de horas de 24 a 12
	private void metodo_calcular() {
		String hora24 = (txtFormato24.getText());
		int hora = Integer.parseInt(hora24.substring(0, 2));
		int minutos = Integer.parseInt(hora24.substring(3, 5));
		String periodo;
		
        if (hora < 12) {
            periodo = "AM";
        } else {
            periodo = "PM";
            if (hora > 12) {
                hora -= 12;
            }
        }
        String hora12 = String.format("%d:%02d %s", hora, minutos, periodo);
        txtFormato12.setText(String.valueOf(hora12));
	}
	
	// Método para limpiar los campos
	private void limpiar_campos() {
		txtFormato24.setText("");
		txtFormato12.setText("");				
	}
}
