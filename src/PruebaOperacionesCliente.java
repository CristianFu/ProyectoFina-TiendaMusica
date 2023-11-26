import java.util.Scanner;

public class PruebaOperacionesCliente {
        private static final Scanner entrada = new Scanner(System.in);
        static OperacionesCliente cliente = new OperacionesCliente();
        public static void mainOperacionesCliente (){
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
                        comprarCancion();
                        System.out.println("-----------------------------------");
                        System.out.println("Lista canciones compradas");
                        cliente.verCancionesCompradas();
                        break;
                    case 4:
                    ModoCliente.main(new String[]{});
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("No vaido");
                        break;
                }
            }while (opcion !=6);
        }
        private static void menu(){
            System.out.println("---------------------------------");
                System.out.println("Operaciones Clientes");
                System.out.println("1.- Ver catalaogo");
                System.out.println("2.- Ver catalogo WEB");
                System.out.println("3.- Comprar cancion");
                System.out.println("4.- Abonar saldo");
                System.out.println("5.- Ver canciones compradas WEB");
                System.out.println("6.- Salir");
            System.out.println("Elige tu opcion: ");
        }
        public static void comprarCancion(){
            cliente.verCancionesCatalogo();
            System.out.println("Dime la clave de la canciona comprar: ");
            int clave=entrada.nextInt();
            int indice=cliente.buscarCancion(clave);
            if (indice==-1){
                System.out.println("La clave no existe");
                return;
            }
            //Verificar que no se haya comprado
        int indiceC=cliente.buscarCancionComprada(clave);
            if (indiceC==-1){
                System.out.println("La cancion ya ha sido comprada");
                return;
            }
            cliente.comprarCancion(indice);
        }
    }