
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

public class DAOAlumnoFile implements IPersistible<Alumno>, Serializable {

	// No implemento IPersistible<P> sino directamente <Alumno> porque se que es
	// para Alumnos
	// A esto se le llama "interferir" -> pj: Se le interfiere con Alumno

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private static DAOAlumnoFile INSTANCE;
	private ArrayList<Alumno> lista;

	/**
	 * Encargado de devolver solo un objeto, patron Singleton La palabra reservada
	 * synchronized hace que si se le llama al mismo tiempo, cree uno y al terminar,
	 * cree el otro y así sucesivamente
	 * 
	 * @return
	 */
	public static synchronized DAOAlumnoFile getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DAOAlumnoFile();
		}
		return INSTANCE;
	}

	/**
	 * Privado para que nadie pueda crear objetos
	 */
	private DAOAlumnoFile() {
		super();
		this.lista = new ArrayList<Alumno>();
	}

	public DAOAlumnoFile(ArrayList<Alumno> lista) {
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

	public void guardarLista(ArrayList<Alumno> lista) throws IOException {

		try {

			File almacen = new File("C:\\\\Users\\\\Jon\\\\eclipse-workspace\\\\1713\\\\RankingAlumnos.txt");
			FileOutputStream fos = new FileOutputStream(almacen);

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lista);
			oos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Alumno> LeerListaGuardada() {

		try {
			FileInputStream lector;
			lector = new FileInputStream("C:\\Users\\Jon\\eclipse-workspace\\1713\\RankingAlumnos.txt");
			// BufferedReader buffer = new BufferedReader(lector);

			ObjectInputStream ois = new ObjectInputStream(lector);

			Object aux = ois.readObject();

			lista = (ArrayList<Alumno>) aux;

			ois.close();

		} catch (IOException ex) {
			//ex.printStackTrace();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return lista;

	}

	@Override
	public boolean delete(int id) {
		// TODO implementar borrar por id
		return false;
	}

}
