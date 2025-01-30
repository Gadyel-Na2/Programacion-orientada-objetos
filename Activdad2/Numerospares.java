/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numerospares;
/**
 *
 * @author aldopazmendiola
 */
public class Numerospares {

    public static void main(String[] args) {
        int[] numerosPares = new int[50];
        int index = 0;
        
        for (int i = 2; i <= 100; i += 2) {
            numerosPares[index] = i;
            index++;
        }
        
        System.out.println("Lista de números pares del 2 al 100:");
        for (int numero : numerosPares) {
            System.out.print(numero + " ");
        }
        
    }
}