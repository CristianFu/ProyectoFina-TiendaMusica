import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacionesCliente {
    private static final Scanner entrada = new Scanner(System.in);
    private Archivo archivox = new Archivo("Cancionex.txt");
    private ArrayList<Cancion> listaCanciones;
    private ArrayList<Cancion> listaCancionesCompradas = new ArrayList<>();

    public OperacionesCliente() {
        listaCanciones = archivox.leerDeArchivo();
    }

    // Método para buscar una canción en la lista de canciones
    public int buscarCancion(int clave) {
        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getClave() == clave) {
                return i;
            }
        }
        return -1;
    }

    // Método para buscar una canción en la lista de canciones compradas
    public int buscarCancionComprada(int clave) {
        for (int i = 0; i < listaCancionesCompradas.size(); i++) {
            if (listaCancionesCompradas.get(i).getClave() == clave) {
                return i;
            }
        }
        return -1;
    }

    // Método para comprar una canción y agregarla a la lista de canciones compradas
    public void comprarCancion(int indice) {
        Cancion cancionX = listaCanciones.get(indice);
        listaCancionesCompradas.add(cancionX);
    }

    // Método para mostrar las canciones compradas
    public void verCancionesCompradas() {
        System.out.println("Lista de canciones compradas:");
        verCanciones(listaCancionesCompradas);
    }

    // Método para mostrar todas las canciones en el catálogo
    public void verCancionesCatalogo() {
        verCanciones(listaCanciones);
    }

    // Método para mostrar las canciones en una página web
    public void verPaginaWebCatalogoCompleto() {
        String nombrePagina = "Canciones.html";
        PaginaHTML pagina = new PaginaHTML(nombrePagina);
        pagina.crearPagina();
        try {
            File documentoAbrir = new File(nombrePagina);
            Desktop.getDesktop().open(documentoAbrir);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Método privado para mostrar las canciones en consola
    private void verCanciones(ArrayList<Cancion> lista) {
        System.out.printf("%-8s|%-30s|%-30s|%-8s\n", "Clave", "Nombre Cancion", "Artista", "Precio");
        System.out.println("--------|------------------------------|------------------------------|--------");
        for (Cancion aux : lista) {
            System.out.printf("%-8d|%-30s|%-30s|$%-6.2f\n", aux.getClave(), aux.getNombreCancion(),
                    aux.getNombreCantante(), aux.getPrecio());
        }
    }
}
