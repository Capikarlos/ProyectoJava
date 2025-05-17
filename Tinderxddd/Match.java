import java.util.Scanner;
import java.util.List;

public class Match{
    public static void mostrarUsuariosPosibleMatch(Usuario u1, List<Usuario> posibles_matchs){
        Scanner scanner = new Scanner(System.in);
        List<Usuario> matchsOrdenados = Compatibilidad.paHacerMatch(u1, posibles_matchs);
        int i=1, hayCandidatos=0;
        int opcion = -1;
        for(Usuario candidato : matchsOrdenados){
            if(opcion == 3){
                break;
            }
            if(!noMostrarGenteQueYaPaso(u1, candidato)){
                continue;
            }

            System.out.println("\n\n==========TINDER 2.0==========");
            System.out.println("1. Me gusta");
            System.out.println("2. No me gusta");
            System.out.println("3. Dejar de revisar");
            System.out.println("\n\n=======Persona " + i + "=======");

            System.out.println("Nombre: " + candidato.getNombre());
            System.out.println("Genero: " + candidato.getGenero());
            System.out.println("Ubicacion: " + candidato.getUbicacion_ciudad().nombre_ciudad);
            System.out.println("Edad: " + candidato.getEdad());

            int j=1;
            System.out.println("\nLe gusta:");
            for(String hob_candidato : candidato.getHobbies()){
                System.out.println(j + ". " + hob_candidato);
                j++;
            }
            
            System.out.println("=======================\nQue desas hacer: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    u1.agregarLikeUsuarios(candidato);
                    System.out.println(candidato.getNombre() + " Se ha anadido a tus me gustas, si tu tambien le gustas haran match!");
                    hacerMatch(candidato, u1);
                    break;
                case 2:
                    //No hace nada (en realidad pus avanza al sig candidato)
                    break;
                case 3:
                    System.out.println("Volviendo a la pantalla anterior...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            hayCandidatos++;
        }
        if(hayCandidatos==0){
            System.out.println("Por el momento no hay usuarios disponibles");
        }
    }

    //Revisar si la lista de likes del candidato tambien tiene añadido a alguien mas y si si, hacen match
    public static void hacerMatch(Usuario u1, Usuario u2){
        for(Usuario listaLikesU1 : u1.getLikeUsuarios()){
            if(listaLikesU1.equals(u2)){
                u1.agregarMatch(u2);
                u2.agregarMatch(u1);
                System.out.println("Se ha producido un match!!!");
            }
        }
    }

    //Si ya se le dio me gusta o no me gusta a alguien o ya hicieron match, no mostrar
    public static boolean noMostrarGenteQueYaPaso(Usuario u1, Usuario u2){
        for(Usuario u : u1.getNoLikeUsuarios()){
            if(u.equals(u2)){
                return false;
            }
        }
        for(Usuario u : u1.getLikeUsuarios()){
            if(u.equals(u2)){
                return false;
            }
        }
        for(Usuario u : u1.getMatchList()){
            if(u.equals(u2)){
                return false;
            }
        }
        return true;
    }
}
