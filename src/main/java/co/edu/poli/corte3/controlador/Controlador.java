package co.edu.poli.corte3.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.poli.corte3.modelo.ProductoModel;
import co.edu.poli.corte3.vista.Vista;

public class Controlador {
    private ProductoModel modelo;
    private Vista vista;

    public Controlador(ProductoModel modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Registrar vista como observador del modelo
        this.modelo.agregarObserver(this.vista);

        // Mostrar la vista
        this.vista.setVisible(true);

        // Acción para agregar producto
        this.vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.getNombreProducto();
                double precio = vista.getPrecioProducto();

                if (nombre.isEmpty() || precio <= 0) {
                    vista.mostrarMensaje("Datos inválidos. Por favor, complete todos los campos correctamente.");
                } else {
                    modelo.agregarProducto(nombre, precio);
                }
            }
        });

        // Acción para modificar producto
        this.vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = vista.getProductoSeleccionadoIndex();
                String nombre = vista.getNombreProducto();
                double precio = vista.getPrecioProducto();

                if (index >= 0 && !nombre.isEmpty() && precio > 0) {
                    modelo.modificarProducto(index, nombre, precio);
                } else {
                    vista.mostrarMensaje("Seleccione un producto y asegúrese de ingresar datos válidos.");
                }
            }
        });

        // Acción para deshacer cambios
        this.vista.getBtnDeshacer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.deshacerCambios();
            }
        });
    }
}
