import java.util.ArrayList;
import java.util.List;

public class Compatibilidad {
    public static List<Usuario> paHacerMatch(Usuario u1, List<Usuario> posibleMatch){
        List<Usuario> posible_match_ordenado = new ArrayList<>();

        List<Usuario> uList = new ArrayList<>();
        List<Integer> p_uList = new ArrayList<>();

        for(Usuario u : posibleMatch){
            if(u1.getId() != u.getId()){
                int p_compatibilidad = Compatibilidad.porcentajeCompatibilidad(u1, u);
                p_uList.add(p_compatibilidad);
                uList.add(u);
            }
        }

        // Insertion sort descendente basado en porcentaje de compatibilidad
        for (int i = 1; i < p_uList.size(); i++) {
            int key = p_uList.get(i);
            Usuario keyUser = uList.get(i);
            int j = i - 1;

            // Mover elementos mayores al key hacia adelante
            while (j >= 0 && p_uList.get(j) < key) {
                p_uList.set(j + 1, p_uList.get(j));
                uList.set(j + 1, uList.get(j));
                j--;
            }

            p_uList.set(j + 1, key);
            uList.set(j + 1, keyUser);
        }

        posible_match_ordenado.addAll(uList);
        return posible_match_ordenado;
    }




    public static int porcentajeCompatibilidad(Usuario u1, Usuario u2){
        //Distancia 25%, hobbies 50%, rango de edad 25%
        int compatibilidadTotal;

        int p_dist;
        int distancia = distanciaEuclidiana(u1.ubicacion_ciudad.coordsCiudad_x, u2.ubicacion_ciudad.coordsCiudad_x, u1.ubicacion_ciudad.coordsCiudad_y, u2.ubicacion_ciudad.coordsCiudad_y);
        if(distancia == 0){
            p_dist = 25;
        }else if(distancia < 10){
            p_dist = 20;
        }else if(distancia < 20){
            p_dist = 10;
        }else{
            p_dist = 0;
        }

        int p_hobbies, hobbies_compartidos=0;
        for(String u1_1 : u1.getHobbies()){
            for(String u2_1 : u2.getHobbies()){
                if(u1_1.equals(u2_1)){
                    hobbies_compartidos++;
                    break;
                }
            }  
        }

        if(hobbies_compartidos >= 3){
            p_hobbies = 50;
        }else if(hobbies_compartidos == 2){
            p_hobbies = 30;
        }else if(hobbies_compartidos == 1){
            p_hobbies = 15;
        }else{
            p_hobbies = 0;
        }

        int p_rEdad;
        if(Math.abs(u1.edad - u2.edad) < 5){
            p_rEdad = 25;
        }else if(Math.abs(u1.edad - u2.edad) < 8){
            p_rEdad = 15;
        }else if(Math.abs(u1.edad - u2.edad) < 12){
            p_rEdad = 5;
        }else{
            p_rEdad = 0;
        }

        compatibilidadTotal = p_dist + p_rEdad + p_hobbies;
        return compatibilidadTotal;
    }
    
    private static int distanciaEuclidiana(int x1, int x2, int y1, int y2){
        return (((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
    }
}
