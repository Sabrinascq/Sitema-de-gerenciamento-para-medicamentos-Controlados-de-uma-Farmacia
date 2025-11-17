package controller;
import model.Fornecedor;
import model.FornecedorDAO;

public class FornecedorCtrl {
    
    public FornecedorCtrl(){
    }

    public void adiciona(Fornecedor fornecedor){
        FornecedorDAO dao = new FornecedorDAO();
        dao.adiciona(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
    }
}