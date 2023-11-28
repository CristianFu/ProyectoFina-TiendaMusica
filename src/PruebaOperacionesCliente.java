import java.util.Scanner;

public class PruebaOperacionesCliente {
    private static final Scanner entrada = new Scanner(System.in);
    private static final OperacionesCliente cliente = new OperacionesCliente();
    private static final ArchivoSaldo archivox = new ArchivoSaldo("saldo.txt");

    public static void mainOperacionesCliente() {
        archivox.leerDeArchivo();
        int opcion;

        do {
            menu();
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    cliente.verCancionesCatalogo();
                    break;
                case 2:
                    cliente.verPaginaWebCatalogoCompleto();
                    break;
                case 3:
                    System.out.println("_________________________________________");
                    cliente.verCancionesCatalogo();
                    System.out.println("_________________________________________");
                    System.out.println(" *COMPRAR CANCIÓN*");
                    comprarCancion();
                    archivox.escribirEnArchivo();
                    System.out.println("------------------------------------");
                    System.out.println("Lista canciones compradas");
                    cliente.verCancionesCompradas();
                    break;
                case 4:
                    cliente.abonarSaldo();
                    break;
                case 5:
                    cliente.verPaginaWebCancionesCompradas();
                    break;
                case 6:
                    cliente.verSaldo();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No válido");
                    break;
            }
        } while (opcion != 7);
    }

    private static void menu() {
        System.out.println("---------------------------------");
        System.out.println("Operaciones Clientes");
        System.out.println("1.- Ver catálogo");
        System.out.println("2.- Ver catálogo WEB");
        System.out.println("3.- Comprar canción");
        System.out.println("4.- Abonar saldo");
        System.out.println("5.- Ver canciones compradas WEB");
        System.out.println("6.- Ver saldo");
        System.out.println("7.- Salir");
        System.out.print("Elige tu opción: ");
    }
    

    private static void comprarCancion() {
        System.out.println("Saldo actual: " + Globales.saldo);
        System.out.print("Dime la clave de la canción a comprar: ");
        int clave = entrada.nextInt();
        int indice = cliente.buscarCancion(clave);

        if (indice == -1) {
            System.out.println("La clave no existe");
            return;
        }

        // Verificar que no se haya comprado
        int indiceC = cliente.buscarCancionComprada(clave);
        if (indiceC != -1) {
            System.out.println("La canción ya ha sido comprada");
            return;
        }

        cliente.comprarCancion(indice);
        cliente.cobrarCancion(indice);
        System.out.println("**Gracias por tu compra**");
        System.out.println("Tu saldo es: " + Globales.saldo);
    }
    public void abonarSaldo() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a abonar: $");
        double cantidadAbonar = entrada.nextDouble();

        if (cantidadAbonar > 0) {
            double saldo = cantidadAbonar;
            System.out.println("Abono exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("La cantidad a abonar debe ser mayor que cero.");
        }
    }
    public void verSaldo(String saldo) {
        System.out.println("Tu saldo actual es: $" + saldo);
    }
}
