package com.taller.practico;

public class Debug2 {
    public static void main(String[] args) {
        int totalElementos = 5;

        System.out.println("Imprimiendo elementos del 1 al " + totalElementos + ":");

        for (int i = 1; i <= totalElementos; i++) { // CORRECCIÓN: <= en lugar de <
            System.out.println("Elemento " + i);
        }
    }
}