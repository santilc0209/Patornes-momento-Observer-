package co.edu.poli.corte3.modelo;

public interface Observer {
    void actualizar();  // Método a ser implementado por los observadores
}
// Este método se llamará cuando el observable notifique a sus observadores sobre un cambio en su estado