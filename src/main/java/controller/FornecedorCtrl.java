package controller;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.FornecedorDAO;

public class FornecedorCtrl {
    
    public FornecedorCtrl(){
    }

    public void adiciona(Fornecedor fornecedor){
        FornecedorDAO dao = new FornecedorDAO();
        if(dao.adiciona(fornecedor)){
            JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar fornecedor.");
        }
    }
}