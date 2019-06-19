package com.ipartek.formacion;

import java.util.Comparator;

public class ComparadorCerdosDiamantes implements Comparator<Object> {

	
	
	@Override
	public int compare(Object a, Object b) {
		
		int anterior=0;
		int posterior=0;
		
		if(a instanceof Cerdo) {
			Cerdo c1 = (Cerdo) a;	
			anterior= c1.getValor();
			
		}else if(a instanceof Diamante) {
			Diamante d1 = (Diamante) a;
			anterior= d1.getValor();
		}
		
		if(b instanceof Cerdo) {
			Cerdo c2 = (Cerdo) b;
			posterior = c2.getValor();
		}
		else if(b instanceof Diamante) {
			Diamante d2 = (Diamante) b;
			posterior = d2.getValor();
		}
		return anterior - posterior;
	
	} // Cerdos y Diamantes/


	
}
