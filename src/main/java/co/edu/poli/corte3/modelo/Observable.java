package co.edu.poli.corte3.modelo;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void agregarObserver(Observer observer) {
        observers.add(observer);  // Añadir un nuevo observador
    }

    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.actualizar();  // Notificar a todos los observadores
        }
    }
}
