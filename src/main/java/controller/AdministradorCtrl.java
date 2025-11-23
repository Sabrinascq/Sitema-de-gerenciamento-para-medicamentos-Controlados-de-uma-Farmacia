package controller;
import javax.swing.JOptionPane;
import model.Administrador;
import model.AdministradorDAO;

public class AdministradorCtrl {

    public AdministradorCtrl() {
    }

    public void adiciona(Administrador administrador) {
        AdministradorDAO dao = new AdministradorDAO();
        if (dao.adiciona(administrador)) {
            JOptionPane.showMessageDialog(null, "Administrador salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar administrador.");
        }
    }
}