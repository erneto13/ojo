package abc_eclipse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class abc_limpio {

	private JFrame frame;
	private JTextField txtClave;
	private JTextField txtNombre;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abc_limpio window = new abc_limpio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public abc_limpio() {
		initialize();
		
        //ABRIR CONEXI�N CON BASE DE DATOS (INICIALIZACI�N DE CONEXI�N CON BD)
        try {
            //Crea la conexi�n con la base de datos
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ABCJava;user=amaral;password=amaral;encrypt=false"; //Crea la cadena de conexión
            con = DriverManager.getConnection(connectionUrl); //Abre la conexi�n
            JOptionPane.showMessageDialog(null,"La conexi�n se llevo a cabo con �xito :P");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ e.toString());
        } 
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 261, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClave = new JLabel("Clave: ");
		lblClave.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblClave.setBounds(42, 42, 46, 14);
		frame.getContentPane().add(lblClave);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNombre.setBounds(42, 67, 62, 14);
		frame.getContentPane().add(lblNombre);
		
		txtClave = new JTextField();
		txtClave.setBounds(81, 39, 86, 20);
		frame.getContentPane().add(txtClave);
		txtClave.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(93, 64, 86, 20);
		frame.getContentPane().add(txtNombre);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 120, 245, 94);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		final JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if (e.getSource() == btnAgregar) //Permite identificar que elemento del formulario disparó el evento
		        {
		            try
		            {
		                String strSQL = "INSERT INTO paises (clave,nombre) VALUES ('" + txtClave.getText() + "','" + txtNombre.getText() + "')";
		                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
		                int rowsEffected = stmt.executeUpdate(strSQL); //Es el que dispara la sentencia SQL contra la base de datos
		                JOptionPane.showMessageDialog(null,rowsEffected + " rows effected");
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: " + ex.toString());
		            }
		        }
			}
		});
		btnAgregar.setFont(new Font("Poppins", Font.PLAIN, 12));
		panel.add(btnAgregar);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if (e.getSource() == btnModificar) //Lo mismo que el anterior
		        {
		            try
		            {
		                String strSQL = "UPDATE paises SET nombre = '" + txtNombre.getText() + "' where clave = '" + txtClave.getText() + "'";
		                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
		                int rowsEffected = stmt.executeUpdate(strSQL);
		                JOptionPane.showMessageDialog(null,rowsEffected + " rows effected");
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
		            }
		        }
				
			}
		});
		btnModificar.setFont(new Font("Poppins", Font.PLAIN, 12));
		panel.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if (e.getSource() == btnEliminar) //Lo mismo que el anterior
		        {
		            try
		            {
		                String strSQL = "DELETE from paises where clave = '" + txtClave.getText() + "'";
		                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
		                int rowsEffected = stmt.executeUpdate(strSQL);
		                JOptionPane.showMessageDialog(null,rowsEffected + " rows effected");
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
		            }
		        }
				
			}
		});
		btnEliminar.setFont(new Font("Poppins", Font.PLAIN, 12));
		panel.add(btnEliminar);
		
		final JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if (e.getSource() == btnConsultar) //Varia un poco
		        {
		            try
		            {
		                String SQL = "SELECT * FROM paises where clave ='" + txtClave.getText() + "'"; //Texto de sentencia SQL (query)
		                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
		                ResultSet rs = stmt.executeQuery(SQL); //Declaración de variable para guardar resultados de sentencia SQL y ejecución
		                rs.next(); //Accede (se posiciona) a la tupla en el resultset después de ejecutar el select contra la base de datos (de manera inicial no se puede acceder hasta llamar a "next"
		                txtNombre.setText(rs.getString("Nombre")); //Toma el valor del campo "nombre" y se muestra en el textbox correspondiente
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ ex.toString());
		            }
		        }
				
			}
		});
		btnConsultar.setFont(new Font("Poppins", Font.PLAIN, 12));
		panel.add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("ABC Recodificado");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 112, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 27, 245, 2);
		frame.getContentPane().add(panel_1);
	}
}
