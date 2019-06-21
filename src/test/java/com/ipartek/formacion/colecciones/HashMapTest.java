package com.ipartek.formacion.colecciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

public class HashMapTest {
	
	@Test
	public void test() {
		
		HashMap<String, String> paises = new HashMap<String, String>();
		
		paises.put("bk", "Barakaldo");
		paises.put("eu", "EEUU");
		paises.put("ko", "Korea");
		
		assertEquals(3, paises.size());
		
		assertEquals("Barakaldo", paises.get("bk"));
		assertNull(paises.get("NO EXISTE ESTA KEY"));
		
		paises.put("bk", "Barakaldo");
		
		Iterator<String> it = paises.values().iterator(); //@see keySet
		
		int cont = 0;
		
		while(it.hasNext()) {
			String valor = it.next();
			if("Barakaldo".equals(valor)) {
				cont++;
			}
		}
		assertEquals(1, cont); // Si es así, no se pone 2 veces el mismo key->valor
		
		Iterator<String> itKeys = paises.keySet().iterator();
		
		cont = 0;
		while(itKeys.hasNext()) {
			String valor = itKeys.next();
			if("bk".equals(valor)) {
				cont++;
			}
		}
		
		assertEquals(1, cont);
		
		
	}

}
