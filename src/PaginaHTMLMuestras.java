import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PaginaHTMLMuestras {
    private String nombrePagina;
    private Archivo archivox = new Archivo("CANCIONEX.txt");
    private ArrayList<Cancion> listaCanciones;

    public PaginaHTMLMuestras(String nombreA) {
        this.nombrePagina = nombreA;
        listaCanciones = archivox.leerDeArchivo();
    }

    public void crearPagina() {
        String primeraParte = String.join("\n",
                "<!DOCTYPE html>",
                "<html lang='en'>",
                "<head>",
                "  <meta charset='UTF-8'>",
                "  <title>Catalogo Musica</title>",
                "  <link href='css/bootstrap.min.css' rel='stylesheet' type='text/css'>",
                "  <style>",
                "    #cuerpo {",
                "      margin: 100px;",
                "    }",
                "    .table-striped tbody tr:nth-child(odd) {",
                "      background-color: #f2f2f2; ",
                "    }",
                "  </style>",
                "</head>",
                "<body>",
                "  <div id='cuerpo'>",
                "    <h1>Catalogo de Musica Muestra</h1>"
        );

        String ultimaParte = String.join("\n",
                "  </div>",
                "  <script src='js/jquery.min.js'></script>",
                "  <script src='js/bootstrap.min.js'></script>",
                "</body>",
                "</html>"
        );

        String registro = "";
        for (Cancion aux : listaCanciones) {
            registro += String.format(
                    "    <tr>" +
                            "      <td>" +
                            "        <img src='img/%s' width='50' height='50' alt=''>" +
                            "      </td>" +
                            "      <td>" +
                            "        <audio src='audio2/%s' controls></audio>" +
                            "      </td>" +
                            "      <td>%s</td>" +
                            "      <td>%s</td>" +
                            "      <td>$%.2f</td>" +
                            "    </tr>",
                    aux.getPortada(),
                    aux.getArchivo(),
                    aux.getNombreCancion(),
                    aux.getNombreCantante(),
                    aux.getPrecio()
            );
        }

        String tablaCanciones = String.join("\n",
                "    <table class='table table-striped'>",
                "      <thead>",
                "        <tr>",
                "          <th>Carátula</th>",
                "          <th>Audio</th>",
                "          <th>Nombre de la canción</th>",
                "          <th>Artista</th>",
                "          <th>Precio</th>",
                "        </tr>",
                "      </thead>",
                "      <tbody>",
                registro,
                "      </tbody>",
                "    </table>"
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
