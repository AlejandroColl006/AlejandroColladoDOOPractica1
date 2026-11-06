import model.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Coleccion coleccionAlejandroCollado = new Coleccion();
        int opcion;

        // Para dejar al usuario que introduzca una opción por pantalla
        do {
            mostrarMenu();
            opcion = leerEntero("Introduce el número correspondiente a la opción que quieras elegir: ");

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

    // Metodo de mostrarMenu

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("COLECCIÓN DE FILATELIA Y NUMISMÁTICA ");
        System.out.println("1- Añade una nueva moneda");
        System.out.println("2- Añade un nuevo sello");
        System.out.println("3- Te muestro todas las monedas");
        System.out.println("4- Te muestro todos los sellos");
        System.out.println("5- Mostrar el precio total de la colección");
        System.out.println("6- Mostrar la rareza media de la colección");
        System.out.println("0- Para salir del menú");
    }
    // Metodo añadirMoneda
    private static void anadirMoneda(Coleccion coleccionAlejandroCollado) {
        System.out.println("Nueva moneda");
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

    private static void anadirSello(Coleccion coleccionAlejandroCollado) {
        System.out.println("Nuevo sello para la colección");
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
    /*Para que cuando tenga que leer un numero entero o un numero decimal,
    un texto o los estados de conservación además si lo introduce de manera incorrecta se lance un error, la condicion de String leer texto dentro del
    if es buscado para que al menos se introduzca una letra y que por ejemplo no pase pais solo*/
    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (texto.matches(".*\\p{L}.*")) {
                return texto;
            }
            System.out.println("Error: \"" + texto + "\" no es un texto válido (debe contener al menos una letra). Inténtalo de nuevo.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: " + texto + " no es un número entero. Prueba a intertarlo de nuevo.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            try {
                double numero = Double.parseDouble(texto.replace(',', '.'));
                // parseDouble acepta "NaN" e "Infinity", que no son números útiles aquí
                if (Double.isNaN(numero) || Double.isInfinite(numero)) {
                    throw new NumberFormatException();
                }
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + texto + "\" no es un número válido (por ejemplo 2.5). Inténtalo de nuevo.");
            }
        }
    }

    private static EstadoConservacionMoneda leerEstadoMoneda() {
        String opciones = Arrays.toString(EstadoConservacionMoneda.values());
        while (true) {
            String texto = leerTexto("Estado de conservación " + opciones + ": ");
            try {
                return EstadoConservacionMoneda.valueOf(texto.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: \"" + texto + "\" no es un estado válido. Opciones: "
                        + opciones + ". Inténtalo de nuevo.");
            }
        }
    }

    private static EstadoConservacionSello leerEstadoSello() {
        String opciones = Arrays.toString(EstadoConservacionSello.values());
        while (true) {
            String texto = leerTexto("Estado de conservación " + opciones + ": ");
            try {
                return EstadoConservacionSello.valueOf(texto.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: \"" + texto + "\" no es un estado válido. Opciones: "
                        + opciones + ". Inténtalo de nuevo.");
            }
        }
    }
}