import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Subnet.claseA;
import Subnet.claseB;
import Subnet.claseC;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;

public class Interfaz {
	public String mensajeError="";
	String [] oct = new String [4];
	Boolean errorMain=false;
	public String aux;
	claseA ipA = null;
	claseB ipB = null;
	claseC ipC = null;
	Ventana2 newframe = null;
	
	
	int opcion=0;
    private JFrame frame;
    private JTextField TextoIP;
    private JRadioButton BotonSubred, BotonHost;
    private ButtonGroup buttonGroup;
    private JLabel lblSeleccionaUnaOpcin;
    private JLabel TextoCambiar;
    private JTextField IngresarSubredes;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz window = new Interfaz();
                    window.frame.setVisible(true);
               } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Interfaz() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(238, 238, 238));
        frame.setBounds(100, 100, 476, 623);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton BotonCalcular = new JButton("CALCULAR");
        BotonCalcular.setForeground(Color.WHITE);
        BotonCalcular.setBackground(new Color(60, 179, 113));
        BotonCalcular.setFont(new Font("Tahoma", Font.PLAIN, 30));
        BotonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ABRIR VENTANA DESPUES DE DARLE EN CALULAR
            	oct[0]="";
            	oct[1]="";
            	oct[2]="";
            	oct[3]="";
            	String IP=TextoIP.getText();
            	if(BotonSubred.isSelected()) {
            		opcion=1;
            	}else if(BotonHost.isSelected()) {
            		opcion=2;
            	}
            	int j=0;
            	int ingresados=Integer.parseInt(IngresarSubredes.getText());
        		for (int i=0; i<IP.length();i++) {
        			if(IP.charAt(i)=='.') {
        				j++;
        					if (j>3) {

        						break;
        						
        					}
        			}else {
        				if(Character.isDigit(IP.charAt(i))) {
        					oct[j]+=IP.charAt(i);	
        				} else {
        					mensajeError="La IP es incorrecta, intentelo de nuevo";
        					errorMain=true;
        				}
        				
        			}
        		}
        		int octal1=Integer.parseInt(oct[0]);
        		if(octal1>0 && octal1<128) {
        			ipA= new claseA(IP, opcion, ingresados);
        			if(!ipA.ErrorIP) {
        				if(opcion==1) {
        					ipA.calcular_subredes();
        					ipA.calcular_hostxsubred();
        					ipA.calcular_nuevaMascara();
        					if(!ipA.ErrorIP) {
        						aux=ipA.aux;
        						ipA.escribir_rangos();
        						newframe= new Ventana2(aux);
        						newframe.setVisible(true);
        					}else {
        						mensajeError=ipA.msgError;
        						VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        						nuevoframe.setVisible(true);
        						
        					}	
        				}else if(opcion==2) {
        					ipA.calcular_hostxsubred();
        					ipA.calcular_subredes();
        					ipA.calcular_nuevaMascara();
        					if(!ipA.ErrorIP) {
        						aux=ipA.aux;
        						ipA.escribir_rangos();	
        						newframe= new Ventana2(aux);
        						newframe.setVisible(true);
        					}else {
        						mensajeError=ipA.msgError;
        						VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        						nuevoframe.setVisible(true);
        					}		
        				}
        			}else {
						mensajeError=ipA.msgError;
						VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
						nuevoframe.setVisible(true);
					}		
        		}else if(octal1>=128 && octal1<192) {
        			 ipB= new claseB(IP, opcion, ingresados);
        				if(!ipB.ErrorIP) {
        					if(opcion==1) {
        						ipB.calcular_subredes();
        						ipB.calcular_hostxsubred();
        						ipB.calcular_nuevaMascara();
        						if(!ipB.ErrorIP) {
        							aux=ipB.aux;
        							ipB.escribir_rangos();
            						newframe= new Ventana2(aux);
            						newframe.setVisible(true);
        						}else {
        							mensajeError=ipB.msgError;
        							VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        							nuevoframe.setVisible(true);
        						}	
        					}else if(opcion==2) {
        						ipB.calcular_hostxsubred();
        						ipB.calcular_subredes();
        						ipB.calcular_nuevaMascara();
        						if(!ipB.ErrorIP) {
        							aux=ipB.aux;
        							ipB.escribir_rangos();	
            						newframe= new Ventana2(aux);
            						newframe.setVisible(true);
        						}else {
        							mensajeError=ipB.msgError;
        							VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        							nuevoframe.setVisible(true);
        						}
        							
        					}
        				}else {
    						mensajeError=ipB.msgError;
    						VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
    						nuevoframe.setVisible(true);
    					}		
        		}else if(octal1>=192 && octal1<224) {
        			 ipC= new claseC(IP, opcion, ingresados);
        				if(!ipC.ErrorIP) {
        					if(opcion==1) {
        						ipC.calcular_subredes();
        						ipC.calcular_hostxsubred();
        						ipC.calcular_nuevaMascara();
        						if(!ipC.ErrorIP) {
        							aux=ipC.aux;
        							ipC.escribir_rangos();	
            						newframe= new Ventana2(aux);
            						newframe.setVisible(true);
        						}else {
        							mensajeError=ipC.msgError;
        							VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        							nuevoframe.setVisible(true);
        						}		
        					}else if(opcion==2) {
        						ipC.calcular_hostxsubred();
        						ipC.calcular_subredes();
        						ipC.calcular_nuevaMascara();
        						if(!ipC.ErrorIP) {
        							aux=ipC.aux;
        							ipC.escribir_rangos();	
            						newframe= new Ventana2(aux);
            						newframe.setVisible(true);
        						}else {
        							mensajeError=ipC.msgError;
        							VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        							nuevoframe.setVisible(true);
        						}
        							
        					}
        					
        				}else {
    						mensajeError=ipC.msgError;
    						VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
    						nuevoframe.setVisible(true);
    					}		
        				
        		}
            	// CREO LA VENTANA
                
        		if(errorMain) {
        			VentanaDeError nuevoframe = new VentanaDeError(mensajeError);
        			nuevoframe.setVisible(true);
        		}
                // HAGO "VISIBLE LA VENTANA" CUANDO LE DOY CLICK EN CALCULAR
                
                
                //
            }
        });
        
        BotonCalcular.setBounds(94, 493, 235, 62);
        frame.getContentPane().add(BotonCalcular);

        JLabel lblNewLabel = new JLabel("IP:");
        lblNewLabel.setForeground(new Color(60, 179, 113));
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblNewLabel.setBounds(61, 42, 44, 30);
        frame.getContentPane().add(lblNewLabel);

        TextoIP = new JTextField();
        TextoIP.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        TextoIP.setBounds(61, 82, 332, 51);
        frame.getContentPane().add(TextoIP);
        TextoIP.setColumns(10);

        BotonSubred = new JRadioButton("Subredes");
        BotonSubred.setBackground(new Color(238, 238, 238));
        BotonSubred.setForeground(Color.BLACK);
        BotonSubred.setFont(new Font("Tahoma", Font.PLAIN, 21));
        BotonSubred.setBounds(61, 210, 212, 42);
        frame.getContentPane().add(BotonSubred);

        BotonHost = new JRadioButton("Host x Subred");
        BotonHost.setBackground(new Color(245, 245, 245));
        BotonHost.setFont(new Font("Tahoma", Font.PLAIN, 21));
        BotonHost.setBounds(61, 254, 199, 30);
        frame.getContentPane().add(BotonHost);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(BotonSubred);
        buttonGroup.add(BotonHost);

        lblSeleccionaUnaOpcin = new JLabel("Selecciona una opción:");
        lblSeleccionaUnaOpcin.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        lblSeleccionaUnaOpcin.setForeground(new Color(70, 130, 180));
        lblSeleccionaUnaOpcin.setBounds(61, 174, 354, 30);
        frame.getContentPane().add(lblSeleccionaUnaOpcin);
        
        TextoCambiar = new JLabel("Cantidad de Subredes:");
        TextoCambiar.setForeground(SystemColor.textHighlight);
        TextoCambiar.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        TextoCambiar.setBounds(61, 331, 391, 51);
        frame.getContentPane().add(TextoCambiar);
        
        IngresarSubredes = new JTextField();
        IngresarSubredes.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        IngresarSubredes.setColumns(10);
        IngresarSubredes.setBounds(61, 396, 332, 51);
        frame.getContentPane().add(IngresarSubredes);
        
        BotonSubred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TextoCambiar.setText("Cantidad de Subredes:");
                BotonHost.setSelected(false);
            }
        });
        
        BotonHost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TextoCambiar.setText("Cantidad de Host x Subred:");
                BotonSubred.setSelected(false);
            }
        });

        BotonSubred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BotonHost.setSelected(false);
            }
        });
    }
}