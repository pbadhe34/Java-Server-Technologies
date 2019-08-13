/**
 * BankService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.server;

public interface BankService extends java.rmi.Remote {
    public com.server.User getUser(int id1) throws java.rmi.RemoteException;
    public boolean updateUser(com.server.User obj) throws java.rmi.RemoteException;
}
