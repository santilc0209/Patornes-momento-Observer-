package co.edu.poli.corte3.modelo;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoMemento guardarEstado() {
        return new ProductoMemento(nombre, precio);
    }

    public void restaurarEstado(ProductoMemento memento) {
        this.nombre = memento.getNombre();
        this.precio = memento.getPrecio();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
