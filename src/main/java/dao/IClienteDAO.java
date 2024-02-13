package main.java.dao;

import main.java.domain.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws SQLException;

    public Cliente consultar(Cliente cliente) throws SQLException;

    public Integer excluir(Cliente cliente) throws   SQLException;

    public Integer atualizar(Cliente cliente) throws SQLException;

    public List<Cliente> buscarTodos() throws  SQLException;
}
