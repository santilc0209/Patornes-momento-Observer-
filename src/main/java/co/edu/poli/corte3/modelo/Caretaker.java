package co.edu.poli.corte3.modelo;

import java.util.Stack;

public class Caretaker {
    private Stack<ProductoMemento> historial = new Stack<>();

    public void guardarMemento(ProductoMemento memento) {
        historial.push(memento);
    }

    public ProductoMemento deshacer() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }

    public boolean hayCambios() {
        return !historial.isEmpty();
    }
}
