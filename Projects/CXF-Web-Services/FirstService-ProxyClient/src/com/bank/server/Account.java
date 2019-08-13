package com.bank.server;
/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */


public interface Account extends java.rmi.Remote {
    public int readAccountBalance(java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String getAccountName(int acNo) throws java.rmi.RemoteException;
}
