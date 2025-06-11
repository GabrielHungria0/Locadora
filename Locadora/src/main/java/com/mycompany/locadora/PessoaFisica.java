/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora;

/**
 *
 * @author gabri
 */
public class PessoaFisica extends Pessoa{
    
    private String cpf;
    private Emprestimo emprestimo;
    
    public PessoaFisica(String nome, String telefone, String endereço, String cpf,Emprestimo emprestimo) {
        super(nome, telefone, endereço);
        this.cpf = cpf;
        this.emprestimo = emprestimo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
   
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
    
}
