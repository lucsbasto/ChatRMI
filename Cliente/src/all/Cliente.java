package all;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import all.tela;
import java.util.ArrayList;
/**
 *
 * @author Lucas
 */
public class Cliente extends UnicastRemoteObject implements ICliente{
    String nome;
    static IServidor server;
    String msg;
    ArrayList<String> msgs = new ArrayList<>();
        
    public Cliente(IServidor server) throws RemoteException {
        super();
        Cliente.server = server;
    }

    @Override
    public void notificaRecebimento(Mensagem msg) throws RemoteException {
        this.msg = msg.getSender() + " diz: " + msg.getMensagem();
        System.out.println(this.msg);
        this.msgs.add(this.msg);
    }

    public String mensagem() {
        return this.msg;
    }
    
    @Override
    public ArrayList atualiza(){
        return this.msgs;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int msgSize(){
        return this.msgs.size();
    }
    
    @Override
    public String retornaNome() throws RemoteException {
        return nome;
    }
}
