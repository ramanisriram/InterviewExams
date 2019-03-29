package testdome;

import java.awt.List;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    	ArrayList nameListObj = new ArrayList();
    	try {
    		
    	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	  DocumentBuilder builder = factory.newDocumentBuilder();
    	  InputSource is = new InputSource(new StringReader(xml));
    	  Document doc = builder.parse(is);
    	  NodeList folderNodes = doc.getElementsByTagName("folder");
    	  for(int i=0; i<folderNodes.getLength(); i++) {
    		  Node ab = folderNodes.item(i);
    		  NamedNodeMap attrs = ab.getAttributes();
    		  if(attrs.getNamedItem("name").getNodeValue().toString().startsWith("u") || attrs.getNamedItem("name").getNodeValue().toString().startsWith("U")) {
    			  nameListObj.add(attrs.getNamedItem("name").getNodeValue().toString());
    		  }
    	  }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	  return nameListObj;
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"uc\">" +
                    "<folder name=\"uprogram files\">" +
                        "<folder name=\"Uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}