import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MuestrasHTML {
    private String nombrePagina;
    private Archivo archivox = new Archivo("canciones.txt");
    private ArrayList<Cancion> listaCanciones;

    public MuestrasHTML (String nombreA) {
        this.nombrePagina = nombreA;
        // Corrige la lectura de canciones desde el archivo
        this.listaCanciones = archivox.leerDeArchivo();
    }

    public void crearPagina() {
        String primeraParte = String.join("\n",
                "<!DOCTYPE html>",
                "<html lang='en'>",
                "<head>",
                "<meta charset='UTF-8'>",
                "<title>Catálogo Música Muestras</title>",
                "<link href='css/bootstrap.min.css' rel='stylesheet' type='text/css'>",
                "<style>",
                "#cuerpo{",
                "margin:100px;",
                "}",
                "</style>",
                "</head>",
                "<body>",
                "<div id='cuerpo'>",
                "<h1>Catálogo de Música Muestras</h1>",
                "<table class='table table-striped'>",
                "<thead>",
                "<tr>",
                "<th>Carátula</th>",
                "<th>Audio</th>",
                "<th>Nombre de la canción</th>",
                "<th>Artísta</th>",
                "<th>Precio</th>",
                "</tr>",
                "</thead>",
                "<tbody>"
        );

        String ultimaParte = String.join("\n",
                "</tbody>",
                "</table>",
                "</div>",
                "<script src='js/jquery.min.js'></script>",
                "<script src='js/bootstrap.min.js'></script>",
                "</body>",
                "</html>"
        );

        StringBuilder registro = new StringBuilder();
        for (Cancion aux : listaCanciones) {
            registro.append("<tr>")
                    .append("<td>")
                    .append("<img src='img/").append(aux.getPortada()).append("' width='50' height='50' alt=''>")
                    .append("</td>")
                    .append("<td>")
                    .append("<audio src='audio2/").append(aux.getArchivo()).append("' controls></audio>")
                    .append("</td>")
                    .append("<td>").append(aux.getNombreCancion()).append("</td>")
                    .append("<td>").append(aux.getNombreCantante()).append("</td>")
                    .append("<td>$").append(aux.getPrecio()).append("</td>")
                    .append("</tr>");
        }

        try {
            PrintWriter salidaArchivo = new PrintWriter(nombrePagina);
            salidaArchivo.println(primeraParte + registro.toString() + ultimaParte);
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

