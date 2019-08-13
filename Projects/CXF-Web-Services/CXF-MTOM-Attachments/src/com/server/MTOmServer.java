 

package com.server;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.ws.Holder;
 

@WebService(serviceName = "MtomService",portName = "MtomPort",targetNamespace = "http://cxf.apache.org/", endpointInterface = "com.server.MTomPort")

public class MTOmServer implements MTomPort   {


    public void attachByteArray(Holder<String> name, Holder<byte[]> attachinfo) {
        System.out.println("Received ByteArray image from client");
        System.out.println("The image data size is " + attachinfo.value.length);        
        name.value = "Recd " + name.value;        
    }

    public void attachDataHandler(Holder<String> name, Holder<DataHandler> attachinfo) {
        try {
            System.out.println("Received image with mtom enabled from client");
            InputStream mtomIn = attachinfo.value.getInputStream();
            FileOutputStream fs = new FileOutputStream("Image.jpg");
            copy(mtomIn, fs);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            copy(mtomIn, out);
            System.out.println("The image data size is " + out.size());
            name.value = "MTomRecd " + name.value;
            mtomIn.close();
            attachinfo.value = new DataHandler(new ByteArrayDataSource(out.toByteArray(),
                                                                       attachinfo.value.getContentType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int copy(final InputStream input, final OutputStream output) throws IOException {
    	System.out.println("Copying the file contents..");
        final byte[] buffer = new byte[4096];
        int n = 0;
        n = input.read(buffer);
        int total = 0;
        while (-1 != n) {
            output.write(buffer, 0, n);
            total += n;
            n = input.read(buffer);
        }
        return total;
    }
    
    
}
