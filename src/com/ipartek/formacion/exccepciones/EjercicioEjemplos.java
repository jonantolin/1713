package com.ipartek.formacion.exccepciones;

import java.util.Scanner;

public class EjercicioEjemplos {


	public static void main(String[] args) {
		
		boolean repetir = false;
		int num1 = 0;
		int num2 = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			try {
				repetir = false;
				System.out.println("Introduce primer n�mero: ");
				num1 = Integer.parseInt(sc.nextLine());
				

			}catch (Exception e){
				System.out.println("Por favor introduce un n�mero v�lido");
				repetir = true;
			}
		}while(repetir);
		
		do {
			
			try {
				repetir = false;
				System.out.println("Introduce segundo n�mero: ");
				num2 = Integer.parseInt(sc.nextLine());
				

			}catch (Exception e){
				System.out.println("Por favor introduce un n�mero v�lido");
				repetir = true;
			}
		}while(repetir);
		
		sc.close();

		System.out.println(num1 + " + " +num2 + " = " + (num1+num2));
	}

}
