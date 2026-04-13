package taller2;

import java.util.Scanner;

public class fase4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double recaudoTotal = 0;
        int totalPasajerosAtendidos = 0;
        int continuar = 1;

        System.out.println("--- INICIO DE TURNO DE COBRO ---");

        while (continuar == 1) {
            System.out.print("Ingrese hora (0-23): ");
            int hora = sc.nextInt();
            System.out.println("Tipo: 1.Normal | 2.Estudiante | 3.Adulto Mayor | 4.Discapacitado");
            int tipo = sc.nextInt();

            double tarifa = 0;
            if (tipo == 1) tarifa = 3000;
            else if (tipo == 2) {
                tarifa = 1500;
                if (hora >= 9 && hora <= 16) tarifa -= 150; // 10% dto
            } 
            // Casos 3 y 4 son tarifa 0

            recaudoTotal += tarifa;
            totalPasajerosAtendidos++;

            System.out.println("Cobro realizado: $" + tarifa);
            System.out.print("¿Cobrar a otro pasajero? (1: Sí / 0: No): ");
            continuar = sc.nextInt();
        }

        System.out.println("\n--- REPORTE DE TURNO ---");
        System.out.println("Pasajeros atendidos: " + totalPasajerosAtendidos);
        System.out.println("Total recaudado: $" + recaudoTotal);
    }
    
}
