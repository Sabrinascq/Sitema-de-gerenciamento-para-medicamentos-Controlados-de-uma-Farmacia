package controller;

import model.ProdutoDAO;
import model.SaidaProdutoDAO;
import javax.swing.JOptionPane;

public class SaidaProdutoCtrl {

    public boolean realizarSaida(String codigo, int qtdSaida) {
        
        if (qtdSaida <= 0) {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que zero.");
            return false;
        }
        if (codigo == null || codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O código do produto é obrigatório.");
            return false;
        }

        ProdutoDAO produtoDao = new ProdutoDAO();
        SaidaProdutoDAO historicoDao = new SaidaProdutoDAO();

        boolean baixou = produtoDao.baixarEstoque(codigo, qtdSaida);

        if (baixou) {
            historicoDao.registrarHistorico(codigo, qtdSaida);
            
            JOptionPane.showMessageDialog(null, "Saída registrada com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Produto não encontrado ou estoque insuficiente.");
            return false;
        }
    }
}