import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    private String nombreArchivo;

    // Constructor
    public Archivo(String nombreA) {
        this.nombreArchivo = nombreA;
    }

    // Método para escribir canciones en un archivo
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
    }

    // Método para leer canciones desde un archivo
    public ArrayList<Cancion> leerDeArchivo() {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try {
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);

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

                Cancion cancionx = new Cancion(clave, nombreCancion, artista, genero, portada, album, archivo, precio);
                listaCanciones.add(cancionx);
            }

            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCanciones;
    }

    // Método para escribir canciones compradas en un archivo separado
    public void escribirEnArchivoComp(ArrayList<Cancion> listaCancionesCompradas) {
        try {
            PrintWriter salidaArchivo = new PrintWriter("cancionesCompradas.txt");
            for (Cancion cancionx : listaCancionesCompradas) {
                salidaArchivo.println(cancionx.formatoArchivo());
            }
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer canciones compradas desde un archivo separado
    public ArrayList<Cancion> leerDeArchivoComp() {
        ArrayList<Cancion> listaCancionesCompradas = new ArrayList<>();
        try {
            File archivoLectura = new File("cancionesCompradas.txt");
            Scanner leerArchivo = new Scanner(archivoLectura);

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

                Cancion cancionx = new Cancion(clave, nombreCancion, artista, genero, portada, album, archivo, precio);
                listaCancionesCompradas.add(cancionx);
            }

            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCancionesCompradas;
    }
}
