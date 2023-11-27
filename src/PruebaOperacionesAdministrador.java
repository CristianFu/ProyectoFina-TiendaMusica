import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class PruebaOperacionesAdministrador {
    static Catalogo catalogoTienda = new Catalogo();
    static Scanner entrada = new Scanner(System.in);
    static Archivo archivox = new Archivo("CANCIONEX.txt");

    public static void mainOperacionesAdministrador() {
        catalogoTienda.setlistaCanciones(archivox.leerDeArchivo());
        mostrarCanciones();
        int opcion,indice;
        int clave;
        do {
            menu();
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    pedirDatosCancion();
                    archivox.escribirEnArchivo(catalogoTienda.getListaCanciones());
                    mostrarCanciones();
                    break;
                case 2:
                    mostrarCanciones();
                    break;
                case 3:
                   buscarCancion();
                    break;
                case 4:
                    borrarCancion();
                    archivox.escribirEnArchivo(catalogoTienda.getListaCanciones());
                    mostrarCanciones();
                    break;
                case 5:
                   cambiarNombreCancion();
                   archivox.escribirEnArchivo(catalogoTienda.getListaCanciones());
                   mostrarCanciones();
                    break;
                case 6:

                    break;
                case 7:
                    verPaginaWebCatalogoCompleto();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No válido");
                    break;
            }//fin de switch
        } while (opcion != 8);
    }

    private static void menu() {
        System.out.println("-------------------------------------------------" +
                "-------------------------");
        System.out.println("Operaciones sobre canciones:");
        System.out.println("1.-Añadir una cancion a la lista");
        System.out.println("2.-Mostrar lista de canciones");
        System.out.println("3.-Buscar cancion por clave");
        System.out.println("4.-Borrar una cancion");
        System.out.println("5.-Cambiar el nombre de una cancion");
        System.out.println("6.-Cambiar el precio");
        System.out.println("7.-Ver pagina web del catalogo");
        System.out.println("8.-Salir");
        System.out.println("Elige tu opcion:");
    }//Fin menu
    public static void pedirDatosCancion () {
        int clave, indice;
        System.out.println("Dime la clave de la cancion:");
        clave = entrada.nextInt();
        indice=catalogoTienda.buscarCancionPorClave(clave);
        if (indice!=-1){
            System.out.println("La clave ya existe repite la operacion:");
            return;
        }
        entrada.nextLine();
        String nombreCancionx, nombreCantantex, generox, portadax, albumx, archivox;
        double preciox;
        System.out.print("Dame el nombre de la canción: ");
        nombreCancionx = entrada.nextLine();
        System.out.print("Dame los nombres de los artistas: ");
        nombreCantantex = entrada.nextLine();
        System.out.print("Dame el género: ");
        generox=entrada.nextLine();
        System.out.print("Dame el nombre de la portada: ");
        portadax = entrada.nextLine();
        System.out.print("Dame el nombre del álbum: ");
        albumx=entrada.nextLine();
        System.out.print("Dame el nombre del archivo: ");
        archivox=entrada.nextLine();
        System.out.print("Dame el precio de la canción: ");
        preciox=entrada.nextDouble();

        Cancion cancionX = new Cancion (clave, nombreCancionx, nombreCantantex, generox,
                portadax, albumx, archivox, preciox);
        catalogoTienda.insertarCancion (cancionX);
        System.out.println("Cancion registrada");
    }

   public static void mostrarCanciones () {
      catalogoTienda.verCatalogo();
    }
    public static void cambiarNombreCancion(){
        int clave, indice;
        System.out.println("Cambiar nombre");
        System.out.print("Dame la clave de la cancion:");
        clave=entrada.nextInt();
        indice=catalogoTienda.buscarCancionPorClave(clave);
        if (indice==-1){
            System.out.println("La clave no existe, repite la operacion.");
        }else{
            entrada.nextLine();
            System.out.println("Datos de la cancion");
            catalogoTienda.mostrarCancion(indice);
            System.out.println();
            System.out.print("Dame le nuevo nombre de la cancion:");
            String nombreCancion=entrada.nextLine();
            catalogoTienda.cambiarNombreCancion(indice, nombreCancion);
            archivox.escribirEnArchivo(catalogoTienda.getListaCanciones());
            System.out.println("Cambios guardados");
        }
        System.out.println();
    }
    private static void borrarCancion(){
        int clave, indice;
        System.out.print("Dame la clave de la cancion a borrar:");
        clave=entrada.nextInt();
        indice=catalogoTienda.buscarCancionPorClave(clave);
        if (indice==-1){
            System.out.println("La clave no existe, repite la operacion");
        }else{
            catalogoTienda.borrarCancion(clave);
            System.out.println("La cancion se ha eliminado");
        }
    }
    private static void buscarCancion(){
        int clave, indice;
        System.out.print("Dame la clave de la cancion a buscar:");
        clave=entrada.nextInt();
        indice=catalogoTienda.buscarCancionPorClave(clave);
        if (indice==-1){
            System.out.println("La clave no existe, repite la operacion");
        }else{
            catalogoTienda.mostrarCancion(indice);
        }
    }
    public static void verPaginaWebCatalogoCompleto(){
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
}
