/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora;

/**
 *
 * @author gabri
 */
public class CarroLuxo extends Carro{
    
    private int qtdAirBags;
    private double tmnhPortaMalas;
    private boolean gpsIntegrado;

    public CarroLuxo(String marca, String modelo, String placa, int ano, double valorLocacao,double valorMulta,int qtdAirBags,double tmnhPortaMalas,boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacao,valorMulta);
        this.qtdAirBags = qtdAirBags;
        this.tmnhPortaMalas = tmnhPortaMalas;
        this.gpsIntegrado = gpsIntegrado;
    }

    public int getQtdAirBags() {
        return qtdAirBags;
    }

    public void setQtdAirBags(int qtdAirBags) {
        this.qtdAirBags = qtdAirBags;
    }

    public double getTmnhPortaMalas() {
        return tmnhPortaMalas;
    }

    public void setTmnhPortaMalas(double tmnhPortaMalas) {
        this.tmnhPortaMalas = tmnhPortaMalas;
    }

    public boolean isGpsIntegrado() {
        return gpsIntegrado;
    }

    public void setGpsIntegrado(boolean gpsIntegrado) {
        this.gpsIntegrado = gpsIntegrado;
    }

    @Override
     public double calcularAluguel(int renovacoes){
        if(renovacoes>5){
            return (renovacoes-5)*super.getValorMulta()+super.getValorLocacao();
        }
        return super.getValorLocacao();
    }
   
}
