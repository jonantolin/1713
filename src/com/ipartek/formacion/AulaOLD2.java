package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * 
 * @author Jon
 *
 */
public class AulaOLD2 {

	private int alumSeleccionado = 0;
	private ArrayList<Person> listaAlumnos = new ArrayList<Person>();
	private ArrayList<Integer> vecesElegido = new ArrayList<Integer>();
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

	/**
	 * Rellena arrayList<Person> listaAlumnos con array de String alumnos,
	 * y arrayList<Integer> vecesElegido se establece a 0
	 * @see alumnos
	 */
	public void rellenarLista() {
		for (int i = 0; i < alumnos.length; i++) {
			listaAlumnos.add(new Person(alumnos[i], 20, 'H'));
			vecesElegido.add(0);
		}
	}
	
	public void listado() {
		
		Iterator <Person> it = listaAlumnos.iterator();
		Iterator <Integer> it2 = vecesElegido.iterator();
	
		while(it.hasNext() && it2.hasNext()) {
			
			Person person = (Person) it.next();
			Integer num = (Integer) it2.next();
			System.out.println(person.getNombre()+" --------Elegido: "+ num+" veces");

		}
		
	}
	
	public void ordenarLista() {
		
		// Collections.sort();
		
		Iterator<Person> it = listaAlumnos.iterator();
		Iterator <Integer> it2 = vecesElegido.iterator();
		
		
		for (int i = 0; i < listaAlumnos.size(); i++) {
			
			for (int j = 0; j < listaAlumnos.size() - i - 1; j++) {
				
				int aux;
				Person auxNombre;
				
				Person person = (Person) it.next();
				Integer num = (Integer) it2.next();
				
				if (num > vecesElegido.get(j + 1)) {
					aux = vecesElegido.get(j + 1);
					auxNombre = listaAlumnos.get(j + 1);
					
					listaAlumnos.set(j + 1, person);
					listaAlumnos.set(j, auxNombre);
					
					vecesElegido.set(j + 1, num) ;
					vecesElegido.set(j, aux);
				}
			}
		}
		
	}
	
	public void nuevoAlumno(String nombre) {
		listaAlumnos.add(new Person(nombre, 20, 'H'));
		vecesElegido.add(0);
	}
	
	public void nuevoAlumno(String nombre, int edad, char sexo) {
		listaAlumnos.add(new Person(nombre, edad, sexo));
		vecesElegido.add(0);
	}
	
	/**
	 * Busca el alumno en la listaAlumnos y lo elimina
	 * @param nombre String nombre de alumno a eliminar
	 */
	public void eliminarAlumno(String nombre) {
		
		for (Iterator<Person> iterator = listaAlumnos.iterator(); iterator.hasNext();) {
			
			Person person = (Person) iterator.next();
			
			if(person.getNombre().equals(nombre)) {
				System.out.println(person.getNombre()+" ha sido eliminado de la lista");
				iterator.remove();
			}
			
		}
	}

	
	/**
	 * 
	 * @return String con el nombre del alumno elegido para leer
	 */
	public String afortunado() {
		
		String mensaje;
		int numAleatorio=0;
		
		
		do {
			
			numAleatorio = (int) (Math.random() * listaAlumnos.size());
			
		}while(numAleatorio == alumSeleccionado);
		
		alumSeleccionado = numAleatorio;
		vecesElegido.set(alumSeleccionado, vecesElegido.get(alumSeleccionado)+1);
		
		mensaje = "El alumno escogido es: " + listaAlumnos.get(alumSeleccionado).getNombre();
		
		return mensaje;
	}
	
	
}
