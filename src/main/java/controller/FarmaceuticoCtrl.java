package controller;
import model.Farmaceutico;
import model.FarmaceuticoDAO;

public class FarmaceuticoCtrl {
    
    public FarmaceuticoCtrl(){
    }

    public void adiciona(Farmaceutico farmaceutico){
        FarmaceuticoDAO dao = new FarmaceuticoDAO();
        dao.adiciona(farmaceutico);
        System.out.println("Farmacêutico adicionado com sucesso!");
    }
}