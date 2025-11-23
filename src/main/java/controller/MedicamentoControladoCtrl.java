package controller;
import javax.swing.JOptionPane;
import model.MedicamentoControlado;
import model.MedicamentoControladoDAO;

public class MedicamentoControladoCtrl {
    
    public MedicamentoControladoCtrl(){
    }

    public void adiciona(MedicamentoControlado medicamentoControlado){
        MedicamentoControladoDAO dao = new MedicamentoControladoDAO();
        if(dao.adiciona(medicamentoControlado)){
            JOptionPane.showMessageDialog(null, "Medicamento controlado salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar medicamento controlado.");
        }
    }
}