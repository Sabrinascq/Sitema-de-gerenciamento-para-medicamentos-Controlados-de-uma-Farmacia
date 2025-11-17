package controller;
import model.Produto;
import model.ProdutoDAO;

public class ProdutoCtrl {
    
    public ProdutoCtrl(){
    }

    public void adiciona(Produto produto){
        ProdutoDAO dao = new ProdutoDAO();
        dao.adiciona(produto);
        System.out.println("Produto adicionado com sucesso!");
    }
}