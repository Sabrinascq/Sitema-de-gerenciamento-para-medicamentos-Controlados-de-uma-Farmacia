package controller;

import model.Produto;
import model.ProdutoDAO;
import javax.swing.JOptionPane;

public class ProdutoCtrl {

    public boolean salvar(Produto p) {
        ProdutoDAO dao = new ProdutoDAO();
        
        boolean sucesso = dao.salvarOuSomar(p);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Produto salvo ou estoque atualizado!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar produto.");
            return false;
        }
    }
}