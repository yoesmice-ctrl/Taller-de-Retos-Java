package ahorcado;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // ===== Unidad 1.1: constante inmutable =====
    static final int MAX_INTENTOS = 6;

    static final String[] PALABRAS = {
            "java", "string", "builder", "bucle", "variable",
            "consola", "compilador", "metodo", "objeto", "intellij"
    };

    // Estadísticas acumuladas entre partidas
    static int partidasJugadas = 0;
    static int partidasGanadas = 0;
    static int partidasPerdidas = 0;
    static double mejorPuntaje = 0.0;
    static String mejorJugador = "-";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== AHORCADO DE CONSOLA =====");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadísticas");
            System.out.println("3. Salir");

            opcion = leerOpcion(sc);

            switch (opcion) {
                case 1:
                    jugar(sc);
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
        } while (opcion != 3);

        sc.close();
    }

    // ===== Fase 1: validación del menú =====
    private static int leerOpcion(Scanner sc) {
        while (true) {
            System.out.print("Elige una opción (1-3): ");
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= 1 && valor <= 3) {
                    return valor;
                }
                System.out.println("Error: la opción debe estar entre 1 y 3.");
            } catch (NumberFormatException e) {
                System.out.println("Error: ingresa solo números (1, 2 o 3).");
            }
        }
    }

    // ===== Fases 2 y 3: registro del jugador y bucle del juego =====
    private static void jugar(Scanner sc) {

        // --- Fase 2: nombre normalizado ---
        String nombreJugador = "";
        while (nombreJugador.length() == 0) {
            System.out.print("Ingresa tu nombre: ");
            nombreJugador = sc.nextLine().trim().toUpperCase();
            if (nombreJugador.length() == 0) {
                System.out.println("El nombre no puede estar vacío. Intenta de nuevo.");
            }
        }

        // --- Fase 2: variables de estado ---
        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 100.0;
        boolean juegoGanado = false;
        char ultimaLetra;
        int aciertos = 0;
        int fallos = 0;

        // Palabra secreta al azar
        Random random = new Random();
        String palabraSecreta = PALABRAS[random.nextInt(PALABRAS.length)].toUpperCase();

        // --- StringBuilder: máscara "_ _ _ _" e historial de letras ---
        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append("_ ");
        }
        StringBuilder historial = new StringBuilder();

        System.out.println("\n¡Suerte, " + nombreJugador + "! La palabra tiene "
                + palabraSecreta.length() + " letras.");
        System.out.println("(Escribe RENDIRSE si quieres abandonar la partida)");

        // --- Fase 3: bucle principal ---
        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\nPalabra:  " + mascara);
            System.out.println("Usadas:   " + historial);
            System.out.println("Intentos: " + intentosRestantes + " / " + MAX_INTENTOS);
            System.out.print("Ingresa una letra: ");

            String entrada = sc.nextLine().trim();

            // Rendición -> break
            if (entrada.equalsIgnoreCase("RENDIRSE")) {
                System.out.println("Te has rendido.");
                break;
            }

            // Entrada vacía, más de un carácter o no es letra -> continue
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Entrada inválida: escribe una sola letra.");
                continue;
            }

            ultimaLetra = Character.toUpperCase(entrada.charAt(0));

            // Letra repetida -> continue
            if (historial.indexOf(String.valueOf(ultimaLetra)) >= 0) {
                System.out.println("Ya usaste la letra " + ultimaLetra + ". Prueba otra.");
                continue;
            }
            historial.append(ultimaLetra).append(' ');

            // Buscar la letra en la palabra y destapar la máscara
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String letraPalabra = String.valueOf(palabraSecreta.charAt(i));
                if (letraPalabra.equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, ultimaLetra);
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
                puntaje += 10;
            } else {
                fallos++;
                intentosRestantes--;
                puntaje = Math.max(0, puntaje - 5);
            }

            // Operador ternario: retroalimentación
            System.out.println(acierto
                    ? "¡Bien! La letra " + ultimaLetra + " está en la palabra."
                    : "Fallaste: la letra " + ultimaLetra + " no está en la palabra.");

            // Victoria: ya no quedan guiones -> break
            if (mascara.indexOf("_") < 0) {
                juegoGanado = true;
                break;
            }
        }

        // Actualizar estadísticas
        partidasJugadas++;
        if (juegoGanado) {
            partidasGanadas++;
        } else {
            partidasPerdidas++;
        }
        if (puntaje > mejorPuntaje) {
            mejorPuntaje = puntaje;
            mejorJugador = nombreJugador;
        }

        // Fase 4: resumen final
        mostrarResumen(nombreJugador, juegoGanado, palabraSecreta,
                intentosRestantes, aciertos, fallos, puntaje);
    }

    // ===== Estadísticas acumuladas =====
    private static void mostrarEstadisticas() {
        System.out.println("\n====================================================");
        System.out.println("ESTADÍSTICAS");
        System.out.println("====================================================");
        if (partidasJugadas == 0) {
            System.out.println("Aún no has jugado ninguna partida.");
        } else {
            System.out.printf("Partidas jugadas:  %d%n", partidasJugadas);
            System.out.printf("Partidas ganadas:  %d%n", partidasGanadas);
            System.out.printf("Partidas perdidas: %d%n", partidasPerdidas);
            System.out.printf("Mejor puntaje:     %.2f pts (%s)%n", mejorPuntaje, mejorJugador);
        }
        System.out.println("====================================================");
    }

    // ===== Fase 4: resumen final solo con printf =====
    private static void mostrarResumen(String nombre, boolean ganado, String palabra,
                                       int intentosRestantes, int aciertos, int fallos,
                                       double puntaje) {
        int totalTurnos = aciertos + fallos;
        // Casting a double para evitar la división entera
        double porcentaje = totalTurnos == 0 ? 0.0 : (double) aciertos / totalTurnos * 100;

        System.out.printf("%n====================================================%n");
        System.out.printf("RESUMEN DE LA PARTIDA%n");
        System.out.printf("====================================================%n");
        System.out.printf("Jugador: %s%n", nombre);
        System.out.printf("Estado Final: %s%n", ganado ? "¡VICTORIA!" : "DERROTA");
        System.out.printf("Palabra Secreta: %s%n", palabra);
        System.out.printf("Intentos Restantes: %d / %d%n", intentosRestantes, MAX_INTENTOS);
        System.out.printf("Porcentaje Aciertos: %.2f%%%n", porcentaje);
        System.out.printf("Puntaje Final: %.2f pts%n", puntaje);
        System.out.printf("====================================================%n");
    }
}