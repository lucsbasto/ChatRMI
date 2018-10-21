/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface IServidor extends Remote{
    public void enviaMensagem(Mensagem msg) throws java.rmi.RemoteException;   
    public void contatoCliente(ICliente cli) throws java.rmi.RemoteException;
    public ArrayList<String> enviaClientes() throws java.rmi.RemoteException;
    public boolean Atualizar() throws java.rmi.RemoteException;
    public Mensagem atualiza() throws java.rmi.RemoteException;
    public ArrayList getMsgs() throws java.rmi.RemoteException;
}
