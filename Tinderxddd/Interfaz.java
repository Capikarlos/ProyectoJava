import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Interfaz {
    Scanner scanner = new Scanner(System.in);
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Ciudades> listaCiudades = new ArrayList<>();

    public void registrarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }

    public void registrarCiudad(Ciudades ciudad){
        listaCiudades.add(ciudad);
    }

    public Usuario validarUsuarioExistente(String contrasena, int id){
        for(Usuario u : listaUsuarios){
            if(u.getId() == id && u.getContrasena().equals(contrasena)){
                return u;
            }
        }
        return null;
    }

    public Ciudades buscarCiudadPorNombre(String nombre) {
    for (Ciudades c : listaCiudades) {
            if (c.getNombre_ciudad().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    public void sesionIniciada(Usuario usuario){
        int opcion = 0;
        while(opcion != 3){
            System.out.println("\n\n=====TINDER 2.0=====");
            System.out.println("Bienvenido " + usuario.getNombre());
            System.out.println("\nQue desea realizar\n1.Buscar Matchs\n2.Ver Matchs\n3.Cerrar sesion");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1: //Buscar match
                    Match.mostrarUsuariosPosibleMatch(usuario, listaUsuarios);
                    
                    break;
                case 2: //Ver match
                    usuario.verMatch();
                    break;
                case 3: //Cerrar sesion
                    System.out.println("Cerrando sesion... Hasta luego " + usuario.getNombre() + "!");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }    
        }
    }

    
}
