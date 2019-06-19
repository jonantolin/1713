package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h, m, s;
		boolean horaValida = false;
		boolean	minutosValidos = false;
		boolean segundosValidos = false;
		
		System.out.println("Introduzca 3 números (Hora, Minutos, Segundos)");

		System.out.println("Hora: ");
		h = sc.nextInt();

		System.out.println("Minutos: ");
		m = sc.nextInt();
		
		System.out.println("Segundos: ");
		s = sc.nextInt();
		
		if(h < 24 && h >= 0) {
			horaValida = true;
		}
		
		if(m < 60 && m >= 0) {
			minutosValidos = true;
		}
		
		if(s < 60 && s >= 0) {
			segundosValidos = true;
		}
		
		if(horaValida && minutosValidos && segundosValidos) {
			System.out.println("Es una hora válida");
		}else {
			System.out.println("No es una hora válida");
		}
		
		sc.close();
	}

}
