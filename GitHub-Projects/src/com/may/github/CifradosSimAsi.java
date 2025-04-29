package com.may.github;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;


public class CifradosSimAsi {

	private JFrame frmSimuladorDeAlgoritmos;
	private JTextField txtTextoClaro;
	private JTextField txtTextoCifrado;
	private JTextField txtTextoDescifrado;
	private JTextField txtCapturaK;
	private JTextField txtPrimoP;
	private JTextField txtPrimoQ;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CifradosSimAsi window = new CifradosSimAsi();
					window.frmSimuladorDeAlgoritmos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CifradosSimAsi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimuladorDeAlgoritmos = new JFrame();
		frmSimuladorDeAlgoritmos.setResizable(false);
		frmSimuladorDeAlgoritmos.setTitle("Simulador de algoritmos");
		frmSimuladorDeAlgoritmos.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Downloads\\icon-fim.png"));
		frmSimuladorDeAlgoritmos.setBounds(100, 100, 347, 495);
		frmSimuladorDeAlgoritmos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimuladorDeAlgoritmos.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cifrados Siméticos y Asimétricos");
		lblTitulo.setEnabled(false);
		lblTitulo.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblTitulo.setBounds(10, 11, 230, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblTitulo);
		
		JLabel lblDesc = new JLabel("Este programa simula 3 tipos de métodos de cifrados y ");
		lblDesc.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblDesc.setBounds(10, 25, 317, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblDesc);
		
		JLabel lblPasoAPaso = new JLabel("explicará paso a paso para un mejor entendimiento.");
		lblPasoAPaso.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblPasoAPaso.setBounds(10, 36, 300, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblPasoAPaso);
		
		JLabel lblMetodoCifradoTitulo = new JLabel("Método de cifrado:");
		lblMetodoCifradoTitulo.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblMetodoCifradoTitulo.setBounds(10, 80, 126, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblMetodoCifradoTitulo);
		
