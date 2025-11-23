/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Funcionario extends Pessoa {
    String senha;
    int idFunc;
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getIdFunc() {
        return idFunc;
    }
    
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
}
