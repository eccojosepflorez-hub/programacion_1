package Clse4;

import java.util.Scanner;

public class Ejercicio48 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedir los numeros
        System.out.println("Digite el primer numero:");
        int num1 = sc.nextInt();
        
        System.out.println("Digite el segundo numero:");
        int num2 = sc.nextInt();
        
        // Condicional
        if (num2 != 0 && num1 % num2 == 0){
            System.out.println("El segundo numero es divisor del primero");
        }else if (num1 != 0 && num2 % num1 == 0){
            System.out.println("El primer numero es divisor del segundo");
        }else{
            System.out.println("Ninguno es divisor del otro");
        }
        
        sc.close();
    }
}