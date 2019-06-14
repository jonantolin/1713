package com.ipartek.formacion.ejercicios.basicos.secuencial;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		/*
		 Longitud de la circunferencia = 2*PI*Radio
		 Area de la circunferencia = PI*Radio^2  
		*/
		Scanner sc = new Scanner (System.in);
		
		final double PI = 3.14159584;
		
		double radio;
		
		System.out.println("Introduzca el valor del radio de la circunferencia");
		radio = sc.nextDouble();
		
		double longitud = PI * radio * 2;
		double area = PI * Math.pow(radio, 2);
		
		/* System.out.println("Valor de la longitud: "+longitud+""
				+ "\nValor del área: "+area);
		*/
		
		System.out.printf("Valor de la longitud: %.2f \nValor del área: %.2f", longitud, area);
		
	}

}
