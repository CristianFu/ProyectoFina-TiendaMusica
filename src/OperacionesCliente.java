import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OperacionesCliente {
    // Recuperar canciones de txt
    private Archivo archivox = new Archivo("Cancionex.txt");
    private ArrayList<Cancion> listaCanciones;

    // Para guardar las canciones compradas
    private ArrayList<Cancion> listaCancionesCompradas = new ArrayList<>();
    private ArchivoCancionesCompradas archivoj = new ArchivoCancionesCompradas("cancionesCompradas.txt");

    public OperacionesCliente() {
        listaCanciones = archivox.leerDeArchivo();
        listaCancionesCompradas = archivoj.leerDeArchivo();
    }

    public int buscarCancion(int clave) {
        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getClave() == clave) {
                return i;
            }
        }
        return -1;
    }

    public int buscarCancionComprada(int clave) {
        for (int i = 0; i < listaCancionesCompradas.size(); i++) {
            if (listaCancionesCompradas.get(i).getClave() == clave) {
                return i;
            }
        }
        return -1;
    }

    public void cobrarCancion(int indice) {
        double precio = listaCanciones.get(indice).getPrecio();
        System.out.println("El precio de la canción es: " + precio);
        Globales.saldo = Globales.saldo - precio;
    }

    public void comprarCancion(int indice) {
        Cancion cancionX = listaCanciones.get(indice);
        listaCancionesCompradas.add(cancionX);
        archivoj.escribirEnArchivo(listaCancionesCompradas);
    }

    public void verCancionesCompradas() {
        verCanciones(listaCancionesCompradas);
    }

    public void verCancionesCatalogo() {
        verCanciones(listaCanciones);
    }

    private void verCanciones(ArrayList<Cancion> lista) {
        // Imprimimos lista
        System.out.printf("%-8s|%-30s|%-30s|%-8s\n", "Clave", "Nombre Cancion", "Artista", "Precio");
        System.out.println("--------|--------------------------|------------------------------|--------");
        for (Cancion aux : lista) {
            // Aquí se lleva el % según el tipo
            System.out.printf("%-8d|%-30s|%-30s|$%-6.2f\n", aux.getClave(),
                    aux.getNombreCancion(), aux.getNombreCantante(), aux.getPrecio());
        }
    }

    public void verPaginaWebCatalogoCompleto() {
        String nombrePagina = "CancionesMuestra.html";
        PaginaHTMLMuestras pagina = new PaginaHTMLMuestras(nombrePagina);
        pagina.crearPagina();
        try {
            File documentoAbrir = new File(nombrePagina);
            Desktop.getDesktop().open(documentoAbrir);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void verPaginaWebCancionesCompradas() {
        String nombrePagina = "CancionesCompradas.html";
        PaginaHTMLCancionesCompradas pagina = new PaginaHTMLCancionesCompradas(nombrePagina);
        pagina.crearPagina();
        try {
            File documentoAbrir = new File(nombrePagina);
            Desktop.getDesktop().open(documentoAbrir);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void abonarSaldo() {
    }

    public void verSaldo() {
    }
}
