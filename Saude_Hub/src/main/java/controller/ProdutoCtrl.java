/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Produto;

public class ProdutoCtrl {
      //declarar var de conexões com BD
    String nome;
    float preco;
    int codigo;
    
    public ProdutoCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(Produto produto){
        //String sql = "insert into Produto(nome, preco, codigo) VALUES (?, ?)";
        System.out.println("Produto adicionado com sucesso!");
    }
}
