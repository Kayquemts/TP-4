package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conection.Conect;

public class ClienteDAO {

    // Adicionar Cliente
    public boolean addCliente(Cliente cli) {
        String sql = "INSERT INTO CLIENTE (nome, email, telefone) VALUES (?, ?, ?)";
        try {
            Connection con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getEmail());
            ps.setString(3, cli.getTelefone());

            int linhasAfetadas = ps.executeUpdate();
            con.close();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remover Cliente baseado no ID
    public boolean removerCliente(int idCliente) {
        String sql = "DELETE FROM CLIENTE WHERE ID_Cliente = ?";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar Cliente baseado no ID
    public boolean atualizarCliente(Cliente cli) {
        String sql = "UPDATE CLIENTE SET nome = ?, email = ?, telefone = ? WHERE ID_Cliente = ?";
        try (Connection con = Conect.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getEmail());
            ps.setString(3, cli.getTelefone());
            ps.setInt(4, cli.getId());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Pesquisar Cliente baseado no ID
    public Cliente pesquisarCliente(int idCliente) {
        String sql = "SELECT * FROM CLIENTE WHERE ID_Cliente = ?";
        try {
            Connection con = Conect.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("ID_Cliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    con.close();
                    return cliente;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
