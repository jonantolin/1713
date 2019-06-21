package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



/**
 * 
 * @author Jon
 *
 */
public class AulaSinDAO{
	
	private int alumSeleccionado = 0;
	private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	
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
			listaAlumnos.add(new Alumno(alumnos[i]));
		}
	}
	
	public void listado() {
		
		ordenarLista();
		Iterator <Alumno> it = listaAlumnos.iterator();
		
	
		while(it.hasNext()) {
			
			Alumno alum = (Alumno) it.next();
	
			System.out.println(alum.getNombre()+" --------Elegido: "+ alum.getNumVecesElegido()+" veces");

		}
		
	}
	
	public void ordenarLista() {
		
		Collections.sort(listaAlumnos);

	} 
	
	public void nuevoAlumno(String nombre) {
		listaAlumnos.add(new Alumno(nombre));
	}
	
	/**
	 * Busca el alumno en la listaAlumnos y lo elimina
	 * @param nombre String nombre de alumno a eliminar
	 */
	public void eliminarAlumno(String nombre) {
		
		for (Iterator<Alumno> iterator = listaAlumnos.iterator(); iterator.hasNext();) {
			
			Alumno alum = (Alumno) iterator.next();
			
			if(alum.getNombre().equals(nombre)) {
				System.out.println(alum.getNombre()+" ha sido eliminado de la lista");
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
		
		
		listaAlumnos.get(alumSeleccionado).setNumVecesElegido(listaAlumnos.get(alumSeleccionado).getNumVecesElegido() +1);
		
		mensaje = "El alumno escogido es: " + listaAlumnos.get(alumSeleccionado).getNombre();
		
		return mensaje;
	}



}

