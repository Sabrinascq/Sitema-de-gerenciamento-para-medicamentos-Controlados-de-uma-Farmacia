package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

import model.*; 

public class Relatorio {

    // -------------------------------------------------------------------------
    // 1. RELATÓRIO DE CLIENTES
    // -------------------------------------------------------------------------
    public void gerarRelatorioClientes() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE CLIENTES ===\n\n");

        if (lista.isEmpty()) {
            sb.append("Nenhum cliente encontrado.\n");
        } else {
            for (Cliente c : lista) {
                sb.append("Nome: ").append(c.getNome()).append("\n");
                sb.append("Data de Nascimento: ").append(c.getDataNasc()).append("\n");
                sb.append("CPF: ").append(c.getCpf()).append("\n");
                sb.append("Telefone: ").append(c.getTelefone()).append("\n");
                sb.append("Endereço: ").append(c.getEndereco()).append("\n");
                sb.append("--------------------------------------------------\n");
            }
        }
        mostrarNaTela("Relatório de Clientes", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 2. RELATÓRIO DE PRODUTOS
    // -------------------------------------------------------------------------
    public void gerarRelatorioProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE ESTOQUE DE PRODUTOS ===\n\n");

        if (lista.isEmpty()) {
            sb.append("Nenhum produto cadastrado.\n");
        } else {
            for (Produto p : lista) {
                sb.append("Código: ").append(p.getCodigo()).append("\n");
                sb.append("Nome: ").append(p.getNome()).append("\n");
                sb.append(String.format("Preço Unitário: R$ %.2f\n", p.getPreco()));
                
                sb.append("Quantidade em Estoque: ").append(p.getQuantidade()).append("\n");
                
                sb.append("--------------------------------------------------\n");
            }
        }
        mostrarNaTela("Relatório de Produtos", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 3. RELATÓRIO DE FARMACÊUTICOS
    // -------------------------------------------------------------------------
    public void gerarRelatorioFarmaceuticos() {
        FarmaceuticoDAO dao = new FarmaceuticoDAO();
        List<Farmaceutico> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE FARMACÊUTICOS ===\n\n");

        for (Farmaceutico f : lista) {
            sb.append("Nome: ").append(f.getNome()).append("\n");
            sb.append("Data de Nascimento: ").append(f.getDataNasc()).append("\n");
            sb.append("CRF: ").append(f.getCrf()).append("\n");
            sb.append("CPF: ").append(f.getCpf()).append("\n");
            sb.append("Universidade: ").append(f.getUni()).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        mostrarNaTela("Relatório de Farmacêuticos", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 4. RELATÓRIO DE MEDICAMENTOS (COMUNS)
    // -------------------------------------------------------------------------
    public void gerarRelatorioMedComum() {
        MedicamentoComumDAO dao = new MedicamentoComumDAO();
        List<MedicamentoComum> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE MEDICAMENTOS COMUNS ===\n\n");

        for (MedicamentoComum m : lista) {
            sb.append("Nome: ").append(m.getNome()).append("\n");
            sb.append("Dosagem: ").append(m.getDosagem()).append("\n");
            sb.append("Indicação: ").append(m.getIndicacao()).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        mostrarNaTela("Relatório de Med. Comuns", sb.toString());
    }
    
    // -------------------------------------------------------------------------
    // 5. RELATÓRIO DE MEDICAMENTOS (CONTROLADOS)
    // -------------------------------------------------------------------------
    public void gerarRelatorioMedControlado() {
        MedicamentoControladoDAO dao = new MedicamentoControladoDAO();
        List<MedicamentoControlado> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE MEDICAMENTOS CONTROLADOS ===\n\n");

        for (MedicamentoControlado m : lista) {
            sb.append("Nome: ").append(m.getNome()).append("\n");
            sb.append("Tipo Controle: ").append(m.getTipoControle()).append("\n");
            sb.append("Num. Receita: ").append(m.getNumReceita()).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        mostrarNaTela("Relatório de Med. Controlados", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 6. RELATÓRIO DE FORNECEDORES
    // -------------------------------------------------------------------------
    public void gerarRelatorioFornecedores() {
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE FORNECEDORES ===\n\n");

        for (Fornecedor f : lista) {
            sb.append("Nome: ").append(f.getNome()).append("\n");
            sb.append("CNPJ: ").append(f.getCnpj()).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        mostrarNaTela("Relatório de Fornecedores", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 7. RELATÓRIO DE FUNCIONÁRIOS
    // -------------------------------------------------------------------------
    public void gerarRelatorioFuncionarios() {
        FuncionarioDAO dao = new FuncionarioDAO();
        List<Funcionario> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE FUNCIONÁRIOS ===\n\n");

        for (Funcionario f : lista) {
            sb.append("Nome: ").append(f.getNome()).append("\n");
            sb.append("Data de Nascimento: ").append(f.getDataNasc()).append("\n");
            sb.append("CPF: ").append(f.getCpf()).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        mostrarNaTela("Relatório de Funcionários", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 8. RELATÓRIO DE ADMINISTRADORES
    // -------------------------------------------------------------------------
    public void gerarRelatorioAdministradores() {
        AdministradorDAO dao = new AdministradorDAO();
        List<Administrador> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE ADMINISTRADORES ===\n\n");

        for (Administrador a : lista) {
            sb.append("Nome: ").append(a.getNome()).append("\n");
            sb.append("Data de Nascimento: ").append(a.getDataNasc()).append("\n");
            sb.append("CPF: ").append(a.getCpf()).append("\n");
            sb.append("Tipo Atividade: ").append(a.getTipoAtividade()).append("\n");
            sb.append("--------------------------------------------------\n");
        }
        mostrarNaTela("Relatório de Administradores", sb.toString());
    }

    // -------------------------------------------------------------------------
    // 9. RELATÓRIO DE RECEITAS
    // -------------------------------------------------------------------------
    public void gerarRelatorioReceitas() {
        ReceitaDAO dao = new ReceitaDAO();
        List<Receita> lista = dao.listarTodos();

        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO DE RECEITAS ===\n\n");

        if (lista.isEmpty()) {
            sb.append("Nenhuma receita encontrada.\n");
        } else {
            for (Receita r : lista) {
                sb.append("Medicamento: ").append(r.getNomeMedicamento()).append("\n");
                sb.append("Data Emissão: ").append(r.getDataEmissao()).append("\n");
                sb.append("Posologia: ").append(r.getPosologia()).append("\n");
                sb.append("--------------------------------------------------\n");
            }
        }
        mostrarNaTela("Relatório de Receitas", sb.toString());
    }

    // =========================================================================
    // MÉTODO AUXILIAR PARA EXIBIR NA TELA COM SCROLL
    // =========================================================================
    private void mostrarNaTela(String titulo, String texto) {
        JTextArea textArea = new JTextArea(texto);
        textArea.setEditable(false); 
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400)); 
        
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}