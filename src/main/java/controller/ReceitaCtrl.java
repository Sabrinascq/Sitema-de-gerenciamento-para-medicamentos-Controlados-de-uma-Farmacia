package controller;
import javax.swing.JOptionPane;
import model.Receita;
import model.ReceitaDAO;

public class ReceitaCtrl {
    
    public ReceitaCtrl(){}

    public void adiciona(Receita receita){
        ReceitaDAO dao = new ReceitaDAO();
        if(dao.adiciona(receita)){
            JOptionPane.showMessageDialog(null, "Receita salva com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar receita. Verifique se o Cliente e o Medicamento existem.");
        }
    }
}