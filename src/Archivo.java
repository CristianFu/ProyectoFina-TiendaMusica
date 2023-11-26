import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

    private String nombreArchivo;

    public Archivo(String nombreA) {
        this.nombreArchivo = nombreA;

    }

    public void escribirEnArchivo(ArrayList<Cancion> listaCanciones) {

        try {

            PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
            for (Cancion cancionx : listaCanciones) {
                salidaArchivo.println(cancionx.formatoArchivo());
            }

            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    } // fin de escribirEnArchivo

    public ArrayList<Cancion> leerDeArchivo() {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try {
// Abrir el archivo
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);
// Leer el archivo
            while (leerArchivo.hasNext()) {
                String linea = leerArchivo.nextLine();
                String[] valores = linea.split("\\|");
                int clave = Integer.parseInt(valores[0]);
                String nombreCancion = valores[1];
                String artista = valores[2];
                String genero = valores[3];
                String portada = valores[4];
                String album = valores[5];
                String archivo = valores[6];
                double precio = Double.parseDouble(valores[7]);
                Cancion cancionx = new Cancion(clave, nombreCancion, artista, genero,
                        portada, album, archivo, precio);
                listaCanciones.add(cancionx);
            }
// Cerrar el archivo
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCanciones;
    }//fin leerarchivo
}
