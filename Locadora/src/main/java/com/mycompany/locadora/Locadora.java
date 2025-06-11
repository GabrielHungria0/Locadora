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
public class Locadora {
    
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Carro> carrosDisponiveis;
    private ArrayList<Pessoa> clientes;
    private ArrayList<Emprestimo> emprestimos;

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carrosDisponiveis = new ArrayList<>();
        this.clientes =  new ArrayList<>();
        this.emprestimos = new ArrayList<>();
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

    public boolean setClientes(ArrayList<Pessoa> clientes) {
        this.clientes = clientes;
        return true;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public boolean setEmprestimos(ArrayList<Emprestimo> emprestimos) {     
        this.emprestimos = emprestimos;
        return true;
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
        if(placa == null){
            return null;
        }
        for(Carro carro:carrosDisponiveis){
            if(carro.getPlaca().equals(placa)){
                return carro;
            }
        }
        return null;
    }
    
    public Pessoa buscarCliente(String documento) {
        
        if(documento == null){
            return null;
        }
        
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
            if(emprestimo.getCarroEmprestado().getPlaca().equals(placa) && !emprestimo.isFinalizado()){
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
        
       if(documento == null || placa == null){
           return false;
       }
       
       Pessoa cliente = this.buscarCliente(documento);
       Carro carro = this.buscarCarro(placa);
       
       if(cliente == null || carro == null || carro.isEmprestado() || !this.podeEmprestar(cliente)){
           return false;
       }

       Emprestimo emprestimo = new Emprestimo(carro,cliente);
           
        if(cliente instanceof PessoaFisica pf){     
               pf.setEmprestimo(emprestimo);    
        }
        else if(cliente instanceof PessoaJuridica pj){
               pj.addEmprestimo(emprestimo);
        }
           
           this.addEmprestimo(emprestimo);
           carro.setEmprestado(true);
           
       return true;
    }
    
    public double finalizarEmprestimo(String documento,Emprestimo emprestimo) {
        
       if(emprestimo == null || documento == null){
           return -1;
       }
        
       Pessoa cliente =  this.buscarCliente(documento);
       Carro carro = emprestimo.getCarroEmprestado();
       
       if(cliente == null || !carro.isEmprestado() || emprestimo.isFinalizado()){
           return -1;
       } 
       else if(cliente instanceof PessoaFisica pf){
           if(pf.getEmprestimo()!=emprestimo){
               return -1;
           }else{
               pf.setEmprestimo(null);
               return this.concluirFinalizacao(carro, emprestimo);
           }
       }
       else if(cliente instanceof PessoaJuridica pj){
           Emprestimo validarEmprestimo = pj.buscaEmprestimo(emprestimo);
           if(validarEmprestimo ==null ){
               return -1;
           }
           else{
               pj.removeEmprestimo(emprestimo);
               return this.concluirFinalizacao(carro, emprestimo);
           }
       }
       
       return -1;
    }
    
    private double concluirFinalizacao(Carro carro,Emprestimo emprestimo){
        carro.setEmprestado(false);
        emprestimo.setFinalizado(true);
        return carro.calcularAluguel(emprestimo.getNumeroRenovacoes());     
    }
   
    
}
