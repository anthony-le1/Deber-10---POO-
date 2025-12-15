package Main;

import Formulario.FormularioCV;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Crear ventana
        JFrame frame = new JFrame("Mi Hoja de Vida - Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear formulario
        FormularioCV formulario = new FormularioCV();
        JPanel panel = formulario.getPanelPrincipal();

        panel.setBackground(new Color(245, 245, 245)); // Gris claro
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen interno

        frame.setContentPane(panel);

        // Tamaño de ventana
        frame.setSize(850, 700);
        frame.setMinimumSize(new Dimension(800, 650));
        frame.setLocationRelativeTo(null);

        // Mostrar ventana
        frame.setVisible(true);
    }
}

