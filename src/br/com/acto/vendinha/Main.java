package br.com.acto.vendinha;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.PostgreSQLConnection;
import br.com.acto.vendinha.entity.ClienteEntity;
import br.com.acto.vendinha.entity.PessoaFisicaEntity;
import br.com.acto.vendinha.entity.PessoaJuridicaEntity;
import br.com.acto.vendinha.entity.ProdutoEntity;
import br.com.acto.vendinha.model.Cliente;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;
import br.com.acto.vendinha.model.Produto;

public class Main {

    public static void main(String[] args) {

        ConnectionFactory connection = new PostgreSQLConnection(); // polimorfismo
        connection.conectarDB();

        PessoaFisicaEntity pessoaFisicaEntity = new PessoaFisicaEntity();
        PessoaFisica jao = new PessoaFisica();
        jao.setNome("Jão da Silva");
        jao.setCpf("12345678910");
        jao.setRg("456879213854");
        jao.setSexo("Masculino");
        pessoaFisicaEntity.cadastrar(jao);

        PessoaJuridicaEntity pessoaJuridicaEntity = new PessoaJuridicaEntity();
        PessoaJuridica vendinha = new PessoaJuridica();
        vendinha.setNome("Vendinha ACTO");
        vendinha.setCnpj("1234567899876541");
        vendinha.setRazaoSocial("Vendinha ACTO - LTDA");
        pessoaJuridicaEntity.cadastrar(vendinha);

        ClienteEntity clienteEntity = new ClienteEntity();
        Cliente maria = new Cliente();
        maria.setNome("Maria da Silva");
        maria.setCpf(1234567811);
        maria.setEmail("maria@gmail.com");
        maria.setTelefone("(67) 9 92299922");
        clienteEntity.cadastrar(maria);

        ProdutoEntity produtoEntity = new ProdutoEntity();
        Produto produto = new Produto();
        produto.setDescricao("Placa de Vídeo");
        produto.setMarca("NVIDIA");
        produto.setModelo("RTX 3060");
        produto.setValor(4000.00);
        produto.setVencimento(null);
        produtoEntity.cadastrar(produto);

        // System.out.println(pessoaFisicaEntity.buscarTodos());
        // System.out.println(pessoaJuridicaEntity.buscarTodos());
        System.out.println(clienteEntity.buscarTodos());
        System.out.println(produtoEntity.buscarTodos());

    }
}
