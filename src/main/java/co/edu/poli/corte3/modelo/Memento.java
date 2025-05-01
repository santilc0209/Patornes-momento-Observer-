package co.edu.poli.corte3.modelo;

import java.util.ArrayList;

public class Memento {
    private ArrayList<Producto> estado;

    public Memento(ArrayList<Producto> productos) {
        // Clonación profunda para evitar modificaciones en el estado original
        this.estado = new ArrayList<>();
        for (Producto p : productos) {
            this.estado.add(new Producto(p.getNombre(), p.getPrecio()));
        }
    }

    public ArrayList<Producto> getProductos() {
        // Retorna una copia para evitar modificaciones directas
        ArrayList<Producto> copia = new ArrayList<>();
        for (Producto p : estado) {
            copia.add(new Producto(p.getNombre(), p.getPrecio()));
        }
        return copia;
    }
}
