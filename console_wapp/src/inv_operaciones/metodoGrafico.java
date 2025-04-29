package inv_operaciones;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.Polygon;


public class metodoGrafico {

	private JFrame frmIdoMtodoGrfico;
	private JTextField etxtX;
	private JTextField etxtY;
	private JTextField etxtRX1;
	private JTextField etxtRX2;
	private JTextField etxtRX3;
	private JTextField etxtRY1;
	private JTextField etxtRY2;
	private JTextField etxtRY3;
	private JTextField etxtResRes1;
	private JTextField etxtResRes2;
	private JTextField etxtResRes3;
	private JTextField txtNuevasX;
	private JTextField txtNuevasY;
	private JTextField txtNuevosResultados;
    private ArrayList<JLabel> lblNuevasRestricciones;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					metodoGrafico window = new metodoGrafico();
					window.frmIdoMtodoGrfico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public metodoGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdoMtodoGrfico = new JFrame();
		frmIdoMtodoGrfico.setResizable(false);
		frmIdoMtodoGrfico.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ernesto Amaral\\Pictures\\a.png"));
		frmIdoMtodoGrfico.setForeground(new Color(0, 0, 0));
		frmIdoMtodoGrfico.setTitle("Programación Lineal Método Gráfico");
		frmIdoMtodoGrfico.setBounds(100, 100, 1042, 671);
		frmIdoMtodoGrfico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdoMtodoGrfico.getContentPane().setLayout(null);
		
		JLabel lblDesc = new JLabel("Este programa solicita al usuario que objetivo ");
		lblDesc.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblDesc.setBounds(10, 33, 342, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblDesc);
		
		JLabel lblDesc2 = new JLabel("quiere realizar y mostrará el gráfico del objetivo solicitado.");
		lblDesc2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblDesc2.setBounds(10, 48, 424, 27);
		frmIdoMtodoGrfico.getContentPane().add(lblDesc2);
		
		JLabel img = new JLabel("");
		img.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Función objetivo
			    
				etxtX.setText("600");
				etxtY.setText("700");
				
				// Restricciones de solo x
				
				etxtRX1.setText("1");
				etxtRX2.setText("2");
				etxtRX3.setText("3");
				
				// Restricciones de solo y
				
				etxtRY1.setText("2");
				etxtRY2.setText("2");
				etxtRY3.setText("2");
				
				// Resultados de las restricciones
				
