package com.ipartek.formacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PruebaLecturaEscritura {

	
    
    
    
    private ArrayList<String> mensajes = new ArrayList<String>();
    
            
    public PruebaLecturaEscritura(){
    	
    	mensajes.add("Mensaje número 1");
    	mensajes.add("Mensaje número 2");
    	mensajes.add("Mensaje número 3");
    	mensajes.add("Mensaje número 4");
    	mensajes.add("Mensaje número 5");
        
    }
    
    public void guardarMensaje() {
    	try{
    		FileWriter almacen = new FileWriter("C://Users/Jon/Desktop/prueba.txt");
            BufferedWriter buff = new BufferedWriter(almacen); 
            
            for(String mensaje: mensajes) {
            	buff.write(mensaje+"\n");
            }
            
            buff.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void LeerMensaje(){
        try{
        	FileReader lector = new FileReader("C://Users/Jon/Desktop/prueba.txt");
            BufferedReader buffer = new BufferedReader(lector);
            boolean eof = false;
            while(!eof) {
            	String linea = buffer.readLine();
            	if(linea == null) {
            		eof= true;
            	}else {
            		System.out.println(linea);
            	}
            }
           buffer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    
    }
    
    public static void main(String[] args){
        PruebaLecturaEscritura prueba = new PruebaLecturaEscritura();
        prueba.guardarMensaje();
        prueba.LeerMensaje();
    
    }

}
