/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_parques;

import java.util.Scanner;

/**
 *
 * @author Karen
 */
public class Juego_Parques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello guys ");
        double Num1, Num2;
        
        Scanner sc= new Scanner(System.in);
        System.out.println("ingrese dos numeros");
        Num1=sc.nextDouble();
        Num2=sc.nextDouble();
        double re=Num1+Num2;
        System.out.println("el resultado de la suma de los numeros es:"+Num1+" + "+Num2+"es de " +re);
        
        Scanner va= new Scanner(System.in);
        int num, a1,a2,a3;
        do {System.out.print("ingrese la cantidad de numeros que quiere ver de la serie fibonacci");
        num=va.nextInt();      
         } while (num<1);
        System.out.print("los primeros "+num+ "de la secuencia son");
        

    
    }
    
}
 


