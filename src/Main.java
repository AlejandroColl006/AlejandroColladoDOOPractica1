import model.*;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Coleccion coleccionAlejandroCollado = new Coleccion();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    anadirMoneda(coleccionAlejandroCollado);
                    break;
                case 2:
                    anadirSello(coleccionAlejandroCollado);
                    break;
                case 3:
                    coleccionAlejandroCollado.mostrarMonedas();
                    break;
                case 4:
                    coleccionAlejandroCollado.mostrarSellos();
                    break;
                case 5:
                    System.out.printf("Precio total de la colección: %.2f €%n",
                            coleccionAlejandroCollado.obtenerPrecioTotal());
                    break;
                case 6:
                    System.out.printf("Rareza media de la colección: %.2f%n",
                            coleccionAlejandroCollado.obtenerRarezaMedia());
                    break;
                case 0:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Elige un número entre 0 y 6.");
            }
        } while (opcion != 0);
    }

    // ---------- Menú ----------

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== COLECCIÓN DE FILATELIA Y NUMISMÁTICA =====");
        System.out.println("1-Añadir una nueva moneda");
        System.out.println("2-Añadir un nuevo sello");
        System.out.println("3-Mostrar todas las monedas");
        System.out.println("4-Mostrar todos los sellos");
        System.out.println("5-Mostrar el precio total de la colección");
        System.out.println("6-Mostrar la rareza media de la colección");
        System.out.println("0-Salir");
    }

    private static void anadirMoneda(Coleccion coleccionAlejandroCollado) {
        System.out.println("--- Nueva moneda ---");
        String pais = leerTexto("País: ");
        String autoridad = leerTexto("Autoridad gobernante: ");
        int annus = leerEntero("Año: ");
        double valor = leerDecimal("Valor facial: ");
        String unidad = leerTexto("Unidad monetaria: ");
        double precio = leerDecimal("Precio (€): ");
        String composicion = leerTexto("Composición: ");
        double peso = leerDecimal("Peso (g): ");
        double diametro = leerDecimal("Diámetro (mm): ");
        double grosor = leerDecimal("Grosor (mm): ");
        EstadoConservacionMoneda estado = leerEstadoMoneda();

        boolean anadida = false;
        while (!anadida) {
            int rareza = leerEntero("Rareza (1-100): ");
            try {
                Moneda moneda = new Moneda(pais, autoridad, annus, valor, unidad, rareza,
                        precio, composicion, peso, diametro, grosor, estado);
                coleccionAlejandroCollado.anadirMoneda(moneda);
                anadida = true;
                System.out.println("Moneda añadida correctamente.");
            } catch (RarezaInvalidaException e) {
                System.out.println("Error: " + e.getMessage() + " Inténtalo de nuevo.");
            }
        }
    }

    /** Igual que anadirMoneda, pero con los datos propios de un sello. */
    private static void anadirSello(Coleccion coleccionAlejandroCollado) {
        System.out.println("--- Nuevo sello ---");
        String pais = leerTexto("País: ");
        String autoridad = leerTexto("Autoridad gobernante: ");
        int annus = leerEntero("Año: ");
        double valor = leerDecimal("Valor facial: ");
        String unidad = leerTexto("Unidad monetaria: ");
        double precio = leerDecimal("Precio (€): ");
        double altura = leerDecimal("Altura (mm): ");
        double anchura = leerDecimal("Anchura (mm): ");
        String imagen = leerTexto("Imagen (ruta o nombre del archivo): ");
        EstadoConservacionSello estado = leerEstadoSello();

        boolean anadido = false;
        while (!anadido) {
            int rareza = leerEntero("Rareza (1-100): ");
            try {
                Sello sello = new Sello(pais, autoridad, annus, valor, unidad, rareza,
                        precio, altura, anchura, imagen, estado);
                coleccionAlejandroCollado.anadirSello(sello);
                anadido = true;
                System.out.println("Sello añadido correctamente.");
            } catch (RarezaInvalidaException e) {
                System.out.println("Error: " + e.getMessage() + " Inténtalo de nuevo.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }


    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero.");
            }
        }
    }


    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número (por ejemplo 2.5).");
            }
        }
    }

    private static EstadoConservacionMoneda leerEstadoMoneda() {
        while (true) {
            String texto = leerTexto("Estado de conservación (G, VG, F, VF, XF, AU, UNC): ");
            try {
                return EstadoConservacionMoneda.valueOf(texto.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no válido.");
            }
        }
    }

    private static EstadoConservacionSello leerEstadoSello() {
        while (true) {
            String texto = leerTexto("Estado de conservación (U, NSG, NF, N): ");
            try {
                return EstadoConservacionSello.valueOf(texto.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no válido.");
            }
        }
    }
}