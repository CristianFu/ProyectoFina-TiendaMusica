import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Globales {
    public static double saldo;
    public static double getSaldo() {
        File f = new File("saldo.txt");
        try  (Scanner entrada = new Scanner(f)) {
            //Cuando terminan los int empiezan los double
            while (entrada.hasNextDouble()) { //mientras queden double por leer
               saldo = entrada.nextDouble(); //se lee un double del archivo
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return saldo;
    }
}