import java.util.Scanner;

public class TiendaMusica {
    private static final Scanner entrada =new Scanner(System.in);
    public static void main(String[] args) {
        //Codigo validar entrada sistema
        //Admin o usu
        int opcion;
        do{
            menu();
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    //si usuario es admin
                    administrador();
                    break;
                case 2:
                    //si usario es cliente
                    cliente();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                break;
            }
        }while(opcion!=3);
    }//fin main
    public static void menu(){
        System.out.println("------------------------------------");
        System.out.println("¿Como quiere ingresar?");
        System.out.println("1.- Administrador");
        System.out.println("2.- Cliente");
        System.out.println("3.- Salir");
        System.out.print("Elige la opcion: ");
    }//fin de menu
    public static void administrador(){
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("BIENVENIDO.  * Estas entrando como administrador *");
        //pedir una contraseña para poder continuar, 3 intentos
        //si logra entrar
            Scanner entrada = new Scanner(System.in);
            String pass = "Ingenieros-ICO27";
            boolean autenticado = false;
            int intentos = 0;
            System.out.println("******************************************************");
            do {
                System.out.print("Dame la contraseña para poder ingresar: ");
                String password = entrada.next();
                if(password.equals(pass)){
                    autenticado=true;
                }else {
                    intentos++;
                    System.out.println(" * La contraseña es incorrecta  * " );
                    System.out.println();
                    System.out.println("  #  Intento " + intentos + " de 3.  #");
                }
            }while (intentos < 3 && !autenticado);
            if (intentos == 3 && !autenticado){
                System.out.println("*****************************************************");
                System.out.println("*************Numeros de intentos excedidos***********");
                System.out.println("*****************************************************");
                return;
            }
            System.out.println("***********************************************************");
            System.out.println("****************BIENVENODO PUESDES CONTINUAR****************");
            System.out.println("***********************************************************");
            PruebaOperacionesAdministrador.mainOperacionesAdministrador();
        }
    public static void cliente(){
        System.out.println("Estas entrando como cliente");
        PruebaOperacionesCliente.mainOperacionesCliente();
    }//fin cliente
}