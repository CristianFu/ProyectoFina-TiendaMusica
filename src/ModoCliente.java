import java.util.ArrayList;
import java.util.Scanner;

public class ModoCliente {
    private static final Scanner entrada = new Scanner(System.in);
    ArrayList<Cancion> listaCanciones;

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    comprarCancion();
                    break;
                case 2:
                    abonarSaldo();
                    break;
                case 3:
                    verSaldo();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No válido");
                    break;
            }
        } while (opcion != 4);
    }

    private static void menu() {
        System.out.println("---------------------------------");
        System.out.println("Operaciones Clientes");
        System.out.println("1.- Comprar canción");
        System.out.println("2.- Abonar saldo");
        System.out.println("3.- Ver saldo");
        System.out.println("4.- Salir");
        System.out.println("Elige tu opción: ");
    }

    public static void abonarSaldo() {
        double nuevoSaldo;
        System.out.println("Dame la cantidad a abonar: ");
        double cantidad = entrada.nextDouble();
        nuevoSaldo = Globales.getSaldo() + cantidad;
        System.out.println("Ahora el saldo es: " + nuevoSaldo);
        Globales.escribirSaldo(nuevoSaldo);
        return;
    }

    public static void comprarCancion() {
        double precioCancion = 20;
        if (Globales.getSaldo() >= precioCancion) {
            System.out.println("El precio de la canción es: " + precioCancion);
            double nuevoSaldo = Globales.saldo - precioCancion;
            System.out.println("Saldo después de comprar una canción: " + nuevoSaldo);
            Globales.escribirSaldo(nuevoSaldo);
        } else {
            System.out.println("Saldo no suficiente");
        }
        return;
    }

    public static void verSaldo() {
        System.out.println("Saldo recuperado: " + Globales.getSaldo());
        // Cambiar saldo
        Globales.saldo = Globales.getSaldo(); // Se sustituye por el valor del txt
        System.out.println("Saldo actual: " + Globales.saldo);
        return;
    }
}
