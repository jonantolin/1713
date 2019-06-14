package com.ipartek.formacion.utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrdenarArrayTest {

	/**
	 * Se podria lanzar la excepción manualmente para especificar
	 * porque se ha lanzado (pj: "No se puede mandar un array null")
	 * o decirlo al capturarla en un catch (NullPointerException)
	 */
	@Test ( expected = NullPointerException.class)
	public void ordenarTest() {
		int [] prueba = {12, 3, 8, 5, 2, 6};
		
		int [] pruebaOrdenado = OrdenarArray.ordenar(prueba);
		
		assertEquals(2, pruebaOrdenado[0]);
		assertEquals(3, pruebaOrdenado[1]);
		assertEquals(5, pruebaOrdenado[2]);
		assertEquals(6, pruebaOrdenado[3]);
		assertEquals(8, pruebaOrdenado[4]);
		assertEquals(12, pruebaOrdenado[5]);
		
		int [] prueba2 = {-4, 5, 26, 2};
		int[] pruebaOrdenado2 = {-4, 2, 5, 26};
		assertArrayEquals(pruebaOrdenado2, OrdenarArray.ordenar(prueba2));
		
		int [] prueba3 = null;
		OrdenarArray.ordenar(prueba3);

	}

}
