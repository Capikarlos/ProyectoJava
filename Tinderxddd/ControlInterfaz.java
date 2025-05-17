import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ControlInterfaz {
    public static void main(String[] args){
        Interfaz interfaz = new Interfaz();
        Scanner scanner = new Scanner(System.in);

        //Registrar ciudades
        interfaz.registrarCiudad(new Ciudades("Ciudad_1", 2, 2));
        interfaz.registrarCiudad(new Ciudades("Ciudad_2", 6, 7));
        interfaz.registrarCiudad(new Ciudades("Ciudad_3", 10, 6));
        interfaz.registrarCiudad(new Ciudades("Ciudad_4", 15, 4));
        interfaz.registrarCiudad(new Ciudades("Ciudad_5", 1, 7));
        interfaz.registrarCiudad(new Ciudades("Ciudad_6", 8, 3));

        //Registrar usuarios
        Usuario u1 = new Usuario(
            1,
            "Capi",
            19,
            interfaz.buscarCiudadPorNombre("Ciudad_1"),
            List.of("Ajedrez", "Programar", "Chatgptear"),
            "Masculino",
            "123"
        );
        interfaz.registrarUsuario(u1);

        Usuario u2 = new Usuario(
            2,
            "XL",
            20,
            interfaz.buscarCiudadPorNombre("Ciudad_2"),
            List.of("Dormir", "Leer", "Bailar"),
            "Femenino",
            "123"
        );
        interfaz.registrarUsuario(u2);

        Usuario u3 = new Usuario(
            3,
            "Rod",
            30,
            interfaz.buscarCiudadPorNombre("Ciudad_4"),
            List.of("PP", "Bases de datos", "Mates discretas"),
            "Masculino",
            "123"
        );
        interfaz.registrarUsuario(u3);

        Usuario u4 = new Usuario(
            4,
            "El qso",
            19,
            interfaz.buscarCiudadPorNombre("Ciudad_6"),
            List.of("Jugar", "Balatrear", "Mentarsela al capi"),
            "Masculino",
            "123"
        );
        interfaz.registrarUsuario(u4);

        Usuario u5 = new Usuario(
            5,
            "El pinche nata",
            22,
            interfaz.buscarCiudadPorNombre("Ciudad_3"),
            List.of("Dormir", "No se", "Chambear"),
            "Masculino",
            "123"
        );
        interfaz.registrarUsuario(u5);

        u2.agregarMatch(u3);
        u3.agregarMatch(u2);

        u2.agregarLikeUsuarios(u1);
        u3.agregarLikeUsuarios(u1);

        int num_Usuarios = 6; //para saber que ID se registrara, se inicia en 6 pq ya hay otros dos IDs ocupados

        //Comienzo
        while (true) {
            System.out.println("\n\n=====TINDER 2.0=====");
            System.out.println("1. Ingresar con usuario");
            System.out.println("2. Registrar nuevo usaurio");
            System.out.println("3. Cerrar");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:
                    System.out.println("\n\n=====TINDER 2.0=====");
                    System.out.println("Ingrese su ID: ");
                    int id_temp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese su contrasena: ");
                    String contra_temp = scanner.nextLine();

                    Usuario gomitas_de_chamoy = interfaz.validarUsuarioExistente(contra_temp, id_temp);
                    if(gomitas_de_chamoy == null){
                        System.out.println("ID o contrasena invalidas");
                    }else{
                        interfaz.sesionIniciada(gomitas_de_chamoy);
                    }
                    break;
                
                case 2:
                    //Nuevo usuario
                    System.out.println("\n\n=====TINDER 2.0=====");
                    System.out.println("Bienvenido, ingrese su nombre: ");
                    String name = scanner.nextLine();

                    System.out.println("Ahora su edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("De donde eres: ");
                    String city = scanner.nextLine();
                    Ciudades ciudad = interfaz.buscarCiudadPorNombre(city);
                    if(ciudad == null){
                        System.out.println("Se ingreso una ciudad inexistente, no ha sido posible registrar al usuario");
                        break;
                    }

                    System.out.println("Ingresa tu genero: ");
                    String genere = scanner.nextLine();

                    System.out.println("Ingresa una contrasena: ");
                    String contra = scanner.nextLine();
                    System.out.println("Su contrasena ha sido validada, no la olvide... su ID es " + num_Usuarios);

                    System.out.println("\n\nVanmos a personalizar tu perfil, ingresa tus tres actividades favoritas: ");
                    List<String> hobList = new ArrayList<>(); 
                    for(int i=0; i<3; i++){
                        System.out.println("Ingresa la actividad " + (i+1) + ":");
                        hobList.add(scanner.nextLine());
                    }

                    interfaz.registrarUsuario(new Usuario(num_Usuarios, name, edad, ciudad, hobList, genere, contra));
                    System.out.println("El usuario se registro con exito");
                    num_Usuarios++;

                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
}
