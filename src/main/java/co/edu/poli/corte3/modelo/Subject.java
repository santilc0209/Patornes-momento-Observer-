package co.edu.poli.corte3.modelo;

public interface Subject {
    void agregarObserver(Observer o);
    void removerObserver(Observer o);
    void notificarObservers();
}
