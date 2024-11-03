import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JFrame implements ActionListener {
    private JTextField txtNombre, txtApellido, txtCC, txtTelefono, txtEmail, txtUsuario, txtDireccion;
    private JPasswordField txtPassword;
    private JButton btnRegistrar, btnRegresar;

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
            new VentanaPrincipal();
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
        if (UsuarioManager.registrarUsuario(nuevoUsuario)) {
            JOptionPane.showMessageDialog(this, "Registro exitoso");
            new VentanaPrincipal(); // Volver a la ventana principal
            dispose(); // Cerrar la ventana de registro
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar. Arreglo lleno.");
        }
    }
}
