package co.edu.poli.proyecto.servicios;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import co.edu.poli.proyecto.modelo.*;

public class ImpleOperacionArchivo implements OperacionArchivo {

	@Override
	public void serealizar(Reserva[] reservas, String path, String name) {
		try {
			FileOutputStream fos = new FileOutputStream (path + name);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(reservas);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	@Override
	public Reserva[] deserealizar(String path, String name) {
		Reserva[] reservas = null;
        try {
		FileInputStream fis = new FileInputStream(path + name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        reservas = (Reserva[]) ois.readObject();
        ois.close();
        fis.close();
      } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
      }
      return reservas;
	}


}