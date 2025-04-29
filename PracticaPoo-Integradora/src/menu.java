import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu {

	private JFrame menuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.menuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuPrincipal = new JFrame();
		menuPrincipal.setResizable(false);
		menuPrincipal.setTitle("Menu");
		menuPrincipal.setBounds(100, 100, 680, 267);
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCliente = new JButton("Clientes");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            clientes clientesMenu = new clientes();  
	            clientesMenu.setVisible(true);
	            menuPrincipal.dispose();		
				
			}
		});
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		menuPrincipal.getContentPane().add(btnCliente);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setFont(new Font("Arial", Font.PLAIN, 12));
		menuPrincipal.getContentPane().add(btnEmpleados);
		
		JButton btnProveedor = new JButton("Proveedores");
		btnProveedor.setFont(new Font("Arial", Font.PLAIN, 12));
		menuPrincipal.getContentPane().add(btnProveedor);
		
		JButton btnTipoDePescados = new JButton("Tipo de Pescados");
		btnTipoDePescados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            tipoPescados menuPescados = new tipoPescados();  
	            menuPescados.setVisible(true);
	            menuPrincipal.dispose();				
				
			}
		});
		btnTipoDePescados.setFont(new Font("Arial", Font.PLAIN, 12));
		menuPrincipal.getContentPane().add(btnTipoDePescados);
		
		JButton btnCliente_4 = new JButton("Cliente");
		btnCliente_4.setFont(new Font("Arial", Font.PLAIN, 12));
		menuPrincipal.getContentPane().add(btnCliente_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\ezgif.com-resize.jpg"));
		menuPrincipal.getContentPane().add(lblNewLabel);
	}
	
	public void setVisible(boolean b) {
		menuPrincipal.setVisible(true);
	}
}
