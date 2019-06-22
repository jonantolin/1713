package com.ipartek.formacion;

import java.util.Date;

public class Employee extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final float SALARIO_MINIMO = 937.05f;
	
	private int numEmpleado;
	private Date fechaContrato;
	private float salario;
	
	
	
	public Employee() {
		super();
		this.numEmpleado = 0;
		this.fechaContrato = new Date();
		this.salario = SALARIO_MINIMO;
	}
	
	public Employee(String nombre, int edad, char sexo, float salario) throws PersonException {
		
		this();
		super.setNombre(nombre);

			super.setEdad(edad);
	
		super.setSexo(sexo);
		this.salario = salario;
	}
	//Construir constructor pero con nombre, edad, sexo y saario definidos en este
	
	// Crear varios objetos de tipo Employee 
	
	public int getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	
	@Override
	public String toString() {
		return "N�mero de empleado=" + numEmpleado + ", fecha de contrato=" + fechaContrato + ", Salario=" + salario
				+ ", Nombre =" + getNombre() + ", Edad=" + getEdad() + ", Altura=" + getAltura()
				+ ", Peso=" + getPeso() + ", Color de ojos=" + getColorOjos() + ", Sexo=" + getSexo() + "]";
	}
	
	// OTRA MANERA DE HACER EL TOSTRING CON EL TOSTRING DE LA SUPERCLASE
	/*
	@Override
	public String toString() {
		return super.toString() + "Employee [numEmpleado=" + numEmpleado + ", fechaContrato=" + fechaContrato + ", salario=" + salario
				+ "]";
	}
	*/


	}

