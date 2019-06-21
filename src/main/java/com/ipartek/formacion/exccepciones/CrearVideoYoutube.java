package com.ipartek.formacion.exccepciones;

import java.util.Scanner;

import com.ipartek.formacion.Youtube;

public class CrearVideoYoutube {

	public static void main(String[] args) {
		
		boolean repetir = true;
		Youtube video = null;
		
		System.out.println("------- Crear VIDEO YOUTUBE --------");
		System.out.println("------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		
		do {
		
		System.out.println("Titulo del video, recuerda longitud [2, 150]");
		String titulo = sc.nextLine();
		
		System.out.println("Codigo del video, recuerda longitud [11]");
		String codigo = sc.nextLine();
		
		try {
			video = new Youtube(titulo, codigo);
			repetir = false;
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		}while(repetir);
		System.out.println("Video Creado Correctamente");
		System.out.println(video);
		
		sc.close();
	}

}
