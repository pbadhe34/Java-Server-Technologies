 

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.MTomPort;
import org.apache.cxf.MtomService;



 
public final class MTomPortClient {

    private static final QName SERVICE_NAME = new QName("http://cxf.apache.org/", "MtomService");

    private MTomPortClient() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = MtomService.WSDL_LOCATION;
         
      
        MtomService ss = new MtomService(wsdlURL, SERVICE_NAME);
        MTomPort port = ss.getMtomPort();  
        Binding binding = ((BindingProvider)port).getBinding();
        ((SOAPBinding)binding).setMTOMEnabled(true);
        
        URL fileURL = MTomPortClient.class.getResource("/user.txt");
        
        
        System.out.println("Invoking attachByteArray...");        
       
        File aFile = new File(new URI(fileURL.toString()));
        long fileSize = aFile.length();
        System.out.println("Filesize of  image is: " + fileSize);

        System.out.println("\nStarting MTOM Test using basic byte array:");
        Holder<String> name = new Holder<String>("WaterFall Image");
        Holder<byte[]> param = new Holder<byte[]>();
        param.value = new byte[(int) fileSize];
        InputStream in = fileURL.openStream();
        int len = in.read(param.value);
        while (len < fileSize) 
        {
            len += in.read(param.value, len, (int)(fileSize - len));
        }
        System.out.println("--Sending the image to server");
        System.out.println("--Sending a name value of " + name.value);

        port.attachByteArray(name, param);


        System.out.println("attachByteArray._attachByteArray_arg0=" + name.value);
        System.out.println("attachByteArray._attachByteArray_arg1=" + param.value);
        
        System.out.println("--Received byte[] back from server, returned size is "
                + param.value.length);
            System.out.println("--Returned string value is " + name.value);
        System.out.println("attavchByetararay is over..");
      
        
         
        System.out.println("Invoking attachDataHandler...");           

        
               

        Image image = ImageIO.read(new ByteArrayInputStream(param.value));
        System.out.println("--Loaded image from byte[] successfully, hashCode="
            + image.hashCode());
         

        System.out.println("\nStarting MTOM test with DataHandler:");
        name.value = "Vinu";
        
        Holder<DataHandler> handler = new Holder<DataHandler>();

        handler.value = new DataHandler(fileURL);

         
        //port.attachDataHandler(name, handler);
        
        
        System.out.println("Attachment over..");

        InputStream mtomIn = handler.value.getInputStream();
        fileSize = 0;
        for (int i = mtomIn.read(); i != -1; i = mtomIn.read()) {
            fileSize++;
        }

        System.out.println("--Received DataHandler back from server, "
            + "returned size is " + fileSize);
        System.out.println("--Returned string value is " + name.value);
        
        System.exit(0);
    }


    }

 
