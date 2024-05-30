package co.edu.poli.proyecto.modelo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que representa una universidad en el sistema.
 */
public class Universidad implements Serializable {

    /**
     * Constructor por defecto de la clase Universidad.
     */
    public Universidad() {
    }

    private String nombre;
    private Laboratorio[] cantidadLaboratorios;
    private Usuario[] usuarios;
    private String ubicacion;

    /**
     * Constructor de la clase Universidad.
     *
     * @param nombre              el nombre de la universidad.
     * @param cantidadLaboratorios los laboratorios de la universidad.
     * @param usuarios            los usuarios asociados a la universidad.
     * @param ubicacion           la ubicación de la universidad.
     */
    public Universidad(String nombre, Laboratorio[] cantidadLaboratorios, Usuario[] usuarios, String ubicacion) {
        super();
        this.nombre = nombre;
        this.cantidadLaboratorios = cantidadLaboratorios;
        this.usuarios = usuarios;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el nombre de la universidad.
     *
     * @return el nombre de la universidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la universidad.
     *
     * @param nombre el nombre de la universidad a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los laboratorios de la universidad.
     *
     * @return los laboratorios de la universidad.
     */
    public Laboratorio[] getCantidadLaboratorios() {
        return cantidadLaboratorios;
    }

    /**
     * Establece los laboratorios de la universidad.
     *
     * @param cantidadLaboratorios los laboratorios de la universidad a establecer.
     */
    public void setCantidadLaboratorios(Laboratorio[] cantidadLaboratorios) {
        this.cantidadLaboratorios = cantidadLaboratorios;
    }

    /**
     * Obtiene los usuarios asociados a la universidad.
     *
     * @return los usuarios asociados a la universidad.
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    /**
     * Establece los usuarios asociados a la universidad.
     *
     * @param usuarios los usuarios asociados a la universidad a establecer.
     */
    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Obtiene la ubicación de la universidad.
     *
     * @return la ubicación de la universidad.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la universidad.
     *
     * @param ubicacion la ubicación de la universidad a establecer.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Retorna una representación en forma de cadena de texto de la instancia Universidad.
     *
     * @return una cadena de texto que representa la instancia Universidad.
     */
    @Override
    public String toString() {
        return "Universidad [nombre=" + nombre + ", cantidadLaboratorios=" + Arrays.toString(cantidadLaboratorios)
                + ", usuarios=" + Arrays.toString(usuarios) + ", ubicacion=" + ubicacion + "]";
    }

}
