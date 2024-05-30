package co.edu.poli.proyecto.modelo;

import java.io.Serializable;

/**
 * Clase que representa una reserva en el sistema.
 */
public class Reserva implements Serializable {

    /**
     * Constructor por defecto de la clase Reserva.
     */
    public Reserva() {
    }

    private int id;
    private Laboratorio laboratorio;
    private Usuario usuarioReserva;
    private TiempoReserva horarioReserva;
    private String estado;

    /**
     * Constructor de la clase Reserva.
     *
     * @param id el identificador de la reserva.
     * @param laboratorio el laboratorio reservado.
     * @param usuarioReserva el usuario que realiza la reserva.
     * @param horarioReserva el horario de la reserva.
     * @param estado el estado de la reserva.
     */
    public Reserva(int id, Laboratorio laboratorio, Usuario usuarioReserva, TiempoReserva horarioReserva, String estado) {
        super();
        this.id = id;
        this.laboratorio = laboratorio;
        this.usuarioReserva = usuarioReserva;
        this.horarioReserva = horarioReserva;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador de la reserva.
     *
     * @return el identificador de la reserva.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la reserva.
     *
     * @param id el identificador de la reserva a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el laboratorio reservado.
     *
     * @return el laboratorio reservado.
     */
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    /**
     * Establece el laboratorio reservado.
     *
     * @param laboratorio el laboratorio a establecer.
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * Obtiene el usuario que realiza la reserva.
     *
     * @return el usuario que realiza la reserva.
     */
    public Usuario getUsuarioReserva() {
        return usuarioReserva;
    }

    /**
     * Establece el usuario que realiza la reserva.
     *
     * @param usuarioReserva el usuario a establecer.
     */
    public void setUsuarioReserva(Usuario usuarioReserva) {
        this.usuarioReserva = usuarioReserva;
    }

    /**
     * Obtiene el horario de la reserva.
     *
     * @return el horario de la reserva.
     */
    public TiempoReserva getHorarioReserva() {
        return horarioReserva;
    }

    /**
     * Establece el horario de la reserva.
     *
     * @param horarioReserva el horario a establecer.
     */
    public void setHorarioReserva(TiempoReserva horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    /**
     * Obtiene el estado de la reserva.
     *
     * @return el estado de la reserva.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la reserva.
     *
     * @param estado el estado a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna una representación en forma de cadena de texto de la instancia Reserva.
     *
     * @return una cadena de texto que representa la instancia Reserva.
     */
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", laboratorio=" + laboratorio + ", usuarioReserva=" + usuarioReserva
                + ", horarioReserva=" + horarioReserva + ", estado=" + estado + "]";
    }
}
