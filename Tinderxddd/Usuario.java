import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario{
    protected String nombre;
    protected int id, edad;
    protected Ciudades ubicacion_ciudad;
    protected List<String> hobbies;
    protected String genero;
    protected String contrasena;
    protected List<Usuario> matchList = new ArrayList<>();
    protected List<Usuario> likeUsuarios = new ArrayList<>();
    protected List<Usuario> noLikeUsuarios = new ArrayList<>();

    //Constructor
    public Usuario(int id, String nombre, int edad, Ciudades ubicacion_ciudad, List<String> hobbies, String genero, String contrasena) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.ubicacion_ciudad = ubicacion_ciudad;
        this.hobbies = new ArrayList<>(hobbies);
        this.genero = genero;
        this.contrasena = contrasena;
    }

    //Metodo para agregar matchs
    public void agregarMatch(Usuario usuario_match) {
        if (!matchList.contains(usuario_match)) {
            matchList.add(usuario_match);
        }
    }

    //Metodo para agregar a likeUsuarios
    public void agregarLikeUsuarios(Usuario usuario_like){
        if (!likeUsuarios.contains(usuario_like)) {
            likeUsuarios.add(usuario_like);
        }
    }

    //Metodo para agregar a noLikeUsuarios
    public void agregarNoLikeUsuarios(Usuario usuario_no_like){
        if (!noLikeUsuarios.contains(usuario_no_like)) {
            noLikeUsuarios.add(usuario_no_like);
        }
    }

    //Metodo para ver los matchs
    public void verMatch(){
        int n=1;
        if(matchList.size()==0){
            System.out.println("No tienes ningun match disponible");
        }else{
                System.out.println(nombre + ", las personas con las que tienes match son:");
                for (Usuario u : matchList){
                System.out.println("Persona " + n + ": " + u.getNombre());
                n++;
            }
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Ciudades getUbicacion_ciudad() {
        return ubicacion_ciudad;
    }

    public void setUbicacion_ciudad(Ciudades ubicacion_ciudad) {
        this.ubicacion_ciudad = ubicacion_ciudad;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Usuario> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Usuario> matchList) {
        this.matchList = matchList;
    }

    public List<Usuario> getLikeUsuarios() {
        return likeUsuarios;
    }

    public void setLikeUsuarios(List<Usuario> likeUsuarios) {
        this.likeUsuarios = likeUsuarios;
    }

    public List<Usuario> getNoLikeUsuarios() {
        return noLikeUsuarios;
    }

    public void setNoLikeUsuarios(List<Usuario> nolikeUsuarios) {
        this.noLikeUsuarios = nolikeUsuarios;
    }

    // equals y hashCode basados en ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}