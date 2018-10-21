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
public interface ICliente extends Remote{
    public void notificaRecebimento(Mensagem msg) throws java.rmi.RemoteException;
    public String retornaNome() throws java.rmi.RemoteException;
    public String getNome() throws java.rmi.RemoteException;
    public ArrayList atualiza() throws java.rmi.RemoteException;
}
