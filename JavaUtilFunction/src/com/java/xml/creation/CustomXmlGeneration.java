package com.java.xml.creation;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
 class Customer {

	String name;
	int age;
	int id;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

}


/*public class CustomXmlGeneration {

	public static void main(String[] args) {
		try {

		    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		    Document doc = docBuilder.newDocument();
		    Element rootElement = doc.createElement("CONFIGURATION");
		    doc.appendChild(rootElement);
		    Element browser = doc.createElement("BROWSER");
		    browser.appendChild(doc.createTextNode("chrome"));
		    rootElement.appendChild(browser);
		    Element base = doc.createElement("BASE");
		    base.appendChild(doc.createTextNode("http:fut"));
		    rootElement.appendChild(base);
		    Element employee = doc.createElement("EMPLOYEE");
		    rootElement.appendChild(employee);
		    Element empName = doc.createElement("EMP_NAME");
		    empName.appendChild(doc.createTextNode("Anhorn, Irene"));
		    employee.appendChild(empName);
		    Element actDate = doc.createElement("ACT_DATE");
		    actDate.appendChild(doc.createTextNode("20131201"));
		    employee.appendChild(actDate);
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    String s =  new String();
		    
		    DOMSource source = new DOMSource(doc);
		    //StreamResult result = new StreamResult(new File("C:\\Bishwa\\ScoreDetail.xml"));
		    StreamResult result = new StreamResult(s);

		    transformer.transform(source, result);
		    System.out.println("File saved!");
		  } catch (ParserConfigurationException pce) {
		    pce.printStackTrace();
		  } catch (TransformerException tfe) {
		    tfe.printStackTrace();}

	try

	{

		File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(customer, file);
		jaxbMarshaller.marshal(customer, System.out);

	}catch(
	JAXBException e)
	{
		e.printStackTrace();
	}

}
*/