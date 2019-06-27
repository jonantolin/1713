package com.ipartek.formacion.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ipartek.formacion.Perro;

public class LeerPerrosFromXML {

	//  Leer XML de listado de perros, guardar en ArrayList
	// y mostrar por pantalla
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		
		
		// leer fichero
		
		ClassLoader classLoader = new LeerPerrosFromXML().getClass().getClassLoader();
		File file = new File(classLoader.getResource("perros.xml").getFile());
		
		//crear builder
		
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(file);
				
				Element raiz = doc.getDocumentElement();
				NodeList nodes = raiz.getChildNodes();
		
		//parsear perros.xml
		// StringBuilder xmlStringBuilder = new StringBuilder();
		//File perroXML = new File("C:\\1713\\eclipse-workspace\\1713\\src\\main\\java\\com\\ipartek\\formacion\\xml\\perros.xml");
//		xmlStringBuilder.append("<?xml version=\"1.0\"?> <perro><nombre>Rataplan</nombre><raza>cruce </raza> </perro>");
//		ByteArrayInputStream input = new ByteArrayInputStream(
//		   xmlStringBuilder.toString().getBytes("UTF-8"));
		
		
		//recorrer Document y rellenar ArrayList
		
		ArrayList <Perro> listaPerros = new ArrayList <Perro>();
		
		
		Node node;
		Element elemento;
		
		
		for (int i = 0; i < nodes.getLength(); i++) {
			
			node = (Node) nodes.item(i);
			elemento =  (Element) nodes;
			
			
			//NodeList atribPerros = elemento.getChildNodes();
			
			String nombre = elemento.getElementsByTagName("nombre").toString();
			int edad = Integer.parseInt(elemento.getElementsByTagName("edad").toString());
			String raza = elemento.getElementsByTagName("raza").toString();
			boolean vacunado = false;
			String vacunadoString = elemento.getElementsByTagName("nombre").toString();
			
			if(vacunadoString.equals("true")) {
				vacunado = true;
			}
			
			listaPerros.add(new Perro(nombre, edad, raza, vacunado));
		}
		
		
		//Mostrar por pantalla
		
		for(Perro perro : listaPerros) {
			System.out.println(perro);
		}

	}

}
