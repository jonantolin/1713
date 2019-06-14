package com.ipartek.formacion;

public class PruebaEmpleado2 {

	public static void main(String[] args) throws PersonException {
		Employee empleado1 = new Employee();
		
		System.out.println(empleado1);
		
		Employee empleado2 = new Employee("Jon", 32, 'H', 2800);
		
		
		System.out.println(empleado2);
	}

}
