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
        Locadora Desmanche = new Locadora("Desmanche", "If Goiano", "984433892");
        Scanner leitor = new Scanner(System.in);
        boolean executando = true;
        while(executando){
            System.out.println("1-cadastrar um novo veiculo");
            System.out.println("2-cadastrar clientes");
            System.out.println("3-realizar um emprestimo");
            System.out.println("4-finalizar um emprestimo");
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
                    
                    if(opcao!=1 && opcao!=2 && opcao!=3){
                        System.out.println("Digite numeros validos");
                        break;
                    }
                    
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
                    leitor.nextLine(); 
                    
                    switch (opcao) {
                        case 1:
                            System.out.println("informe a quantidade de air bags");
                            int qtdAirBags = leitor.nextInt();
                            System.out.println("informe o tamanho do porta malas");
                            double tmnhPortaMalas = leitor.nextDouble();
                            System.out.println("informe se tem gps integrado true/false");
                            boolean gpsIntegrado = leitor.nextBoolean();
                            leitor.nextLine();
                            CarroLuxo c1 = new CarroLuxo(marca,modelo,placa,ano,valorLocacao,valorMulta,qtdAirBags,tmnhPortaMalas,gpsIntegrado);
                            Desmanche.addCarros(c1);
                            break;
                        case 2:
                            System.out.println("informe se tem ar condicionado true/false");
                            boolean arCondicionado = leitor.nextBoolean();
                            leitor.nextLine();
                            CarroPopular c2 = new CarroPopular(marca,modelo,placa,ano,valorLocacao,valorMulta,arCondicionado);
                            Desmanche.addCarros(c2);
                            break;
                        case 3:
                            System.out.println("Informe o tipo de tracao");
                            String tipoTracao = leitor.nextLine();
                            System.out.println("Informe o tipo de combustivel");
                            String tipoCombustivel = leitor.nextLine();
                            System.out.println("Tamanho do porta malas");
                            String tmnhPortaMala = leitor.nextLine();
                            leitor.nextLine();
                            CarroSuv c3 = new CarroSuv(marca,modelo,placa,ano,valorLocacao,valorMulta,tmnhPortaMala,tipoTracao,tipoCombustivel);
                            Desmanche.addCarros(c3);
                            break;
                        default:
                            System.out.println("Opcao invalida");
                            break;
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
                        PessoaFisica pf = new PessoaFisica(nome,telefone,endereco,cpf,null);
                        Desmanche.addClientes(pf);
                    }else if(opcao == 2){
                        System.out.println("Informe o cnpj");
                        String cnpj = leitor.nextLine();
                        System.out.println("Informe o nome do representante");
                        String nomeRepresentante = leitor.nextLine();
                        PessoaJuridica pj = new PessoaJuridica(nome,telefone,endereco,nomeRepresentante,cnpj);
                        Desmanche.addClientes(pj);
                    } else {
                        System.out.println("Opcao invalida");
                    }
                    break;

                case 3:
                    System.out.println("Informe o numero do documento");
                    String documento = leitor.nextLine();
                    System.out.println("Informe a placa do carro que deseja alugar");
                    String placaEmprestimo = leitor.nextLine();
                    boolean realizado = Desmanche.realizarEmprestimo(documento, placaEmprestimo); 
                    if(realizado){
                        System.out.println("Emprestimo realizado com sucesso");
                    }else{
                        System.out.println("Nao foi possivel realizar o emprestimo");
                    }
                    break;

                case 4:
                    System.out.println("Informe o numero do documento");
                    String documentoFinal = leitor.nextLine();
                    System.out.println("Informe a placa do carro que consta no emprestimo");
                    String placaFinal = leitor.nextLine();
                    Emprestimo emprestimo = Desmanche.buscarEmprestimo(placaFinal);
                    if(emprestimo != null) {
                        double valor = Desmanche.finalizarEmprestimo(documentoFinal, emprestimo);
                        if(valor == -1){
                            System.out.println("Nao foi possivel finalizar o emprestimo");
                        }else{
                            System.out.println("Emprestimo finalizado o valor e "+valor);
                        }              
                    } 
                    
                    else {
                        System.out.println("Emprestimo nao encontrado para essa placa");
                    }
                    break;

                case 5:
                    System.out.println("Saindo");
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }


}
