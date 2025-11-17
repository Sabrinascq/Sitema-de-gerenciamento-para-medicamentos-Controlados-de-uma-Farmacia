package controller;
import model.Cliente;
import model.ClienteDAO;

public class ClienteCtrl {
    
    public ClienteCtrl(){
    }
    
    public void adiciona(Cliente cliente){
        ClienteDAO dao = new ClienteDAO();
        if(dao.adiciona(cliente)){
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.err.println("Erro ao adicionar cliente.");
        }
    }  
}