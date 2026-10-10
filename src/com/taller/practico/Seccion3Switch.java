package com.taller.practico;

public class Seccion3Switch {
    public static void main(String[] args) {
        int dia = 3; // 1 = Lunes ... 7 = Domingo

        // ---------- Implementación 1: switch tradicional ----------
        String jornada;
        switch (dia) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                jornada = "Jornada laboral completa";
                break;
            case 6:
                jornada = "Media jornada";
                break;
            case 7:
                jornada = "Día de descanso";
                break;
            default:
                jornada = "Día inválido";
        }
        System.out.println("[Tradicional] Día " + dia + ": " + jornada);

        // ---------- Implementación 2: switch moderno con flecha ----------
        String jornadaModerna = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Jornada laboral completa";
            case 6 -> "Media jornada";
            case 7 -> "Día de descanso";
            default -> "Día inválido";
        };
        System.out.println("[Moderno] Día " + dia + ": " + jornadaModerna);
    }
}