package com.ipartek.formacion.utilidades;

public class OrdenarArray {
	
	/**
	 * 
	 * @param arrayDesordenado int [] un array de enteros previsiblemente desordenado
	 * @return int [] devuelve el array ordenado
	 * @throws Excepcion si arrayDesordenado es null
	 */

	public static int[] ordenar(int[] arrayDesordenado){

		int aux = 0;

		for (int i = 0; i < arrayDesordenado.length; i++) {
			for (int j = 0; j < arrayDesordenado.length - i - 1; j++) {
				if (arrayDesordenado[j] > arrayDesordenado[j + 1]) {
					aux = arrayDesordenado[j + 1];
					arrayDesordenado[j + 1] = arrayDesordenado[j];
					arrayDesordenado[j] = aux;
				}
			}
		}

		return arrayDesordenado;
	}

	/*
	 * public static void main(String[] args) { OrdenarArray prueba = new
	 * OrdenarArray(); int [] arrayPrueba = {2, 4, 1, 9, 34,7, 1, 2, 1, 1}; int []
	 * arrayOrdenado = prueba.ordenar(arrayPrueba);
	 * 
	 * for (int i = 0; i < arrayOrdenado.length; i++) {
	 * System.out.println(arrayOrdenado[i] + " "); }
	 * 
	 * }
	 */
}
