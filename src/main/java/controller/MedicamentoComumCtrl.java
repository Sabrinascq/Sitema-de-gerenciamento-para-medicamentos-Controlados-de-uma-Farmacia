package controller;
import javax.swing.JOptionPane;
import model.MedicamentoComum;
import model.MedicamentoComumDAO;

public class MedicamentoComumCtrl {
    
    public MedicamentoComumCtrl(){
    }

    public void adiciona(MedicamentoComum medicamentoComum){
        MedicamentoComumDAO dao = new MedicamentoComumDAO();
        if(dao.adiciona(medicamentoComum)){
            JOptionPane.showMessageDialog(null, "Medicamento comum salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar medicamento comum.");
        }
    }
}