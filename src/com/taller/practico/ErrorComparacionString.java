package com.taller.practico;

public class ErrorComparacionString {
    public static void main(String[] args) {
        // Generación explícita de dos objetos String en posiciones distintas de memoria
        String proveedor1 = new String("OneTrust");
        String proveedor2 = "OneTrust";

        // PUNTO DE INSPECCIÓN: Evalúe por qué '==' compara referencias de memoria y no contenido
        if (proveedor1 == proveedor2) {
            System.out.println("Los proveedores coinciden exactamente.");
        } else {
            System.out.println("Los proveedores son distintos según la comparación por referencia.");
        }
    }
}