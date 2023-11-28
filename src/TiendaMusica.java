import java.util.Scanner;

public class TiendaMusica {
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    administrador();
                    break;
                case 2:
                    cliente();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }

    public static void menu() {
        System.out.println("------------------------------------");
        System.out.println("¿Cómo quiere ingresar?");
        System.out.println("1.- Administrador");
        System.out.println("2.- Cliente");
        System.out.println("3.- Salir");
        System.out.print("Elige la opción: ");
    }

    public static void administrador() {
        System.out.println("Estás entrando como administrador");
        Scanner entrada = new Scanner(System.in);
        String pass = "Ingeniero-ICO27";
        boolean autenticado = false;
        int intentos = 0;

        System.out.println("********************************");
        do {
            System.out.println("Ingrese la contraseña para poder entrar: ");
            String password = entrada.next();
            if (password.equals(pass)) {
                autenticado = true;
            } else {
                intentos++;
                System.out.println("La contraseña es incorrecta");
                System.out.println("Intento " + intentos + " de 3");
            }
        } while (intentos < 3 && !autenticado);

        if (intentos == 3 && !autenticado) {
            System.out.println("********************************");
            System.out.println("Número de intentos excedidos");
            return;
        }

        System.out.println("********************************");
        System.out.println("Bienvenido, puedes continuar");

        // Llamar al método mainOperacionesAdministrador de la clase PruebaOperacionesAdministrador
        PruebaOperacionesAdministrador.mainOperacionesAdministrador();
    }

    public static void cliente() {
        System.out.println("Estás entrando como cliente");
        PruebaOperacionesCliente.mainOperacionesCliente();
    }
}
