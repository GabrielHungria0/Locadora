/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora;

/**
 *
 * @author gabri
 */
public class CarroPopular extends Carro{
    
    private boolean arCondicionado;
    
    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacao,double valorMulta,boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.arCondicionado = arCondicionado;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }  
    
    @Override
     public double calcularAluguel(int renovacoes){
        if(renovacoes>1){
            return (renovacoes-1)*super.getValorMulta()+super.getValorLocacao();
        }
        return super.getValorLocacao();
    }
    
    
    
}
