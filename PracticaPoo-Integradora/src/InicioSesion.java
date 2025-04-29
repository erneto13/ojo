import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion {

	private JFrame frmLogin;
	private JTextField txtCorreoElectronico;
	private JPasswordField txtContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion window = new InicioSesion();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		inicializador();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void inicializador() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 249, 197);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo electrónico: ");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 39, 125, 14);
		frmLogin.getContentPane().add(lblCorreo);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCorreoElectronico.setBounds(10, 55, 195, 20);
		frmLogin.getContentPane().add(txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContrasenia.setBounds(10, 86, 82, 14);
		frmLogin.getContentPane().add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setFont(new Font("Arial", Font.PLAIN, 11));
		txtContrasenia.setBounds(10, 101, 195, 20);
		frmLogin.getContentPane().add(txtContrasenia);
		
		JButton btnIniciarSesion = new JButton("Iniciar");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CORREOINICIARSESION = txtCorreoElectronico.getText();
				char[] CONTRASENIAINICIARSESION = txtContrasenia.getPassword();
				String CONTRASENI_DESGLOSADA = new String(CONTRASENIAINICIARSESION);
				
		        if (CORREOINICIARSESION.equals("lugo") && CONTRASENI_DESGLOSADA.equals("vanesa")) {
		            
		            menu menuinicio = new menu();  
		            menuinicio.setVisible(true);
		    		frmLogin.dispose();
		        }
				
			}
		});
		btnIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIniciarSesion.setBounds(10, 132, 76, 20);
		frmLogin.getContentPane().add(btnIniciarSesion);
	}
}
