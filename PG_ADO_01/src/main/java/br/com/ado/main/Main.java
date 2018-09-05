/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ado.main;

import br.com.ado.db.dao.DaoProduto;
import java.util.Scanner;
import br.com.ado.servico.Servico;
import br.com.ado.model.produto.Produto;

/**
 *
 * @author victo
 * @author raffael.wmoraes
 * @author rafaeldini
 */
public class Main {

    public static void main(String[] args) {
        Produto produto = new Produto();
        
        int menu = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("************************");
            System.out.println("0) Encerrar programa");
            System.out.println("1) Inserir");
            System.out.println("2) Alterar");
            System.out.println("3) Consultar");
            System.out.println("4) Excluir");
            System.out.println("************************");
            System.out.print("Escolha um numero: ");
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    System.out.print("Digite o nome do Produto: ");
                    String nome = sc.nextLine();
                    produto.setNome(nome);

                    System.out.print("Digite a descrição do Produto: ");
                    String descricao = sc.nextLine();
                    produto.setDescricao(descricao);

                    System.out.print("Digite o preço de compra: ");
                    String precoCompra = sc.nextLine();
                    produto.setPreco_compra(Float.parseFloat(precoCompra));

                    System.out.print("Digite o preço de venda: ");
                    String precoVenda = sc.nextLine();
                    produto.setPreco_venda(Float.parseFloat(precoVenda));

                    System.out.print("Digite a quantidade do produto: ");
                    String quantidade = sc.nextLine();
                    produto.setQuantidade(Integer.parseInt(quantidade));

                    /* System.out.print("Selecione a categoria do Produto(" + produto.getNome() + ") :");
                    * pegar Categorias do Banco de Dados
                    */
                    if (Servico.cadastrarProduto(produto) == null) {
                        System.out.println(produto.getNome() + " inserido com sucesso!\n");
                    }

                    break;
                case 3:
                    System.out.print("Digite o nome do produto: ");
                    nome = sc.nextLine();
                    Produto p = Servico.obterProduto(nome);
                    System.out.println("Nome: "+p.getNome()+ "\nDescricao: "+ p.getDescricao()+"\n"+"Categoria: "+ p.getCategoria()+"\n"+ 
                            "Preco de Compra: "+p.getPreco_compra()+"\n"+"Preco de Venda: "+ p.getPreco_venda()+"\n"+"Quantidade: "+p.getQuantidade());
                    
                    break;
                case 4:
                    System.out.print("Digite o nome do produto: ");
                    nome = sc.nextLine();
                    Servico.excluirProduto(nome);
                    if(Servico.obterProduto(nome)== null){
                        System.out.println("Produto removido com sucesso!");
                    }
                    
                    break;
            
            }

        } while (menu != 0);
    }

}
