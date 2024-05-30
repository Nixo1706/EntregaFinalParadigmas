package co.edu.poli.proyecto.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import co.edu.poli.proyecto.modelo.Reserva;

/**
 * Implementación de la interfaz OperacionArchivo para la serialización y
 * deserialización de objetos Reserva.
 */
public class ImpleOperacionArchivo implements OperacionArchivo {

    /**
     * Serializa un arreglo de reservas y lo guarda en un archivo.
     *
     * @param reservas el arreglo de reservas a serializar.
     * @param path     la ruta donde se guardará el archivo.
     * @param name     el nombre del archivo.
     */
    @Override
    public void serealizar(Reserva[] reservas, String path, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(path + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(reservas);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Deserializa un archivo y devuelve un arreglo de reservas.
     *
     * @param path la ruta donde se encuentra el archivo.
     * @param name el nombre del archivo a deserializar.
     * @return el arreglo de reservas deserializado.
     */
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
