import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class FrameFacturas extends FrameCategorias {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Connection con;
    private JButton btnBuscarPorEstadoPago;
    private JTextField txtRFC, txtTelefono, txtCorreo, txtDetalles, txtCantidad, txtImpuestos, txtSubtotal, txtTotal, txtMetodoPago, txtEstadoPago; // Variables de la clase y tabla
    private JTable tablaSQLclientes; // Agregamos una tabla para mostrar los datos de la sql table

    public FrameFacturas() {
        // Llama al constructor de la clase padre (FrameCategorias)
        super();
        setResizable(true);
        setTitle("Menu de Facturas : Kei Sushi");
        setBounds(100, 100, 560, 568);
        Container c;
        c = getContentPane();

        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=POO-Integradora;user=amaral;password=amaral;encrypt=false";
            con = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al conectarse a la BD: " + e.toString());
        }
        
        // Agrego nuevos componentes de interfaz de usuario
        btnBuscarPorEstadoPago = new JButton("Buscar por estado de pago");
        btnBuscarPorEstadoPago.setFont(new Font("Poppins", Font.PLAIN, 12));
        btnBuscarPorEstadoPago.addActionListener(this);

        // Crear componentes de la interfaz de usuario
        JLabel lblRFC = new JLabel(" RFC");
        lblRFC.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblTelefono = new JLabel(" Telefono");
        lblTelefono.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblCorreo = new JLabel(" Correo");
        lblCorreo.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblDetalles = new JLabel(" Detalles");
        lblDetalles.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblCantidad = new JLabel(" Cantidad");
        lblCantidad.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblImpuestos = new JLabel(" Impuestos");
        lblImpuestos.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblSubtotal = new JLabel(" Subtotal");
        lblSubtotal.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblTotal = new JLabel(" Total");
        lblTotal.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblMetodoPago = new JLabel(" Método de pago");
        lblMetodoPago.setFont(new Font("Poppins", Font.PLAIN, 12));
        JLabel lblEstadoPago = new JLabel(" Estado del pago");
        lblEstadoPago.setFont(new Font("Poppins", Font.PLAIN, 12));

        
        txtRFC = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        txtDetalles = new JTextField();
        txtCantidad = new JTextField();
        txtImpuestos = new JTextField();
        txtSubtotal = new JTextField();
        txtTotal = new JTextField();
        txtMetodoPago = new JTextField();
        txtEstadoPago = new JTextField();


        // Agrega los nuevos componentes al panel correspondiente
        JPanel panelBotones = (JPanel) getContentPane().getComponent(1);
        panelBotones.add(btnBuscarPorEstadoPago);

        JPanel panelSuperior = (JPanel) getContentPane().getComponent(0);
        panelSuperior.add(lblRFC);
        panelSuperior.add(txtRFC);
        panelSuperior.add(lblTelefono);
        panelSuperior.add(txtTelefono);
        panelSuperior.add(lblCorreo);
        panelSuperior.add(txtCorreo);
        panelSuperior.add(lblDetalles);
        panelSuperior.add(txtDetalles);
        panelSuperior.add(lblCantidad);
        panelSuperior.add(txtCantidad);
        panelSuperior.add(lblImpuestos);
        panelSuperior.add(txtImpuestos);
        panelSuperior.add(lblSubtotal);
        panelSuperior.add(txtSubtotal);
        panelSuperior.add(lblTotal);
        panelSuperior.add(txtTotal);
        panelSuperior.add(lblMetodoPago);
        panelSuperior.add(txtMetodoPago);
        panelSuperior.add(lblEstadoPago);
        panelSuperior.add(txtEstadoPago);

        // Agrego una JTable al formulario para ver como actua con SQL Server
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaSQLclientes = new JTable(modeloTabla);
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("RFC"); // Agregamos la columna de teléfono
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("Detalles");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Impuestos");
        modeloTabla.addColumn("Subtotal");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Metodo de pago");
        modeloTabla.addColumn("Estado de pago");
        
        JScrollPane scrollPane = new JScrollPane(tablaSQLclientes);
        c.add(scrollPane, BorderLayout.CENTER);

        /*
         * Agregar el evento WindowOpened a la 
         * ventana para que la muestre cuando abra 
         * el formulario y siempre este cargada
         */
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
            	consultarTablaFacturas(); // Obtener y mostrar los datos al abrir la ventana
            }
        });
    }
    
    /*
     * Sobrecarga del método de consultar la tabla
     */
    // Método sobrecargado para consultar la tabla de clientes sin parámetros
    private void consultarTablaFacturas() { // Método sin párametros
        try {
            String SQL = "SELECT * FROM tabla_facturas";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idEmpleado = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String rfc = rs.getString("RFC");
                String telefono = rs.getString("Telefono");
                String correo = rs.getString("Correo");
                String detalles = rs.getString("Detalles");
                String cantidad = rs.getString("Cantidad");
                String impuestos = rs.getString("Impuestos");
                String subtotal = rs.getString("Subtotal");
                String total = rs.getString("Total");
                String metodoPago = rs.getString("MetodoPago");
                String estadoPago = rs.getString("EstadoPago");

                model.addRow(new Object[] { idEmpleado, nombre, rfc, telefono, correo, detalles, cantidad, impuestos, subtotal, total, metodoPago, estadoPago});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la BD: " + ex.toString());
        }
    }

    // Método sobrecargado para consultar la tabla de clientes con un parámetro de búsqueda
    private void consultarTablaFacturas(String EstadoPago) { // Parámetro de búsqueda por número de teléfono
        try {
            String SQL = "SELECT * FROM tabla_facturas WHERE EstadoPago LIKE '%" + EstadoPago + "%'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String idEmpleado = rs.getString("ID");
                String nombre = rs.getString("Nombre");
                String rfc = rs.getString("RFC");
                String telefono = rs.getString("Telefono");
                String correo = rs.getString("Correo");
                String detalles = rs.getString("Detalles");
                String cantidad = rs.getString("Cantidad");
                String impuestos = rs.getString("Impuestos");
                String subtotal = rs.getString("Subtotal");
                String total = rs.getString("Total");
                String metodoPago = rs.getString("MetodoPago");
                String estadoPago = rs.getString("EstadoPago");

                model.addRow(new Object[] { idEmpleado, nombre, rfc, telefono, correo, detalles, cantidad, impuestos, subtotal, total, metodoPago, estadoPago});
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
                String strSQL = "INSERT INTO tabla_facturas (ID,Nombre,RFC,Telefono,Correo,Detalles,Cantidad,Impuestos,Subtotal,Total,MetodoPago,EstadoPago) VALUES ('"
                        + txtClave.getText() + "','" + txtNombre.getText() + "','" + txtRFC.getText() + "','"
                        + txtTelefono.getText() + "','" + txtCorreo.getText() + "','" + txtDetalles.getText() + "','"
                        + txtCantidad.getText() + "','" + txtImpuestos.getText() + "','" + txtSubtotal.getText() + "','"
                        + txtTotal.getText() + "','" + txtMetodoPago.getText() + "','" + txtEstadoPago.getText() +"') ";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de agregar una nueva columna
                consultarTablaFacturas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                String strSQL = "UPDATE tabla_facturas SET Nombre = '" + txtNombre.getText() + "', RFC = '"
                        + txtRFC.getText() + "', Telefono = '" + txtTelefono.getText() + "', Correo = '" + txtCorreo.getText()
                        + "', Detalles = '" + txtDetalles.getText() + "', Cantidad = '" + txtImpuestos.getText() + "', Subtotal = '" + txtSubtotal.getText()
                        + "', Total = '" + txtTotal.getText() + "', MetodoPago = '" + txtMetodoPago.getText() + "',  EstadoPago = '" + txtEstadoPago.getText()
                        + "'where ID = '"
                        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de modificar un cliente
                consultarTablaFacturas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBorrar) {
            try {
                String strSQL = "DELETE FROM tabla_facturas WHERE ID = '" + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");

                // Actualizar la tabla después de borrar un cliente
                consultarTablaFacturas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
                String idBuscador = txtClave.getText();
                String SQL = "SELECT * FROM tabla_facturas WHERE ID LIKE '%" + idBuscador + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);

                DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String idEmpleado = rs.getString("ID");
                    String nombre = rs.getString("Nombre");
                    String rfc = rs.getString("RFC");
                    String telefono = rs.getString("Telefono");
                    String correo = rs.getString("Correo");
                    String detalles = rs.getString("Detalles");
                    String cantidad = rs.getString("Cantidad");
                    String impuestos = rs.getString("Impuestos");
                    String subtotal = rs.getString("Subtotal");
                    String total = rs.getString("Total");
                    String metodoPago = rs.getString("MetodoPago");
                    String estadoPago = rs.getString("EstadoPago");

                    model.addRow(new Object[] { idEmpleado, nombre, rfc, telefono, correo, detalles, cantidad, impuestos, subtotal, total, metodoPago, estadoPago});
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnBuscarPorEstadoPago) {

        	String EstadoPago = txtEstadoPago.getText();
        	consultarTablaFacturas(EstadoPago);
        	
        }
    }
}
