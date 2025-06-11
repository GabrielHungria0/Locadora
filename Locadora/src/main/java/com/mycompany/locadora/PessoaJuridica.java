/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora;

/**
 *
 * @author gabri
 */

import java.util.ArrayList;
public class PessoaJuridica extends Pessoa {

    private String nomeRepresentante;
    private String cnpj;
    private ArrayList<Emprestimo> emprestimos;

    public PessoaJuridica(String nome, String telefone, String endereco, String nomeRepresentante, String cnpj) {
        super(nome, telefone, endereco);
        this.nomeRepresentante = nomeRepresentante;
        this.cnpj = cnpj;
        this.emprestimos = new ArrayList<>();
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public boolean addEmprestimo(Emprestimo emprestimo) {
        if (emprestimo != null) {
            emprestimos.add(emprestimo);
            return true;
        }
        return false;
    }

    public boolean removeEmprestimo(Emprestimo emprestimo) {
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo e = emprestimos.get(i);
            if (e.getCarroEmprestado().getPlaca().equals(emprestimo.getCarroEmprestado().getPlaca())
                    && !e.isFinalizado()) {
                emprestimos.remove(i);
                return true;
            }
        }
        return false;
    }

    public Emprestimo buscaEmprestimo(Emprestimo emprestimo) {
        for (Emprestimo e : emprestimos) {
            if (e.getCarroEmprestado().getPlaca().equals(emprestimo.getCarroEmprestado().getPlaca())
                    && !e.isFinalizado()) {
                return e;
            }
        }
        return null;
    }
}
