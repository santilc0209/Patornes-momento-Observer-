package co.edu.poli.corte3;

import co.edu.poli.corte3.controlador.Controlador;
import co.edu.poli.corte3.modelo.ProductoModel;
import co.edu.poli.corte3.vista.Vista;

public class App {
    public static void main(String[] args) {
        ProductoModel modelo = new ProductoModel();
        Vista vista = new Vista();
        new Controlador(modelo, vista);
    }
}
