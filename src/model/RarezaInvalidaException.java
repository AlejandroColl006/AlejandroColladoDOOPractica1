package model;

/**
 * Excepción controlada (checked) que se lanza cuando el índice de rareza de un
 * elemento coleccionable no está dentro del rango permitido (1 a 100).
 *
 * Al extender de Exception (y no de RuntimeException), el compilador obliga a
 * quien cree o modifique la rareza a gestionarla con try/catch o con throws.
 */
public class RarezaInvalidaException extends Exception {

  private final int rarezaIntroducida;

  public RarezaInvalidaException(int rarezaIntroducida) {
    super("La rareza debe estar entre " + ElementoColeccionable.Rareza_MIN
            + " y " + ElementoColeccionable.Rareza_MAX
            + " (valor introducido: " + rarezaIntroducida + ").");
    this.rarezaIntroducida = rarezaIntroducida;
  }

  public int getRarezaIntroducida() {
    return rarezaIntroducida;
  }
}