package com.ipartek.formacion.modelo;

import java.util.List;

/**
 * Operaciones b�sicas de CRUD
 * @author Curso
 *
 * P (o cualquier mayuscula) es una clase gen�rica,
 * para que se pueda implementar la interfaz en cualquier objeto
 */
public interface IPersistible<P> {
	
	List<P> getAll();
	
	P getById(int id);
	
	boolean insert(P pojo); // Se le pasa todo el objeto, no el id
	
	boolean delete(int id);
	
	boolean update(P pojo);

}
