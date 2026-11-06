package model;

public class Sello extends ElementoColeccionable {

    private double altura;
    private double anchura;
    private String imagen;                               // ruta o nombre del archivo de imagen
    private EstadoConservacionSello estadoConservacion;

    public Sello(String pais, String autoridadGobernante, int annus, double valor,
                 String unidadMonetaria, int rareza, double precio,
                 double altura, double anchura, String imagen,
                 EstadoConservacionSello estadoConservacion) throws RarezaInvalidaException {
        super (pais, autoridadGobernante, annus, valor, unidadMonetaria, rareza, precio);
        this.altura = altura;
        this.anchura = anchura;
        this.imagen = imagen;
        this.estadoConservacion = estadoConservacion;
    }

    // Getters
    public double getAltura() {
        return altura;
    }

    public double getAnchura() {
        return anchura;
    }

    public String getImagen() {
        return imagen;
    }

    public EstadoConservacionSello getEstadoConservacion() {
        return estadoConservacion;
    }

    //Setters
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEstadoConservacion(EstadoConservacionSello estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public String toString() {
        return "El Sello tiene las caracterísitcas [altura=" + altura + " mm"
                + ", anchura=" + anchura + " mm"
                + ", imagen=" + imagen
                + ", estadoConservacion=" + estadoConservacion + "]";
    }
}



