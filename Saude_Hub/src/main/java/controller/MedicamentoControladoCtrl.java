/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MedicamentoControlado;

public class MedicamentoControladoCtrl {
    //declarar var de conexões com BD
    String nome;
    String tipoControle;
    String dosagem;
    int numReceita;
    int valReceita;
    String descricao;
    
    public MedicamentoControladoCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(MedicamentoControlado medicamentoControlado){
        //String sql = "insert into MedicamentoControlado(nome, tipoControle, dosagem, numReceita, valReceita, descricao) VALUES (?, ?)";
        System.out.println("Medicamento Controlado adicionado com sucesso!");
    }
}
