package com.ipartek.formacion.utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraDevolucionTest {

	@Test( expected = Exception.class )
	public void entregadoMenorImporteException() throws Exception {
		
		CalculadoraDevolucion.vueltas(100, 2);
	}
	
	@Test( expected = Exception.class )
	public void importeNegativoException() throws Exception {
		
		CalculadoraDevolucion.vueltas(-100, 2);
	}
	
	@Test( expected = Exception.class )
	public void entregadoNegativoException() throws Exception  {
		
		CalculadoraDevolucion.vueltas(100, -2);

	}
	
	@Test
	public void importeExacto() throws Exception {
		int [] vueltas = CalculadoraDevolucion.vueltas(100, 100);
		for (int i = 0; i < CalculadoraDevolucion.BILLETES_MONEDAS.length; i++) {
			assertEquals(0, vueltas[1]);
		}
	}
	
	@Test
	public void importeNoExacto() throws Exception {
		int [] vueltas = CalculadoraDevolucion.vueltas(500, 501);
		assertEquals("500", 0, vueltas[0]);
		assertEquals("200", 0, vueltas[1]);
		assertEquals("100", 0, vueltas[2]);
		assertEquals("50", 0, vueltas[3]);
		assertEquals("20", 0, vueltas[4]);
		assertEquals("10", 0, vueltas[5]);
		assertEquals("5", 0, vueltas[6]);
		assertEquals("2", 0, vueltas[7]);
		assertEquals("1", 1, vueltas[8]);
		assertEquals("50 cents", 0, vueltas[9]);
		assertEquals("20 cents", 0, vueltas[10]);
		assertEquals("10 cents", 0, vueltas[11]);
		assertEquals("5 cents", 0, vueltas[12]);
		assertEquals("2 cents", 0, vueltas[13]);
		assertEquals("1 cent", 0, vueltas[14]);
		 
		
		
		int [] vueltas2 = CalculadoraDevolucion.vueltas(200.85f, 500);
		assertEquals("500", 0, vueltas2[0]);
		assertEquals("200", 1, vueltas2[1]);
		assertEquals("100", 0, vueltas2[2]);
		assertEquals("50", 1, vueltas2[3]);
		assertEquals("20", 2, vueltas2[4]);
		assertEquals("10", 0, vueltas2[5]);
		assertEquals("5", 1, vueltas2[6]);
		assertEquals("2", 2, vueltas2[7]);
		assertEquals("1", 0, vueltas2[8]);
		assertEquals("50 cents", 0, vueltas2[9]);
		assertEquals("20 cents", 0, vueltas2[10]);
		assertEquals("10 cents", 1, vueltas2[11]);
		assertEquals("5 cents", 1, vueltas2[12]);
		assertEquals("2 cents", 0, vueltas2[13]);
		assertEquals("1 cent", 0, vueltas2[14]);
	 
		
	}

}
