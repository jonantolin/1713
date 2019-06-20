package com.ipartek.formacion.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.Alumno;

//No implemento IPersistible<P> sino directamente <Alumno> porque se que es para Alumnos
// A esto se le llama "interferir" -> pj: Se le interfiere con Alumno
public class DAOAlumnoArrayList implements IPersistible<Alumno> {

	private ArrayList<Alumno> lista;

	public DAOAlumnoArrayList() {
		super();
		this.lista = new ArrayList<Alumno>();
	}
	
	public DAOAlumnoArrayList(ArrayList<Alumno> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public List<Alumno> getAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Alumno getById(int id) {
		// TODO Auto-generated method stub
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
			
			if(alum.getNombre().equals(nombre)) {
				
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
			
			if(alum.getNombre().equals(nombreViejo)) {
				
				//iterator.remove();
				alum.setNombre(nombreNuevo);
			}
			
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
