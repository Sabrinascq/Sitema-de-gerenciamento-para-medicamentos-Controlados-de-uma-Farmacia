package controller;
import model.Administrador;
import model.AdministradorDAO;

public class AdministradorCtrl {

    public AdministradorCtrl() {
    }

    public void adiciona(Administrador administrador) {
        AdministradorDAO dao = new AdministradorDAO();
        if (dao.adiciona(administrador)) {
            System.out.println("Administrador cadastrado com sucesso!");
        } else {
            System.err.println("Erro ao cadastrar administrador.");
        }
    }
}