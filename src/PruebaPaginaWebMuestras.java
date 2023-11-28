public class PruebaPaginaWebMuestras {
    public static void main(String[] args) {
        // Crea una instancia de la clase PáginaHTMLMuestras con el nombre de archivo "CancionesMuestra.html"
        PaginaHTMLMuestras pagina = new PaginaHTMLMuestras ("CancionesMuestra.html");

        // Llama al método crearPagina() para generar y escribir el contenido HTML en el archivo
        pagina.crearPagina();
    }
}
