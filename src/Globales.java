import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Globales {
    public static double saldo;

    // Método para obtener el saldo desde el archivo
    public static double getSaldo() {
        File f = new File("saldo.txt");
        try (Scanner entrada = new Scanner(f)) {
            // Leer el saldo del archivo mientras haya doubles por leer
            while (entrada.hasNextDouble()) {
                saldo = entrada.nextDouble(); // Se lee un double del archivo
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return saldo;
    }

    // Método para escribir el saldo en el archivo
    public static void escribirSaldo(double saldo) {
        try {
            PrintWriter salidaArchivo = new PrintWriter("Saldo.txt");
            salidaArchivo.print(saldo);
            salidaArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
