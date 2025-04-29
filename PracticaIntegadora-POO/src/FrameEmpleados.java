import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class FrameEmpleados extends FrameCategorias {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Connection con;
    private JButton btnMarcar;
    private JTextField txtRFC, txtTelefono, txtDomicilio, txtPuesto, txtFechaIngreso;
    private JTable tablaSQLclientes; // Agregamos una tabla para mostrar los datos de la sql table

    public FrameEmpleados() {
        // Llama al constructor de la clase padre (FrameCategorias)
        super();
        setResizable(false);
        setBounds(100, 100, 812, 568);
        Container c;
        c = getContentPane();

        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=POO-Integradora;user=amaral;password=amaral;encrypt=false";
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al conectarse a la BD: " + e.toString());
        }
        
        // Agrego nuevos componentes de interfaz de usuario
        btnMarcar = new JButton("Buscar por puesto");
        btnMarcar.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnMarcar.addActionListener(this);

        // Crear componentes de la interfaz de usuario
        JLabel lblRFC = new JLabel(" RFC");
        lblRFC.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblTelefono = new JLabel(" Telefono");
        lblTelefono.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblDomicilio = new JLabel(" Domicilio");
        lblDomicilio.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblPuesto = new JLabel(" Puesto");
        lblPuesto.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblFechaIngreso = new JLabel(" Ingreso");
        lblFechaIngreso.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblRelleno = new JLabel(" ");
        lblFechaIngreso.setFont(new Font("Poppins", Font.PLAIN, 12));
        
        txtRFC = new JTextField();
        txtTelefono = new JTextField();
        txtDomicilio = new JTextField();
        txtPuesto = new JTextField();
        txtFechaIngreso = new JTextField();

        // Agrega los nuevos componentes al panel correspondiente
        JPanel panelBotones = (JPanel) getContentPane().getComponent(1);
        panelBotones.add(btnMarcar);

        JPanel panelSuperior = (JPanel) getContentPane().getComponent(0);
        panelSuperior.add(lblRFC);
        panelSuperior.add(txtRFC);
        panelSuperior.add(lblTelefono);
        panelSuperior.add(txtTelefono);
        panelSuperior.add(lblDomicilio);
        panelSuperior.add(txtDomicilio);
        panelSuperior.add(lblPuesto);
        panelSuperior.add(txtPuesto);
        panelSuperior.add(lblFechaIngreso);
        panelSuperior.add(txtFechaIngreso);
        panelSuperior.add(lblRelleno);

        // Agrego una JTable al formulario para ver como actua con SQL Server
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaSQLclientes = new JTable(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("RFC"); // Agregamos la columna de teléfono
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Domicilio");
        modeloTabla.addColumn("Puesto");
        modeloTabla.addColumn("Ingreso");
        JScrollPane scrollPane = new JScrollPane(tablaSQLclientes);
        c.add(scrollPane, BorderLayout.CENTER);

        /*
         * Agregar el evento WindowOpened a la 
         * ventana para que la muestre cuando abra 
         * el formulario y siempre este cargada
         */
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
            	consultarTablaEmpleados(); // Obtener y mostrar los datos al abrir la ventana
            }
        });
    }
    
    /*
     * Sobrecarga del método de consultar la tabla
     */
    // Método sobrecargado para consultar la tabla de clientes sin parámetros
    private void consultarTablaEmpleados() { // Método sin párametros
        try {
            String SQL = "SELECT * FROM tabla_empleados";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idEmpleado = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String rfc = rs.getString("RFC");
                String telefono = rs.getString("Telefono");
                String domicilio = rs.getString("Domicilio");
                String puesto = rs.getString("Puesto");
                String fechaIngreso = rs.getString("Ingreso");

                model.addRow(new Object[] { idEmpleado, nombre, rfc, telefono, domicilio, puesto, fechaIngreso });
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la BD: " + ex.toString());
        }
    }

    // Método sobrecargado para consultar la tabla de clientes con un parámetro de búsqueda
    private void consultarTablaEmpleados(String Puesto) { // Parámetro de búsqueda por número de teléfono
        try {
            String SQL = "SELECT * FROM tabla_empleados WHERE Puesto LIKE '%" + Puesto + "%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idEmpleado = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String rfc = rs.getString("RFC");
                String telefono = rs.getString("Telefono");
                String domicilio = rs.getString("Domicilio");
                String puesto = rs.getString("Puesto");
                String fechaIngreso = rs.getString("Ingreso");

                model.addRow(new Object[] { idEmpleado, nombre, rfc, telefono, domicilio, puesto, fechaIngreso });
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
                String strSQL = "INSERT INTO tabla_empleados (ID,Nombre,RFC,Telefono,Domicilio,Puesto,Ingreso) VALUES ('"
                        + txtClave.getText() + "','" + txtNombre.getText() + "','" + txtRFC.getText() + "','"
                        + txtTelefono.getText() + "','" + txtDomicilio.getText() + "','" + txtPuesto.getText() + "','" + txtFechaIngreso.getText() + "') ";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de agregar una nueva columna
                consultarTablaEmpleados();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
            	String strSQL = "UPDATE tabla_empleados SET Nombre = '" + txtNombre.getText() + "', RFC = '"
            	        + txtRFC.getText() + "', Telefono = '" + txtTelefono.getText() + "', Domicilio = '"
            	        + txtDomicilio.getText() + "', Puesto = '" + txtPuesto.getText() + "', Ingreso = '" 
            	        + txtFechaIngreso.getText() 
            	        + "' WHERE ID = '"
            	        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de modificar un cliente
                consultarTablaEmpleados();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBorrar) {
            try {
                String strSQL = "DELETE FROM tabla_empleados WHERE ID = '" + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de borrar un cliente
                consultarTablaEmpleados();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
                String idBuscador = txtClave.getText();
                String SQL = "SELECT * FROM tabla_empleados WHERE ID LIKE '%" + idBuscador + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);

                DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String idEmpleado = rs.getString("ID");
                    String nombre = rs.getString("Nombre");
                    String rfc = rs.getString("RFC");
                    String telefonoEmpleado = rs.getString("Telefono");
                    String domicilio = rs.getString("Domicilio");
                    String puesto = rs.getString("Puesto");
                    String ingreso = rs.getString("Ingreso");

                    model.addRow(new Object[] { idEmpleado, nombre, rfc, telefonoEmpleado, domicilio, puesto, ingreso });
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnMarcar) {
        	String Puesto = txtPuesto.getText();
        	consultarTablaEmpleados(Puesto);
        }
    }
}
