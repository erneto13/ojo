import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class PantallaLogin {

	private JFrame frmInicioDeSesin;
	private JTextField txtCorreoElectronico;
	private JPasswordField txtContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin window = new PantallaLogin();
					window.frmInicioDeSesin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaLogin() {
		inicializador();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void inicializador() {
		frmInicioDeSesin = new JFrame();
		frmInicioDeSesin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Desktop\\aaaaaaaaaaaaaaaaaaa.png"));
		frmInicioDeSesin.setTitle("Sesión");
		frmInicioDeSesin.setResizable(false);
		frmInicioDeSesin.setBounds(100, 100, 249, 232);
		frmInicioDeSesin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesin.getContentPane().setLayout(null);
		
		JLabel lblCorreo = new JLabel("Usuario ");
		lblCorreo.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 23, 125, 14);
		frmInicioDeSesin.getContentPane().add(lblCorreo);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCorreoElectronico.setBounds(10, 48, 195, 20);
		frmInicioDeSesin.getContentPane().add(txtCorreoElectronico);
		txtCorreoElectronico.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblContrasenia.setBounds(10, 79, 82, 14);
		frmInicioDeSesin.getContentPane().add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setFont(new Font("Poppins", Font.PLAIN, 11));
		txtContrasenia.setBounds(10, 104, 195, 20);
		frmInicioDeSesin.getContentPane().add(txtContrasenia);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String correo = txtCorreoElectronico.getText();
				char[] contrasenia = txtContrasenia.getPassword();
				String contraseniaCompleta = new String(contrasenia);
				
		        if (correo.equals("admin") && contraseniaCompleta.equals("root")) {  //if authentic, navigate user to a new page  
		            
		        	JOptionPane.showMessageDialog(null, "Sesión iniciada Bienvenido");
		            // Se crea una instancia de la clase MenuPrincipal  
		        	
		            MenuABC paginaPrincipal = new MenuABC();  
		              
		            // La hacemos visibible para el usuario  
		            paginaPrincipal.setVisible(true);
		    		frmInicioDeSesin.dispose();
		    		
		        
		        } else {
		            JOptionPane.showMessageDialog(null, "Las credenciales no son correctas, verifique de nuevo.", "Credenciales incorrectas", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		btnIniciarSesion.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnIniciarSesion.setBounds(10, 144, 195, 20);
		frmInicioDeSesin.getContentPane().add(btnIniciarSesion);
	}
}
