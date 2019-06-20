package com.ipartek.formacion.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.Alumno;

//No implemento IPersistible<P> sino directamente <Alumno> porque se que es para Alumnos
// A esto se le llama "interferir" -> pj: Se le interfiere con Alumno
public class DAOAlumnoArrayList implements IPersistible<Alumno> {

	private ArrayList<Alumno> lista;
    private String mensaje;
    
    private FileReader lector;
    

	public DAOAlumnoArrayList() {
		super();
		this.lista = new ArrayList<Alumno>();
	}
	
	public DAOAlumnoArrayList(ArrayList<Alumno> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public List<Alumno> getAll() {
		return lista;
	}

	@Override
	public Alumno getById(int id) {
		Alumno resul = null;

		for (Alumno a : lista) {
			if (a.getId() == id) {
				resul = a;
				break; // Si lo encuentra no sigue iterando
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Alumno pojo) {
		lista.add(pojo);

		// System.out.println("Añadido");
		return true;
	}


	public boolean delete(String nombre) {

		boolean borrado = false;
		
		for (Iterator<Alumno> iterator = lista.iterator(); iterator.hasNext();) {
			
			Alumno alum = (Alumno) iterator.next();
			
			if(alum.getNombre().equals(nombre)) {
				
				iterator.remove();
				borrado = true;
			}
			
		}

		return borrado;
	}

	@Override
	public boolean update(Alumno pojo) {

		// TODO encontrar en la lista por pojo.getId, al encontrarlo setNombre
		// O con setNombr

		// System.out.println("Añadido");
		return true;
	}
	
	public boolean update(String nombreViejo, String nombreNuevo) {
		
		for (Iterator<Alumno> iterator = lista.iterator(); iterator.hasNext();) {
			
			Alumno alum = (Alumno) iterator.next();
			
			if(alum.getNombre().equals(nombreViejo)) {
				
				//iterator.remove();
				alum.setNombre(nombreNuevo);
			}
			
		}
		
		return true;
	}
    public void guardar_mensaje(ArrayList<Alumno> lista) throws IOException{
    		
        try{
        	
        	String linea="";
        	File almacen= new File("C:\\Users\\Jon\\Desktop\\RankingAlumnos.txt");
        	FileOutputStream fos = new FileOutputStream(almacen);
            BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos));
            int cont=0;
            
            for (Iterator<Alumno> iterator = lista.iterator(); iterator.hasNext();) {
            	
				Alumno alumno = (Alumno) iterator.next();
				cont++;	
				if(alumno != null) {
		            linea = cont+"º - "+alumno.getNombre() + " -------- Elegido: " + alumno.getNumVecesElegido() + " veces";
		            buffer.write(linea);
		            buffer.newLine();
		            
		            //TODO revisar ultimo registro que no sea nulo como pasa
				}
   
            } 
            
            buffer.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        

    }
    
    public void LeerMensaje(){
    	
        try{
        	
            lector = new FileReader("C://Users/Jon/Desktop/RankingAlumnos.txt");
            BufferedReader buffer = new BufferedReader(lector);
            boolean eol = false;
            
            while(!eol) {
            String linea = buffer.readLine();
            
	            if(linea == null) {
	            	eol = true;
	            }else {
	            	System.out.println(linea);
	            }
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("El mensaje es: "+mensaje);
    
    }
	@Override
	public boolean delete(int id) {
		// TODO implementar borrar por id
		return false;
	}

}
