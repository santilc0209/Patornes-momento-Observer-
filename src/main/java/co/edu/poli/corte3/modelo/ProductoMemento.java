package co.edu.poli.corte3.modelo;

import java.util.List;

public class ProductoMemento {
    private final List<Producto> estado;

    public ProductoMemento(List<Producto> estado) {
        this.estado = estado;
    }

    public List<Producto> getEstado() {
        return estado;
    }
}
