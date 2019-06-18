package com.ipartek.formacion;

import java.util.ArrayList;

import java.util.Iterator;

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
	


}
