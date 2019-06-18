package com.ipartek.formacion.colecciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
	
	public ArrayList<String> paises;
	
	
	
	@Before
	public void setUp() {
		paises = new ArrayList<String>();
		paises.add("Barakaldo");
		paises.add("EEUU");
		paises.add("Korea la buena");
	}
	
	
	@Test
	public void test() {
		
		// String [] paises = new String[3];
	
	
		
		
		
		assertFalse(paises.isEmpty());
		
		//size
		
		// Insertar "Kuala Lumpur" entre "Barakaldo" y "EEUU"
		
		// Insertar "Barakaldo" para comprobaer que se puede repetir
		
		// Probar a eliminar "Korea la buena"
		
		// Probar a eliminar todo
		
		// Usar contains para saber si existe "Barakaldo" y "Korea la buena"
		
		//TODO mirar como ordenar alfabeticamente
		
	}
	
	@Test
	public void testArrayVacio() {
		
		assertEquals(3, paises.size());
		
		paises.clear();
		
		assertTrue(paises.isEmpty());
		
		paises.add("Italia");
		
		assertFalse(paises.isEmpty());
		
		
	}

	@Test 
	public void testInsertarEnMedio() {
		paises.add("Barakaldo");
		paises.add("EEUU");
		paises.add("Korea la buena");
		
		paises.add(1, "Kuala Lumpur");
		assertEquals("Barakaldo", paises.get(0));
		assertEquals("Kuala Lumpur", paises.get(1));
		assertEquals("EEUU", paises.get(2));
		
		
	}
	
	@Test
	public void insertarOtraVez() {
		
		paises.add("Barakaldo");
		
		
		int cont = 0;
		Iterator<String> it= paises.iterator();
		
		while(it.hasNext()) {
			
			String pais = it.next();
			if("Barakaldo".equals(pais)) {
				cont++;
			}
		}
		
		assertEquals(2, cont);
	}
	
	//TODO probar eliminar todos, probar contains Barakaldo y korea la buena
	
	@Test
	public void ordenarTest() {
		Collections.sort(paises);
	}
}
