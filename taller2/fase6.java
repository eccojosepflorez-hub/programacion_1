package taller2;

import java.util.Scanner;

public class fase6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionPrincipal = -1;
        
        // Variables globales para el reporte del día
        double recaudoGlobal = 0;
        int totalPasajerosDia = 0;

        while (opcionPrincipal != 0) {
            System.out.println("\n===============================");
            System.out.println("   SISTEMA DE GESTION MIO");
            System.out.println("===============================");
            System.out.println("1. Modulo de Cobros (Fase 1/4)");
            System.out.println("2. Control de Aforo (Fase 2)");
            System.out.println("3. Reporte General del Dia (Fase 5)");
            System.out.println("0. Salir del Sistema");
            System.out.print("Seleccione: ");
            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    // Lógica de cobro integrada
                    System.out.print("Hora: ");
                    int h = sc.nextInt();
                    System.out.print("Tipo (1-4): ");
                    int t = sc.nextInt();
                    double pago = (t == 1) ? 3000 : (t == 2) ? 1500 : 0;
                    recaudoGlobal += pago;
                    totalPasajerosDia++;
                    System.out.println("Cobro exitoso.");
                    break;

                case 2:
                    // Lógica de aforo (resumida)
                    System.out.println("Iniciando simulacion de bus...");
                    // Aquí se llamaría a la lógica de la Fase 2 que ya tienes
                    break;

                case 3:
                    System.out.println("\n--- REPORTE GENERAL ---");
                    System.out.println("Total Pasajeros: " + totalPasajerosDia);
                    System.out.println("Recaudo Caja: $" + recaudoGlobal);
                    break;

                case 0:
                    System.out.println("Cerrando sesión...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
    
}
