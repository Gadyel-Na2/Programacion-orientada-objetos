/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package saludo;

/**
 *
 * @author aldopazmendiola
 */
import java.util.Scanner;

public class Saludo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe tu nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.equals("Aldo")) {
            System.out.println("Hola "+ nombre + " (Usuario con permisos)");
        }
        else if (nombre.equals("aldo")) {
            System.out.println("Usuario correcto pero ingresa la primera letra"
                    + " con mayuscula");
        }
        else {
            System.out.println("Usuario Rechazado: " + nombre);
        }
        scanner.close();
         
    }
    
}