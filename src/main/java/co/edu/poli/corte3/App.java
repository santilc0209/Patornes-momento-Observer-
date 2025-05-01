package co.edu.poli.corte3;

import co.edu.poli.corte3.modelo.ProductoModel;
import co.edu.poli.corte3.vista.Vista;
import co.edu.poli.corte3.controlador.Controlador;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ProductoModel modelo = new ProductoModel();
            Vista vista = new Vista();
            new Controlador(modelo, vista);
        });
    }
}
