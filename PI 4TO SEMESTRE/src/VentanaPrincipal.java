import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JButton btnLogin, btnRegistro, btnSalir;

    public VentanaPrincipal() {
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
}
