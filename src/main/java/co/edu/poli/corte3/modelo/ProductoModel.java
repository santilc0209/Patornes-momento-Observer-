package co.edu.poli.corte3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProductoModel {
    private List<Producto> productos;
    private Stack<ProductoMemento> historial;
    private List<Observer> observadores;

    public ProductoModel() {
        productos = new ArrayList<>();
        historial = new Stack<>();
        observadores = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        guardarEstado();
        productos.add(producto);
        notificarObservadores();
    }

    public void modificarProducto(int index, String nombre, double precio) {
        if (index >= 0 && index < productos.size()) {
            guardarEstado();
            Producto p = productos.get(index);
            p.setNombre(nombre);
            p.setPrecio(precio);
            notificarObservadores();
        }
    }

    public void deshacer() {
        if (!historial.isEmpty()) {
            ProductoMemento memento = historial.pop();
            productos = new ArrayList<>();
            for (Producto p : memento.getEstado()) {
                productos.add(new Producto(p));
            }
            notificarObservadores();
        }
    }

    private void guardarEstado() {
        List<Producto> copia = new ArrayList<>();
        for (Producto p : productos) {
            copia.add(new Producto(p));
        }
        historial.push(new ProductoMemento(copia));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarObservador(Observer o) {
        observadores.add(o);
    }

    public void notificarObservadores() {
        for (Observer o : observadores) {
            o.actualizar(new ArrayList<>(productos));
        }
    }
    
}
