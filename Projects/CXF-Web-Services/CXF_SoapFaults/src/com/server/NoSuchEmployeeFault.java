 

package com.server;

import java.rmi.RemoteException;

 
public class NoSuchEmployeeFault extends Exception  implements java.io.Serializable 
{
    private String info;

    public NoSuchEmployeeFault() 
	{
    }

    public NoSuchEmployeeFault(String info)
	{
    	   super(info);
           this.info = info;
           
            
    }

    public  String getInfo() 
	{
        return info;
    }

    public void setInfo(java.lang.String info)
	{
        this.info = info;
    }
}
