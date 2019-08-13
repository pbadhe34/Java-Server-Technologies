package com.bank.server;

public class AccountProxy implements com.bank.server.Account {
  private String _endpoint = null;
  private com.bank.server.Account account = null;
  
  public AccountProxy() {
    _initAccountProxy();
  }
  
  public AccountProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountProxy();
  }
  
  private void _initAccountProxy() {
    try {
      account = (new com.bank.server.AccountServiceLocator()).getAccount();
      if (account != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)account)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)account)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (account != null)
      ((javax.xml.rpc.Stub)account)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bank.server.Account getAccount() {
    if (account == null)
      _initAccountProxy();
    return account;
  }
  
  public int readAccountBalance(java.lang.String name) throws java.rmi.RemoteException{
    if (account == null)
      _initAccountProxy();
    return account.readAccountBalance(name);
  }
  
  public java.lang.String getAccountName(int acNo) throws java.rmi.RemoteException{
    if (account == null)
      _initAccountProxy();
    return account.getAccountName(acNo);
  }
  
  
}