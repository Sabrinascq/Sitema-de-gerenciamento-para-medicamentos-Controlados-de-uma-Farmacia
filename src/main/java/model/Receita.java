package model;

public class Receita {
    private int idReceita;
    private int clienteId; 
    private String nomeMedicamento; 
    private String dataEmissao;
    private String posologia;
    
 
    public int getIdReceita() { return idReceita; }
    public void setIdReceita(int idReceita) { this.idReceita = idReceita; }
    
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    
    public String getNomeMedicamento() { return nomeMedicamento; }
    public void setNomeMedicamento(String nomeMedicamento) { this.nomeMedicamento = nomeMedicamento; }

    public String getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(String dataEmissao) { this.dataEmissao = dataEmissao; }
    
    public String getPosologia() { return posologia; }
    public void setPosologia(String posologia) { this.posologia = posologia; }
}