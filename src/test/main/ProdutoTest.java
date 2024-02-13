package test.main;

import main.java.dao.IProdutoDAO;
import main.java.dao.ProdutoDAO;
import main.java.domain.Produto;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoTest {

    @Test
    public void cadastraProduto() throws SQLException {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Produto 01");
        produto.setDescricao("Teste ddsds");
        produto.setPreco(123.44);

        Integer qtdCadastrado = produtoDAO.cadastrar(produto);
        assertTrue(qtdCadastrado == 1);
    }

    @Test
    public void atualizaProduto() throws SQLException {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setId(4);
        produto.setPreco(120.88);
        produto.setNome("Produto alterado");
        produto.setDescricao("Mudando ");

        Integer qtdAtualizado = produtoDAO.atualizar(produto);
        assertTrue(qtdAtualizado == 1);
    }

    @Test
    public void consultaProduto() throws SQLException {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setId(4);

        Produto produtoConsultado = produtoDAO.consultar(produto);
        assertNotNull(produtoConsultado);

        System.out.println("O produto consultado foi " + produtoConsultado.getNome());
    }

    @Test
    public  void consultaTodos() throws SQLException {
        IProdutoDAO produtoDAO = new ProdutoDAO();

        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos = produtoDAO.buscarTodos();

        for(Produto pro: listaProdutos) {
            System.out.println("O produto retornado foi ID " + pro.getId() + " nome " + pro.getNome());
        }
    }
}
