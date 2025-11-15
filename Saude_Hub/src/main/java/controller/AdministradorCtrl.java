/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Administrador;
/**
 *
 * @author PC GAMER
 */
public class AdministradorCtrl {
     //declarar var de conexões com BD
    String nome;
    int senha;
    int dataNasc;
    int cpf;
    int idFunc;
    String tipoAtividade;
    
    public AdministradorCtrl(){
        //abrir nova conexão com BD
    }
    public void adiciona(Administrador administrador){
        //String sql = "insert into Administrador(nome, senha, dataNasc, cpf, tipoAtividade) VALUES (?, ?)";
        System.out.println("Administrador adicionado com sucesso!");
    }
       
}
