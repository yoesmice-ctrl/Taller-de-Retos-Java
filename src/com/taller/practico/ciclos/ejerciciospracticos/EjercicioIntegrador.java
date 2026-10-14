package com.taller.practico;

import java.util.Scanner;

public class EjercicioIntegrador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CAPACIDAD_MAXIMA = 500;
        int totalUnidades = 0;
        double valorInventario = 0;
        int productosRegistrados = 0;
        int opcion;

        do {
            System.out.println("\n===== ALMACÉN LOGÍSTICO =====");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Cantidad de productos del lote: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.println("\n--- Producto " + i + " de " + n + " ---");
                        System.out.print("¿Está descontinuado? (s/n): ");
                        String descontinuado = sc.next();
                        if (descontinuado.equalsIgnoreCase("s")) {
                            System.out.println("Producto descontinuado, se omite.");
                            continue;
                        }

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        while (precio <= 0) {
                            System.out.print("Error: el precio debe ser mayor a cero. Ingrese de nuevo: ");
                            precio = sc.nextDouble();
                        }

                        System.out.print("Cantidad en stock: ");
                        int stock = sc.nextInt();
                        while (stock <= 0) {
                            System.out.print("Error: el stock debe ser mayor a cero. Ingrese de nuevo: ");
                            stock = sc.nextInt();
                        }

                        totalUnidades += stock;
                        valorInventario += precio * stock;
                        productosRegistrados++;

                        if (totalUnidades > CAPACIDAD_MAXIMA) {
                            System.out.println("¡ALERTA! Sobrecupo: se superó la capacidad de "
                                    + CAPACIDAD_MAXIMA + " unidades. Se aborta el lote.");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n--- ESTADO DEL ALMACÉN ---");
                    System.out.println("Productos registrados: " + productosRegistrados);
                    System.out.println("Unidades totales: " + totalUnidades + " / " + CAPACIDAD_MAXIMA);
                    System.out.println("Valor del inventario: $" + valorInventario);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();
    }
}