package co.edu.poli.proyecto.modelo;

import java.io.Serializable;

public class Laboratorio implements Serializable {

    public Laboratorio() {
    }

    private String salon;
    private int cantidadReservas;
    private int capacidadUsuarios;
	public Laboratorio(String salon, int cantidadReservas, 
			int capacidadUsuarios) {
		super();
		this.salon = salon;
		this.cantidadReservas = cantidadReservas;
		this.capacidadUsuarios = capacidadUsuarios;
	}
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	public int getCantidadReservas() {
		return cantidadReservas;
	}
	public void setCantidadReservas(int cantidadReservas) {
		this.cantidadReservas = cantidadReservas;
	}
	public int getCapacidadUsuarios() {
		return capacidadUsuarios;
	}
	public void setCapacidadUsuarios(int capacidadUsuarios) {
		this.capacidadUsuarios = capacidadUsuarios;
	}
	@Override
	public String toString() {
		return "Laboratorio [salon=" + salon + ", cantidadReservas=" + cantidadReservas + ", capacidadUsuarios="
				+ capacidadUsuarios + "]";
	}
	
    
    

}