/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;


public class ClienteCtrl {
      //declarar var de conexões com BD
    String nome;
    int dataNasc;
    int cpf;
    int telefone;
    String endereco;
    
    public ClienteCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(Cliente cliente){
        //String sql = "insert into Cliente(nome,dataNasc, cpf, telefone, endereco) VALUES (?, ?)";
        System.out.println("Cliente adicionado com sucesso!");
    }
       
}
