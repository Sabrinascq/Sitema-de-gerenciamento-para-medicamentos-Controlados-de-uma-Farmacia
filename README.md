# 💊 SaúdeHub: Sistema de Gerenciamento para Farmácia

Este é um projeto de desenvolvimento de um **Sistema de Gerenciamento de Farmácia** com foco na otimização do controle de entidades essenciais do negócio e no gerenciamento de **medicamentos controlados** através do crucial módulo de Cadastro de Receitas.
***

## ✨ Tecnologias e Arquitetura

O sistema foi construído sobre uma arquitetura robusta, utilizando a linguagem **Java** e seguindo boas práticas de design de software.

* **Linguagem de Programação:** **Java**.
* **Interface Gráfica (Visão):** Java **Swing**, ideal para aplicações desktop.
* **Banco de Dados (SGBD):** **MySQL** para persistência de dados.
* **Arquitetura:** Padrão **Modelo-Visão-Controlador (MVC)**, garantindo a separação clara de responsabilidades entre lógica de dados, interface e controle de fluxo.
    * O código está dividido nos pacotes `model`, `view`, e `controller`.
* **Padrões de Design:** Aplicação do **Princípio da Responsabilidade Única (SRP)**, garantindo que classes de Controle (*Ctrl) e Acesso a Dados (*DAO) mantenham responsabilidades estritamente separadas.

***

## 🔑 Funcionalidades e Escopo do Projeto

O objetivo do projeto foi implementar um sistema modular e eficiente que suporta as seguintes operações de gerenciamento:

* **Gerenciamento de Cadastros:** Suporte ao cadastro completo de clientes, funcionários (administradores e farmacêuticos), fornecedores e medicamentos (comuns e controlados).
* **Cadastro de Receitas:** Funcionalidade para vincular um cliente a um medicamento já registrado, assegurando a rastreabilidade.
* **Controle de Estoque:** Gerenciamento de estoque de entrada e saída de medicamentos/produtos.
* **Sistema de Login:** Implementação de login para acesso dos funcionários, com diferentes níveis de acesso e controle de segurança.

