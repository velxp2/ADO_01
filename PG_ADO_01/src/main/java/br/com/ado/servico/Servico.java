/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ado.servico;

import br.com.ado.db.dao.DaoProduto;
import br.com.ado.model.produto.Produto;
import java.util.List;

/**
 *
 * @author victo
 * @author rafaeldini
 */
public class Servico {
    
    public static String cadastrarProduto(Produto produto) {

        String resposta = null;

        //resposta = ValidadorProduto.validar(produto);

        if (resposta == null) {

            try {

                DaoProduto.inserir(produto);

            } catch (Exception e) {

                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }

        }

        return resposta;
    }

    public static String atualizarProduto(Produto produto, int id) {

        String resposta = null;

        resposta = null;

        if (resposta == null) {

            try {

                DaoProduto.atualizar(produto, id);

            } catch (Exception e) {

                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }

        return resposta;

    }

    public static String excluirProduto(String nome) {

        String resposta = null;

        try {

            DaoProduto.excluir(nome);

        } catch (Exception e) {

            e.printStackTrace();
            resposta = "Erro na fonte de dados";

        }

        return resposta;
    }

    public static List<Produto> procurarProduto(String nome) {

        List<Produto> listaResposta = null;

        try {

            if (nome == null || "".equals(nome)) {
                 listaResposta = DaoProduto.procurar(nome);
            }
        } catch (Exception e) {

            e.printStackTrace();

        }

        return listaResposta;
    }

    public static Produto obterProduto(String nome) {

        Produto produtoResposta = null;
        try {

            produtoResposta = DaoProduto.obter(nome);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return produtoResposta;

    }
}
