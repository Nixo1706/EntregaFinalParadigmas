package co.edu.poli.proyecto.modelo;

import java.io.Serializable;

/**
 * Clase que representa un laboratorio en el sistema.
 */
public class Laboratorio implements Serializable {

    /**
     * Constructor por defecto de la clase Laboratorio.
     */
    public Laboratorio() {
    }

    private String salon;
    private int cantidadReservas;
    private int capacidadUsuarios;

    /**
     * Constructor de la clase Laboratorio.
     *
     * @param salon el nombre del laboratorio.
     * @param cantidadReservas la cantidad de reservas realizadas en el laboratorio.
     * @param capacidadUsuarios la capacidad máxima de usuarios permitida en el laboratorio.
     */
    public Laboratorio(String salon, int cantidadReservas, int capacidadUsuarios) {
        super();
        this.salon = salon;
        this.cantidadReservas = cantidadReservas;
        this.capacidadUsuarios = capacidadUsuarios;
    }

    /**
     * Obtiene el nombre del laboratorio.
     *
     * @return el nombre del laboratorio.
     */
    public String getSalon() {
        return salon;
    }

    /**
     * Establece el nombre del laboratorio.
     *
     * @param salon el nombre del laboratorio a establecer.
     */
    public void setSalon(String salon) {
        this.salon = salon;
    }

    /**
     * Obtiene la cantidad de reservas realizadas en el laboratorio.
     *
     * @return la cantidad de reservas realizadas en el laboratorio.
     */
    public int getCantidadReservas() {
        return cantidadReservas;
    }

    /**
     * Establece la cantidad de reservas realizadas en el laboratorio.
     *
     * @param cantidadReservas la cantidad de reservas a establecer.
     */
    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    /**
     * Obtiene la capacidad máxima de usuarios permitida en el laboratorio.
     *
     * @return la capacidad máxima de usuarios permitida en el laboratorio.
     */
    public int getCapacidadUsuarios() {
        return capacidadUsuarios;
    }

    /**
     * Establece la capacidad máxima de usuarios permitida en el laboratorio.
     *
     * @param capacidadUsuarios la capacidad máxima de usuarios a establecer.
     */
    public void setCapacidadUsuarios(int capacidadUsuarios) {
        this.capacidadUsuarios = capacidadUsuarios;
    }

    /**
     * Retorna una representación en forma de cadena de texto de la instancia Laboratorio.
     *
     * @return una cadena de texto que representa la instancia Laboratorio.
     */
    @Override
    public String toString() {
        return "Laboratorio [salon=" + salon + ", cantidadReservas=" + cantidadReservas + ", capacidadUsuarios="
                + capacidadUsuarios + "]";
    }
}
