package com.alurachallenge.principal;

import com.alurachallenge.conversor.Conversor;

import java.util.*;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    // Lista ordenada de monedas permitidas
    private final List<Map.Entry<String, String>> monedas = List.of(
            Map.entry("ARS", "Peso argentino"),
            Map.entry("BOB", "Boliviano boliviano"),
            Map.entry("BRL", "Real brasileño"),
            Map.entry("CLP", "Peso chileno"),
            Map.entry("COP", "Peso colombiano"),
            Map.entry("USD", "Dólar estadounidense"),
            Map.entry("PEN", "Sol peruano")
    );

    public void mostrar() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("-------------------------------------------");
            System.out.println("               MENÚ PRINCIPAL              ");
            System.out.println("-------------------------------------------");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    convertirMoneda();
                    break;
                case "2":
                    continuar = false;
                    System.out.println("\n-------------------------------------------");
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    System.out.println("-------------------------------------------");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo nuevamente.");
            }
        }

        scanner.close();
    }

    private void convertirMoneda() {
        mostrarMonedasDisponibles();

        String origen = seleccionarMoneda("origen");
        if (origen == null) return;

        String destino = seleccionarMoneda("destino");
        if (destino == null) return;

        System.out.print("Ingrese monto a convertir: ");
        try {
            double monto = Double.parseDouble(scanner.nextLine());
            Conversor.realizarConversion(origen, destino, monto);
        } catch (NumberFormatException e) {
            System.out.println("Monto inválido. Inténtalo de nuevo.");
        }
    }

    private void mostrarMonedasDisponibles() {
        System.out.println("\n-------------------------------------------");
        System.out.println("           MONEDAS DISPONIBLES             ");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < monedas.size(); i++) {
            Map.Entry<String, String> moneda = monedas.get(i);
            System.out.printf("%d. %s (%s)\n", i + 1, moneda.getKey(), moneda.getValue());
        }
        System.out.println();
    }

    private String seleccionarMoneda(String tipo) {
        System.out.printf("Seleccione número de moneda %s: ", tipo);
        try {
            int seleccion = Integer.parseInt(scanner.nextLine());
            if (seleccion >= 1 && seleccion <= monedas.size()) {
                return monedas.get(seleccion - 1).getKey(); // Devuelve el código (ej. "USD")
            } else {
                System.out.println("Selección inválida. Inténtalo de nuevo.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
            return null;
        }
    }
}
