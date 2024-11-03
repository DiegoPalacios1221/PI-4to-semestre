import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame implements ActionListener {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegresar;

    public VentanaLogin() {
        // Configurar la ventana de login
        setTitle("Iniciar Sesión");
        setSize(350, 200);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtUsuario = new JTextField(15);
        txtPassword = new JPasswordField(15);
        btnLogin = new JButton("Iniciar sesión");
        btnRegresar = new JButton("Regresar");

        btnLogin.addActionListener(this);
        btnRegresar.addActionListener(e -> {
            new VentanaPrincipal();
            dispose();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        add(txtUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnRegresar, gbc);

        gbc.gridx = 1;
        add(btnLogin, gbc);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (UsuarioManager.verificarUsuario(txtUsuario.getText(), new String(txtPassword.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");

        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }
}
