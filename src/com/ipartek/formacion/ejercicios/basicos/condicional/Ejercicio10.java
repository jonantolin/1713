package com.ipartek.formacion.ejercicios.basicos.condicional;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mes;
		
		System.out.println("Introduzca un número del 1 al 12 para ver el mes: ");
		mes = sc.nextInt();
		
		switch(mes) {
		case 1: System.out.println("Has elegido Enero que tiene 31 días.");
		break;
		
		case 2: System.out.println("Has elegido Febrero que tiene 28 días.");
		break;
		
		case 3: System.out.println("Has elegido Marzo que tiene 31 días.");
		break;
		
		case 4: System.out.println("Has elegido Abril que tiene 30 días.");
		break;
		
		case 5: System.out.println("Has elegido Mayo que tiene 31 días.");
		break;
		
		case 6: System.out.println("Has elegido Junio que tiene 30 días.");
		break;
		
		case 7: System.out.println("Has elegido Julio que tiene 31 días.");
		break;
		
		case 8: System.out.println("Has elegido Agosto que tiene 31 días.");
		break;
		
		case 9: System.out.println("Has elegido Septiembre que tiene 30 días.");
		break;
		
		case 10: System.out.println("Has elegido Octubre que tiene 31 días.");
		break;
		
		case 11: System.out.println("Has elegido Noviembre que tiene 30 días.");
		break;
		
		case 12: System.out.println("Has elegido Diciembre que tiene 31 días.");
		break;
		
		default: System.out.println("No has elegido un mes correcto (num del 1 al 12)");
		
		}
		sc.close();
	}

}
