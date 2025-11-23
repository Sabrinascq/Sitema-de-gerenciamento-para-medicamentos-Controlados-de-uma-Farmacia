package controller;

import javax.swing.JOptionPane;
import model.Administrador;
import model.AdministradorDAO;
import model.Funcionario;
import model.FuncionarioDAO;
import view.TelaPrincipal;

public class LoginCtrl {

    public enum TipoUsuario {
        ADMINISTRADOR,
        FUNCIONARIO,
        INVALIDO
    }

    public boolean autenticar(String cpf, String senha, javax.swing.JFrame telaLogin) {
        
        AdministradorDAO adminDao = new AdministradorDAO();
        Administrador admin = adminDao.login(cpf, senha);

        if (admin != null) {
            JOptionPane.showMessageDialog(null, "Login de Administrador bem-sucedido! Acesso Total.");
            
            telaLogin.dispose();
            
            TelaPrincipal tela = new TelaPrincipal(TipoUsuario.ADMINISTRADOR);
            tela.setVisible(true);
            return true;
        }

        FuncionarioDAO funcDao = new FuncionarioDAO();
        Funcionario func = funcDao.login(cpf, senha);

        if (func != null) {
            JOptionPane.showMessageDialog(null, "Login de Funcionário bem-sucedido! Acesso Restrito.");
            
            telaLogin.dispose();
            
            TelaPrincipal tela = new TelaPrincipal(TipoUsuario.FUNCIONARIO);
            tela.setVisible(true);
            return true;
        }

        JOptionPane.showMessageDialog(null, "CPF ou Senha inválidos. Tente novamente.");
        return false;
    }
}