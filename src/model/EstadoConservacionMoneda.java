package model;


public enum EstadoConservacionMoneda {

    G("Good (bien)"),
    VG("Very Good (muy bien)"),
    F("Fine (fina)"),
    VF("Very Fine (muy fina)"),
    XF("Extremely Fine (extremadamente fina)"),
    AU("About Uncirculated (casi sin circular)"),
    UNC("Uncirculated (sin circular)");

    private final String descripcion;

    EstadoConservacionMoneda(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionMoneda() {
        return descripcion;
    }
}