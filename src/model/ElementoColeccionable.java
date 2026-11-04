package model;

public abstract class ElementoColeccionable {


    //Variables estaticas de tipo entero y finales para que no se editen en ninguna parte del código
    public static final int Rareza_MIN = 1;
    public static final int Rareza_MAX = 100;


    //Atributos
    private String pais;
    private String autoridadGobernante;
    private int annus;                 // año de emisión
    private double valor;              // valor facial
    private String unidadMonetaria;    // ej.: "EUR", "céntimos"
    private int rareza;                // entre 1 y 100
    private double precio;

    protected ElementoColeccionable(String pais, String autoridadGobernante, int annus,
                                    double valor, String unidadMonetaria, int rareza,
                                    double precio) throws RarezaInvalidaException {
        this.pais = pais;
        this.autoridadGobernante = autoridadGobernante;
        this.annus = annus;
        this.valor = valor;
        this.unidadMonetaria = unidadMonetaria;
        setRareza(rareza);
        this.precio = precio;
    }

    //Getters

    public String getPais() {
        return pais;
    }

    public String getAutoridadGobernante() {
        return autoridadGobernante;
    }

    public int getAnnus() {
        return annus;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidadMonetaria() {
        return unidadMonetaria;
    }

    public int getRareza() {
        return rareza;
    }

    public double getPrecio() {
        return precio;
    }

    //Setters


    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAutoridadGobernante(String autoridadGobernante) {
        this.autoridadGobernante = autoridadGobernante;
    }

    public void setAnnus(int annus) {
        this.annus = annus;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setUnidadMonetaria(String unidadMonetaria) {
        this.unidadMonetaria = unidadMonetaria;
    }

    public final void setRareza(int rareza) throws RarezaInvalidaException {
        if (rareza < Rareza_MIN || rareza >Rareza_MAX) {
            throw new RarezaInvalidaException(rareza);
        }
        this.rareza = rareza;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}


