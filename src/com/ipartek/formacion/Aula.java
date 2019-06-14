package com.ipartek.formacion;

public class Aula {

	public static void main(String[] args) {

		// Declarar array con nombre alumnos

		// Generar numero aleatorio

		// Mostrar voluntario para leer

		String[] alumnos = { "Ander",
							"Mounir",	
							"Andoni",
							"Asier",
							"Jon C",
							"Arkaitz",
							"Aritz",
							"Manuel",
							"Eduardo",
							"Eder I",
							"Eder S",
							"Gaizka",
							"Borja",
							"Verónica",
							"Jon A",
							"Jose Luís"};

		int numAleatorio;

		numAleatorio = (int) (Math.random() * alumnos.length);

		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i]);

		}

		System.out.println("El alumno escogido es: " + alumnos[numAleatorio]);
	}

}
