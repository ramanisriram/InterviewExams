package commbank;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class LogParser {
	public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
		List<Integer> intListId = new ArrayList<Integer>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xml));
			Document doc = builder.parse(is);
			NodeList folderNodes = doc.getElementsByTagName("entry");
			for (int i = 0; i < folderNodes.getLength(); i++) {
				Node ab = folderNodes.item(i);
				NodeList childNodes = ab.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeName().equals("message")) {
						if (childNodes.item(j).getTextContent().equals(message)) {
							NamedNodeMap attrs = ab.getAttributes();
							intListId.add(Integer.parseInt(attrs.getNamedItem("id").getNodeValue()));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return intListId;
	}

	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<log>\n" + "    <entry id=\"1\">\n"
				+ "        <message>Application started</message>\n" + "    </entry>\n" + "    <entry id=\"2\">\n"
				+ "        <message>Application ended</message>\n" + "    </entry>\n" + "</log>";

		Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
		for (int id : ids)
			System.out.println(id);
	}
}