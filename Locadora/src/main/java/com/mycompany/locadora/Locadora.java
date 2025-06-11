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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Locadora {
    
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Carro> carrosDisponiveis;
    private ArrayList<Pessoa> clientes;
    private ArrayList<Emprestimo> emprestimos;

    public Locadora(String nome, String endereco, String telefone, ArrayList<Carro> carrosDisponiveis, ArrayList<Pessoa> clientes, ArrayList<Emprestimo> emprestimos) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carrosDisponiveis = carrosDisponiveis;
        this.clientes = clientes;
        this.emprestimos = emprestimos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Carro> getCarrosDisponiveis() {
        return carrosDisponiveis;
    }

    public void setCarrosDisponiveis(ArrayList<Carro> carrosDisponiveis) {
        this.carrosDisponiveis = carrosDisponiveis;
    }

    public ArrayList<Pessoa> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Pessoa> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public boolean addCarros(Carro carro){
        if(carro!=null){
            carrosDisponiveis.add(carro);
            return true;
        }else{
            return false;
        }
    }
    public boolean addClientes(Pessoa cliente){
        if(cliente!=null){
            clientes.add(cliente);
            return true;
        }else{
            return false;
        }
    }
    public boolean addEmprestimo(Emprestimo emprestimo){
        if(emprestimo!=null){
            emprestimos.add(emprestimo);
            return true;
        }else{
            return false;
        }
    }
    
    public Carro buscarCarro(String placa){
        for(Carro carro:carrosDisponiveis){
            if(carro.getPlaca().equals(placa)){
                return carro;
            }
        }
        return null;
    }
    
    public Pessoa buscarCliente(String documento) {
        for (Pessoa p : clientes) {
            if (p instanceof PessoaFisica pf && pf.getCpf().equals(documento)) {
                return pf;
            } else if (p instanceof PessoaJuridica pj && pj.getCnpj().equals(documento)) {
                return pj;
            }
        }
        return null;
    }
    
    public Emprestimo buscarEmprestimo(String placa){
        for(Emprestimo emprestimo : emprestimos){
            if(emprestimo.getCarroEmprestado().getPlaca().equals(placa)){
                return emprestimo;
            }
        }
        return null;
    }
    
    public boolean podeEmprestar(Pessoa cliente){ 
       if( cliente instanceof PessoaFisica pf){
           return pf.getEmprestimo() == null;
       }else{
           return true;
       }
    }
    
    public boolean realizarEmprestimo(String documento,String placa){ 
       Pessoa cliente = this.buscarCliente(documento);
       Carro carro = this.buscarCarro(placa);
       if(cliente == null || carro == null || carro.isEmprestado()){
           return false;
       }else if(this.podeEmprestar(cliente)){
           Emprestimo emprestimo = new Emprestimo(carro,cliente);
           if(cliente instanceof PessoaFisica pf){
               pf.setEmprestimo(emprestimo);
               emprestimos.add(emprestimo);
               carro.setEmprestado(true);
               return true;
           }else if(cliente instanceof PessoaJuridica pj){
               pj.addEmprestimo(emprestimo);
               emprestimos.add(emprestimo);
               carro.setEmprestado(true);
               return true;
           }
       }
       return false;
    }
    
    public double finalizarEmprestimo(String documento,Emprestimo emprestimo) {
        
       Pessoa cliente =  this.buscarCliente(documento);
       Carro carro = emprestimo.getCarroEmprestado();
       
       if(cliente == null || !carro.isEmprestado() || emprestimo.isFinalizado()){
           return -1;
       } 
       else if(cliente instanceof PessoaFisica pf){
           if(pf.getEmprestimo()!=emprestimo){
               return -1;
           }else{
               carro.setEmprestado(false);
               emprestimo.setFinalizado(true);
               pf.setEmprestimo(null);
               return carro.calcularAluguel(emprestimo.getNumeroRenovacoes());
           }
       }
       else if(cliente instanceof PessoaJuridica pj){
           Emprestimo validarEmprestimo = pj.buscaEmprestimo(emprestimo);
           if(validarEmprestimo ==null){
               return -1;
           }
           else{
               carro.setEmprestado(false);
               emprestimo.setFinalizado(true);
               pj.removeEmprestimo(emprestimo);
               return carro.calcularAluguel(emprestimo.getNumeroRenovacoes());     
           }
       }
       
       return -1;
    }
   
    
}
