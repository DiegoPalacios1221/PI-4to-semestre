public class DatosUsuario {
    private String nombre;
    private String apellido;
    private int cc;
    private int telefono;
    private String email;
    private String usuario;
    private String contrasena;
    private String direccion;

    public DatosUsuario(String nombre, String apellido, int cc, int telefono, String email, String usuario, String contrasena, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cc = cc;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}
