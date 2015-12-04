/**
 * HelloServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.m2i.formation.jsf.webService;

public class HelloServiceSoapBindingSkeleton implements com.m2i.formation.jsf.webService.HelloService, org.apache.axis.wsdl.Skeleton {
    private com.m2i.formation.jsf.webService.HelloService impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getById", _params, new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "getByIdReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://managedBeans.jsf.formation.m2i.com", "BookTO"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "getById"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getById") == null) {
            _myOperations.put("getById", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getById")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "title"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "price"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getBook", _params, new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "getBookReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://managedBeans.jsf.formation.m2i.com", "BookTO"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "getBook"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getBook") == null) {
            _myOperations.put("getBook", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getBook")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getHello", _params, new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "getHelloReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://webService.jsf.formation.m2i.com", "getHello"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getHello") == null) {
            _myOperations.put("getHello", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getHello")).add(_oper);
    }

    public HelloServiceSoapBindingSkeleton() {
        this.impl = new com.m2i.formation.jsf.webService.HelloServiceSoapBindingImpl();
    }

    public HelloServiceSoapBindingSkeleton(com.m2i.formation.jsf.webService.HelloService impl) {
        this.impl = impl;
    }
    public com.m2i.formation.jsf.managedBeans.BookTO getById(int id) throws java.rmi.RemoteException
    {
        com.m2i.formation.jsf.managedBeans.BookTO ret = impl.getById(id);
        return ret;
    }

    public com.m2i.formation.jsf.managedBeans.BookTO getBook(int id, java.lang.String title, double price) throws java.rmi.RemoteException
    {
        com.m2i.formation.jsf.managedBeans.BookTO ret = impl.getBook(id, title, price);
        return ret;
    }

    public java.lang.String getHello() throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getHello();
        return ret;
    }

}
