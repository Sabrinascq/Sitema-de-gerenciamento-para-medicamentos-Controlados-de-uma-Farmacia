/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class MedicamentoControlado extends Medicamento{
    String numReceita;
    String valReceita;
    String descricao;
    private int quantidade;

    public String getNumReceita() {
        return numReceita;
    }

    public void setNumReceita(String numReceita) {
        this.numReceita = numReceita;
    }

    public String getValReceita() {
        return valReceita;
    }

    public void setValReceita(String valReceita) {
        this.valReceita = valReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
