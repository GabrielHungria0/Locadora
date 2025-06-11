/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.locadora;

/**
 *
 * @author gabri
 */
public class CarroSuv extends Carro {
    
    private double tmnhPortaMalas;
    private String tipoTracao;
    private String tipoCombustivel;

    public CarroSuv(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta ,double tmnhPortaMalas,String tipoTracao,String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacao,valorMulta);
        this.tipoCombustivel = tipoCombustivel;
        this.tipoTracao = tipoTracao;
        this.tmnhPortaMalas = tmnhPortaMalas;
    }

    public double getTmnhPortaMalas() {
        return tmnhPortaMalas;
    }

    public void setTmnhPortaMalas(double tmnhPortaMalas) {
        this.tmnhPortaMalas = tmnhPortaMalas;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
    
    @Override
     public double calcularAluguel(int renovacoes){
        if(renovacoes>3){
            return (renovacoes-3)*super.getValorMulta()+super.getValorLocacao();
        }
        return super.getValorLocacao();
    }
    
    
    
}
