package com.ipartek.formacion;

public class Person{

	// atributos
	private int id; // Lo usare para una BBDD, primary key
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String nombre;
	private int edad;
	private float altura; // 1.70 m
	private float peso;
	private String colorOjos;
	private char sexo; // 'H' ó 'M' ó 'I'
	
	/*
	 *  Creamos un constructor donde la persona por defecto va a tener nombre "anonimo",
	 *   la edad 18, altura 0, peso 0, colorOjos marrones, sexo indefinido
	 *   Nombre, edad, sexo
	 *   Queremos sobrecargar el constructor para poder crear una persona
	 *    induicabdo el nombre, la edad y el sexo
	 * */
	
	public Person() {
		this.id = -1; //Esto indicara despues que no se ha recuperado de la base de datos
		this.nombre = "Anónimo";
		this.edad = 18;
		this.altura = 0;
		this.peso = 0;
		this.colorOjos = "Marrones";
		this.sexo = 'I';
		
	}
	
	public Person(String nombre, int edad, char sexo) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public void setNombre(String nombre) {
		if(nombre == null) {
			this.nombre = "Sin nombre";
		}else {
			this.nombre = nombre;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonException {
		if(edad < 0) {
			throw new PersonException(PersonException.ERROR_EDAD);
		}else {
			this.edad = edad;
		}
		
		
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	

	@Override
	public String toString() {
		return "Person [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", peso=" + peso
				+ ", colorOjos=" + colorOjos + ", sexo=" + sexo + "]";
	}

	public String saludar() {
		
		
		return "Hola, me llamo "+nombre;
	}

	

}
