package Clse4;

import java.util.Scanner;

public class Ejercicio44 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedir el numero al usuario
        System.out.println("Digite un numero:");
        double num = sc.nextDouble();
        
        // Condicional
        if (num < 0){
            System.out.println("El numero es negativo, no tiene raiz cuadrada real");
        }else{
            double raiz = Math.sqrt(num);
            System.out.println("La raiz cuadrada es: " + raiz);
        }
        
        sc.close();
    }
}