package redes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class AppSubneteo extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtDireccionIP;
    private JLabel lblDireccionIP;
    private JLabel lblClaseIP;
    private JTextField tboxClaseIP;
    private JTextField txtHostsC;
    private JTextField tboxRango;
    private JTextField txtSubredesTeoricas;
    private JTextField txtSubredesPracticos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppSubneteo frame = new AppSubneteo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AppSubneteo() {
    	setTitle("Software de Subneteo");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Pictures\\amlopelon.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 449, 503);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblIngresarIP = new JLabel("Ingrese la dirección IP:");
        lblIngresarIP.setBounds(10, 79, 143, 14);
        lblIngresarIP.setFont(new Font("Poppins", Font.PLAIN, 12));
        contentPane.add(lblIngresarIP);

        txtDireccionIP = new JTextField();
        txtDireccionIP.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtDireccionIP.setBounds(145, 76, 109, 20);
        contentPane.add(txtDireccionIP);
        txtDireccionIP.setColumns(10);
        
        final JLabel txtMascara = new JLabel("Máscara:");
        txtMascara.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtMascara.setBounds(10, 217, 57, 14);
        contentPane.add(txtMascara);
        
        final JTextField tboxSubredes = new JTextField();
        tboxSubredes.setEnabled(false);
        tboxSubredes.setFont(new Font("Poppins", Font.PLAIN, 12));
        tboxSubredes.setColumns(10);
        tboxSubredes.setBounds(197, 120, 78, 20);
        contentPane.add(tboxSubredes);
        
        JLabel txtSubredesTeoricos = new JLabel("Teoricos:");
        txtSubredesTeoricos.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtSubredesTeoricos.setBounds(10, 276, 57, 14);
        contentPane.add(txtSubredesTeoricos);
        
        JLabel lblPrcticos = new JLabel("Prácticos:");
        lblPrcticos.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblPrcticos.setBounds(10, 301, 57, 14);
        contentPane.add(lblPrcticos);
        
        JLabel txtHostSubredesTeoricos = new JLabel("Teoricos:");
        txtHostSubredesTeoricos.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtHostSubredesTeoricos.setBounds(205, 276, 218, 14);
        contentPane.add(txtHostSubredesTeoricos);
        
        JLabel txtHostSubredesPracticos = new JLabel("Prácticos:");
        txtHostSubredesPracticos.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtHostSubredesPracticos.setBounds(205, 301, 218, 14);
        contentPane.add(txtHostSubredesPracticos);
        
        tboxClaseIP = new JTextField();
        tboxClaseIP.setEditable(false);
        tboxClaseIP.setFont(new Font("Poppins", Font.PLAIN, 12));
        tboxClaseIP.setBounds(80, 180, 15, 20);
        contentPane.add(tboxClaseIP);
        tboxClaseIP.setColumns(10);
        
        JLabel txtMascara_1 = new JLabel("");
        txtMascara_1.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtMascara_1.setBounds(66, 217, 209, 14);
        contentPane.add(txtMascara_1);
        
        JLabel txtHosts = new JLabel("Ingrese el número de hosts:");
        txtHosts.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtHosts.setBounds(10, 148, 187, 14);
        contentPane.add(txtHosts);
        
        txtHostsC = new JTextField();
        txtHostsC.setEnabled(false);
        txtHostsC.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtHostsC.setColumns(10);
        txtHostsC.setBounds(176, 145, 78, 20);
        contentPane.add(txtHostsC);
        
        JLabel txtRango = new JLabel("Rango: ");
        txtRango.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtRango.setBounds(10, 326, 45, 14);
        contentPane.add(txtRango);
        
		txtSubredesTeoricas = new JTextField();
		txtSubredesTeoricas.setEditable(false);
		txtSubredesTeoricas.setBounds(67, 273, 86, 20);
		contentPane.add(txtSubredesTeoricas);
		txtSubredesTeoricas.setColumns(10);
		
		txtSubredesPracticos = new JTextField();
		txtSubredesPracticos.setEditable(false);
		txtSubredesPracticos.setColumns(10);
		txtSubredesPracticos.setBounds(71, 299, 86, 20);
		contentPane.add(txtSubredesPracticos);
        
        JLabel lblNuevaMascara = new JLabel("Nueva mascara: ");
        lblNuevaMascara.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblNuevaMascara.setBounds(10, 351, 244, 14);
        contentPane.add(lblNuevaMascara);
        
        // Botón responsable de establecer la dirección IP
        JButton btnSubredes = new JButton("");
        btnSubredes.setEnabled(false);
        btnSubredes.setBounds(284, 122, 16, 16);
        btnSubredes.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\360_F_305431718_eh07vqK6LRIjxixuTxATG5PFCQmGwNwQ (1).jpg.crdownload"));
        btnSubredes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
				//Esta acción limpia todos los campos que se ocuparon
				String comprobarCadenaVacia = txtDireccionIP.getText(); 
				String comprobarCadenaVaciaB = tboxSubredes.getText(); 
				
					if (comprobarCadenaVacia.isEmpty()) { //comprobar si el texto está vacío
						JOptionPane.showMessageDialog(null, "No se pudo completar la acción. Necesita rellenar el campo de la dirección IP y de subredes.", "", JOptionPane.ERROR_MESSAGE); // muestra un mensaje de error
					} else if (comprobarCadenaVaciaB.isEmpty()) {
						JOptionPane.showMessageDialog(null, "No se pudo completar la acción. Necesita rellenar el campo de las subredes.", "", JOptionPane.ERROR_MESSAGE); // muestra un mensaje de error
					} else {
						
		                // Obtener la dirección IP ingresada por el usuario
		                String direccionIP = txtDireccionIP.getText();

		                // Mostrar la dirección IP en el JLabel correspondiente
		                lblDireccionIP.setText("Dirección IP: " + direccionIP);

		                // Detectar la clase de la dirección IP
		                String claseIP = detectarClaseIP(direccionIP);

		                // Mostrar la clase de la dirección IP en el JLabel correspondiente
		                tboxClaseIP.setText(claseIP); 
		                
		                
		                /*
		                 * PROCEDO DE CREAR Y MOSTRAR LA MASCARA DE RED
		                 */
		                // Determinar la máscara de red según la clase de la dirección IP
		                
		                // Obtener la dirección IP del JTextField
		                String direccionIP2 = txtDireccionIP.getText();

		                // Obtener la clase de la dirección IP
		                int primerOcteto = Integer.parseInt(direccionIP2.split("\\.")[0]);

		                String mascaraDeRed;
		                
		                if (primerOcteto <= 127) {
		                    mascaraDeRed = "255.0.0.0";
		                } else if (primerOcteto >= 128 && primerOcteto <= 191) {
		                    mascaraDeRed = "255.255.0.0";
		                } else if (primerOcteto >= 192 && primerOcteto <= 223) {
		                    mascaraDeRed = "255.255.255.0";
		                } else {
		                	mascaraDeRed = "Imposible de obtener con esa clase";
		                }

		                // Establecer la máscara de red en el JLabel
		                txtMascara_1.setText(mascaraDeRed);
		                
		                /*
		                 * PROCESO PARA CREAR LAS SUBREDES TEORICAS Y PRACTICAS
		                 */
		                
		                // Para calcular las Subredes de parte Teorico y Practico
		                String cuantasSubredes = tboxSubredes.getText();
		                Integer cSubredes_double = Integer.parseInt(cuantasSubredes);

		                // Variable para almacenar el valor de la potencia de 2
		                int potencia = 0;

		                // Calculamos la potencia de 2 hasta que sea mayor o igual a la cantidad de subredes deseada
		                while (Math.pow(2, potencia) < cSubredes_double) {
		                    // Incrementamos la potencia para la siguiente iteración
		                    potencia++;
		                }
		               double numaux = 1;
		                numaux = (Math.pow(2, potencia));
		                if (numaux == cSubredes_double) {
		                	potencia = potencia+1;
		                }
		                
		                // Establecemos los valores en los labels
		                txtSubredesTeoricas.setText(""+(int)Math.pow(2, potencia));
		                txtSubredesPracticos.setText("" + ((int)Math.pow(2, potencia) - 2));
		                
		                //////////////////////////////////////////////////////////////////////////////////
		                
		                // Verificamos la clase de la red basada en la potencia
		                // Calculamos los bits prestados y los host restantes
		                /*String valorString = tboxClaseIP.getText();
		                int hostPorClase = Integer.parseInt(valorString); */

		               
		                if (primerOcteto <= 127) {
		                    // Clase A
		                    int bitsPrestados = potencia; 
		                    int hostRestante = (8 - potencia);

		                    double hostSubredPracticos = Math.pow(2, hostRestante);
		                    double hostSubredTeoricos = hostSubredPracticos - 2;
		                    
		                    // Formatear y mostrar el valor de hostSubredPracticos en la interfaz de usuario
		                    txtHostSubredesTeoricos.setText("Teóricos: " + String.format("%.0f", hostSubredPracticos));
		                    txtHostSubredesPracticos.setText("Prácticos: " + String.format("%.0f", hostSubredTeoricos));

		                    if (hostSubredPracticos > 256) {
		                        double rango = (hostSubredPracticos / 256);
		                        // Redondear y convertir el valor a entero
		                        int valorInt = (int) Math.round(rango);
		                        tboxRango.setText("" + valorInt);
		                    } else {
		                        double rango = (256 / hostSubredPracticos);
		                        // Redondear y convertir el valor a entero
		                        int valorInt = (int) Math.round(rango);
		                        tboxRango.setText("" + valorInt);
		                    }
					      
		                } else if (primerOcteto <= 191) {
		                    // Clase B		                	
			                int bitsPrestados = potencia; 
			                int hostRestante = 16 - potencia;
		                	
		                    double hostSubredPracticos = Math.pow(2, hostRestante);
		                    double hostSubredTeoricos = hostSubredPracticos - 2;
		                    txtHostSubredesTeoricos.setText("Teóricos: " + hostSubredPracticos);
		                    txtHostSubredesPracticos.setText("Prácticos: " + hostSubredTeoricos);
		                    
		                    if (hostSubredPracticos > 256) {
						        Double rango = (hostSubredPracticos/256);

						        // Convierte el valor double a int utilizando el método intValue()
						        int valorInt = Double.valueOf(rango).intValue();
						     
						        tboxRango.setText(""+valorInt);
		                    } else {
						        Double rango = (256/hostSubredPracticos);

						        // Convierte el valor double a int utilizando el método intValue()
						        int valorInt = Double.valueOf(rango).intValue();
						     
						        tboxRango.setText(""+valorInt);
		                    }
					      
		                } else if (primerOcteto <= 222) {
		                    // Clase C		                	
			                int bitsPrestados = potencia; 
			                int hostRestante =  8 - potencia;
		                	
		                    double hostSubredPracticos = Math.pow(2, hostRestante);
		                    double hostSubredTeoricos = hostSubredPracticos - 2;
		                    txtHostSubredesTeoricos.setText("Teóricos: " + hostSubredPracticos);
		                    txtHostSubredesPracticos.setText("Prácticos: " + hostSubredTeoricos);
		                    
		                    if (hostSubredPracticos > 256) {
						        Double rango = (hostSubredPracticos/256);

						        // Convierte el valor double a int utilizando el método intValue()
						        int valorInt = Double.valueOf(rango).intValue();
						     
						        tboxRango.setText(""+valorInt);
		                    } else {
						        Double rango = (256/hostSubredPracticos);

						        // Convierte el valor double a int utilizando el método intValue()
						        int valorInt = Double.valueOf(rango).intValue();
						     
						        tboxRango.setText(""+valorInt);
		                    }
					      
		                } else {
		                    // Otros casos
		                    txtHostSubredesTeoricos.setText("Teóricos: -");
		                    txtHostSubredesPracticos.setText("Prácticos: -");
		                }
		                
		                
		        		/*
		        		 * BLOQUE DE CÓDIGO PARA GENERAR LOS RANGOS ENTRE LAS SUBREDES
		        		 */

		        		String direccionIP1 = txtDireccionIP.getText(); // Obtener la dirección IP del cuadro de texto
		        		String subredesCadena = tboxSubredes.getText(); // Obtener las subredes que se necesitan
		        		int subredesNumero = Integer.parseInt(subredesCadena); // Obtengo de cadena a integer
		        		String cadenaPracticos = tboxSubredes.getText();
		        		int practicos = Integer.parseInt(cadenaPracticos);

		        		// Dividir la dirección IP en octetos usando el punto como delimitador
		        		String[] octetos = direccionIP1.split("\\.");

		        		if (octetos.length == 4) { // Verificar si se obtuvieron cuatro octetos
		        		    String octeto1 = octetos[0];
		        		    String octeto2 = octetos[1];
		        		    String octeto3 = octetos[2];
		        		    String octeto4 = octetos[3];

		        		    String cadenaRango = tboxRango.getText();
		        		    int valorInt1 = Integer.parseInt(cadenaRango);
		        		    
		        		    // Para la clase A (primer octeto entre 1 y 126)
		        		    if (Integer.parseInt(octeto1) >= 1 && Integer.parseInt(octeto1) <= 126) {
		        		        System.out.println("\nClase A | Direccion de Red: " + octeto1 + ".0.0.0\n");
		        		        int valorPostumo = valorInt1 + 1; // Iniciar valorPostumo con valorInt1 - 1

		        		        for (int i = 1; i < practicos; i++) {
		        		            System.out.println(i + ".- " + octeto1 + "." + (valorPostumo - 1) + octeto3 + ".0 hasta " + octeto1 + "." + ((valorPostumo - 1) - 1) + octeto3 + ".255 | ");
		        		            valorPostumo += valorInt1; // Acumular el valor de valorInt1 en valorPostumo
		        		        }
		        		        valorPostumo -= valorInt1;
		        		        lblNuevaMascara.setText("Nueva máscara: 255.255.255." + valorPostumo);
		        		      }

		        		    // Para la clase B (primer octeto entre 128 y 191)
		        		    else if (Integer.parseInt(octeto1) >= 128 && Integer.parseInt(octeto1) <= 191) {
		        		        System.out.println("\nClase B | Direccion de Red: " + octeto1 + "." + octeto2 + ".0.0\n");
		        		        int valorPostumo = valorInt1 + 1; // Iniciar valorPostumo con valorInt1 - 1

		        		        for (int i = 1; i < practicos; i++) {
		        		            System.out.println(i + ".- " + octeto1 + "." + octeto2 + "." + (valorPostumo - 1) + octeto4 + " hasta " + octeto1 + "." + octeto2 + "." + ((valorPostumo - 1) - 1) +  octeto4 + " | ");
		        		            valorPostumo += valorInt1; // Acumular el valor de valorInt1 en valorPostumo
		        		        }
		        		        valorPostumo -= valorInt1;
		        		        lblNuevaMascara.setText("Nueva máscara: 255.255.255." + valorPostumo);
		        		    }

		        		    // Para la clase C (primer octeto entre 192 y 223)
		        		    else if (Integer.parseInt(octeto1) >= 192 && Integer.parseInt(octeto1) <= 223) {
		        		        System.out.println("\nClase C | Direccion de Red: " + octeto1 + "." + octeto2 + "." + octeto3 + ".0\n");
		        		        int valorPostumo = valorInt1; // Iniciar valorPostumo con valorInt1

		        		        for (int i = 1; i < practicos; i++) {
		        		            System.out.println(i + ".- " + octeto1 + "." + octeto2 + "." + octeto3 +  "." + (valorPostumo - 1) + " -- " + octeto1 + "." + octeto2 + "." + octeto3 + "." + valorPostumo + " | ");
		        		            valorPostumo += valorInt1; // Restar el valor de valorInt1 en valorPostumo
		        		        }
		        		        valorPostumo -= valorInt1;
		        		        lblNuevaMascara.setText("Nueva máscara: 255.255.255." + valorPostumo);
		        		    

		        		      // Para otras clases de direcciones IP  
		        		    } else {
		        		        System.out.println("Dirección IP no válida. Verifica que pertenezca a una clase A, B o C.");
		        		      }
		        		        } else {
		        		        System.out.println("Dirección IP no válida. Debe contener cuatro octetos separados por puntos.");
		        		        }
		        	}
           }
        });
        contentPane.add(btnSubredes);
        
		JButton btnHosts = new JButton("");
		btnHosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                // Obtener la dirección IP ingresada por el usuario
                String direccionIP = txtDireccionIP.getText();
                
                // Mostrar la dirección IP en el JLabel correspondiente
                lblDireccionIP.setText("Dirección IP: " + direccionIP);
				
                // Detectar la clase de la dirección IP
                String claseIP = detectarClaseIP(direccionIP);

                // Mostrar la clase de la dirección IP en el JLabel correspondiente
                tboxClaseIP.setText(" " + claseIP); 
                
                // Obtener la dirección IP del JTextField
                String direccionIP2 = txtDireccionIP.getText();

                // Obtener la clase de la dirección IP
                int primerOcteto = Integer.parseInt(direccionIP2.split("\\.")[0]);

                String mascaraDeRed;

                // Determinar la máscara de red según la clase de la dirección IP
                if (primerOcteto <= 127) {
                    mascaraDeRed = "255.0.0.0";
                } else if (primerOcteto >= 128 && primerOcteto <= 191) {
                    mascaraDeRed = "255.255.0.0";
                } else if (primerOcteto >= 192 && primerOcteto <= 223) {
                    mascaraDeRed = "255.255.255.0";
                } else {
                	mascaraDeRed = "Imposible de obtener con esa clase";
                }

                // Establecer la máscara de red en el JLabel
                txtMascara_1.setText(mascaraDeRed);
                
                /*
                 * SEPRADOR
                 */
                
                String hostsCadena = txtHostsC.getText();
                int hostsPorSubred = Integer.parseInt(hostsCadena); // Convertir la cadena a entero}
                
                
                String[] octetos = direccionIP.split("\\.");
                String octeto1 = octetos[0];
                String octeto2 = octetos[1];
                String octeto3 = octetos[2];

                int valorInt1 = hostsPorSubred + 2; // Calcular el valorInt1 sumando 2 para la dirección de red y broadcast

                if (Integer.parseInt(octeto1) >= 1 && Integer.parseInt(octeto1) <= 126) {
                    System.out.println("\nClase A | Dirección de Red: " + octeto1 + ".0.0.0\n");

                    // Calcular el número de subredes teóricas y prácticas
                    int subredesTeoricas = (int) Math.pow(2, 24 - (int) (Math.log(hostsPorSubred + 2) / Math.log(2)));
                    int subredesPracticas = (subredesTeoricas > 0) ? subredesTeoricas - 2 : 0;

                    txtSubredesTeoricas.setText(""+subredesTeoricas);
                    txtSubredesPracticos.setText("" + subredesPracticas);
                    txtHostSubredesTeoricos.setText(""+valorInt1);
                    txtHostSubredesPracticos.setText("" + (hostsPorSubred > 0 ? hostsPorSubred : 0));

                    int valorPostumo = valorInt1 + 1; // Iniciar valorPostumo con valorInt1 - 1
                    for (int i = 1; i <= subredesPracticas; i++) {
                        System.out.println(i + ".- " + octeto1 + "." + (valorPostumo - 1) + ".0.0 hasta " + octeto1 + "." + ((valorPostumo - 1) - 1) + ".255.255");
                        valorPostumo += valorInt1; // Acumular el valor de valorInt1 en valorPostumo
                    }
    		        valorPostumo -= valorInt1;
    		        lblNuevaMascara.setText("Nueva máscara: 255.255.255." + valorPostumo);
                } else if (Integer.parseInt(octeto1) >= 128 && Integer.parseInt(octeto1) <= 191) {
                    System.out.println("\nClase B | Dirección de Red: " + octeto1 + "." + octeto2 + ".0.0\n");

                    // Calcular el número de subredes teóricas y prácticas
                    int subredesTeoricas = (int) Math.pow(2, 16 - (int) (Math.log(hostsPorSubred + 2) / Math.log(2)));
                    int subredesPracticas = (subredesTeoricas > 0) ? subredesTeoricas - 2 : 0;
                    
                    txtSubredesTeoricas.setText(""+subredesTeoricas);
                    txtSubredesPracticos.setText("" + subredesPracticas);
                    txtHostSubredesTeoricos.setText(""+valorInt1);
                    txtHostSubredesPracticos.setText("" + (hostsPorSubred > 0 ? hostsPorSubred : 0));

                    int valorPostumo = valorInt1 + 1; // Iniciar valorPostumo con valorInt1 - 1
                    for (int i = 1; i <= subredesPracticas; i++) {
                        System.out.println(i + ".- " + octeto1 + "." + octeto2 + "." + (valorPostumo - 1) + ".0 hasta " + octeto1 + "." + octeto2 + "." + ((valorPostumo - 1) - 1) + ".255");
                        valorPostumo += valorInt1; // Acumular el valor de valorInt1 en valorPostumo
                    }
    		        valorPostumo -= valorInt1;
    		        lblNuevaMascara.setText("Nueva máscara: 255.255.255." + valorPostumo);
                } else if (Integer.parseInt(octeto1) >= 192 && Integer.parseInt(octeto1) <= 223) {
                    System.out.println("\nClase C | Dirección de Red: " + octeto1 + "." + octeto2 + "." + octeto3 + ".0\n");

                    // Calcular el número de subredes teóricas y prácticas
                    int subredesTeoricas = (int) Math.pow(2, 8 - (int) (Math.log(hostsPorSubred + 2) / Math.log(2)));
                    int subredesPracticas = (subredesTeoricas > 0) ? subredesTeoricas - 2 : 0;

                    txtSubredesTeoricas.setText(""+subredesTeoricas);
                    txtSubredesPracticos.setText("" + subredesPracticas);
                    txtHostSubredesTeoricos.setText(""+valorInt1);
                    txtHostSubredesPracticos.setText("" + (hostsPorSubred > 0 ? hostsPorSubred : 0));

                    int valorPostumo = valorInt1; // Iniciar valorPostumo con valorInt1 - 1
                    for (int i = 1; i <= subredesPracticas; i++) {
                        System.out.println(i + ".- " + octeto1 + "." + octeto2 + "." + octeto3 + "." + (valorPostumo - 1) + " hasta " + octeto1 + "." + octeto2 + "." + octeto3 + "." + ((valorPostumo - 1) - 1));
                        valorPostumo += valorInt1; // Acumular el valor de valorInt1 en valorPostumo
                    }
    		        valorPostumo -= valorInt1;
    		        lblNuevaMascara.setText("Nueva máscara: 255.255.255." + valorPostumo);
                } else {
                    System.out.println("\nDirección IP inválida.");
                }
				
			}
		});
		btnHosts.setEnabled(false);
		btnHosts.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\lupa (1).png"));
		btnHosts.setBounds(264, 148, 16, 16);
		contentPane.add(btnHosts);

        lblDireccionIP = new JLabel("Dirección IP: ");
        lblDireccionIP.setBounds(10, 200, 199, 14);
        lblDireccionIP.setFont(new Font("Poppins", Font.PLAIN, 12));
        contentPane.add(lblDireccionIP);

        lblClaseIP = new JLabel("Clase de IP: ");
        lblClaseIP.setBounds(10, 183, 78, 14);
        lblClaseIP.setFont(new Font("Poppins", Font.PLAIN, 12));
        contentPane.add(lblClaseIP);
        
        JLabel txtDescripción = new JLabel("Este programa simula la creación de suberedes dependiendo de");
        txtDescripción.setBounds(10, 30, 381, 20);
        txtDescripción.setFont(new Font("Poppins", Font.PLAIN, 12));
        contentPane.add(txtDescripción);
        
        JLabel txtTitulo = new JLabel("Software de Subneteo");
        txtTitulo.setEnabled(false);
        txtTitulo.setBounds(10, 11, 167, 20);
        txtTitulo.setFont(new Font("Poppins", Font.PLAIN, 14));
        contentPane.add(txtTitulo);
        
        JLabel lblDeUnaDireccin = new JLabel("de una dirección IP proporcionada y el número de subredes o hosts.");
        lblDeUnaDireccin.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblDeUnaDireccin.setBounds(10, 45, 413, 20);
        contentPane.add(lblDeUnaDireccin);
        
        JPanel lineaDivisora = new JPanel();
        lineaDivisora.setBackground(Color.LIGHT_GRAY);
        lineaDivisora.setBounds(0, 70, 434, 2);
        contentPane.add(lineaDivisora);
        
        JLabel txtSubredes = new JLabel("Ingrese el número de subredes: ");
        txtSubredes.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtSubredes.setBounds(10, 123, 187, 14);
        contentPane.add(txtSubredes);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String ipAleatoria = generarDireccionIP();
        		txtDireccionIP.setText(ipAleatoria);
        		String numeroAleatorio = generarNumerosAleatorios();
        		tboxSubredes.setText(numeroAleatorio);
        	}
        });
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Pictures\\amlopelon.jpg"));
        lblNewLabel.setBounds(334, 76, 89, 88);
        contentPane.add(lblNewLabel);
        
        JLabel txtTituloSubredes = new JLabel("Subredes");
        txtTituloSubredes.setEnabled(false);
        txtTituloSubredes.setFont(new Font("Poppins", Font.PLAIN, 12));
        txtTituloSubredes.setBounds(10, 251, 64, 14);
        contentPane.add(txtTituloSubredes);
        
        JLabel lblTituloHostSubredes = new JLabel("Host * subredes");
        lblTituloHostSubredes.setFont(new Font("Poppins", Font.PLAIN, 12));
        lblTituloHostSubredes.setEnabled(false);
        lblTituloHostSubredes.setBounds(205, 251, 100, 14);
        contentPane.add(lblTituloHostSubredes);
        
        JPanel lineaDivisora_1 = new JPanel();
        lineaDivisora_1.setBackground(Color.LIGHT_GRAY);
        lineaDivisora_1.setBounds(0, 376, 434, 2);
        contentPane.add(lineaDivisora_1);
        
        JPanel lineaDivisora_2 = new JPanel();
        lineaDivisora_2.setBackground(Color.LIGHT_GRAY);
        lineaDivisora_2.setBounds(0, 238, 434, 2);
        contentPane.add(lineaDivisora_2);
        
        final JRadioButton rdbtnSubredes = new JRadioButton("Subredes");
        rdbtnSubredes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tboxSubredes.setEnabled(true);
        		txtHostsC.setEnabled(false);
        		txtHostsC.setText(null);
        		btnHosts.setEnabled(false);
        		btnSubredes.setEnabled(true);
        	}
        });
        rdbtnSubredes.setFont(new Font("Poppins", Font.PLAIN, 12));
        rdbtnSubredes.setBounds(10, 95, 109, 23);
        contentPane.add(rdbtnSubredes);
        
        JRadioButton rdbtnHosts = new JRadioButton("Hosts");
        rdbtnHosts.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		
        	tboxSubredes.setEnabled(false);
    		txtHostsC.setEnabled(true);
    		tboxSubredes.setText(null);
    		btnSubredes.setEnabled(false);
    		btnHosts.setEnabled(true);
        	}
        });
        rdbtnHosts.setFont(new Font("Poppins", Font.PLAIN, 12));
        rdbtnHosts.setBounds(116, 95, 109, 23);
        contentPane.add(rdbtnHosts);
        
		// Agrega los botones de opción a un ButtonGroup
		
		ButtonGroup btngFuncion = new ButtonGroup();
		btngFuncion.add(rdbtnHosts);
		btngFuncion.add(rdbtnSubredes);   
		
		JLabel lblNewLabel_1 = new JLabel("Equipo 7. Copyright Derechos Reservados 2023 ©");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 439, 295, 14);
		contentPane.add(lblNewLabel_1);
		
		tboxRango = new JTextField();
		tboxRango.setFont(new Font("Poppins", Font.PLAIN, 12));
		tboxRango.setEditable(false);
		tboxRango.setColumns(10);
		tboxRango.setBounds(52, 323, 89, 20);
		contentPane.add(tboxRango);
    }

    /**
     * Genear un direccionesIP aleatoriamente
     */
    public static String generarDireccionIP() {
        Random random = new Random();
        int octeto1 = random.nextInt(256);
        int octeto2 = random.nextInt(256);
        int octeto3 = random.nextInt(256);
        int octeto4 = random.nextInt(256);
        return octeto1 + "." + octeto2 + "." + octeto3 + "." + octeto4;
    }
    
    /**
     * Genear números aleatoriamente
     */
    public static String generarNumerosAleatorios() {
        Random random = new Random();
        int numeraso = random.nextInt(10000);
        return numeraso + "";
    }
    
    /**
     * Detecta la clase de una dirección IP dada.
     */
    public String detectarClaseIP(String direccionIP) {
        String[] octetos = direccionIP.split("\\."); // dividimos la dirección IP en sus octetos

        int primerOcteto =
        		
        	    Integer.parseInt(octetos[0]); // obtenemos el primer octeto como un entero

        if (primerOcteto >= 0 && primerOcteto <= 127) {
        	
            return "A";
        } else if (primerOcteto >= 128 && primerOcteto <= 191) {
        	
            return "B";
        } else if (primerOcteto >= 192 && primerOcteto <= 222) {
        	
            return "C";
        } else if (primerOcteto >= 223 && primerOcteto <= 239) {
            return "D";
        } else if (primerOcteto >= 240 && primerOcteto <= 255) {
            return "E";
        } else {
            return "Dirección IP no válida";
        }
        
        
    }
}
