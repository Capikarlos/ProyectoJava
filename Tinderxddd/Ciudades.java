public class Ciudades {
    protected String nombre_ciudad;
    protected int coordsCiudad_x, coordsCiudad_y;

    //Constructor
    public Ciudades(String ciudad, int x, int y){
        this.nombre_ciudad = ciudad;
        this.coordsCiudad_x = x;
        this.coordsCiudad_y = y;
    }

    //Getters y Setters
    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public int getCoordsCiudad_x() {
        return coordsCiudad_x;
    }

    public void setCoordsCiudad_x(int coordsCiudad_x) {
        this.coordsCiudad_x = coordsCiudad_x;
    }

    public int getCoordsCiudad_y() {
        return coordsCiudad_y;
    }

    public void setCoordsCiudad_y(int coordsCiudad_y) {
        this.coordsCiudad_y = coordsCiudad_y;
    }
}
