package model;

public class Moneda extends ElementoColeccionable {

    // Atributos
    private String composicion;
    private double peso;
    private double diametro;
    private double grosor;
    private EstadoConservacionMoneda estadoConservacion;


public Moneda (String pais, String autoridadGobernante, int annus, double valor,
              String unidadMonetaria, int rareza, double precio,
              String composicion, double peso, double diametro, double grosor,
              EstadoConservacionMoneda estadoConservacion) throws RarezaInvalidaException {
    super(pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio);
    this.composicion = composicion;
    this.peso = peso;
    this.diametro = diametro;
    this.grosor = grosor;
    this.estadoConservacion = estadoConservacion;
}

// Getters
    public String getComposicion() {
        return composicion;
    }

    public double getPeso() {
        return peso;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getGrosor() {
        return grosor;
    }

    public EstadoConservacionMoneda getEstadoConservacion() {
        return estadoConservacion;
    }

    // Setters
    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public void setGrosor(double grosor) {
        this.grosor = grosor;
    }

    public void setEstadoConservacion(EstadoConservacionMoneda estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public String toString() {
        return "Moneda [" + super.toString()
                + ", composicion=" + composicion
                + ", peso=" + peso + " g"
                + ", diametro=" + diametro + " mm"
                + ", grosor=" + grosor + " mm"
                + ", estadoConservacion=" + estadoConservacion + "]";
    }
}
