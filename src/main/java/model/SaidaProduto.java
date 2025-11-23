package model;

public class SaidaProduto {
    private int id;
    private String codigoProduto;
    private int quantidade;
    private String dataSaida;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCodigoProduto() { return codigoProduto; }
    public void setCodigoProduto(String codigoProduto) { this.codigoProduto = codigoProduto; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getDataSaida() { return dataSaida; }
    public void setDataSaida(String dataSaida) { this.dataSaida = dataSaida; }
}