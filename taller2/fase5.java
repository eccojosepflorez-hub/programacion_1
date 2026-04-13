package taller2;

import java.util.Scanner;

public class fase5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int contGratis = 0;
        double valorSubsidioTotal = 0;
        double precioReferencia = 3000; // Lo que dejaría de ganar el MIO
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n1. Registrar Pasajero | 0. Ver Reporte y Salir");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Tipo: 1.Normal | 2.Estudiante | 3.Adulto Mayor | 4.Discapacitado");
                int tipo = sc.nextInt();

                if (tipo == 3 || tipo == 4) {
                    contGratis++;
                    valorSubsidioTotal += precioReferencia;
                    System.out.println("Pasajero exonerado (Subsidio)");
                } else {
                    System.out.println("Pasajero paga tarifa.");
                }
            }
        }

        System.out.println("\n--- REPORTE DE SUBSIDIOS ---");
        System.out.println("Total pasajeros gratuitos: " + contGratis);
        System.out.println("Valor total subsidiado: $" + valorSubsidioTotal);
    }
    
}
