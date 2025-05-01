package co.edu.poli.corte3;

import co.edu.poli.corte3.controlador.Controlador;
import co.edu.poli.corte3.vista.Vista;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vista vista = new Vista();
            vista.setVisible(true);
            new Controlador(vista);  // Crear e iniciar el controlador
        });
    }
}
