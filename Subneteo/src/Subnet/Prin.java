package Subnet;
import java.io.*;

public class Prin {

	public static void main(String[] args) {
		Boolean errorMain=false;
		String mensajeError="";
		claseA ipA=null;
		claseB ipB=null;
		claseC ipC=null;
		int opcion=1;
		int ingresados=16000000;
		String [] oct= new String[4];
		// TODO Auto-generated method stub
		String IP="10.0.0.0";
		oct[0]="";
		oct[1]="";
		oct[2]="";
		oct[3]="";
		int j=0;
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
					System.out.println(mensajeError="La IP es incorrecta, intentelo de nuevo");
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
						ipA.escribir_rangos();
						System.out.println("Creada correctamente");
					}else {
						System.out.println("Error");
					}	
				}else if(opcion==2) {
					ipA.calcular_hostxsubred();
					ipA.calcular_subredes();
					ipA.calcular_nuevaMascara();
					if(!ipA.ErrorIP) {
						ipA.escribir_rangos();	
						System.out.println("Creada correctamente");
					}else {
						System.out.println("Error");
					}		
				}
			}
		}else if(octal1>=128 && octal1<192) {
			 ipB= new claseB(IP, opcion, ingresados);
				if(!ipB.ErrorIP) {
					if(opcion==1) {
						ipB.calcular_subredes();
						ipB.calcular_hostxsubred();
						ipB.calcular_nuevaMascara();
						if(!ipB.ErrorIP) {
							ipB.escribir_rangos();
							System.out.println("Creada correctamente");
						}else {
							System.out.println("Error");
						}	
					}else if(opcion==2) {
						ipB.calcular_hostxsubred();
						ipB.calcular_subredes();
						ipB.calcular_nuevaMascara();
						if(!ipB.ErrorIP) {
							ipB.escribir_rangos();	
							System.out.println("Creada correctamente");
						}else {
							System.out.println("Error");
						}
							
					}
				}
		}else if(octal1>=192 && octal1<224) {
			 ipC= new claseC(IP, opcion, ingresados);
				if(!ipC.ErrorIP) {
					if(opcion==1) {
						ipC.calcular_subredes();
						ipC.calcular_hostxsubred();
						ipC.calcular_nuevaMascara();
						if(!ipC.ErrorIP) {
							ipC.escribir_rangos();	
							System.out.println("Creada correctamente");
						}else {
							System.out.println("Error");
						}		
					}else if(opcion==2) {
						ipC.calcular_hostxsubred();
						ipC.calcular_subredes();
						ipC.calcular_nuevaMascara();
						if(!ipC.ErrorIP) {
							ipC.escribir_rangos();	
							System.out.println("Creada correctamente");
						}else {
							System.out.println("Error");
						}
							
					}
				}
				
		}



		

		
		
		}
	}


