package co.edu.poli.corte3.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements Subject {
    private List<Producto> productos;
    private List<Observer> observers;
    private Caretaker caretaker;

    public ProductoModel() {
        productos = new ArrayList<>();
        observers = new ArrayList<>();
        caretaker = new Caretaker();
    }

    public void agregarProducto(String nombre, double precio) {
        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        notificarObservers();
    }

    public void modificarProducto(int index, String nuevoNombre, double nuevoPrecio) {
        if (index >= 0 && index < productos.size()) {
            Producto producto = productos.get(index);
            caretaker.guardarMemento(producto.guardarEstado());
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            notificarObservers();
        }
    }

    public void deshacerCambios() {
        if (caretaker.hayCambios() && !productos.isEmpty()) {
            Producto producto = productos.get(productos.size() - 1);
            ProductoMemento memento = caretaker.deshacer();
            if (memento != null) {
                producto.restaurarEstado(memento);
                notificarObservers();
            }
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public void agregarObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removerObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notificarObservers() {
        for (Observer o : observers) {
            o.actualizar();
        }
    }
}
