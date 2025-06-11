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

    public Emprestimo(Carro carroEmprestado,Pessoa pessoa) {
        this.carroEmprestado = carroEmprestado;
        this.numeroRenovacoes = 0;
        this.finalizado = false;
        this.carroEmprestado.setEmprestado(true);
    }

    public Carro getCarroEmprestado() {
        return carroEmprestado;
    }

    public boolean setCarroEmprestado(Carro carroEmprestado) {
        if(carroEmprestado == null){
            return false;
        }
        this.carroEmprestado = carroEmprestado;
        return true;
    }

    public int getNumeroRenovacoes() {
        return numeroRenovacoes;
    }

    public boolean renovar(int diasExtras) {
        if(diasExtras<=0){
            return false;
        }
        this.numeroRenovacoes += diasExtras;
        return true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }   
    
}
