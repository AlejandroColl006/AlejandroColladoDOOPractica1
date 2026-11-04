package model;

import java.util.ArrayList;
import java.util.List;


public class Coleccion {

    private final ArrayList<ElementoColeccionable> elementos;

    public Coleccion() {
        this.elementos = new ArrayList<ElementoColeccionable>();
    }

    public void añadirMoneda (Moneda moneda) {
        if (moneda == null) {
            throw new IllegalArgumentException("No se puede añadir una moneda vacía ");
        }
        elementos.add(moneda);
    }

    public void añadirSello (Sello sello) {
        if (sello == null) {
            throw new IllegalArgumentException("No se puede añadir un sello vacío");
        }
        elementos.add(sello);
    }

    public List<Moneda> getMonedas() {
        List<Moneda> monedas = new ArrayList<>();
        for (ElementoColeccionable elemento : elementos) {
            if (elemento instanceof Moneda) {
                monedas.add((Moneda) elemento);}
        }
        return monedas;
    }

    public List<Sello> getSellos() {
        List<Sello> sellos = new ArrayList<>();
        for (ElementoColeccionable elemento : elementos) {
            if (elemento instanceof Sello) {
                sellos.add((Sello) elemento);}
        }
        return sellos;
    }




}
