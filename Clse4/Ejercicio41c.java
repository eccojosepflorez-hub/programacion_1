package Clse4;
import java.util.Scanner;
public class Ejercicio41c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalPositivos = 0;
        int totalNegativos = 0;

        // pedir numero al usuario
        System.out.println("Digite un numero:");
        int numero = sc.nextInt();

        // condicional
        if (numero > 0) {
            totalPositivos = totalPositivos + numero;
        } else {
            totalNegativos = totalNegativos + numero;
        }

        // mostrar resultados
        System.out.println("Total de positivos: " + totalPositivos);
        System.out.println("Total de negativos: " + totalNegativos);

        sc.close();
    }


    }
