package co.edu.poli.corte3.controlador;

import co.edu.poli.corte3.modelo.*;
import co.edu.poli.corte3.vista.Vista;

import java.util.ArrayList;

public class Controlador {
    private Vista vista;
    private Observable observable;
    private ArrayList<Producto> productos;
    private Memento memento;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.productos = new ArrayList<>();
        this.observable = new Observable();
        this.observable.agregarObserver(vista); // Registrar la vista como observador

        // Establecer los listeners de los botones
        this.vista.getBtnAgregar().addActionListener(e -> agregarProducto());
        this.vista.getBtnModificar().addActionListener(e -> modificarProductoSeleccionado());
        this.vista.getBtnDeshacer().addActionListener(e -> deshacerCambios());
    }

    private void agregarProducto() {
        guardarEstado();
        String nombre = vista.getNombreProducto();
        double precio = vista.getPrecioProducto();
        if (nombre != null && !nombre.isEmpty() && precio > 0) {
            productos.add(new Producto(nombre, precio));
            actualizarVista();
            observable.notificarObservers(); // Notificar a los observadores
        }
    }

    private void modificarProductoSeleccionado() {
        int index = vista.getProductoSeleccionadoIndex();
        if (index == -1) {
            vista.mostrarMensaje("Debe seleccionar un producto para modificarlo.");
            return;
        }
        if (index >= 0 && index < productos.size()) {
            guardarEstado();
            String nuevoNombre = vista.getNombreProducto();
            double nuevoPrecio = vista.getPrecioProducto();
            if (nuevoNombre != null && nuevoPrecio > 0) {
                productos.get(index).setNombre(nuevoNombre);
                productos.get(index).setPrecio(nuevoPrecio);
                actualizarVista();
                observable.notificarObservers(); // Notificar a los observadores
            }
        }
    }

    private void deshacerCambios() {
        if (memento != null) {
            productos = memento.getProductos();  // Restaurar estado anterior
            actualizarVista();
            observable.notificarObservers(); // Notificar a los observadores
        }
    }

    private void guardarEstado() {
        memento = new Memento(productos);  // Guardar el estado actual
    }

    private void actualizarVista() {
        vista.actualizarLista(productos);  // Actualizar la vista con la lista de productos
    }
}
