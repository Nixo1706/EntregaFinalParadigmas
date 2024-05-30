package co.edu.poli.proyecto.modelo;
import java.io.Serializable;
public class Reserva implements Serializable{

 
    public Reserva() {
    }
    
    private int id;
    private Laboratorio laboratorio;
    private Usuario usuarioReserva;
    private TiempoReserva horarioReserva ;
    private String estado;
	public Reserva(int id, Laboratorio laboratorio, Usuario usuarioReserva, TiempoReserva horarioReserva,
			String estado) {
		super();
		this.id = id;
		this.laboratorio = laboratorio;
		this.usuarioReserva = usuarioReserva;
		this.horarioReserva = horarioReserva;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Usuario getUsuarioReserva() {
		return usuarioReserva;
	}
	public void setUsuarioReserva(Usuario usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
	}
	public TiempoReserva getHorarioReserva() {
		return horarioReserva;
	}
	public void setHorarioReserva(TiempoReserva horarioReserva) {
		this.horarioReserva = horarioReserva;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", laboratorio=" + laboratorio + ", usuarioReserva=" + usuarioReserva
				+ ", horarioReserva=" + horarioReserva + ", estado=" + estado + "]";
	}
    
    

    

}