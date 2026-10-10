package com.taller.practico;

public class Seccion1Operadores {
    public static void main(String[] args) {
        int x = 7;
        boolean flag = false;

        // Fila 1
        int seg = 86400 % 3600;
        System.out.println("seg = " + seg);

        // Fila 2
        int y = ++x + x++;
        System.out.println("y = " + y + " | x = " + x);

        // Fila 3
        double div1 = 15 / 2;
        double div2 = 15.0 / 2;
        System.out.println("div1 = " + div1 + " | div2 = " + div2);

        // Fila 4 (cada fila parte de x = 7)
        x = 7;
        boolean res = flag && (++x > 0);
        System.out.println("res = " + res + " | x = " + x);
    }
}