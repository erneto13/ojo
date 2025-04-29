package Subnet;
import java.io.*;
public class claseA {
	String [] octetos=new String [4];
	public int oct1, oct2, oct3, oct4;
	public String mascara, msgError;
	public boolean ErrorIP;
	public double bits_ocupados=0, bits_hxs=0;
	public int opc; //opc 1= calcular por numero de subredes
	public String aux;
	//opc 2= calcular hosts*subred
	public int subredes, hostxsubred;
	public claseA(String ip, int opchost, int host) {
		//Dividir ip en octetos dependiendo de la posicion de los puntos 
	octetos[0]="";
	octetos[1]="";
	octetos[2]="";
	octetos[3]="";

		int j=0;
		for (int i=0; i<ip.length();i++) {
			if(ip.charAt(i)=='.') {
				j++;
					if (j>3) {
						ErrorIP=true; //Se genera un error en la IP
						msgError="La IP es incorrecta, intentelo de nuevo";
						break;
						
					}
			}else {
				if(Character.isDigit(ip.charAt(i))) {
					octetos[j]+=ip.charAt(i);	
				} else {
					msgError="La IP es incorrecta, intentelo de nuevo";
					ErrorIP=true;
				}
				
			}
		}
		if (ErrorIP!=true) {
			oct1=Integer.parseInt(octetos[0]);
			oct2=Integer.parseInt(octetos[1]);
			oct3=Integer.parseInt(octetos[2]);
			oct4=Integer.parseInt(octetos[3]);
			if(oct2!=0) {
				ErrorIP=true;
				msgError="La IP es incorrecta, intentelo de nuevo";
			}
			if(oct3!=0) {
				ErrorIP=true;
				msgError="La IP es incorrecta, intentelo de nuevo";
			}
			if(oct4!=0) {
				ErrorIP=true;
				msgError="La IP es incorrecta, intentelo de nuevo";
			}
		}
		if (opchost==1) {
			subredes=host;
		}else if (opchost==2) {
			hostxsubred=host;
		}
		opc=opchost;
	}
	public int calcular_subredes() {
		

/* Aqui se trabaja cuando sabemos el numero de subredes requeridas
Sacamos el numero de subredes calculando un numero 2 a la n hasta que sea mayor a las subredes
que requiera el usuario 
*/
		if(opc==1) {
			
		double subredess;
			bits_ocupados=0;
			double subredes_solicitadas=subredes;
			do {
				subredess=Math.pow(2, bits_ocupados);
				bits_ocupados++;
			}while(subredess<subredes_solicitadas+2);
			bits_ocupados--;
			subredes=(int)subredess;
			//Obtenemos el total de subredes dependiendo de las que el usuario haya ingresado
			//Lo guardamos en subredes
			
			
			//Con esto, obtenemos a su vez el numero de bits ocupados para poder rellenar en la mascara
			//correspondiente, lo guardamos en bits_ocupados
			//Si se ocuparon mas de 24 bits, entonces podemos decir que la cantidad de subredes es imposible.
			if (bits_ocupados>24) {
				ErrorIP=true;
				msgError="La cantidad de subredes supera el numero posible";
			}
		}else {
			bits_ocupados=24-bits_hxs;
			double subredess;
			subredess=Math.pow(2, 24-bits_hxs);
			subredes=(int)subredess;
		}
if (subredes>16777216) {
	ErrorIP=true;
	msgError="La cantidad de subredes supera el numero posible";
}
	return subredes;
}
	public int calcular_hostxsubred() {
	
	/*Aqui se trabaja conociendo el numero de host x subred minimos que requiere el usuario
		
*/	
		if(opc==2) {
			double hxs;
			double hostxsubred_solicitados=hostxsubred;
			do {
				hxs=Math.pow(2, bits_hxs);
				bits_hxs++;
			}while(hxs<hostxsubred_solicitados+2);
			bits_hxs--;
			hostxsubred=(int)hxs;
			if (bits_hxs>24) { //Si se ocuparon mas de 24 bits, entonces podemos decir que la cantidad de subredes es imposible.
				ErrorIP=true;
				msgError="La cantidad de host x subred supera el numero posible";
			}
		}
		else {
			double hxs;
			hxs=Math.pow(2,24-bits_ocupados);
			hostxsubred=(int)hxs;
		}
		if (hostxsubred>16777216) {
			ErrorIP=true;
			msgError="La cantidad de host x subred supera el numero posible";
		}
		return hostxsubred;	
}
	public String calcular_nuevaMascara() {
		int moct1=255, moct2=0, moct3=0, moct4=0;
		double aux=0;
		int i=7, vueltas=0;
		if(bits_ocupados>=0 && bits_ocupados<=8) {
			do {
				aux+=Math.pow(2,i);
				i--;
				vueltas++;
				
			}while(vueltas<bits_ocupados);
			moct2=(int)aux;
		}else if(bits_ocupados>=9 && bits_ocupados<=16) {
			aux=0;
			moct2=255;
			bits_ocupados-=8;
			do {
				aux+=Math.pow(2,i);
				i--;
				vueltas++;
			}while(vueltas!=bits_ocupados);
			moct3=(int)aux;
		}else if(bits_ocupados>=17 && bits_ocupados<=24) {
			moct2=255;
			moct3=255;
			aux=0;
			bits_ocupados-=16;
			do {
				aux+=Math.pow(2,i);
				i--;
				vueltas++;
			}while(vueltas!=bits_ocupados);
			moct4=(int)aux;
		}
		mascara=moct1+"."+moct2+"."+moct3+"."+moct4;
		return mascara;
	}
	public void escribir_rangos() {
		aux="IP "+oct1+"-"+oct2+"-"+oct3+"-"+oct4+".txt";
		int subred=1; //Numero de subred que se va a poner
		int [] octales= new int[9]; //Lugar donde se van a almacenar los distintos octales que perteneceran 
		for (int i=0;i<9;i++) {
			octales[i]=0;
		}
		octales[0]=oct1;
		octales[4]=oct1;
		octales[3]=-1;
		//a los rangos
		/*
		 Dada la cadena de la siguiente forma:
		 pw.println("Subred "+subred+": "+octales[0]+"."+octales[1]+"."+octales[2]+"."+octales[3]+"-"+octales[4]+"."+octales[5]+"."+octales[6]+"."+octales[7])
		  donde siempre octales 0 y 4 seran el valor de oct1
		  */
		
		File rangos = new File (aux);
		try {
			if(!rangos.exists()) {
				
					rangos.createNewFile();
					}
		            PrintWriter pw = new PrintWriter(rangos);
		            BufferedWriter bw = new BufferedWriter(pw);
		            pw.println("IP: "+oct1+"."+oct2+"."+oct3+"."+oct4+"\n");
		            pw.println("Subredes: "+subredes+"\t Hosts por subred: "+hostxsubred+"\n");
		            pw.println("Nueva mascara: "+mascara+"\n");
		            pw.println("Rangos: ");
		            int division=0;
		            int residuo=0;
		            int residuo2=0;
		            int division2=0;
		            int suma=hostxsubred;
		            int suma1=hostxsubred-1;
		            if(suma<256) {
		            	
		            }else if(suma>=256 && suma<65536) {
		            	division=suma/256;
		            	residuo=suma%256;
		            }else if(suma>=65536) {
		            	division=suma/65536;
		            	residuo=suma%65536;
		            	division2=residuo/256;
		            	residuo2=residuo%256;
		            }
		            for (subred=1;subred<=subredes;subred++) {
		            	octales[1]=octales[5];
		            	octales[2]=octales[6];
		            	octales[3]=octales[7];
		            	if(subred!=1) {
		            		octales[3]++;
		            	}

		            	if(octales[3]>255) {
		            		octales[2]++;
		            		octales[3]-=256;
		            	}
		            	if(octales[2]>255) {
		            		octales[1]++;
		            		octales[2]-=256;
		            	}
		            if(subred!=1) {
		            	if(suma<256) {
		            		octales[7]+=suma;
		                	if(octales[7]>255) {
		                		octales[6]++;
		                		octales[7]-=256;
		                	}
		                	if(octales[6]>255) {
		                		octales[5]++;
		                		octales[6]-=256;
		                	}
		            	}else if(suma>=256 && suma<65536) {

		            		octales[6]+=division;
		            		octales[7]+=residuo;
		                	if(octales[7]>255) {
		                		octales[6]++;
		                		octales[7]-=256;
		                	}
		                	if(octales[6]>255) {
		                		octales[5]++;
		                		octales[6]-=256;
		                	}
		            	}else if(suma>=65536) {

		            		System.out.println(residuo);
		            		octales[5]+=division;

		            		octales[6]+=division2;

		            		octales[7]+=residuo2;
		                	if(octales[7]>255) {
		                		octales[6]++;
		                		octales[7]-=256;
		                	}
		                	if(octales[6]>255) {
		                		octales[5]++;
		                		octales[6]-=256;
		                	}
		            	}

		            }else {
		            	if(suma<256) {
		            		octales[7]+=suma-1;
		                	if(octales[7]>255) {
		                		octales[6]++;
		                		octales[7]-=256;
		                	}
		                	if(octales[6]>255) {
		                		octales[5]++;
		                		octales[6]-=256;
		                	}
		            	}else if(suma>=256 && suma<65536) {

		            		octales[6]+=(suma-1)/256;
		            		octales[7]+=(suma-1)%256;
		                	if(octales[7]>255) {
		                		octales[6]++;
		                		octales[7]-=256;
		                	}
		                	if(octales[6]>255) {
		                		octales[5]++;
		                		octales[6]-=256;
		                	}
		            	}else if(suma1>=65536) {

		            		System.out.println(residuo);
		            		octales[5]+=(suma-1)/65536;
			            	
			            	
		            		octales[6]+=((suma-1)%65536)/256;

		            		octales[7]+=((suma-1)%65536)%256;
		                	if(octales[7]>255) {
		                		octales[6]++;
		                		octales[7]-=256;
		                	}
		                	if(octales[6]>255) {
		                		octales[5]++;
		                		octales[6]-=256;
		                	}
		            	}
		            }
	

		        			pw.println("Subred "+subred+": "+octales[0]+"."+octales[1]+"."+octales[2]+"."+octales[3]+" - "+octales[4]+"."+octales[5]+"."+octales[6]+"."+octales[7]);
		        			
		        		}
		            
		            
		            bw.close();
			}
				 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}