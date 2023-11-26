public class Cancion {
    private int clave;
    private String nombreCancion;
    private String nombreCantante;
    private String genero;
    private String portada;
    private String album;
    private String archivo;
    private double precio;

    public Cancion(int clave, String nombreCancion, String nombreCantante, String genero, String portada, String album, String archivo, double precio) {
        this.clave = clave;
        this.nombreCancion = nombreCancion;
        this.nombreCantante = nombreCantante;
        this.genero = genero;
        this.portada = portada;
        this.album = album;
        this.archivo = archivo;
        this.precio = precio;
    }

    public Cancion() {
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getNombreCantante() {
        return nombreCantante;
    }

    public void setNombreCantante(String nombreCantante) {
        this.nombreCantante = nombreCantante;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String formatoArchivo() {
        return clave + "|" + nombreCancion +
                "|" + nombreCantante + "|" + genero + "|" +
                portada + "|" + album + "|" + archivo + "|" + precio;
    }

    public String toString() {
        return "Cancion{" + " clave= " + clave +
                " nombreCancion= '" + nombreCancion + '\'' + " nombreCantante= '" + nombreCantante + '\'' +
                " ,genero= '" + genero + '\'' + " ,portada= '" + portada + '\'' + " ,album= '" + album + '\'' +
                " ,archivo= '" + archivo + '\'' + " ,precio= '" + precio + '}';
    }
}




