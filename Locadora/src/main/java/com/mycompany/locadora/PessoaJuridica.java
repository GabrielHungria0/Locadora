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
    
    public PessoaJuridica(String nome, String telefone, String endereço,String nomeRepresentante,String cnpj) {
        super(nome, telefone, endereço);
        this.nomeRepresentante = nomeRepresentante;
        this.cnpj = cnpj;
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
    
    public boolean addEmprestimo(Emprestimo emprestimo){
        if(emprestimo!=null){
            return false;
        }else{
            emprestimos.add(emprestimo);
            return true;
        }
    } 
    public boolean removeEmprestimo(Emprestimo emprestimo){
        if(this.buscaEmprestimo(emprestimo) == null){
            return false;
        }else{
            this.emprestimos.remove(emprestimo);
            return true;
        }
    }
    public Emprestimo buscaEmprestimo(Emprestimo emprestimo){
        for(Emprestimo emprestimosFeitos : emprestimos){
            if(emprestimosFeitos == emprestimo){
                return emprestimo;
            }else{
                return null;
            }
        }
        return null;
    }
}
