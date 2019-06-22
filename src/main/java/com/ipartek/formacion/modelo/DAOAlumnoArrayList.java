package com.ipartek.formacion.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ipartek.formacion.Alumno;

//No implemento IPersistible<P> sino directamente <Alumno> porque se que es para Alumnos
// A esto se le llama "interferir" -> pj: Se le interfiere con Alumno
public class DAOAlumnoArrayList implements IPersistible<Alumno> {

	private static DAOAlumnoArrayList INSTANCE;
	private ArrayList<Alumno> lista;
	
	
	
	/**
	 * Encargado de devolver solo un objeto, patron Singleton La palabra reservada
	 * synchronized hace que si se le llama al mismo tiempo, cree uno y al terminar,
	 * cree el otro y así sucesivamente
	 * 
	 * @return
	 */
	public static synchronized DAOAlumnoArrayList getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DAOAlumnoArrayList();
		}
		return INSTANCE;
	}

	/**
	 * Privado para que nadie pueda crear objetos
	 */
	private DAOAlumnoArrayList() {
		super();
		this.lista = new ArrayList<Alumno>();
	}

	public DAOAlumnoArrayList(ArrayList<Alumno> lista) {
		super();
		this.lista = lista;
	}
	
	
	
	@Override
	public List<Alumno> getAll() {
		return lista;
	}

	@Override
	public Alumno getById(int id) {
		Alumno resul = null;

		for (Alumno a : lista) {
			if (a.getId() == id) {
				resul = a;
				break; // Si lo encuentra no sigue iterando
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Alumno pojo) {
		lista.add(pojo);

		// System.out.println("Añadido");
		return true;
	}

	

	@Override
	public boolean update(Alumno pojo) {
		Scanner sc = new Scanner(System.in);
		String nuevoNombre = sc.nextLine();
		pojo.setNombre(nuevoNombre);
		sc.close();
		return true;
	}

	public boolean update(String nombreViejo, String nombreNuevo) {

		for (Iterator<Alumno> iterator = lista.iterator(); iterator.hasNext();) {

			Alumno alum = (Alumno) iterator.next();

			if (alum.getNombre().equals(nombreViejo)) {

				// iterator.remove();
				alum.setNombre(nombreNuevo);
			}

		}

		return true;
	}
	

	@Override
	public boolean delete(int id) {
		// TODO implementar borrar por id
		return false;
	}
	
	public boolean delete(String nombre) {

		boolean borrado = false;

		for (Iterator<Alumno> iterator = lista.iterator(); iterator.hasNext();) {

			Alumno alum = (Alumno) iterator.next();

			if (alum.getNombre().equals(nombre)) {

				iterator.remove();
				borrado = true;
			}

		}

		return borrado;
	}

}