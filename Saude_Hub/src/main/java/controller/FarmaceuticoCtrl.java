/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Farmaceutico;

public class FarmaceuticoCtrl {
     //declarar var de conexões com BD
    String nome;
    int senha;
    int dataNasc;
    int cpf;
    int crf;
    int idFunc;
    String uni;
    
    public FarmaceuticoCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(Farmaceutico farmaceutico){
        //String sql = "insert into Farmaceutico(nome, senha, dataNasc, cpf, crf, uni) VALUES (?, ?)";
        System.out.println("Farmacêutico adicionado com sucesso!");
    }
       
}
