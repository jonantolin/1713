package com.ipartek.formacion.exccepciones;

import com.ipartek.formacion.Perro;
import com.ipartek.formacion.PerroException;

/**
 *  Se pueden capturar m�s d eun tipo de excepciones
 *  Siempre la �ltima en capturar que sea Exception que es la mas gen�rica
 * @author Curso
 *
 */

public class CapturarTiposExcepciones {

	public static void main(String[] args) {
		
		try {
			
			//Perro p = null;
			Perro p = new Perro();
			p.setEdad(4);
			p.toString();
			System.out.println(p);
			
			int [] numerosLista = new int [5];
			numerosLista[8] = 10;
			
			System.out.println("Ha llegado hasta aqui");
			
		}catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Es una posicion incorrecta para el array");
			
		}catch(PerroException e) {	
			System.out.println("Perro Exception");
			
		}catch(NullPointerException e) {
			System.out.println("Excepci�n null");
			
		}catch(Exception e) {
			System.out.println("Excepci�n Gen�rica, siempre la �ltima");
			e.printStackTrace();
		}
		
	}
	
	
}
