package uo.mp.lab05.dome.model.interfaces;

/**
 * Interfaz para items prestables.
 * 
 * @author enol
 *
 */
public interface Borrowable {

    /**
     * Indica si un item prestable está disponible.
     * 
     * @return true si lo está, false en caso contrario.
     */
    boolean isAvailable();

    /**
     * Método para prestar un item.
     */
    void borrow();

    /**
     * Método para devolver un item.
     */
    void giveBack();

}
