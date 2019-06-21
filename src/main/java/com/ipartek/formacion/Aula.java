package com.ipartek.formacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.ipartek.formacion.modelo.DAOAlumnoArrayList;

public class Aula {

	private static Scanner sc = new Scanner(System.in);

	private int alumSeleccionado = 0;
	private static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	private static DAOAlumnoArrayList dao = new DAOAlumnoArrayList(listaAlumnos);

	static String[] alumnos = { "Ander", "Mounir", "Andoni", "Asier", "Jon C", "Arkaitz", "Aritz", "Manuel", "Eduardo",
			"Eder I", "Eder S", "Gaizka", "Borja", "Verónica", "Jon A", "Jose Luís" };

	/**
	 * Rellena arrayList<Person> listaAlumnos con array de String alumnos, y
	 * arrayList<Integer> vecesElegido se establece a 0
	 * 
	 * @see alumnos
	 */
	private static void rellenarLista() {
		for (int i = 0; i < alumnos.length; i++) {
			listaAlumnos.add(new Alumno(alumnos[i]));
		}

	}

	private static void listado() {

		Collections.sort(dao.getAll());

		Iterator<Alumno> it = dao.getAll().iterator();

		int cont = 0;
		while (it.hasNext()) {
			
			
			Alumno alum = (Alumno) it.next();
			cont++;
			System.out.println(
					cont + "º - " + alum.getNombre() + " -------- Elegido: " + alum.getNumVecesElegido() + " veces");

		}

	}

	private static void nuevoAlumno() {

		String nombre;

		System.out.println("\nIntroduzca nombre del nuevo alumno: ");
		nombre = (String) sc.nextLine();
		dao.insert(new Alumno(nombre));
		System.out.println("Añadido con éxito");
	}

	/**
	 * Busca el alumno en la listaAlumnos y lo elimina
	 * 
	 * @param nombre String nombre de alumno a eliminar
	 */
	private static void eliminarAlumno() {

		System.out.println("\nIntroduzca nombre que desea ELIMINAR");

		sc = new Scanner(System.in);
		String nombre = (String) sc.nextLine();
		if (dao.delete(nombre)) {
			System.out.println("Eliminado con éxito");
		} else {
			System.out.println("No se pudo eliminar, no existía registro");
		}

	}

	/**
	 * 
	 * @return String con el nombre del alumno elegido para leer
	 */
	private String afortunado() {

		String mensaje;
		int numAleatorio = 0; // Servira de indice para array / lista

		do {

			numAleatorio = (int) (Math.random() * listaAlumnos.size());

		} while (numAleatorio == alumSeleccionado);

		alumSeleccionado = numAleatorio;

		dao.getAll().get(alumSeleccionado)
				.setNumVecesElegido(dao.getAll().get(alumSeleccionado).getNumVecesElegido() + 1);

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

		if (dao.update(nombreAnterior, nombreNuevo)) {
			System.out.println(nombreAnterior + "Cambiado con éxito por " + nombreNuevo);
		} else {
			System.out.println("Error al cambiar, no existia registro.");
		}
		// dao.update(pojo);
	}

	private static void pintarMenu() {

		System.out.println("\nIntroduzca la opción que quiera (introduzca número): "
						+ "\n1 - Listar alumnos"
						+ "\n2 - Crear alumno" 
						+ "\n3 - Eliminar alumno" 
						+ "\n4 - Buscar Alumno Afortunado para leer"
						+ "\n5 - Modificar alumno" 
						+ "\n6 - Guardar lista" 
						+ "\n7 - Ver última lista guardada" 
						+ "\n0- Salir" 
						+ "\nIntroduzca numero: ");
	}

	private static void cargar_lista_guardada() {
		dao.LeerMensaje();

	}

	private static void guardar_mensaje() {

		try {
			dao.guardar_mensaje(listaAlumnos);
			System.out.println("Guardado con éxito.");
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Aula aula = new Aula();
		rellenarLista();
		// DAOAlumnoArrayList dao = new DAOAlumnoArrayList();

		String opcion = "0";

		do {

			pintarMenu();

			opcion = sc.next();

			switch (opcion) {

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

			case "6":

				guardar_mensaje();
				break;

			case "7":

				cargar_lista_guardada();
				break;

			case "0":

				System.out.println("Hasta pronto");
				break;

			default:
				System.out.println("Introduce una opción metiendo un número del 1 al 4 o 0 para salir");
			}

		} while (!opcion.equals("0"));

		sc.close();
	}

}