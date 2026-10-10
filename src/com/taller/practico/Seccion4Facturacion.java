package com.taller.practico;

import java.util.Locale;

public class Seccion4Facturacion {

    static double calcularTotal(int cantidad, String tipoCliente, String cupon) {
        final double PRECIO_UNITARIO = 250.00;
        double subtotalBase = cantidad * PRECIO_UNITARIO;

        double porcentajeDescuento = switch (tipoCliente) {
            case "VIP" -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO" -> 0.05;
            default -> 0.0;
        };
        double subtotalConDescuento = subtotalBase - (subtotalBase * porcentajeDescuento);

        double descuentoCupon;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
        } else {
            descuentoCupon = 0.00;
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double iva = baseImponible * 0.16;
        double total = baseImponible + iva;

        System.out.println(String.format(Locale.US, "Subtotal base: $%.2f", subtotalBase));
        System.out.println(String.format(Locale.US, "Subtotal con descuento: $%.2f", subtotalConDescuento));
        System.out.println(String.format(Locale.US, "Descuento cupón: $%.2f", descuentoCupon));
        System.out.println(String.format(Locale.US, "Base imponible: $%.2f", baseImponible));
        System.out.println(String.format(Locale.US, "IVA (16%%): $%.2f", iva));
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Caso de Prueba A ===");
        System.out.println(String.format(Locale.US, "Total a pagar = $%.2f", calcularTotal(3, "VIP", "PROMO1 año")));
        System.out.println();
        System.out.println("=== Caso de Prueba B ===");
        System.out.println(String.format(Locale.US, "Total a pagar = $%.2f", calcularTotal(1, "NUEVO", "PROMO1 año")));
    }
}