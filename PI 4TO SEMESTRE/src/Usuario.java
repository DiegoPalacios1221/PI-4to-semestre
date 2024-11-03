import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario extends JFrame implements ActionListener {

    // Arreglo de usuarios
    private static DatosUsuario[] usuarios = new DatosUsuario[10];
    private static int numeroUsuarios = 0; // Contador de usuarios registrados

    // Botones de la ventana principal
    JButton btnLogin, btnRegistro, btnSalir;

    // Constructor de la ventana inicial
    public Usuario() {
        // Configurar la ventana principal
        setTitle("Bienvenidos a Vanity and Magic");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Crear componentes de la ventana
        JLabel lblBienvenida = new JLabel("Bienvenidos a Vanity and Magic", SwingConstants.CENTER);
        JLabel lblElijaOpcion = new JLabel("Elige una opción", SwingConstants.CENTER);

        btnLogin = new JButton("Iniciar sesión");
        btnRegistro = new JButton("Registrarse");
        btnSalir = new JButton("Salir");

        // Ajustar tamaño y fuente de los botones
        Font botonFont = new Font("Arial", Font.BOLD, 16);
        btnLogin.setFont(botonFont);
        btnRegistro.setFont(botonFont);
        btnSalir.setFont(botonFont);

        // Añadir listeners
        btnLogin.addActionListener(this);
        btnRegistro.addActionListener(this);
        btnSalir.addActionListener(this);

        // Añadir componentes a la ventana
        add(lblBienvenida);
        add(lblElijaOpcion);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnLogin);
        panelBotones.add(btnRegistro);
        add(panelBotones);

        add(btnSalir);

        // Mostrar la ventana
        setVisible(true);
        setLocationRelativeTo(null);
    }

    // Método para registrar un nuevo usuario
    public static boolean registrarUsuario(DatosUsuario usuario) {
        if (numeroUsuarios < usuarios.length) {
            usuarios[numeroUsuarios] = usuario;
            numeroUsuarios++;
            return true;
        }
        return false; // No se pudo registrar, arreglo lleno
    }

    // Método para verificar si un usuario existe
    public static boolean verificarUsuario(String usuario, String contrasena) {
        for (int i = 0; i < numeroUsuarios; i++) {
            if (usuarios[i].getUsuario().equals(usuario) &&
                    usuarios[i].getContrasena().equals(contrasena)) {
                return true; // Usuario encontrado
            }
        }
        return false; // Usuario no encontrado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            new VentanaLogin();
            dispose(); // Cerrar la ventana actual
        } else if (e.getSource() == btnRegistro) {
            new VentanaRegistro();
            dispose(); // Cerrar la ventana actual
        } else if (e.getSource() == btnSalir) {
            System.exit(0); // Salir del programa
        }
    }

    // Clase para la ventana de registro
    class VentanaRegistro extends JFrame implements ActionListener {
        JTextField txtNombre, txtApellido, txtCC, txtTelefono, txtEmail, txtUsuario, txtDireccion;
        JPasswordField txtPassword;
        JButton btnRegistrar, btnRegresar;

        public VentanaRegistro() {
            // Configurar la ventana de registro
            setTitle("Registrarse");
            setSize(300, 400);
            setLayout(new GridLayout(10, 2));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear componentes
            txtNombre = new JTextField();
            txtApellido = new JTextField();
            txtCC = new JTextField();
            txtTelefono = new JTextField();
            txtEmail = new JTextField();
            txtUsuario = new JTextField();
            txtPassword = new JPasswordField();
            txtDireccion = new JTextField();

            btnRegistrar = new JButton("Registrar");
            btnRegresar = new JButton("Regresar");

            // Añadir listeners
            btnRegistrar.addActionListener(this);
            btnRegresar.addActionListener(e -> {
                new Usuario();
                dispose();
            });

            // Añadir componentes a la ventana
            add(new JLabel("Nombre:"));
            add(txtNombre);
            add(new JLabel("Apellido:"));
            add(txtApellido);
            add(new JLabel("Cédula:"));
            add(txtCC);
            add(new JLabel("Teléfono:"));
            add(txtTelefono);
            add(new JLabel("Email:"));
            add(txtEmail);
            add(new JLabel("Usuario:"));
            add(txtUsuario);
            add(new JLabel("Contraseña:"));
            add(txtPassword);
            add(new JLabel("Dirección:"));
            add(txtDireccion);

            // Cambiar el orden de los botones: "Regresar" antes de "Registrar"
            add(btnRegresar);
            add(btnRegistrar);

            // Mostrar la ventana
            setVisible(true);
            setLocationRelativeTo(null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            DatosUsuario nuevoUsuario = new DatosUsuario(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    Integer.parseInt(txtCC.getText()),
                    Integer.parseInt(txtTelefono.getText()),
                    txtEmail.getText(),
                    txtUsuario.getText(),
                    new String(txtPassword.getPassword()),
                    txtDireccion.getText()
            );

            // Llamar al método para registrar un usuario
            if (registrarUsuario(nuevoUsuario)) {
                JOptionPane.showMessageDialog(this, "Registro exitoso");
                new Usuario(); // Volver a la ventana inicial
                dispose(); // Cerrar la ventana de registro
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar. Arreglo lleno.");
            }
        }
    }


    // Clase para la ventana de inicio de sesión (login)
    class VentanaLogin extends JFrame implements ActionListener {
        JTextField txtUsuario;
        JPasswordField txtPassword;
        JButton btnLogin, btnRegresar;

        public VentanaLogin() {
            // Configurar la ventana de login
            setTitle("Iniciar Sesión");
            setSize(350, 200);
            setLayout(new GridBagLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crear componentes
            txtUsuario = new JTextField(15);
            txtPassword = new JPasswordField(15);
            btnLogin = new JButton("Iniciar sesión");
            btnRegresar = new JButton("Regresar");

            // Añadir listener
            btnLogin.addActionListener(this);
            btnRegresar.addActionListener(e -> {
                new Usuario();
                dispose();
            });

            // Crear layout con GridBagConstraints
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Usuario:"), gbc);

            gbc.gridx = 1;
            add(txtUsuario, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            add(new JLabel("Contraseña:"), gbc);

            gbc.gridx = 1;
            add(txtPassword, gbc);

            // Posicionar el botón en la misma columna de los campos de texto, pero más abajo
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.EAST;
            add(btnLogin, gbc);

            // Posicionar el botón "Regresar"
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.WEST;
            add(btnRegresar, gbc);

            // Mostrar la ventana
            setVisible(true);
            setLocationRelativeTo(null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtPassword.getPassword());

            // Llamar al método para verificar usuario
            if (verificarUsuario(usuario, contrasena)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                // Aquí puedes continuar con la lógica de la siguiente ventana
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        }
    }

    // Clase DatosUsuario con los nuevos campos
    static class DatosUsuario {
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

    public static void main(String[] args) {
        new Usuario(); // Iniciar el sistema
    }
}
