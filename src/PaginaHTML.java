import java.io.*;
import java.util.ArrayList;

public class PaginaHTML {
    private String nombrePagina;
    private Archivo archivox = new Archivo("cancionex.txt");
    private ArrayList<Cancion> listaCanciones;

    public PaginaHTML(String nombreA) {
        this.nombrePagina = nombreA;
        listaCanciones = archivox.leerDeArchivo();
    }

    public void crearPagina() {
        String primeraParte = String.join("\n",
                "<!DOCTYPE html>",
                "<html lang='en'>",
                "<head>",
                "<meta charset='UTF-8'>",
                "<title>Catalogo Musica</title>",
                "<link href='css/bootstrap.min.css' rel='stylesheet' type='text/css'>",
                "<style>",
                "#cuerpo {",
                "  margin: 100px;",
                "}",
                ".table-striped tbody tr:nth-child(odd) {",
                "  background-color: #f2f2f2; ",
                "}",
                "</style>",
                "</head>",
                "<body>",
                "<div id='cuerpo'>",
                "<h1>Catalogo de musica</h1>"
        );

        String ultimaParte = String.join("\n",
                "</div>",
                "<script src='js/jquery.min.js'></script>",
                "<script src='js/bootstrap.min.js'></script>",
                "</body>",
                "</html>"
        );

        String registro = "";
        for (Cancion aux : listaCanciones) {
            registro +=
                    "<tr>" +
                            "<td>" +
                            "<img src='img/" + aux.getPortada() +
                            "' width='50' height='50' alt=''>" +
                            "</td>" +
                            "<td>" +
                            "<audio src='audio/" + aux.getArchivo() + "' controls>" +
                            "</audio>" +
                            "</td>" +
                            "<td>" + aux.getNombreCancion() + "</td>" +
                            "<td>" + aux.getNombreCantante() + "</td>" +
                            "<td>$" + aux.getPrecio() + "</td>" +
                            "</tr>";
        }

        String tablaCanciones = String.join("\n",
                "<table class='table table-striped'>",
                "<thead>",
                "<tr>",
                "<th>Caratula</th>",
                "<th>Audio</th>",
                "<th>Nombre de la cancion</th>",
                "<th>Artista</th>",
                "<th>Precio</th>",
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
