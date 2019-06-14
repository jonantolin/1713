package com.ipartek.formacion.exccepciones;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Comienza programa");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor introduce un número del 0 al 9");
		
		try {
		String sNumero = sc.nextLine();
		int numero = Integer.parseInt(sNumero);
		
		System.out.println("Su número es " + numero);
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Mensaje de la excepción: "+e.getMessage());
			System.out.println("Te dije un NÚMERO!! Que si no falla");
			
		}finally {
			sc.close();
		}
		
		
		
		
		System.out.println("\nfinaliza programa");
	}

}
