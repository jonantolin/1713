package com.ipartek.formacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class YoutubeTest {
	
	Youtube video;
	
	private static final int LONGITUD_CODIGO = 11;
	private static final int LONGITUD_MIN_TITULO = 2;
	private static final int LONGITUD_MAX_TITULO = 150;
	private static final String URL = "https://www.youtube.com/watch?v=";
	
	private String titulo = "Rammstein";
	private String codigo = "12345678901"; // exactamente 11
	private int reproducciones; // >= 0

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		video = new Youtube(titulo, codigo);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Ignore
	@Test
	public void testYoutube() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitulo() {
		assertEquals("Rammstein", video.getTitulo());
	}

	@Test (expected = Exception.class)
	public void testSetTitulo() throws Exception{
		video.setTitulo("Concierto");
		assertEquals("Concierto", video.getTitulo());
		
		video.setTitulo("a"); // Debe lanzar la excepción, porque tiene que tener length >= 2
		assertEquals("Rammstein", video.getTitulo());
	}

	@Test
	public void testGetCodigo() {
		assertEquals(codigo, video.getCodigo());
	}

	@Test (expected = Exception.class)
	public void testSetCodigo() throws Exception {
		video.setCodigo("c1234"); // Lanzará excepción, debe tener length == 11
		assertEquals("c1234", video.getCodigo());
	}

	@Test
	public void testGetReproducciones() {
		assertEquals(0, video.getReproducciones());
	}

	@Test (expected = Exception.class)
	public void testSetReproducciones() throws Exception {
		video.setReproducciones(8);
		assertEquals(8, video.getReproducciones());
		
		video.setReproducciones(-8); // Debe lanzar una excpecion esta linea, debe ser > 0
		assertEquals(-8, video.getReproducciones());
	}
	
	@Ignore
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetURL() {
		assertEquals(URL+codigo, video.getURL());
	}

}
