package controller;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteDAO;

public class ClienteCtrl {
    
    public ClienteCtrl(){
    }
    
    public void adiciona(Cliente cliente){
        ClienteDAO dao = new ClienteDAO();
        if(dao.adiciona(cliente)){
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente.");
        }
    }  
}