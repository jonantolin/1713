package com.ipartek.formacion.exccepciones;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Comienza programa");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor introduce un n�mero del 0 al 9");
		
		try {
		String sNumero = sc.nextLine();
		int numero = Integer.parseInt(sNumero);
		
		System.out.println("Su n�mero es " + numero);
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Mensaje de la excepci�n: "+e.getMessage());
			System.out.println("Te dije un N�MERO!! Que si no falla");
			
		}finally {
			sc.close();
		}
		
		
		
		
		System.out.println("\nfinaliza programa");
	}

}
