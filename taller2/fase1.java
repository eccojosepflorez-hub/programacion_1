package taller2;

import java.util.Scanner;

public class fase1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese la hora actual (0-23): ");
        int hora = sc.nextInt();
        System.out.println("Tipo de pasajero: \n 1. Normal\n 2. Estudiante\n 3. Adulto mayor\n 4. Discapacitado");
        System.out.print("Seleccione: ");
        int tipo = sc.nextInt();

        double tarifaBase = 0;
        double decuento = 0;
        String nombreTipo = "";
        
        // Regla: Hora valle entre las 9:00 y las 16:00
        boolean esHoraValle = (hora >= 9 && hora <= 16);

        switch (tipo) {
            case 1:
                nombreTipo = "Normal";
                tarifaBase = 3000;
                break;
            case 2:
                nombreTipo = "Estudiante";
                tarifaBase = 1500;
                if (esHoraValle) {
                    decuento = tarifaBase * 0.10; // 10% de descuento en hora valle
                }
                break;
            case 3:
                nombreTipo = "Adulto mayor";
                tarifaBase = 0; // Tarifa gratuita según el proyecto
                break;
            case 4:
                nombreTipo = "Discapacitado";
                tarifaBase = 0; // Tarifa gratuita según el proyecto
                break;
            default:
                System.out.println("Tipo invalido");
                return;
        }

        double totalPagar = tarifaBase - decuento;

        System.out.println("\n--- TIQUETE ---");
        System.out.println("Tipo: " + nombreTipo);
        System.out.println("Total a pagar: $" + totalPagar);
    }
}
    

