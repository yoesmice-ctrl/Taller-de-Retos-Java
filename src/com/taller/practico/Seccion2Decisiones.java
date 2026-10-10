package com.taller.practico;

public class Seccion2Decisiones {
    public static void main(String[] args) {

        // ---------- Reto 1: Clasificación de edades ----------
        int edadUsuario = 28; // prueba con 10, 15, 28, 68
        if (edadUsuario < 12) {
            System.out.println("Categoría: Infante - Requiere tutor de cuenta");
        } else if (edadUsuario <= 17) {
            System.out.println("Categoría: Adolescente - Acceso restringido a foros comunitarios");
        } else if (edadUsuario <= 64) {
            System.out.println("Categoría: Adulto - Acceso a funcionalidades estándar");
        } else {
            System.out.println("Categoría: Adulto Mayor - Acceso con interfaz adaptada");
        }

        // ---------- Reto 2: Aprobación de notas y asistencia ----------
        double calificacionFinal = 75.0;
        int porcentajeAsistencia = 85;
        boolean entregoProyectoFinal = true;

        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            System.out.println("Dictamen: Aprobado");
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            System.out.println("Dictamen: Pendiente de Examen Extraordinario");
        } else {
            System.out.println("Dictamen: Reprobado");
        }

        // ---------- Reto 3: Tarifas de entrada ----------
        String tipoEntrada = "ESTUDIANTE"; // VIP, ESTUDIANTE, GENERAL, ADULTO_MAYOR
        double precioBase = 100.0;
        double precioFinal;

        if (tipoEntrada.equals("VIP")) {
            precioFinal = precioBase * 1.10;
        } else if (tipoEntrada.equals("ESTUDIANTE")) {
            precioFinal = precioBase * 0.50;
        } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
            precioFinal = precioBase * 0.60;
        } else {
            precioFinal = precioBase;
        }
        System.out.println("Entrada: " + tipoEntrada + " | Monto final: $" + precioFinal);

        // ---------- Refactorización a operador ternario ----------
        boolean cookieSesionActiva = true;
        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";
        System.out.println("Estado de conexión: " + estadoConexion);
    }
}