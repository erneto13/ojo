import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class clientes extends tipoPescados {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Connection con;
    // private JButton btnBuscarPorCiudad;
    private JTextField txtTelefono, txtPedidoPescado;
    private JTable tablaSQLclientes; // Agregamos una tabla para mostrar los datos de la sql table

    public clientes() {
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
        
        /*  Agrego nuevos componentes de interfaz de usuario
        btnBuscarPorCiudad = new JButton("Buscar por ciudad");
        btnBuscarPorCiudad.setFont(new Font("Arial", Font.PLAIN, 12));
        btnBuscarPorCiudad.addActionListener(this);
*/
        
        // Crear componentes de la interfaz de usuario
        JLabel Telefono = new JLabel(" Telefono");
        Telefono.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel PedidoPescado = new JLabel(" PedidoPescado");
        Telefono.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel rellenar = new JLabel("");
        rellenar.setFont(new Font("Arial", Font.PLAIN, 12));
        
        txtTelefono = new JTextField();
        txtPedidoPescado = new JTextField();
        
        JPanel panelSuperior = (JPanel) getContentPane().getComponent(0);
        panelSuperior.add(Telefono);
        panelSuperior.add(txtTelefono);
        panelSuperior.add(PedidoPescado);
        panelSuperior.add(txtPedidoPescado);
        panelSuperior.add(rellenar);

   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            try {
                String strSQL = "INSERT INTO tabla_clientes (ID,Nombre,Telefono,PedidoPescado) VALUES ('"
                        + txtClave.getText() + "','" + txtNombre.getText() + "','" + txtTelefono.getText() + "','"
                        + txtPedidoPescado.getText() + "') ";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnModificar) {
            try {
                String strSQL = "UPDATE tabla_clientes SET Nombre = '" + txtNombre.getText() + "', Telefono = '"
                        + txtTelefono.getText() + "', PedidoPescado = '" + txtPedidoPescado.getText() 
                        + "'ID = '"
                        + txtClave.getText() + "'";
                Statement stmt = con.createStatement();
                int rowsEffected = stmt.executeUpdate(strSQL);
                JOptionPane.showMessageDialog(null, rowsEffected + " rows affected");
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
        if (e.getSource() == btnConsultar) {
            try {
                String id = txtClave.getText();
                String SQL = "SELECT * FROM tabla_clientes WHERE ID LIKE '%" + id + "%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);

                DefaultTableModel model = (DefaultTableModel) tablaSQLclientes.getModel();
                model.setRowCount(0);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse con la bd: " + ex.toString());
            }
        }
    }
}