		// Mis opciones de algoritmos en radio buttons 
		final JRadioButton rdbtnCesar = new JRadioButton("Cifrado de césar");
		rdbtnCesar.setFont(new Font("Poppins", Font.PLAIN, 12));
		rdbtnCesar.setBounds(10, 92, 138, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(rdbtnCesar);
		
		final JRadioButton rdbtnCifradoDeBloques = new JRadioButton("Cifrado de bloques simple");
		rdbtnCifradoDeBloques.setFont(new Font("Poppins", Font.PLAIN, 12));
		rdbtnCifradoDeBloques.setBounds(10, 110, 182, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(rdbtnCifradoDeBloques);
		
		final JRadioButton rdbtnAlgoritmoRSA = new JRadioButton("Algoritmo RSA");
		rdbtnAlgoritmoRSA.setFont(new Font("Poppins", Font.PLAIN, 12));
		rdbtnAlgoritmoRSA.setBounds(10, 128, 109, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(rdbtnAlgoritmoRSA);
		
		// Los meto en un grupo para solo seleccionar una opción 
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnCesar);
        buttonGroup.add(rdbtnCifradoDeBloques);
        buttonGroup.add(rdbtnAlgoritmoRSA);
		
		JLabel lblTextoEnClaro = new JLabel("Texto en claro:");
		lblTextoEnClaro.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblTextoEnClaro.setBounds(10, 167, 96, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblTextoEnClaro);
		
		txtTextoClaro = new JTextField();
		txtTextoClaro.setEnabled(false);
		txtTextoClaro.setBounds(10, 182, 86, 20);
		frmSimuladorDeAlgoritmos.getContentPane().add(txtTextoClaro);
		txtTextoClaro.setColumns(10);
		
		JLabel lblTextoCifrado = new JLabel("Texto cifrado:");
		lblTextoCifrado.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblTextoCifrado.setBounds(10, 203, 96, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblTextoCifrado);
		
		txtTextoCifrado = new JTextField();
		txtTextoCifrado.setEnabled(false);
		txtTextoCifrado.setColumns(10);
		txtTextoCifrado.setBounds(10, 218, 86, 20);
		frmSimuladorDeAlgoritmos.getContentPane().add(txtTextoCifrado);
		
		JLabel lblTextoDescifrado = new JLabel("Texto descifrado: ");
		lblTextoDescifrado.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblTextoDescifrado.setBounds(10, 239, 109, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblTextoDescifrado);
		
		txtTextoDescifrado = new JTextField();
		txtTextoDescifrado.setEnabled(false);
		txtTextoDescifrado.setColumns(10);
		txtTextoDescifrado.setBounds(10, 255, 86, 20);
		frmSimuladorDeAlgoritmos.getContentPane().add(txtTextoDescifrado);
		
		JLabel lblMtodo = new JLabel("Método:");
		lblMtodo.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblMtodo.setBounds(10, 286, 62, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblMtodo);
		
		JPanel panelMetodo = new JPanel();
		panelMetodo.setBackground(Color.LIGHT_GRAY);
		panelMetodo.setBounds(10, 311, 311, 134);
		frmSimuladorDeAlgoritmos.getContentPane().add(panelMetodo);
		panelMetodo.setLayout(null);
		
		final JTextArea taDescripcionMetodo = new JTextArea();
		taDescripcionMetodo.setFont(new Font("Poppins", Font.PLAIN, 11));
		taDescripcionMetodo.setEditable(false);
		taDescripcionMetodo.setBounds(10, 7, 291, 118);
		panelMetodo.add(taDescripcionMetodo);
		JScrollPane scrollPane = new JScrollPane(taDescripcionMetodo);
		scrollPane.setBounds(10, 7, 291, 118);
		panelMetodo.add(scrollPane);
		
		JLabel lblK = new JLabel("k:");
		lblK.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblK.setBounds(210, 83, 18, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblK);
		
		txtCapturaK = new JTextField();
		txtCapturaK.setEnabled(false);
		txtCapturaK.setColumns(10);
		txtCapturaK.setBounds(220, 80, 32, 20);
		frmSimuladorDeAlgoritmos.getContentPane().add(txtCapturaK);
		
		final JLabel lblAbecedario = new JLabel(" ");
		lblAbecedario.setBounds(138, 286, 46, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblAbecedario);
		
		final JLabel lblAbecedarioModificado = new JLabel(" ");
		lblAbecedarioModificado.setBounds(82, 286, 46, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblAbecedarioModificado);
		
		JButton btnVerTabla = new JButton("Ver tabla");
		btnVerTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnCesar.isSelected()) {
					
	                int desplazamiento = Integer.parseInt(txtCapturaK.getText());
		            String abecedarioOriginal = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		            String abecedarioModificado = obtenerAbecedarioModificado(desplazamiento);

		            AbecedarioVentana abecedarioVentana = new AbecedarioVentana(abecedarioOriginal, abecedarioModificado);
		            abecedarioVentana.setVisible(true);
		            
				} else if (rdbtnCifradoDeBloques.isSelected()) {
					
	                generateBinaryTable();
					
				} else if (rdbtnAlgoritmoRSA.isSelected()) {
			        AbecedarioASCII abecedarioWindow = new AbecedarioASCII();
			        abecedarioWindow.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Debes elegir un método de cifrado válido");
				}
				
			}
		});
		btnVerTabla.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnVerTabla.setBounds(235, 176, 89, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(btnVerTabla);
		
		JButton btnCifrar = new JButton("Cifrar");
		btnCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if (rdbtnCesar.isSelected()) {
				
                String mensaje = txtTextoClaro.getText();
                int desplazamiento = Integer.parseInt(txtCapturaK.getText());
                String mensajeCifrado = cifrar(mensaje, desplazamiento);
                txtTextoCifrado.setText(mensajeCifrado);
				txtTextoDescifrado.setText("");
                
                taDescripcionMetodo.setText(" Como primer paso debemos capturar lo que \n es k: " + desplazamiento);	
                taDescripcionMetodo.append(". Eso lo que hará es mover el abecedario \n orignal las mismas posiciones que k. Podemos \n ver esto si le damos a ver tabla.");
                taDescripcionMetodo.append("\n\n Ahora, estas letras intercambiadas tomaran la \n posicion de las letras orignales y el mensaje \n se cifrará. \n\n Por lo tanto el mensaje queda de la siguiente \n manera: \n\n");
                taDescripcionMetodo.append(" Mensaje en claro: " + mensaje + "\n Mensaje cifrado: " + mensajeCifrado + "\n");
				
				} else if (rdbtnCifradoDeBloques.isSelected()) {
	                cifrarTexto();
	                int bloqueBits = Integer.parseInt(txtCapturaK.getText());
	                int tamanioTabla = (int) Math.pow(2, bloqueBits);
	                
	                taDescripcionMetodo.setText(" 1. Primero creamos la tabla con la ");	
	                taDescripcionMetodo.append("potencia \n 2^" + bloqueBits + " = " + tamanioTabla + ". Esto serán las");
	                taDescripcionMetodo.append("combinaciones que \n tendrá la tabla.");
	                taDescripcionMetodo.append(" Esta se encuentra en Ver Tabla.");
	                
	                taDescripcionMetodo.append("\n\n 2. Tomamos el texto en claro, ");	
	                taDescripcionMetodo.append("sacamos su valor \n ASCII y los convertimos a binario.");
	                taDescripcionMetodo.append("Eso lo hacemos \n carácter por carácter.");

	                taDescripcionMetodo.append("\n\n 3. Ahora se dividen bloques");	
	                taDescripcionMetodo.append("de k bits y con la \n tabla generada");
	                taDescripcionMetodo.append("se haran intercambios entre los \n bits orignales y los que cifrarán.");
	                
	                taDescripcionMetodo.append("\n\n 4. Finalmente mostramos el mensaje");	
	                taDescripcionMetodo.append(" cifrado \n con el siguiente orden: \n\n ");
	                taDescripcionMetodo.append("txtCifrado = BINARIOCIFRADO, ASCII ...");
	                
				} else if (rdbtnAlgoritmoRSA.isSelected()) {
					
					// Creo las variables de tipo BigInteger 
					
					String pCadena = txtPrimoP.getText();   // Es una cadena ya que esta en JTextField y lo paso a un valor BigInteger
					BigInteger p = new BigInteger(pCadena); // esto para poder trabajar con ese tipo de numeros
					String qCadena = txtPrimoQ.getText();   // hago lo mismo para tanto p y q y despúes no tener
					BigInteger q = new BigInteger(qCadena); // problemas con ninguno de los pasos siguientes.
					
					// Estas son mis variables que daré valor en los siguientes pasos
				    BigInteger n;
				    BigInteger z;
				    BigInteger e2;
				    BigInteger d=BigInteger.ZERO;
				    
			        // Calcular n = p * q
			        n = p.multiply(q);
			        
			        // Calcular z(n) = (p - 1) * (q - 1)
			        z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
					

			        // Creo un objeto del tipo SecureRandom
			        SecureRandom random = new SecureRandom();
			        e2 = BigInteger.probablePrime(z.bitLength() - 1, random);

			        // Ciclo while para encontrar el valor de e
			        while (e2!=d) {
			            e2 = BigInteger.probablePrime(z.bitLength() - 1, random);

			            if (!z.gcd(e2).equals(BigInteger.ONE)) {
			                continue;
			            }

			            d = e2.modInverse(z);

			            if (!e2.equals(d) && d.compareTo(BigInteger.ZERO) > 0) {
			                break;
			            	}
			        }

			        /*
			         * SEGUNDA PARTE - VOL.2 - SEASON 2
			         */
			        
			        String textoClaro = txtTextoClaro.getText(); // Obtengo la cadena de mi TextoClaro

			     // Convierto el texto claro en una matriz de caracteres
			     char[] caracteres = textoClaro.toCharArray();

			     // Creo una instancia de StringBuilder para construir el texto cifrado
			     StringBuilder textoCifrado = new StringBuilder();

			     for (char c : caracteres) {
			         // Convertir el carácter en un BigInteger
			         BigInteger m = BigInteger.valueOf(c);

			         // Cifrar el BigInteger utilizando la clave pública (e, n)
			         BigInteger cifrado = m.modPow(e2, n);

			         // Agregar el número cifrado al texto cifrado
			         textoCifrado.append(cifrado).append(" ");
			     }

			     // Establecer el texto cifrado en el campo de texto correspondiente
			     txtTextoCifrado.setText(textoCifrado.toString().trim());

			        
	                taDescripcionMetodo.setText(" Para el Algoritmo de RSA utilizaremos \n estos pasos: \n\n 1. Tomar nuestros números primos. Estos no \n deben sobrepasar a 100. \n\n p: " + p + "\n q: " + q);	
	                taDescripcionMetodo.append("\n\n 2. Calcular el valor de n y z. Donde estos se \n calcuan así: \n\n (n = p*q) n = " + n + "\n (z = (p-1) * (q-1)) z = " + z);
	                taDescripcionMetodo.append("\n\n 3. Encontrar primos relativos y calcular el \n valor de e. A su vez, e debe ser MCD igual a 1. \n\n e = " + e2);
	                taDescripcionMetodo.append("\n\n 4. Encontrar el valor d donde (e * d)mod z = 1 \n o ((e * d) − 1) mod z = 0\r\n\n d= " + d);
	                taDescripcionMetodo.append("\n\n 5. Determinar la clave pública (n,e) y la \n clave privada (n,d) \n\n Clave pública (" + n + "," + e2 + ") \n Clave privada (" + n + "," + d + ")");
	                taDescripcionMetodo.append("\n\n Formular. Por último tenemos las formular \n para cifrar y descifrar mensajes. \n\n Cifrado: c = m^e mod n \n Descifrar: m = c^d mod n \n\n Ademas de seguir esta regla m<n");

				} else {
					JOptionPane.showMessageDialog(null, "No ha seleccionado un método válido para cifrar un mensaje en claro.", "", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de Nerror
				}
			}
		});
		btnCifrar.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnCifrar.setBounds(235, 201, 89, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(btnCifrar);
		
		JButton btnDescrifrar = new JButton("Descrifrar");
		btnDescrifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnCesar.isSelected()) {
					
				String textoClaro = txtTextoClaro.getText();
				txtTextoDescifrado.setText(textoClaro);
				txtTextoDescifrado.setEnabled(true);
				txtTextoDescifrado.setEditable(false);
				
				} else if (rdbtnCifradoDeBloques.isSelected()) {
					
					String textoClaro = txtTextoClaro.getText();
					txtTextoDescifrado.setText(textoClaro);
					txtTextoDescifrado.setEnabled(true);
					txtTextoDescifrado.setEditable(false);
	                
				} else if (rdbtnAlgoritmoRSA.isSelected()) {
					
					String textoClaro = txtTextoClaro.getText();
					txtTextoDescifrado.setText(textoClaro);
					txtTextoDescifrado.setEnabled(true);
					txtTextoDescifrado.setEditable(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "No hay un mensaje para descifrar.", "", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de Nerror
				}
			}
		});
		btnDescrifrar.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnDescrifrar.setBounds(235, 226, 89, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(btnDescrifrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTextoClaro.setText("");
				txtTextoCifrado.setText(null);
				txtTextoDescifrado.setText(null);
				txtCapturaK.setText(null);
				taDescripcionMetodo.setText("");
				txtPrimoP.setText(null);
				txtPrimoQ.setText(null);
				
			}
		});
		btnLimpiar.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnLimpiar.setBounds(235, 251, 89, 23);
		frmSimuladorDeAlgoritmos.getContentPane().add(btnLimpiar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 60, 331, 4);
		frmSimuladorDeAlgoritmos.getContentPane().add(panel);
		
		JLabel lblCreditos = new JLabel("Elaborado por el Equipo 7. Derechos reservados.");
		lblCreditos.setEnabled(false);
		lblCreditos.setFont(new Font("Poppins", Font.PLAIN, 11));
		lblCreditos.setBounds(10, 65, 280, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblCreditos);
		
		JLabel lblPrimoP = new JLabel("p:");
		lblPrimoP.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblPrimoP.setBounds(268, 83, 18, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblPrimoP);
		
		txtPrimoP = new JTextField();
		txtPrimoP.setEnabled(false);
		txtPrimoP.setColumns(10);
		txtPrimoP.setBounds(278, 80, 32, 20);
		frmSimuladorDeAlgoritmos.getContentPane().add(txtPrimoP);
		
		JLabel lblPrimoQ = new JLabel("q:");
		lblPrimoQ.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblPrimoQ.setBounds(268, 111, 18, 14);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblPrimoQ);
		
		txtPrimoQ = new JTextField();
		txtPrimoQ.setEnabled(false);
		txtPrimoQ.setColumns(10);
		txtPrimoQ.setBounds(278, 108, 32, 20);
		frmSimuladorDeAlgoritmos.getContentPane().add(txtPrimoQ);
		
		JButton btnCargarMetodo = new JButton("");
		btnCargarMetodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnCesar.isSelected()) {
					
					txtTextoClaro.setEnabled(true);
					txtCapturaK.setEnabled(true);
					txtTextoCifrado.setEnabled(true);
					txtTextoCifrado.setEditable(false);
					
					// Desactivo la opción de csmpos de texto ya que no se ocupan en este método
					txtPrimoP.setEnabled(false);
					txtPrimoQ.setEnabled(false);
					
				} else if (rdbtnCifradoDeBloques.isSelected()) {
					
					txtTextoClaro.setEnabled(true);
					txtCapturaK.setEnabled(true);
					txtTextoCifrado.setEnabled(true);
					txtTextoCifrado.setEditable(false);
					txtTextoDescifrado.setEditable(false);
					txtTextoDescifrado.setEnabled(true);

					
					// Desactivo la opción de csmpos de texto ya que no se ocupan en este método
					txtPrimoP.setEnabled(false);
					txtPrimoQ.setEnabled(false);
					
				} else if (rdbtnAlgoritmoRSA.isSelected()) {
					txtCapturaK.setEnabled(false);
					txtTextoClaro.setEnabled(true);
					txtTextoCifrado.setEnabled(true);
					txtTextoCifrado.setEditable(false);
					txtPrimoP.setEnabled(true);
					txtPrimoQ.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "A ocurrido un error, debe seleccionar un algoritmo para continuar.", "", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de Nerror
				}
				
			}
		});
		btnCargarMetodo.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Desktop\\d.png"));
		btnCargarMetodo.setBounds(152, 80, 32, 32);
		frmSimuladorDeAlgoritmos.getContentPane().add(btnCargarMetodo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Desktop\\thecockrock.gif"));
		lblNewLabel.setBounds(129, 188, 80, 80);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "¡GOOOOOYAA! CACHU CACHUA RA RA", "", JOptionPane.INFORMATION_MESSAGE); //mostrar mensaje de Nerror
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Desktop\\ll-removebg-preview.png"));
		lblNewLabel_1.setBounds(270, 135, 40, 36);
		frmSimuladorDeAlgoritmos.getContentPane().add(lblNewLabel_1);

	}
	
	/*
	 * Clases que utilizaré 
	 */
	
	/*
	 * CIFRADO DE CESAR
	 */
	// Esto me permitirá mover el abecedario original y poder cifrar el mensaje
    public static String cifrar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (Character.isLetter(letra)) {
                int codigo = (int) letra;
                int base;
                if (Character.isLowerCase(letra)) {
                    base = (int) 'a';
                } else {
                    base = (int) 'A';
                }
                codigo = (codigo - base + desplazamiento) % 26 + base;
                char letraCifrada = (char) codigo;
                resultado.append(letraCifrada);
            } else {
                resultado.append(letra);
            }
        }
        return resultado.toString();
    }

    // Este me permitira obtener el abecedario modificado para mostrarlo y usarlo
    public static String obtenerAbecedarioModificado(int desplazamiento) {
        StringBuilder abecedarioModificado = new StringBuilder();
        int base = (int) 'A';
        for (int i = 0; i < 26; i++) {
            int codigo = (i + desplazamiento) % 26 + base;
            char letra = (char) codigo;
            abecedarioModificado.append(letra);
        }
        return abecedarioModificado.toString();
    }
    
    /*
     * BLOQUE SIMPLE
     */
    
    private void generateBinaryTable() {
        String valorK = txtCapturaK.getText();

        if (!valorK.isEmpty()) {
            try {
                int k = Integer.parseInt(valorK);
                int tamanioTabla2 = (int) Math.pow(2, k);

                if (k >= 0) {
                    JDialog tabloideBinariasco = new JDialog();
                    tabloideBinariasco.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    tabloideBinariasco.setLayout(new BorderLayout());

                    String[] columnas = {"Número Binario", "Resultado"};
                    Object[][] ladatapapaya = new Object[tamanioTabla2][2];

                    for (int i = 0; i < tamanioTabla2; i++) {
                        String bin = Integer.toBinaryString(i);

                        while (bin.length() < k) {
                        	bin = "0" + bin;
                        }

                        String salida = generarSalida(bin, k);
                        ladatapapaya[i][0] = bin;
                        ladatapapaya[i][1] = salida;
                    }

                    DefaultTableModel modeloTabla = new DefaultTableModel(ladatapapaya, columnas);
                    JTable tabla222222 = new JTable(modeloTabla);
                    tabla222222.setEnabled(false);
                    JScrollPane scrollPane = new JScrollPane(tabla222222);
                    tabloideBinariasco.add(scrollPane, BorderLayout.CENTER);
                    tabloideBinariasco.pack();
                    tabloideBinariasco.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "El valor de K debe ser mayor o igual a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El valor de K no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor para K.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String generarSalida(String binarioDos, int k) {
        StringBuilder salidos = new StringBuilder();

        for (int i = 0; i < k; i++) {
            char bitAParinado = binarioDos.charAt(i);

            if (bitAParinado == '0') { // Si hay 0 agrega 1
            	salidos.append('1');
            } else { // Agrega 0
            	salidos.append('0');
            }
        }

        return salidos.toString();
    }
    
    private void cifrarTexto() {
        String textoClaro = txtTextoClaro.getText();

        if (!textoClaro.isEmpty()) {
            StringBuilder textoCifrado = new StringBuilder();

            int k = Integer.parseInt(txtCapturaK.getText());

            for (int i = 0; i < textoClaro.length(); i++) {
                char caracter = textoClaro.charAt(i);
                int ascii = (int) caracter;
                String binarioAuxiliar = Integer.toBinaryString(ascii);

                while (binarioAuxiliar.length() < 15) {
                	binarioAuxiliar = "0" + binarioAuxiliar;
                }

                StringBuilder cifrado = new StringBuilder();

                for (int j = 0; j < 15; j += k) {
                    int varInicializadora = j;
                    int varFinalizadora = Math.min(j + k, 15);
                    String block = binarioAuxiliar.substring(varInicializadora, varFinalizadora);
                    String resultado = buscarResultadoEnTabla(block);
                    cifrado.append(resultado);
                }

                textoCifrado.append(cifrado.toString()).append(", ").append(binarioAuxiliar).append(", ").append(ascii).append(", ");
            }

            txtTextoCifrado.setText(textoCifrado.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un texto en claro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }




    
    private Object[][] a;
    private int tamanioTabla;	
    
    private String buscarResultadoEnTabla(String binario) {
        for (int i = 0; i < tamanioTabla; i++) {
            String binDeTabla = (String) a[i][0];

            if (binario.equals(binDeTabla)) {
                return (String) a[i][1];
            }
        }

        return "";
    }
     
 }
