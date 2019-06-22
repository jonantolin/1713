package com.ipartek.formacion.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.Alumno;

//No implemento IPersistible<P> sino directamente <Alumno> porque se que es para Alumnos
// A esto se le llama "interferir" -> pj: Se le interfiere con Alumno
public class DAOAlumnoArrayList implements IPersistible<Alumno>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	@Override
	public boolean update(Alumno pojo) {

		// TODO encontrar en la lista por pojo.getId, al encontrarlo setNombre
		// O con setNombr

		// System.out.println("Añadido");
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

	// Guardo en un fichero la el objeto lista con Serialize
	public void guardarMensaje(ArrayList<Alumno> lista) throws IOException {

		try {

			// String linea="";
			File almacen = new File("C:\\1713\\eclipse-workspace\\RankingAlumnos.txt");
			FileOutputStream fos = new FileOutputStream(almacen);

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lista);
			oos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void LeerMensaje() {

		/*
		 * TODO Hacer que pueda usar los datos guardados, con Serialize o guardando los
		 * datos por comas (pj: Jon; 2 )
		 */

		try {
			FileInputStream lector;
			lector = new FileInputStream("C:\\\\1713\\\\eclipse-workspace\\\\RankingAlumnos.txt");
			// BufferedReader buffer = new BufferedReader(lector);

			ObjectInputStream ois = new ObjectInputStream(lector);

			Object aux = ois.readObject();
			
			lista = (ArrayList <Alumno>)aux;
			
			ois.close();
//            boolean eol = false;
//            
//            while(!eol) {
//            String linea = buffer.readLine();
//            
//	            if(linea == null) {
//	            	buffer.close();
//	            	eol = true;
//	            }else {
//	            	System.out.println(linea);
//	            }
//            }

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean delete(int id) {
		// TODO implementar borrar por id
		return false;
	}

}