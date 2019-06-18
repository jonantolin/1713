package com.ipartek.formacion;


import java.util.Scanner;

public class AulaApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Aula aula = new Aula();
		aula.rellenarLista();
		
		int opcion = 0;
		
		do{
			System.out.println("\nIntroduzca la opci�n que quiera (introduzca n�mero): "
					+ "\n1 - Listar alumnos"
					+ "\n2 - Crear alumno"
					+ "\n3 - Eliminar alumno"
					+ "\n4 - Buscar Alumno Afortunado para leer"
					+ "\n0- Salir"
					+ "\nIntroduzca numero: ");
			opcion = sc.nextInt();
			switch(opcion) {
			
				case 1:
					aula.listado();
					break;
				case 2: 
					System.out.println("\nIntroduzca nombre del nuevo alumno: ");
					String nom =""; 
					Scanner sc3 = new Scanner(System.in);
					nom = (String)sc3.nextLine();
					aula.nuevoAlumno(nom);
					System.out.println("Introducido con �xito\n");
					break;
				case 3:
					System.out.println("\nIntroduzca nombre que desea ELIMINAR");
					
					Scanner sc2 = new Scanner(System.in);
					String nombre = sc2.nextLine(); 
					//nombre = sc2.next();
					
					aula.eliminarAlumno(nombre);
					break;
				case 4:
					System.out.println(aula.afortunado());
					break;
				case 0: 
					System.out.println("Hasta pronto");
					break;
				default:
					System.out.println("Introduce una opci�n metiendo un n�mero del 1 al 4 o 0 para salir");
			}		
		}while(opcion != 0);
		
		sc.close();
	}

}
