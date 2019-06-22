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
 * Se guarda automaticamente en un fichero de texto el ranking y se inicia con el mismo
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
	
	private static final String MOSTRAR_RANKING = "1";
	private static final String CREAR_ALUMNO = "2";
	private static final String ELIMINAR_ALUMNO = "3";
	private static final String BUSCAR_VOLUNTARIO = "4";
	private static final String MODIFICAR_ALUMNO = "5";
	private static final String NUEVO_RANKING = "6";
	private static final String SALIR = "0";
	
	

	/**
	 * Rellena arrayList<Alumno> listaAlumnos con array de String alumnos,
	 * y vecesElegido se establece a 0
	 * 
	 * Se usa la primera vez o cuando no existe registro guardado
	 * @see alumnos
	 */
	private static void rellenarLista() {
		
		listaAlumnos = new ArrayList<Alumno>();
				 
		for (int i = 0; i < alumnos.length; i++) {

				listaAlumnos.add(new Alumno(alumnos[i]));	
		}
		

	}
	
	private static void listado() {
		
		// Comprueba si existe ranking guardado en archivo, ordena y lo muestra, sino crea uno nuevo con ranking a 0
		if(cargarListaGuardada()) {
			
			Collections.sort(dao.getAll());
			
			Iterator<Alumno> it = dao.getAll().iterator();

			int cont = 0;
			
			System.out.println("            Ranking de alumnos elegidos: ");
			System.out.println("-----------------------------------------------------");
			System.out.println("           Pos | Nombre | Veces Elegido");
			System.out.println("           ----------------------------");
			while (it.hasNext()) {
				
				
				Alumno alum = (Alumno) it.next();
				cont++;
				System.out.println(
						"           "+cont + "º" +" | "+ alum.getNombre() + " | " + alum.getNumVecesElegido());

			}
			
		}else {
			
			nuevoRanking();
		}

	}
	
	/**
	 * Crea un nuevo Ranking de alumnos del Aula con numVecesElegido = 0
	 */
	private static void nuevoRanking() {
		
		rellenarLista();
		dao = new DAOAlumnoFile(listaAlumnos);
		guardarListado();
		listado();
		
	}
	
	private static void nuevoAlumno() {
		
		boolean insertado;
		String nombre;

		System.out.println("\nIntroduzca nombre del nuevo alumno: ");
		nombre = (String) sc.nextLine();
		insertado = dao.insert(new Alumno(nombre));
		
		if(insertado) {
			
			guardarListado();
			System.out.println("Añadido con éxito");
		}

	}

	/**
	 * Busca el alumno en la listaAlumnos y lo elimina
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
	 * Devuelve String con el voluntario para leer y le suma 1 a NumVecesElegido
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

	
	/**
	 * Ordena al DAO deserializar y devolver el ranking guardado,
	 * listaAlumnos recoge y copia el objeto deserializado devuelto por el DAO siendo esta variable de clase local
	 * @return booleano si ha podido recuperar ranking guardado
	 */
	private static boolean cargarListaGuardada() {
		
		boolean cargada = false;
		
		try {
			listaAlumnos = dao.LeerListaGuardada();
			if(listaAlumnos.size() > 0) {
				cargada = true;
			}
		}catch(Exception e) {
			
		}
		
		return cargada;	
	}
	
	
	/**
	 * Ordena al DAO guardar el ranking en archivo
	 */
	private static void guardarListado() {

		try {
			dao.guardarLista(listaAlumnos);
			
		} catch (IOException e) {
			System.out.println("Error");
		}

	}
	

	private static void pintarMenu() {
	
		
		System.out.println("\n--------------------------------------------------"
						+ "\n        Introduzca la opción que quiera:"
						+ "\n\n            1 -> Ver Ranking"
						+ "\n            2 -> Crear alumno" 
						+ "\n            3 -> Eliminar alumno" 
						+ "\n            4 -> Buscar Alumno Afortunado para leer"
						+ "\n            5 -> Modificar alumno" 
						+ "\n            6 -> Reiniciar Ranking" 
						+ "\n\n            0 -> Salir" 
						+ "\n\n--------------------------------------------------" 
						+ "\n\nIntroduzca número: ");
	}
	
	public static void main(String[] args) {
		

		Aula aula = new Aula();
		
		System.out.println("RANKING DE VOLUNTARIOS PARA LEER");
		String opcion = "0";

		do {
			
			pintarMenu();

			opcion = sc.next();

			switch (opcion) {

			case MOSTRAR_RANKING:
				
				listado();
				break;

			case CREAR_ALUMNO:

				nuevoAlumno();
				break;

			case ELIMINAR_ALUMNO:

				eliminarAlumno();
				break;

			case BUSCAR_VOLUNTARIO:

				System.out.println(aula.afortunado());
				break;

			case MODIFICAR_ALUMNO:

				actualizarAlumno();
				break;
				
			case NUEVO_RANKING:

				nuevoRanking();
				break;
				
			case SALIR:

				System.out.println("Hasta pronto");
				break;

			default:
				System.out.println("Introduce una opción metiendo un número del 1 al 6 o 0 para salir");
			}

		} while (!opcion.equals("0"));

		sc.close();
	}

}