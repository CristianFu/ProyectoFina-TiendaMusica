import java.util.Scanner;
public class ModoCliente {
    private static final Scanner entrada = new Scanner(System.in);

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

    // Método para mostrar el menú al usuario
    private static void menu() {
        System.out.println("---------------------------------");
        System.out.println("Operaciones Clientes");
        System.out.println("1.- Comprar canción");
        System.out.println("2.- Abonar saldo");
        System.out.println("3.- Ver saldo");
        System.out.println("4.- Salir");
        System.out.println("Elige tu opción: ");
    }

    // Método para abonar saldo a la cuenta
    public static void abonarSaldo() {
        System.out.println("Dame la cantidad a abonar: ");
        double cantidad = entrada.nextDouble();
        Globales.saldo = Globales.getSaldo() + cantidad;
        System.out.println("Ahora el saldo es: " + Globales.saldo);
        escribirNuevoSaldo(Globales.saldo);
    }

    // Método para comprar una canción y descontar el saldo
    public static void comprarCancion() {
        double precioCancion = 20; // Precio simulado de la canción
        if (Globales.getSaldo() >= precioCancion) {
            System.out.println("El precio de la canción es: " + precioCancion);
            Globales.saldo = Globales.saldo - precioCancion;
            System.out.println("Saldo después de comprar una canción: " + Globales.saldo);
            escribirNuevoSaldo(Globales.saldo);
        } else {
            System.out.println("Saldo no suficiente");
        }
    }

    // Método para mostrar el saldo actual
    public static void verSaldo() {
        System.out.println("Saldo recuperado: " + Globales.getSaldo());
        Globales.saldo = Globales.getSaldo(); // Se sustituye por el valor del txt
        System.out.println("Saldo actual: " + Globales.saldo);
    }

    // Método para escribir el nuevo saldo en un archivo
    private static void escribirNuevoSaldo(double nuevoSaldo) {
        try {
            java.io.PrintWriter salidaArchivo = new java.io.PrintWriter("Saldo.txt");
            salidaArchivo.println(nuevoSaldo);
            salidaArchivo.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
