package controller;
import model.Funcionario;
import model.FuncionarioDAO;

public class FuncionarioCtrl {
    
    public FuncionarioCtrl(){
    }

    public void adiciona(Funcionario funcionario){
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.adiciona(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }
}