package console_wapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.awt.Toolkit;

public class suma_2val {

	private JFrame frmSumarValores;
	private JTextField txtnum1;
	private JTextField txtnum2;
	private JTextField res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					suma_2val window = new suma_2val();
					window.frmSumarValores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public suma_2val() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSumarValores = new JFrame();
		frmSumarValores.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Desktop\\Servidores\\HYRONIC SURVIVAL (2)\\HYRONIC SURVIVAL\\Hyronic Survival - File\\plugins\\Oraxen\\pack\\textures\\custom\\bosses\\ravenna.png"));
		frmSumarValores.setTitle("Sumar");
		frmSumarValores.setResizable(false);
		frmSumarValores.getContentPane().setForeground(new Color(102, 153, 51));
		frmSumarValores.getContentPane().setLocale(new Locale("af"));
		frmSumarValores.getContentPane().setIgnoreRepaint(true);
		frmSumarValores.getContentPane().setBackground(new Color(255, 255, 255));
		frmSumarValores.setBackground(new Color(128, 0, 255));
		frmSumarValores.getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 11));
		frmSumarValores.setBounds(100, 100, 242, 208);
		frmSumarValores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSumarValores.getContentPane().setLayout(null);
		
		JLabel txtTitle = new JLabel("Sumar 2 valores");
		txtTitle.setEnabled(false);
		txtTitle.setFont(new Font("Century Gothic", Font.BOLD, 11));
		txtTitle.setBounds(75, 11, 136, 16);
		frmSumarValores.getContentPane().add(txtTitle);
		
		JLabel lblNewLabel = new JLabel("Primer valor");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setBounds(28, 38, 89, 14);
		frmSumarValores.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Segundo valor");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(28, 63, 89, 14);
		frmSumarValores.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(28, 88, 89, 14);
		frmSumarValores.getContentPane().add(lblNewLabel_2);
		
		txtnum1 = new JTextField();
		txtnum1.setBounds(125, 35, 86, 20);
		frmSumarValores.getContentPane().add(txtnum1);
		txtnum1.setColumns(10);
		
		txtnum2 = new JTextField();
		txtnum2.setBounds(125, 60, 86, 20);
		frmSumarValores.getContentPane().add(txtnum2);
		txtnum2.setColumns(10);
		
		res = new JTextField();
		res.setEditable(false);
		res.setBounds(125, 85, 86, 20);
		frmSumarValores.getContentPane().add(res);
		res.setColumns(10);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Declaramos las variables y se le asigan a las cajas de texto
				int num1 = Integer.parseInt(txtnum1.getText());
				int num2 = Integer.parseInt(txtnum2.getText());
				
				// Establecemos a la variable suma el valor de la suma de estás 2 variables
				int suma = num1 + num2;
				
				// El resultado lo colocamos en la caja de texto del resultado
				res.setText(String.valueOf(suma));
			}
		});
		btnSumar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSumar.setBounds(28, 116, 89, 23);
		frmSumarValores.getContentPane().add(btnSumar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnum1.setText("");
				txtnum2.setText("");
				res.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLimpiar.setBounds(122, 116, 89, 23);
		frmSumarValores.getContentPane().add(btnLimpiar);
		
	}
}
