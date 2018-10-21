package all;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Mensagem implements Serializable {
    String sender;
    String receiver;
    String mensagem;
    
    public Mensagem(String sender, String receiver, String mensagem){
    this.sender = sender;
    this.receiver = receiver;
    this.mensagem = mensagem;
    }    

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "sender=" + sender + ", receiver=" + receiver + ", mensagem=" + mensagem + '}';
    }
    
}
