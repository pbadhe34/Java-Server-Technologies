
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.test.classes.Address;
import com.test.classes.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import javax.xml.stream.XMLStreamWriter;



public class XmlMarshaller {

	 
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance("com.test.classes");//load the context for package
        
        // create an Java Employee object composite structure
		Employee emp = new Employee();
		com.test.classes.Location myLocation = new com.test.classes.Location();
		Address myAddress = new Address();
		
		myLocation.setDirection(6);		
		myLocation.setRoadName("M. G. Road");
		
		myAddress.setArea(myLocation);
		myAddress.setCityName("Pune");
		myAddress.setHouserNuumber(876);
		
		emp.setAddress(myAddress);
		emp.setBirth_Date(new Date());
		emp.setId(11);
		emp.setName("Vijay Malusare");
		
		 // create a Marshaller and marshal to System.out
        Marshaller m = jc.createMarshaller();
        m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
        
        m.marshal(emp, System.out);
        m.marshal(emp,  new FileOutputStream(new File("emp2.xml")));	
		


	}

}
