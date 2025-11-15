/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MedicamentoComum;


public class MedicamentoComumCtrl {
    //declarar var de conexões com BD
    String nome;
    String tipoControle;
    String dosagem;
    String indicacao;
    
    public MedicamentoComumCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(MedicamentoComum medicamentoComum){
        //String sql = "insert into MedicamentoComum(nome, tipoControle, dosagem, indicacao) VALUES (?, ?)";
        System.out.println("Medicamento Comum adicionado com sucesso!");
    }
}
