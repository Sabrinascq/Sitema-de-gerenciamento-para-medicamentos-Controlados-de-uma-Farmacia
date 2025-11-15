/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Fornecedor;


public class FornecedorCtrl {
     //declarar var de conexões com BD
    String nome;
    int cnpj;
    
    public FornecedorCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(Fornecedor farmaceutico){
        //String sql = "insert into Fornecedor(nome, cnpj) VALUES (?, ?)";
        System.out.println("Fornecedor adicionado com sucesso!");
    }
}
