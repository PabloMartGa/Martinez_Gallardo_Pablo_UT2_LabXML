/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.martinez_gallardo_pablo_ut2_labxml;

import java.io.File;
import java.lang.classfile.Attributes;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author DAM2P
 */
public class Martinez_Gallardo_Pablo_UT2_LabXML {

    public static void main(String[] args) {
        try {
            //las tres primeras líneas cargan el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("imperio.xml"));
            
            //se normaliza y se obtiene el elemento raíz
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
            
            //se cogen las nodos "nave"
            NodeList listaNaves = doc.getElementsByTagName("nave");
            for(int i=0; i<listaNaves.getLength(); i++){
                Node nodo = listaNaves.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element elemento = (Element) nodo;
                    
                    String id = elemento.getAttribute("id");  //atributo de la etiqueta nave
                    
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent(); //texto de la etiqueta hijo de nave
                    String piloto = elemento.getElementsByTagName("piloto").item(0).getTextContent(); //texto de la etiqueta hijo de nave
                    
                    System.out.println("ID: " + id + "\nNombre: " + nombre + "\nPiloto: " + piloto + "\n");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al parsear el DOM: " + e.getMessage());
        }
        
        
        //=========================================================================================================================================//
        
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            
            DefaultHandler manejador = new DefaultHandler(){
                private boolean esNombre = false;
                
                //este evento encuentra una etiqueta de apertura
                @Override
                public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)throws SAXException{
                    if(qName.equalsIgnoreCase("nave")){
                        String clase = attributes.getValue("clase");
                        System.out.println("Clase nave: " + clase);
                        
                    }else if(qName.equalsIgnoreCase("nombre")){
                        esNombre = true;
                    }
                }
                
                
                //este evento procesa el texto plano dentro de una etiqueta
                @Override
                public void characters(char[] ch, int start, int length)throws SAXException{
                    if(esNombre){
                        System.out.println("Nombre: " + new String(ch, start, length) + "\n");
                        esNombre = false;
                    }
                }
                
            };
            
            
            //se lanza el análisis secuencial del XML
            parser.parse(new File("imperio.xml"), manejador);
            
        } catch (Exception e) {
            System.out.println("Error al parsear con SAX: " + e.getMessage()    );
        }
        
        
        //========================================================================================================================================//

        
        
        
    }
}
