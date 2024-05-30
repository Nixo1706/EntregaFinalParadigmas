package co.edu.poli.proyecto.servicios;

import co.edu.poli.proyecto.modelo.Reserva;

/**
 * Interfaz que define operaciones básicas de gestión de reservas.
 */
public interface Operacion {

    /**
     * Crea una nueva reserva.
     *
     * @param reser la reserva a crear.
     * @return un mensaje indicando el resultado de la operación.
     */
    public String create(Reserva reser);

    /**
     * Lee una reserva a partir de su ID.
     *
     * @param id el ID de la reserva a leer.
     * @return la reserva correspondiente al ID, o null si no se encuentra.
     */
    public Reserva read(int id);

    /**
     * Actualiza una reserva existente con una nueva reserva.
     *
     * @param id el ID de la reserva a actualizar.
     * @param reser la nueva reserva con la que se actualizará.
     */
    public void update(int id, Reserva reser);

    /**
     * Elimina una reserva a partir de su ID.
     *
     * @param id el ID de la reserva a eliminar.
     * @return un mensaje indicando el resultado de la operación.
     */
    public String delete(int id);
}
