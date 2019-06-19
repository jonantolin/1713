package com.ipartek.formacion;

import java.util.ArrayList;

import org.junit.Test;

public class CerdosYDiamantes implements ComparadorCerdosDiamantes {

	
	@Test
	public void test() {

		ArrayList lista = new ArrayList();
		Cerdo c = new Cerdo();
		Diamante d = new Diamante();
		
		lista.add(c);
		lista.add(d);
		
	}

	@Override
	public int comparar(Object a, Object b) {
	//	if(a instanceof Cerdo) {
	//		Cerdo a = (Cerdo) a;
	//	}
		return 0;
	}

}
