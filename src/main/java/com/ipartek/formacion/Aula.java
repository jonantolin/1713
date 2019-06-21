package com.ipartek.formacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import com.ipartek.formacion.modelo.DAOAlumnoFile;


/**
 * Aplicación para elegir un alumno aleatorio para que lea,
 * Permite ver un ranking con las veces que ha sido seleccionado cada alumno
 * Permite crear, eliminar, actualizar alumnos (CRUD)
 * Tambien se puede guardar en un fichero de texto el ranking y visualizarlo
 * 
 * @author Jon
 *
 */
public class Aula {

	private static Scanner sc = new Scanner(System.in);

	private int alumSeleccionado = 0;
	private static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	private static DAOAlumnoFile dao = new DAOAlumnoFile(listaAlumnos);

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
		cargarListaGuardada();
		Collections.sort(dao.getAll());

		Iterator<Alumno> it = dao.getAll().iterator();

		int cont = 0;
		
		System.out.println("Ranking de alumnos elegidos: ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Pos | Nombre | Veces Elegido");
		while (it.hasNext()) {
			
			
			Alumno alum = (Alumno) it.next();
			cont++;
			System.out.println(
					cont + "º" +" | "+ alum.getNombre() + " | " + alum.getNumVecesElegido());

		}

	}

	private static void nuevoAlumno() {

		String nombre;

		System.out.println("\nIntroduzca nombre del nuevo alumno: ");
		nombre = (String) sc.nextLine();
		dao.insert(new Alumno(nombre));
		guardarListado();
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
			guardarListado();
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
		
		guardarListado();

		mensaje = " El alumno escogido es: " + dao.getAll().get(alumSeleccionado).getNombre();

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
			guardarListado();
			System.out.println(nombreAnterior + "Cambiado con éxito por " + nombreNuevo);
		} else {
			System.out.println("Error al cambiar, no existia registro.");
		}
		// dao.update(pojo);
	}

	private static void pintarMenu() {
		
		//TODO implementar reinicar listado
		
		System.out.println("\nIntroduzca la opción que quiera (introduzca número): "
						+ "\n1 - Listar alumnos"
						+ "\n2 - Crear alumno" 
						+ "\n3 - Eliminar alumno" 
						+ "\n4 - Buscar Alumno Afortunado para leer"
						+ "\n5 - Modificar alumno" 
						//+ "\n6 - Reiniciar Ranking" 
						+ "\n0 - Salir" 
						+ "\nIntroduzca numero: ");
	}

	private static void cargarListaGuardada() {
		listaAlumnos = dao.LeerListaGuardada();

	}

	private static void guardarListado() {

		try {
			dao.guardarLista(listaAlumnos);
			System.out.println("Guardado con éxito.");
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Aula aula = new Aula();
		rellenarLista();
		

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