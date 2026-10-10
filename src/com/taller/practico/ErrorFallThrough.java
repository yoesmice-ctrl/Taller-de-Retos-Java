package com.taller.practico;

public class ErrorFallThrough {
    public static void main(String[] args) {
        int opcionCategoria = 1;

        // PUNTO DE INSPECCIÓN: Observe la ejecución secuencial al omitir sentencias de parada
        switch (opcionCategoria) {
            case 1:
                System.out.println("Categoría Selección: Lunes (Jornada Laboral)");
            case 2:
                System.out.println("Categoría Selección: Martes (Jornada Laboral)");
            case 3:
                System.out.println("Categoría Selección: Miércoles (Jornada Laboral)");
            default:
                System.out.println("Día no identificado");
        }
    }
}