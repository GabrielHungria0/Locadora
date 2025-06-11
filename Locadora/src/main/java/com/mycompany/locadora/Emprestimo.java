/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora;

/**
 *
 * @author gabri
 */
public class Emprestimo {
    
    private Carro carroEmprestado;
    private int numeroRenovacoes; 
    private boolean finalizado;
    private Pessoa pessoa;

    public Emprestimo(Carro carroEmprestado,Pessoa pessoa) {
        this.carroEmprestado = carroEmprestado;
        this.numeroRenovacoes = 0;
        this.finalizado = false;
        this.carroEmprestado.setEmprestado(true);
        this.pessoa = pessoa;
    }

    public Carro getCarroEmprestado() {
        return carroEmprestado;
    }

    public void setCarroEmprestado(Carro carroEmprestado) {
        this.carroEmprestado = carroEmprestado;
    }

    public int getNumeroRenovacoes() {
        return numeroRenovacoes;
    }

    public void renovar(int diasExtras) {
        this.numeroRenovacoes += diasExtras;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }   

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
