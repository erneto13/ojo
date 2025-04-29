import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuABC {

	private JFrame frmMenuPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuABC window = new MenuABC();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuABC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setResizable(false);
		frmMenuPrincipal.setTitle("Menu Principal de los ABC's");
		frmMenuPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Desktop\\iconos-botones\\logo-icon.png"));
		frmMenuPrincipal.setBounds(100, 100, 397, 468);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Desktop\\logo japones.png"));
		logo.setBounds(274, 318, 107, 111);
		frmMenuPrincipal.getContentPane().add(logo);
		
		JPanel lineaDivisora = new JPanel();
		lineaDivisora.setBackground(Color.LIGHT_GRAY);
		lineaDivisora.setBounds(0, 70, 381, 2);
		frmMenuPrincipal.getContentPane().add(lineaDivisora);
		
		JButton btnArticulos = new JButton("");
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            // Se crea una instancia de la clase FrameProveedores  
	            FrameArticulos paginaArticulos = new FrameArticulos();  
	              
	            // La hacemos visibible para el usuario  
	            paginaArticulos.setVisible(true);
	            frmMenuPrincipal.dispose();
				
			}
		});
		btnArticulos.setForeground(Color.WHITE);
		btnArticulos.setBackground(Color.WHITE);
		btnArticulos.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\ARTICULOS.png"));
		btnArticulos.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnArticulos.setBounds(10, 151, 137, 57);
		frmMenuPrincipal.getContentPane().add(btnArticulos);
		
		JButton btnCategorias = new JButton("");
		btnCategorias.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\PROVEEDORES (4).png"));
		btnCategorias.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            // Se crea una instancia de la clase FrameProveedores  
	            FrameCategorias paginaCategorias = new FrameCategorias();  
	              
	            // La hacemos visibible para el usuario  
	            paginaCategorias.setVisible(true);
	            frmMenuPrincipal.dispose();
				
			}
		});
		btnCategorias.setBounds(229, 83, 142, 57);
		frmMenuPrincipal.getContentPane().add(btnCategorias);
		
		JButton btnFacturas = new JButton("");
		btnFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            // Se crea una instancia de la clase FrameProveedores  
	            FrameFacturas paginaFacturas = new FrameFacturas();  
	              
	            // La hacemos visibible para el usuario  
	            paginaFacturas.setVisible(true);
	            frmMenuPrincipal.dispose();
				
			}
		});
		btnFacturas.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\ARTICULOS (2).png"));
		btnFacturas.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnFacturas.setBounds(234, 219, 137, 57);
		frmMenuPrincipal.getContentPane().add(btnFacturas);
		
		JButton btnProveedores = new JButton("");
		btnProveedores.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\PROVEEDORES (3).png"));
		btnProveedores.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnProveedores.setBounds(10, 83, 142, 57);
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	            // Se crea una instancia de la clase FrameProveedores  
	            FrameProveedores paginaProveedores = new FrameProveedores();  
	              
	            // La hacemos visibible para el usuario  
	            paginaProveedores.setVisible(true);
	            frmMenuPrincipal.dispose();
			
			}
			});
		frmMenuPrincipal.getContentPane().add(btnProveedores);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            // Se crea una instancia de la clase FrameProveedores  
	            FrameClientes paginaClientes = new FrameClientes();  
	              
	            // La hacemos visibible para el usuario  
	            paginaClientes.setVisible(true);
	            frmMenuPrincipal.dispose();
				
			}
		});
		btnClientes.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\ARTICULOS (1).png"));
		btnClientes.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnClientes.setBounds(10, 219, 137, 57);
		frmMenuPrincipal.getContentPane().add(btnClientes);
		
		JButton btnEmpleados = new JButton("");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            // Se crea una instancia de la clase FrameProveedores  
	            FrameEmpleados paginaEmpleados = new FrameEmpleados();  
	              
	            // La hacemos visibible para el usuario  
	            paginaEmpleados.setVisible(true);
	            frmMenuPrincipal.dispose();
				
			}
		});
		btnEmpleados.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\ARTICULOS (3).png"));
		btnEmpleados.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnEmpleados.setBounds(234, 151, 137, 57);
		frmMenuPrincipal.getContentPane().add(btnEmpleados);
	}
	
	public void setVisible(boolean b) {
		frmMenuPrincipal.setVisible(true);
	}
}
