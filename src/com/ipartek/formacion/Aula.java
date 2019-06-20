package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.ipartek.formacion.modelo.DAOAlumnoArrayList;

public class Aula {
	
	private static Scanner sc = new Scanner(System.in);
	private static DAOAlumnoArrayList dao;
	private int alumSeleccionado = 0;
	private static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	
	 static String[] alumnos = { "Ander",
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
			"Ver�nica",
			"Jon A",
			"Jose Lu�s"};

	/**
	 * Rellena arrayList<Person> listaAlumnos con array de String alumnos,
	 * y arrayList<Integer> vecesElegido se establece a 0
	 * @see alumnos
	 */
	private static void rellenarLista() {
		for (int i = 0; i < alumnos.length; i++) {
			listaAlumnos.add(new Alumno(alumnos[i]));
		}
		dao = new DAOAlumnoArrayList(listaAlumnos);
	}
	
	private static void listado() {
		
		ordenarLista();
		Iterator <Alumno> it = dao.getAll().iterator();
		
	
		while(it.hasNext()) {
			
			Alumno alum = (Alumno) it.next();
	
			System.out.println(alum.getNombre()+" --------Elegido: "+ alum.getNumVecesElegido()+" veces");

		}
		
	}
	
	private static void ordenarLista() {
		
		Collections.sort(dao.getAll());

	} 
	
	private static void nuevoAlumno() {

		String nombre;
		
		System.out.println("\nIntroduzca nombre del nuevo alumno: ");
		nombre = (String)sc.nextLine();
		dao.insert(new Alumno(nombre));
		System.out.println("A�adido con �xito");
	}
	
	/**
	 * Busca el alumno en la listaAlumnos y lo elimina
	 * @param nombre String nombre de alumno a eliminar
	 */
	private static void eliminarAlumno() {
		
		System.out.println("\nIntroduzca nombre que desea ELIMINAR");
		
		sc = new Scanner(System.in);
		String nombre = (String)sc.nextLine(); 
		if(dao.delete(nombre)) {
			System.out.println("Eliminado con �xito");
		}else {
			System.out.println("No se pudo eliminar, no exist�a registro");
		}
		
	
	}

	
	/**
	 * 
	 * @return String con el nombre del alumno elegido para leer
	 */
	private String afortunado() {
		
		String mensaje;
		int numAleatorio=0;
		
		
		do {
			
			numAleatorio = (int) (Math.random() * listaAlumnos.size());
			
		}while(numAleatorio == alumSeleccionado);
		
		alumSeleccionado = numAleatorio;
		
		
		dao.getAll().get(alumSeleccionado).setNumVecesElegido(dao.getAll().get(alumSeleccionado).getNumVecesElegido() +1);
		
		mensaje = "El alumno escogido es: " + dao.getAll().get(alumSeleccionado).getNombre();
		
		return mensaje;
	}
	
	private static void actualizarAlumno() {
		
		String nombreAnterior;
		String nombreNuevo;
		System.out.println("\nIntroduzca nombre que quiere actualizar: ");
		nombreAnterior = sc.nextLine();
		
		System.out.println("Introduce nuevo nombre: ");
		nombreNuevo = sc.nextLine();
		
		if(dao.update(nombreAnterior, nombreNuevo)) {
			System.out.println(nombreAnterior+ "Cambiado con �xito por "+nombreNuevo);
		}else {
			System.out.println("Error al cambiar, no existia registro.");
		}
		//dao.update(pojo);
	}

	
	private static void pintarMenu() {
		
		System.out.println("\nIntroduzca la opci�n que quiera (introduzca n�mero): "
				+ "\n1 - Listar alumnos"
				+ "\n2 - Crear alumno"
				+ "\n3 - Eliminar alumno"
				+ "\n4 - Buscar Alumno Afortunado para leer"
				+ "\n5 - Modificar alumno"
				+ "\n0- Salir"
				+ "\nIntroduzca numero: ");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Aula aula = new Aula();
		rellenarLista();
		// DAOAlumnoArrayList dao = new DAOAlumnoArrayList();
		
		
		String opcion ="0";
		
		do{
			
			pintarMenu();

			opcion = sc.next();
				
			switch(opcion) {
			
				case "1":
					
					listado();
					break;
					
				case "2": 
					
					nuevoAlumno();
					break;
					
				case "3":
	
					eliminarAlumno();
					break;
					
				case "4":
					System.out.println(aula.afortunado());
					break;
				
				case "5":
					actualizarAlumno();
					break;
				case "0": 
					System.out.println("Hasta pronto");
					break;
					
				default:
					System.out.println("Introduce una opci�n metiendo un n�mero del 1 al 4 o 0 para salir");
			}
			
			
			
		}while(!opcion.equals("0"));
		
		sc.close();
	}


}
