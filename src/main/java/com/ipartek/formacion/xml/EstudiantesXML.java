package com.ipartek.formacion.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

/**
 * Ejercicio para aprender a parsear y trabajar con XML
 * 
 * @see https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
 * 
 * @author Curso
 *
 */
public class EstudiantesXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		
		//Similar a String pero preparado para trabajar con String grandes o ficheros de texto
		StringBuilder xmlStringBuilder = new StringBuilder();
		xmlStringBuilder.append("<?xml version=\"1.0\"?> <perro><nombre>Rataplan</nombre><raza>cruce </raza> </perro>");
		ByteArrayInputStream input = new ByteArrayInputStream(
		   xmlStringBuilder.toString().getBytes("UTF-8"));
		Document doc = builder.parse(input);
		
		Element elementPerro = doc.getDocumentElement();
		NodeList nodes = elementPerro.getChildNodes();
		
		String nombre = nodes.item(0).getTextContent();
		String raza = nodes.item(1).getTextContent();
		
		String contenidoTextoCompleto =  elementPerro.getTextContent();
		
		
		
		System.out.println("Nombre: " + nombre + " \nRaza: "+raza);
		
		System.out.println("A ver que sacamos del perro "+contenidoTextoCompleto);

	}

}
