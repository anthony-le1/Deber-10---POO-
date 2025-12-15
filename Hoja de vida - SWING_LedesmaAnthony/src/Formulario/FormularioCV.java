package Formulario;

import Excepcion.FormularioException;
import java.util.regex.Pattern;
import Archivo.Archivo;
import Persona.Persona;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioCV {

    private JLabel lblHojaVida;
    private JLabel lblNombre;
    private JTextField txtCedula;
    private JTextField textNombre;
    private JTextField textEdad;
    private JLabel lblEdad;
    private JTextField textDireccion;
    private JLabel lblDireccion;
    private JTextField textCorreo;
    private JLabel lblCorreo;
    private JTextField textTelefono;
    private JLabel lblTelefono;
    private JLabel lblPerfil;
    private JLabel lblFormacion;
    private JLabel lblExperiencia;
    private JLabel lblCompetencias;
    private JLabel lblIdiomas;
    private JPanel panelPrincipal;
    private JTextArea textPerfil;
    private JTextArea textFormacion;
    private JTextArea textCompetencia;
    private JTextArea textIdiomas;
    private JLabel lblGenero;
    private JComboBox cbxGenero;
    private JButton btnGuardar;
    private JLabel lblGuardarCv;
    private JLabel lblCedula;
    private JButton btnMostrar;
    private JLabel lblMostrarCv;
    private JButton btnLimpiar;
    private JLabel lblLimpiar;
    private JTextArea textExperiencia;

    private Archivo archivo;

    public FormularioCV() {

        archivo = new Archivo();

        textPerfil.setLineWrap(true);
        textPerfil.setWrapStyleWord(true);
        textPerfil.setEditable(true);

        textFormacion.setLineWrap(true);
        textFormacion.setWrapStyleWord(true);
        textFormacion.setEditable(true);

        textCompetencia.setLineWrap(true);
        textCompetencia.setWrapStyleWord(true);
        textCompetencia.setEditable(true);

        textExperiencia.setLineWrap(true);
        textExperiencia.setWrapStyleWord(true);
        textExperiencia.setEditable(true);

        textIdiomas.setLineWrap(true);
        textIdiomas.setWrapStyleWord(true);
        textIdiomas.setEditable(true);

        // Botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persona p = crearPersonaDesdeFormulario();
                    archivo.guardar(p);
                    JOptionPane.showMessageDialog(null, "Hoja de vida guardada correctamente en hoja_vida.txt");
                    limpiarFormulario();
                } catch (FormularioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persona p = archivo.mostrar();

                    JTextArea area = new JTextArea(p.mostrarInfo());
                    area.setEditable(false);
                    area.setLineWrap(true);
                    area.setWrapStyleWord(true);

                    JScrollPane scrollPane = new JScrollPane(area);
                    scrollPane.setPreferredSize(new Dimension(550, 450));

                    JOptionPane.showMessageDialog(
                            null,
                            scrollPane,
                            "Hoja de Vida",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (FormularioException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
    }

    private Persona crearPersonaDesdeFormulario() throws FormularioException {
        // Validación de campos vacíos
        if (txtCedula.getText().trim().isEmpty() ||
                textNombre.getText().trim().isEmpty() ||
                textEdad.getText().trim().isEmpty() ||
                textDireccion.getText().trim().isEmpty() ||
                textCorreo.getText().trim().isEmpty() ||
                textTelefono.getText().trim().isEmpty() ||
                textPerfil.getText().trim().isEmpty() ||
                textFormacion.getText().trim().isEmpty() ||
                textExperiencia.getText().trim().isEmpty() ||
                textCompetencia.getText().trim().isEmpty() ||
                textIdiomas.getText().trim().isEmpty()) {
            throw new FormularioException("Todos los campos son obligatorios");
        }

        // Conversión y Validación de la Edad (String -> int)
        int edad;
        try {
            edad = Integer.parseInt(textEdad.getText());
            if (edad <= 0 || edad > 120) throw new FormularioException("Edad inválida");
        } catch (NumberFormatException e) {
            throw new FormularioException("Edad debe ser un número");
        }

        // Validación del Correo
        String correo = textCorreo.getText();
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", correo)) {
            throw new FormularioException("Correo inválido");
        }

        // Creación del objeto Persona
        return new Persona(
                txtCedula.getText(),
                textNombre.getText(),
                edad,
                textDireccion.getText(),
                correo,
                textTelefono.getText(),
                (String) cbxGenero.getSelectedItem(),
                textPerfil.getText(),
                textFormacion.getText(),
                textExperiencia.getText(),
                textCompetencia.getText(),
                textIdiomas.getText()
        );
    }

    // Método para limpiar los campos
    private void limpiarFormulario() {
        txtCedula.setText("");
        textNombre.setText("");
        textEdad.setText("");
        textDireccion.setText("");
        textCorreo.setText("");
        textTelefono.setText("");
        textPerfil.setText("");
        textFormacion.setText("");
        textExperiencia.setText("");
        textCompetencia.setText("");
        textIdiomas.setText("");
        cbxGenero.setSelectedIndex(0);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}


