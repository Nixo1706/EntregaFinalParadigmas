package co.edu.poli.proyecto.modelo;
import java.io.Serializable;
public class Usuario implements Serializable {

    public Usuario() {
    }

    private String nombre;
    private int id;
    private String correoUni;
	public Usuario(String nombre, int id, String correoUni) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.correoUni = correoUni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreoUni() {
		return correoUni;
	}
	public void setCorreoUni(String correoUni) {
		this.correoUni = correoUni;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", id=" + id + ", correoUni=" + correoUni + "]";
	}

   

}