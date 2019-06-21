package com.ipartek.formacion.modelo;

import java.util.List;

/**
 * Operaciones básicas de CRUD
 * @author Curso
 *
 * P (o cualquier mayuscula) es una clase genérica,
 * para que se pueda implementar la interfaz en cualquier objeto
 */
public interface IPersistible<P> {
	
	/**
	 * listado de P
	 * @return List<P>,  y si no hay datos lista inicializada
	 */
	List<P> getAll();
	
	/**
	 * Recupera P por su identofocador
	 * @param id int identificador
	 * @return P, y si no existe null
	 */
	P getById(int id);
	
	/**
	 * Crea un nuevo registro
	 * @param pojo 
	 * @return true si inserta, false en caso contrario
	 */
	boolean insert(P pojo); // Se le pasa todo el objeto, no el id
	
	
	/**
	 * Elimina un nuevo registro
	 * @param int 
	 * @return true si elimina el registro, false en caso contrario
	 */
	boolean delete(int id);
	
	//boolean delete(String nombre);
	
	
	/**
	 * Actualiza un nuevo registro
	 * @param pojo 
	 * @return true si actualiza registro, false en caso contrario
	 */
	boolean update(P pojo);
	
	
}
