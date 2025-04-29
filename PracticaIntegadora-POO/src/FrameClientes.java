import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class FrameClientes extends FrameCategorias {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Connection con;
    private JButton btnConsultarTelefono;
    private JTextField txtTelefono, txtColonia, txtCalle, txtCP;
    private JTable tablaSQLclientes; // Agregamos una tabla para mostrar los datos de la sql table

    public FrameClientes() {
        // Llama al constructor de la clase padre (FrameCategorias)
        super();
        setResizable(true);
        setBounds(100, 100, 812, 568);
        Container c;
        c = getContentPane();
        
        /*
         * Conexión a la base de datos
         */        
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=POO-Integradora;user=amaral;password=amaral;encrypt=false";
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al conectarse a la BD: " + e.toString());
        }

        // Agrego nuevos componentes de interfaz de usuario
        btnConsultarTelefono = new JButton("Consultar por número de teléfono");
        btnConsultarTelefono.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnConsultarTelefono.addActionListener(this);

        // Crear componentes de la interfaz de usuario
        JLabel lblTelefono = new JLabel(" Telefono");
        lblTelefono.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblColonia = new JLabel(" Colonia");
        lblColonia.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblCalle = new JLabel(" Calle");
        lblCalle.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblCP = new JLabel(" CP");
        lblCP.setFont(new Font("Poppins", Font.PLAIN, 12));

        txtTelefono = new JTextField();
        txtColonia = new JTextField();
        txtCalle = new JTextField();
        txtCP = new JTextField();

        // Agrega los nuevos componentes al panel correspondiente
        JPanel panelBotones = (JPanel) getContentPane().getComponent(1);
        panelBotones.add(btnConsultarTelefono);

        JPanel panelSuperior = (JPanel) getContentPane().getComponent(0);
        panelSuperior.add(lblTelefono);
        panelSuperior.add(txtTelefono);
        panelSuperior.add(lblColonia);
        panelSuperior.add(txtColonia);
        panelSuperior.add(lblCalle);
        panelSuperior.add(txtCalle);
        panelSuperior.add(lblCP);
        panelSuperior.add(txtCP);

        // Agregar JTable al formulario
        DefaultTableModel model = new DefaultTableModel();
        tablaSQLclientes = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Telefono"); // Agregamos la columna de teléfono
        model.addColumn("Colonia");
        model.addColumn("Calle");
        model.addColumn("CP");
        JScrollPane scrollPane = new JScrollPane(tablaSQLclientes);
        c.add(scrollPane, BorderLayout.CENTER);

        // Agregar el evento WindowOpened a la ventana
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                consultarTablaClientes(); // Obtener y mostrar los datos al abrir la ventana
            }
        });
    }
    
    /*
     * Sobrecarga del método de consultar la tabla
     */
    // Método sobrecargado para consultar la tabla de clientes sin parámetros
    private void consultarTablaClientes() { // Método sin párametros
        try {
            String SQL = "SELECT * FROM tabla_clientes";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idCliente = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String telefono = rs.getString("Telefono");
                String colonia = rs.getString("Colonia");
                String calle = rs.getString("Calle");
                String cp = rs.getString("CP");

                model.addRow(new Object[] { idCliente, nombre, telefono, colonia, calle, cp });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la BD: " + ex.toString());
        }
    }

    // Método sobrecargado para consultar la tabla de clientes con un parámetro de búsqueda
    private void consultarTablaClientes(String telefono) { // Parámetro de búsqueda por número de teléfono
        try {
            String SQL = "SELECT * FROM tabla_clientes WHERE Telefono LIKE '%" + telefono + "%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idCliente = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String telefonoCliente = rs.getString("Telefono");
                String colonia = rs.getString("Colonia");
                String calle = rs.getString("Calle");
                String cp = rs.getString("CP");

                model.addRow(new Object[]{idCliente, nombre, telefonoCliente, colonia, calle, cp});
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
                String strSQL = "INSERT INTO tabla_clientes (ID,Nombre,Telefono,Colonia,Calle,CP) VALUES ('"
                        + txtClave.getText() + "','" + txtNombre.getText() + "','" + txtTelefono.getText() + "','"
                        + txtColonia.getText() + "','" + txtCalle.getText() + "','" + txtCP.getText() + "') ";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de agregar una nueva columna
                consultarTablaClientes();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                String strSQL = "UPDATE tabla_clientes SET Nombre = '" + txtNombre.getText() + "', Telefono = '"
                        + txtTelefono.getText() + "', Colonia = '" + txtColonia.getText() + "', Calle = '"
                        + txtCalle.getText() + "', CP = '" + txtCP.getText() + "' WHERE ID = '"
                        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de modificar un cliente
                consultarTablaClientes();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBorrar) {
            try {
                String strSQL = "DELETE FROM tabla_clientes WHERE ID = '" + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de borrar un cliente
                consultarTablaClientes();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
                String idBuscador = txtClave.getText();
                String SQL = "SELECT * FROM tabla_clientes WHERE ID LIKE '%" + idBuscador + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);

                DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String idCliente = rs.getString("ID");
                    String nombre = rs.getString("Nombre");
                    String telefonoCliente = rs.getString("Telefono");
                    String colonia = rs.getString("Colonia");
                    String calle = rs.getString("Calle");
                    String cp = rs.getString("CP");

                    model.addRow(new Object[] { idCliente, nombre, telefonoCliente, colonia, calle, cp });
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultarTelefono) {
            // Llamada al método sobrecargado para consultar la tabla de clientes con un parámetro de búsqueda
            String telefono = txtTelefono.getText();
            consultarTablaClientes(telefono);
        }
    }
}
