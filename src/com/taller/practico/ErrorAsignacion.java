package com.taller.practico;

public class ErrorAsignacion {
    public static void main(String[] args) {
        boolean cookieActiva = false;

        // PUNTO DE INSPECCIÓN: Analice el operador utilizado dentro del parentesis del 'if'
        if (cookieActiva = true) {
            System.out.println("Estado de sesión: Sesión del usuario activa.");
        } else {
            System.out.println("Estado de sesión: Sesión inactiva.");
        }
    }
}