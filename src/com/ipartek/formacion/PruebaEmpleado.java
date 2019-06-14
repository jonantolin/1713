package com.ipartek.formacion;

import java.text.DecimalFormat;

public class PruebaEmpleado {

	public static void main(String[] args) throws PersonException {
		
		Employee empleado1 = new Employee();
		Employee empleado2 = new Employee("Jon", 32, 'H', 3200);
		Employee empleado3 = new Employee("Alba", 26, 'M', 3500);
		Employee empleado4 = new Employee("Margarita", 63, 'M', 2000);
		Employee youtuber1 = new Employee("Logan Paul", 23, 'H', 14500000);
		Employee youtuber2 = new Employee("PewDiePie", 29, 'H', 15500000);
		Employee youtuber3 = new Employee("Jacksepticeye", 28, 'H', 16000000);
		
		Employee [] youtubers = new Employee [3];
		
		youtubers[0] = youtuber1;
		youtubers[1] = youtuber2;
		youtubers[2] = youtuber3;
		
		
		
		System.out.println(empleado1);
		System.out.println(empleado2);
		System.out.println(empleado3);
		System.out.println(empleado4);
		System.out.println(youtuber1);
		System.out.println(youtuber2);
		System.out.println(youtuber3);
		
		System.out.println("");
		System.out.println("Con Array y bucle for");
		System.out.println("");
		
		
		// numero, nombre, salario
		// ej: 1. Logan 1.450.000 $
		
		
		// Creo un objeto que sirve para dar formato al número
		DecimalFormat formateador = new DecimalFormat("##,###,###"); 
		
		
		for (int i = 0; i < youtubers.length; i++) {
				System.out.println((i+1) +". "+youtubers[i].getNombre() + " " 
			+ formateador.format(youtubers[i].getSalario())+" $");

		}
		
		// foreach
		/*
		for( Employee empleado : youtubers ) {
			System.out.println(empleado);
		}
		*/
 }

}
