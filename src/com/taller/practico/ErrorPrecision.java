package com.taller.practico;

public class ErrorPrecision {
    public static void main(String[] args) {
        int tareasCompletadas = 3;
        int tareasTotales = 4;

        // PUNTO DE INSPECCIÓN: Verifique por qué (3 / 4) trunca los decimales a 0 antes de multiplicar por 100
        double porcentajeAvance = (tareasCompletadas / tareasTotales) * 100;

        System.out.println("El porcentaje de avance es: " + porcentajeAvance + "%");
    }
}