				etxtResRes1.setText("140");
				etxtResRes2.setText("190");
				etxtResRes3.setText("240");
		
			}
		});
		img.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\Diseño_sin_título-removebg-preview (1).png"));
		img.setBounds(950, 11, 65, 29);
		frmIdoMtodoGrfico.getContentPane().add(img);
		
		JPanel lineaDivisora = new JPanel();
		lineaDivisora.setBackground(Color.LIGHT_GRAY);
		lineaDivisora.setBounds(0, 80, 1024, 2);
		frmIdoMtodoGrfico.getContentPane().add(lineaDivisora);
		
		JLabel txtObjetivo = new JLabel("Objetivo:");
		txtObjetivo.setEnabled(false);
		txtObjetivo.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtObjetivo.setBounds(10, 93, 109, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtObjetivo);
		
		JRadioButton rbtnMinimizar = new JRadioButton("Minimizar");
		rbtnMinimizar.setFont(new Font("Poppins", Font.PLAIN, 13));
		rbtnMinimizar.setBounds(10, 117, 109, 23);
		frmIdoMtodoGrfico.getContentPane().add(rbtnMinimizar);
		
		JRadioButton rbtnMaximizar = new JRadioButton("Maximizar");
		rbtnMaximizar.setFont(new Font("Poppins", Font.PLAIN, 13));
		rbtnMaximizar.setBounds(10, 143, 109, 23);
		frmIdoMtodoGrfico.getContentPane().add(rbtnMaximizar);
		
		// Agrega los botones de opción a un ButtonGroup
		
		ButtonGroup btngFuncion = new ButtonGroup();
		btngFuncion.add(rbtnMinimizar);
		btngFuncion.add(rbtnMaximizar);
		
		// Agrego los ComboBox de las inecuaciones
		
        final JComboBox<String> cboxInecuacionR1 = new JComboBox<String>();
        cboxInecuacionR1.setBounds(138, 252, 45, 22);
        frmIdoMtodoGrfico.getContentPane().add(cboxInecuacionR1);
        
        // Estás son las opciones de los ComboBox para las restricciones

        cboxInecuacionR1.addItem(">=");
        cboxInecuacionR1.addItem("<=");
        cboxInecuacionR1.addItem("=");

        final JComboBox<String> cboxInecuacionR2 = new JComboBox<String>();
        cboxInecuacionR2.setBounds(138, 282, 45, 22);
        frmIdoMtodoGrfico.getContentPane().add(cboxInecuacionR2);
        
        // Estás son las opciones de los ComboBox para las restricciones

        cboxInecuacionR2.addItem(">=");
        cboxInecuacionR2.addItem("<=");
        cboxInecuacionR2.addItem("=");
        
        final JComboBox<String> cboxInecuacionR3 = new JComboBox<String>();
        cboxInecuacionR3.setBounds(138, 314, 45, 22);
        frmIdoMtodoGrfico.getContentPane().add(cboxInecuacionR3);
        
        // Estás son las opciones de los ComboBox para las restricciones
        
        cboxInecuacionR3.addItem(">=");
        cboxInecuacionR3.addItem("<=");
        cboxInecuacionR3.addItem("=");
		
		JLabel txtFuncObj = new JLabel("Función objetivo: ");
		txtFuncObj.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtFuncObj.setEnabled(false);
		txtFuncObj.setBounds(10, 167, 134, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtFuncObj);
		
		etxtX = new JTextField();
		etxtX.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtX.setBounds(10, 196, 45, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtX);
		etxtX.setColumns(10);
		
		JLabel lblX = new JLabel("x +");
		lblX.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX.setBounds(60, 192, 31, 29);
		frmIdoMtodoGrfico.getContentPane().add(lblX);
		
		etxtY = new JTextField();
		etxtY.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtY.setColumns(10);
		etxtY.setBounds(85, 196, 45, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtY);
		
		JLabel txtRestricciones = new JLabel("Restricciones:");
		txtRestricciones.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtRestricciones.setEnabled(false);
		txtRestricciones.setBounds(10, 223, 134, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtRestricciones);
		
		etxtRX1 = new JTextField();
		etxtRX1.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtRX1.setColumns(10);
		etxtRX1.setBounds(10, 253, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtRX1);
		
		JLabel lblY = new JLabel("y");
		lblY.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblY.setBounds(135, 192, 19, 29);
		frmIdoMtodoGrfico.getContentPane().add(lblY);
		
		etxtRX2 = new JTextField();
		etxtRX2.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtRX2.setColumns(10);
		etxtRX2.setBounds(10, 284, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtRX2);
		
		etxtRX3 = new JTextField();
		etxtRX3.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtRX3.setColumns(10);
		etxtRX3.setBounds(10, 315, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtRX3);
		
		etxtRY1 = new JTextField();
		etxtRY1.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtRY1.setColumns(10);
		etxtRY1.setBounds(82, 253, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtRY1);
		
		etxtRY2 = new JTextField();
		etxtRY2.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtRY2.setColumns(10);
		etxtRY2.setBounds(82, 284, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtRY2);
		
		etxtRY3 = new JTextField();
		etxtRY3.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtRY3.setColumns(10);
		etxtRY3.setBounds(82, 315, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtRY3);
		
		JLabel xmas1 = new JLabel("x +");
		xmas1.setFont(new Font("Poppins", Font.PLAIN, 14));
		xmas1.setBounds(55, 249, 31, 29);
		frmIdoMtodoGrfico.getContentPane().add(xmas1);
		
		JLabel xmas2 = new JLabel("x +");
		xmas2.setFont(new Font("Poppins", Font.PLAIN, 14));
		xmas2.setBounds(55, 280, 31, 29);
		frmIdoMtodoGrfico.getContentPane().add(xmas2);
		
		JLabel xmas3 = new JLabel("x +");
		xmas3.setFont(new Font("Poppins", Font.PLAIN, 14));
		xmas3.setBounds(55, 311, 31, 29);
		frmIdoMtodoGrfico.getContentPane().add(xmas3);
		
		JLabel yequal1 = new JLabel("y");
		yequal1.setFont(new Font("Poppins", Font.PLAIN, 14));
		yequal1.setBounds(125, 249, 11, 29);
		frmIdoMtodoGrfico.getContentPane().add(yequal1);
		
		JLabel yequal2 = new JLabel("y");
		yequal2.setFont(new Font("Poppins", Font.PLAIN, 14));
		yequal2.setBounds(125, 280, 19, 29);
		frmIdoMtodoGrfico.getContentPane().add(yequal2);
		
		JLabel yequal3 = new JLabel("y");
		yequal3.setFont(new Font("Poppins", Font.PLAIN, 14));
		yequal3.setBounds(125, 311, 19, 29);
		frmIdoMtodoGrfico.getContentPane().add(yequal3);
		
		etxtResRes1 = new JTextField();
		etxtResRes1.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtResRes1.setColumns(10);
		etxtResRes1.setBounds(187, 253, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtResRes1);
		
		etxtResRes2 = new JTextField();
		etxtResRes2.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtResRes2.setColumns(10);
		etxtResRes2.setBounds(187, 284, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtResRes2);
		
		etxtResRes3 = new JTextField();
		etxtResRes3.setFont(new Font("Poppins", Font.PLAIN, 13));
		etxtResRes3.setColumns(10);
		etxtResRes3.setBounds(187, 315, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(etxtResRes3);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setForeground(Color.RED);
		btnLimpiar.setBackground(Color.RED);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Esta acción limpia todos los campos que se ocuparon
				String vtxt = etxtX.getText(); 
				
					if (vtxt.isEmpty()) { //comprobar si el texto está vacío
						JOptionPane.showMessageDialog(null, "No se pudo completar la acción. No hay campos que requieran ser limpiados.", "", JOptionPane.INFORMATION_MESSAGE); //mostrar mensaje de Nerror
					} else {
							etxtX.setText(null);
								etxtY.setText(null);
									etxtRX1.setText(null);
										etxtRX2.setText(null);
											etxtRX3.setText(null);
											etxtRY1.setText(null);
												etxtRY2.setText(null);
													etxtRY3.setText(null);
													etxtResRes1.setText(null);
														etxtResRes2.setText(null);
															etxtResRes3.setText(null);
			}
		}
		});
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
		btnLimpiar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnLimpiar.setBounds(186, 362, 25, 23);
		frmIdoMtodoGrfico.getContentPane().add(btnLimpiar);
		
		JLabel lblProblemaPlanteado = new JLabel("Problema Planteado");
		lblProblemaPlanteado.setFont(new Font("Poppins", Font.BOLD, 14));
		lblProblemaPlanteado.setEnabled(false);
		lblProblemaPlanteado.setBounds(240, 83, 157, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblProblemaPlanteado);
		
		final JLabel lblRestriccion1 = new JLabel("...");
		lblRestriccion1.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblRestriccion1.setBounds(255, 177, 134, 14);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccion1);
		
		final JLabel lblRestriccion2 = new JLabel("...");
		lblRestriccion2.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblRestriccion2.setBounds(255, 207, 134, 14);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccion2);
		
		final JLabel lblRestriccion3 = new JLabel("...");
		lblRestriccion3.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblRestriccion3.setBounds(255, 237, 134, 14);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccion3);
		
		JLabel lblRestriccionesPlan = new JLabel("Sujeto a:");
		lblRestriccionesPlan.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblRestriccionesPlan.setEnabled(false);
		lblRestriccionesPlan.setBounds(240, 143, 70, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccionesPlan);
		
		JLabel lblFuncinObjetivo = new JLabel("Función objetivo:");
		lblFuncinObjetivo.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblFuncinObjetivo.setEnabled(false);
		lblFuncinObjetivo.setBounds(240, 100, 194, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblFuncinObjetivo);
		
		final JLabel lblFuncObje = new JLabel("...");
		lblFuncObje.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblFuncObje.setBounds(250, 125, 134, 14);
		frmIdoMtodoGrfico.getContentPane().add(lblFuncObje);
		
		
		// Acciones del boton para calcular las función objetivo y las restricciones
		JButton btnGraficar = new JButton("Generar problema");
		btnGraficar.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.GREEN));
		btnGraficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Esta acción limpia todos los campos que se ocuparon
				String vtxt = etxtRX1.getText(); 
				
					if (vtxt.isEmpty()) { //comprobar si el texto está vacío
						JOptionPane.showMessageDialog(null, "No se pudo completar la acción. No hay valores dentro de la función objetivo y las restricciones.", "", JOptionPane.ERROR_MESSAGE); //mostrar mensaje de Nerror
					} else {
				
				// Para el ComboBox de la primera restricción
						
				// Primera restricción
				String xRes1 = etxtRX1.getText();
				String yRes1 = etxtRY1.getText();
				String resR1 = etxtResRes1.getText();
				String restriccion1 = xRes1 + "x + " + yRes1 + "y " + cboxInecuacionR1.getSelectedItem() + " " + resR1;
				
				// segunda restricción
				String xRes2 = etxtRX2.getText();
				String yRes2 = etxtRY2.getText();
				String resR2 = etxtResRes2.getText();
				String restriccion2 = xRes2 + "x + " + yRes2 + "y " + cboxInecuacionR2.getSelectedItem() + " " + resR2;
				
				// tercera restricción
				String xRes3 = etxtRX3.getText();
				String yRes3 = etxtRY3.getText();
				String resR3 = etxtResRes3.getText();
				String restriccion3 = xRes3 + "x + " + yRes3 + "y " + cboxInecuacionR3.getSelectedItem() + " " + resR3;
				
				// Función objetivo
				String xFuncObj = etxtX.getText();
				String yFuncObj = etxtY.getText();
				String funcionObjetivo = "Z = " + xFuncObj + "x + " + yFuncObj + "y ";
				
				// Concatenamos las restricciones
				lblRestriccion1.setText(restriccion1);
				lblRestriccion2.setText(restriccion2);
				lblRestriccion3.setText(restriccion3);
				
				// Concatenamos la función objetivo
				lblFuncObje.setText(funcionObjetivo);
				
				}
			}
		});
		btnGraficar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGraficar.setBounds(10, 362, 166, 23);
		frmIdoMtodoGrfico.getContentPane().add(btnGraficar);
		
		JLabel lblXY = new JLabel("x, y");
		lblXY.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblXY.setEnabled(false);
		lblXY.setBounds(243, 252, 38, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblXY);
		
		JLabel lblRestriccion1_1 = new JLabel("1.");
		lblRestriccion1_1.setFont(new Font("Poppins", Font.BOLD, 13));
		lblRestriccion1_1.setBounds(240, 169, 11, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccion1_1);
		
		JLabel lblRestriccion1_1_1 = new JLabel("2.");
		lblRestriccion1_1_1.setFont(new Font("Poppins", Font.BOLD, 13));
		lblRestriccion1_1_1.setBounds(240, 199, 11, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccion1_1_1);
		
		JLabel lblRestriccion1_1_1_1 = new JLabel("3.");
		lblRestriccion1_1_1_1.setFont(new Font("Poppins", Font.BOLD, 13));
		lblRestriccion1_1_1_1.setBounds(240, 229, 23, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccion1_1_1_1);
		
		JLabel lblParaLaPrimera = new JLabel("Para la primera restricción");
		lblParaLaPrimera.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblParaLaPrimera.setEnabled(false);
		lblParaLaPrimera.setBounds(240, 366, 194, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblParaLaPrimera);
		
		JLabel lblX_1 = new JLabel("x = 0.0");
		lblX_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX_1.setEnabled(false);
		lblX_1.setBounds(245, 388, 65, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblX_1);
		
		final JLabel txtYRestriccion = new JLabel("y = ");
		txtYRestriccion.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtYRestriccion.setBounds(245, 403, 27, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtYRestriccion);
		
		JLabel lblX_1_2 = new JLabel("y = 0.0");
		lblX_1_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX_1_2.setEnabled(false);
		lblX_1_2.setBounds(335, 388, 80, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblX_1_2);
		
		final JLabel txtXRestriccion = new JLabel("x = ");
		txtXRestriccion.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtXRestriccion.setBounds(335, 403, 27, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtXRestriccion);
		
		JLabel lblParaLaSegunda = new JLabel("Para la segunda restricción");
		lblParaLaSegunda.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblParaLaSegunda.setEnabled(false);
		lblParaLaSegunda.setBounds(245, 438, 194, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblParaLaSegunda);
		
		JLabel lblX_1_1 = new JLabel("x = 0.0");
		lblX_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX_1_1.setEnabled(false);
		lblX_1_1.setBounds(245, 458, 65, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblX_1_1);
		
		final JLabel txtYRestriccion_2 = new JLabel("y = ");
		txtYRestriccion_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtYRestriccion_2.setBounds(245, 473, 27, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtYRestriccion_2);
		
		JLabel lblX_1_2_1 = new JLabel("y = 0.0");
		lblX_1_2_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX_1_2_1.setEnabled(false);
		lblX_1_2_1.setBounds(335, 458, 55, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblX_1_2_1);
		
		final JLabel txtXRestriccion_2 = new JLabel("x = ");
		txtXRestriccion_2.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtXRestriccion_2.setBounds(335, 473, 27, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtXRestriccion_2);
		
		JLabel lblParaLaSegunda_1 = new JLabel("Para la segunda restricción");
		lblParaLaSegunda_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblParaLaSegunda_1.setEnabled(false);
		lblParaLaSegunda_1.setBounds(245, 513, 194, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblParaLaSegunda_1);
		
		JLabel lblX_1_1_1 = new JLabel("x = 0");
		lblX_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX_1_1_1.setEnabled(false);
		lblX_1_1_1.setBounds(245, 533, 65, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblX_1_1_1);
		
		final JLabel txtYRestriccion3 = new JLabel("y = ");
		txtYRestriccion3.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtYRestriccion3.setBounds(245, 548, 27, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtYRestriccion3);
		
		JLabel lblX_1_2_1_1 = new JLabel("y = 0.0");
		lblX_1_2_1_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblX_1_2_1_1.setEnabled(false);
		lblX_1_2_1_1.setBounds(335, 533, 55, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblX_1_2_1_1);
		
		final JLabel txtXRestriccion_3 = new JLabel("x = ");
		txtXRestriccion_3.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtXRestriccion_3.setBounds(335, 548, 27, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtXRestriccion_3);
		
		
		// Los nuevos textos que me sirven para el gráfico
		
        final JLabel txtRestriccionY1 = new JLabel("0.0");
        txtRestriccionY1.setFont(new Font("Poppins", Font.PLAIN, 14));
        txtRestriccionY1.setBounds(271, 404, 54, 31);
        frmIdoMtodoGrfico.getContentPane().add(txtRestriccionY1);
        
        final JLabel txtRestriccionY2 = new JLabel("0.0");
        txtRestriccionY2.setFont(new Font("Poppins", Font.PLAIN, 14));
        txtRestriccionY2.setBounds(271, 474, 54, 31);
        frmIdoMtodoGrfico.getContentPane().add(txtRestriccionY2);
        
        final JLabel txtRestriccionY3 = new JLabel("0.0");
        txtRestriccionY3.setFont(new Font("Poppins", Font.PLAIN, 14));
        txtRestriccionY3.setBounds(271, 549, 54, 31);
        frmIdoMtodoGrfico.getContentPane().add(txtRestriccionY3);
        
        final JLabel txtRestriccionX1 = new JLabel("0.0");
        txtRestriccionX1.setFont(new Font("Poppins", Font.PLAIN, 14));
        txtRestriccionX1.setBounds(360, 403, 55, 31);
        frmIdoMtodoGrfico.getContentPane().add(txtRestriccionX1);
        
        final JLabel txtRestriccionX2 = new JLabel("0.0");
        txtRestriccionX2.setFont(new Font("Poppins", Font.PLAIN, 14));
        txtRestriccionX2.setBounds(360, 474, 55, 31);
        frmIdoMtodoGrfico.getContentPane().add(txtRestriccionX2);
        
        final JLabel txtRestriccionX3 = new JLabel("0.0");
        txtRestriccionX3.setFont(new Font("Poppins", Font.PLAIN, 14));
        txtRestriccionX3.setBounds(360, 549, 55, 31);
        frmIdoMtodoGrfico.getContentPane().add(txtRestriccionX3);
		
		
		// Evento para generar las restricciones que se usaré dentro del grafico
		JButton btnCalcularRestricciones = new JButton("Restricciones");
		btnCalcularRestricciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Esta acción limpia todos los campos que se ocuparon
				String comprobarCadenaVacia = etxtRY1.getText(); 
				
					if (comprobarCadenaVacia.isEmpty()) { //comprobar si el texto está vacío
						JOptionPane.showMessageDialog(null, "No se pudo completar la acción. Las restricciones no han sido ocupadas.", "", JOptionPane.INFORMATION_MESSAGE); //mostrar mensaje de Nerror
					} else {
				
				// Defino las variables que usaré dentro de esta bloque
				// Para la x & y de la primera restriccion
				
				Double yDeLaRestriccion1 = Double.parseDouble(etxtRY1.getText());
				Double resultadoDeLaRestriccion1y = Double.parseDouble(etxtResRes1.getText());
				Double restriccionDeY1 = resultadoDeLaRestriccion1y / yDeLaRestriccion1;
				
				Double xDeLaRestriccion1 = Double.parseDouble(etxtRX1.getText());
				Double resultadoDeLaRestriccion1x = Double.parseDouble(etxtResRes1.getText());
				Double restriccionDeX1 = resultadoDeLaRestriccion1x / xDeLaRestriccion1;

				// Para la x & y de la segunda restriccion
				
				Double yDeLaRestriccion2 = Double.parseDouble(etxtRY2.getText());
				Double resultadoDeLaRestriccion2y = Double.parseDouble(etxtResRes2.getText());
				Double restriccionDeY2 = resultadoDeLaRestriccion2y / yDeLaRestriccion2;
				
				Double xDeLaRestriccion2 = Double.parseDouble(etxtRX2.getText());
				Double resultadoDeLaRestriccion2x = Double.parseDouble(etxtResRes2.getText());
				Double restriccionDeX2 = resultadoDeLaRestriccion2x / xDeLaRestriccion2;
				
				// Para la x & y de la tercera restriccion
				
				Double yDeLaRestriccion3 = Double.parseDouble(etxtRY3.getText()); // Convierto cadena a double
				Double resultadoDeLaRestriccion3y = Double.parseDouble(etxtResRes3.getText());
				Double restriccionDeY3 = resultadoDeLaRestriccion3y / yDeLaRestriccion3;
				
				Double xDeLaRestriccion3 = Double.parseDouble(etxtRX3.getText());
				Double resultadoDeLaRestriccion3x = Double.parseDouble(etxtResRes3.getText());
				Double restriccionDeX3 = resultadoDeLaRestriccion3x / xDeLaRestriccion3;
				
				// Aquí agrego los valores de x & y cuando valen 0 respectivamente 
				// para obtener los valores que usaré en el gráfico.
				txtRestriccionY1.setText(Double.toString(restriccionDeY1));
				txtRestriccionX1.setText(Double.toString(restriccionDeX1));
				
				txtRestriccionY2.setText(Double.toString(restriccionDeY2));
				txtRestriccionX2.setText(Double.toString(restriccionDeX2));
				
				txtRestriccionY3.setText(Double.toString(restriccionDeY3));
				txtRestriccionX3.setText(Double.toString(restriccionDeX3));
				
				}
			}
		});
		btnCalcularRestricciones.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCalcularRestricciones.setBounds(240, 317, 166, 23);
		frmIdoMtodoGrfico.getContentPane().add(btnCalcularRestricciones);
		
		JLabel lblMtodoGrficoV = new JLabel("Método Gráfico v0.0.1");
		lblMtodoGrficoV.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblMtodoGrficoV.setEnabled(false);
		lblMtodoGrficoV.setBounds(10, 11, 156, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblMtodoGrficoV);
		
		JLabel lblRestriccionesParaEl_1 = new JLabel("Restricciones para el gráfico");
		lblRestriccionesParaEl_1.setFont(new Font("Poppins", Font.BOLD, 14));
		lblRestriccionesParaEl_1.setEnabled(false);
		lblRestriccionesParaEl_1.setBounds(240, 351, 225, 31);
		frmIdoMtodoGrfico.getContentPane().add(lblRestriccionesParaEl_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Pictures\\amlopelon.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programa realizado por Ernesto Amaral Espinoza y Cisneros Orejel Illan I. Luigi. ", "", JOptionPane.INFORMATION_MESSAGE); //mostrar mensaje de Nerror
			}
		});
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnNewButton.setBounds(895, 33, 126, 44);
		frmIdoMtodoGrfico.getContentPane().add(btnNewButton);
        
		///////////////////////
		
        // Crear objeto ChartPanel y agregarlo al panel
        JFreeChart chart = ChartFactory.createXYLineChart(
                "", // título
                "Eje X", // etiqueta del eje x
                "Eje Y", // etiqueta del eje y
                null); // datos
        
        // Crea objetos XYSeriesCollection para los datos de la función objetivo y las restricciones
        
        XYSeriesCollection datasetObjetivo = new XYSeriesCollection();
        XYSeriesCollection datasetRestricciones = new XYSeriesCollection();


        // Agrega los datos de las restricciones a objetos XYSeries
        // Para la primera restriccón
        
        final XYSeries seriesRestriccion1 = new XYSeries("Restricción 1");
        seriesRestriccion1.add(0, 0);
        seriesRestriccion1.add(0, 0);
        datasetRestricciones.addSeries(seriesRestriccion1);

        // Agrega los datos de las restricciones a objetos XYSeries
        // Para la segunda restriccón
        
        final XYSeries seriesRestriccion2 = new XYSeries("Restricción 2");
        seriesRestriccion2.add(0, 0);
        seriesRestriccion2.add(0, 0);
        datasetRestricciones.addSeries(seriesRestriccion2);
        
        // Agrega los datos de las restricciones a objetos XYSeries
        // Para la tercer restriccón
        
        final XYSeries seriesRestriccion3 = new XYSeries("Restricción 3");
        seriesRestriccion3.add(0, 0);
        seriesRestriccion3.add(0, 0);
        datasetRestricciones.addSeries(seriesRestriccion3);

        // Crea objetos XYLineAndShapeRenderer para los datos de la función objetivo y las restricciones
        
        XYLineAndShapeRenderer rendererObjetivo = new XYLineAndShapeRenderer();
        rendererObjetivo.setSeriesPaint(0, Color.BLUE);

        XYLineAndShapeRenderer rendererRestricciones = new XYLineAndShapeRenderer();
        rendererRestricciones.setSeriesPaint(0, Color.BLACK);
        rendererRestricciones.setSeriesShapesVisible(0, false);
        rendererRestricciones.setSeriesFillPaint(0, new Color(255, 255, 255, 100));

        // Agrega los objetos XYSeriesCollection y XYLineAndShapeRenderer al objeto XYPlot
        XYPlot plot1 = chart.getXYPlot();
        plot1.setDataset(0, datasetObjetivo);
        plot1.setRenderer(0, rendererObjetivo);
        plot1.setDataset(1, datasetRestricciones);
        plot1.setRenderer(1, rendererRestricciones);
        
        /*
         * DENTRO DE ESTE BLOQUE PARA EL VALOR DE A PARA CREAR EL POLIGONO
         */
        
        // Crea un objeto JFreeChart utilizando el objeto XYPlot y ajusta el título y los ejes según sea necesario
        JFreeChart chart1 = new JFreeChart("Método gráfico", JFreeChart.DEFAULT_TITLE_FONT, plot1, true);
        chart1.setBackgroundPaint(Color.white);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.RED);
        chartPanel.setBounds(475, 93, 300, 300);
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);
        frmIdoMtodoGrfico.getContentPane().add(chartPanel);
                
        ///////////////////////////////////////////////////////////////////////////////
        
		JButton btnGenerarGrafico = new JButton("Generar gráfico");
		btnGenerarGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		        // Convertir las restricciones X & Y a double para usarlas en las gráficas
		        // Primero las Y
		        
		        String txtResY1 = txtRestriccionY1.getText();
		        final double txtRestriccionY1_double = Double.parseDouble(txtResY1);
		        
		        String txtResY2 = txtRestriccionY2.getText();
		        final double txtRestriccionY2_double = Double.parseDouble(txtResY2);
		        
		        String txtResY3 = txtRestriccionY3.getText();
		        final double txtRestriccionY3_double = Double.parseDouble(txtResY3);
		        
		        // Ahora las X
		        
		        String txtResX1 = txtRestriccionX1.getText();
		        final double txtRestriccionX1_double = Double.parseDouble(txtResX1);
		        
		        String txtResX2 = txtRestriccionX2.getText();
		        final double txtRestriccionX2_double = Double.parseDouble(txtResX2);
		        
		        String txtResX3 = txtRestriccionX3.getText();
		        final double txtRestriccionX3_double = Double.parseDouble(txtResX3);
				
		        // Actualizamos la grafica a los nuevos valores dependiendo de 
		        // las funciones
		        
				seriesRestriccion1.clear(); // Limpiamos antiguos valores
				seriesRestriccion2.clear(); // Limpiamos antiguos valores
				seriesRestriccion3.clear(); // Limpiamos antiguos valores
				seriesRestriccion1.add(0.0, txtRestriccionY1_double); 
				seriesRestriccion1.add(txtRestriccionX1_double, 0.0); 
				seriesRestriccion2.add(0.0, txtRestriccionY2_double);
				seriesRestriccion2.add(txtRestriccionX2_double, 0.0);
				seriesRestriccion3.add(0.0, txtRestriccionY3_double);
				seriesRestriccion3.add(txtRestriccionX3_double, 0.0);

			}
		});
		btnGenerarGrafico.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGenerarGrafico.setBounds(240, 582, 175, 23);
		frmIdoMtodoGrfico.getContentPane().add(btnGenerarGrafico);
		
		JLabel txtTitleZ = new JLabel("Conocer el valor de Z");
		txtTitleZ.setFont(new Font("Poppins", Font.BOLD, 14));
		txtTitleZ.setEnabled(false);
		txtTitleZ.setBounds(672, 402, 225, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtTitleZ);
		
		JLabel txtSubTitle = new JLabel("Para la segunda restricción");
		txtSubTitle.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtSubTitle.setEnabled(false);
		txtSubTitle.setBounds(671, 420, 194, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtSubTitle);
		
		JLabel txtParaA = new JLabel("A(0,0) = ");
		txtParaA.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtParaA.setEnabled(false);
		txtParaA.setBounds(681, 462, 71, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtParaA);
		
		JLabel txtParaB = new JLabel("B(0,0) = ");
		txtParaB.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtParaB.setEnabled(false);
		txtParaB.setBounds(681, 483, 71, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtParaB);
		
		JLabel txtParaC = new JLabel("C(0,0) = ");
		txtParaC.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtParaC.setEnabled(false);
		txtParaC.setBounds(681, 504, 71, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtParaC);
		
		JLabel txtParaD = new JLabel("D(0,0) = ");
		txtParaD.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtParaD.setEnabled(false);
		txtParaD.setBounds(681, 525, 71, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtParaD);
		
		final JLabel txtRestriccionDeXA = new JLabel("0");
		txtRestriccionDeXA.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtRestriccionDeXA.setBounds(740, 462, 300, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtRestriccionDeXA);
		
		final JLabel txtRestriccionDeXB = new JLabel("0");
		txtRestriccionDeXB.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtRestriccionDeXB.setBounds(740, 483, 300, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtRestriccionDeXB);
		
		final JLabel txtRestriccionDeXC = new JLabel("0");
		txtRestriccionDeXC.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtRestriccionDeXC.setBounds(740, 504, 300, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtRestriccionDeXC);
		
		final JLabel txtRestriccionDeXD = new JLabel("0");
		txtRestriccionDeXD.setFont(new Font("Poppins", Font.PLAIN, 14));
		txtRestriccionDeXD.setBounds(740, 525, 300, 31);
		frmIdoMtodoGrfico.getContentPane().add(txtRestriccionDeXD);
		
		final JLabel lblZA = new JLabel("");
		lblZA.setBounds(662, 468, 16, 16);
		frmIdoMtodoGrfico.getContentPane().add(lblZA);
		
		final JLabel lblZB = new JLabel("");
		lblZB.setBounds(662, 491, 16, 16);
		frmIdoMtodoGrfico.getContentPane().add(lblZB);
		
		final JLabel lblZD = new JLabel("");
		lblZD.setBounds(662, 532, 16, 16);
		frmIdoMtodoGrfico.getContentPane().add(lblZD);
		
		final JLabel lblC = new JLabel("");
		lblC.setBackground(Color.RED);
		lblC.setBounds(662, 512, 16, 16);
		frmIdoMtodoGrfico.getContentPane().add(lblC);
		
		// Botón para generar los valores de los puntos dentro de las restricciones
		// para saber el valor de Z
		
		JButton btnCalcularZ = new JButton("Encontrar Z");
		btnCalcularZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (rbtnMaximizar.isSelected()) {
					
				
				// Dentro de estas variables se almacenan los valores de los puntos dentro
				// de la gráfica para el primer punto que es la A
				
				Double valorXA = 0.0;
				Double valorYA = 0.0;
				
					// Dentro de estas variables esta la X & Y de la función objetivo
				
					Double x = Double.parseDouble(etxtX.getText());
					Double y = Double.parseDouble(etxtY.getText());	
					
					/* En este bloque realizo la multiplicación de la X 
					   de la función objetivo y de lo valor del punto A */
				
					Double valorAX = x * valorXA;
					Double valorAY = y * valorYA;
					Double resultadoDoubleA = valorAX + valorAY;

					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					
					
					// Dentro de estas variables se almacenan los valores de los puntos dentro
					// de la gráfica para el primer punto que es la A
					
					Double valorXB = 0.0;
					Double valorYB = 70.0;
						
						
						/* En este bloque realizo la multiplicación de la X 
						   de la función objetivo y de lo valor del punto A */
					
							Double valorBX = x * valorXB;
							Double valorBY = y * valorYB;
							Double resultadoDoubleB = valorBX + valorBY;
				
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						
						
						// Dentro de estas variables se almacenan los valores de los puntos dentro
						// de la gráfica para el primer punto que es la A
						
						Double valorXC = 50.0;
						Double valorYC = 45.0;
						
							
							/* En este bloque realizo la multiplicación de la X 
							   de la función objetivo y de lo valor del punto A */
						
								Double valorCX = x * valorXC;
								Double valorCY = y * valorYC;
								Double resultadoDoubleC = valorCX + valorCY;
				
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							
							
							// Dentro de estas variables se almacenan los valores de los puntos dentro
							// de la gráfica para el primer punto que es la A
							
							Double valorXD = 80.0;
							Double valorYD = 0.0;
							
								
								/* En este bloque realizo la multiplicación de la X 
								   de la función objetivo y de lo valor del punto A */
							
									Double valorDX = x * valorXD;
									Double valorDY = y * valorYD;
									Double resultadoDoubleD = valorDX + valorDY;

				
				txtRestriccionDeXA.setText(x + "(" + valorYA + ") + " + y + "(" + valorXA + ") = " + resultadoDoubleA + "");
				txtRestriccionDeXB.setText(x + "(" + valorYB + ") + " + y + "(" + valorXB + ") = " + resultadoDoubleB + "");
				txtRestriccionDeXC.setText(x + "(" + valorYD + ") + " + y + "(" + valorXC + ") = " + resultadoDoubleC + "");
				txtRestriccionDeXD.setText(x + "(" + valorYC + ") + " + y + "(" + valorXD + ") = " + resultadoDoubleD + "");

				
				Double valorDeZ = Double.MIN_VALUE; // Inicializar con el valor mínimo posible

				if (resultadoDoubleA >= valorDeZ) {
				    valorDeZ = resultadoDoubleA;
				    lblZA.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}
				if (resultadoDoubleB >= valorDeZ) {
				    valorDeZ = resultadoDoubleB;
				    lblZB.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}
				if (resultadoDoubleC >= valorDeZ) {
				    valorDeZ = resultadoDoubleC;
				    lblC.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				    lblZB.setIcon(new ImageIcon(""));
				}
				if (resultadoDoubleD >= valorDeZ) {
				    valorDeZ = resultadoDoubleD;
				    lblZD.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}
			  } else if (rbtnMinimizar.isSelected()) {
				  
				// Ahora empieza para ver si es de minimizacióin
				// Dentro de estas variables se almacenan los valores de los puntos dentro
				// de la gráfica para el primer punto que es la A
				
				Double valorXA = 0.0;
				Double valorYA = 0.0;
				
					// Dentro de estas variables esta la X & Y de la función objetivo
				
					Double x = Double.parseDouble(etxtX.getText());
					Double y = Double.parseDouble(etxtY.getText());	
					
					/* En este bloque realizo la multiplicación de la X 
					   de la función objetivo y de lo valor del punto A */
				
					Double valorAX = x * valorXA;
					Double valorAY = y * valorYA;
					Double resultadoDoubleA = valorAX + valorAY;

					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					// PARA LA VARIABLE B
					
					
					// Dentro de estas variables se almacenan los valores de los puntos dentro
					// de la gráfica para el primer punto que es la A
					
					Double valorXB = 0.0;
					Double valorYB = 70.0;
						
						
						/* En este bloque realizo la multiplicación de la X 
						   de la función objetivo y de lo valor del punto A */
					
							Double valorBX = x * valorXB;
							Double valorBY = y * valorYB;
							Double resultadoDoubleB = valorBX + valorBY;
				
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						// PARA LA VARIABLE C
						
						
						// Dentro de estas variables se almacenan los valores de los puntos dentro
						// de la gráfica para el primer punto que es la A
						
						Double valorXC = 50.0;
						Double valorYC = 45.0;
						
							
							/* En este bloque realizo la multiplicación de la X 
							   de la función objetivo y de lo valor del punto A */
						
								Double valorCX = x * valorXC;
								Double valorCY = y * valorYC;
								Double resultadoDoubleC = valorCX + valorCY;
				
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							// PARA LA VARIABLE C
							
							
							// Dentro de estas variables se almacenan los valores de los puntos dentro
							// de la gráfica para el primer punto que es la A
							
							Double valorXD = 80.0;
							Double valorYD = 0.0;
							
								
								/* En este bloque realizo la multiplicación de la X 
								   de la función objetivo y de lo valor del punto A */
							
									Double valorDX = x * valorXD;
									Double valorDY = y * valorYD;
									Double resultadoDoubleD = valorDX + valorDY;

				
				txtRestriccionDeXA.setText(x + "(" + valorYA + ") + " + y + "(" + valorXA + ") = " + resultadoDoubleA + "");
				txtRestriccionDeXB.setText(x + "(" + valorYB + ") + " + y + "(" + valorXB + ") = " + resultadoDoubleB + "");
				txtRestriccionDeXC.setText(x + "(" + valorYD + ") + " + y + "(" + valorXC + ") = " + resultadoDoubleC + "");
				txtRestriccionDeXD.setText(x + "(" + valorYC + ") + " + y + "(" + valorXD + ") = " + resultadoDoubleD + "");

				
				Double valorDeZ = resultadoDoubleA;

				if (resultadoDoubleB < valorDeZ) {
				    valorDeZ = resultadoDoubleB;
				    lblZB.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}

				if (resultadoDoubleC < valorDeZ) {
				    valorDeZ = resultadoDoubleC;
				    lblC.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}

				if (resultadoDoubleD < valorDeZ) {
				    valorDeZ = resultadoDoubleD;
				    lblZD.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}

				if (resultadoDoubleA < valorDeZ) {
				    valorDeZ = resultadoDoubleA;
				    lblZA.setIcon(new ImageIcon("C:\\Users\\Ernesto Amaral\\Downloads\\x-button (1).png"));
				}


			  } else {
					JOptionPane.showMessageDialog(null, "Error al encontrar el valor de Z, debe seleccionar un objetivo en específico.", "", JOptionPane.INFORMATION_MESSAGE);
			  }
			}
		});
		btnCalcularZ.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCalcularZ.setBounds(740, 592, 175, 23);
		frmIdoMtodoGrfico.getContentPane().add(btnCalcularZ);
		
		final JPanel nuevasRestricciones = new JPanel();
		nuevasRestricciones.setBounds(10, 470, 200, 151);
		frmIdoMtodoGrfico.getContentPane().add(nuevasRestricciones);
		nuevasRestricciones.setLayout(new GridLayout(0,1));
		
		// Estas serán las nuevas restricciones que se agregarán con el botón de abajo
		
		final JComboBox<String> cboxInecuacionRNUEVAS = new JComboBox<String>();
		cboxInecuacionRNUEVAS.setBounds(138, 434, 45, 22);
		frmIdoMtodoGrfico.getContentPane().add(cboxInecuacionRNUEVAS);
		cboxInecuacionRNUEVAS.addItem(">=");
		cboxInecuacionRNUEVAS.addItem("<=");
		cboxInecuacionRNUEVAS.addItem("=");

		txtNuevasX = new JTextField();
		txtNuevasX.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtNuevasX.setColumns(10);
		txtNuevasX.setBounds(10, 435, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(txtNuevasX);
		
		txtNuevasY = new JTextField();
		txtNuevasY.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtNuevasY.setColumns(10);
		txtNuevasY.setBounds(82, 435, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(txtNuevasY);
		
		JLabel xmas3_1 = new JLabel("x +");
		xmas3_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		xmas3_1.setBounds(55, 431, 31, 29);
		frmIdoMtodoGrfico.getContentPane().add(xmas3_1);
		
		JLabel yequal3_1 = new JLabel("y");
		yequal3_1.setFont(new Font("Poppins", Font.PLAIN, 14));
		yequal3_1.setBounds(125, 431, 19, 29);
		frmIdoMtodoGrfico.getContentPane().add(yequal3_1);
		
		txtNuevosResultados = new JTextField();
		txtNuevosResultados.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtNuevosResultados.setColumns(10);
		txtNuevosResultados.setBounds(187, 435, 38, 20);
		frmIdoMtodoGrfico.getContentPane().add(txtNuevosResultados);
		
		
		ArrayList<JLabel> listaRestricciones = new ArrayList<>();
		
		JButton btnNuevaRestriccion = new JButton("Agregar restricción");
		btnNuevaRestriccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * VERIFICAR SI DENTRO DE LAS CAJAS DE TEXTO DE X, Y & RESULTADO ESTAN VACIAS
				 */
				String comprobarEspacioVacioX = txtNuevasX.getText();
				String comprobarEspacioVacioY = txtNuevasY.getText();
				String comprobarEspacioVacioR = txtNuevosResultados.getText();

				/*
				 * IR VERIFICANDO POR X, Y & RESULTADO SI ESTA VACIO, SI LO ES, O
				 */
					if (comprobarEspacioVacioX.isEmpty()) { // En esta parte debe verificar cadenas vacias
						JOptionPane.showMessageDialog(null, "Error al capturar una nueva restricción, debe rellenar el campo de X.", "", JOptionPane.INFORMATION_MESSAGE);
					} else if (comprobarEspacioVacioY.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error al capturar una nueva restricción, debe rellenar el campo de Y.", "", JOptionPane.INFORMATION_MESSAGE);
					} else if (comprobarEspacioVacioR.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error al capturar una nueva restricción, debe rellenar el campo de resultado.", "", JOptionPane.INFORMATION_MESSAGE);
					} else {
				
						String nuevasX = txtNuevasX.getText();
						String nuevasY = txtNuevasY.getText();
						String nuevasR = txtNuevosResultados.getText();
						
						JLabel lblNuevasRestricciones = new JLabel( "" + nuevasX + "x + " + nuevasY + "y " + cboxInecuacionRNUEVAS.getSelectedItem() + " " + nuevasR + "");
						nuevasRestricciones.getRootPane().add(lblNuevasRestricciones);
						lblNuevasRestricciones.setFont(new Font("Poppins", Font.PLAIN, 14));
						nuevasRestricciones.getRootPane().validate();
						nuevasRestricciones.getRootPane().repaint();
						nuevasRestricciones.add(lblNuevasRestricciones);
						listaRestricciones.add(lblNuevasRestricciones); // Agregar al ArrayList

					
			  }
			}
		});
		btnNuevaRestriccion.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnNuevaRestriccion.setBounds(10, 400, 215, 23);
		frmIdoMtodoGrfico.getContentPane().add(btnNuevaRestriccion);
	}
}
