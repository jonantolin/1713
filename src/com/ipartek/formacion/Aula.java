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

	/* 
	 * Cambiar el array de alumnos por arraylist de Person
	 * 
	 * Otra aplicacion Java:
	 *  Menu: 1 - Listar Alumnos con Ranking
	 * 2 - Crear Alumno (Nombre, edad)
	 * 3 - eliminar Alumno
	 * 4 - Bucar Voluntario pa leer (No puede salir el anterior si se tira 2 veces)
	 * 5 - Ranking de las veces que ha salido cada uno
	 * 
	 * Encapsulado en pequeñas funciones
	 * 
	 * 
	 * 
	 * */
}
