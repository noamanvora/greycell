package greycell;
import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class Xpath{

	@SuppressWarnings("resource")
	public static void main(String args[])   {
		
		
		try 
		{
		Scanner scan = new Scanner(System.in);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("C:\\Users\\Noaman\\eclipse-workspace\\greycell\\src\\greycell\\data.xml");
						
		System.out.println("Enter the Expression:");
		String expr = scan.nextLine();
		
		XPathExpression xpath = XPathFactory.newInstance().newXPath().compile(expr);
		Object eve = xpath.evaluate(doc, XPathConstants.NODESET);
					
		NodeList nodes = (NodeList) eve;
		
		for(int i=0; i<nodes.getLength();i++){
			Element element = (Element)nodes.item(i);
			System.out.println("<"+element.getNodeName()+">"+nodes.item(i).getTextContent()+"</"+element.getNodeName()+">");
		} 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
}
