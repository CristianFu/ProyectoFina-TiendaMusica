import java.util.ArrayList;
import java.util.Iterator;

public class Catalogo {
    private ArrayList<Cancion> listaCanciones;
    private ArrayList<Cancion> listaCancionesCompradas;

    public Catalogo() {
        listaCanciones = new ArrayList<>();
        listaCancionesCompradas = new ArrayList<>();
    }

    public ArrayList<Cancion> getListaCancionesCompradas() {
        return listaCancionesCompradas;
    }

    public void insertarCancionComprada(Cancion cancionx) {
        listaCancionesCompradas.add(cancionx);
    }

    public ArrayList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void insertarCancion(Cancion cancionx) {
        listaCanciones.add(cancionx);
    }

    public void verCatalogo() {
        System.out.printf("%-8s|%-30s|%-30s|%-8s\n", "Clave", "Nombre Cancion", "Artista", "Precio");
        System.out.println("--------|------------------------|-----------------------------|--------");
        for (Cancion aux : this.getListaCanciones()) {
            System.out.printf("%-8d|%-30s|%-30s|$%-6.2f\n", aux.getClave(), aux.getNombreCancion(),
                    aux.getNombreCantante(), aux.getPrecio());
        }
    }

    public int buscarCancionPorClave(int claveBuscar) {
        for (int i = 0; i < listaCanciones.size(); i++) {
            if (listaCanciones.get(i).getClave() == claveBuscar) {
                return i;
            }
        }
        return -1;
    }

    public void cambiarNombreCancion(int indice, String nuevoNombre) {
        Cancion cancionAux = listaCanciones.get(indice);
        cancionAux.setNombreCancion(nuevoNombre);
    }

    public void cambiarPrecioCancion(int indice, double nuevoPrecio) {
        Cancion cancionAux = listaCanciones.get(indice);
        cancionAux.setPrecio(nuevoPrecio);
    }

    public void borrarCancion(int clave) {
        Iterator<Cancion> cancionIterator = listaCanciones.iterator();
        while (cancionIterator.hasNext()) {
            Cancion cancionx = cancionIterator.next();
            if (clave == cancionx.getClave()) {
                cancionIterator.remove();
            }
        }
    }

    public void mostrarCancion(int indice) {
        Cancion aux = listaCanciones.get(indice);
        System.out.printf("%-8s|%-30s|%-30s|%-8s\n", "Clave", "Nombre Cancion", "Artista", "Precio");
        System.out.println("------|------------------------|-------------------------|-------");
        System.out.printf("%-8d||%-30s|%-30s|$%-6.2f\n", aux.getClave(), aux.getNombreCancion(),
                aux.getNombreCantante(), aux.getPrecio());
    }

    public void setListaCanciones(ArrayList<Cancion> lista) {
        this.listaCanciones = lista;
    }

    public void getDatosCancion(int indice) {
        listaCanciones.get(indice);
    }
}
