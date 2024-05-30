package co.edu.poli.proyecto.servicios;

import java.util.Arrays;
import co.edu.poli.proyecto.modelo.Reserva;

/**
 * Implementación de la interfaz Operacion para gestionar reservas.
 */
public class ImpleOperacion implements Operacion {

    private Reserva[] reservas;
    private int cont = 0;

    /**
     * Constructor que inicializa el arreglo de reservas con una capacidad inicial de 4.
     */
    public ImpleOperacion() {
        reservas = new Reserva[4];
    }

    /**
     * Obtiene el arreglo de reservas.
     *
     * @return el arreglo de reservas.
     */
    public Reserva[] getReservas() {
        return reservas;
    }

    /**
     * Crea una nueva reserva y la añade al arreglo de reservas. Si el arreglo está lleno,
     * su capacidad se duplica.
     *
     * @param reser la reserva a crear.
     * @return un mensaje indicando el éxito de la operación.
     */
    @Override
    public String create(Reserva reser) {
        if (cont == reservas.length) {
            reservas = Arrays.copyOf(reservas, reservas.length * 2);
        }
        reservas[cont] = reser;
        cont++;
        return "Reserva creada exitosamente";
    }

    /**
     * Lee una reserva a partir de su ID.
     *
     * @param id el ID de la reserva a leer.
     * @return la reserva correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Reserva read(int id) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getId() == id) {
                    return reservas[i];
                }
            }
        }
        System.out.println("No se encontró la reserva con ID " + id);
        return null;
    }

    /**
     * Actualiza una reserva existente con una nueva reserva.
     *
     * @param id el ID de la reserva a actualizar.
     * @param reser la nueva reserva con la que se actualizará.
     */
    @Override
    public void update(int id, Reserva reser) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].getId() == id) {
                reservas[i] = reser;
                return;
            }
        }
    }

    /**
     * Elimina una reserva a partir de su ID.
     *
     * @param id el ID de la reserva a eliminar.
     * @return un mensaje indicando el éxito o fallo de la operación.
     */
    @Override
    public String delete(int id) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].getId() == id) {
                reservas[i] = null;
                return "Reserva eliminada exitosamente.";
            }
        }
        return "No se encontró ninguna reserva";
    }
}
