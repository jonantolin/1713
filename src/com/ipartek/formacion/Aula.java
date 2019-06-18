package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aula {
	
	
	private ArrayList<Person> listaAlumnos = new ArrayList<Person>();
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

	public void rellenarLista() {
		for (int i = 0; i < alumnos.length; i++) {
			listaAlumnos.add(new Person(alumnos[i], 20, 'H'));
		}
	}
	
	public void listado() {
		
		Iterator <Person> it = listaAlumnos.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getNombre());
		}
		
	}
	
	public String afortunado() {
		String mensaje;
		int numAleatorio;

		numAleatorio = (int) (Math.random() * listaAlumnos.size());
		
		mensaje = "El alumno escogido es: " + listaAlumnos.get(numAleatorio).getNombre();
		
		return mensaje;
	}
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int opcion = 0;
	
	while(opcion != 0) {
		System.out.println("Introduzca la opción que quiera: "
				+ "\nListar alumnos"
				+ "\nCrear alumno"
				+ "\nEliminar alumno"
				+ "\nBuscar Alumno");
		opcion = sc.nextInt();
		switch(opcion) {
		
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("Introduce una opción metiendo un número del 1 al 4 o 0 para salir");
		}
	}
	
	sc.close();
}

}
