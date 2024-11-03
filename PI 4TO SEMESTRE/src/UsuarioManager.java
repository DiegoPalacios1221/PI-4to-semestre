public class UsuarioManager {
    private static DatosUsuario[] usuarios = new DatosUsuario[10];
    private static int numeroUsuarios = 0;

    public static boolean registrarUsuario(DatosUsuario usuario) {
        if (numeroUsuarios < usuarios.length) {
            usuarios[numeroUsuarios] = usuario;
            numeroUsuarios++;
            return true;
        }
        return false;
    }

    public static boolean verificarUsuario(String usuario, String contrasena) {
        for (int i = 0; i < numeroUsuarios; i++) {
            if (usuarios[i].getUsuario().equals(usuario) && usuarios[i].getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}
