package co.edu.poli.proyecto.servicios;
import co.edu.poli.proyecto.modelo.*;

public interface OperacionArchivo {
	/**
	 * Serializa un arreglo de reservas y guarda el resultado en un archivo en el sistema de archivos.
	 * 
	 * @param curso Arreglo de reservas a serializar.
	 * @param path Ruta donde se guardará el archivo.
	 * @param nombre Nombre del archivo a generar.
	 */
    public void serealizar(Reserva [ ] reservas, String path, String name);
	/**
	 * Deserializa un archivo del sistema de archivos y devuelve un arreglo de reservas.
	 * 
	 * @param path Ruta donde se encuentra el archivo.
	 * @param nombre Nombre del archivo a deserializar.
	 * @return Arreglo de reservas deserializado.
	 */
    public Reserva [ ] deserealizar(String path, String name);

}