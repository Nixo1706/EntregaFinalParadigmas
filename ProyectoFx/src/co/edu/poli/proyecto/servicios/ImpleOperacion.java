package co.edu.poli.proyecto.servicios;
import java.util.Arrays;
import co.edu.poli.proyecto.modelo.Reserva;

public class ImpleOperacion implements Operacion {

    
    public Reserva [ ] reservas;
    int cont = 0;
    
    public Reserva[] getReservas() {
		return reservas;
	}
	public ImpleOperacion() {
    	reservas = new Reserva[4];
    }
	@Override
	public String create(Reserva reser) {
		if (cont==reservas.length) {
			reservas=Arrays.copyOf(reservas, reservas.length*2);
		}
		reservas[cont] = reser;
		cont ++;
		return "Reserva creada exitosamente";
	}
	@Override
	public Reserva read(int id) {
		for (int i = 0; i < reservas.length; i++) {
			 if (reservas[i]!= null) {
	            	if (reservas[i].getId()==id) {
	            		return reservas[i];
	            	}
	            }
		 }
		 System.out.println("No se encontró la reserva con ID "+id);
	        return null;
	}
	@Override
	public void update(int id, Reserva reser) {
		for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].getId() == id) {
            	reservas[i] = reser;
                return;
            }
        }
		
	}
	@Override
	public String delete(int id) {
		for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].getId() == id) {
            	reservas[i] = null;
                return "Reserva eliminada exitosamente.";
            }
        }
        return "No se encontro ninguna reserva";
		
	}
	//Queda pendiente el estado de la reserva, se aplica en la parte gráfica
	//Botón refresh
	//Reservas disponibles
}