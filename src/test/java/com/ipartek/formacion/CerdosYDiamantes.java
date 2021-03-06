package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.Test;

public class CerdosYDiamantes  {

	
	@Test
	public void test() {

		ArrayList<Ordenable> lista = new ArrayList<Ordenable>();
		ArrayList<String> lista2 = new ArrayList<String>();
		Cerdo c = new Cerdo("Pig", 3);
		Diamante d = new Diamante("Rojo",1);
		Cerdo c2 = new Cerdo("Rodirgo",30);
		Diamante d2 = new Diamante("Blanco",40);
		Cerdo c3 = new Cerdo("Clen", 5);
		Diamante d3 = new Diamante(10);
		
		lista.add(c);
		lista.add(d);
		lista.add(c2);
		lista.add(d2);
		lista.add(c3);
		lista.add(d3);
		
		lista2.add("Perro");
		lista2.add("Zapato");
		lista2.add("Alambre");
		lista2.add("Barco");
		lista2.add("Casa");
		

		Collections.sort(lista, new ComparadorCerdosDiamantes());
		
		assertEquals(1, lista.get(0).getValor());
		assertEquals(c, lista.get(1));
		assertEquals(c3, lista.get(2));
		assertEquals(d3, lista.get(3));
		assertEquals(c2, lista.get(4));
		assertEquals(40, lista.get(5).getValor());
		
		assertEquals("El nombre del cerdo es Pig", devolverDato(lista.get(1)));
		
		Collections.sort(lista2);
		
		assertEquals("Alambre",lista2.get(0));
		assertEquals("Barco",lista2.get(1));
		assertEquals("Casa",lista2.get(2));
		assertEquals("Perro",lista2.get(3));
		assertEquals("Zapato",lista2.get(4));
		
		
		
	}
	
	
	
	public String devolverDato(Ordenable elemento) {
		
		// Esto es para sacar un dato exclusivo de un objeto sin saber cual me llega,
		// En este caso si es un cerdo quiero su nombre y de un diamante su color
		
		String mensaje="";
		
		if(elemento instanceof Cerdo) {
			Cerdo c1 = (Cerdo) elemento;
			mensaje = "El nombre del cerdo es "+c1.getNombre();
			
		}
		if(elemento instanceof Diamante) {
			Diamante d1 = (Diamante) elemento;	
			mensaje = "El color del diamante es "+d1.getColor();	
		}	
		
		return mensaje;
	}

	
}
