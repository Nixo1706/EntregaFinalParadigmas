package co.edu.poli.proyecto.modelo;

import java.io.Serializable;

/**
 * Clase que representa un usuario en el sistema.
 */
public class Usuario implements Serializable {

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {
    }

    private String nombre;
    private int id;
    private String correoUni;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombre    el nombre del usuario.
     * @param id        el identificador del usuario.
     * @param correoUni el correo universitario del usuario.
     */
    public Usuario(String nombre, int id, String correoUni) {
        super();
        this.nombre = nombre;
        this.id = id;
        this.correoUni = correoUni;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre el nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return el identificador del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id el identificador del usuario a establecer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el correo universitario del usuario.
     *
     * @return el correo universitario del usuario.
     */
    public String getCorreoUni() {
        return correoUni;
    }

    /**
     * Establece el correo universitario del usuario.
     *
     * @param correoUni el correo universitario del usuario a establecer.
     */
    public void setCorreoUni(String correoUni) {
        this.correoUni = correoUni;
    }

    /**
     * Retorna una representación en forma de cadena de texto de la instancia Usuario.
     *
     * @return una cadena de texto que representa la instancia Usuario.
     */
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", id=" + id + ", correoUni=" + correoUni + "]";
    }

}
