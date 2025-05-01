package co.edu.poli.corte3.controlador;

import co.edu.poli.corte3.modelo.*;
import co.edu.poli.corte3.vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private ProductoModel modelo;
    private Vista vista;

    public Controlador(ProductoModel modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.modelo.agregarObservador(vista);

        this.vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        this.vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarProducto();
            }
        });

        this.vista.getBtnDeshacer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.deshacer();
            }
        });

        this.vista.setVisible(true);
    }

    private void agregarProducto() {
        String nombre = vista.getNombreProducto();
        double precio = vista.getPrecioProducto();

        if (nombre.isEmpty() || precio <= 0) {
            vista.mostrarMensaje("Nombre y precio válidos son obligatorios.");
            return;
        }

        Producto producto = new Producto(nombre, precio);
        modelo.agregarProducto(producto);
    }

    private void modificarProducto() {
        int index = vista.getProductoSeleccionadoIndex();
        String nombre = vista.getNombreProducto();
        double precio = vista.getPrecioProducto();

        if (index < 0 || nombre.isEmpty() || precio <= 0) {
            vista.mostrarMensaje("Seleccione un producto válido y complete los campos.");
            return;
        }

        modelo.modificarProducto(index, nombre, precio);
    }
}
