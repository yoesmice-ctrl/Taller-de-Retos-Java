package com.taller.practico;

import java.util.Scanner;

public class Ejercicio3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo N: ");
        int n = sc.nextInt();

        // Parte A: factorial (long para evitar desbordamiento en valores medianos)
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("\nParte A: " + n + "! = " + factorial);
        if (n > 20) {
            System.out.println("Advertencia: para N > 20 el resultado desborda el tipo long.");
        }

        // Parte B: triángulo con for anidados
        System.out.println("\nParte B: patrón triangular de altura " + n);
        for (int fila = 1; fila <= n; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        sc.close();
    }
}