import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PaginaHTMLCompradas {
    private List<Cancion> listaCancionesCompradas;
    private String nombrePagina;

    // Constructor y métodos necesarios...

    public void crearPagina() {
        String primeraParte = String.join("\n",
                "<!DOCTYPE html>",
                "<html lang='en'>",
                "<head>",
                "<meta charset='UTF-8'>",
                "<title>Catálogo Música Comprada</title>",
                "<link href='css/bootstrap.min.css' rel='stylesheet' type='text/css'>",
                "<style>",
                "#cuerpo{",
                "margin:100px;",
                "}",
                "</style>",
                "</head>",
                "<body>",
                "<div id='cuerpo'>",
                "<h1>Catálogo de Música comprada</h1>"
        );

        String ultimaParte = String.join("\n",
                "</div>",
                "<script src='js/jquery.min.js'></script>",
                "<script src='js/bootstrap.min.js'></script>",
                "</body>",
                "</html>"
        );

        String registro = "";
        for (Cancion aux : listaCancionesCompradas) {
            registro +=
                    "<tr>" +
                            "<td>" +
                            "<img src='img/" + aux.getPortada() + "' width='50' height='50' alt=''>" +
                            "</td>" +
                            "<td>" +
                            "<audio src='audio/" + aux.getArchivo() + "' controls></audio>" +
                            "</td>" +
                            "<td>" + aux.getNombreCancion() + "</td>" +
                            "<td>" + aux.getNombreCantante() + "</td>" +
                            "</tr>";
        }

        String tablaCanciones = String.join("\n",
                "<table class='table table-striped'>",
                "<thead>",
                "<tr>",
                "<th>Carátula</th>",
                "<th>Audio</th>",
                "<th>Nombre de la canción</th>",
                "<th>Artísta</th>",
                "</tr>",
                "</thead>",
                "<tbody>",
                registro,
                "</tbody>",
                "</table>"
        );

        try {
            PrintWriter salidaArchivo = new PrintWriter(nombrePagina);
            salidaArchivo.println(primeraParte + tablaCanciones + ultimaParte);
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
