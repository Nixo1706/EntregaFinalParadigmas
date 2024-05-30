package co.edu.poli.proyecto.modelo;

import java.time.LocalTime;
import java.io.Serializable;

/**
 * Clase que representa el tiempo de una reserva en el sistema.
 */
public class TiempoReserva implements Serializable {

    /**
     * Constructor por defecto de la clase TiempoReserva.
     */
    public TiempoReserva() {
    }

    private String fecha;
    private LocalTime horaInicio;

    /**
     * Constructor de la clase TiempoReserva.
     *
     * @param fecha la fecha de la reserva.
     * @param horaInicio la hora de inicio de la reserva.
     */
    public TiempoReserva(String fecha, LocalTime horaInicio) {
        super();
        this.fecha = fecha;
        this.horaInicio = horaInicio;
    }

    /**
     * Obtiene la fecha de la reserva.
     *
     * @return la fecha de la reserva.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param fecha la fecha de la reserva a establecer.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de inicio de la reserva.
     *
     * @return la hora de inicio de la reserva.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Establece la hora de inicio de la reserva.
     *
     * @param horaInicio la hora de inicio de la reserva a establecer.
     */
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Retorna una representación en forma de cadena de texto de la instancia TiempoReserva.
     *
     * @return una cadena de texto que representa la instancia TiempoReserva.
     */
    @Override
    public String toString() {
        return "TiempoReserva [fecha=" + fecha + ", horaInicio=" + horaInicio + "]";
    }

    /**
     * Calcula la hora de finalización de la reserva sumando 2 horas a la hora de inicio.
     *
     * @param horaInicio la hora de inicio de la reserva.
     * @return la hora de finalización de la reserva.
     */
    public LocalTime calcularHoraFin(LocalTime horaInicio) {
        return horaInicio.plusHours(2);
    }

}
