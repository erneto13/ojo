import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class FrameProveedores extends FrameCategorias {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Connection con;
    private JButton btnBuscarPorCiudad;
    private JTextField txtDireccion, txtCiudad, txtEmail, txtTelefono, txtTipoProveedor, txtRegistro;
    private JTable tablaSQLclientes; // Agregamos una tabla para mostrar los datos de la sql table

    public FrameProveedores() {
        // Llama al constructor de la clase padre (FrameCategorias)
        super();
        setResizable(true);
        setTitle("Menu de Proveedores : Kei Sushi");
        setBounds(100, 100, 1012, 568);
        Container c;
        c = getContentPane();

        
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=POO-Integradora;user=amaral;password=amaral;encrypt=false";
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al conectarse a la BD: " + e.toString());
        }
        
        // Agrego nuevos componentes de interfaz de usuario
        btnBuscarPorCiudad = new JButton("Buscar por ciudad");
        btnBuscarPorCiudad.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnBuscarPorCiudad.addActionListener(this);

        // Crear componentes de la interfaz de usuario
        JLabel lblDireccion = new JLabel(" Dirección");
        lblDireccion.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblCiudad = new JLabel(" Ciudad");
        lblCiudad.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblEmail = new JLabel(" Correo");
        lblEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblTelefono = new JLabel(" Telefono");
        lblTelefono.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblTipoProveedor = new JLabel(" Tipo de proveedor");
        lblTipoProveedor.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblRegistro = new JLabel(" Fecha de registro");
        lblRegistro.setFont(new Font("Poppins", Font.PLAIN, 12));
        
        txtDireccion = new JTextField();
        txtCiudad = new JTextField();
        txtEmail = new JTextField();
        txtTelefono = new JTextField();
        txtTipoProveedor = new JTextField();
        txtRegistro = new JTextField();

        // Agrega los nuevos componentes al panel correspondiente
        JPanel panelBotones = (JPanel) getContentPane().getComponent(1);
        panelBotones.add(btnBuscarPorCiudad);

        JPanel panelSuperior = (JPanel) getContentPane().getComponent(0);
        panelSuperior.add(lblDireccion);
        panelSuperior.add(txtDireccion);
        panelSuperior.add(lblCiudad);
        panelSuperior.add(txtCiudad);
        panelSuperior.add(lblEmail);
        panelSuperior.add(txtEmail);
        panelSuperior.add(lblTelefono);
        panelSuperior.add(txtTelefono);
        panelSuperior.add(lblTipoProveedor);
        panelSuperior.add(txtTipoProveedor);
        panelSuperior.add(lblRegistro);
        panelSuperior.add(txtRegistro);

        // Agrego una JTable al formulario para ver como actua con SQL Server
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaSQLclientes = new JTable(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Direccion"); // Agregamos la columna de teléfono
        modeloTabla.addColumn("Ciudad");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Tipo de proveedor");
        modeloTabla.addColumn("Registro");
        JScrollPane scrollPane = new JScrollPane(tablaSQLclientes);
        c.add(scrollPane, BorderLayout.CENTER);

        /*
         * Agregar el evento WindowOpened a la 
         * ventana para que la muestre cuando abra 
         * el formulario y siempre este cargada
         */
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
            	consultarTablaProveedores(); // Obtener y mostrar los datos al abrir la ventana
            }
        });
    }
    
    /*
     * Sobrecarga del método de consultar la tabla
     */
    // Método sobrecargado para consultar la tabla de clientes sin parámetros
    private void consultarTablaProveedores() { // Método sin párametros
        try {
            String SQL = "SELECT * FROM tabla_proveedores";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idEmpleado = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String direccion = rs.getString("Direccion");
                String ciudad = rs.getString("Ciudad");
                String email = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String tipoProveedor = rs.getString("TipoProveedor");
                String fechaRegistro = rs.getString("Registro");

                model.addRow(new Object[] { idEmpleado, nombre, direccion, ciudad, email, telefono, tipoProveedor, fechaRegistro});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la BD: " + ex.toString());
        }
    }

    // Método sobrecargado para consultar la tabla de clientes con un parámetro de búsqueda
    private void consultarTablaProveedores(String Ciudad) { // Parámetro de búsqueda por número de teléfono
        try {
            String SQL = "SELECT * FROM tabla_proveedores WHERE Ciudad LIKE '%" + Ciudad + "%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idEmpleado = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String direccion = rs.getString("Direccion");
                String ciudad = rs.getString("Ciudad");
                String email = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String tipoProveedor = rs.getString("TipoProveedor");
                String fechaRegistro = rs.getString("Registro");

                model.addRow(new Object[] { idEmpleado, nombre, direccion, ciudad, email, telefono, tipoProveedor, fechaRegistro});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
        }
    }
    
    

    // Sobrescribe el método actionPerformed para agregar funcionalidad a los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            try {
                String strSQL = "INSERT INTO tabla_proveedores (ID,Nombre,Direccion,Ciudad,Correo,Telefono,TipoProveedor,Registro) VALUES ('"
                        + txtClave.getText() + "','" + txtNombre.getText() + "','" + txtDireccion.getText() + "','"
                        + txtCiudad.getText() + "','" + txtEmail.getText() + "','" + txtTelefono.getText() + "','" + txtTipoProveedor.getText() + "','" + txtRegistro.getText() + "') ";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de agregar una nueva columna
                consultarTablaProveedores();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                String strSQL = "UPDATE tabla_proveedores SET Nombre = '" + txtNombre.getText() + "', Direccion = '"
                        + txtDireccion.getText() + "', Ciudad = '" + txtCiudad.getText() + "', Correo = '"
                        + txtEmail.getText() + "', Telefono = '" + txtTelefono.getText() + "', TipoProveedor = '" 
                        + txtTipoProveedor.getText() + "', Registro = '" + txtRegistro.getText()
                        + "'ID = '"
                        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de modificar un cliente
                consultarTablaProveedores();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBorrar) {
            try {
                String strSQL = "DELETE FROM tabla_proveedores WHERE ID = '" + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de borrar un cliente
                consultarTablaProveedores();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
                String idBuscador = txtClave.getText();
                String SQL = "SELECT * FROM tabla_proveedores WHERE ID LIKE '%" + idBuscador + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);

                DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String idEmpleado = rs.getString("ID");
                    String nombre = rs.getString("Nombre");
                    String direccion = rs.getString("Direccion");
                    String ciudad = rs.getString("Ciudad");
                    String email = rs.getString("Correo");
                    String telefono = rs.getString("Telefono");
                    String tipoProveedor = rs.getString("TipoProveedor");
                    String fechaRegistro = rs.getString("Registro");

                    model.addRow(new Object[] { idEmpleado, nombre, direccion, ciudad, email, telefono, tipoProveedor, fechaRegistro});
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBuscarPorCiudad) {
            String Ciudad = txtCiudad.getText();
            consultarTablaProveedores(Ciudad);
        }
    }
}
