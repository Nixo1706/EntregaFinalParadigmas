package co.edu.poli.proyecto.modelo;
import java.time.LocalTime;
import java.io.Serializable;

public class TiempoReserva implements Serializable {

    public TiempoReserva() {
    }

    private String fecha;
    private LocalTime horaInicio;
	public TiempoReserva(String fecha, LocalTime horaInicio) {
		super();
		this.fecha = fecha;
		this.horaInicio = horaInicio;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	@Override
	public String toString() {
		return "TiempoReserva [fecha=" + fecha + ", horaInicio=" + horaInicio + "]";
	}
	public LocalTime calcularHoraFin(LocalTime horaInicio) {
		return horaInicio.plusHours(2);
	}

    
	
}