/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Funcionario;



/**
 *
 * @author thiag
 */
public class FuncionarioCtrl {
    //declarar var de conexões com BD
    String nome;
    int senha;
    int dataNasc;
    int cpf;
    int idFunc;
    public FuncionarioCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(Funcionario funcionario){
        //String sql = "insert into Funcionario(nome, senha, dataNasc, cpf, idFunc) VALUES (?, ?)";
        System.out.println("Funcionário adicionado com sucesso!");
    }
       
}
