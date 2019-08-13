package com.server;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.ws.Holder;

@WebService(name = "MTomPort", targetNamespace = "http://cxf.apache.org/")
public interface MTomPort {

	public void attachByteArray(Holder<String> name, Holder<byte[]> attachinfo);

	public void attachDataHandler(Holder<String> name,Holder<DataHandler> attach);

}