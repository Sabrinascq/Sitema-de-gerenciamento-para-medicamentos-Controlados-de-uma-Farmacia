package controller;
import model.MedicamentoControlado;
import model.MedicamentoControladoDAO;

public class MedicamentoControladoCtrl {
    
    public MedicamentoControladoCtrl(){
    }

    public void adiciona(MedicamentoControlado medicamentoControlado){
        MedicamentoControladoDAO dao = new MedicamentoControladoDAO();
        dao.adiciona(medicamentoControlado);
        System.out.println("Medicamento Controlado adicionado com sucesso!");
    }
}