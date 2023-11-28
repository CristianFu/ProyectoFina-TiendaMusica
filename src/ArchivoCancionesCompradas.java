import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoCancionesCompradas {
    private String nombreArchivo;

    // Constructor
    public ArchivoCancionesCompradas(String nombreA) {
        this.nombreArchivo = nombreA;
    }

    // Método para escribir canciones compradas en un archivo
    public void escribirEnArchivo(ArrayList<Cancion> listaCancionesCompradas) {
        try {
            PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
            for (Cancion cancionx : listaCancionesCompradas) {
                salidaArchivo.println(cancionx.formatoArchivo());
            }
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer canciones compradas desde un archivo
    public ArrayList<Cancion> leerDeArchivo() {
        ArrayList<Cancion> listaCancionesCompradas = new ArrayList<>();
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

                Cancion cancionX = new Cancion(clave, nombreCancion, artista, genero, portada, album, archivo, precio);
                listaCancionesCompradas.add(cancionX);
            }

            // Cerrar el archivo
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCancionesCompradas;
    }
}
