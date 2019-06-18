package com.ipartek.formacion;


import java.util.Scanner;

/**
 * 
 * @author Jon
 *
 * Usa clase Aula 
 * Un menu con 4 posibilidades (Listar, Crear, Eliminar, Elegir alumno aleatorio que lee) 
 */
public class AulaApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Aula aula = new Aula();
		aula.rellenarLista();
		
		String opcion ="0";
		
		do{
			
			System.out.println("\nIntroduzca la opción que quiera (introduzca número): "
					+ "\n1 - Listar alumnos"
					+ "\n2 - Crear alumno"
					+ "\n3 - Eliminar alumno"
					+ "\n4 - Buscar Alumno Afortunado para leer"
					+ "\n0- Salir"
					+ "\nIntroduzca numero: ");
				
				
			opcion = sc.next();
				
			switch(opcion) {
			
				case "1":
					aula.listado();
					break;
					
				case "2": 
					System.out.println("\nIntroduzca nombre del nuevo alumno: ");
					String nom =""; 
					//Scanner sc3 = new Scanner(System.in);
					sc = new Scanner(System.in);
					nom = (String)sc.nextLine();
					aula.nuevoAlumno(nom);
					System.out.println("Introducido con éxito\n");
					break;
					
				case "3":
					System.out.println("\nIntroduzca nombre que desea ELIMINAR");
					
					 sc = new Scanner(System.in);
					String nombre = (String)sc.nextLine(); 
					//nombre = sc2.next();
					
					aula.eliminarAlumno(nombre);
					break;
					
				case "4":
					System.out.println(aula.afortunado());
					break;
					
				case "0": 
					System.out.println("Hasta pronto");
					break;
					
				default:
					System.out.println("Introduce una opción metiendo un número del 1 al 4 o 0 para salir");
			}
			
			
			
		}while(!opcion.equals("0"));
		
		sc.close();
	}

}
