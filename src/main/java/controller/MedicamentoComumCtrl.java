package controller;
import model.MedicamentoComum;
import model.MedicamentoComumDAO;

public class MedicamentoComumCtrl {
    
    public MedicamentoComumCtrl(){
    }

    public void adiciona(MedicamentoComum medicamentoComum){
        MedicamentoComumDAO dao = new MedicamentoComumDAO();
        dao.adiciona(medicamentoComum);
        System.out.println("Medicamento Comum adicionado com sucesso!");
    }
}