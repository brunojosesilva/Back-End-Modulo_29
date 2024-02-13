package main.java.dao;

import main.java.domain.Cliente;
import main.java.dao.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Integer cadastrar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "INSERT INTO CLIENTE (CPF, NOME, EMAIL, TELEFONE) VALUES (?, ?, ?, ?)";
            stm = connection.prepareStatement(sql);

            stm.setLong(1, cliente.getCpf());
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getTelefone());
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Cliente consultar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente clienteRetorno = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM CLIENTE WHERE CPF = ?";
            stm = connection.prepareStatement(sql);

            stm.setLong(1, cliente.getCpf());
            rs = stm.executeQuery();

            if(rs.next()) {
                clienteRetorno = new Cliente();
                clienteRetorno.setCpf(rs.getLong("CPF"));
                clienteRetorno.setId(rs.getInt("CLIENTE_ID"));
                clienteRetorno.setNome(rs.getString("NOME"));
                clienteRetorno.setEmail(rs.getString("EMAIL"));
                clienteRetorno.setTelefone(rs.getString("TELEFONE"));
            }
            return clienteRetorno;

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "DELETE FROM CLIENTE WHERE CPF = ?";
            stm = connection.prepareStatement(sql);

            stm.setLong(1, cliente.getCpf());
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "UPDATE CLIENTE SET  NOME = ? , EMAIL = ? , TELEFONE = ? WHERE CPF = ?";
            stm = connection.prepareStatement(sql);

            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getEmail());
            stm.setString(3, cliente.getTelefone());
            stm.setLong(4, cliente.getCpf());
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente clienteRetorno = null;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM CLIENTE";
            stm = connection.prepareStatement(sql);

            rs = stm.executeQuery();

            while (rs.next()) {
                clienteRetorno = new Cliente();
                clienteRetorno.setCpf(rs.getLong("CPF"));
                clienteRetorno.setId(rs.getInt("CLIENTE_ID"));
                clienteRetorno.setNome(rs.getString("NOME"));
                clienteRetorno.setEmail(rs.getString("EMAIL"));
                clienteRetorno.setTelefone(rs.getString("TELEFONE"));
                listaClientes.add(clienteRetorno);
            }
            return listaClientes;

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();;
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
