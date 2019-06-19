package com.ipartek.formacion.ejercicios.basicos.secuencial;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int velocidad;
		
		System.out.println("Introduce velocidad en km/h: ");
		velocidad = sc.nextInt();
		
		double velocidadMS = velocidad * 1000 / 3600;
		
		System.out.println("La velocidad en M/S es "+velocidadMS);
		
		sc.close();
	}

}
