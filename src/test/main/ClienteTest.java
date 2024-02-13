package test.main;

import org.junit.Test;

import main.java.domain.Cliente;
import main.java.dao.ClienteDAO;
import main.java.dao.IClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bruno.silva
 * Gera os testes para o cadastro de clientes
 */
public class ClienteTest {

    /* Roda o primeiro teste de cadastro */
    @Test
    public void cadastraCliente() throws SQLException {
        IClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCpf(112393884l);
        cliente.setEmail("brunojs@gmail.com");
        cliente.setNome("Bruno Jose Silva");
        cliente.setTelefone("777477272");

        Integer qtdCadastrado = clienteDAO.cadastrar(cliente);
        assertTrue(qtdCadastrado == 1);

        Cliente clienteConsulta = clienteDAO.consultar(cliente);
        assertNotNull(clienteConsulta);
        assertEquals(cliente.getCpf(), clienteConsulta.getCpf());

        Integer qtdExcluido = clienteDAO.excluir(cliente);
        assertNotNull(qtdExcluido);
    }

    @Test
    public void atualizarCliente() throws  SQLException {
        IClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCpf(112393884l);
        cliente.setEmail("brunojs@gmail.com");
        cliente.setNome("Bruno Jose Silva");
        cliente.setTelefone("777477272");

        Integer qtdCadastrado = clienteDAO.cadastrar(cliente);
        assertTrue(qtdCadastrado == 1);

        cliente.setTelefone("099876366");

        Integer qtdAtualizado = clienteDAO.atualizar(cliente);
        assertTrue(qtdAtualizado == 1);

        Cliente clienteConsulta = clienteDAO.consultar(cliente);
        assertNotNull(clienteConsulta);
        assertNotEquals(cliente.getTelefone(), clienteConsulta.getTelefone());

        System.out.println("O valor atualizado ficou: " + clienteConsulta.getTelefone());

        Integer qtdExcluido = clienteDAO.excluir(cliente);
        assertNotNull(qtdExcluido);
    }

    @Test
    public void consultaTodos() throws  SQLException {
        IClienteDAO clienteDAO = new ClienteDAO();

        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes =clienteDAO.buscarTodos();
        assertNotNull(listaClientes);

        for (Cliente cli: listaClientes) {
            System.out.println("Cliente retornado ID " + cli.getId() +  " nome " + cli.getNome() +
                    " CPF " + cli.getCpf());
        }
    }
}
