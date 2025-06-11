/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.locadora;

/**
 *
 * @author gabri
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        while(true){
            ArrayList<Carro> carros = new ArrayList<>();
            ArrayList<Pessoa> p1 = new ArrayList<>();
            ArrayList<Emprestimo> e1 = new ArrayList<>();
            Locadora Desmanche = new Locadora("Desmanche", "If Goiano", "984433892", carros, p1, e1);
            Scanner leitor = new Scanner(System.in);
            System.out.println("1-cadastrar um novo veículo");
            System.out.println("2-cadastrar clientes");
            System.out.println("3-realizar um empréstimo");
            System.out.println("4-finalizar um empréstimo");
            System.out.println("5-Sair");
            int opcao = leitor.nextInt();
            leitor.nextLine();
            
            switch(opcao){
                
                case 1:
                    System.out.println("Digite o numero da opcao para escolher");
                    System.out.println("1-Luxo");
                    System.out.println("2-Popular");
                    System.out.println("3-Suv");
                    opcao = leitor.nextInt();
                    leitor.nextLine();
                    
                    System.out.println("Informe a marca");     
                    String marca = leitor.nextLine();
                    System.out.println("Informe o modelo");
                    String modelo = leitor.nextLine();
                    System.out.println("Informe a placa");
                    String placa = leitor.nextLine();
                    System.out.println("Informe o ano");
                    int ano = leitor.nextInt();
                    System.out.println("Informe o valor da locacao");
                    double valorLocacao = leitor.nextDouble();
                    System.out.println("Informe a multa");
                    double valorMulta = leitor.nextDouble();
                    
                    if(opcao == 1){
                        
                        System.out.println("informe a quantidade de air bags");
                        int qtdAirBags = leitor.nextInt();
                        System.out.println("informe o tamanho do porta malas");
                        double tmnhPortaMalas = leitor.nextDouble();
                        System.out.println("informe se tem porta malas true/false");
                        boolean gpsIntegrado = leitor.nextBoolean();
                        CarroLuxo c1 = new CarroLuxo(marca,modelo,placa,ano,valorLocacao,valorMulta,qtdAirBags,tmnhPortaMalas,gpsIntegrado);
                        
                        Desmanche.addCarros(c1);
                    }else if(opcao == 2){
                        System.out.println("informe se tem ar condicionado true/false");
                        boolean arCondicionado = leitor.nextBoolean();
                        CarroPopular c1 = new CarroPopular(marca,modelo,placa,ano,valorLocacao,valorMulta,arCondicionado);
                        Desmanche.addCarros(c1);
                        
                    }else if(opcao == 3){
                        
                        System.out.println("Informe o tipo de tracao");
                        String tipoTracao = leitor.nextLine();
                        System.out.println("Informe o tipo de combustivel");
                        String tipoCombustivel = leitor.nextLine();
                        System.out.println("Tamanho do porta malas");
                        double tmnhPortaMalas = leitor.nextDouble();
                        CarroSuv c1 = new CarroSuv(marca,modelo,placa,ano,valorLocacao,valorMulta,tmnhPortaMalas,tipoTracao,tipoCombustivel);
                        Desmanche.addCarros(c1);
                    }
                   break;
                case 2:
                    
                    System.out.println("Digite o numero da opcao para escolher");
                    System.out.println("1-Pessoa Fisica");
                    System.out.println("2-Pessoa Juridica");
                    opcao = leitor.nextInt();
                    leitor.nextLine();
                    
                    System.out.println("Informe o nome");
                    String nome = leitor.nextLine();
                    System.out.println("Informe o telefone");
                    String telefone = leitor.nextLine();
                    System.out.println("Informe o endereco");
                    String endereco = leitor.nextLine();
                    
                    if(opcao == 1){
                        System.out.println("Informe o cpf");
                        String cpf = leitor.nextLine();
                        PessoaFisica Lula = new PessoaFisica(nome,telefone,endereco,cpf,null);
                        Desmanche.addClientes(Lula);
                    }else if(opcao == 2){
                        System.out.println("Informe o cnpj");
                        String cnpj = leitor.nextLine();
                        PessoaJuridica PabloEscobar = new PessoaJuridica(nome,telefone,endereco,cnpj,null);
                        Desmanche.addClientes(PabloEscobar);
                    }
                    
                   break;
                case 3:
                    System.out.println("Informe o numero do documento");
                    String documento = leitor.nextLine();
                    System.out.println("Informe a placa do carro que deseja alugar");
                    placa = leitor.nextLine();
                    Desmanche.realizarEmprestimo(documento, placa);  
                   break;
                case 4:
                    System.out.println("Informe o numero do documento");
                    documento = leitor.nextLine();
                    System.out.println("Informe a placa do carro que consta no emprestimo");
                    placa = leitor.nextLine();
                    Emprestimo emprestimo = Desmanche.buscarEmprestimo(placa);
                    Desmanche.finalizarEmprestimo(documento, emprestimo);
                   break;
                case 5:
                   break;
                         
                
            }
        }
        
    }
}
