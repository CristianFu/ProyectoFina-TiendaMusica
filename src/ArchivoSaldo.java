import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoSaldo {
    private String nombreArchivo;

    // Constructor
    public ArchivoSaldo(String nombreA) {
        this.nombreArchivo = nombreA;
    }

    // Método para escribir el saldo en el archivo
    public void escribirEnArchivo() {
        try {
            PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
            salidaArchivo.println(Globales.saldo);
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // fin de escribirEnArchivo

    // Método para leer el saldo desde el archivo
    public void leerDeArchivo() {
        try {
            // Abrir el archivo
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);

            // Leer el archivo
            while (leerArchivo.hasNext()) {
                Globales.saldo = leerArchivo.nextDouble();
            }

            // Cerrar el archivo
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// fin leerarchivo
}
