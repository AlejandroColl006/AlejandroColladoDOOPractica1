package model;

public enum EstadoConservacionSello {

    U("Usado"),
    NSG("Nuevo sin goma"),
    NF("Nuevo con fijasellos"),
    N("Nuevo");

    private final String descripcion;

    EstadoConservacionSello(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionSello() {
        return descripcion;
    }
}