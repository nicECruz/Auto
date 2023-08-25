package AutoConParametro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ProcesadorDebito {

	public static void procesarArchivoD(String nombreArchivoEntrada1,String nombreArchivoSalida, String nombreArchivoEntrada2) {
        try (BufferedReader br1 = new BufferedReader(new FileReader(nombreArchivoEntrada1));
             BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivoEntrada2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {
        	String line;
        	String linea2;
            String line2;
            String lineA;
            String lineB;
            int contador=0;
            int contador1=0;
            String CuotaAux="";
            int CuotaNumI;
            int CuotaNumD;
            String CodBonifAnual1;
        	String PorcBonifAnual1;
        	String CodBonifAnual2;
        	String PorcBonifAnual2;
        	String IBonifAnual1I;
        	String IBonifAnual1D;
        	String IBonifAnual2I;
        	String IBonifAnual2D;
        	String codigo;
        	String CodigoBancoI= "";
        	String CodigoBancoD= "";
            // Resto del código...

            while ((line = br1.readLine()) != null) {
            	
            	if(!line.trim().isEmpty()) {
        			
            		
        			String AuditoFechaLog= LocalDate.now().toString().replaceAll("-","")+"|";//longitud 8
        			String AuditoHoraLog= "|";//Longitud 6
        			String AuditoOperadLog="|";//
        			String AuditoTerminLog="|";
        			String AuditoPrograLog="|";
        			String AuditoOpcion="|";
        			
        			  //Integer hora = LocalTime.now().getHour();
        			  //Integer minuto = LocalTime.now().getMinute();
        			  //Integer segundos = LocalTime.now().getSecond();
        			  String DominioI = line.substring(217, 225);//Longitud 8
        			  String ObjetoI=DominioI+"|";//Longitud 11
        			  
        			  String DominioD = line.substring(4000, 4008);
        			  String ObjetoD=DominioD+"|";
        			  
        			  String Impuesto="01|";
        			  
        			  String Planta="|";  //consultar
        			  
        			  String AnioCuotaI=line.substring(205, 209);//Longitud 4
        			  String AnioCuotaD=line.substring(3988, 3992);
        			  String CuotaI=line.substring(209,210);//Longitud 1
        			  //CuotaNumI= Integer.valueOf(CuotaI);
        			  String CuotaD=line.substring(3992,3993);
        			  //CuotaNumD= Integer.valueOf(CuotaD);
        			  String CalificadorI=AnioCuotaI+"0"+CuotaI+"AU|";//Longitud 8
        			  String CalificadorD=AnioCuotaD+"0"+CuotaD+"AU|";
        			  contador1 += 1;
        			  if (contador1 == 2)
                      {   
        				  contador1 = 0;
                      }
                      else
                      {
                          CuotaAux = CuotaI;
                      }
        			  if(AnioCuotaD.equals("    ")) {
        				  CalificadorI=AnioCuotaI+"0"+CuotaAux+"AU|";//Longitud 8
        				  CalificadorD=AnioCuotaI+"0"+CuotaAux+"AU|";//Longitud 8
        			  }
        			  
        			  String DestinatarioI=line.substring(0, 30).replace("|", " ")+"|";//Longitud 30
        			  String DestinatarioD=line.substring(3783, 3813).replace("|", " ")+"|";
        			  
        			  String DestinApelliNombreI=DestinatarioI;//Longitud 30
        			  String DestinApelliNombreD=DestinatarioD;
        			  
        			  String DestinCodigoPostal="|";//Longitud 4
        			  
        			  String LocalidadI=line.substring(83, 100).replace("|", " ");//Longitud 17
        			  String LocalidadD=line.substring(3866, 3883).replace("|", " ");
        			  
        			  String DestinLocaliI=LocalidadI+"|";//Longitud 30
        			  String DestinLocaliD=LocalidadD+"|";
        			  
        			  String CalleI=line.substring(30, 60).replace("|", " ");//Longitud 30
        			  String CalleD=line.substring(3813, 3843).replace("|", " ");
        			  
        			  String DestinCalleI=CalleI+"|";//Longitud 35
        			  String DestinCalleD=CalleD+"|";
        			  
        			  String NroRecI=line.substring(63, 68).replace("|", " ")+"|";//Longitud 5
        			  String NroRecD=line.substring(3846, 3851).replace("|", " ")+"|";
        			  
        			  String PisoI=line.substring(71, 74).replace("|", " ")+"|";
        			  String PisoD=line.substring(3854, 3857).replace("|", " ")+"|";
        			  
        			  String DptoI=line.substring(77, 81).replace("|", " ")+"|";
        			  String DptoD=line.substring(3860, 3864 ).replace("|", " ")+"|";
        			  
        			  String DistritoI=line.substring(365, 368).replace("|", " ")+"|";
        			  String DistritoD=line.substring(4148, 4151).replace("|", " ")+"|";
        			  
        			  String DestinCuit="|";
        			  
        			  String LeyendaPostalCpaI=line.substring(968, 976).replace("|", " ")+"|";
        			  String LeyendaPostalCpaD=line.substring(4751, 4759).replace("|", " ")+"|";
        			  
        			  String DestinSinUso="|";
        			  
        			  String DescripcionMarcaI="|"; //CodigoMarca
        			  String DescripcionMarcaD="|"; //CodigoMarca
        			  
        			  String DescripcionModeloI=line.substring(309, 324)+"|";
        			  String DescripcionModeloD=line.substring(4092, 4107)+"|";
        			  
        			  String ModeloI=line.substring(296, 300)+"|";
        			  String ModeloD=line.substring(4079, 4083)+"|";
        			  
        			  String CategoriaI=line.substring(307, 308)+"|";//Longitud(2) 1 a pedido de patricia
        			  String CategoriaD=line.substring(4090, 4091)+"|";
        			  
        			  String IncisoI=line.substring(305, 306);//Longitud 1
        			  String IncisoD=line.substring(4088, 4089);
        			  
        			  String CodIncisoI=IncisoI+"|";//Longitud 3
        			  String CodIncisoD=IncisoD+"|";
        			  
        			  String Distrito="|";
        			  String AutoSinUso="|";
        			  String DescMarcaI=line.substring(277, 289)+"|";//longitud 15
        			  String DescMarcaD=line.substring(4060, 4072)+"|";//longitud 15
        			  String Inmo="|";//Longitud 60
        			  String CodArboladura="|";//longitud 12
        			  String Matricula="|";//longitud 15
        			  String DistriAmarre="|";
        			  String NLifore="|";
        			  
        			  String NLiforeCodI=line.substring(3495, 3511)+"|";//longitud 16
        			  String NLiforeCodD=line.substring(7278, 7294)+"|";
        			  
        			  //String Barra50CuotaI=line.substring(2566, 2616)+"|";//longitud 50
        			  //String Barra50CuotaD=line.substring(6349, 6399)+"|";
        			  String Barra50CuotaI="|";//longitud 50
        			  String Barra50CuotaD="|";
        			  
        			  String NBarraDeco="|";//longitud 70
        			  //String NBarraDeco="                                                                      ";//longitud 70
        			  String CpeCuota="|";//longitud 19
        			  //String CpeCuota="                   ";//longitud 19
        			  
        			  String ImporteOriginalCuotaI=line.substring(1808, 1818).replaceAll("[.\\ \\,]","");//longitud 10
        			  String IOriginalI=ImporteOriginalCuotaI;//longitud 18
        			  for(int i=IOriginalI.length(); i<=17; i++) {
        				  IOriginalI="0"+IOriginalI;
        			  }
        			  IOriginalI += '|';
        			  
        			  String ImporteOriginalCuotaD=line.substring(5591, 5601).replaceAll("[.\\ \\,]","");
        			  String IOriginalD=ImporteOriginalCuotaD;//longitud 18
        			  for(int i=IOriginalD.length(); i<=17; i++) {
        				  IOriginalD="0"+IOriginalD;
        			  }
        			  IOriginalD += '|';
        			  
        			  String ImporteConFondoI=line.substring(264, 276).replaceAll("[.\\ \\,]","");//longitud 12
        			  String ImporteConFondoD=line.substring(4047, 4059).replaceAll("[.\\ \\,]","");
        			  
        			  String IActualI=ImporteConFondoI;//longitud 18
        			  for(int i=IActualI.length(); i<=17; i++) {
        				  IActualI="0"+IActualI;
        			  }
        			  IActualI+='|';
        			  String IActualD=ImporteConFondoD;
        			  for(int i=IActualD.length(); i<=17; i++) {
        				  IActualD="0"+IActualD;
        			  }
        			  IActualD+='|';
        			  
        			  String IBonificacion="|";//longitud 13
        			  //String IBonificacion="             ";
        			  
        			  String CodBonif1="61|";//longitud 2
        			  String PorcBonif1="10|";//longitud 6
        			  
        			  String DescuentoCuotaBcI=line.substring(1818, 1828).replaceAll("[.\\ \\,]","");//longitud 10
        			  for(int i=DescuentoCuotaBcI.length(); i<13; i++) {
        				  DescuentoCuotaBcI="0"+DescuentoCuotaBcI;
        			  }
        			  DescuentoCuotaBcI+='|';
        			  String DescuentoCuotaBcD=line.substring(5601, 5611).replaceAll("[.\\ \\,]","");
        			  for(int i=DescuentoCuotaBcD.length(); i<13; i++) {
        				  DescuentoCuotaBcD="0"+DescuentoCuotaBcD;
        			  }
        			  DescuentoCuotaBcD+='|';
        			  
        			  String IBonif1I=DescuentoCuotaBcI;//longitud 13
        			  String IBonif1D=DescuentoCuotaBcD;//longitud 13
        			  
        			  String CodBonif2="29|";//longitud 2
        			  String PorcBonif2="10|";//longitud 6
        			  String IBonif2I=DescuentoCuotaBcI;//longitud 13
        			  String IBonif2D=DescuentoCuotaBcD;//longitud 13
        			  /*String IBonif2I="|";//longitud 13
        			  String IBonif2D="|";//longitud 13*/
        			  
        			  String CodBonif3="|";//longitud 2
        			  String PorcBonif3="|";//longitud 6
        			  String IBonif3="|";//longitud 13
        			  
        			  String CodBonif4="|";//longitud 2
        			  String PorcBonif4="|";//longitud 6
        			  String IBonif4="|";//longitud 13
        			  
        			  String CodBonif5="|";//longitud 2
        			  String PorcBonif5="|";//longitud 6
        			  String IBonif5="|";//longitud 13
        			  
        			  String FondoEducativoCuotaI=line.substring(2478, 2487).replaceAll("[.\\ \\,]","");//longitud 9
        			  for(int i=FondoEducativoCuotaI.length(); i<9; i++) {
        				  FondoEducativoCuotaI="0"+FondoEducativoCuotaI;
        			  }
        			  FondoEducativoCuotaI+='|';
        			  String FondoEducativoCuotaD=line.substring(6261, 6270).replaceAll("[.\\ \\,]","");
        			  for(int i=FondoEducativoCuotaD.length(); i<9; i++) {
        				  FondoEducativoCuotaD="0"+FondoEducativoCuotaD;
        			  }
        			  FondoEducativoCuotaD+='|';
        			  
        			  String CoefFondoEduc="|";//longitud 6
        			  String ICuota="|";//longitud 18
        			  String NLiforeAnual="|";
        			  
        			  /*String BarraLiforeCodifAnualI=line.substring(3511, 3527)+"|";//longitud 16
        			  String BarraLiforeCodifAnualD=line.substring(7294, 7310)+"|";*/
        			  String BarraLiforeCodifAnualI="|";//longitud 16
        			  String BarraLiforeCodifAnualD="|";
        			  
        			  /*String Barra50AnualI=line.substring(2616, 2666)+"|";//longitud 50
        			  String Barra50AnualD=line.substring(6399, 6449)+"|";*/
        			  String Barra50AnualI="|";//longitud 50
        			  String Barra50AnualD="|";
        			  
        			  /*String NBarraDecoAnualI=line.substring(766, 828)+"|";//longitud 70
        			  String NBarraDecoAnualD=line.substring(4549, 4611)+"|";*/
        			  String NBarraDecoAnualI="|";//longitud 70
        			  String NBarraDecoAnualD="|";
        			  //String Barra50AnualI="|";//longitud 50
        			  //String Barra50AnualD="|";
        			  
        			  //String NBarraDecoAnualI=line.substring(766, 828)+"|";//longitud 70
        			  //String NBarraDecoAnualD=line.substring(4549, 4611)+"|";
        			  //String NBarraDecoAnual="                                                                      ";//longitud 70
        			  
        			  String CpeAnual="|";//longitud 19
        			  //String CpeAnual="                   "+"|";//longitud 19
        			  /*String ImporteOriginalAnualI=line.substring(1838, 1848).replaceAll("[.\\ \\,]","");//longitud 10
        			  String IOriginalAnualI=ImporteOriginalAnualI;
        			  for(int i=IOriginalAnualI.length(); i<18; i++) {
        				  IOriginalAnualI="0"+IOriginalAnualI;
        			  }
        			  IOriginalAnualI+='|';*/
        			  String IOriginalAnualI="|";
        			  /*String ImporteOriginalAnualD=line.substring(5621, 5631).replaceAll("[.\\ \\,]","");
        			  String IOriginalAnualD=ImporteOriginalAnualD;
        			  for(int i=IOriginalAnualD.length(); i<18; i++) {
        				  IOriginalAnualD="0"+IOriginalAnualD;
        			  }
        			  IOriginalAnualD+='|';*/
        			  String IOriginalAnualD="|";
        			  
        			  /*String ImporteAPagarAnualI=line.substring(626, 638).replaceAll("[.\\ \\,]","");//longitud 10
        			  String ImporteAPagarAnualD=line.substring(4409, 4421).replaceAll("[.\\ \\,]","");
        			  
        			  String IActualAnualI=ImporteAPagarAnualI;//longitud 18 falta
        			  for(int i=IActualAnualI.length(); i<18; i++) {
        				  IActualAnualI="0"+IActualAnualI;
        			  }
        			  IActualAnualI+='|';
        			  String IActualAnualD=ImporteAPagarAnualD;//longitud 18 falta
        			  for(int i=IActualAnualD.length(); i<18; i++) {
        				  IActualAnualD="0"+IActualAnualD;
        			  }
        			  IActualAnualD+='|';*/
        			  String IActualAnualI="|";
        			  String IActualAnualD="|";
        			  
        			  /*String IBonificacionAnual1I=line.substring(1848, 1858).replaceAll("[.\\ \\,]","");//longitud 13 CONSULTAR!!!!
        			  for(int i=IBonificacionAnual1I.length(); i<13; i++) {
        				  IBonificacionAnual1I="0"+IBonificacionAnual1I;
        			  }
        			  IBonificacionAnual1I+='|';
        			  String IBonificacionAnual1D=line.substring(5631, 5641).replaceAll("[.\\ \\,]","");//longitud 13 CONSULTAR!!!!
        			  for(int i=IBonificacionAnual1D.length(); i<13; i++) {
        				  IBonificacionAnual1D="0"+IBonificacionAnual1D;
        			  }
        			  IBonificacionAnual1D+='|';*/
        			  String IBonificacionAnual1I="|";
        			  String IBonificacionAnual1D="|";
        			  if((CuotaI.equals("1"))||(CuotaI.equals(" "))) {
        				  CodBonifAnual1="61|";
        				  PorcBonifAnual1="10|";
        				  CodBonifAnual2="03|";
        				  PorcBonifAnual2="10|";
        			 }
        			 else {
        				  //String CodBonifAnual1="  |";//longitud 2
        				   CodBonifAnual1="|";
//        				  String PorcBonifAnual1="      |";//longitud 6	  
        				   PorcBonifAnual1="|";
//        				  String CodBonifAnual2="  |";//longitud 2
        				   CodBonifAnual2="|";
//        				  String PorcBonifAnual2="      |";//longitud 6
        				   PorcBonifAnual2="|";

        				 
        			 }
        			  
        			  //String CodBonifAnual1="|";//longitud 2
        			  //String PorcBonifAnual1="|";//longitud 6	  
        			  IBonifAnual1I=IBonificacionAnual1I;//longitud 13
        			  IBonifAnual1D=IBonificacionAnual1D;
        			 
        			  //String CodBonifAnual2="|";//longitud 2
        			  //String PorcBonifAnual2="|";//longitud 6
        			  /*String IBonifAnual2I=line.substring(1858, 1868).replaceAll("[.\\ \\,]","");//longitud 13
        			  for(int i =  IBonifAnual2I.length(); i<= 12;i++) {
      					
      					IBonifAnual2I = "0" + IBonifAnual2I; 
      					
      				  }
      				  IBonifAnual2I += "|";
        			  String IBonifAnual2D=line.substring(5641, 5651).replaceAll("[.\\ \\,]","");
        			  for(int i =  IBonifAnual2D.length(); i<= 12;i++) {
        					
        					 IBonifAnual2D = "0" +IBonifAnual2D; 
        					
        			  }
        			  IBonifAnual2D += "|";*/
        			  IBonifAnual2D = "|";
        			  IBonifAnual2I = "|";
        			  
        			  String CodBonifAnual3="|";//longitud 2
        			  String PorcBonifAnual3="|";//longitud 6	
        			  String IBonifAnual3="|";//longitud 13
        			  
        			  String CodBonifAnual4="|";//longitud 2
        			  String PorcBonifAnual4="|";//longitud 6
        			  String IBonifAnual4="|";//longitud 13
        			  
        			  String CodBonifAnual5="|";//longitud 2
        			  String PorcBonifAnual5="|";//longitud 6	
        			  String IBonifAnual5="|";//longitud 13	
        			  
        			  /*String FondoEducativoAnualI=line.substring(2487, 2496).replaceAll("[.\\ \\,]","");//longitud 9
        			  for(int i=FondoEducativoAnualI.length(); i<18; i++) {
        				  FondoEducativoAnualI="0"+FondoEducativoAnualI;
        			  }
        			  FondoEducativoAnualI+='|';
        			  String FondoEducativoAnualD=line.substring(6270, 6279).replaceAll("[.\\ \\,]","");
        			  for(int i=FondoEducativoAnualD.length(); i<18; i++) {
        				  FondoEducativoAnualD="0"+FondoEducativoAnualD;
        			  }
        			  FondoEducativoAnualD+='|';*/
        			  String FondoEducativoAnualD="|";
        			  String FondoEducativoAnualI="|";
        			  
        			  
        			  String CoefFondoEducAnual="|";//longitud 6
        			  String ICuotaAnual="|";//longitud 18
        			  String MDebitoAutomatico="D|";//longitud 1
        			  String MBoletaElect="|";//longitud 1
        			  String MBc="|";//longitud 1
        			  String MCompensa="|";//longitud 1
        			  String MSinUso="|";//longitud 3
        			  
        			  String Año1I=line.substring(1578, 1582)+"|";//longitud 4
        			  String Año1D=line.substring(5361, 5365)+"|";
        			  String CantCuotas1I=line.substring(1583, 1585)+"|";//longitud 2
        			  String CantCuotas1D=line.substring(5366, 5368)+"|";
        			  String Importe1I=line.substring(1585, 1595).replaceAll("[.\\ \\,]","");//longitud orig 10 faltan 3
        			  String Importe1D=line.substring(5368, 5378).replaceAll("[.\\ \\,]","");
        			  for (int i = Importe1I.length(); i <= 12 ; i++) {
        				  Importe1I = "0" + Importe1I;
        			  }
        			  
        			  Importe1I += "|";
        			  
        			  for (int i = Importe1D.length(); i <= 12 ; i++) {
        				  Importe1D = "0"  + Importe1D;
        			  }
        			  Importe1D += "|";
        			  
        			  String Año2I=line.substring(1613, 1617)+"|";
        			  String Año2D=line.substring(5396, 5400)+"|";
        			  String CantCuotas2I=line.substring(1618, 1620)+"|";
        			  String CantCuotas2D=line.substring(5401, 5403)+"|";
        			  String Importe2I=line.substring(1620, 1630).replaceAll("[.\\ \\,]","");
        			  String Importe2D=line.substring(5403, 5413).replaceAll("[.\\ \\,]","");
        			  for (int i = Importe2I.length(); i <= 12 ; i++) {
        				  Importe2I = "0"  + Importe2I;
        			  }
        			  
        			  Importe2I += "|";
        			  
        			  for (int i = Importe2D.length(); i <= 12 ; i++) {
        				  Importe2D = "0"  + Importe2D;
        			  }
        			  Importe2D += "|";
        			  
        			  String Año3I=line.substring(1648, 1652)+"|";
        			  String Año3D=line.substring(5431, 5435)+"|";
        			  String CantCuotas3I=line.substring(1653, 1655)+"|";
        			  String CantCuotas3D=line.substring(5436, 5438)+"|";
        			  String Importe3I=line.substring(1655, 1665).replaceAll("[.\\ \\,]","");
        			  String Importe3D=line.substring(5438, 5448).replaceAll("[.\\ \\,]","");
        			  for (int i = Importe3I.length(); i <= 12 ; i++) {
        				  Importe3I = "0"  + Importe3I;
        			  }
        			  
        			  Importe3I += "|";
        			  
        			  for (int i = Importe3D.length(); i <= 12 ; i++) {
        				  Importe3D = "0"  + Importe3D;
        			  }
        			  Importe3D += "|";
        			  
        			  String Año4I=line.substring(1683, 1687)+"|";
        			  String Año4D=line.substring(5466, 5470)+"|";
        			  String CantCuotas4I=line.substring(1688, 1690)+"|";
        			  String CantCuotas4D=line.substring(5471, 5473)+"|";
        			  String Importe4I=line.substring(1690, 1700).replaceAll("[.\\ \\,]","");
        			  String Importe4D=line.substring(5473, 5483).replaceAll("[.\\ \\,]","");
        			  for (int i = Importe4I.length(); i <= 11 ; i++) {
        				  Importe4I = "0"  + Importe4I;
        			  }
        			  
        			  Importe4I += "|";
        			  
        			  for (int i = Importe4D.length(); i <= 11 ; i++) {
        				  Importe4D = "0"  + Importe4D;
        			  }
        			  
        			  Importe4D += "|";
        			  
        			  String Año5I=line.substring(1718, 1722)+"|";
        			  String Año5D=line.substring(5501, 5505)+"|";
        			  String CantCuotas5I=line.substring(1723, 1725)+"|";
        			  String CantCuotas5D=line.substring(5506, 5508)+"|";
        			  String Importe5I=line.substring(1725, 1735).replaceAll("[.\\ \\,]","");
        			  String Importe5D=line.substring(5508, 5518).replaceAll("[.\\ \\,]","");
        			  for (int i = Importe5I.length(); i <= 12 ; i++) {
        				  Importe5I = "0"  + Importe5I;
        			  }
        			  
        			  Importe5I += "|";
        			  
        			  for (int i = Importe5D.length(); i <= 12 ; i++) {
        				  Importe5D = "0"  + Importe5D;
        			  }
        			  
        			  Importe5D += "|";
        			  
        			  String Año6I=line.substring(1753, 1757)+"|";
        			  String Año6D=line.substring(5536, 5540)+"|";
        			  String CantCuotas6I=line.substring(1758, 1760)+"|";
        			  String CantCuotas6D=line.substring(5541, 5543)+"|";
        			  String Importe6I=line.substring(1760, 1770).replaceAll("[.\\ \\,]","");
        			  String Importe6D=line.substring(5543, 5553).replaceAll("[.\\ \\,]","");
        			  for (int i = Importe6I.length(); i <= 12 ; i++) {
        				  Importe6I = "0"  + Importe6I;
        			  }
        			  
        			  Importe6I += "|";
        			  
        			  
        			  for (int i = Importe6D.length(); i <= 12 ; i++) {
        				  Importe6D = "0"  + Importe6D;
        			  }
        			  
        			  Importe6D += "|";
        			  
        			  String DeudaCaducidadesI = line.substring(1798, 1808).replaceAll("[.\\ \\,\\*]","");//longitud orig 10 faltan 3
        			  String DeudaCaducidadesD = line.substring(5581, 5591).replaceAll("[.\\ \\,\\*]","");
        			  for (int i = DeudaCaducidadesI.length(); i <= 12 ; i++) {
        				  DeudaCaducidadesI = "0"  + DeudaCaducidadesI;
        			  }
        			  
        			  DeudaCaducidadesI += "|";
        			  
        			  for (int i = DeudaCaducidadesD.length(); i <= 12 ; i++) {
        				  DeudaCaducidadesD = "0"  + DeudaCaducidadesD;
        			  }
        			  
        			  DeudaCaducidadesD += "|";
        			  
        			  String DeudaTituloEjecutivoI = line.substring(1788, 1798).replaceAll("[.\\ \\,\\*]","");//longitud orig 10 faltan 3
        			  String DeudaTituloEjecutivoD = line.substring(5571, 5581).replaceAll("[.\\ \\,\\*]","");
        			  for (int i = DeudaTituloEjecutivoI.length(); i <= 12 ; i++) {
        				  DeudaTituloEjecutivoI = "0"  + DeudaTituloEjecutivoI;
        			  }
        			  
        			  DeudaTituloEjecutivoI += "|";
        			  
        			  for (int i = DeudaTituloEjecutivoD.length(); i <= 12 ; i++) {
        				  DeudaTituloEjecutivoD = "0"  + DeudaTituloEjecutivoD;
        			  }
        			  
        			  DeudaTituloEjecutivoD += "|";
        			  
        			  String DeudaTotalI= line.substring(2002, 2015).replaceAll("[.\\ \\,\\*]","");//longitud 13
        			  String DeudaTotalD= line.substring(5785, 5798).replaceAll("[.\\ \\,\\*]","");
        			  for (int i = DeudaTotalI.length(); i <= 12 ; i++) {
        				  DeudaTotalI = "0"  + DeudaTotalI;
        			  }
        			  
        			  DeudaTotalI += "|";
        			  
        			  for (int i = DeudaTotalD.length(); i <= 12 ; i++) {
        				  DeudaTotalD = "0"  + DeudaTotalD;
        			  }
        			  
        			  DeudaTotalD += "|";
        			  
        			  String Fecha1="|";//longitud 8
        			  String Fecha2="|";//longitud 8
        			  //String ValuacionFiscal="             ";//longitud 13
        			  String ValuacionFiscal="|";//longitud 13
        			  
        			  String ValuacionI= line.substring(386, 399).replaceAll("[.\\ \\,]","");//longitud 13
        			  String ValuacionD= line.substring(4169, 4182).replaceAll("[.\\ \\,]","");
        			  for (int i = ValuacionI.length(); i <= 12 ; i++) {
        				  ValuacionI = "0"  + ValuacionI;
        			  }
        			  
        			  ValuacionI += "|";
        			  
        			  
        			  for (int i = ValuacionD.length(); i <= 12 ; i++) {
        				  ValuacionD = "0"  + ValuacionD;
        			  }
        			  
        			  ValuacionD += "|";
        			  
        			  String DescLeyenda="|";//longitud 70 CONSULTAR!!!!
        			  String CodigoCuenta="|";//longitud 3
        			  String NumeroCuentaI=line.substring(1307,1315)+"|";//longitud 20
        			  String NumeroCuentaD=line.substring(5090,5098)+"|";
        			  //String CodigoBanco="|";//longitud 3
        			  String CodigoSucursal="|";//longitud 4
        			  String CodError="|";//longitud5
        			  String LeyenError="|";//longitud 70
        			  String ProgError="|";//longitud 8
        			  
                      //String numeroCuenta =(line.substring(2624,2632));
          			  String descriBancoI = (line.substring(1315,1347)).replaceAll(" ",""); 
          			  String descriBancoD = (line.substring(5098,5130)).replaceAll(" ","");
          			  br2.mark(10000);
          			  //line2 = file2.readLine();
          			  while ((line2 = br1.readLine()) != null) {
                      //while(line2= br1.readLine()!=null) {
                      	if(line2!="") {
                      		String banco=line2.substring(3,35).replaceAll(" ","");
//                      		CodigoBancoI=(line2.substring(0,3));
                      		if(banco.equals(descriBancoI)) {
                      			CodigoBancoI=(line2.substring(0,3)+"|");
                      			System.out.println("Si se pudo encontrar el bancoI: " +banco);
//                                  break;
                      		}
                      		else {
                      		
                      			//System.out.println("No se pudo encontrar el objeto: " +objeto);
                      		}
                      		String bancoD=line2.substring(3,35).replaceAll(" ","");
//                      		CodigoBancoD=(line2.substring(0,3));
                      		if(bancoD.equals(descriBancoD)) {
                      			CodigoBancoD=(line2.substring(0,3)+"|");
                      			System.out.println("Si se pudo encontrar el bancoD: " +banco);
//                                  break;
                      		}
                      		else {
                      			
                      			//System.out.println("No se pudo encontrar el objeto: " +objeto);
                      		}
                      	}
                      	try {
                              
                              line2 = br2.readLine();
                          } catch (Exception e) {
                              System.out.println("Error de lectura del fichero");
                          }
                      }
                      br2.reset();
        			  

        			  String CircI="|";//longitud 3
        			  String CircD="|";
        			  
        			  String SeccI="|";//longitud 3
        			  String SeccD="|";
        			  
        			  String ChacI="|";//longitud 8
        			  String ChacD="|";
        			  
        			  
        			  String QuinI="|";//longitud 8
        			  String QuinD="|";
        			  
        			  String MzanaI="|";//longitud 8
        			  String MzanaD="|";
        			  
        			  
        			  
        			  String FraccI="|";//longitud 8
        			  String FraccD="|";
        			  
        			  String ParcI="|";//longitud 8
        			  String ParcD="|";
        			  
        			  String SubParcI="|";//longitud 6
        			  String SubParcD="|";
          			  
          			  String SupTierI = "|";
          			  String SupTierD = "|";
        			  
//        			  String SupEdifI="           |";//line.substring(643, 654);//longitud 11
          			  String SupEdifI="|";
//        			  String SupEdifD="           |";//line.substring(4099, 4110);
          			  String SupEdifD="|";
          			  
          			String IOriginalCF="|";
      			    String MCreditoFiscal="|";
      			    String InmoSinUsoA="|";
      			    String PartidasAsociadas=" ";
        			  
        			  
        			  
        			  
        			
        			  System.out.println("fecha"+AuditoFechaLog);
        			  line=  AuditoFechaLog+AuditoHoraLog+AuditoOperadLog+AuditoTerminLog+AuditoPrograLog+AuditoOpcion+ObjetoI+Impuesto+Planta+CalificadorI+DestinApelliNombreI+DestinCodigoPostal+DestinLocaliI+DestinCalleI+NroRecI+PisoI+DptoI+DistritoI+DestinCuit+LeyendaPostalCpaI+DestinSinUso+DestinSinUso+DescripcionMarcaI+DescripcionModeloI+ModeloI+CategoriaI+CodIncisoI+Distrito+AutoSinUso+DescMarcaI+CodArboladura+Matricula+DistriAmarre+NLifore+NLiforeCodI+Barra50CuotaI+NBarraDeco+CpeCuota+IOriginalI+IOriginalCF+IActualI+IBonificacion+CodBonif1+PorcBonif1+IBonif1I+CodBonif2+PorcBonif2+IBonif2I+CodBonif3+PorcBonif3+IBonif3+CodBonif4+PorcBonif4+IBonif4+CodBonif5+PorcBonif5+IBonif5+FondoEducativoCuotaI+CoefFondoEduc+ICuota+NLiforeAnual+BarraLiforeCodifAnualI+Barra50AnualI+NBarraDecoAnualI+CpeAnual+IOriginalAnualI+IActualAnualI+IBonificacionAnual1I+CodBonifAnual1+PorcBonifAnual1+IBonifAnual1I+CodBonifAnual2+PorcBonifAnual2+IBonifAnual2I+CodBonifAnual3+PorcBonifAnual3+IBonifAnual3+CodBonifAnual4+PorcBonifAnual4+IBonifAnual4+CodBonifAnual5+PorcBonifAnual5+IBonifAnual5+FondoEducativoAnualI+CoefFondoEducAnual+ICuotaAnual+MDebitoAutomatico+MBoletaElect+MBc+MCompensa+MSinUso+MCreditoFiscal+Año1I+CantCuotas1I+Importe1I+Año2I+CantCuotas2I+Importe2I+Año3I+CantCuotas3I+Importe3I+Año4I+CantCuotas4I+Importe4I+Año5I+CantCuotas5I+Importe5I+DeudaCaducidadesI+DeudaTituloEjecutivoI+DeudaTotalI+Fecha1+Fecha2+ValuacionFiscal+ValuacionI+DescLeyenda+CodigoCuenta+NumeroCuentaI+CodigoBancoI+CodigoSucursal+CodError+LeyenError+ProgError+Año6I+CantCuotas6I+Importe6I+CircI + SeccI + MzanaI + ParcI+ SubParcI + SupTierI + SupEdifI + ChacI + FraccI + QuinI+InmoSinUsoA+PartidasAsociadas;
        			  line2= AuditoFechaLog+AuditoHoraLog+AuditoOperadLog+AuditoTerminLog+AuditoPrograLog+AuditoOpcion+ObjetoD+Impuesto+Planta+CalificadorD+DestinApelliNombreD+DestinCodigoPostal+DestinLocaliD+DestinCalleD+NroRecD+PisoD+DptoD+DistritoD+DestinCuit+LeyendaPostalCpaD+DestinSinUso+DestinSinUso+DescripcionMarcaD+DescripcionModeloD+ModeloD+CategoriaD+CodIncisoD+Distrito+AutoSinUso+DescMarcaD+CodArboladura+Matricula+DistriAmarre+NLifore+NLiforeCodD+Barra50CuotaD+NBarraDeco+CpeCuota+IOriginalD+IOriginalCF+IActualD+IBonificacion+CodBonif1+PorcBonif1+IBonif1D+CodBonif2+PorcBonif2+IBonif2D+CodBonif3+PorcBonif3+IBonif3+CodBonif4+PorcBonif4+IBonif4+CodBonif5+PorcBonif5+IBonif5+FondoEducativoCuotaD+CoefFondoEduc+ICuota+NLiforeAnual+BarraLiforeCodifAnualD+Barra50AnualD+NBarraDecoAnualD+CpeAnual+IOriginalAnualD+IActualAnualD+IBonificacionAnual1D+CodBonifAnual1+PorcBonifAnual1+IBonifAnual1D+CodBonifAnual2+PorcBonifAnual2+IBonifAnual2D+CodBonifAnual3+PorcBonifAnual3+IBonifAnual3+CodBonifAnual4+PorcBonifAnual4+IBonifAnual4+CodBonifAnual5+PorcBonifAnual5+IBonifAnual5+FondoEducativoAnualD+CoefFondoEducAnual+ICuotaAnual+MDebitoAutomatico+MBoletaElect+MBc+MCompensa+MSinUso+MCreditoFiscal+Año1D+CantCuotas1D+Importe1D+Año2D+CantCuotas2D+Importe2D+Año3D+CantCuotas3D+Importe3D+Año4D+CantCuotas4D+Importe4D+Año5D+CantCuotas5D+Importe5D+DeudaCaducidadesD+DeudaTituloEjecutivoD+DeudaTotalD+Fecha1+Fecha2+ValuacionFiscal+ValuacionD+DescLeyenda+CodigoCuenta+NumeroCuentaD+CodigoBancoD+CodigoSucursal+CodError+LeyenError+ProgError+Año6D+CantCuotas6D+Importe6D+CircD + SeccD + MzanaD + ParcD+ SubParcD + SupTierD + SupEdifD + ChacD + FraccD + QuinD+InmoSinUsoA+PartidasAsociadas;
        			  bw.write(line);
        			  bw.write(line2);
                      bw.newLine();
        			  

        				
        		}
            }
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

