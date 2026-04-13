package taller2;

import java.util.Scanner;

public class fase2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int capacidadMax = 80;
        int pasajerosActuales = 0;
        int totalSubieron = 0;
        int paradasConAforoMax = 0;
        int parada = 1;

        while (parada <= 25) {
            System.out.println("\nPARADA " + parada + " - Pasajeros a bordo: " + pasajerosActuales);
            System.out.print("¿Cuántos suben? (o -1 para terminar ruta): ");
            int suben = sc.nextInt();
            
            if (suben == -1) break;

            System.out.print("¿Cuántos bajan? ");
            int bajan = sc.nextInt();

            // Validación: No pueden bajar más de los que hay
            if (bajan > pasajerosActuales) bajan = pasajerosActuales;
            pasajerosActuales -= bajan;

            // Validación: No superar capacidad máxima
            if (pasajerosActuales + suben > capacidadMax) {
                int puedenSubir = capacidadMax - pasajerosActuales;
                System.out.println("¡ALERTA! Solo pueden subir " + puedenSubir + " pasajeros.");
                suben = puedenSubir;
            }

            pasajerosActuales += suben;
            totalSubieron += suben;
            
            if (pasajerosActuales == capacidadMax) paradasConAforoMax++;

            // Mostrar estado según porcentaje
            double porcentaje = (pasajerosActuales * 100.0) / capacidadMax;
            if (pasajerosActuales == capacidadMax) System.out.println("Estado: AFORO MÁXIMO");
            else if (porcentaje >= 60) System.out.println("Estado: BUS LLENO");
            else System.out.println("Estado: NORMAL");

            parada++;
        }

        System.out.println("\n--- RESUMEN DE RUTA ---");
        System.out.println("Total pasajeros movilizados: " + totalSubieron);
        System.out.println("Paradas en aforo máximo: " + paradasConAforoMax);
    }
}
