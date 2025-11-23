package controller;
import javax.swing.JOptionPane;
import model.Farmaceutico;
import model.FarmaceuticoDAO;

public class FarmaceuticoCtrl {
    
    public FarmaceuticoCtrl(){
    }

    public void adiciona(Farmaceutico farmaceutico){
        FarmaceuticoDAO dao = new FarmaceuticoDAO();
        if(dao.adiciona(farmaceutico)){
            JOptionPane.showMessageDialog(null, "Farmacêutico salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar farmacêutico.");
        }
    }
}