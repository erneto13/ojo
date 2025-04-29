import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class FrameCategorias extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    Connection con;
    JButton btnAgregar, btnModificar, btnBorrar, btnConsultar;
    JTextField txtClave, txtNombre;
    protected JTable tablaSQLcategorias;

    public FrameCategorias() {
        setTitle("Menu de Categorías : Kei Sushi");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Desktop\\iconos-botones\\logo-icon.png"));
        setBounds(100, 100, 397, 468);
        setResizable(false);
        Container c;
        JPanel panelSuperior = new JPanel();
        JPanel panelBotones = new JPanel();

        // ABRIR CONEXI�N CON BASE DE DATOS (INICIALIZACI�N DE CONEXI�N CON BD)
        try {
            // Crea la conexi�n con la base de datos
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=POO-Integradora;user=amaral;password=amaral;encrypt=false"; // Crea la cadena de conexión
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
        lblClave.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblNombre = new JLabel(" Nombre");
        lblNombre.setFont(new Font("Poppins", Font.PLAIN, 12));

        txtClave = new JTextField();
        txtNombre = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnAgregar.addActionListener(this); // btnAgregar.addActionListener(new MiClase());
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnModificar.addActionListener(this);
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnBorrar.addActionListener(this);
        btnConsultar = new JButton("Consultar");
        btnConsultar.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnConsultar.addActionListener(this);

        // Agregando componentes de interfaz de usuario
        panelSuperior.add(lblClave);
        panelSuperior.add(txtClave);
        panelSuperior.add(lblNombre);
        panelSuperior.add(txtNombre);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnConsultar);

        // Agregar JTable al formulario
        DefaultTableModel model = new DefaultTableModel();
        tablaSQLcategorias = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Nombre");
        JScrollPane scrollPane = new JScrollPane(tablaSQLcategorias);
        c.add(scrollPane, BorderLayout.CENTER);

        // Agregar el evento WindowOpened a la ventana
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                consultarTablaCategorias(); // Obtener y mostrar los datos al abrir la ventana
            }
        });
    }

    private void consultarTablaCategorias() {
        try {
            String SQL = "SELECT * FROM tabla_categorias";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLcategorias.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idCategoria = rs.getString("ID");
                String nombre = rs.getString("Nombre");

                model.addRow(new Object[] { idCategoria, nombre });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la BD: " + ex.toString());
        }
    }

    /*
     * Método que se dispara al hacer clic sobre cualquier botón en formulario
     * (porqué el formulario implementa la interfaz ActionListener)
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            try {
            	 String strSQL = "INSERT INTO tabla_categorias (ID,nombre) VALUES ('" + txtClave.getText() + "','" + txtNombre.getText() + "')";
                 Statement stmt = con.createStatement();
                 int rowsEffected = stmt.executeUpdate(strSQL);
                 JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");
                 
                 // Actualizar la tabla después de agregar una nueva columna
                 consultarTablaCategorias();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                String strSQL = "UPDATE tabla_categorias SET Nombre = '" + txtNombre.getText() + "' where ID = '"
                        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsAffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsAffected + " rows affected");

                // Actualizar la tabla después de modificar una categoría
                consultarTablaCategorias();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBorrar) {
            // Borrar una columna de la base de datos
            try {
                String strSQL = "DELETE from tabla_categorias where ID = '" + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");
                
                // Actualizar la tabla después de borrar una columna
                consultarTablaCategorias();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
                String SQL = "SELECT * FROM tabla_categorias where ID ='" + txtClave.getText() + "'"; // Texto de sentencia SQL (query)
                Statement stmt = con.createStatement(); // Declaración de variable y preparación de sentencia SQL
                ResultSet rs = stmt.executeQuery(SQL); // Declaración de variable para guardar resultados de sentencia
                                                        // SQL y ejecución

                // Limpia la tabla antes de agregar nuevos datos
                DefaultTableModel model = (DefaultTableModel) tablaSQLcategorias.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String id = rs.getString("ID");
                    String nombre = rs.getString("Nombre");

                    model.addRow(new Object[] { id, nombre });
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
    }
}
