package Clse4;

import java.util.Scanner;

public class Ejercicio45 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedir el numero
        System.out.println("Digite un numero:");
        int num = sc.nextInt();
        
        // Metodo 1: Operador modulo
        if (num % 2 == 0){
            System.out.println("Metodo 1: El numero es par");
        }else{
            System.out.println("Metodo 1: El numero es impar");
        }
        
        // Metodo 2: Division exacta
        if ((num / 2) * 2 == num){
            System.out.println("Metodo 2: El numero es par");
        }else{
            System.out.println("Metodo 2: El numero es impar");
        }
        
        // Metodo 3: Operador binario
        if ((num & 1) == 0){
            System.out.println("Metodo 3: El numero es par");
        }else{
            System.out.println("Metodo 3: El numero es impar");
        }
        
        sc.close();
    }
}