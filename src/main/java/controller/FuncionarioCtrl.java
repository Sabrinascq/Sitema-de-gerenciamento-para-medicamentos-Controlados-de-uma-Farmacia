package controller;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.FuncionarioDAO;

public class FuncionarioCtrl {
    
    public FuncionarioCtrl(){
    }

    public void adiciona(Funcionario funcionario){
        FuncionarioDAO dao = new FuncionarioDAO();
        if(dao.adiciona(funcionario)){
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar funcionário.");
        }
    }
}