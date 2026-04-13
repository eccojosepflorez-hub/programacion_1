package taller2;

import java.util.Scanner;

public class fase3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ MIO CALI ===");
            System.out.println("1. Cobrar Tarifa (Fase 1)");
            System.out.println("2. Control de Ruta (Fase 2)");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ejecutando módulo de cobro...");
                    // Aquí iría el código de la Fase 1
                    break;
                case 2:
                    System.out.println("Iniciando control de aforo...");
                    // Aquí iría el código de la Fase 2
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
    
