package co.edu.poli.proyecto.servicios;

import co.edu.poli.proyecto.modelo.Reserva;

import java.io.*;
import java.util.*;

public interface Operacion {

    public String create(Reserva reser);
    public Reserva read(int id);
    public void update(int id, Reserva reser);
    public String delete(int id);

}