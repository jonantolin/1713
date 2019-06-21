import com.ipartek.formacion.Perro;
import com.ipartek.formacion.PerroPresa;
import com.ipartek.formacion.Person;

public class HelloWorld {

	
	
	public static void main(String[] args) throws Exception {
		
	/*	String nombre = "Ander";
		
		System.out.println("Hola "+nombre); */
		
		Person persona1 = new Person();
		persona1.setNombre("Jon");
		System.out.println(persona1.saludar());
		
		Perro perro1 = new Perro();
		perro1.setNombre("Lia");
		perro1.setEdad(-5);
		perro1.setRaza("Mestiza");
		perro1.setVacunado(true);
		
		Perro perro2 = new Perro();
		
		Perro perro3 = new Perro("Vito", 4, "Pastor alemán", true);
		
		System.out.println(perro1.toString());
		System.out.println(perro2.toString());
		System.out.println(perro3.toString());
		
		PerroPresa perro4 = new PerroPresa();
		System.out.println(perro4.toString());
		perro4.atacar();
		

	}

}
