package jdbc_ejemplo1;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class abc_limpio extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
    JButton btnAgregar, btnModificar, btnBorrar, btnConsultar;
    JTextField txtClave, txtNombre;

    //CONSTRUCTOR DEL FORMULARIO (CONSTRUCTOR ES "SINONIMO" DE INICIALIZACI�N)
    //INICIALIZAR EL FORMULARIO (CREANDO BOTONES, TEXTBOXES, ETC..)
    public abc_limpio()
    {
        Container c;
        JPanel panelSuperior = new JPanel();
        JPanel panelBotones = new JPanel();

        //ABRIR CONEXI�N CON BASE DE DATOS (INICIALIZACI�N DE CONEXI�N CON BD)
        try {
            //Crea la conexi�n con la base de datos
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ABCJava;user=amaral;password=amaral;encrypt=false"; //Crea la cadena de conexión
            con = DriverManager.getConnection(connectionUrl); //Abre la conexi�n
            JOptionPane.showMessageDialog(null,"La conexi�n se llevo a cabo con �xito :P");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al conectarse con la bd: "+ e.toString());
        } 

        //ESTABLECER LAYOUT Y CREAR BOTONES (INICIALIZACI�N DE INTERFAZ DE USUARIO)
        
        c = getContentPane();
        BorderLayout bl = new BorderLayout();
        c.setLayout(bl);                          //Layout del formulario
        
        c.add(panelSuperior, BorderLayout.NORTH);
        c.add(panelBotones, BorderLayout.SOUTH);

        GridLayout gl = new GridLayout(2,2);
        panelSuperior.setLayout(gl);              //Layout del panel superior

        FlowLayout fl = new FlowLayout();
        panelBotones.setLayout(fl);               //Layout del panel botones

        //Crear componentes de la interfaz de usuario
        JLabel lblClave = new JLabel("Clave");
        JLabel lblNombre = new JLabel("Nombre");

        txtClave = new JTextField();
        txtNombre = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this); // btnAgregar.addActionListener(new MiClase());
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(this);
        btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(this);
        btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(this);

        //Agregando componentes de interfaz de usuario
        panelSuperior.add(lblClave); panelSuperior.add(txtClave);
        panelSuperior.add(lblNombre); panelSuperior.add(txtNombre);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnConsultar);

    }

    //M�todo que se dispara al hacer click sobre cualquier bot�n en formulario
    //(porqu� el formulario implementa la interfaz ActionListener)
    public void actionPerformed(ActionEvent e) 
    {

//        JOptionPane.showMessageDialog(null,"Adios");

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
        if (e.getSource() == btnBorrar) //Lo mismo que el anterior
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

}


