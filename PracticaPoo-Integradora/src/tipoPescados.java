import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class tipoPescados extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    Connection con;
    JButton btnAgregar, btnModificar, btnBorrar, btnConsultar;
    JTextField txtClave, txtNombre;
    protected JTable tablaSQLcategorias;

    public tipoPescados() {
        setBounds(100, 100, 397, 468);
        Container c;
        JPanel panelSuperior = new JPanel();
        JPanel panelBotones = new JPanel();

        // ABRIR CONEXI�N CON BASE DE DATOS (INICIALIZACI�N DE CONEXI�N CON BD)
        try {
            // Crea la conexi�n con la base de datos
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=POO;user=amaral;password=amaral;encrypt=false"; // Crea la cadena de conexión
            con = DriverManager.getConnection(connectionUrl); // Abre la conexi�n
            JOptionPane.showMessageDialog(null, "Se ha efectuado la conexión a la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un eror al conectarse a la BD: " + e.toString());
        }

        // ESTABLECER LAYOUT Y CREAR BOTONES (INICIALIZACI�N DE INTERFAZ DE USUARIO)
        c = getContentPane();
        BorderLayout bl = new BorderLayout();
        c.setLayout(bl); // Layout del formulario

        c.add(panelSuperior, BorderLayout.NORTH);
        c.add(panelBotones, BorderLayout.SOUTH);

        GridLayout gl = new GridLayout(2, 2);
        panelSuperior.setLayout(gl); // Layout del panel superior

        FlowLayout fl = new FlowLayout();
        panelBotones.setLayout(fl); // Layout del panel botones

        // Crear componentes de la interfaz de usuario
        JLabel lblClave = new JLabel(" ID");
        lblClave.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel lblNombre = new JLabel(" Nombre");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));

        txtClave = new JTextField();
        txtNombre = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnAgregar.addActionListener(this); // btnAgregar.addActionListener(new MiClase());
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnModificar.addActionListener(this);
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnBorrar.addActionListener(this);
        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnConsultar.addActionListener(this);

        
        panelSuperior.add(lblClave);
        panelSuperior.add(lblNombre);
        
        panelSuperior.add(txtClave);
        panelSuperior.add(txtNombre);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnConsultar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            try {
            	 String strSQL = "INSERT INTO tabla_tipoPescados (ID,nombre) VALUES ('" + txtClave.getText() + "','" + txtNombre.getText() + "')";
                 Statement stmt = con.createStatement();
                 int rowsEffected = stmt.executeUpdate(strSQL);
                 JOptionPane.showMessageDialog(null, rowsEffected + " columnas han sido actualizado");
                 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                String strSQL = "UPDATE tabla_tipoPescados SET Nombre = '" + txtNombre.getText() + "' where ID = '"
                        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsAffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsAffected + " columnas han sido actualizado");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBorrar) {
            // Borrar una columna de la base de datos
            try {
                String strSQL = "DELETE from tabla_tipoPescados where ID = '" + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " columnas han sido actualizado");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
            	String SQL = "SELECT * FROM tabla_tipoPescados where ID ='" + txtClave.getText() + "'"; //Texto de sentencia SQL (query)
                Statement stmt = con.createStatement(); //Declaración de variable y preparación de sentencia SQL
                ResultSet rs = stmt.executeQuery(SQL); //Declaración de variable para guardar resultados de sentencia SQL y ejecución
                rs.next(); //Accede (se posiciona) a la tupla en el resultset después de ejecutar el select contra la base de datos (de manera inicial no se puede acceder hasta llamar a "next"
                txtNombre.setText(rs.getString("Nombre")); //Toma el valor del campo "nombre" y se muestra en el textbox correspondiente
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
    }
    }
