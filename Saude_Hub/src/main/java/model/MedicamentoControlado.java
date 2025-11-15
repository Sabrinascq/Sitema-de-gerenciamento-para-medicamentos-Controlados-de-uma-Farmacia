/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class MedicamentoControlado extends Medicamento{
    int numReceita;
    int valReceita;
    String descricao;

    public int getNumReceita() {
        return numReceita;
    }

    public void setNumReceita(int numReceita) {
        this.numReceita = numReceita;
    }

    public int getValReceita() {
        return valReceita;
    }

    public void setValReceita(int valReceita) {
        this.valReceita = valReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
