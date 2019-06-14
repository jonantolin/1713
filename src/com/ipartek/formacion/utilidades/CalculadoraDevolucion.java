package com.ipartek.formacion.utilidades;

public class CalculadoraDevolucion {

	// Devolver las vueltas óptimas de una compra

	public static final float[] BILLETES_MONEDAS = {
			// billetes
			500, 200, 100, 50, 20, 10, 5,
			// monnedas
			2, 1, 0.50f, 0.20f, 0.10f, 0.05f, 0.02f, 0.01f

	};

	/**
	 * Calcula las vueltas óptimas para retornar el menor número de billetes y
	 * monedas
	 * 
	 * @param importe   float lo que cuesta el producto
	 * @param entregado float lo que entrega el cliente
	 * @return int[] cantidad de billetes y monedas retornadas
	 * @see public static final float[] BILLETES_MONEDAS
	 * @throws Exception si el importe es mayor que lo entregado o si importe < 0 o
	 *                   entregado < 0
	 * 
	 */
	public static int[] vueltas(float importe, float entregado) throws Exception {

		// pj: cuesta 200, se entrega 1 billete de 500
		/*
		 * if(importe > entregado || importe < 0 || entregado < 0) { throw new
		 * Exception("Valores introducidos incorrectos"); }
		 */
		
		if (importe > entregado) {
			throw new Exception("Entregado menos dinero que el coste del producto");
		}
		if (importe < 0) {
			throw new Exception("El valor del producto no puede ser menor que 0");
		}
		if (entregado < 0) {
			throw new Exception("El valor del dinero entregado por el cliente no puede ser menor que 0");
		}
		
		
		float dineroRestante = 0;
		int[] billetesDevueltos = new int[BILLETES_MONEDAS.length];
		int billeteAux = 0;

		dineroRestante = entregado - importe;

		int contador = 0;
		while (dineroRestante > 0) {
			
			billeteAux = (int) (dineroRestante / BILLETES_MONEDAS[contador]);
			if (billeteAux != 0) {
				dineroRestante = dineroRestante - (billeteAux * BILLETES_MONEDAS[contador]);
				// otra manera: dineroRestante = dineroRestante % BILLERES_MONEDAS[contador];
				// Redondeo porque la operacion pierde decimales por una extrañeza de Java
				dineroRestante = Math.round(dineroRestante * 100.0f) / 100.0f;
				billetesDevueltos[contador] = billeteAux;
			} else {
				billetesDevueltos[contador] = 0;
			}
			contador++;
		}
		;

		return billetesDevueltos;
	}
}
