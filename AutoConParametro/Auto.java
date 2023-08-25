package AutoConParametro;
public class Auto {

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Entradas <nombreArchivoEntrada1> <nombreArchivoSalida> <nombreArchivoEntrada2>");
            return;
        }

        String nombreArchivoEntrada1 = args[0];
        String nombreArchivoSalida = args[1];
        String nombreArchivoEntrada2 = args[2];
        System.out.println("Pude reconocer>");

        if (nombreArchivoEntrada1.contains("CREDITO")) {
            ProcesadorDebito.procesarArchivoD(nombreArchivoEntrada1, nombreArchivoSalida, nombreArchivoEntrada2);
        } else if (nombreArchivoEntrada1.contains("DEBITO")) {
            ProcesadorCredito.procesarArchivoT(nombreArchivoEntrada1, nombreArchivoSalida, nombreArchivoEntrada2);
        } else if (nombreArchivoEntrada1.contains("MAILS")) {
            ProcesadorMail.procesarArchivoM(nombreArchivoEntrada1, nombreArchivoSalida, null);
        } else if (nombreArchivoEntrada1.contains("COMUN")) {
            ProcesadorComun.procesarArchivoC(nombreArchivoEntrada1, nombreArchivoSalida, null);
        } else {
            System.out.println("Archivo no reconocido: " + nombreArchivoEntrada1);
        }
    }
}
