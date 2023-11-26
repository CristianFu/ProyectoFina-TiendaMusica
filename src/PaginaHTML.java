import java.io.*;
import java.util.ArrayList;

public class PaginaHTML {
    private String nombrePagina;
    private Archivo archivox = new Archivo("cancionex.txt");
    private ArrayList<Cancion> listaCanciones;
    private String backgroundColor = "#69ed9c";  // Color de fondo predeterminado
    private String textColor = "#111111";  // Color de texto predeterminado

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
                "<link href='css/bootstrap.min.css'",
                "rel='stylesheet'type='text/css'>",
                "<style>",
                "body {",
                "background-color: " + backgroundColor + ";",
                "color: " + textColor + ";",
                "font-family: 'Arial', sans-serif;",
                "}",
                "#cuerpo{",
                "margin:100px;",
                "}",
                "h1 {",
                "color: #fff;",
                "font-family: 'Impact', sans-serif;",
                "}",
                "th {",
                "background-color: #333;",
                "}",
                "tbody tr:nth-child(odd) {",
                "background-color: #555;",
                "}",
                "tbody tr:nth-child(even) {",
                "background-color: #444;",
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
                            "'width='50' height='50' alt=''>" +
                            "</td>" +
                            "<td>" +
                            "<audio src='audio/" + aux.getArchivo() + "'controls>" +
                            "</audio>" +
                            "</td>" +
                            "<td>" + aux.getNombreCancion() + "</td>" +
                            "<td>" + aux.getNombreCantante() + "</td>" +
                            "<td>$" + aux.getPrecio() + "</td>" +
                            "</td>";
        }

        String tablaCanciones = String.join("\n",
                "<table class='table table-striped'>",
                "<thead>",
                "<tr>",
                "<th>Caratula</th>",
                "<th>Audio</th>",
                "<th>Nombre de la canción</th>",
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

    public void guardarEstilos(String backgroundColor, String textColor) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }
}
