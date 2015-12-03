/**
 * HelloService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.m2i.formation.jsf.manageBeans.francois;

public interface HelloService extends java.rmi.Remote {
    public java.lang.String getHello(java.lang.String name) throws java.rmi.RemoteException;
    public com.m2i.formation.jsf.manageBeans.francois.BookBean getBookbyID(int id) throws java.rmi.RemoteException;
}
