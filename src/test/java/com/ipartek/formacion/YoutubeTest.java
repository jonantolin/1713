package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class YoutubeTest {

	Youtube video;

	/*
	 * private static final int LONGITUD_CODIGO = 11; private static final int
	 * LONGITUD_MIN_TITULO = 2; private static final int LONGITUD_MAX_TITULO = 150;
	 */
	private static final String URL = "https://www.youtube.com/watch?v=";
	private final String TITULO = "Rammstein";
	private final String CODIGO = "12345678901"; // exactamente 11
	// private int reproducciones; // >= 0

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		video = new Youtube(TITULO, CODIGO);
	}

	@After
	public void tearDown() throws Exception {
		video = null; // Así se pondrá null despues de cada Test individual
	}

	@Test
	public void testYoutube() throws Exception {
		// Youtube video2 = new Youtube(); //El constructor aun no está definido
		video = new Youtube(TITULO, CODIGO);

		try {
			video = new Youtube(null, null); // Debe saltar la excepción en este punto
			fail("Constructor con nulos"); // Si se ejecuta esta linea, la prueba dirá que lo hemos hecho mal
		} catch (Exception e) {
			assertTrue(true);
		}


		try {
			video = new Youtube(null, CODIGO); // Debe saltar la excepción en este punto
			fail("Titulo nulo"); // Si se ejecuta esta linea, la prueba dirá que lo hemos hecho mal
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			video = new Youtube(TITULO, null); // Debe saltar la excepción en este punto
			fail("Código nulo"); // Si se ejecuta esta linea, la prueba dirá que lo hemos hecho mal
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testGetTitulo() {
		assertEquals(TITULO, video.getTitulo());
	}

	@Test(expected = Exception.class)
	public void testSetTitulo() throws Exception {
		video.setTitulo("Concierto");
		assertEquals("Concierto", video.getTitulo());

		video.setTitulo("a"); // Debe lanzar la excepción, porque tiene que tener length >= 2
		assertEquals("Rammstein", video.getTitulo());
	}

	@Test
	public void testGetCodigo() {
		assertEquals(CODIGO, video.getCodigo());
	}

	@Test(expected = Exception.class)
	public void testSetCodigo() throws Exception {
		video.setCodigo("c1234"); // Lanzará excepción, debe tener length == 11
		assertEquals("c1234", video.getCodigo());
	}

	@Test
	public void testGetReproducciones() {
		assertEquals(0, video.getReproducciones());
	}

	@Test(expected = Exception.class)
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
		assertEquals(URL + CODIGO, video.getURL());
	}

}
