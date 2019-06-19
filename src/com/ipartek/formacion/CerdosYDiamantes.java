package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class CerdosYDiamantes  {

	
	@Test
	public void test() {

		ArrayList<Object> lista = new ArrayList<Object>();
		Cerdo c = new Cerdo(3);
		Diamante d = new Diamante(1);
		Cerdo c2 = new Cerdo(30);
		Diamante d2 = new Diamante(40);
		Cerdo c3 = new Cerdo(5);
		Diamante d3 = new Diamante(10);
		
		lista.add(c);
		lista.add(d);
		lista.add(c2);
		lista.add(d2);
		lista.add(c3);
		lista.add(d3);
		
		Collections.sort(lista, new ComparadorCerdosDiamantes());
		
		assertEquals(1, lista.get(0));
		
		//Collections.sort(lista, new ComparadorCerdosDiamantes());
		
	}

	
	

}
