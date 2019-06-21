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

public class DAOAlumnoArrayListOLD implements IPersistible<Alumno>{

	// No implemento IPersistible<P> sino directamente <Alumno> porque se que es
	// para Alumnos
	// A esto se le llama "interferir" -> pj: Se le interfiere con Alumno
	
		
		private static DAOAlumnoArrayListOLD INSTANCE;
		private ArrayList<Alumno> lista;
	   
	    
	    
	    
	    /**
	     * Encargado de devolver solo un objeto, patron Singleton
	     * La palabra reservada synchronized hace que si se le llama al mismo tiempo, cree uno y al terminar, 
	     * cree el otro y así sucesivamente
	     * @return
	     */  
	    public static synchronized DAOAlumnoArrayListOLD getInstance(){
	    	
	    	if(INSTANCE == null) {
	    		INSTANCE = new DAOAlumnoArrayListOLD();
	    	}
	    	return INSTANCE;
	    }
	    
	    
	    /**
	     * Privado para que nadie pueda crear objetos
	     */
		private DAOAlumnoArrayListOLD() {
			super();
			this.lista = new ArrayList<Alumno>();
		}
		
		public DAOAlumnoArrayListOLD(ArrayList<Alumno> lista) {
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
	    		
	    	/*TODO Hacer que pueda usar los datos guardados, con Serialize o guardando
		       los datos por comas (pj: Jon; 2 ) */
	    	
	        try{
	        	
	        	String linea="";
	        	File almacen= new File("C:\\1713\\eclipse-workspace\\RankingAlumnos.txt");
	        	FileOutputStream fos = new FileOutputStream(almacen);
	            BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos));
	            int cont=0;
	            
	            for (Iterator<Alumno> iterator = lista.iterator(); iterator.hasNext();) {
	            	
					Alumno alumno = (Alumno) iterator.next();
					cont++;	
					boolean terminado = false;
					if(alumno == null && !terminado) {
			            terminado = true;
			            
			            //TODO revisar ultimo registro que no sea nulo como pasa
					}else {
						linea = cont+"º - "+alumno.getNombre() + " -------- Elegido: " + alumno.getNumVecesElegido() + " veces";
			            buffer.write(linea);
			            buffer.newLine();
					}
	   
	            } 
	            
	            buffer.close();
	            
	        }catch(IOException ex){
	            ex.printStackTrace();
	        }
	        

	    }
	    
	    public void LeerMensaje(){
	    	
	    	/*TODO Hacer que pueda usar los datos guardados, con Serialize o guardando
	    	       los datos por comas (pj: Jon; 2 ) */
	    	
	        try{
	        	FileReader lector;
	            lector = new FileReader("C:\\\\1713\\\\eclipse-workspace\\\\RankingAlumnos.txt");
	            BufferedReader buffer = new BufferedReader(lector);
	            boolean eol = false;
	            
	            while(!eol) {
	            String linea = buffer.readLine();
	            
		            if(linea == null) {
		            	buffer.close();
		            	eol = true;
		            }else {
		            	System.out.println(linea);
		            }
	            }
	            
	        }catch(IOException ex){
	            ex.printStackTrace();
	        }
	        
	    }
		@Override
		public boolean delete(int id) {
			// TODO implementar borrar por id
			return false;
		}
	
}
