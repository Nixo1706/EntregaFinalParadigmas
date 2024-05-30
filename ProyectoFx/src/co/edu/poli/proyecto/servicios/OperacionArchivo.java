package co.edu.poli.proyecto.servicios;
import co.edu.poli.proyecto.modelo.*;

public interface OperacionArchivo {
    public void serealizar(Reserva [ ] reservas, String path, String name);
    public Reserva [ ] deserealizar(String path, String name);

}