
import all.ICliente;
import all.IServidor;
import all.Mensagem;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements IServidor {

    private ArrayList<ICliente> cli = new ArrayList<>();
    private ArrayList<String> nomes = new ArrayList<>();
    private Mensagem msg;
    private ArrayList<Mensagem> msgs = new ArrayList<>();
    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public void enviaMensagem(Mensagem msg) throws RemoteException {
        this.msg = msg;
        if (msg.getReceiver().equalsIgnoreCase("todos")) {
            encTodos(msg);
        } else {
            envInd(msg);
        }
    }
    
    @Override
    public Mensagem atualiza(){
        System.out.println("A mensagem foi: "+msg.toString());
        return this.msg;
    }
     
    public void encTodos(Mensagem msg) throws RemoteException {
        for (ICliente c : cli) {
            c.notificaRecebimento(msg);
            c.atualiza();
        }
    }
    
    public void envInd(Mensagem msg) throws RemoteException {
        for(ICliente ic: cli){
            if(ic.getNome().equals(msg.getReceiver()))
                ic.notificaRecebimento(msg);
                ic.atualiza();
        }
    }
    @Override
    public ArrayList getMsgs(){
        return this.msgs;
    }
    
    @Override
    public void contatoCliente(ICliente cli) throws RemoteException {
        this.cli.add(cli);
        enviaClientes();
    }

    @Override
    public ArrayList<String> enviaClientes() throws RemoteException {
        nomes = new ArrayList<>();
        for (int i = 0; i < cli.size(); i++) {
            nomes.add(cli.get(i).retornaNome());
        }
        return nomes;
    }

    @Override
    public boolean Atualizar() throws RemoteException {
        for (int i = 0; i < cli.size(); i++) {
            nomes.add(cli.get(i).retornaNome());
        }
        return true;
    }
    @Override
    public void disconnect(){
        
    } 
     
    
    
     public static void main(String[] args) {
         try {     
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry pronto.");
            System.out.println("");
        } catch (Exception e) {
                    System.out.println("Exception starting RMI registry:" + e);
        }
                
        try{			
                Servidor s = new Servidor();
                Naming.rebind("ServidorService", s); 
                System.out.println("foi aqui");
        }catch (RemoteException | MalformedURLException e){
                System.err.println("Erro: "+ e.getMessage() );	
                System.exit(0);
        }       
    }
}
