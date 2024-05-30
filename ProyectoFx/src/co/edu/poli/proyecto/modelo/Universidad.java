package co.edu.poli.proyecto.modelo;
import java.io.Serializable;
import java.util.Arrays;

public class Universidad implements Serializable{

    public Universidad() {
    }

    private String nombre;
    private Laboratorio [ ] cantidadLaboratorios;
    private Usuario [ ] usuarios;
    private String ubicacion;
	public Universidad(String nombre, Laboratorio[] cantidadLaboratorios, Usuario[] usuarios, String ubicacion) {
		super();
		this.nombre = nombre;
		this.cantidadLaboratorios = cantidadLaboratorios;
		this.usuarios = usuarios;
		this.ubicacion = ubicacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Laboratorio[] getCantidadLaboratorios() {
		return cantidadLaboratorios;
	}
	public void setCantidadLaboratorios(Laboratorio[] cantidadLaboratorios) {
		this.cantidadLaboratorios = cantidadLaboratorios;
	}
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	@Override
	public String toString() {
		return "Universidad [nombre=" + nombre + ", cantidadLaboratorios=" + Arrays.toString(cantidadLaboratorios)
				+ ", usuarios=" + Arrays.toString(usuarios) + ", ubicacion=" + ubicacion + "]";
	}
    
    

}